package algorithm;

/**
 * @author: Avery
 * @description: 简单手写不用  Integer.parseInt 方法自己写的一个转换
 * @date: 2017年6月14日
 */
public class StringToInt {
	private static int testParseInt(String str){
		boolean flag=false;
		if(str.charAt(0)=='-')
			flag=true;
		int i=0,result=0;
		if(flag)i++;
		while(i<str.length()){
			if(str.charAt(i)>=48&&str.charAt(i)<=57){
				result*=10;
				result+=str.charAt(i)-48;
				i++;
			}
			else{
				System.out.println("你输入的不是数字");
			}
		}
		if(flag)
			result=-result;
		return result;
	}
public static void main(String[] args) {
	int b=testParseInt("-123")+1;
	System.out.println(b);//-122
}	
}
