package staffMS.src.cn.edu.jsu.lzy.dao;

import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JOptionPane;

public class Demo2 {//����������ɾ��ĵĲ�����

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		DatabaseConnectionSql dbconn = new DatabaseConnectionSql();
		DateOperate3 test=new DateOperate3();
		if(DateOperate3.DateSelect2("202100145"))
		{
			JOptionPane.showMessageDialog(null, "sucess");
		}
		else {
			JOptionPane.showMessageDialog(null, "false");
		}
			
		
	}

}
//System.out.printf("------");