package com.sh.algorithm;

/**
 * @author ACER
 * @description
 * @date 2019/4/9 20:40
 */
public class LongestCommonPrefix {

    public static void main(String[] args) {
        String[] strs = new String[]{"dog","racecar","car"};
        System.out.println(longestCommonPrefix(strs));
    }

    public static String longestCommonPrefix(String[] strs) {
        int len = strs.length;
        if(len == 0){
            return "";
        }else if(len == 1){
            return strs[0];
        }
        int current = strs[0].length();
        for(int i = 1; i < len; i++){
            int j = 0;
            int minlen = Math.min(current, strs[i].length());
            while(j < minlen && strs[0].charAt(j) == strs[i].charAt(j)){
                j++;
            }
            if(j == 0){
                return "";
            }else{
                current = j - 1;
            }
        }
        return strs[0].substring(0, current + 1);
    }
}
