package jdbcandxml;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * @author:李祖林
 * @description:封装实现类
 * @date:2017年6月5日下午7:54:02
 */
public class EmpDao {
	/**
	 * 查询
	 * 
	 * @throws SQLException
	 */
	public List<Emp> searchAll() throws SQLException {
		List<Emp> empList = new ArrayList<Emp>();
		Connection conn = DBUtity.openConnection();
		Statement st = conn.createStatement();
		String sql = "select *from emp";
		ResultSet rs = st.executeQuery(sql);
		while (rs.next()) {
			Emp emp = new Emp();
			emp.setEmpno(rs.getInt("empno"));
			emp.setEmpname(rs.getString("empname"));
			emp.setJob(rs.getString("job"));
			emp.setMgr(rs.getInt("mgr"));
			emp.setHiredate(rs.getString("hiredate"));
			emp.setSal(rs.getDouble("sal"));
			emp.setComm(rs.getDouble("comm"));
			emp.setDeptno(rs.getInt("deptno"));
			empList.add(emp);
		}
		for (Emp emp : empList) {
			System.out.println(emp);
		}
		DBUtity.closeConnection(conn);
		return empList;
	}

	/** 添加数据 */
	public void insert(Emp emp) throws SQLException {
		Connection conn = DBUtity.openConnection();
		Statement st = conn.createStatement();
		String sql = "insert into emp values(" + emp.getEmpno() + ",'" + emp.getEmpname() + "','" + emp.getJob() + "',"
				+ emp.getMgr() + ",'" + emp.getHiredate() + "'," + emp.getSal() + "," + emp.getComm() + ","
				+ emp.getDeptno() + ")";
		st.executeUpdate(sql);
		DBUtity.closeConnection(conn);
	}

	/** 修改 */
	public void update() throws SQLException {
		Connection conn = DBUtity.openConnection();
		Statement st = conn.createStatement();
		String sql = "update emp set sal=sal+100 where empno=3";
		st.executeUpdate(sql);
		DBUtity.closeConnection(conn);
	}

	/** 删除 */
	public void delete() throws SQLException {
		Connection conn = DBUtity.openConnection();
		Statement st = conn.createStatement();
		String sql = "delete from emp where empno=3";
		st.executeUpdate(sql);
		DBUtity.closeConnection(conn);
	}

	public static void main(String[] args) throws SQLException {
		EmpDao empDao = new EmpDao();
		// 查询
		empDao.searchAll();
		// 创建emp对象
		Emp emp = new Emp(3, "caocao", "paobing", 11, "2017-06-04", 2000, 1000, 1);
		// 插入数据
		empDao.insert(emp);
		// 修改
		empDao.update();
		// 删除
		empDao.delete();
	}
}
