package com.main.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JDesktopPane;
import java.awt.Color;

/**
* @author Lonely_Fantasy 
* @version 创建时间：2021年6月10日 下午3:20:40
* 类说明
*/
public class IndexFrameForAdmin extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IndexFrameForAdmin frame = new IndexFrameForAdmin();
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
	public IndexFrameForAdmin() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(IndexFrameForAdmin.class.getResource("/images/main_icon.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 700);
		setTitle("\u5E93\u5B58\u7BA1\u7406\u4E3B\u9875");
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 15));
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("\u7528\u6237\u7BA1\u7406");
		mnNewMenu.setIcon(new ImageIcon(IndexFrameForAdmin.class.getResource("/images/user-filling.png")));
		mnNewMenu.setFont(new Font("微软雅黑", Font.BOLD, 15));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("\u7528\u6237\u5217\u8868");
		mntmNewMenuItem.setIcon(new ImageIcon(IndexFrameForAdmin.class.getResource("/images/menu.png")));
		mntmNewMenuItem.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 14));
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("\u6DFB\u52A0\u7528\u6237");
		mntmNewMenuItem_1.setIcon(new ImageIcon(IndexFrameForAdmin.class.getResource("/images/adjust.png")));
		mntmNewMenuItem_1.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 14));
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenu mnNewMenu_1 = new JMenu("\u5546\u54C1\u7BA1\u7406");
		mnNewMenu_1.setIcon(new ImageIcon(IndexFrameForAdmin.class.getResource("/images/dynamic-filling.png")));
		mnNewMenu_1.setFont(new Font("微软雅黑", Font.BOLD, 14));
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("\u5546\u54C1\u5217\u8868");
		mntmNewMenuItem_2.setFont(new Font("微软雅黑", Font.BOLD, 15));
		mntmNewMenuItem_2.setIcon(new ImageIcon(IndexFrameForAdmin.class.getResource("/images/layers.png")));
		mnNewMenu_1.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("\u5E93\u5B58\u72B6\u6001");
		mntmNewMenuItem_3.setFont(new Font("微软雅黑", Font.BOLD, 15));
		mntmNewMenuItem_3.setIcon(new ImageIcon(IndexFrameForAdmin.class.getResource("/images/home.png")));
		mnNewMenu_1.add(mntmNewMenuItem_3);
		
		JMenu mnNewMenu_2 = new JMenu("\u5165\u5E93\u64CD\u4F5C");
		mnNewMenu_2.setIcon(new ImageIcon(IndexFrameForAdmin.class.getResource("/images/decline-filling.png")));
		mnNewMenu_2.setFont(new Font("微软雅黑", Font.BOLD, 15));
		menuBar.add(mnNewMenu_2);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("\u65B0\u589E\u5165\u5E93");
		mntmNewMenuItem_4.setFont(new Font("微软雅黑", Font.BOLD, 15));
		mntmNewMenuItem_4.setIcon(new ImageIcon(IndexFrameForAdmin.class.getResource("/images/ruku.png")));
		mnNewMenu_2.add(mntmNewMenuItem_4);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("\u5165\u5E93\u8BB0\u5F55");
		mntmNewMenuItem_5.setFont(new Font("微软雅黑", Font.BOLD, 15));
		mntmNewMenuItem_5.setIcon(new ImageIcon(IndexFrameForAdmin.class.getResource("/images/menu.png")));
		mnNewMenu_2.add(mntmNewMenuItem_5);
		
		JMenu mnNewMenu_3 = new JMenu("\u51FA\u5E93\u64CD\u4F5C");
		mnNewMenu_3.setIcon(new ImageIcon(IndexFrameForAdmin.class.getResource("/images/rise-filling.png")));
		mnNewMenu_3.setFont(new Font("微软雅黑", Font.BOLD, 15));
		menuBar.add(mnNewMenu_3);
		
		JMenuItem mntmNewMenuItem_6 = new JMenuItem("\u65B0\u589E\u51FA\u5E93");
		mntmNewMenuItem_6.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 15));
		mntmNewMenuItem_6.setIcon(new ImageIcon(IndexFrameForAdmin.class.getResource("/images/chuku.png")));
		mnNewMenu_3.add(mntmNewMenuItem_6);
		
		JMenuItem mntmNewMenuItem_7 = new JMenuItem("\u51FA\u5E93\u8BB0\u5F55");
		mntmNewMenuItem_7.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 15));
		mntmNewMenuItem_7.setIcon(new ImageIcon(IndexFrameForAdmin.class.getResource("/images/menu.png")));
		mnNewMenu_3.add(mntmNewMenuItem_7);
		
		JMenu mnNewMenu_4 = new JMenu("\u6211\u7684\u8D26\u6237");
		mnNewMenu_4.setIcon(new ImageIcon(IndexFrameForAdmin.class.getResource("/images/user-filling.png")));
		mnNewMenu_4.setFont(new Font("微软雅黑", Font.BOLD, 15));
		menuBar.add(mnNewMenu_4);
		
		JMenuItem mntmNewMenuItem_8 = new JMenuItem("\u8D26\u6237\u4FE1\u606F");
		mntmNewMenuItem_8.setIcon(new ImageIcon(IndexFrameForAdmin.class.getResource("/images/browse.png")));
		mntmNewMenuItem_8.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 15));
		mnNewMenu_4.add(mntmNewMenuItem_8);
		
		JMenuItem mntmNewMenuItem_9 = new JMenuItem("\u4FEE\u6539\u5BC6\u7801");
		mntmNewMenuItem_9.setIcon(new ImageIcon(IndexFrameForAdmin.class.getResource("/images/lock.png")));
		mntmNewMenuItem_9.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 15));
		mnNewMenu_4.add(mntmNewMenuItem_9);
		
		JMenuItem mntmNewMenuItem_11 = new JMenuItem("\u9000\u51FA\u7CFB\u7EDF");
		mntmNewMenuItem_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mntmNewMenuItem_11.setIcon(new ImageIcon(IndexFrameForAdmin.class.getResource("/images/exit.png")));
		mntmNewMenuItem_11.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 15));
		mnNewMenu_4.add(mntmNewMenuItem_11);
		
		JMenu mnNewMenu_5 = new JMenu("\u66F4\u591A");
		mnNewMenu_5.setIcon(new ImageIcon(IndexFrameForAdmin.class.getResource("/images/more-fill.png")));
		mnNewMenu_5.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 15));
		menuBar.add(mnNewMenu_5);
		
		JMenuItem mntmNewMenuItem_10 = new JMenuItem("\u5173\u4E8E\u8F6F\u4EF6");
		mntmNewMenuItem_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "使用Java Swing开发，数据库使用openGauss","关于软件",JOptionPane.INFORMATION_MESSAGE);
			}
		});
		mntmNewMenuItem_10.setIcon(new ImageIcon(IndexFrameForAdmin.class.getResource("/images/help.png")));
		mntmNewMenuItem_10.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 15));
		mnNewMenu_5.add(mntmNewMenuItem_10);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(Color.LIGHT_GRAY);
		contentPane.add(desktopPane, BorderLayout.CENTER);
		//窗口居中
		setLocationRelativeTo(null);
	}

}
