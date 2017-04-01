package com.zsy.lib.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileUtils {

    public static final String BR = System.getProperty("line.separator", "\n");

    public static void main(String[] args) {

        // File file=new File("E:/javaroot/dst");
        // System.out.println(delete(file));

        System.out.println(copy(new File("E:/javaroot"), new File("E:/javaroot2")));

    }

    private static boolean delete(File file) {
        if (file.isFile()) {
            file.delete();
        }
        if (file.isDirectory()) {
            boolean rt1 = deleteChildren(file);
            boolean rt2 = file.delete();
            if (!rt1 || !rt2) {
                return false;
            }
        }
        return true;
    }

    private static boolean deleteChildren(File file) {
        File[] files = file.listFiles();
        for (File file2 : files) {
            delete(file2);
        }
        return true;
    }

    public static boolean copyFile(File src, File dst) {
        if (src == null || dst == null) {
            throw new NullPointerException("src or dst == null");
        }
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream(src);
            fos = new FileOutputStream(dst);
            return IOUtils.is2os(fis, fos);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            IOUtils.close(fis, fos);
        }
        return false;
    }

    public static final boolean copy(File src, File dst) {
        if (src == null || dst == null) {
            throw new NullPointerException("src or dst == null");
        }
        if (!dst.isDirectory()) {
            dst.mkdirs();
        }
        if (src.isFile()) {
            System.out.println("is file");
            dst = new File(dst, src.getName());
            return copyFile(src, dst);
        }
        System.out.println(src.isDirectory() + ":" + src.isFile() + ":" + src.exists());
        File[] files = src.listFiles();
        System.out.println(files.length);
        for (File file : files) {
            if (file.isFile()) {
                if (!copyFile(file, new File(dst, file.getName()))) {
                    return false;
                }
            } else if (!copy(file, new File(dst, file.getName()))) {
                return false;
            }
        }
        return true;

    }

    public static final boolean str2file(String text, File file, String charset, boolean append) {
        FileOutputStream fos = null;
        try {
            return IOUtils.str2os(text, new FileOutputStream(file, append), charset);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            IOUtils.close(fos);
        }
        return false;
    }

    public static final boolean str2file(String text, File file, boolean append) {
        return str2file(text, file, IOUtils.DEFAULT_CHARSET, append);
    }

    public static final boolean str2file(String text, File file,String charset) {
        return str2file(text, file, charset, false);
    }

    public static final StringBuilder listFile(File file, int depth, StringBuilder sb) {
        if (file == null || sb == null) {
            return sb;
        }

        sb.append(file.getAbsolutePath() + BR);

        if (file.isFile() || depth == 0) {
            return sb;
        }
        File[] files = file.listFiles();
        depth--;
        for (File file2 : files) {
            listFile(file2, depth, sb);
        }
        return sb;

    }
}
