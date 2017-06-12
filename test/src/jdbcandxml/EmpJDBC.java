package jdbcandxml;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author:李祖林
 * @description:员工信息表的增改查
 * @date:2017年6月5日下午5:17:23
 */
public class EmpJDBC {
	/** 查询 */
	public void searchAll() throws SQLException, ClassNotFoundException {
		// 加载驱动
		Class.forName("com.mysql.jdbc.Driver");
		// 建立连接
		Connection conn = DriverManager.getConnection("jdbc:mysql:" + "//localhost:3306/lin", "root", "linxing123");
		Statement stat = conn.createStatement();
		String sql = "select *from emp";
		// 执行sql语句
		ResultSet rs = stat.executeQuery(sql);
		while (rs.next()) {
			System.out.println("empno=" + rs.getInt("empno") + ",empname=" + rs.getString("empname") + ",job="
					+ rs.getString("job") + ",gmr=" + rs.getInt("mgr") + ",hiredate=" + rs.getDate("hiredate") + ",sal="
					+ rs.getDouble("sal") + ",comm=" + rs.getDouble("comm") + ",deptno=" + rs.getInt("deptno"));

		}
		// 关闭连接
		rs.close();
		stat.close();
		conn.close();
	}

	/** 添加数据 */
	public void add(int empno, String empname, String job, int mgr, String hiredate, double sal, double comm,
			int deptno) throws ClassNotFoundException, SQLException {
		// 加载驱动
		Class.forName("com.mysql.jdbc.Driver");
		// 建立连接
		Connection conn = DriverManager.getConnection("jdbc:mysql:" + "//localhost:3306/lin", "root", "linxing123");
		Statement stat = conn.createStatement();
		String sql = "insert into emp values(" + empno + ",'" + empname + "','" + job + "'," + mgr + ",'" + hiredate
				+ "'," + sal + "," + comm + "," + deptno + ")";
		stat.executeUpdate(sql);
		stat.close();
		conn.close();
	}

	/** 修改 */
	public void update() throws ClassNotFoundException, SQLException {
		// 加载驱动
		Class.forName("com.mysql.jdbc.Driver");
		// 建立连接
		Connection conn = DriverManager.getConnection("jdbc:mysql:" + "//localhost:3306/lin", "root", "linxing123");
		Statement stat = conn.createStatement();
		String sql = "update emp set sal=sal+100 where empno=1";
		stat.executeUpdate(sql);
		stat.close();
		conn.close();
	}

	/**
	 * 删除
	 * 
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public void delete() throws ClassNotFoundException, SQLException {
		// 加载驱动
		Class.forName("com.mysql.jdbc.Driver");
		// 建立连接
		Connection conn = DriverManager.getConnection("jdbc:mysql:" + "//localhost:3306/lin", "root", "linxing123");
		Statement stat = conn.createStatement();
		String sql = "delete from emp where empno=1";
		stat.executeUpdate(sql);
		stat.close();
		conn.close();
	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		EmpJDBC emp = new EmpJDBC();
		// 插入两条数据
		emp.add(1, "zhangsan", "teacher", 11, "2017-06-04", 2000, 1000, 1);
		// emp.add(2,"guanyu", "teacher", 11,"2017-06-04",2500,1200,1);
		emp.searchAll();
		// 修改empno=1的sal薪资加100
		emp.update();
		// 删除empno=1的数据
		emp.delete();
	}
}
