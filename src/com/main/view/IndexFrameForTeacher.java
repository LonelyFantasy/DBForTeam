package com.main.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.main.model.SystemAdmin;
import com.main.model.Teacher;
import com.main.model.UserType;
import com.main.view.student.AddStudentFrame;
import com.main.view.student.StudentListFrame;
import com.main.view.studentClass.AddClassFrame;
import com.main.view.studentClass.ClassListFrame;
import com.main.view.systemManage.ResetPassword;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
* @author Lonely_Fantasy 
* @version 创建时间：2021年6月19日 下午12:56:55
* 类说明
*/
public class IndexFrameForTeacher extends JFrame {
	
	private JPanel contentPane;
    public static JDesktopPane desktopPane;

    public static ResetPassword resetPassword = null;
    public static ClassListFrame classListFrame = null;
    public static AddClassFrame addClassFrame = null;
    public static AddStudentFrame addStudentFrame = null;
    public static StudentListFrame studentListFrame = null;
	
	
	public static UserType userType;//接受登录数据
    public static Teacher teacher;//接受登录数据
    public static String adminPassword;//接受登录数据
    public static String classid;//接受登录数据
    

	/**
	 * Create the frame.
	 */
	public IndexFrameForTeacher(UserType u, Teacher t, String p, String c) {
		userType = u;
        teacher = t;
        adminPassword = p;
        classid = c;
        setIconImage(Toolkit.getDefaultToolkit().getImage(IndexFrame.class.getResource("/images/main_icon.png")));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1100, 950);
        setTitle("\u7BA1\u7406\u4E3B\u9875");

        JMenuBar menuBar = new JMenuBar();
        menuBar.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
        setJMenuBar(menuBar);

        JMenu mnNewMenu = new JMenu("\u73ED\u7EA7\u7BA1\u7406");
        mnNewMenu.setIcon(new ImageIcon(IndexFrame.class.getResource("/images/dynamic-filling.png")));
        mnNewMenu.setFont(new Font("微软雅黑", Font.BOLD, 15));
        menuBar.add(mnNewMenu);

        JMenuItem mntmNewMenuItem_1 = new JMenuItem("班级信息");
        mntmNewMenuItem_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
            }
        });
        mntmNewMenuItem_1.setIcon(new ImageIcon(IndexFrame.class.getResource("/images/menu.png")));
        mntmNewMenuItem_1.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 14));
        mnNewMenu.add(mntmNewMenuItem_1);

        JMenu mnNewMenu_1 = new JMenu("\u5B66\u751F\u7BA1\u7406");
        mnNewMenu_1.setIcon(new ImageIcon(IndexFrame.class.getResource("/images/group-filled-persons.png")));
        mnNewMenu_1.setFont(new Font("微软雅黑", Font.BOLD, 15));
        menuBar.add(mnNewMenu_1);

        JMenuItem mntmNewMenuItem_1_1 = new JMenuItem("学生列表");
        mntmNewMenuItem_1_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		studentList();
        	}
        });
        mntmNewMenuItem_1_1.setIcon(new ImageIcon(IndexFrame.class.getResource("/images/menu.png")));
        mntmNewMenuItem_1_1.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 14));
        mnNewMenu_1.add(mntmNewMenuItem_1_1);

        JMenu mnNewMenu_4 = new JMenu("\u6211\u7684\u8D26\u6237");
        mnNewMenu_4.setIcon(new ImageIcon(IndexFrame.class.getResource("/images/user-filling.png")));
        mnNewMenu_4.setFont(new Font("微软雅黑", Font.BOLD, 15));
        menuBar.add(mnNewMenu_4);

        JMenuItem mntmNewMenuItem_8 = new JMenuItem("\u8D26\u6237\u4FE1\u606F");
        mntmNewMenuItem_8.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
            	myAccount();
            }
        });
        mntmNewMenuItem_8.setIcon(new ImageIcon(IndexFrame.class.getResource("/images/browse.png")));
        mntmNewMenuItem_8.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 15));
        mnNewMenu_4.add(mntmNewMenuItem_8);

        JMenuItem mntmNewMenuItem_9 = new JMenuItem("\u4FEE\u6539\u5BC6\u7801");
        mntmNewMenuItem_9.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
            }
        });
        mntmNewMenuItem_9.setIcon(new ImageIcon(IndexFrame.class.getResource("/images/lock.png")));
        mntmNewMenuItem_9.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 15));
        mnNewMenu_4.add(mntmNewMenuItem_9);

        JMenuItem mntmNewMenuItem_11 = new JMenuItem("\u9000\u51FA\u7CFB\u7EDF");
        mntmNewMenuItem_11.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        mntmNewMenuItem_11.setIcon(new ImageIcon(IndexFrame.class.getResource("/images/exit.png")));
        mntmNewMenuItem_11.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 15));
        mnNewMenu_4.add(mntmNewMenuItem_11);

        JMenu mnNewMenu_5 = new JMenu("\u66F4\u591A");
        mnNewMenu_5.setIcon(new ImageIcon(IndexFrame.class.getResource("/images/more-fill.png")));
        mnNewMenu_5.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 15));
        menuBar.add(mnNewMenu_5);

        JMenuItem mntmNewMenuItem_10 = new JMenuItem("\u5173\u4E8E\u8F6F\u4EF6");
        mntmNewMenuItem_10.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                aboutSoftware();
            }
        });
        mntmNewMenuItem_10.setIcon(new ImageIcon(IndexFrame.class.getResource("/images/help.png")));
        mntmNewMenuItem_10.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 15));
        mnNewMenu_5.add(mntmNewMenuItem_10);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        desktopPane = new JDesktopPane();
        desktopPane.setBackground(Color.LIGHT_GRAY);
        contentPane.add(desktopPane, BorderLayout.CENTER);
        //窗口居中
        setLocationRelativeTo(null);
	}

    protected void studentList() {
		// TODO Auto-generated method stub
		
	}

	//我的账户----账户信息
    protected void myAccount() {
        // TODO Auto-generated method stub
        JOptionPane.showMessageDialog(this, "账户名称：" + teacher.getName() + "\n账户类别：" + userType + "\n管理班级：", "账户信息", JOptionPane.INFORMATION_MESSAGE);
    }

	//更多----关于软件
    protected void aboutSoftware() {
        // TODO Auto-generated method stub
        JOptionPane.showMessageDialog(null, "使用Java Swing开发\n数据库使用MySQL", "关于软件", JOptionPane.INFORMATION_MESSAGE);
    }

}
