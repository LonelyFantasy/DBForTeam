package com.main.view;

import com.main.dao.AdminDao;
import com.main.model.SystemAdmin;
import com.main.model.UserType;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

/**
 * @author Lonely_Fantasy
 * @version 创建时间：2021年6月10日 下午1:29:44
 * 类说明：启动页面
 */
public class Login extends JFrame {

    private JTextField adminName;
    private JPasswordField adminPassword;
    private JComboBox user_type_combobox;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                Login frame = new Login();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
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
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("\u5B66\u751F\u4FE1\u606F\u7BA1\u7406\u7CFB\u7EDF");
        lblNewLabel.setFont(new Font("微软雅黑", Font.BOLD, 20));
        lblNewLabel.setBounds(134, 34, 160, 28);
        contentPane.add(lblNewLabel);

        JLabel lblUsername = new JLabel("\u7528\u6237\u540D\uFF1A");
        lblUsername.setIcon(new ImageIcon(Login.class.getResource("/images/user.png")));
        lblUsername.setFont(new Font("微软雅黑", Font.BOLD, 16));
        lblUsername.setBounds(80, 72, 94, 28);
        contentPane.add(lblUsername);

        adminName = new JTextField();
        adminName.setFont(new Font("微软雅黑", Font.BOLD, 16));
        adminName.setColumns(10);
        adminName.setBounds(184, 72, 155, 28);
        contentPane.add(adminName);

        JLabel lblPassword = new JLabel(" \u5BC6  \u7801\uFF1A");
        lblPassword.setIcon(new ImageIcon(Login.class.getResource("/images/lock.png")));
        lblPassword.setFont(new Font("微软雅黑", Font.BOLD, 16));
        lblPassword.setBounds(80, 122, 94, 28);
        contentPane.add(lblPassword);

        adminPassword = new JPasswordField();
        adminPassword.setFont(new Font("微软雅黑", Font.BOLD, 16));
        adminPassword.setBounds(184, 122, 155, 28);
        contentPane.add(adminPassword);

        user_type_combobox = new JComboBox();
        user_type_combobox.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        user_type_combobox.setBounds(203, 154, 110, 28);
        user_type_combobox.setModel(new DefaultComboBoxModel(new UserType[]{UserType.ADMIN}));
//        contentPane.add(user_type_combobox);

        JButton btnLogin = new JButton("\u767B\u5F55");
        btnLogin.addActionListener(ae -> confirmLogin());
        btnLogin.setIcon(new ImageIcon(Login.class.getResource("/images/login.png")));
        btnLogin.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        btnLogin.setFocusable(false);
        btnLogin.setBounds(59, 205, 118, 36);
        contentPane.add(btnLogin);

        JButton btnExit = new JButton("\u9000\u51FA");
        btnExit.addActionListener(e -> System.exit(0));
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

    protected void confirmLogin() {
        // TODO Auto-generated method stub
        String nameString1 = this.adminName.getText();
        String passwordString1 = this.adminPassword.getText();
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
    }
}
