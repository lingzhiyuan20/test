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

public static void DateAdd(String Cname,String Dname,String number,String name,String sex,String entryDate) {//��������
	DatabaseConnectionSql dbcs=new DatabaseConnectionSql();//ʹ��1�ж�����������ݿ����
	String sql="insert into PD2(company,department,stuffNumber,sex,name,entryDate) values(?,?,?,?,?,?)";//ʹ��ռλ������������
	try(Connection conn=dbcs.getConnection();//��ȡ���ݿ��
		PreparedStatement pstmt=conn.prepareStatement(sql);){//ʵ����PreparedStatement
    	ArrayList<String> alist=new ArrayList<String>();//���弯��
			if(!alist.contains(number)) {//�жϱ���Ƿ�Ψһ
				alist.add(number);//����ż��뼯��
				
				pstmt.setString(1, Cname);//�����1��ռλ��������
	    		pstmt.setString(2, Dname);//�����2��ռλ��������
	    		pstmt.setString(3, number);//�����3��ռλ��������
	    		pstmt.setString(4, name);//�����4��ռλ��������
	    		pstmt.setString(5, sex);//�����5��ռλ��������
	    		pstmt.setString(6,entryDate );//�����6��ռλ��������
	    		pstmt.addBatch();//����������ȴ�ִ��

		}
		pstmt.executeBatch();//����ִ�в������
	}catch(SQLException e) {
		e.printStackTrace();
	}
}
public static void DateDelete(String number) throws SQLException {//ɾ������ 
	DatabaseConnectionSql dbcs=new DatabaseConnectionSql();//ʹ��1�ж�����������ݿ����
	String sql="delete from PD2 where stuffNumber="+number;//ʹ��ռλ������������
	Connection conn=dbcs.getConnection();//��ȡ���ݿ�����
	java.sql.Statement pstmt=conn.createStatement();
	pstmt.executeUpdate(sql);
	JOptionPane.showMessageDialog(null, "sucess");
	pstmt.close();
	conn.close();
}
public static Vector DateSelect(String number) throws SQLException{//��ѯ���������
	DatabaseConnectionSql dbcs=new DatabaseConnectionSql();//ʹ��1�ж�����������ݿ����
	String sql="select* from PD2 where stuffNumber="+number;//ʹ��ռλ������������
	Connection conn=dbcs.getConnection();//��ȡ���ݿ�����
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
public static boolean DateSelect2(String number) throws SQLException{//��ѯ���ж�����
	DatabaseConnectionSql dbcs=new DatabaseConnectionSql();//ʹ��1�ж�����������ݿ����
	String sql="select* from PD2 where stuffNumber="+number;//ʹ��ռλ������������
	Connection conn=dbcs.getConnection();//��ȡ���ݿ�����
	java.sql.Statement pstmt=null;
	ResultSet rs=null;
	pstmt=conn.createStatement();
	rs=pstmt.executeQuery(sql);
	while(rs.next()) {
		String stuffNumber=rs.getString("stuffNumber").trim();//trim()ȥ�ո�
		if(stuffNumber.equals(number))
			return true;	
	}
	pstmt.close();
	conn.close();
	return false;
}
//public static boolean DateSelect2(String number) throws SQLException{//��ѯ���ж�����
//	DatabaseConnectionSql dbcs=new DatabaseConnectionSql();//ʹ��1�ж�����������ݿ����
//	String sql="select* from PD2 where stuffNumber="+number;//ʹ��ռλ������������
//	Connection conn=dbcs.getConnection();//��ȡ���ݿ�����
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
public static void DateUpdate(String Cname,String Dname,String number,String name,String sex,String entryDate) throws SQLException{//�޸�����p
	DatabaseConnectionSql dbcs=new DatabaseConnectionSql();//ʹ��1�ж�����������ݿ����
	String sql="update PD2 set company='"+Cname+"',department='"+Dname+"',stuffNumber='"+number+"',name='"+name+"',sex='"+sex+"',entryDate='"+entryDate+"' where stuffNumber="+number;//ʹ��ռλ������������
	Connection conn=dbcs.getConnection();//��ȡ���ݿ�����
	java.sql.Statement pstmt=conn.createStatement();
	pstmt.executeUpdate(sql);
	JOptionPane.showMessageDialog(null, "sucess");
	pstmt.close();
	conn.close();
}
//�˻�����


public static void UserDateAdd(int u,int p) {//��������
	DatabaseConnectionSql dbcs=new DatabaseConnectionSql();//ʹ��1�ж�����������ݿ����
	String sql="insert into User1(userName,password) values(?,?)";//ʹ��ռλ������������
	try(Connection conn=dbcs.getConnection();//��ȡ���ݿ��
		PreparedStatement pstmt=conn.prepareStatement(sql);){//ʵ����PreparedStatement
    	ArrayList<String> alist=new ArrayList<String>();//���弯��
			if(!alist.contains(u)) {//�жϱ���Ƿ�Ψһ			
				pstmt.setInt(1, u);//�����1��ռλ��������
	    		pstmt.setInt(2, p);//�����2��ռλ��������
	    		pstmt.addBatch();//����������ȴ�ִ��

		}
		pstmt.executeBatch();//����ִ�в������
		JOptionPane.showMessageDialog(null, "sucess");
	}catch(SQLException e) {
		e.printStackTrace();
	}
}
public static void UserDateDelete(int u) throws SQLException {//ɾ������
	DatabaseConnectionSql dbcs=new DatabaseConnectionSql();//ʹ��1�ж�����������ݿ����
	String sql="delete from User1 where userName="+u;
	Connection conn=dbcs.getConnection();//��ȡ���ݿ�����
	java.sql.Statement pstmt=conn.createStatement();
	pstmt.executeUpdate(sql);
	JOptionPane.showMessageDialog(null, "sucess");
	pstmt.close();
	conn.close();
}

public static void UserDateUpdate(int u,int p) throws SQLException{//�޸�����
	DatabaseConnectionSql dbcs=new DatabaseConnectionSql();//ʹ��1�ж�����������ݿ����
	String sql="update User1 set userName='"+u+"',password='"+p+"'where userName="+u;
	Connection conn=dbcs.getConnection();//��ȡ���ݿ�����
	java.sql.Statement pstmt=conn.createStatement();
	pstmt.executeUpdate(sql);
	JOptionPane.showMessageDialog(null, "sucess");
	pstmt.close();
	conn.close();
}
public static boolean UserDateSelectUserName(int n) throws SQLException{//��ѯ�˺�
	DatabaseConnectionSql dbcs=new DatabaseConnectionSql();//ʹ��1�ж�����������ݿ����
	String sql="select* from User1";
	Connection conn=dbcs.getConnection();//��ȡ���ݿ�����
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
public static boolean UserDateSelectPassword(int n) throws SQLException{//��ѯ����
	DatabaseConnectionSql dbcs=new DatabaseConnectionSql();//ʹ��1�ж�����������ݿ����
	String sql="select* from User1";
	Connection conn=dbcs.getConnection();//��ȡ���ݿ�����
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
	Vector<Vector> rows=new Vector<Vector>();//����Ҫ���ص����м�¼����
	DatabaseConnectionSql dbcs=new DatabaseConnectionSql();//ʹ��1�ж�����������ݿ����
	try(java.sql.Connection conn=dbcs.getConnection();//��ȡ���ݿ��
		java.sql.PreparedStatement pstmt=conn.prepareStatement(sql);){//ʵ����PreparedStatement
		ResultSet rs=pstmt.executeQuery();//ִ�в�ѯ��䣬����ŵ����ݼ���
		while(rs.next()) {//�������ݼ�
			Vector row=new Vector();//����������
			row.add(rs.getString(1));//��ȡ��һ���ֶ�
			row.add(rs.getString(2));//��ȡ�ڶ����ֶ�
			row.add(rs.getString(3));
			row.add(rs.getString(4));
			row.add(rs.getString(5));
			row.add(rs.getString(6));
			rows.add(row);//����������ӵ���¼������
		} 
	}catch(SQLException e) {
		e.printStackTrace();
	}
	return rows;//��������������
}
}
