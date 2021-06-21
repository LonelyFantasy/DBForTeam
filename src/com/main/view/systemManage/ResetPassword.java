package com.main.view.systemManage;

import com.main.dao.AdminDao;
import com.main.util.StringUtil;
import com.main.view.IndexFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Lonely_Fantasy
 * @version 创建时间：2021年6月12日 下午10:10:34
 * 类说明
 */
public class ResetPassword extends JInternalFrame {
    private JTextField oldPassword;
    private JTextField newPassword;
    private JTextField confirmPassword;


    /**
     * Create the frame.
     */
    public ResetPassword() {
        setFrameIcon(new ImageIcon(ResetPassword.class.getResource("/images/lock.png")));
        setTitle("\u4FEE\u6539\u5BC6\u7801");
        setBounds(100, 100, 450, 330);
        getContentPane().setLayout(null);
        setClosable(true);
        setIconifiable(true);
        JLabel lblNewLabel = new JLabel("\u5F53\u524D\u7528\u6237\uFF1A");
        lblNewLabel.setIcon(new ImageIcon(ResetPassword.class.getResource("/images/user.png")));
        lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        lblNewLabel.setBounds(79, 33, 102, 25);
        lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
        getContentPane().add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("\u65E7\u5BC6\u7801\uFF1A");
        lblNewLabel_1.setIcon(new ImageIcon(ResetPassword.class.getResource("/images/lock.png")));
        lblNewLabel_1.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
        lblNewLabel_1.setBounds(79, 80, 102, 25);
        getContentPane().add(lblNewLabel_1);

        JLabel lblNewLabel_1_1 = new JLabel("\u65B0\u5BC6\u7801\uFF1A");
        lblNewLabel_1_1.setIcon(new ImageIcon(ResetPassword.class.getResource("/images/lock.png")));
        lblNewLabel_1_1.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.LEFT);
        lblNewLabel_1_1.setBounds(79, 125, 102, 25);
        getContentPane().add(lblNewLabel_1_1);

        JLabel lblNewLabel_1_1_1 = new JLabel("\u786E\u8BA4\u5BC6\u7801\uFF1A");
        lblNewLabel_1_1_1.setIcon(new ImageIcon(ResetPassword.class.getResource("/images/lock.png")));
        lblNewLabel_1_1_1.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.LEFT);
        lblNewLabel_1_1_1.setBounds(79, 170, 102, 25);
        getContentPane().add(lblNewLabel_1_1_1);

        String userTypeString = IndexFrame.userType.getName();
        String adminNameString = IndexFrame.admin.getName();

        JLabel currentUsername = new JLabel(userTypeString);
        currentUsername.setHorizontalAlignment(SwingConstants.CENTER);
        currentUsername.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        currentUsername.setBounds(217, 33, 102, 25);
        getContentPane().add(currentUsername);

        oldPassword = new JTextField();
        oldPassword.setBounds(188, 80, 165, 25);
        getContentPane().add(oldPassword);
        oldPassword.setColumns(10);

        newPassword = new JTextField();
        newPassword.setColumns(10);
        newPassword.setBounds(188, 127, 165, 25);
        getContentPane().add(newPassword);

        confirmPassword = new JTextField();
        confirmPassword.setColumns(10);
        confirmPassword.setBounds(188, 172, 165, 25);
        getContentPane().add(confirmPassword);

        JButton btnNewButton = new JButton("\u4FEE\u6539");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                confirmReset(ae);
            }
        });
        btnNewButton.setIcon(new ImageIcon(ResetPassword.class.getResource("/images/login.png")));
        btnNewButton.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        btnNewButton.setBounds(79, 241, 93, 36);
        btnNewButton.setFocusPainted(false);//取消按钮虚线
        getContentPane().add(btnNewButton);

        JButton btnNewButton_1 = new JButton("\u91CD\u7F6E");
        btnNewButton_1.setIcon(new ImageIcon(ResetPassword.class.getResource("/images/exit.png")));
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                resetButton();
            }
        });
        btnNewButton_1.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        btnNewButton_1.setBounds(260, 241, 93, 36);
        btnNewButton_1.setFocusPainted(false);//取消按钮虚线
        getContentPane().add(btnNewButton_1);

        setVisible(true);
    }


    //提交修改密码请求
    protected void confirmReset(ActionEvent ae) {
        // TODO Auto-generated method stub
        String oldPasswordString = this.oldPassword.getText();
        String newPasswordString = this.newPassword.getText();
        String confirmPasswordString = this.confirmPassword.getText();

        //判断是否填写
        if(StringUtil.isEmpty(oldPasswordString)) {
            JOptionPane.showMessageDialog(this, "请输入原密码！");
            return;
        }
        if(StringUtil.isEmpty(newPasswordString)) {
            JOptionPane.showMessageDialog(this, "请输入新密码！");
            return;
        }
        if(StringUtil.isEmpty(confirmPasswordString)) {
            JOptionPane.showMessageDialog(this, "请再次输入新密码！");
            return;
        }

        if(newPasswordString.length() < 7){
            JOptionPane.showMessageDialog(this, "新密码长度至少为8位！");
            return;
        }
        if(!newPasswordString.equals(confirmPasswordString)){
            JOptionPane.showMessageDialog(this, "两次新密码不一致！");
            return;
        }

        //判断用户类型
        if("系统管理员".equals(IndexFrame.userType.getName())) {
            AdminDao adminDao = new AdminDao();
            System.out.println(oldPasswordString + "\n" + IndexFrame.admin.getPassword());
            if(!StringUtil.isSame(oldPasswordString, IndexFrame.admin.getPassword())) {//旧密码检查
                JOptionPane.showMessageDialog(this, "原密码不正确！");
                return;
            }
            JOptionPane.showMessageDialog(this, adminDao.resetPassword(IndexFrame.admin, newPasswordString));
            IndexFrame.admin.setPassword(newPasswordString);//更新当前程序缓存的密码
            resetButton();
            return;
        }
        if("学生".equals(IndexFrame.userType.getName())) {

            return;
        }
        if("教师".equals(IndexFrame.userType.getName())) {

            return;
        }

    }

    //清除内容
    protected void resetButton() {
        // TODO Auto-generated method stub
        this.oldPassword.setText("");
        this.newPassword.setText("");
        this.confirmPassword.setText("");
    }

    //重写这个窗体的关闭按键方法，防止窗口重复出现
    public void doDefaultCloseAction() {
        setVisible(false);
        resetButton();//打开窗口自动清除内容
    }
}
