package com.main.view.student;

import com.main.dao.StudentDao;
import com.main.model.Student;
import com.main.util.LimitedDocument;
import com.main.view.IndexFrame;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyVetoException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * @author Lonely_Fantasy
 * @version 创建时间：2021年6月17日 下午1:37:53
 * 类说明
 */
public class StudentListFrame extends JInternalFrame {
    private JTable studentList;
    private JTextField studentNameText;
    private JTextField studentGradeText;
    private JTextField studentSecondaryText;
    private JTextField studentAgeText;
    private JTextField studentMajorText;
    private JTextField studentClassNameText;
    private JTextField studentIdText;
    private JButton editButton;
    private JButton deleteButton;
    private JRadioButton maleRadioBtn;
    private JRadioButton femaleRadioBtn;
    public JLabel count_label;//数量的标签设定
    private DefaultTableModel dtm = null;


    /**
     * Create the frame.
     */
    public StudentListFrame() {
        setFrameIcon(new ImageIcon(StudentListFrame.class.getResource("/images/menu.png")));
        setTitle("学生列表");
        setBounds(100, 100, 940, 700);
        setIconifiable(true);
        setClosable(true);
        getContentPane().setLayout(null);


        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 10, 904, 500);
        getContentPane().add(scrollPane);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());//给每行加线条
        studentList = new JTable();
        studentList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                selectRow();
            }
        });


        studentList.setFont(new Font("微软雅黑", Font.BOLD, 14));

        //表格属性
        studentList.setBackground(new Color(230, 230, 255));//表背景属性
        studentList.getTableHeader().setReorderingAllowed(false);//表头不可拖动
        studentList.setRowHeight(30);//表格高度
        studentList.setShowGrid(false);
        studentList.setShowHorizontalLines(false);

        //表格文字居中
        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
        renderer.setHorizontalAlignment(JLabel.CENTER);
        studentList.setDefaultRenderer(Object.class, renderer);


        studentList.setModel(new DefaultTableModel(
                                     new Object[][]{
                                     },
                                     new String[]{
                                             "\u5B66\u53F7", "\u5E74\u7EA7", "\u59D3\u540D", "\u6027\u522B", "\u5E74\u9F84", "\u73ED\u7EA7", "\u5B66\u9662", "\u4E13\u4E1A"
                                     }
                             ) {
                                 //设置表中内容不可编辑状态（重写方法）
                                 public boolean isCellEditable(int row, int column) {
                                     return false;
                                 }
                             }
        );
        studentList.getColumnModel().getColumn(0).setPreferredWidth(100);
        studentList.getColumnModel().getColumn(0).setMinWidth(100);
        studentList.getColumnModel().getColumn(0).setMaxWidth(100);
        studentList.getColumnModel().getColumn(1).setPreferredWidth(91);
        studentList.getColumnModel().getColumn(1).setMinWidth(91);
        studentList.getColumnModel().getColumn(1).setMaxWidth(91);
        studentList.getColumnModel().getColumn(2).setPreferredWidth(95);
        studentList.getColumnModel().getColumn(2).setMinWidth(95);
        studentList.getColumnModel().getColumn(2).setMaxWidth(95);
        studentList.getColumnModel().getColumn(3).setPreferredWidth(91);
        studentList.getColumnModel().getColumn(3).setMinWidth(91);
        studentList.getColumnModel().getColumn(3).setMaxWidth(91);
        studentList.getColumnModel().getColumn(4).setPreferredWidth(91);
        studentList.getColumnModel().getColumn(4).setMinWidth(91);
        studentList.getColumnModel().getColumn(4).setMaxWidth(91);
        studentList.getColumnModel().getColumn(5).setPreferredWidth(91);
        studentList.getColumnModel().getColumn(5).setMinWidth(91);
        studentList.getColumnModel().getColumn(5).setMaxWidth(91);
        studentList.getColumnModel().getColumn(6).setPreferredWidth(170);
        studentList.getColumnModel().getColumn(6).setMinWidth(170);
        studentList.getColumnModel().getColumn(6).setMaxWidth(170);
        studentList.getColumnModel().getColumn(7).setPreferredWidth(170);
        studentList.getColumnModel().getColumn(7).setMinWidth(170);
        studentList.getColumnModel().getColumn(7).setMaxWidth(170);
        scrollPane.setViewportView(studentList);

        JLabel lblNewLabel = new JLabel("学生姓名");
        lblNewLabel.setIcon(new ImageIcon(StudentListFrame.class.getResource("/images/user.png")));
        lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        lblNewLabel.setBounds(10, 520, 81, 25);
        getContentPane().add(lblNewLabel);

        studentNameText = new JTextField();
        studentNameText.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        studentNameText.setColumns(10);
        studentNameText.setBounds(101, 520, 105, 25);
        getContentPane().add(studentNameText);

        JLabel lblNewLabel_1_1 = new JLabel("年龄");
        lblNewLabel_1_1.setIcon(new ImageIcon(StudentListFrame.class.getResource("/images/editor.png")));
        lblNewLabel_1_1.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        lblNewLabel_1_1.setBounds(486, 520, 81, 25);
        getContentPane().add(lblNewLabel_1_1);

        JLabel lblNewLabel_1 = new JLabel("所属年级");
        lblNewLabel_1.setIcon(new ImageIcon(StudentListFrame.class.getResource("/images/layers.png")));
        lblNewLabel_1.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        lblNewLabel_1.setBounds(10, 576, 81, 25);
        getContentPane().add(lblNewLabel_1);

        studentGradeText = new JTextField();
        studentGradeText.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        studentGradeText.setColumns(10);
        studentGradeText.setBounds(100, 575, 105, 25);
        getContentPane().add(studentGradeText);

        JLabel lblNewLabel_1_2 = new JLabel("所属学院");
        lblNewLabel_1_2.setIcon(new ImageIcon(StudentListFrame.class.getResource("/images/company.png")));
        lblNewLabel_1_2.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        lblNewLabel_1_2.setBounds(228, 576, 81, 25);
        getContentPane().add(lblNewLabel_1_2);

        studentSecondaryText = new JTextField();
        studentSecondaryText.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        studentSecondaryText.setColumns(10);
        studentSecondaryText.setBounds(327, 575, 136, 25);
        getContentPane().add(studentSecondaryText);

        JLabel lblNewLabel_1_2_1 = new JLabel("所属专业");
        lblNewLabel_1_2_1.setIcon(new ImageIcon(StudentListFrame.class.getResource("/images/feeds.png")));
        lblNewLabel_1_2_1.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        lblNewLabel_1_2_1.setBounds(486, 575, 81, 25);
        getContentPane().add(lblNewLabel_1_2_1);

        JLabel lblNewLabel_1_2_1_1 = new JLabel("性别");
        lblNewLabel_1_2_1_1.setIcon(new ImageIcon(StudentListFrame.class.getResource("/images/sex-symbol.png")));
        lblNewLabel_1_2_1_1.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        lblNewLabel_1_2_1_1.setBounds(228, 520, 81, 25);
        getContentPane().add(lblNewLabel_1_2_1_1);

        studentAgeText = new JTextField();
        studentAgeText.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        studentAgeText.setColumns(10);
        studentAgeText.setBounds(577, 520, 105, 25);
        getContentPane().add(studentAgeText);
        //调用重写的工具类，设置文本框只能输入数字
        LimitedDocument ld = new LimitedDocument(2);//参数为能输入的最大长度
        ld.setAllowChar("0123456789");//只能输入的字符
        studentAgeText.setDocument(ld);

        studentMajorText = new JTextField();
        studentMajorText.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        studentMajorText.setColumns(10);
        studentMajorText.setBounds(577, 576, 136, 25);
        getContentPane().add(studentMajorText);

        JLabel lblNewLabel_1_1_1 = new JLabel("班级名");
        lblNewLabel_1_1_1.setIcon(new ImageIcon(StudentListFrame.class.getResource("/images/Customermanagement.png")));
        lblNewLabel_1_1_1.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        lblNewLabel_1_1_1.setBounds(706, 520, 81, 25);
        getContentPane().add(lblNewLabel_1_1_1);

        studentClassNameText = new JTextField();
        studentClassNameText.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        studentClassNameText.setColumns(10);
        studentClassNameText.setBounds(797, 520, 105, 25);
        getContentPane().add(studentClassNameText);

        JLabel lblNewLabel_2 = new JLabel("学号");
        lblNewLabel_2.setIcon(new ImageIcon(StudentListFrame.class.getResource("/images/namecard.png")));
        lblNewLabel_2.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        lblNewLabel_2.setBounds(10, 624, 81, 25);
        getContentPane().add(lblNewLabel_2);

        studentIdText = new JTextField();
        studentIdText.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        studentIdText.setColumns(10);
        studentIdText.setBounds(100, 623, 105, 25);
        getContentPane().add(studentIdText);

        editButton = new JButton("编辑");
        editButton.addActionListener(e -> editStudentInfo());
        editButton.setIcon(new ImageIcon(StudentListFrame.class.getResource("/images/editor.png")));
        editButton.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        editButton.setBounds(549, 624, 93, 25);
        getContentPane().add(editButton);

        JButton btnNewButton_1 = new JButton("搜索");
        btnNewButton_1.addActionListener(e -> queryButton());
        btnNewButton_1.setIcon(new ImageIcon(StudentListFrame.class.getResource("/images/search.png")));
        btnNewButton_1.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        btnNewButton_1.setBounds(416, 624, 93, 25);
        getContentPane().add(btnNewButton_1);

        JButton btnNewButton_2 = new JButton("清空");
        btnNewButton_2.setIcon(new ImageIcon(StudentListFrame.class.getResource("/images/exit.png")));
        btnNewButton_2.addActionListener(e -> resetButton());
        btnNewButton_2.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        btnNewButton_2.setBounds(678, 624, 93, 25);
        getContentPane().add(btnNewButton_2);

        deleteButton = new JButton("删除");
        deleteButton.addActionListener(e -> deleteButton());
        deleteButton.setIcon(new ImageIcon(StudentListFrame.class.getResource("/images/ashbin-fill.png")));
        deleteButton.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        deleteButton.setBounds(809, 624, 93, 25);
        deleteButton.setFocusPainted(false);//取消按钮虚线
        getContentPane().add(deleteButton);

        maleRadioBtn = new JRadioButton("男");
        maleRadioBtn.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        maleRadioBtn.setBounds(327, 522, 42, 23);
        getContentPane().add(maleRadioBtn);

        femaleRadioBtn = new JRadioButton("女");
        femaleRadioBtn.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        femaleRadioBtn.setBounds(385, 522, 42, 23);
        getContentPane().add(femaleRadioBtn);

        //取消点击显示虚线框
        btnNewButton_1.setFocusable(false);
        btnNewButton_2.setFocusable(false);
        editButton.setFocusable(false);
        femaleRadioBtn.setFocusable(false);
        maleRadioBtn.setFocusable(false);
        deleteButton.setFocusable(false);

        count_label = new JLabel("");
        count_label.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        count_label.setBounds(226, 611, 100, 38);
        count_label.setText(label_string());
        getContentPane().add(count_label);

        dtm = (DefaultTableModel) this.studentList.getModel();
        queryAllStudent();
    }

    //编辑学生信息按钮事件
    protected void editStudentInfo() {
        // TODO Auto-generated method stub

        //获取选择带学生的信息
        Student tempStudent = new Student();
        tempStudent.setId(dtm.getValueAt(studentList.getSelectedRow(), 0).toString());
        tempStudent.setGrade(dtm.getValueAt(studentList.getSelectedRow(), 1).toString());
        tempStudent.setName(dtm.getValueAt(studentList.getSelectedRow(), 2).toString());
        String sexString = "";
        if ("男".equals(dtm.getValueAt(studentList.getSelectedRow(), 3).toString())) {
            sexString = "男";
        } else {
            sexString = "女";
        }
        tempStudent.setSex(sexString);
        int ages = Integer.parseInt(dtm.getValueAt(studentList.getSelectedRow(), 4).toString());//年龄转换Int类型
        tempStudent.setAge(ages);
        tempStudent.setClassName(dtm.getValueAt(studentList.getSelectedRow(), 5).toString());
        tempStudent.setSecondary(dtm.getValueAt(studentList.getSelectedRow(), 6).toString());
        tempStudent.setMajor(dtm.getValueAt(studentList.getSelectedRow(), 7).toString());
//		new StudentDao().querySomeStudent(tempStudent); 
        tempStudent.setClassId(new StudentDao().queryStudentClassId(tempStudent.getId()));//将查询到的id传入到tempStudent
        if (IndexFrame.addStudentFrame == null) {
            IndexFrame.addStudentFrame = new AddStudentFrame();
            IndexFrame.desktopPane.add(IndexFrame.addStudentFrame);
        }
        IndexFrame.addStudentFrame.editStudentInfo(tempStudent);
        IndexFrame.addStudentFrame.setVisible(true);
        //保持窗体最前
        try {
            IndexFrame.addStudentFrame.setSelected(true);
        } catch (PropertyVetoException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


    //删除学生信息按钮事件
    protected void deleteButton() {
        // TODO Auto-generated method stub
        String idString = dtm.getValueAt(studentList.getSelectedRow(), 0).toString();//获取选中学生的id
        JOptionPane.showMessageDialog(this, new StudentDao().deleteStudent(idString));//调用StudentDao层中删除学生的方法
        count_label.setText(label_string());
        queryAllStudent();//删除与否都刷新全表
    }

    //点击表格获取当前行数的学生信息
    protected void selectRow() {
        // TODO Auto-generated method stub
        studentIdText.setText(dtm.getValueAt(studentList.getSelectedRow(), 0).toString());
        studentNameText.setText(dtm.getValueAt(studentList.getSelectedRow(), 2).toString());
        studentAgeText.setText(dtm.getValueAt(studentList.getSelectedRow(), 4).toString());
        studentGradeText.setText(dtm.getValueAt(studentList.getSelectedRow(), 1).toString());
        studentSecondaryText.setText(dtm.getValueAt(studentList.getSelectedRow(), 6).toString());
        studentMajorText.setText(dtm.getValueAt(studentList.getSelectedRow(), 7).toString());
        studentClassNameText.setText(dtm.getValueAt(studentList.getSelectedRow(), 5).toString());
        if ("男".equals(dtm.getValueAt(studentList.getSelectedRow(), 3).toString())) {
            this.maleRadioBtn.setSelected(true);
            this.femaleRadioBtn.setSelected(false);
        } else {
            this.maleRadioBtn.setSelected(false);
            this.femaleRadioBtn.setSelected(true);
        }
        //设置编辑删除按钮可点击
        this.editButton.setEnabled(true);
        this.deleteButton.setEnabled(true);
    }

    //搜索按钮
    protected void queryButton() {
        // TODO Auto-generated method stub
        Student tempStudent = new Student();
        //获取编辑框内内容
        tempStudent.setId(studentIdText.getText());
        tempStudent.setName(studentNameText.getText());
        System.out.println(studentAgeText.getText().isEmpty());
        if (!studentAgeText.getText().isEmpty()) {
            int ages = Integer.parseInt(studentAgeText.getText());//年龄转换Int类型
            tempStudent.setAge(ages);
        } else {//设置int类型Age为-1
            tempStudent.setAge(-1);
        }

        tempStudent.setClassName(studentClassNameText.getText());
        tempStudent.setGrade(studentGradeText.getText());
        tempStudent.setSecondary(studentSecondaryText.getText());
        tempStudent.setMajor(studentMajorText.getText());
        String sexString;
        if (maleRadioBtn.isSelected() && !femaleRadioBtn.isSelected()) {
            sexString = "男";
        } else if (!maleRadioBtn.isSelected() && femaleRadioBtn.isSelected()) {
            sexString = "女";
        } else {
            sexString = "";
        }
        tempStudent.setSex(sexString);
        new StudentDao().querySomeStudent(tempStudent);
        ArrayList<Student> attArrayList = new StudentDao().querySomeStudent(tempStudent);

        dtm.setRowCount(0);
        for (Student stu : attArrayList) {
            Vector v = new Vector();
            v.add(stu.getId());
            v.add(stu.getGrade());
            v.add(stu.getName());
            v.add(stu.getSex());
            v.add(stu.getAge());
            v.add(stu.getClassName());
            v.add(stu.getSecondary());
            v.add(stu.getMajor());
            dtm.addRow(v);
        }
        //按钮默认设置不可点击
        this.editButton.setEnabled(false);
        this.deleteButton.setEnabled(false);

    }

    //获取整表内容
    public void queryAllStudent() {
        dtm.setRowCount(0);

        List<Student> allStudentList = new StudentDao().queryAllStudent();

        for (Student stu : allStudentList) {
            Vector v = new Vector();
            v.add(stu.getId());
            v.add(stu.getGrade());
            v.add(stu.getName());
            v.add(stu.getSex());
            v.add(stu.getAge());
            v.add(stu.getClassName());
            v.add(stu.getSecondary());
            v.add(stu.getMajor());
            dtm.addRow(v);
        }
        //按钮默认设置不可点击
        this.editButton.setEnabled(false);
        this.deleteButton.setEnabled(false);
    }

    //重置输入框
    protected void resetButton() {
        // TODO Auto-generated method stub
        studentIdText.setText("");
        studentNameText.setText("");
        studentAgeText.setText("");
        studentGradeText.setText("");
        studentSecondaryText.setText("");
        studentMajorText.setText("");
        studentClassNameText.setText("");
        this.maleRadioBtn.setSelected(false);
        this.femaleRadioBtn.setSelected(false);

    }

    //重写这个窗体的关闭按键方法，防止窗口重复出现
    public void doDefaultCloseAction() {
        setVisible(false);
        resetButton();
    }

    public int student_count()//计算班级数量的函数
    {
        StudentDao studentDao = new StudentDao();
        ArrayList<Student> student_count = studentDao.queryAllStudent();

        return student_count.size();
    }

    public String label_string() {
        int a = student_count();
        return "总学生数量：" + a;
    }
}
