package com.zsy.sum;

import android.os.Environment;

import com.zsy.lib.utils.IOUtils;
import com.zsy.lib.utils.depend.Lg;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class FileUtils {

    public static final String Break = "\r\n";

    public static void test() {
        File dir = new File(Environment.getExternalStorageDirectory() + "/lg");
        Lg.i(dir.toString());
        if (!dir.isDirectory()) {
            Lg.i("rt:" + dir.mkdirs());
        }
        File file = new File(dir, "lg.csv");
        String pre = "";
        if (file.isFile()) {
            pre = Break;
        }
        write(file, pre + "asdf,maoz,aweknjr,smd,keha,asde," + System.currentTimeMillis());
        read(file);
    }

    public static void write(File file, String msg) {
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, true), "UTF-8"));
            writer.write(msg);
            writer.flush();
        } catch (UnsupportedEncodingException | FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            IOUtils.close(writer);
        }
    }

    public static void read(File file) {
        int count = 0;
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] arr = line.split(",");
                Lg.i(Arrays.toString(arr));
//				System.out.println((++count)+"====>"+line);
            }
        } catch (UnsupportedEncodingException | FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            IOUtils.close(reader);
        }
    }


}
