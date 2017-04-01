package com.zsy.lib.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;


public class IOUtils {


    public static final int DEFAULT_BUFFER_LENGTH = 8 * 1024;
    public static final String DEFAULT_CHARSET = "UTF-8";

    public static boolean is2os(InputStream is, OutputStream os, int bufferLen) throws IOException {
        if (is == null || os == null) {
            throw new NullPointerException("is or os == null");
        }
        int len;
//        long count = 0;
        byte[] buffer = new byte[bufferLen];
        while ((len = is.read(buffer)) != -1) {
            os.write(buffer, 0, len);
//                count += len;
        }
        return true;
    }

    public static boolean is2os(InputStream is, OutputStream os) throws IOException {
        return is2os(is, os, DEFAULT_BUFFER_LENGTH);
    }

    public static String is2str(InputStream is, String charset) throws IOException {
        if (is == null) {
            return null;
        }
        BufferedReader reader = new BufferedReader(new InputStreamReader(is, charset));
        StringBuilder stringBuilder = new StringBuilder();
        String curLine;
        while ((curLine = reader.readLine()) != null) {
            stringBuilder.append(curLine);
        }
        return stringBuilder.toString();
    }

    public static String is2str(InputStream is) throws IOException {
        return is2str(is, DEFAULT_CHARSET);
    }

    public static boolean str2os(String text, OutputStream os, String charset) throws IOException {
        if (os == null) {
            throw new NullPointerException("os == null");
        }
        if (text == null) {
            text = "null";
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os, charset));
        bw.append(text);
        bw.flush();
        return true;
    }


    public static boolean str2os(String text, OutputStream os) throws IOException {
        return str2os(text, os, DEFAULT_CHARSET);
    }

    public static void close(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void close(Closeable... closeables) {
        for (Closeable closeable : closeables) {
            close(closeable);
        }
    }
}
