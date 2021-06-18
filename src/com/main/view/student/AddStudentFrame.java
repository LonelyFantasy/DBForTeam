package com.main.view.student;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;

import com.main.dao.ClassDao;
import com.main.dao.StudentDao;
import com.main.model.Student;
import com.main.model.StudentClass;
import com.main.util.CollegeStructure;
import com.main.util.LimitedDocument;
import com.main.util.StringUtil;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Color;

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
	private ArrayList<StudentClass> arrayClass = null;

	
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
		LimitedDocument ld = new LimitedDocument(2);//参数为能输入的最大长度
		ld.setAllowChar("0123456789");//只能输入的字符
		studentAge.setDocument(ld);//应用字符限制
		
		studentGradeComb = new JComboBox(CollegeStructure.gradeString);
		studentGradeComb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setStduentClass();
			}
		});
		studentGradeComb.setBounds(138, 125, 92, 25);
		getContentPane().add(studentGradeComb);
		
		studentSecondaryComb = new JComboBox(CollegeStructure.secondaryString);
		studentSecondaryComb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddStudentFrame.this.studentMajorComb.setModel(new DefaultComboBoxModel(CollegeStructure.major[studentSecondaryComb.getSelectedIndex()]));
				setStduentClass();
			}
		});
		studentSecondaryComb.setBounds(138, 188, 198, 25);
		getContentPane().add(studentSecondaryComb);
		
		studentMajorComb = new JComboBox(CollegeStructure.major[0]);
		studentMajorComb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setStduentClass();
			}
		});
		studentMajorComb.setBounds(138, 246, 198, 25);
		getContentPane().add(studentMajorComb);
			
		ClassDao classDao = new ClassDao();
		this.arrayClass = classDao.querySomeClass(studentGradeComb.getSelectedItem().toString(), studentSecondaryComb.getSelectedItem().toString(), studentMajorComb.getSelectedItem().toString());
		//打开窗口时即做判断，判断默认年级下有无班级信息
		if(this.arrayClass.isEmpty()) {
			studentClassComb = new JComboBox();
			studentClassComb.setEnabled(false);
			studentClassId = new JLabel("暂无班级信息");
		}
		else {
			studentClassComb = new JComboBox(this.arrayClass.toArray());
			studentClassId = new JLabel(arrayClass.get(0).getId());
		}
		studentClassComb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddStudentFrame.this.studentClassId.setText(arrayClass.get(studentClassComb.getSelectedIndex()).getId());
				
			}
		});
		if(this.arrayClass.isEmpty()) {
			studentClassComb.setEnabled(false);//当无法查询到班级时，班级选择栏的编辑状态为false
		}
		studentClassComb.setBounds(138, 308, 198, 25);
		getContentPane().add(studentClassComb);
		

		
		maleRadioBtn = new JRadioButton("男");
		maleRadioBtn.setSelected(true);//默认下为男性
		maleRadioBtn.setBounds(338, 61, 42, 23);
		getContentPane().add(maleRadioBtn);
		
		femaleRadioBtn = new JRadioButton("女");
		femaleRadioBtn.setBounds(396, 61, 42, 23);
		getContentPane().add(femaleRadioBtn);
		
		studentClassId = new JLabel(arrayClass.get(0).getId());
		studentClassId.setForeground(Color.RED);
		studentClassId.setHorizontalAlignment(SwingConstants.LEFT);
		studentClassId.setFont(new Font("微软雅黑", Font.BOLD, 14));
		studentClassId.setBounds(145, 367, 84, 25);
		getContentPane().add(studentClassId);
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(femaleRadioBtn);
		bg.add(maleRadioBtn);
		
		
		JButton btnNewButton = new JButton("添加");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				confirmButton();
			}
		});
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

		//取消按钮焦点
		btnNewButton.setFocusable(false);
		btnNewButton_1.setFocusable(false);
		
		
	}
	
	//提交添加学生信息按钮
	protected void confirmButton() {
		// TODO Auto-generated method stub
		String classIdString = this.studentClassId.getText();
		
		String nameString = this.studentName.getText();
		//判断姓名框是否为空
		if(StringUtil.isEmpty(nameString)) {
			JOptionPane.showMessageDialog(this, "学生姓名不能为空！");
			return;
		}
		
		//判断年龄是否为空
		if(StringUtil.isEmpty(studentAge.getText())) {
			JOptionPane.showMessageDialog(this, "学生年龄不能为空！");
			return;
		}
		int ages = Integer.parseInt(studentAge.getText());//年龄转换Int类型
		
		//判断当前班级是否已经选择
		if(!classIdString.matches("[0-9]*")){
			JOptionPane.showMessageDialog(this, "班级未选择，请重新选择班级！");
			return;
		}
		
		//此处防止在添加过程中如果选择的班级突然被删除的情况
		if(new ClassDao().querySomeClass(classIdString) == false) {//查询班级的新方法
			JOptionPane.showMessageDialog(this, "查无此班级，请重新选择班级！");
			resetButton();//实时刷新班级
			return;
		}
		
		String classNameString = this.studentClassComb.getSelectedItem().toString();//获取班级名字
		String idString = classIdString;//获取班级id
		String gradeString = this.studentGradeComb.getSelectedItem().toString();//获取年级

		String sexString = "男";
		if(this.femaleRadioBtn.isSelected())
			sexString = "女";

		String majorString = this.studentMajorComb.getSelectedItem().toString();
		String  secondaryString = this.studentSecondaryComb.getSelectedItem().toString();
		Student tempStudent = new Student(idString, nameString, ages, gradeString, classIdString, classNameString, sexString, majorString, secondaryString);
		JOptionPane.showMessageDialog(this, new StudentDao().addStudentInfo(tempStudent));
	}

	//点击ComBoBox后更新班级选择事件
    protected void setStduentClass() {
		// TODO Auto-generated method stub
		ClassDao classDao = new ClassDao();
		this.arrayClass = classDao.querySomeClass(studentGradeComb.getSelectedItem().toString(), studentSecondaryComb.getSelectedItem().toString(), studentMajorComb.getSelectedItem().toString());
		this.studentClassId.setText("暂无班级信息");
		if(arrayClass.isEmpty()) {
			this.studentClassComb.setEnabled(false);
		}
		else {//返回结果非空的时候执行读取设置操作		
			this.studentClassId.setText(this.arrayClass.get(0).getId());
			this.studentClassComb.setEnabled(true);
		}
		this.studentClassComb.setModel(new DefaultComboBoxModel(this.arrayClass.toArray()));

		
	}

    //重置按钮
	protected void resetButton() {
		// TODO Auto-generated method stub
		studentName.setText("");
		this.maleRadioBtn.setSelected(true);
		studentGradeComb.setSelectedIndex(0);
		studentSecondaryComb.setSelectedIndex(0);
		studentAge.setText("");
		studentMajorComb.setModel(new DefaultComboBoxModel(CollegeStructure.major[0]));
		ClassDao classDao = new ClassDao();
		this.arrayClass = classDao.querySomeClass(studentGradeComb.getSelectedItem().toString(), studentSecondaryComb.getSelectedItem().toString(), studentMajorComb.getSelectedItem().toString());
		//重置即做判断，判断默认年级下有无班级信息
		if(this.arrayClass.isEmpty()) {
			this.studentClassComb.setEnabled(false);
			this.studentClassId.setText("暂无此班信息");
		}else {
			this.studentClassComb.setModel(new DefaultComboBoxModel(arrayClass.toArray()));
			this.studentClassId.setText(arrayClass.get(0).getId());
		}
		
	}


	//重写这个窗体的关闭按键方法，防止窗口重复出现
    public void doDefaultCloseAction() {
        setVisible(false);
        resetButton();
    }
}
