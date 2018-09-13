package com.buzhi.utils;

import java.util.Random;

public class StringUtils extends org.springframework.util.StringUtils {

	/**
	 * @Description: 生成8位随机数
	 * @author
	 * @date
	 * @return
	 */
	public static synchronized int generateCode() {
		int min = 10000000;
		int max = 99999999;

		Random random = new Random();
		return random.nextInt(max) % (max - min + 1) + min;
	}
	
}
