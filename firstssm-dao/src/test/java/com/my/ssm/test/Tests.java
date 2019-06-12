package com.my.ssm.test;

public class Tests {

	public static void main(String[] args)

	{
		/*
		 * for (int i = 0; i < 10; i++) { if (i == 7) { System.out.println(233); }
		 * System.out.println(i); }
		 */
		// System.out.println("用户ID".length());

		/*
		 * String url = "123/123/abc"; if (url.indexOf("/") != 0) { url = "/" + url; }
		 * System.out.println(url);
		 */

		int[][] arr = { { 1, 2, 3, 4, 5 }, { 6, 7, 8, 9, 10 }, { 11, 12, 13, 14, 15 }, { 16, 17, 18, 19, 20 },
				{ 21, 22, 23, 24, 25 } };
		for (int i = 0; i < arr.length; i++) { // 遍历二维数组，遍历出来的每一个元素是一个一维数组
			for (int j = 0; j < arr[i].length; j++) { // 遍历对应位置上的一维数组
				System.out.println(arr[i][j]);
			}
		}
	}
}
