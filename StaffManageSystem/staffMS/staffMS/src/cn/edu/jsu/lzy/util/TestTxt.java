package staffMS.src.cn.edu.jsu.lzy.util;
import java.sql.SQLException;
import java.util.Collections;
import java.util.Scanner;
import java.util.Vector;

import javax.swing.JOptionPane;

import staffMS.src.cn.edu.jsu.lzy.dao.*;

public class TestTxt {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
			String sn;//根据员工编号对文件进行增删改查
			Scanner in = new Scanner(System.in);  
			sn=in.next();
			
			Vector<Vector> rows=new Vector<Vector>();//测试对数据的增加----已实现
			try {
				Collections.addAll(rows,DateOperate3.DateSelect(sn));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(StaffTxt.StuOperate.addStuff(rows)) {
				JOptionPane.showMessageDialog(null, "sucess");
			}else {
				JOptionPane.showMessageDialog(null, "false");
			}
			

/*
			for (Vector vector : StaffTxt.StuOperate.stuffSelect()) {//测试对数据的查找
				System.out.print(vector+"\n");}
		*/
		
		/*
		StaffTxt.StuOperate.change("201940138", "201940139");//测试对数据的修改
		for (Vector vector : StaffTxt.StuOperate.stuffSelect()) {//测试对数据的查找
			System.out.print(vector+"\n");}
		*/
		
	}
}
