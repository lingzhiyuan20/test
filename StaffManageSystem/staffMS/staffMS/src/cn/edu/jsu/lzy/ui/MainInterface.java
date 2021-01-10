package staffMS.src.cn.edu.jsu.lzy.ui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MainInterface {

	JFrame frame;

	/**
	 * Launch the application.系统主界面
	 * @param
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainInterface window = new MainInterface();
					window.frame.setLocationRelativeTo(null);// 窗体居中
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
 
	/**
	 * Create the application.
	 */
	public MainInterface() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() { 
		frame = new JFrame();
		frame.setFont(new Font("Dialog", Font.PLAIN, 20));
		frame.setTitle("\u5458\u5DE5\u7BA1\u7406\u754C\u9762");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u754C\u9762\u529F\u80FD");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		lblNewLabel.setBounds(43, 28, 97, 30);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("\u589E\u52A0\u6570\u636E");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddDate frame = new AddDate();
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
				
			}
		});
		btnNewButton.setBounds(69, 85, 97, 23); 
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u641C\u7D22\u6570\u636E");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SelectDate frame = new SelectDate();
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(242, 85, 97, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("\u5220\u9664\u6570\u636E");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DelectDate frame = new DelectDate();
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
				
			}
		});
		btnNewButton_2.setBounds(69, 161, 97, 23);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("\u4FEE\u6539\u6570\u636E");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UpadateDate frame = new UpadateDate();
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
			}
		});
		btnNewButton_3.setBounds(242, 161, 97, 23);
		frame.getContentPane().add(btnNewButton_3);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\DELL\\Desktop\\java\u8BFE\u7A0B\u8BBE\u8BA1\\photo sourse\\VCG21gic17132245.jpg"));
		lblNewLabel_1.setBounds(10, 0, 416, 263);
		frame.getContentPane().add(lblNewLabel_1);
	}

}
