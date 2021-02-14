package reflection.service;

import reflection.annotation.Invoke;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionService {

    public void setAnnotationValueByName(Object object, String name) throws NoSuchMethodException, NoSuchFieldException, IllegalAccessException {
            Class clazz = object.getClass();
            Method methodWithAnn = clazz.getDeclaredMethod(name);
            Invoke myInvoke = methodWithAnn.getAnnotation(Invoke.class);
//            Method method = myInvoke.getClass().getMethod("flag");
            myInvoke.getClass().getField("flag").set(object, false);

    }

    public int getCalculatedValue(Object object) throws InvocationTargetException, IllegalAccessException, NoSuchFieldException {
        Class clazz = object.getClass();
        Method[] methods = clazz.getDeclaredMethods();

        for (Method method : methods) {
            if (method.getAnnotation(Invoke.class).flag()) {
                method.invoke(object);
            }
        }
        return (int) clazz.getDeclaredField("sum").get(object);
    }
}
