package staffMS.src.cn.edu.jsu.lzy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class DataOperate {
	//��������
	private static String firstName="��Ǯ��������֣��������������������������ʩ�ſײ��ϻ���κ�ս���л������ˮ��������˸��ɷ�����³Τ������ﻨ������Ԭ��ۺ��ʷ�Ʒ����Ѧ�׺����������ޱϺ�����������ʱ��Ƥ���뿵����Ԫ������ƽ�ƺ�������Ҧ��տ����ë����ױ���갼Ʒ��ɴ�̸��é���ܼ�������ף������������ϯ����ǿ��·¦Σ��ͯ�չ�÷ʢ�ֵ�����������Ĳ��﷮���������֧�¾̹�¬Ī�������Ѹɽ�Ӧ�������ڵ��������������ʯ�޼�ť�������ϻ���½��������춻���κ�ӷ����ഢ���������ɾ��θ����ڽ��͹�����ɽ�ȳ������ȫۭ�����������������ﱩ�����������������ղ����Ҷ��˾��۬�輻��ӡ�ް׻���̨�Ӷ����̼���׿�����ɳ����������ܲ�˫��ݷ����̷�����̼������Ƚ��۪Ӻȴ�ɣ���ţ��ͨ�����༽ۣ����ũ�±�ׯ�̲����ֳ�Ľ����ϰ�°���������������θ����߾Ӻⲽ�����������Ŀܹ�»�ڶ�Ź�����εԽ��¡ʦ�������˹��������������Ǽ��Ŀ�����ɳؿ������ᳲ�������󽭺�����Ȩ�ָ��滸����ٹ˾���Ϲ�ŷ���ĺ�������˶��������ʸ�ξ�ٹ����̨��ұ���������������̫����������������ԯ�������������Ľ����������˾ͽ˾������˾���붽�ӳ�����ľ����������������ṫ���ذμй��׸����������ַ���۳Ϳ�նθɰ��ﶫ�����ź��ӹ麣����΢����˧�ÿ�������������������������Ĳ��٦�����Ϲ�ī�������갮��١�����Ը��ټ�����";
	//����Ů������
	private static String girl="���Ӣ���������Ⱦ���������֥��Ƽ�����ҷ���ʴ��������÷���������滷ѩ�ٰ���ϼ����ݺ�����𷲼Ѽ�������������Ҷ�������������ɺɯ������ٻ�������ӱ¶������������Ǻɵ���ü������ޱݼ���Է�ܰ�������԰��ӽ�������ع���ѱ�ˬ������ϣ����Ʈ�����������������������ܿ�ƺ������˿ɼ���Ӱ��֦˼�� ";
	//������������
    private static String boy="ΰ�����㿡��ǿ��ƽ�����Ļ�������������־��������ɽ�ʲ���������Ԫȫ��ʤѧ��ŷ���������ɱ�˳���ӽ��β��ɿ��ǹ���ﰲ����ï�����м�ͱ벩���Ⱦ�����׳��˼Ⱥ���İ�����ܹ����ƺ���������ԣ���ܽ���������ǫ�����֮�ֺ��ʲ����������������ά�������������󳿳�ʿ�Խ��������׵���ʱ̩ʢ��衾��ڲ�����ŷ纽��";
    //���幫˾����
    private static String Cname="ǣ�ִ��";
    //����Ա����ְʱ��
    private static String entryDate="2021.1.9";
    public static int getNum(int start,int end) {//������ط���ָ����Χ�������
    	//Math.random()�������0.0��1.0֮�����
        return (int)(Math.random()*(end-start+1)+start);
    }
    //�����������
    public static String getDname() {
    	String[] name= {"production","personnel","purchase","secretary"};
    	String flag;
    	flag=name[getNum(0,3)];
		return flag;
    }
    //������ر��
    public static StringBuilder getSNumber() {//��ʹ��String����Ϊ��Ҫ����ƴ���ַ���
    	StringBuilder xh=new StringBuilder("2021");//��ź�ǰ4λ��ͬ
    	StringBuilder xh1=new StringBuilder(String.valueOf(getNum(1,99999)));//���ȡ��3λ//String��valueOf������ת��Ϊ�ַ���
    	if(xh1.length()==1) {
    		xh1=xh1.insert(0, "0000");//�����1λ����ǰ������4��0
    		xh=xh.append(xh1);//ǰ6λ���3λƴ�ӳ�ѧ��
    	}else if(xh1.length()==2) {
    		xh1=xh1.insert(0, "000");//�����2λ����ǰ������3��0
    		xh=xh.append(xh1);
    	}else if(xh1.length()==3) {
    		xh1=xh1.insert(0, "00");//�����3λ����ǰ������2��0
    		xh=xh.append(xh1);
    	}else if(xh1.length()==4) {
    		xh1=xh1.insert(0, "0");//�����4λ����ǰ������1��0
    		xh=xh.append(xh1);
    	}else {
    		xh=xh.append(xh1);
    	}
    	return xh;
    }
  //��������Ա�
    public static String getSex() {
    	String[] name= {"man","woman"};
    	String flag;
    	flag=name[getNum(0,1)];
		return flag;
    }
    //��������������� 
    public static String getChineseName() {
        int index=getNum(0, firstName.length()-1);//���ȡ�����ַ����е�����λ��
        String first=firstName.substring(index, index+1);//��ȡ��λ�õ�����
        int sex=getNum(0,1);//���ȡ�Ա�����1Ϊ������0ΪŮ��
        String str=boy;//��������Ϊ�����ַ���
        int length=boy.length();//��ȡ�����ַ����ĳ���
        if(sex==0){//��������ȡΪ0�������ָ�ΪŮ��
            str=girl;
            length=girl.length();
        }
        index=getNum(0,length-1);//�����ȡ���ֵ�λ��
        String second=str.substring(index, index+1);//��ȡ��λ���е�����
        int hasThird=getNum(0,1);//�����ȡ�����Ƿ��е�������
        String third="";//Ĭ��û�е�������
        if(hasThird==1){//��������ȡΪ1�����е�������
            index=getNum(0,length-1);
            third=str.substring(index, index+1);
        }
        return first+second+third;//��������
    }
    public static void main(String[] args) {
    	addDate();
    }
    public static void addDate() {//��������
    	DatabaseConnectionSql dbcs=new DatabaseConnectionSql();//ʹ��1�ж�����������ݿ����
    	String sql="insert into PD(company,department,stuffNumber,sex,name,entryDate) values(?,?,?,?,?,?)";//ʹ��ռλ������������
    	try(Connection conn=dbcs.getConnection();//��ȡ���ݿ��
    		PreparedStatement pstmt=conn.prepareStatement(sql);){//ʵ����PreparedStatement
        	ArrayList<String> alist=new ArrayList<String>();//���弯��
    		for(int i=1;i<=10000;) {
    			String Dname=getDname();//�����ȡ����
    			String sex=getSex();//�����ȡ�Ա�
    			String xh=getSNumber().toString();//�����ȡ���
    			if(!alist.contains(xh)) {//�жϱ���Ƿ�Ψһ
    				alist.add(xh);//����ż��뼯��
    				String name=getChineseName();//�����ȡ����
    				pstmt.setString(1, Cname);//�����1��ռλ��������
    	    		pstmt.setString(2, Dname);//�����2��ռλ��������
    	    		pstmt.setString(3, xh);//�����3��ռλ��������
    	    		pstmt.setString(4, name);//�����4��ռλ��������
    	    		pstmt.setString(5, sex);//�����5��ռλ��������
    	    		pstmt.setString(6,entryDate );//�����6��ռλ��������
    	    		pstmt.addBatch();//����������ȴ�ִ��
    				i++;//���Ψһ��ѭ����������ִ��
    			}
    		}
    		pstmt.executeBatch();//����ִ�в������
    		JOptionPane.showMessageDialog(null, "sucess");
    	}catch(SQLException e) {
    		e.printStackTrace();
    	}
    }
}
