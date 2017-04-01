package com.zsy.lib.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class SdfUtils {

//	public static void main(String[] args) {
//		String src="19991212181212";
//		try {
//			src=parse(src, "yyyyMMddHHmmss", "yyyy-MM-dd H:m:s");
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
//		System.out.println(src);
//	}
	
	public static String parse(String src,SimpleDateFormat srcSdf,SimpleDateFormat dstSdf) throws ParseException{
		src=dstSdf.format(srcSdf.parse(src));
		return src;
	}
	
	public static String parse(String src,String srcPtn,String dstPtn) throws ParseException{
		SimpleDateFormat srcSdf=new SimpleDateFormat(srcPtn);
		SimpleDateFormat dstSdf=new SimpleDateFormat(dstPtn);
		return parse(src, srcSdf, dstSdf);
	}
}
