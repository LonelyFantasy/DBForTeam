package com.main.view.studentClass;

import com.main.dao.ClassDao;
import com.main.model.StudentClass;
import com.main.util.LimitedDocument;
import com.main.util.StringUtil;
import com.main.view.IndexFrame;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.Vector;

/**
 * @author codebiyang
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
    private JButton editButton;
    private JButton deleteButton;
    public JLabel  class_label_count;//班级数量的显示
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
        scrollPane.setBorder(BorderFactory.createEmptyBorder());//给每行加线条
        getContentPane().add(scrollPane);
        getContentPane().setLayout(null);
        setClosable(true);

        classListTable = new JTable();
        classListTable.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent me) {
        		AbstractResultsetRow();
        	}
        });
        classListTable.setFont(new Font("微软雅黑", Font.BOLD, 14));

        //表格属性
        classListTable.setBackground(new Color(230, 230, 255));//表背景属性
        classListTable.getTableHeader().setReorderingAllowed(false);//表头不可拖动
        classListTable.setRowHeight(30);//表格高度
        classListTable.setShowGrid(false);
        classListTable.setShowHorizontalLines(false);

        //表格居中
        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
        renderer.setHorizontalAlignment(JLabel.CENTER);
        classListTable.setDefaultRenderer(Object.class, renderer);

        classListTable.setModel(new DefaultTableModel(
        	new Object[][] {
        	},
        	new String[] {
        		"\u73ED\u7EA7\u7F16\u53F7", "\u73ED\u7EA7\u540D\u79F0", "\u6240\u5C5E\u5E74\u7EA7", "\u6240\u5C5E\u5B66\u9662", "\u6240\u5C5E\u4E13\u4E1A", "\u73ED\u7EA7\u4FE1\u606F", "\u73ED\u7EA7\u4EBA\u6570"
        	}
        ){
            //设置表中内容不可编辑状态（重写方法）
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        });
        classListTable.getColumnModel().getColumn(0).setPreferredWidth(80);
        classListTable.getColumnModel().getColumn(0).setMinWidth(80);
        classListTable.getColumnModel().getColumn(0).setMaxWidth(80);
        classListTable.getColumnModel().getColumn(1).setPreferredWidth(100);
        classListTable.getColumnModel().getColumn(1).setMinWidth(100);
        classListTable.getColumnModel().getColumn(1).setMaxWidth(100);
        classListTable.getColumnModel().getColumn(2).setPreferredWidth(100);
        classListTable.getColumnModel().getColumn(2).setMinWidth(100);
        classListTable.getColumnModel().getColumn(2).setMaxWidth(100);
        classListTable.getColumnModel().getColumn(3).setPreferredWidth(150);
        classListTable.getColumnModel().getColumn(3).setMinWidth(150);
        classListTable.getColumnModel().getColumn(3).setMaxWidth(150);
        classListTable.getColumnModel().getColumn(4).setPreferredWidth(130);
        classListTable.getColumnModel().getColumn(4).setMinWidth(130);
        classListTable.getColumnModel().getColumn(4).setMaxWidth(130);
        classListTable.getColumnModel().getColumn(6).setPreferredWidth(80);
        classListTable.getColumnModel().getColumn(6).setMinWidth(80);
        classListTable.getColumnModel().getColumn(6).setMaxWidth(80);
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
        //调用重写的工具类，设置文本框只能输入数字
        LimitedDocument ld = new LimitedDocument(4);//参数为能输入的最大长度
        ld.setAllowChar("0123456789");//只能输入的字符
        classGrade.setDocument(ld);

        classMajor = new JTextField();
        classMajor.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        classMajor.setColumns(10);
        classMajor.setBounds(364, 501, 136, 25);
        getContentPane().add(classMajor);

        JButton btnNewButton = new JButton("\u641C\u7D22");
        //搜索
        btnNewButton.addActionListener(ae -> selectSomeoneClass());
        btnNewButton.setIcon(new ImageIcon(ClassListFrame.class.getResource("/images/search.png")));
        btnNewButton.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        btnNewButton.setBounds(557, 445, 93, 25);
        getContentPane().add(btnNewButton);

        JButton btnNewButton_1 = new JButton("\u6E05\u7A7A");
        btnNewButton_1.setIcon(new ImageIcon(ClassListFrame.class.getResource("/images/exit.png")));
        btnNewButton_1.addActionListener(e -> resetButton());
        btnNewButton_1.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        btnNewButton_1.setBounds(557, 501, 93, 25);
        getContentPane().add(btnNewButton_1);

        deleteButton = new JButton("\u5220\u9664");
        deleteButton.addActionListener(e -> deleteButton());
        deleteButton.setIcon(new ImageIcon(ClassListFrame.class.getResource("/images/ashbin-fill.png")));
        deleteButton.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        deleteButton.setBounds(704, 501, 93, 25);
        getContentPane().add(deleteButton);

        editButton = new JButton("编辑");
        editButton.addActionListener(e -> editclassinfo());
        editButton.setIcon(new ImageIcon(ClassListFrame.class.getResource("/images/editor.png")));
        editButton.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        editButton.setBounds(704, 445, 93, 25);
        getContentPane().add(editButton);

        JLabel lblNewLabel_1_3 = new JLabel("\u73ED\u7EA7\u4FE1\u606F");
        lblNewLabel_1_3.setIcon(new ImageIcon(ClassListFrame.class.getResource("/images/namecard.png")));
        lblNewLabel_1_3.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        lblNewLabel_1_3.setBounds(20, 592, 81, 25);
        getContentPane().add(lblNewLabel_1_3);

        JButton btnNewButton_1_1 = new JButton("\u5237\u65B0");
        btnNewButton_1_1.addActionListener(e -> refreshTable());
        btnNewButton_1_1.setIcon(new ImageIcon(ClassListFrame.class.getResource("/images/exchangerate.png")));
        btnNewButton_1_1.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        btnNewButton_1_1.setBounds(557, 551, 93, 25);
        getContentPane().add(btnNewButton_1_1);

        classInfo = new JTextArea();
        classInfo.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        classInfo.setBounds(111, 551, 389, 109);
        getContentPane().add(classInfo);
        
        class_label_count = new JLabel();//这是班级数量的显示
        class_label_count.setText(label_string());
        class_label_count.setBounds(555, 606, 117, 30);
        getContentPane().add(class_label_count);

        this.dtm = (DefaultTableModel) classListTable.getModel();

        queryAllClass();//打开窗口自动加载全部信息
    }

    protected void editclassinfo() {
        StudentClass studentClass=new StudentClass();
        studentClass.setId(dtm.getValueAt(classListTable.getSelectedRow(), 0).toString());
        System.out.println(studentClass.getId());
        studentClass.setName(dtm.getValueAt(classListTable.getSelectedRow(),1).toString());
        System.out.println(studentClass.getName());
        studentClass.setInfo(dtm.getValueAt(classListTable.getSelectedRow(),5).toString());
        System.out.println(studentClass.getInfo());
        if(IndexFrame.editClassFrame== null) {
            IndexFrame.editClassFrame = new EditClassFrame(studentClass);
            IndexFrame.desktopPane.add(IndexFrame.editClassFrame);
        }
        IndexFrame.editClassFrame.setVisible(true);
    }

    //删除班级
    protected void deleteButton() {
		// TODO Auto-generated method stub
		if(JOptionPane.showConfirmDialog(this, "是否删除此班级呢？","正在删除此班级...", JOptionPane.YES_NO_CANCEL_OPTION) == JOptionPane.OK_OPTION);{
			String idString = dtm.getValueAt(this.classListTable.getSelectedRow(), 0).toString();//获取选择班级的编号
			ClassDao classDao = new ClassDao();
			JOptionPane.showMessageDialog(this, classDao.deleteClass(idString));
		}
		class_label_count.setText(label_string());
		queryAllClass();//删除完后刷新表格
	}

	//点击表格事件设置
    protected void AbstractResultsetRow() {
		// TODO Auto-generated method stub
		this.className.setText(dtm.getValueAt(this.classListTable.getSelectedRow(), 1).toString());//班级名称
		this.classGrade.setText(dtm.getValueAt(this.classListTable.getSelectedRow(), 2).toString());//所属年级
		this.classSecondary.setText(dtm.getValueAt(this.classListTable.getSelectedRow(), 3).toString());//所属学院
		this.classMajor.setText(dtm.getValueAt(this.classListTable.getSelectedRow(), 4).toString());//所属专业
		this.classInfo.setText(dtm.getValueAt(this.classListTable.getSelectedRow(), 5).toString());//班级信息
		this.editButton.setEnabled(true);
		this.deleteButton.setEnabled(true);
	}

	//刷新并获取整表内容
    protected void refreshTable() {
        // TODO Auto-generated method stub
        resetButton();
        queryAllClass();
        class_label_count.setText(label_string());//刷新当前班级数量
    }

    //条件搜索
    protected void selectSomeoneClass() {
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

        //使用Vector存放数据
        for (StudentClass studentClass : allClassList) {
            Vector v = new Vector();
            v.add(studentClass.getId());
            v.add(studentClass.getGrade());
            v.add(studentClass.getName());
            v.add(studentClass.getSecondary());
            v.add(studentClass.getMajor());
            v.add(studentClass.getInfo());
            v.add(studentClass.getStudentnumber());
            dtm.addRow(v);
        }

    }

    //重置内容按钮
    protected void resetButton() {
        // TODO Auto-generated method stub
        this.className.setText("");
        this.classGrade.setText("");
        this.classSecondary.setText("");
        this.classMajor.setText("");
        this.classInfo.setText("");
    }

    //获取整表内容
    public List<StudentClass> queryAllClass() {
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
            v.add(studentClass.getStudentnumber());
            dtm.addRow(v);
        }
        //按钮默认设置不可点击
        this.editButton.setEnabled(false);
        this.deleteButton.setEnabled(false);
        return allClassList;
    }

    //重写这个窗体的关闭按键方法，防止窗口重复出现
    public void doDefaultCloseAction() {
        setVisible(false);
        resetButton();
    }
    public int class_count()//计算班级数量的函数
    {
    	ClassDao classdao=new ClassDao();
    	List<StudentClass> class_count=classdao.queryAllClass();
    	
    	return class_count.size();
    }
    public String label_string()//显示班级数量的文字提示
    {
    	int a=class_count();
        return "班级数量："+a;
    }
}
