package com.sh.algorithm;

import java.util.Arrays;

/**
 * @author ACER
 * @description
 * @date 2019/4/1 20:04
 */
public class ReverseInteger {
    public static void main(String[] args) {
//        System.out.println(reverse(Integer.MIN_VALUE));
        System.out.println(isPalindrome(10));
        System.out.println(isPalindrome2(121));
    }

    public static int reverse(int x) {
        int res = 0;
        while(x != 0){
            int y = x % 10;
            if(res > Integer.MAX_VALUE/10 || (res == Integer.MAX_VALUE/10 && y > 7)
            || res < Integer.MIN_VALUE/10 || (res == Integer.MIN_VALUE/10 && y < -8)){
                return 0;
            }
            res = res * 10 + y;
            x = x /10;
        }
        return res;
    }

    public static boolean isPalindrome(int x) {
        if(x < 0){
            return false;
        }
        return reverse(x) == x;
    }

    public static boolean isPalindrome2(int x) {
        if(x < 0){
            return false;
        }
        int rev = 0;
        while(x > rev){
            rev = rev * 10 + x%10;
            x = x/10;
        }
        return x == rev || x == rev /10;
    }
}
