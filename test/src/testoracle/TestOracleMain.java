package testoracle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: Avery
 * @description: 测试类
 * @date: 2017年7月2日
 */
public class TestOracleMain {
	/**查询商品信息  全部查询*/
	public List<Goods> Allserch(){
		List<Goods>goods=new ArrayList<Goods>();
		try {
			Connection conn=DBUtity.openConnection();
			String sql="select *from goods";
			PreparedStatement pst=conn.prepareStatement(sql);
			 ResultSet rs= pst.executeQuery();//查询结果返回一个结果集
			 while(rs.next()){
				 Goods g=new Goods();//用一个商品对象来存放查出的一条数据
				 g.setId(rs.getString(1));
				 g.setName(rs.getString(2));
				 g.setAmount(rs.getInt(3));
				 g.setPrice(rs.getDouble(4));
				 goods.add(g);//将这条数据添加到goods集合中
			 }
	     DBUtity.closeConnection(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return goods;//返回集合查询结果集合
	}
public static void main(String[] args) {
	TestOracleMain t=new TestOracleMain();//当前类对象
	List<Goods>gds=t.Allserch();//返回的集合给gds  因Goods重写了toString  遍历集合就可以
	for(Goods g:gds){
		System.out.println(g);
	}
}
}
