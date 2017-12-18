package com.wyrhero.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class ComMethod {
	/**
	 * 
	 * @param strSrc
	 *            需要加密的MD5源串
	 * @return 返回加密成MD5串
	 */
	public static String getMD5Str(String strSrc) {

		StringBuilder sb = new StringBuilder();

		try {
			MessageDigest mdInst = MessageDigest.getInstance("MD5");
			mdInst.update(strSrc.getBytes());
			byte[] md = mdInst.digest();

			for (byte by : md) {
				sb.append(String.format("%02x", by));// 将生成的字节MD５值转换成字符串
			}
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			sb.append("");
		}

		return sb.toString();
	}
}
