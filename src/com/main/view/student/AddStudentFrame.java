package com.main.view.student;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
* @author Lonely_Fantasy 
* @version 创建时间：2021年6月17日 上午11:05:44
* 类说明
*/
public class AddStudentFrame extends JInternalFrame {
	private JTextField studentName;
	private JTextField studentAge;
	private JRadioButton maleRadioBtn;
	private JRadioButton femaleRadioBtn;
	private JLabel studentClassId;
	private JComboBox studentGradeComb;
	private JComboBox studentSecondaryComb;
	private JComboBox studentClassComb;
	private JComboBox studentMajorComb;

	

	/**
	 * Create the frame.
	 */
	public AddStudentFrame() {
		setFrameIcon(new ImageIcon(AddStudentFrame.class.getResource("/images/add-circle.png")));
		setTitle("添加学生");
		setBounds(100, 100, 500, 520);
		getContentPane().setLayout(null);
		setIconifiable(true);//最小化
		setClosable(true);
		
		JLabel lblNewLabel_1 = new JLabel("学生姓名");
		lblNewLabel_1.setIcon(new ImageIcon(AddStudentFrame.class.getResource("/images/user.png")));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(51, 61, 84, 25);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("所属年级");
		lblNewLabel_1_1.setIcon(new ImageIcon(AddStudentFrame.class.getResource("/images/layers.png")));
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_1.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(51, 125, 84, 25);
		getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("所属学院");
		lblNewLabel_1_1_1.setIcon(new ImageIcon(AddStudentFrame.class.getResource("/images/company.png")));
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_1_1.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		lblNewLabel_1_1_1.setBounds(51, 188, 84, 25);
		getContentPane().add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("学生性别");
		lblNewLabel_1_2.setIcon(new ImageIcon(AddStudentFrame.class.getResource("/images/sex-symbol.png")));
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_2.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		lblNewLabel_1_2.setBounds(252, 61, 84, 25);
		getContentPane().add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("学生年龄");
		lblNewLabel_1_1_2.setIcon(new ImageIcon(AddStudentFrame.class.getResource("/images/browse.png")));
		lblNewLabel_1_1_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_1_2.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		lblNewLabel_1_1_2.setBounds(252, 125, 84, 25);
		getContentPane().add(lblNewLabel_1_1_2);
		
		JLabel lblNewLabel_1_1_3 = new JLabel("所属专业");
		lblNewLabel_1_1_3.setIcon(new ImageIcon(AddStudentFrame.class.getResource("/images/feeds.png")));
		lblNewLabel_1_1_3.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_1_3.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		lblNewLabel_1_1_3.setBounds(51, 246, 84, 25);
		getContentPane().add(lblNewLabel_1_1_3);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("所属班级");
		lblNewLabel_1_1_1_1.setIcon(new ImageIcon(AddStudentFrame.class.getResource("/images/Customermanagement.png")));
		lblNewLabel_1_1_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_1_1_1.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		lblNewLabel_1_1_1_1.setBounds(51, 308, 84, 25);
		getContentPane().add(lblNewLabel_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_2 = new JLabel("班级编号");
		lblNewLabel_1_1_1_2.setIcon(new ImageIcon(AddStudentFrame.class.getResource("/images/editor.png")));
		lblNewLabel_1_1_1_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_1_1_2.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		lblNewLabel_1_1_1_2.setBounds(51, 367, 84, 25);
		getContentPane().add(lblNewLabel_1_1_1_2);
		
		studentName = new JTextField();
		studentName.setBounds(138, 61, 92, 25);
		getContentPane().add(studentName);
		studentName.setColumns(10);
		
		studentAge = new JTextField();
		studentAge.setColumns(10);
		studentAge.setBounds(346, 125, 92, 25);
		getContentPane().add(studentAge);
		
		studentGradeComb = new JComboBox();
		studentGradeComb.setBounds(138, 125, 92, 25);
		getContentPane().add(studentGradeComb);
		
		studentSecondaryComb = new JComboBox();
		studentSecondaryComb.setBounds(138, 188, 198, 25);
		getContentPane().add(studentSecondaryComb);
		
		studentClassComb = new JComboBox();
		studentClassComb.setBounds(138, 308, 198, 25);
		getContentPane().add(studentClassComb);
		
		studentMajorComb = new JComboBox();
		studentMajorComb.setBounds(138, 246, 198, 25);
		getContentPane().add(studentMajorComb);
		
		maleRadioBtn = new JRadioButton("男");
		maleRadioBtn.setBounds(338, 61, 42, 23);
		getContentPane().add(maleRadioBtn);
		
		femaleRadioBtn = new JRadioButton("女");
		femaleRadioBtn.setBounds(396, 61, 42, 23);
		getContentPane().add(femaleRadioBtn);
		
		studentClassId = new JLabel("测试显示");
		studentClassId.setHorizontalAlignment(SwingConstants.LEFT);
		studentClassId.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		studentClassId.setBounds(145, 367, 84, 25);
		getContentPane().add(studentClassId);
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(femaleRadioBtn);
		bg.add(maleRadioBtn);
		
		
		JButton btnNewButton = new JButton("添加");
		btnNewButton.setIcon(new ImageIcon(AddStudentFrame.class.getResource("/images/login.png")));
		btnNewButton.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		btnNewButton.setBounds(51, 423, 109, 38);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("重置");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetButton();
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(AddStudentFrame.class.getResource("/images/exit.png")));
		btnNewButton_1.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		btnNewButton_1.setBounds(329, 423, 109, 38);
		getContentPane().add(btnNewButton_1);

	}
	
	
    protected void resetButton() {
		// TODO Auto-generated method stub
		
	}


	//重写这个窗体的关闭按键方法，防止窗口重复出现
    public void doDefaultCloseAction() {
        setVisible(false);
        resetButton();
    }
}
