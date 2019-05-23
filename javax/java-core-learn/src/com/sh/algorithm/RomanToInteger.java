package com.sh.algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ACER
 * @description
 * @date 2019/4/3 19:58
 */
public class RomanToInteger {
    public static int romanToInt(String s) {
        final Map<Character, Integer> convertMap = new HashMap<Character, Integer>(){
            {
                put('I', 1);
                put('V', 5);
                put('X', 10);
                put('L', 50);
                put('C', 100);
                put('D', 500);
                put('M', 1000);
            }};
        int res = 0;
        int i = 0;
        int len = s.length();
        while(i < len){
            char c = s.charAt(i);
            if((c == 'I' || c == 'X' || c == 'C') && i+ 1 < len
                    && convertMap.get(c) < convertMap.get(s.charAt(i+1))){
                res += convertMap.get(s.charAt(i+1)) - convertMap.get(c);
                i += 2;
            }else{
                res += convertMap.get(c);
                i++;
            }
        }
        return res;
    }

    public static int romanToInt2(String s) {
        final Map<Character, Integer> convertMap = new HashMap<Character, Integer>(){
            {
                put('I', 1);
                put('V', 5);
                put('X', 10);
                put('L', 50);
                put('C', 100);
                put('D', 500);
                put('M', 1000);
            }};
        int res = 0;
        int i = 0;
        int len = s.length();
        int last = 0;
        int v;
        while(i < len){
            v = convertMap.get(s.charAt(i));
            if( last > 0 && v > last){
                last = v - last * 2;
            }else{
                last = v;
            }
            res += last;
            i++;
        }
        return res;
    }

    public static int romanToInt3(String s) {
        final int[] arr = new int[26];
        arr[8] = 1;
        arr[21] = 5;
        arr[23] = 10;
        arr[11] = 50;
        arr[2] = 100;
        arr[3] = 500;
        arr[12] = 1000;
        int res = 0;
        int i = 0;
        int len = s.length();
        int last = 0;
        int v;
        while(i < len){
            v = arr[s.charAt(i) - 'A'];
            if( last > 0 && v > last){
                last = v - last * 2;
            }else{
                last = v;
            }
            res += last;
            i++;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(romanToInt3("III"));
    }
}
