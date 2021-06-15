package com.main.view.studentClass;

import com.main.dao.ClassDao;
import com.main.model.StudentClass;
import com.main.util.StringUtil;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;

/**
 * @author Lonely_Fantasy
 * @version 创建时间：2021年6月14日 下午5:46:52
 * 类说明
 */
public class ClassListFrame extends JInternalFrame {
    private JTable classListTable;
    private JTextField className;
    private JTextField classSecondary;
    private JTextField classGrade;
    private JTextField classMajor;
    private JTextArea classInfo;

    private DefaultTableModel dtm = null;


    /**
     * Create the frame.
     */
    public ClassListFrame() {
        getContentPane().setFont(new Font("微软雅黑", Font.PLAIN, 12));
        setFrameIcon(new ImageIcon(ClassListFrame.class.getResource("/images/menu.png")));
        setTitle("\u73ED\u7EA7\u5217\u8868");
        setBounds(100, 100, 900, 700);
        getContentPane().setLayout(null);
        setIconifiable(true);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 10, 864, 425);
        getContentPane().add(scrollPane);
        getContentPane().setLayout(null);
        setClosable(true);

        classListTable = new JTable();
        classListTable.setFont(new Font("微软雅黑", Font.BOLD, 14));

        //表格属性
        classListTable.setBackground(new Color(230, 230, 255));//表背景属性
        classListTable.getTableHeader().setReorderingAllowed(false);//表头不可拖动
        classListTable.setRowHeight(30);//表格高度

        //表格居中
        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
        renderer.setHorizontalAlignment(JLabel.CENTER);
        classListTable.setDefaultRenderer(Object.class, renderer);

        classListTable.setModel(new DefaultTableModel(
                new Object[][]{
                },
                new String[]{
                        "\u73ED\u7EA7\u7F16\u53F7", "\u73ED\u7EA7\u540D\u79F0", "\u6240\u5C5E\u5E74\u7EA7", "\u6240\u5C5E\u5B66\u9662", "\u6240\u5C5E\u4E13\u4E1A", "\u73ED\u7EA7\u4FE1\u606F"
                }
        ) {
            //设置表中内容不可编辑状态（重写方法）
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        });
        classListTable.getColumnModel().getColumn(0).setPreferredWidth(120);
        classListTable.getColumnModel().getColumn(0).setMinWidth(120);
        classListTable.getColumnModel().getColumn(0).setMaxWidth(120);
        classListTable.getColumnModel().getColumn(1).setPreferredWidth(100);
        classListTable.getColumnModel().getColumn(1).setMinWidth(100);
        classListTable.getColumnModel().getColumn(1).setMaxWidth(100);
        classListTable.getColumnModel().getColumn(2).setPreferredWidth(120);
        classListTable.getColumnModel().getColumn(2).setMinWidth(120);
        classListTable.getColumnModel().getColumn(2).setMaxWidth(120);
        classListTable.getColumnModel().getColumn(3).setPreferredWidth(150);
        classListTable.getColumnModel().getColumn(3).setMinWidth(150);
        classListTable.getColumnModel().getColumn(3).setMaxWidth(150);
        classListTable.getColumnModel().getColumn(4).setPreferredWidth(150);
        classListTable.getColumnModel().getColumn(4).setMinWidth(150);
        classListTable.getColumnModel().getColumn(4).setMaxWidth(150);
        scrollPane.setViewportView(classListTable);

        JLabel lblNewLabel = new JLabel("\u73ED\u7EA7\u540D\u79F0");
        lblNewLabel.setIcon(new ImageIcon(ClassListFrame.class.getResource("/images/Customermanagement.png")));
        lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        lblNewLabel.setBounds(20, 445, 81, 25);
        getContentPane().add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("\u6240\u5C5E\u5B66\u9662");
        lblNewLabel_1.setIcon(new ImageIcon(ClassListFrame.class.getResource("/images/company.png")));
        lblNewLabel_1.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        lblNewLabel_1.setBounds(20, 501, 81, 25);
        getContentPane().add(lblNewLabel_1);

        JLabel lblNewLabel_1_1 = new JLabel("\u6240\u5C5E\u5E74\u7EA7");
        lblNewLabel_1_1.setIcon(new ImageIcon(ClassListFrame.class.getResource("/images/layers.png")));
        lblNewLabel_1_1.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        lblNewLabel_1_1.setBounds(265, 446, 81, 25);
        getContentPane().add(lblNewLabel_1_1);

        JLabel lblNewLabel_1_2 = new JLabel("\u6240\u5C5E\u4E13\u4E1A");
        lblNewLabel_1_2.setIcon(new ImageIcon(ClassListFrame.class.getResource("/images/feeds.png")));
        lblNewLabel_1_2.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        lblNewLabel_1_2.setBounds(265, 502, 81, 25);
        getContentPane().add(lblNewLabel_1_2);

        className = new JTextField();
        className.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        className.setBounds(111, 445, 105, 25);
        getContentPane().add(className);
        className.setColumns(10);

        classSecondary = new JTextField();
        classSecondary.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        classSecondary.setColumns(10);
        classSecondary.setBounds(110, 500, 143, 25);
        getContentPane().add(classSecondary);

        classGrade = new JTextField();
        classGrade.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        classGrade.setColumns(10);
        classGrade.setBounds(364, 445, 105, 25);
        getContentPane().add(classGrade);

        classMajor = new JTextField();
        classMajor.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        classMajor.setColumns(10);
        classMajor.setBounds(364, 501, 136, 25);
        getContentPane().add(classMajor);

        JButton btnNewButton = new JButton("\u641C\u7D22");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                selectSomeoneClass(ae);

            }
        });
        btnNewButton.setIcon(new ImageIcon(ClassListFrame.class.getResource("/images/search.png")));
        btnNewButton.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        btnNewButton.setBounds(557, 445, 93, 25);
        getContentPane().add(btnNewButton);

        JButton btnNewButton_1 = new JButton("\u6E05\u7A7A");
        btnNewButton_1.setIcon(new ImageIcon(ClassListFrame.class.getResource("/images/exit.png")));
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                resetButton();
            }
        });
        btnNewButton_1.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        btnNewButton_1.setBounds(557, 501, 93, 25);
        getContentPane().add(btnNewButton_1);

        JButton btnNewButton_2 = new JButton("\u5220\u9664");
        btnNewButton_2.setIcon(new ImageIcon(ClassListFrame.class.getResource("/images/ashbin-fill.png")));
        btnNewButton_2.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        btnNewButton_2.setBounds(704, 445, 93, 25);
        getContentPane().add(btnNewButton_2);

        JButton btnNewButton_3 = new JButton("\u7F16\u8F91");
        btnNewButton_3.setIcon(new ImageIcon(ClassListFrame.class.getResource("/images/editor.png")));
        btnNewButton_3.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        btnNewButton_3.setBounds(704, 501, 93, 25);
        getContentPane().add(btnNewButton_3);

        JLabel lblNewLabel_1_3 = new JLabel("\u73ED\u7EA7\u4FE1\u606F");
        lblNewLabel_1_3.setIcon(new ImageIcon(ClassListFrame.class.getResource("/images/namecard.png")));
        lblNewLabel_1_3.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        lblNewLabel_1_3.setBounds(20, 592, 81, 25);
        getContentPane().add(lblNewLabel_1_3);

        JButton btnNewButton_1_1 = new JButton("\u5237\u65B0");
        btnNewButton_1_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                refreshTable();
            }
        });
        btnNewButton_1_1.setIcon(new ImageIcon(ClassListFrame.class.getResource("/images/exchangerate.png")));
        btnNewButton_1_1.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        btnNewButton_1_1.setBounds(557, 551, 93, 25);
        getContentPane().add(btnNewButton_1_1);

        classInfo = new JTextArea();
        classInfo.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        classInfo.setBounds(111, 551, 389, 109);
        getContentPane().add(classInfo);

        this.dtm = (DefaultTableModel) classListTable.getModel();

        queryAllClass();//打开窗口自动加载全部信息
    }


    protected void refreshTable() {
        // TODO Auto-generated method stub
        resetButton();
        queryAllClass();
    }


    protected void selectSomeoneClass(ActionEvent ae) {
        // TODO Auto-generated method stub
        String nameString = this.className.getText();
        String gradeString = this.classGrade.getText();
        String majorString = this.classMajor.getText();
        String secondaryString = this.classSecondary.getText();
        String infoString = this.classInfo.getText();

        //判断任意输入框有无内容
        if (StringUtil.isEmpty(nameString) && StringUtil.isEmpty(gradeString) && StringUtil.isEmpty(secondaryString) && StringUtil.isEmpty(majorString) && StringUtil.isEmpty(infoString)) {
            queryAllClass();
            return;
        }

        StudentClass tempClass = new StudentClass();
        tempClass.setName(nameString);
        tempClass.setGrade(gradeString);
        tempClass.setSecondary(secondaryString);
        tempClass.setMajor(majorString);
        tempClass.setInfo(infoString);

        dtm.setRowCount(0);
        ClassDao classDao = new ClassDao();
        List<StudentClass> allClassList = classDao.querySomeClass(tempClass);

        for (StudentClass studentClass : allClassList) {
            Vector v = new Vector();
            v.add(studentClass.getId());
            v.add(studentClass.getGrade());
            v.add(studentClass.getName());
            v.add(studentClass.getSecondary());
            v.add(studentClass.getMajor());
            v.add(studentClass.getInfo());
            dtm.addRow(v);
        }

    }


    protected void resetButton() {
        // TODO Auto-generated method stub
        this.className.setText("");
        this.classGrade.setText("");
        this.classSecondary.setText("");
        this.classMajor.setText("");
    }


    public void queryAllClass() {
        dtm.setRowCount(0);
        ClassDao classDao = new ClassDao();
        List<StudentClass> allClassList = classDao.queryAllClass();

        for (StudentClass studentClass : allClassList) {
            Vector v = new Vector();
            v.add(studentClass.getId());
            v.add(studentClass.getGrade());
            v.add(studentClass.getName());
            v.add(studentClass.getSecondary());
            v.add(studentClass.getMajor());
            v.add(studentClass.getInfo());
            dtm.addRow(v);
        }
    }

    //重写这个窗体的关闭按键方法，防止窗口重复出现
    public void doDefaultCloseAction() {
        setVisible(false);
        resetButton();
    }
}
