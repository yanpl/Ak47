package com.wangyin.ak47.common;

import java.util.Arrays;
import java.util.List;

/**
 * Collection-related helper class
 * 
 * 提供集合、数组的相关操作
 * 
 * @author hubingyin
 * 
 */
public class CollectionUtil {

    /**
     * Add obj to list if obj is NOT exsit in list, otherwise dont do any thing.
     * 
     * @param list
     *            a list
     * @param obj
     *            the object may to be added
     */
    public static <T> void addIfNotExist(List<T> list, T obj) {
        boolean isexist = false;
        for (T t : list) {
            if (t.equals(obj)) {
                isexist = true;
                break;
            }
        }
        if (!isexist) {
            list.add(obj);
        }
    }

    /**
     * Shift left the given string array with 1 step, discard the original
     * leftmost ones.
     * 
     * See: like Linux shell shift
     * 
     * 将字符串数组左移一位，丢弃原最左边的对象
     * 
     * @param array
     *            string array
     * @return string array to be shifted
     */
    public static String[] shift(String[] array) {
        return shift(array, 1);
    }

    /**
     * Shift left the given string array with N step, discard the original
     * leftmost ones.
     * 
     * 将字符串数组左移n位，原最左边的对象丢弃
     * 
     * @param array
     *            string array
     * @param n
     *            number of shifted
     * @return string array to be shifted
     */
    public static String[] shift(String[] array, int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("n must a non-negative number.");
        }

        if (n >= array.length) {
            return new String[0];
        }

        String[] dest = new String[array.length - n];
        System.arraycopy(array, n, dest, 0, array.length - n);
        return dest;
    }

    /**
     * Merge an array of string to a big string.
     * 
     * 将 array 合并成 string
     * 
     * @param array
     *            object array
     * @return a joined string
     */
    @SafeVarargs
    public static <T> String array2String(T... array) {
        int len = array.length;
        if (len == 0) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("[").append(array[0]);
        for (int i = 1; i < array.length; i++) {
            sb.append(",").append(array[i]);
        }
        sb.append("]");

        return sb.toString();
    }

    /**
     * Merge a list of string to a big string.
     * 
     * 将list转成string
     * 
     * @param list
     *            list of object
     * @return a joined string
     */
    public static String list2String(List<?> list) {
        return array2String(list2Array(list));
    }

    /**
     * Convert array to List
     * 
     * Example: {@code List<String> stooges = ArrayUtil.array2List("Larry", "Moe",
     * "Curly");}
     * 
     * @param array
     *            array of objects
     * @return list of objects
     */
    @SafeVarargs
    public static <T> List<T> array2List(T... array) {
        return Arrays.asList(array);
    }

    /**
     * Convert List to array
     * 
     * Example: String[] myarray = (String[]) ArrayUtil.list2Array(mylist);
     * 
     * 
     * @param list
     *            list of objects
     * @return array of objects
     */
    public static <T> Object[] list2Array(List<T> list) {
        return list.toArray();
    }

    /**
     * Convert list of string to a joined string.
     * 
     * @param list
     *            list of strings
     * @param separator
     *            separator between strings
     * @return a joined string
     */
    public static String join(List<String> list, String separator) {

        if (list == null || list.size() == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(list.get(0));
        int size = list.size();
        for (int i = 1; i < size; i++) {
            sb.append(separator).append(list.get(i));
        }
        return sb.toString();
    }

    
    /**
     * 得到数组成员的class类型数组
     * 
     * @param objects array of Object
     * @return array of Object's Class Type
     */
    @SafeVarargs
    public static <T> Class<?>[] objects2Classes(T... objects) { 
        Class<?>[] clazzs = new Class<?>[objects.length];
        for(int i=0; i<objects.length; i++){
            clazzs[i] = objects[i].getClass();
        }
        return clazzs;
    }
    
    /**
     * 得到数组成员的class类型数组
     * 
     * @param objects list of Object
     * @return array of Object's Class Type
     */
    public static <T> Class<?>[] objects2Classes(List<Object> objects) { 
        int size = objects.size();
        Class<?>[] clazzs = new Class<?>[size];
        for(int i=0; i<size; i++){
            clazzs[i] = objects.get(i).getClass();
        }
        return clazzs;
    }
    
    
    
}
