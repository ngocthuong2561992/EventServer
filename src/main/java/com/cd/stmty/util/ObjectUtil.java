package com.cd.stmty.util;

public class ObjectUtil {

    /**
     * check equal two object
     *
     * @param object1 the text1 compare
     * @param object2 the text2 compare
     * @return the result of compare
     */
    public static <T extends Object> Boolean isEqual(T object1, T object2) {
        return (object1 == null && object2 == null) || (object1 != null && object1.equals(object2));
    }

    /**
     * check not equal two object
     *
     * @param object1 the text1 compare
     * @param object2 the text2 compare
     * @return the result of compare
     */
    public static <T extends Object> Boolean isNotEqual(T object1, T object2) {
        return !isEqual(object1, object2);
    }

    /**
     * check empty object
     *
     * @param object the object compare
     * @return object
     */
    public static <T extends Object> Boolean isEmpty(T object) {
        return (object == null);
    }

    /**
     * check not empty object
     *
     * @param object the object compare
     * @return object
     */
    public static <T extends Object> Boolean isNotEmpty(T object) {
        return !isEmpty(object);
    }
}
