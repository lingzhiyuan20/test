package staffMS.src.cn.edu.jsu.lzy.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnectionSql {
	private static final String DBRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver" ;; // ����sqlserver���ݿ���������
	private static final String DBURL ="jdbc:sqlserver://localhost:1433;DatabaseName=StaffManageSystem" ; // ����sqlserver���ݿ����ӵ�ַ
	private static final String DBUSER = "sa"; // sqlserver���ݿ������û���
	private static final String PASSWORD = "lzy20001223"; // sqlserver���ݿ���������
	private Connection conn = null; // �������Ӷ���

	public DatabaseConnectionSql() {// ���췽���������ݿ�
		try {
			Class.forName(DBRIVER);
			this.conn = DriverManager.getConnection(DBURL, DBUSER, PASSWORD);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Connection getConnection() {// �������ݿ����Ӷ���
		return this.conn;
	}

	public void close() {// �ر���������
		if (this.conn != null) {
			try {
				this.conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
