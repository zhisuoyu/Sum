package com.zsy.lib.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by 24275 on 2016/6/29.
 */
public class EncryptUtils {
    public static void main(String[] args) {
        System.out.println(MD5Hex("maozs", false));
        System.out.println(MD5Hex(null));
    }

    private static byte[] MD5(String input) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        return md.digest(input.getBytes());
    }

    public static String MD5Hex(String input, boolean sub16) {
        if (input == null) {
            throw new NullPointerException("input == null");
        }
        String cipherText = null;
        try {
            cipherText = toHex(MD5(input));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        if (cipherText != null && sub16) {
            return cipherText.substring(8, 24);
        }
        return cipherText;
    }

    public static String MD5Hex(String input) {
        return MD5Hex(input, false);
    }





    public static String toHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            int value = b & 0xff;
            String valueHex = Integer.toHexString(value);
            String valueHex2 = value <= 0xf ? "0" + valueHex : valueHex;
            sb.append(valueHex2);
        }
        return sb.toString();
    }
}
