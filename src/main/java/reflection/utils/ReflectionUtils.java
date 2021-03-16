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

import static org.junit.Assert.assertEquals;

public class ReflectionUtils {
    private static Map<String, Boolean> methodMap = new LinkedHashMap<>();

    private ReflectionUtils() {
    }

    public static void setAnnotationValueByName(final Object object, final String nameMethod, final String fieldAnnName,
                                                final boolean valueAnn, final Class<? extends Annotation> annotation) {

        Annotation invokeAnnotation = getDeclaredMethod(object, nameMethod).getAnnotation(annotation);

        setValueForPrivateField(invokeAnnotation, fieldAnnName, valueAnn);
    }

    public static int getCalculatedValue(final Object object, final String nameFieldWithAnn,
                                         final Class<? extends Annotation> annotation) {

        Stream.of(getDeclaredMethods(object))
                .filter(method -> method.isAnnotationPresent(annotation))
                .filter(method -> method.getAnnotation(Invoke.class).state())
                .forEach(method -> invokeMethod(object, method));

        return (int) getValueFromPrivateField(object, nameFieldWithAnn);
    }

    public static void saveAnnotation(Object object, Class<? extends Annotation> annotation) {

        Stream.of(getDeclaredMethods(object))
                .filter(method -> method.isAnnotationPresent(annotation))
                .forEach(method -> methodMap.put(method.getName(), method.getAnnotation(Invoke.class).state()));
    }

    public static void returnDefaultAnnotation(final Object object, final String fieldAnnName,
                                               final Class<? extends Annotation> annotation, boolean annotationValue) {
        Stream.of(getDeclaredMethods(object))
                .filter(method -> method.isAnnotationPresent(annotation))
                .filter(method -> method.getAnnotation(Invoke.class).state() != methodMap.get(method.getName()))
                .forEach(method -> setValueForPrivateField(method.getAnnotation(annotation), fieldAnnName, annotationValue));
    }

    @SuppressWarnings("unchecked")
    public static Object setValueForPrivateField(final Annotation annotation, final String key, final Object newValue) {
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

    private static Method[] getDeclaredMethods(final Object object) {
        return object.getClass().getDeclaredMethods();
    }

    public static Method getDeclaredMethod(final Object object, final String name) {
        Method method = null;
        try {
            method = object.getClass().getDeclaredMethod(name);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return method;
    }

    private static Object getAnnotationValue(final String name, final Class<? extends Annotation> annotation) {
        Object value = null;
        try {
            value = annotation.getDeclaredMethod(name).getDefaultValue();
        } catch (ReflectiveOperationException e) {
            e.printStackTrace();
        }
        return value;
    }

    public static void setIntPrivateField(final Object object, final String nameField, final int fieldValue) {

        try {
            Field field = object.getClass().getDeclaredField(nameField);
            boolean flag = field.isAccessible();

            field.setAccessible(true);
            field.set(object, fieldValue);
            field.setAccessible(flag);
        } catch (ReflectiveOperationException e) {
            e.printStackTrace();
        }
    }

    public static Object getValueFromPrivateField(final Object object, final String nameFieldWithAnn) {

        Object declaredField = 0;

        try {
            Field field = object.getClass().getDeclaredField(nameFieldWithAnn);

            boolean flag = field.isAccessible();
            field.setAccessible(true);

            declaredField = field.get(object);

            field.setAccessible(flag);
        } catch (ReflectiveOperationException e) {
            e.printStackTrace();
        }
        return declaredField;
    }

    public static Object invokeMethod(final Object object, final Method method) {
        Object value = null;
        try {
            value = method.invoke(object);
        } catch (ReflectiveOperationException e) {
            e.printStackTrace();
        }
        return value;
    }

    public static Class getClazz(String className) {
        Class clazz = null;
        try {
            clazz = Class.forName(className);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return clazz;
    }

    public static Object getNewInstance(Class clazz) {
        Object object = null;

        try {
            object = clazz.getConstructor().newInstance();
        } catch (ReflectiveOperationException e) {
            e.printStackTrace();
        }

        return object;
    }
}
