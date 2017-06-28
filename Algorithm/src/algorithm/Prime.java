package algorithm;

import java.util.Scanner;

/**
 * @author: Avery
 * @description: 把一个偶数拆成两个不同素数的和，有几种拆法呢？
 * @date: 2017年6月29日
 */
public class Prime {
	/**判断素数*/
	public static boolean prime(int n){
		if(n<=1)
			return false;
		if(n==2||n==3)
			return true;
		if(n>3){
			for(int i=2;i<=Math.sqrt(n);i++){
				if(n%i==0)
					return false;
			}
		}
		return true;
	}
public static void main(String[] args) {
	Scanner scan=new Scanner(System.in);
	System.out.println("请输入一个正偶数");
	int n=scan.nextInt();
	int count=0;
	for(int i=2;i<=n-i;i++){
		if(prime(i)&&prime(n-i)){
			count++;
		}
	}
	System.out.println(count);
	scan.close();
}
}