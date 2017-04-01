package com.zsy.lib.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpUtils {


    public static final int DEFAULT_CONN_TIME_OUT = 30 * 1000;
    public static final int DEFAULT_READ_TIME_OUT = 30 * 1000;
    public static final String METHOD_GET = "GET";
    public static final String METHOD_POST = "POST";
    public static final String DEFAULT_CHARSET = "UTF-8";

    public static void main(String[] args) {
        System.out.println(post4Str("http://www.baidu.com", null));
        // down("http://img05.tooopen.com/images/20150202/sy_80219211654.jpg",
        // new File("D:/sdf.jpg"));
    }

    public static void disConn(HttpURLConnection conn) {
        if (conn != null) {
            conn.disconnect();
        }
    }

    public static HttpURLConnection getConn(String url, String method, int connTime, int readTime)
            throws IOException {
        if (url == null) {
            return null;
        }
        HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
        conn.setRequestMethod(method);
        conn.setConnectTimeout(connTime);
        conn.setReadTimeout(readTime);
        return conn;
    }

    public static HttpURLConnection getUploadConn(String url) throws IOException {
        HttpURLConnection conn = getConn(url, METHOD_POST, DEFAULT_CONN_TIME_OUT, DEFAULT_READ_TIME_OUT);
        conn.setUseCaches(false);
        conn.setDoOutput(true);
        return conn;
    }

    public static HttpURLConnection getDownloadConn(String url) throws IOException {
        return getConn(url, METHOD_GET);
    }

    public static HttpURLConnection getConn(String url, String method) throws IOException {
        return getConn(url, method, DEFAULT_CONN_TIME_OUT, DEFAULT_READ_TIME_OUT);
    }

    public static String readStream2Str(InputStream inputStream) throws IOException {
        String result = null;
        StringBuilder stringBuilder = new StringBuilder();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, DEFAULT_CHARSET));
        String curLine;
        while ((curLine = reader.readLine()) != null) {
            stringBuilder.append(curLine);
        }
        if (stringBuilder.length() != 0) {
            result = stringBuilder.toString();
        }
        return result;
    }

    public static boolean baseDownload(String url, File file) {
        HttpURLConnection conn = null;
        InputStream inputStream = null;
        FileOutputStream fos = null;
        try {
        	File parentFile=file.getParentFile();
        	if(!parentFile.isDirectory()){
        		parentFile.mkdirs();
        	}
            conn = getDownloadConn(url);
            inputStream = conn.getInputStream();
            fos = new FileOutputStream(file);
            byte[] buffer = new byte[4 * 1024];
            int len;
            int fileLen = conn.getContentLength();
            int countLen = 0;
            while ((len = inputStream.read(buffer)) != -1) {
                fos.write(buffer, 0, len);
                countLen += len;
//                System.out.println(countLen + "/" + fileLen);
//                DebugUtils.log(countLen + "/" + fileLen);
            }
            if (countLen == fileLen) {
                return true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            IOUtils.close(inputStream);
            IOUtils.close(fos);
            disConn(conn);
        }
        return false;
    }

    public static boolean download(String url, File file,boolean overwrite,boolean temp){
    	if(!overwrite&&file.isFile()){
    		return true;
    	}
    	if(!temp){
    		return baseDownload(url, file);
    	}
    	File tempFile=createTempFile(file);
    	boolean rt=baseDownload(url, tempFile);
    	return rt&&tempFile.renameTo(file);
    }
    
    public static boolean download(String url, File file){
    	return download(url, file,false,true);
    }
    
    public static String getStr(String url) {
        String result = null;
        HttpURLConnection conn = null;
        InputStream inputStream = null;
        try {
            conn = getConn(url, METHOD_GET);
            inputStream = conn.getInputStream();
            result = readStream2Str(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            IOUtils.close(inputStream);
            disConn(conn);
        }
        return result;
    }

    public static String post4Str(String url, String paramStr) {
        String result = null;
        HttpURLConnection conn = null;
        InputStream inputStream = null;
        try {
            conn = getConn(url, METHOD_POST);
            conn.setDoOutput(true);
            if (paramStr != null) {
                conn.getOutputStream().write(paramStr.getBytes());
            }
            inputStream = conn.getInputStream();
            result = readStream2Str(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            IOUtils.close(inputStream);
            disConn(conn);
        }
        return result;
    }


	
	public static File createTempFile(File file){
		String tempName=getTempName(file.getAbsolutePath());
		return new File(tempName);
	}

	public static String getTempName(String name){
		int index=name.lastIndexOf('.');
		if(index!=-1){
			name=name.substring(0, index);
		}
		
		return name+".tmp";
	}
    
    // public static boolean download(String urlStr, File file) {
    // HttpURLConnection conn = null;
    // InputStream inputStream = null;
    // FileOutputStream fos = null;
    // try {
    // conn = (HttpURLConnection) new URL(urlStr).openConnection();
    // conn.setConnectTimeout(10000);
    // conn.setReadTimeout(20000);
    // conn.setInstanceFollowRedirects(false);
    // int statusCode = conn.getResponseCode();
    // inputStream = conn.getInputStream();
    // fos = new FileOutputStream(file);
    // byte[] buffer = new byte[8 * 1024];
    // int len;
    // int fileLen = conn.getContentLength();
    // int countLen = 0;
    // while ((len = inputStream.read(buffer)) != -1) {
    // fos.write(buffer, 0, len);
    // countLen += len;
    // System.out.println(countLen + "/" + fileLen + ";" +
    // conn.getReadTimeout());
    // }
    // if (countLen == fileLen) {
    // return true;
    // }
    // } catch (IOException e) {
    // e.printStackTrace();
    // } finally {
    // if (inputStream != null) {
    // try {
    // inputStream.close();
    // } catch (IOException e) {
    // e.printStackTrace();
    // }
    // }
    // if (fos != null) {
    // try {
    // fos.close();
    // } catch (IOException e) {
    // e.printStackTrace();
    // }
    // }
    // if (conn != null) {
    // conn.disconnect();
    // }
    // }
    // return false;
    // }
}
