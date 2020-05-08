package ch.supsi.guiframework.utils;


public class StringUtils {

    public static String capitalizeFirstLetter(String s) {
        if (s == null) {
            return "NULL_STRING_GIVEN";
        }

        if (s.isEmpty()) {
            return "EMPTY_STRING_GIVEN";
        }

        return Character.toUpperCase(s.charAt(0)) + s.substring(1);
    }

    public static String decapitalizeFirstLetter(String s) {
        if (s == null) {
            return "NULL_STRING_GIVEN";
        }

        if (s.isEmpty()) {
            return "EMPTY_STRING_GIVEN";
        }

        return Character.toLowerCase(s.charAt(0)) + s.substring(1);
    }

}
