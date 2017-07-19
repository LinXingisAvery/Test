package test;

import java.util.Scanner;

public class YFTriangle {
	public static void printYFTriangle(){
        System.out.println("how many lines you want:");
        Scanner in = new Scanner(System.in);
        int lines = in.nextInt();//输入需要显示的行数
        int[] a = new int[lines + 1];
        int previous = 1;
        for (int i = 1; i <= lines; i ++){
        	//打印前面空格
        	for(int k=0;k<lines-i;k++){
        		System.out.print("  ");
        	}
        	//打印三角内空
            for (int j = 1; j <= i; j++){
                int current = a[j];
                a[j] = previous + current;
                previous = current;
                System.out.printf("%4d ",a[j]);//输出格式控制
            }
            System.out.println();
        }
    }
public static void main(String[] args) {
	printYFTriangle();
}
}
