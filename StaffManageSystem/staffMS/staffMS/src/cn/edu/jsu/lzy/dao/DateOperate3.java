package staffMS.src.cn.edu.jsu.lzy.dao;

import java.awt.Container;
import java.awt.desktop.PrintFilesEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Statement;

public class DateOperate3 {
	private String Cname;
	private String Dname;
	private String number;
	private String sex;
	private String name;
	private String entryDate;
	
public DateOperate3() {
		super();
	}

public DateOperate3(String company, String department, String stuffNumber, String sex, String name, String entryDate) {
		super();
		this.Cname = company;
		this.Dname = department;
		this.number = stuffNumber;
		this.sex = sex;
		this.name = name;
		this.entryDate = entryDate;
	}

public String getCompany() {
	return Cname;
}

public void setCompany(String company) {
	this.Cname = company;
}

public String getDepartment() {
	return Dname;
}

public void setDepartment(String department) {
	this.Dname = department;
}

public String getStuffNumber() {
	return number;
}

public void setStuffNumber(String stuffNumber) {
	this.number = stuffNumber;
}

public String getSex() {
	return sex;
}

public void setSex(String sex) {
	this.sex = sex;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getEntryDate() {
	return entryDate;
}

public void setEntryDate(String entryDate) {
	this.entryDate = entryDate;
}

public static void DateAdd(String Cname,String Dname,String number,String name,String sex,String entryDate) {//增加数据
	DatabaseConnectionSql dbcs=new DatabaseConnectionSql();//使用1中定义的连接数据库的类
	String sql="insert into PD2(company,department,stuffNumber,sex,name,entryDate) values(?,?,?,?,?,?)";//使用占位符定义插入语句
	try(Connection conn=dbcs.getConnection();//获取数据库接
		PreparedStatement pstmt=conn.prepareStatement(sql);){//实例化PreparedStatement
    	ArrayList<String> alist=new ArrayList<String>();//定义集合
			if(!alist.contains(number)) {//判断编号是否唯一
				alist.add(number);//将编号加入集合
				
				pstmt.setString(1, Cname);//定义第1个占位符的内容
	    		pstmt.setString(2, Dname);//定义第2个占位符的内容
	    		pstmt.setString(3, number);//定义第3个占位符的内容
	    		pstmt.setString(4, name);//定义第4个占位符的内容
	    		pstmt.setString(5, sex);//定义第5个占位符的内容
	    		pstmt.setString(6,entryDate );//定义第6个占位符的内容
	    		pstmt.addBatch();//加入批处理等待执行

		}
		pstmt.executeBatch();//批量执行插入操作
	}catch(SQLException e) {
		e.printStackTrace();
	}
}
public static void DateDelete(String number) throws SQLException {//删除数据 
	DatabaseConnectionSql dbcs=new DatabaseConnectionSql();//使用1中定义的连接数据库的类
	String sql="delete from PD2 where stuffNumber="+number;//使用占位符定义插入语句
	Connection conn=dbcs.getConnection();//获取数据库连接
	java.sql.Statement pstmt=conn.createStatement();
	pstmt.executeUpdate(sql);
	JOptionPane.showMessageDialog(null, "sucess");
	pstmt.close();
	conn.close();
}
public static Vector DateSelect(String number) throws SQLException{//查询并输出数据
	DatabaseConnectionSql dbcs=new DatabaseConnectionSql();//使用1中定义的连接数据库的类
	String sql="select* from PD2 where stuffNumber="+number;//使用占位符定义插入语句
	Connection conn=dbcs.getConnection();//获取数据库连接
	java.sql.Statement pstmt=null;
	ResultSet rs=null;
	pstmt=conn.createStatement();
	rs=pstmt.executeQuery(sql);
	Vector v=new Vector();
	while(rs.next()) {
		String company=rs.getString("company");
		String department=rs.getString("department");
		String stuffNumber=rs.getString("stuffNumber");
		String name=rs.getString("name");
		String sex=rs.getString("sex");
		String entryDate=rs.getString("entryDate");
		v.add(company);
		v.add(department);
		v.add(stuffNumber);
		v.add(name);
		v.add(sex);
		v.add(entryDate);
	}
	pstmt.close();
	conn.close();
	return v;
}
public static boolean DateSelect2(String number) throws SQLException{//查询并判断数据
	DatabaseConnectionSql dbcs=new DatabaseConnectionSql();//使用1中定义的连接数据库的类
	String sql="select* from PD2 where stuffNumber="+number;//使用占位符定义插入语句
	Connection conn=dbcs.getConnection();//获取数据库连接
	java.sql.Statement pstmt=null;
	ResultSet rs=null;
	pstmt=conn.createStatement();
	rs=pstmt.executeQuery(sql);
	while(rs.next()) {
		String stuffNumber=rs.getString("stuffNumber").trim();//trim()去空格
		if(stuffNumber.equals(number))
			return true;	
	}
	pstmt.close();
	conn.close();
	return false;
}
//public static boolean DateSelect2(String number) throws SQLException{//查询并判断数据
//	DatabaseConnectionSql dbcs=new DatabaseConnectionSql();//使用1中定义的连接数据库的类
//	String sql="select* from PD2 where stuffNumber="+number;//使用占位符定义插入语句
//	Connection conn=dbcs.getConnection();//获取数据库连接
//	java.sql.Statement pstmt=null;
//	ResultSet rs=null;
//	pstmt=conn.createStatement();
//	rs=pstmt.executeQuery(sql);
//	while(rs.next()) {
//		int stuffNumber=Integer.parseInt(rs.getString("stuffNumber").trim());
//		int a=Integer.parseInt(number);
//		if(stuffNumber==a)
//			return true;	
//	}
//	pstmt.close();
//	conn.close();
//	return false;
//}
public static void DateUpdate(String Cname,String Dname,String number,String name,String sex,String entryDate) throws SQLException{//修改数据p
	DatabaseConnectionSql dbcs=new DatabaseConnectionSql();//使用1中定义的连接数据库的类
	String sql="update PD2 set company='"+Cname+"',department='"+Dname+"',stuffNumber='"+number+"',name='"+name+"',sex='"+sex+"',entryDate='"+entryDate+"' where stuffNumber="+number;//使用占位符定义插入语句
	Connection conn=dbcs.getConnection();//获取数据库连接
	java.sql.Statement pstmt=conn.createStatement();
	pstmt.executeUpdate(sql);
	JOptionPane.showMessageDialog(null, "sucess");
	pstmt.close();
	conn.close();
}
//账户处理


public static void UserDateAdd(int u,int p) {//增加数据
	DatabaseConnectionSql dbcs=new DatabaseConnectionSql();//使用1中定义的连接数据库的类
	String sql="insert into User1(userName,password) values(?,?)";//使用占位符定义插入语句
	try(Connection conn=dbcs.getConnection();//获取数据库接
		PreparedStatement pstmt=conn.prepareStatement(sql);){//实例化PreparedStatement
    	ArrayList<String> alist=new ArrayList<String>();//定义集合
			if(!alist.contains(u)) {//判断编号是否唯一			
				pstmt.setInt(1, u);//定义第1个占位符的内容
	    		pstmt.setInt(2, p);//定义第2个占位符的内容
	    		pstmt.addBatch();//加入批处理等待执行

		}
		pstmt.executeBatch();//批量执行插入操作
		JOptionPane.showMessageDialog(null, "sucess");
	}catch(SQLException e) {
		e.printStackTrace();
	}
}
public static void UserDateDelete(int u) throws SQLException {//删除数据
	DatabaseConnectionSql dbcs=new DatabaseConnectionSql();//使用1中定义的连接数据库的类
	String sql="delete from User1 where userName="+u;
	Connection conn=dbcs.getConnection();//获取数据库连接
	java.sql.Statement pstmt=conn.createStatement();
	pstmt.executeUpdate(sql);
	JOptionPane.showMessageDialog(null, "sucess");
	pstmt.close();
	conn.close();
}

public static void UserDateUpdate(int u,int p) throws SQLException{//修改数据
	DatabaseConnectionSql dbcs=new DatabaseConnectionSql();//使用1中定义的连接数据库的类
	String sql="update User1 set userName='"+u+"',password='"+p+"'where userName="+u;
	Connection conn=dbcs.getConnection();//获取数据库连接
	java.sql.Statement pstmt=conn.createStatement();
	pstmt.executeUpdate(sql);
	JOptionPane.showMessageDialog(null, "sucess");
	pstmt.close();
	conn.close();
}
public static boolean UserDateSelectUserName(int n) throws SQLException{//查询账号
	DatabaseConnectionSql dbcs=new DatabaseConnectionSql();//使用1中定义的连接数据库的类
	String sql="select* from User1";
	Connection conn=dbcs.getConnection();//获取数据库连接
	java.sql.Statement pstmt=null;
	ResultSet rs=null;
	pstmt=conn.createStatement();
	rs=pstmt.executeQuery(sql);
	while(rs.next()) {
		int u=rs.getInt("userName");
		if(n==u) {
			return true;
		}	
	} 
	pstmt.close();
	conn.close();
	return false;
}
public static boolean UserDateSelectPassword(int n) throws SQLException{//查询密码
	DatabaseConnectionSql dbcs=new DatabaseConnectionSql();//使用1中定义的连接数据库的类
	String sql="select* from User1";
	Connection conn=dbcs.getConnection();//获取数据库连接
	java.sql.Statement pstmt=null;
	ResultSet rs=null;
	pstmt=conn.createStatement();
	rs=pstmt.executeQuery(sql);
	while(rs.next()) {
		int u=rs.getInt("password");
		if(n==u)
		return true;
	}
	pstmt.close(); 
	conn.close();
	return false;
}
public static Vector<Vector> getSelectAll(String sql){
	Vector<Vector> rows=new Vector<Vector>();//定义要返回的所有记录集合
	DatabaseConnectionSql dbcs=new DatabaseConnectionSql();//使用1中定义的连接数据库的类
	try(java.sql.Connection conn=dbcs.getConnection();//获取数据库接
		java.sql.PreparedStatement pstmt=conn.prepareStatement(sql);){//实例化PreparedStatement
		ResultSet rs=pstmt.executeQuery();//执行查询语句，结果放到数据集中
		while(rs.next()) {//遍历数据集
			Vector row=new Vector();//定义行数据
			row.add(rs.getString(1));//获取第一个字段
			row.add(rs.getString(2));//获取第二个字段
			row.add(rs.getString(3));
			row.add(rs.getString(4));
			row.add(rs.getString(5));
			row.add(rs.getString(6));
			rows.add(row);//将行数据添加到记录集合中
		} 
	}catch(SQLException e) {
		e.printStackTrace();
	}
	return rows;//返回所有行数据
}
}
