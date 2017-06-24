package algorithm;

import java.util.Scanner;
/**将二进制字符串转为int   例如00000111转化成int  7而不是111*/
/**
 * @author: Avery
 * @description: 八位二进制加法
 * @date: 2017年6月25日
 */
public class BinaryAdd {
	public static int StringToInt(String str) {
		int n = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '1' || str.charAt(i) == '0') {
				n = n << 1;
				n += str.charAt(i) - 48;
			}
		}
		return n;
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("请输入第一个二进制数");
		String str = scan.next();
		System.out.println("请输入第二个二进制数");
		String str1 = scan.next();
		int n = StringToInt(str);
		int n1 = StringToInt(str1);
		System.out.println(Integer.toBinaryString((n + n1) & 0xff));//取低8位转二进制输出
		scan.close();
	}
}
