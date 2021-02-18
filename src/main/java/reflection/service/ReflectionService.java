package reflection.service;

import reflection.annotation.Invoke;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Map;

public class ReflectionService {

    public void setAnnotationValueByName(Object object, String name) throws NoSuchMethodException, NoSuchFieldException, IllegalAccessException {
        Class clazz = object.getClass();
        Method methodWithAnn = clazz.getDeclaredMethod(name);
        Invoke myInvoke = methodWithAnn.getAnnotation(Invoke.class);
        setValueForPrivateField(myInvoke, "flag", false);
    }

    @SuppressWarnings("unchecked")
    public static Object setValueForPrivateField(Annotation annotation, String key, Object newValue) throws NoSuchFieldException, IllegalAccessException {
        Object handler = Proxy.getInvocationHandler(annotation);
        Field f;
        f = handler.getClass().getDeclaredField("memberValues");

        f.setAccessible(true);
        Map<String, Object> memberValues;
        memberValues = (Map<String, Object>) f.get(handler);

        Object oldValue = memberValues.get(key);
        if (oldValue == null || oldValue.getClass() != newValue.getClass()) {
            throw new IllegalArgumentException();
        }

        memberValues.put(key, newValue);
        return oldValue;
    }


    public int getCalculatedValue(Object object) throws InvocationTargetException, IllegalAccessException, NoSuchFieldException {
        Class clazz = object.getClass();
        Method[] methods = clazz.getDeclaredMethods();

        for (Method method : methods) {
            if (method.isAnnotationPresent(Invoke.class) && method.getAnnotation(Invoke.class).flag()) {
                method.invoke(object);
            }
        }

        Field field = clazz.getDeclaredField("sum");

        boolean flag = field.isAccessible();
        field.setAccessible(true);

        Object declaredField = field.get(object);
        field.setAccessible(flag);

        return (int) declaredField;
    }
}
