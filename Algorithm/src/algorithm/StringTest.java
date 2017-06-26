package algorithm;

/**
 * @author: Avery
 * @description: 假设字符串为 A|B|C|D|E|F|G|H|aaa
 *               处理后获取 A|B|，C|D|E|，F|G|H|，aaa
 * @date: 2017年6月27日
 */
public class StringTest {
public static void main(String[] args) {
	StringBuilder str=new StringBuilder("A|B|C|D|E|F|G|H|aaa");
	int j=0;
	for(int i=str.length()-1;i>=0;i--){
		if(String.valueOf(str.charAt(i)).matches("[a-zA-Z]")){
			j++;
			if(j%3==0)
				str.insert(i, ',');
		}
	}
	System.out.println(str);
}
}
