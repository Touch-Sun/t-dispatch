package io.github.touchsun.tdispatch.core.util;

/**
 * 数字工具
 *
 * @author lee
 * @since 2023/6/6 8:38
 */
public class NumberUtil {

    /**
     * 是否是数字形式一个字符串
     * 
     * @param str 字符串
     * @return 判断结果
     */
    public static boolean isNumeric(String str){
        try {
            int result = Integer.parseInt(str);
            return true; 
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * 是否是数字形式一个字符串
     *
     * @param strArray 字符串数组
     * @return 判断结果
     */
    public static boolean isNumeric(String[] strArray){
        for (String s : strArray) {
            if (!isNumeric(s)) {
                return false;
            }
        }
        return true;
    }
}
