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
	public static class StuOperate {//定义一个员工操作类，定义增、删、改等方法
		  final static File file=new File("F:/java.course/stuff.txt");
		  
		  
		  public static boolean addStuff(Vector v) {//定义增加员工的方法，v为内容
		    try(FileWriter fw=new FileWriter(file,true)){
		      fw.write(v+"\r\n");
//		      JOptionPane.showMessageDialog(null, "sucess");
		      return true;
		    }catch(Exception e1) {e1.printStackTrace();}
		    return false;
		  }
		  
		  
		  public void deleteStuff(String v) {//删除员工数据
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
		  
		  
		  
			  public static void change(String oldStr,String newStr){ //修改员工数据
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
		  
		  
		  
		  public static void stuffSelect1(String oldStr){//查找指定员工数据
			  
		  }
		  
		  
		public static Vector<Vector> stuffSelect() {//查询文本中所有数据
		  Vector<Vector> rows=new Vector<Vector>();//创建行数据容器
		  try(FileReader fr=new FileReader(file);
		      BufferedReader br=new BufferedReader(fr);){//使用缓冲流读取文件
		    String line=null;
		    while((line=br.readLine())!=null) {//按行读取
		      String[] col=line.split("\t");//读取的行按分隔符拆分成字符串数组
		      Vector row=new Vector();//定义行数据
		      for(int i=0;i<col.length;i++) {
		        row.add(col[i]);
		       }//增加行中其它数据
		       rows.add(row);//将行数据增加到行容器中
		    }
		       
		  }catch(Exception e1) {e1.printStackTrace();}
		  return rows;}//返回所有的行
		}	


}
