package com.main.view.studentClass;

import com.main.dao.ClassDao;
import com.main.model.StudentClass;
import com.main.view.IndexFrame;

import javax.swing.*;
import java.awt.*;

public class EditClassFrame extends JInternalFrame {
    private JTextField classNameText;
    private JTextArea classInfoText;

    public EditClassFrame(StudentClass studentClass) {
        setFrameIcon(new ImageIcon(AddClassFrame.class.getResource("/images/add-circle.png")));
        setIconifiable(true);//最小化
        setTitle("编辑班级");
        setBounds(100, 100, 650, 400);
        getContentPane().setLayout(null);
        setClosable(true);

        JLabel lblNewLabel_1 = new JLabel("班级名称");
        lblNewLabel_1.setIcon(new ImageIcon(AddClassFrame.class.getResource("/images/Customermanagement.png")));
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
        lblNewLabel_1.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        lblNewLabel_1.setBounds(70, 52, 84, 25);
        getContentPane().add(lblNewLabel_1);

        JLabel lblNewLabel_1_4 = new JLabel("\u73ED\u7EA7\u4FE1\u606F");
        lblNewLabel_1_4.setIcon(new ImageIcon(AddClassFrame.class.getResource("/images/namecard.png")));
        lblNewLabel_1_4.setHorizontalAlignment(SwingConstants.LEFT);
        lblNewLabel_1_4.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        lblNewLabel_1_4.setBounds(70, 110, 84, 25);
        getContentPane().add(lblNewLabel_1_4);

        classNameText = new JTextField();
        classNameText.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        classNameText.setBounds(164, 52, 143, 25);
        classNameText.setText(studentClass.getName());
        getContentPane().add(classNameText);
        classNameText.setColumns(10);

        classInfoText = new JTextArea();
        classInfoText.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        classInfoText.setBounds(164, 111, 409, 107);
        getContentPane().add(classInfoText);
        classInfoText.setLineWrap(true);
        classInfoText.setText(studentClass.getInfo());

        JButton btnNewButton = new JButton("编辑");
        btnNewButton.addActionListener(ae -> editbutton(studentClass));
        btnNewButton.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        btnNewButton.setIcon(new ImageIcon(AddClassFrame.class.getResource("/images/login.png")));
        btnNewButton.setBounds(70, 308, 109, 38);
        btnNewButton.setFocusPainted(false);//取消按钮虚线
        getContentPane().add(btnNewButton);

        JButton btnNewButton_1 = new JButton("重置");
        btnNewButton_1.addActionListener(ae -> resetButton(studentClass));
        btnNewButton_1.setIcon(new ImageIcon(AddClassFrame.class.getResource("/images/exit.png")));
        btnNewButton_1.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        btnNewButton_1.setBounds(464, 308, 109, 38);
        btnNewButton_1.setFocusPainted(false);//取消按钮虚线
        getContentPane().add(btnNewButton_1);
    }

    protected void editbutton(StudentClass studentClass) {
        if (classNameText.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "班级名称不能为空");
            return;
        }
        if (classInfoText.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "班级名称不能为空");
            return;
        }
        studentClass.setName(classNameText.getText());
        studentClass.setInfo(classInfoText.getText());
        JOptionPane.showMessageDialog(this, new ClassDao().editclassinfo(studentClass));

    }

    protected void resetButton(StudentClass studentClass) {
        classInfoText.setText(studentClass.getInfo());
        classNameText.setText(studentClass.getName());
    }

    //重写这个窗体的关闭按键方法，防止窗口重复出现
    public void doDefaultCloseAction() {
        setVisible(false);
        IndexFrame.editClassFrame = null;
    }
}
