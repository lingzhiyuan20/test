package staffMS.src.cn.edu.jsu.lzy.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import staffMS.src.cn.edu.jsu.lzy.dao.*;
import javax.swing.ImageIcon;
public class DelectDate extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JButton btnNewButton_1;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;

	/**
	 * Launch the application.删除数据库中的数据
	 * @param
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DelectDate frame = new DelectDate();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.删除并判断是否删除
	 * @return
	 */
	public boolean delete() {//删除并判断是否删除
		try {
			DateOperate3.DateDelete(textField.getText());
			if(!DateOperate3.DateSelect2(textField.getText())) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
	}
	public DelectDate() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u8BF7\u8F93\u5165\u8981\u5220\u9664\u7684\u5458\u5DE5\u7F16\u53F7");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		lblNewLabel.setBounds(55, 28, 269, 36);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(113, 88, 269, 36);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("\u5220\u9664");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				{
					if(delete()) {
						lblNewLabel_1.setText("删除成功");
					}else {
						lblNewLabel_1.setText("删除失败");
					}
				}
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 20));
		btnNewButton.setBounds(55, 168, 123, 30);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("\u8FD4\u56DE\u4E3B\u754C\u9762");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			MainInterface window = new MainInterface();
				window.frame.setLocationRelativeTo(null);// 窗体居中
				window.frame.setVisible(true);	
			}
		});
		btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 20));
		btnNewButton_1.setBounds(201, 168, 181, 30);
		contentPane.add(btnNewButton_1);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(55, 221, 330, 32);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\DELL\\Desktop\\java\u8BFE\u7A0B\u8BBE\u8BA1\\photo sourse\\VCG21e070ced19-KKN.jpg"));
		lblNewLabel_2.setBounds(10, 10, 426, 243);
		contentPane.add(lblNewLabel_2);
	}

}
