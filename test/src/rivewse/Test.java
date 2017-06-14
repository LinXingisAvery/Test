package rivewse;

import java.util.LinkedList;
import java.util.List;

/**
 * @author: Avery
 * @description: Josephus及他的朋友与39 个犹太人的死亡游戏
 * @date: 2017年6月14日
 */
public class Test {
	public static void test(int n) {
		List<Integer> arrList = new LinkedList<Integer>();
		for (int i = 1; i <= n; i++) {
			arrList.add(i);
		}
		int number=1;
		int point=0;
		while(arrList.size()>2){
			if(number%3==0){//数到3自杀
				arrList.remove(point);
				point--;
			}
			point++;
			number++;
			if(point>arrList.size()-1){
				point=0;
			}
		}
		System.out.println("留下的人的编号:"+arrList.get(0)+" "+arrList.get(1));
	}

	public static void main(String[] args) {
		test(41);//死亡游戏39+2==41人
	}
}
