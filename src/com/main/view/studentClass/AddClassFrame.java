package com.main.view.studentClass;

import com.main.dao.ClassDao;
import com.main.model.StudentClass;
import com.main.util.CollegeStructure;
import com.main.view.IndexFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Objects;

/**
 * @author Lonely_Fantasy
 * @version 创建时间：2021年6月13日 上午1:08:46
 * 类说明
 */
public class AddClassFrame extends JInternalFrame {
    private JTextField classNameText;
    private JComboBox classGradeComb;
    private JComboBox classMajorComb;
    private JComboBox classSecondaryComb;
    private JTextArea classInfoText;


    /**
     * Create the frame.
     */
    public AddClassFrame() {
        setFrameIcon(new ImageIcon(AddClassFrame.class.getResource("/images/add-circle.png")));
        setIconifiable(true);//最小化
        setTitle("\u6DFB\u52A0\u73ED\u7EA7");
        setBounds(100, 100, 650, 400);
        getContentPane().setLayout(null);
        setClosable(true);

        JLabel lblNewLabel_1 = new JLabel("\u73ED\u7EA7\u540D\u79F0");
        lblNewLabel_1.setIcon(new ImageIcon(AddClassFrame.class.getResource("/images/Customermanagement.png")));
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
        lblNewLabel_1.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        lblNewLabel_1.setBounds(70, 52, 84, 25);
        getContentPane().add(lblNewLabel_1);

        JLabel lblNewLabel_1_1 = new JLabel("\u6240\u5C5E\u5E74\u7EA7");
        lblNewLabel_1_1.setIcon(new ImageIcon(AddClassFrame.class.getResource("/images/layers.png")));
        lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.LEFT);
        lblNewLabel_1_1.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        lblNewLabel_1_1.setBounds(327, 52, 82, 25);
        getContentPane().add(lblNewLabel_1_1);

        JLabel lblNewLabel_1_2 = new JLabel("\u6240\u5C5E\u5B66\u9662");
        lblNewLabel_1_2.setIcon(new ImageIcon(AddClassFrame.class.getResource("/images/company.png")));
        lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.LEFT);
        lblNewLabel_1_2.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        lblNewLabel_1_2.setBounds(70, 112, 84, 25);
        getContentPane().add(lblNewLabel_1_2);

        JLabel lblNewLabel_1_3 = new JLabel("\u6240\u5C5E\u4E13\u4E1A");
        lblNewLabel_1_3.setIcon(new ImageIcon(AddClassFrame.class.getResource("/images/feeds.png")));
        lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.LEFT);
        lblNewLabel_1_3.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        lblNewLabel_1_3.setBounds(327, 112, 82, 25);
        getContentPane().add(lblNewLabel_1_3);

        JLabel lblNewLabel_1_4 = new JLabel("\u73ED\u7EA7\u4FE1\u606F");
        lblNewLabel_1_4.setIcon(new ImageIcon(AddClassFrame.class.getResource("/images/namecard.png")));
        lblNewLabel_1_4.setHorizontalAlignment(SwingConstants.LEFT);
        lblNewLabel_1_4.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        lblNewLabel_1_4.setBounds(70, 176, 84, 25);
        getContentPane().add(lblNewLabel_1_4);

        classNameText = new JTextField();
        classNameText.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        classNameText.setBounds(164, 52, 143, 25);
        getContentPane().add(classNameText);
        classNameText.setColumns(10);

        classGradeComb = new JComboBox(new DefaultComboBoxModel(CollegeStructure.gradeString));
        classGradeComb.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        classGradeComb.setBounds(430, 52, 143, 25);
        getContentPane().add(classGradeComb);

        classMajorComb = new JComboBox(new DefaultComboBoxModel(CollegeStructure.major[0]));
        classMajorComb.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        classMajorComb.setBounds(430, 112, 143, 25);
        getContentPane().add(classMajorComb);

        classSecondaryComb = new JComboBox(new DefaultComboBoxModel(CollegeStructure.secondaryString));
        classSecondaryComb.addActionListener(e -> {//点击不同的学院显示出不同的专业
            AddClassFrame.this.classMajorComb.setModel(new DefaultComboBoxModel(CollegeStructure.major[AddClassFrame.this.classSecondaryComb.getSelectedIndex()]));
        });
        classSecondaryComb.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        classSecondaryComb.setBounds(164, 112, 143, 25);
        getContentPane().add(classSecondaryComb);

        classInfoText = new JTextArea();
        classInfoText.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        classInfoText.setBounds(164, 176, 409, 107);
        getContentPane().add(classInfoText);
        classInfoText.setLineWrap(true);
        classInfoText.setText("\u8FD9\u4E2A\u73ED\u7EA7\u5F88\u61D2\uFF0C\u4EC0\u4E48\u4FE1\u606F\u90FD\u6CA1\u7559\u4E0B\u3002");

        JButton btnNewButton = new JButton("\u6DFB\u52A0");
        btnNewButton.addActionListener(this::addClassButton);
        btnNewButton.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        btnNewButton.setIcon(new ImageIcon(AddClassFrame.class.getResource("/images/login.png")));
        btnNewButton.setBounds(70, 308, 109, 38);
        btnNewButton.setFocusPainted(false);//取消按钮虚线
        getContentPane().add(btnNewButton);

        JButton btnNewButton_1 = new JButton("\u91CD\u7F6E");
        btnNewButton_1.addActionListener(ae -> resetButton());
        btnNewButton_1.setIcon(new ImageIcon(AddClassFrame.class.getResource("/images/exit.png")));
        btnNewButton_1.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        btnNewButton_1.setBounds(464, 308, 109, 38);
        btnNewButton_1.setFocusPainted(false);//取消按钮虚线
        getContentPane().add(btnNewButton_1);

    }

    //添加班级信息
    protected void addClassButton(ActionEvent ae) {
        // TODO Auto-generated method stub
        String name = this.classNameText.getText();
        String grade = Objects.requireNonNull(this.classGradeComb.getSelectedItem()).toString();
        String secondary = Objects.requireNonNull(this.classSecondaryComb.getSelectedItem()).toString();
        String major = Objects.requireNonNull(this.classMajorComb.getSelectedItem()).toString();
        String info = this.classInfoText.getText();

        //判断输入框是否填写内容
        if (classNameText.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "班级名称未输入！", "警告", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (classInfoText.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "班级信息未输入！", "警告", JOptionPane.WARNING_MESSAGE);
            return;
        }
        //班级编号生成
        String id = Integer.parseInt(grade) % 2000 + "00" + CollegeStructure.majorId[classSecondaryComb.getSelectedIndex()][classMajorComb.getSelectedIndex()];
        StudentClass tempClass = new StudentClass(id, grade, name, secondary, major, info);

        ClassDao classDao = new ClassDao();
        JOptionPane.showMessageDialog(this, classDao.addClass(tempClass));

        if (IndexFrame.classListFrame != null) {
            IndexFrame.classListFrame.queryAllClass();
            IndexFrame.classListFrame.class_label_count.setText(IndexFrame.classListFrame.label_string());//添加班级后重新刷新表格并自动统计班级数量
        }
        IndexFrame.classListFrame.class_label_count.setText(IndexFrame.classListFrame.label_string());
    }

    //重置内容按钮
    protected void resetButton() {
        // TODO Auto-generated method stub
        this.classInfoText.setText("");
        this.classGradeComb.setSelectedIndex(0);
        this.classSecondaryComb.setSelectedIndex(0);
        this.classMajorComb.setModel(new DefaultComboBoxModel(CollegeStructure.major[0]));
        this.classInfoText.setText("这个班级很懒，什么信息都没留下。");
    }

    //重写这个窗体的关闭按键方法，防止窗口重复出现
    public void doDefaultCloseAction() {
        setVisible(false);
        resetButton();
    }

}
