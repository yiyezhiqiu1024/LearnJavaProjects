package com.sl.util;

public class Strings {
    public static String underlineCase(String str) {
        if (str == null) return null;
        int length = str.length();
        if (length == 0) return str;

        StringBuilder sb = new StringBuilder();
        // 讲字符串第一个字符转换成小写
        sb.append(Character.toLowerCase(str.charAt(0)));
        // 遍历每一个字符
        for (int i = 1; i < length; i++) {
            char c = str.charAt(i);

            if (Character.isUpperCase(c)) { // 大写
                sb.append("_");
                sb.append(Character.toLowerCase(c));
            } else { // 小写
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
