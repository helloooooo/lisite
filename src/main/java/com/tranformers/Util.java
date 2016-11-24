package com.tranformers;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

/**
 * Created by wuteng1 on 2016/9/3.
 */
public class Util {
    public static Object getObjectByClassName(String className) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        ClassLoader cl = Thread.currentThread().getContextClassLoader();
        Class<?> c = cl.loadClass(className);
        Object o = c.newInstance();
        return o;
    }

    public static Object invokeMethod(Class<?> clazz, Object obj, String methodName, Class<?>[] paramTypes, Object[] params){
        Method m = null;
        try {
            m = clazz.getDeclaredMethod(methodName, paramTypes);
        } catch (NoSuchMethodException e) {

        }
        if(m == null){
            if(clazz.equals(Object.class)){
                return new RuntimeException("Method " + methodName + " not found in any super class");
            }
            return invokeMethod(clazz.getSuperclass(), obj, methodName, paramTypes, params);
        }
        try {
            return m.invoke(obj, params);
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Object  getFieldValue(Class<?> clazz, Object obj, String fieldName){
        Object fieldValue = null;
        Field f;
        try {
            f = clazz.getDeclaredField(fieldName);
            f.setAccessible(true);
            fieldValue = f.get(obj);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return fieldValue;
    }

    public static void setFieldValue(Class<?> clazz, Object obj, String fieldName, Object fieldValue){
        Field f = null;
        try {
            f.setAccessible(true);
            f.set(obj, fieldValue);
            f = clazz.getDeclaredField(fieldName);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public static Double objectToDouble(Object o){
        if(o != null){
            if(o instanceof  Double){
                return (Double) o;
            }
            else if(o instanceof Number){
                return ((Number)o).doubleValue();
            }
            else if(o instanceof String){
                try {
                    return Double.valueOf((String) o);
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    public static Long objectToLong(Object o){
        if(o != null){
            if(o instanceof Long){
                return (Long) o;
            }
            else if(o instanceof Number){
                return ((Number) o).longValue();
            }
            else if(o instanceof String){
                try {
                    return Long.valueOf((String) o);
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    public static String objectToString(Object o){
        if(o != null){
            return o.toString();
        }
        return null;
    }

    public static String getClassResource(Class<?> klass){
        return klass.getClassLoader().getResource(klass.getName().replace('.', '/') + ".class").toString();
    }


    public static <K, V extends Comparable<? super V>> Map<K, V> sortMapByValue(final Map<K, V> map, final boolean descending){
        List<Map.Entry<K, V>> list = new LinkedList<Map.Entry<K, V>>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<K, V>>(){
            public int compare(Map.Entry<K, V> o1, Map.Entry<K, V> o2) {
                if(descending){
                    return (o2.getValue()).compareTo(o1.getValue());
                }
                else{
                    return o1.getValue().compareTo(o2.getValue());
                }
            }
        });
        Map<K, V> result = new LinkedHashMap<K, V>();
        for(Map.Entry<K, V> entry: list){
            result.put(entry.getKey(), entry.getValue());
        }
        return result;
    }


}
