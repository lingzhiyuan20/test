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
		
			String sn;//����Ա����Ŷ��ļ�������ɾ�Ĳ�
			Scanner in = new Scanner(System.in);  
			sn=in.next();
			
			Vector<Vector> rows=new Vector<Vector>();//���Զ����ݵ�����----��ʵ��
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
			for (Vector vector : StaffTxt.StuOperate.stuffSelect()) {//���Զ����ݵĲ���
				System.out.print(vector+"\n");}
		*/
		
		/*
		StaffTxt.StuOperate.change("201940138", "201940139");//���Զ����ݵ��޸�
		for (Vector vector : StaffTxt.StuOperate.stuffSelect()) {//���Զ����ݵĲ���
			System.out.print(vector+"\n");}
		*/
		
	}
}
