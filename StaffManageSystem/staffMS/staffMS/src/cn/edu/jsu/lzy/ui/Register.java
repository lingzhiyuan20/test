package staffMS.src.cn.edu.jsu.lzy.ui;
import staffMS.src.cn.edu.jsu.lzy.dao.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;


import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import staffMS.src.cn.edu.jsu.lzy.dao.*;
public class Register extends JFrame {

	private JPanel contentPane;
	private JTextField number;
	private JTextField password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register frame = new Register();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Create the frame.
	 */
	public Register() {
		setTitle("\u767B\u5F55\u754C\u9762");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblNewLabel_4.setBounds(119, 155, 196, 28);
		contentPane.add(lblNewLabel_4);
		JButton register = new JButton("\u767B\u5F55");
		register.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					if(checkInput()) {
					MainInterface window = new MainInterface();//打开主界面
					window.frame.setLocationRelativeTo(null);// 窗体居中
					window.frame.setVisible(true);
					}else {
						lblNewLabel_4.setText("账号或者密码错误");
					}
				} 			
		});
		register.setFont(new Font("宋体", Font.PLAIN, 20));
		register.setBounds(93, 188, 105, 46);
		contentPane.add(register);
		
		
		number = new JTextField();
		number.setBounds(119, 68, 149, 34);
		contentPane.add(number);
		number.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u8D26\u53F7");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(68, 70, 58, 25);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u5BC6\u7801");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(68, 117, 58, 28);
		contentPane.add(lblNewLabel_2);
		
		password = new JTextField();
		password.setBounds(119, 117, 149, 34);
		contentPane.add(password);
		password.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\DELL\\Desktop\\java\u8BFE\u7A0B\u8BBE\u8BA1\\photo sourse\\919885632968327205.webp"));
		lblNewLabel.setBounds(0, 7, 436, 54);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(278, 72, 123, 24);
		contentPane.add(lblNewLabel_3);
		
		
		
		JButton zhuce = new JButton("\u6CE8\u518C");
		zhuce.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Zhuce frame = new Zhuce();
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
			}
		});
		zhuce.setFont(new Font("宋体", Font.PLAIN, 20));
		zhuce.setBounds(246, 188, 105, 46);
		contentPane.add(zhuce);
	}
	public boolean checkInput(){//验证登录
		
		int a=Integer.parseInt(number.getText());//将文本框账号转换为整型
		int b=Integer.parseInt(password.getText());//将文本框密码转换为整型
		try { 
			if(DateOperate3.UserDateSelectUserName(a)) {
				if(DateOperate3.UserDateSelectPassword(b)) {
					return true;
					} 
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
	}
}

