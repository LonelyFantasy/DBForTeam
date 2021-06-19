package com.main.view;

import com.main.dao.AdminDao;
import com.main.dao.TeacherDao;
import com.main.model.SystemAdmin;
import com.main.model.Teacher;
import com.main.model.UserType;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Lonely_Fantasy
 * @version 创建时间：2021年6月10日 下午1:29:44
 * 类说明123
 */
public class Login extends JFrame {

    private JPanel contentPane;
    private JTextField adminName;
    private JPasswordField adminPassword;
    private JComboBox user_type_combobox;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Login frame = new Login();
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
    public Login() {
        setTitle("\u767B\u5F55\u9875\u9762");
        setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/images/main_icon.png")));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        setResizable(false);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("\u5B66\u751F\u4FE1\u606F\u7BA1\u7406\u7CFB\u7EDF");
        lblNewLabel.setFont(new Font("微软雅黑", Font.BOLD, 20));
        lblNewLabel.setBounds(132, 10, 160, 28);
        contentPane.add(lblNewLabel);

        JLabel lblUsername = new JLabel("\u7528\u6237\u540D\uFF1A");
        lblUsername.setIcon(new ImageIcon(Login.class.getResource("/images/user.png")));
        lblUsername.setFont(new Font("微软雅黑", Font.BOLD, 16));
        lblUsername.setBounds(78, 48, 94, 28);
        contentPane.add(lblUsername);

        adminName = new JTextField();
        adminName.setFont(new Font("微软雅黑", Font.BOLD, 16));
        adminName.setColumns(10);
        adminName.setBounds(182, 48, 155, 28);
        contentPane.add(adminName);

        JLabel lblPassword = new JLabel(" \u5BC6  \u7801\uFF1A");
        lblPassword.setIcon(new ImageIcon(Login.class.getResource("/images/lock.png")));
        lblPassword.setFont(new Font("微软雅黑", Font.BOLD, 16));
        lblPassword.setBounds(78, 98, 94, 28);
        contentPane.add(lblPassword);

        adminPassword = new JPasswordField();
        adminPassword.setFont(new Font("微软雅黑", Font.BOLD, 16));
        adminPassword.setBounds(182, 98, 155, 28);
        contentPane.add(adminPassword);

        JLabel lblNewLabel_1_1_1 = new JLabel("\u7528\u6237\u7C7B\u578B\uFF1A");
        lblNewLabel_1_1_1.setFont(new Font("微软雅黑", Font.BOLD, 16));
        lblNewLabel_1_1_1.setBounds(110, 154, 83, 28);
        contentPane.add(lblNewLabel_1_1_1);

        user_type_combobox = new JComboBox();
        user_type_combobox.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        user_type_combobox.setBounds(203, 154, 110, 28);
        user_type_combobox.setModel(new DefaultComboBoxModel(new UserType[]{UserType.ADMIN, UserType.TEACHER}));
        contentPane.add(user_type_combobox);

        JButton btnLogin = new JButton("\u767B\u5F55");
        btnLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                confirmLogin(ae);
            }
        });
        btnLogin.setIcon(new ImageIcon(Login.class.getResource("/images/login.png")));
        btnLogin.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        btnLogin.setFocusable(false);
        btnLogin.setBounds(59, 205, 118, 36);
        contentPane.add(btnLogin);

        JButton btnExit = new JButton("\u9000\u51FA");
        btnExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        btnExit.setIcon(new ImageIcon(Login.class.getResource("/images/exit.png")));
        btnExit.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        btnExit.setFocusable(false);
        btnExit.setBounds(256, 205, 118, 36);
        contentPane.add(btnExit);

        //按钮虚线隐藏
        btnLogin.setFocusable(false);
        btnExit.setFocusable(false);
        //窗口居中
        setLocationRelativeTo(null);


    }

    protected void confirmLogin(ActionEvent ae) {
        // TODO Auto-generated method stub
        String nameString1 = this.adminName.getText();
        String passwordString1 = this.adminPassword.getText();
        String nameString2 = this.adminName.getText();
        String passwordString2 = this.adminPassword.getText();
        UserType userType = (UserType) this.user_type_combobox.getSelectedItem();
        if ("系统管理员".equals(userType.getName())) {
            AdminDao adminDao = new AdminDao();
            SystemAdmin admin = adminDao.selectAdmin(nameString1, passwordString1);
            if (admin == null) {
                JOptionPane.showMessageDialog(this, "用户名或者密码错误！！");
                return;
            }
            IndexFrame indexFrame = new IndexFrame(userType, admin, passwordString1);
            indexFrame.setVisible(true);
            this.dispose();
        }
        if ("老师".equals(userType.getName())) {
        	TeacherDao teacherDao = new TeacherDao();
            Teacher teacher = teacherDao.selectTeacher(nameString2, passwordString2);
            if (teacher == null) {
                JOptionPane.showMessageDialog(this, "用户名或者密码错误！！");
                return;
            }
            IndexFrameForTeacher indexFrameForTeacher = new IndexFrameForTeacher(userType, teacher, passwordString2);
            indexFrameForTeacher.setVisible(true);
            this.dispose();
            return;
        }
    }
}
