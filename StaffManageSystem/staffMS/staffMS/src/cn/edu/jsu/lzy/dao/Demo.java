package staffMS.src.cn.edu.jsu.lzy.dao;

public class Demo {

	public static void main(String[] args) {
		DatabaseConnectionSql dbconn = new DatabaseConnectionSql();
		if (dbconn.getConnection() != null) {
			System.out.println("���ݿ����ӳɹ�");
			dbconn.close();
		}
	}

}
