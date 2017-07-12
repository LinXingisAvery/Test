package test;

/**
 * @author: Avery
 * @description: 获取两个字符串中最大相同子串
 * @date: 2017年7月13日
 */
public class GetMaxSubString {
	public String getMaxSubString(String str1,String str2){
		String min=str1.length()<str2.length()?str1:str2;//短的
		String max=str1.length()<str2.length()?str2:str1;//长的
		for(int i=0;i<min.length();i++){//控制子串长度
			//左包含右不包含  indexOf方法  所以   可以取等
			for(int startIndex=0,endIndex=min.length()-i;endIndex<=min.length();startIndex++,endIndex++){
				String temp=min.substring(startIndex, endIndex);//得到子串
				//判断子串是否在max中如果在返回temp就是最长串
				if(max.contains(temp))
					return temp;
			}
		}
		return null;
	}
	public static void main(String[] args) {
		GetMaxSubString t=new GetMaxSubString();
		System.out.println(t.getMaxSubString("hellob123dsaf", "adb123a"));
	}
}