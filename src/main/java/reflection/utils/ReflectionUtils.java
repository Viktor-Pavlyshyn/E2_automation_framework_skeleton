package reflection.utils;

import reflection.annotation.Invoke;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Stream;

public class ReflectionUtils {
    private static Map<String, Boolean> methodMap = new LinkedHashMap<>();

    private ReflectionUtils() {
    }

    public static void setAnnotationValueByName(Object object, String name, String fieldAnnName,
                                                boolean valueAnn, Class<? extends Annotation> annotation) {
        try {
            Class clazz = object.getClass();
            Method methodWithAnn = clazz.getDeclaredMethod(name);
            Annotation myInvoke = methodWithAnn.getAnnotation(annotation);
            setValueForPrivateField(myInvoke, fieldAnnName, valueAnn);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

    }

    @SuppressWarnings("unchecked")
    public static Object setValueForPrivateField(Annotation annotation, String key, Object newValue) {
//        TODO:
//        - Why you go using Proxy?
//        - The same. Combine in one line variable initialization and declaration
//        I did not understand your manipulation with Map

        Object handler = Proxy.getInvocationHandler(annotation);

        Map<String, Object> memberValues = null;

        try {
            Field f = handler.getClass().getDeclaredField("memberValues");
            f.setAccessible(true);

            memberValues = (Map<String, Object>) f.get(handler);
        } catch (IllegalAccessException | NoSuchFieldException e) {
            e.printStackTrace();
        }

        Object oldValue = memberValues.get(key);

        if (Objects.isNull(oldValue) || oldValue.getClass() != newValue.getClass()) {
            throw new IllegalArgumentException();
        }

        memberValues.put(key, newValue);
        return oldValue;
    }

    public static int getCalculatedValue(Object object) {
        Class clazz = object.getClass();

        Stream.of(getDeclaredMethods(object)).forEach(method -> {
            if (method.isAnnotationPresent(Invoke.class) && method.getAnnotation(Invoke.class).state()) {
                try {
                    method.invoke(object);
                } catch (IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        });
//        for (Method method : methods) {
//            if (method.isAnnotationPresent(Invoke.class) && method.getAnnotation(Invoke.class).flag()) {
//                method.invoke(object);
//            }
//        }

        Object declaredField = null;

        try {
            Field field = clazz.getDeclaredField("sum");

            boolean flag = field.isAccessible();
            field.setAccessible(true);

            declaredField = field.get(object);

            field.setAccessible(flag);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

        return (int) declaredField;
    }

    public static void saveAnnotation(Object object) {
        Stream.of(getDeclaredMethods(object)).forEach(method -> {
            if (method.isAnnotationPresent(Invoke.class)) {
                boolean value = method.getAnnotation(Invoke.class).state();
                methodMap.put(method.getName(), value);
            }
        });
    }

    public static void returnDefaultAnnotation(Object object) {
        Stream.of(getDeclaredMethods(object)).forEach(method -> {
            if (method.isAnnotationPresent(Invoke.class)) {
                boolean value = method.getAnnotation(Invoke.class).state();
                boolean storedValue = methodMap.get(method.getName());
                if (storedValue != value) {
                    setValueForPrivateField(method.getAnnotation(Invoke.class), "state", true);
                }
            }
        });
    }

    public static Method[] getDeclaredMethods(Object object){
        return object.getClass().getDeclaredMethods();
    }
}
