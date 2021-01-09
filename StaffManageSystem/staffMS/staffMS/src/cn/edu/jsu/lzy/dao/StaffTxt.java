package staffMS.src.cn.edu.jsu.lzy.dao;

import java.awt.desktop.PrintFilesEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.sql.SQLException;
import java.util.Collections;
import java.util.Scanner;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class StaffTxt {
	public static class StuOperate {//����һ��Ա�������࣬��������ɾ���ĵȷ���
		  final static File file=new File("F:/java.course/stuff.txt");
		  
		  
		  public static boolean addStuff(Vector v) {//��������Ա���ķ�����vΪ����
		    try(FileWriter fw=new FileWriter(file,true)){
		      fw.write(v+"\r\n");
//		      JOptionPane.showMessageDialog(null, "sucess");
		      return true;
		    }catch(Exception e1) {e1.printStackTrace();}
		    return false;
		  }
		  
		  
		  public void deleteStuff(String v) {//ɾ��Ա������
			  try {
		            RandomAccessFile raf = new RandomAccessFile(file, "rw");
		            String line;
		            while (null!=(line=raf.readLine())) {
		                if(line.contains(v)){
		                    String[] split = line.split(v);
		                    raf.seek(split[0].length());
		                    raf.writeBytes(null);
		                    raf.writeBytes(split[1]);
		                }
		            }
		           raf.close();
		        } catch (IOException e) {
		            e.printStackTrace();
		        }
		  }
		  
		  
		  
			  public static void change(String oldStr,String newStr){ //�޸�Ա������
			        try {
			            RandomAccessFile raf = new RandomAccessFile(file, "rw");
			            String line;
			            while (null!=(line=raf.readLine())) {
			                if(line.contains(oldStr)){
			                    String[] split = line.split(oldStr);
			                    raf.seek(split[0].length());
			                    raf.writeBytes(newStr);
			                    raf.writeBytes(split[1]);
			                }
			            }
			           raf.close();
			        } catch (IOException e) {
			            e.printStackTrace();
			        }
			    }
		  
		  
		  
		  public static void stuffSelect1(String oldStr){//����ָ��Ա������
			  
		  }
		  
		  
		public static Vector<Vector> stuffSelect() {//��ѯ�ı�����������
		  Vector<Vector> rows=new Vector<Vector>();//��������������
		  try(FileReader fr=new FileReader(file);
		      BufferedReader br=new BufferedReader(fr);){//ʹ�û�������ȡ�ļ�
		    String line=null;
		    while((line=br.readLine())!=null) {//���ж�ȡ
		      String[] col=line.split("\t");//��ȡ���а��ָ�����ֳ��ַ�������
		      Vector row=new Vector();//����������
		      for(int i=0;i<col.length;i++) {
		        row.add(col[i]);
		       }//����������������
		       rows.add(row);//�����������ӵ���������
		    }
		       
		  }catch(Exception e1) {e1.printStackTrace();}
		  return rows;}//�������е���
		}	


}
