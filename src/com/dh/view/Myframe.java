/*
 * Myframe.java
 *
 * Created on __DATE__, __TIME__
 */

package com.dh.view;

import java.awt.Toolkit;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import com.dh.service.GetTableUtil;
import com.dh.service.MySqlDBUtil;
import com.dh.service.Tool;

import dbBase.entity.ConnArgs;

/**
 *
 * @author  __USER__
 */
public class Myframe extends javax.swing.JFrame {

	//用来保存登录界面传过来的连接对象
	private static ConnArgs connargs;

	/** Creates new form Myframe */
	public Myframe() {
		initComponents();
	}

	public Myframe(ConnArgs conn) {
		initComponents();
		connargs = conn;
		List<String> allTablesName = GetTableUtil.getAllTables(conn);
		Object[][] tableinfo = new Object[allTablesName.size()][4];
		for (int i = 0; i < allTablesName.size(); i++) {
			tableinfo[i][0] = false;
			tableinfo[i][1] = allTablesName.get(i);
			tableinfo[i][2] = "请输入中文名称！";
			tableinfo[i][3] = allTablesName.get(i);
		}
		tableInfo.setModel(new javax.swing.table.DefaultTableModel(tableinfo,
				new String[] { "", "表名", "中文表名", "英文表名" }) {
			Class[] types = new Class[] { java.lang.Boolean.class,
					java.lang.String.class, java.lang.String.class,
					java.lang.String.class };
			boolean[] canEdit = new boolean[] { true, false, true, true };

			public Class getColumnClass(int columnIndex) {
				return types[columnIndex];
			}

			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return canEdit[columnIndex];
			}
		});
	}

	//GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		jLayeredPane1 = new javax.swing.JLayeredPane();
		jLabel3 = new javax.swing.JLabel();
		jLabel4 = new javax.swing.JLabel();
		jScrollPane1 = new javax.swing.JScrollPane();
		tableInfo = new javax.swing.JTable();
		jScrollPane2 = new javax.swing.JScrollPane();
		columnInfo = new javax.swing.JTable();
		check = new javax.swing.JButton();
		compareDB2 = new javax.swing.JButton();
		compareDB1 = new javax.swing.JButton();
		index = new javax.swing.JButton();
		jScrollPane3 = new javax.swing.JScrollPane();
		mytable = new javax.swing.JTable();
		keyvalue = new javax.swing.JButton();
		submit = new javax.swing.JButton();
		quit = new javax.swing.JButton();
		jLabel1 = new javax.swing.JLabel();
		redTips = new javax.swing.JLabel();
		backImage = new javax.swing.JLabel();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle("\u9009\u62e9\u9700\u8981\u5bfc\u5165\u7684\u8868");
		setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
		setName("DBFrame");

		jLabel3.setText("\u5217\u8be6\u60c5\uff1a");
		jLabel3.setBounds(420, 20, 120, 17);
		jLayeredPane1.add(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);

		jLabel4.setText("\u6240\u6709\u8868\uff1a");
		jLabel4.setBounds(20, 20, 130, 17);
		jLayeredPane1.add(jLabel4, javax.swing.JLayeredPane.DEFAULT_LAYER);

		tableInfo.setModel(new javax.swing.table.DefaultTableModel(
				new Object[][] {

				}, new String[] { "", "表名", "中文表名", "英文表名" }) {
			Class[] types = new Class[] { java.lang.Boolean.class,
					java.lang.String.class, java.lang.String.class,
					java.lang.String.class };
			boolean[] canEdit = new boolean[] { true, false, true, true };

			public Class getColumnClass(int columnIndex) {
				return types[columnIndex];
			}

			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return canEdit[columnIndex];
			}
		});
		tableInfo.setToolTipText("");
		tableInfo.setName("");
		tableInfo.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				tableInfoMouseClicked(evt);
			}
		});
		jScrollPane1.setViewportView(tableInfo);

		jScrollPane1.setBounds(20, 40, 380, 250);
		jLayeredPane1.add(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);

		columnInfo.setModel(new javax.swing.table.DefaultTableModel(
				new Object[][] {

				}, new String[] { "列名", "列类型", "可否为空", "默认值", "列描述" }) {
			Class[] types = new Class[] { java.lang.String.class,
					java.lang.String.class, java.lang.Boolean.class,
					java.lang.String.class, java.lang.String.class };
			boolean[] canEdit = new boolean[] { false, false, false, false,
					false };

			public Class getColumnClass(int columnIndex) {
				return types[columnIndex];
			}

			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return canEdit[columnIndex];
			}
		});
		jScrollPane2.setViewportView(columnInfo);

		jScrollPane2.setBounds(420, 40, 360, 250);
		jLayeredPane1.add(jScrollPane2, javax.swing.JLayeredPane.DEFAULT_LAYER);

		check.setText("check\u7ea6\u675f");
		check.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				checkMouseClicked(evt);
			}
		});
		check.setBounds(30, 300, 100, 25);
		jLayeredPane1.add(check, javax.swing.JLayeredPane.DEFAULT_LAYER);

		compareDB2.setText("\u6bd4\u5bf9\u6570\u636e\u5e93\u8868\u6570\u636e");
		compareDB2.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				compareDB2MouseClicked(evt);
			}
		});
		compareDB2.setBounds(490, 300, 170, 25);
		jLayeredPane1.add(compareDB2, javax.swing.JLayeredPane.DEFAULT_LAYER);

		compareDB1.setText("\u6bd4\u5bf9\u6570\u636e\u5e93\u8868\u7ed3\u6784");
		compareDB1.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				compareDB1MouseClicked(evt);
			}
		});
		compareDB1.setBounds(310, 300, 160, 25);
		jLayeredPane1.add(compareDB1, javax.swing.JLayeredPane.DEFAULT_LAYER);

		index.setText("\u7d22\u5f15");
		index.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				indexMouseClicked(evt);
			}
		});
		index.setBounds(140, 300, 70, 25);
		jLayeredPane1.add(index, javax.swing.JLayeredPane.DEFAULT_LAYER);

		mytable.setModel(new javax.swing.table.DefaultTableModel(
				new Object[][] {

				}, new String[] { "索引名称", "索引类型", "列名" }) {
			boolean[] canEdit = new boolean[] { false, false, false };

			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return canEdit[columnIndex];
			}
		});
		jScrollPane3.setViewportView(mytable);

		jScrollPane3.setBounds(20, 350, 760, 90);
		jLayeredPane1.add(jScrollPane3, javax.swing.JLayeredPane.DEFAULT_LAYER);

		keyvalue.setText("\u952e\u503c");
		keyvalue.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				keyvalueMouseClicked(evt);
			}
		});
		keyvalue.setBounds(220, 300, 70, 25);
		jLayeredPane1.add(keyvalue, javax.swing.JLayeredPane.DEFAULT_LAYER);

		submit.setText("\u786e\u5b9a");
		submit.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				submitMouseClicked(evt);
			}
		});
		submit.setBounds(607, 440, 80, 25);
		jLayeredPane1.add(submit, javax.swing.JLayeredPane.DEFAULT_LAYER);

		quit.setText("\u53d6\u6d88");
		quit.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				quitActionPerformed(evt);
			}
		});
		quit.setBounds(700, 440, 80, 25);
		jLayeredPane1.add(quit, javax.swing.JLayeredPane.DEFAULT_LAYER);

		jLabel1.setText("\u952e\u503c\u4fe1\u606f\uff1a");
		jLabel1.setBounds(20, 330, 230, 17);
		jLayeredPane1.add(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

		redTips.setForeground(new java.awt.Color(255, 0, 0));
		redTips.setText("*\u6ce8\uff1a\u9009\u62e9\u597d\u9700\u5bfc\u5165\u7684\u8868\u540e\uff0c\u8bf7\u8bbe\u7f6e\u5176\u5bf9\u5e94\u7684\u4e2d\u6587\u540d\u548c\u82f1\u6587\u540d\u3002");
		redTips.setBounds(10, 0, 390, 20);
		jLayeredPane1.add(redTips, javax.swing.JLayeredPane.DEFAULT_LAYER);
		backImage.setBounds(0, 0, 800, 480);
		jLayeredPane1.add(backImage, javax.swing.JLayeredPane.DEFAULT_LAYER);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jLayeredPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 799,
				Short.MAX_VALUE));
		layout.setVerticalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jLayeredPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 478,
				Short.MAX_VALUE));

		pack();
	}// </editor-fold>
	//GEN-END:initComponents

	private void compareDB2MouseClicked(java.awt.event.MouseEvent evt) {
		// 新窗口
		CompareDataFrame comparedataframe = new CompareDataFrame(connargs, null);
		int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
		int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
		comparedataframe.setLocation(screenWidth / 2 - comparedataframe.getWidth() / 2,
				screenHeight / 2 - comparedataframe.getHeight() / 2);
		comparedataframe.setVisible(true);
		this.setVisible(false);
	}

	private void quitActionPerformed(java.awt.event.ActionEvent evt) {
		//关闭程序
		if (JOptionPane.OK_OPTION == JOptionPane.showConfirmDialog(this,
				"确认退出吗？", "确认退出", JOptionPane.OK_CANCEL_OPTION)) {
			System.exit(0);
		}
	}

	private void submitMouseClicked(java.awt.event.MouseEvent evt) {
		//弹出选择的表名
		String tablename = "";
		for (int i = 0; i < tableInfo.getRowCount(); i++) {
			if ((Boolean) tableInfo.getValueAt(i, 0)) {
				tablename += "," + tableInfo.getValueAt(i, 1);
			}
		}
		if ("".equals(tablename)) {
			JOptionPane.showMessageDialog(this, "没有选择表！");
		} else {
			JOptionPane.showMessageDialog(this,"当前选择的表为:" + tablename.substring(1));
		}
	}

	private void compareDB1MouseClicked(java.awt.event.MouseEvent evt) {
		// 转到新的比对页面	
		CompareFrame compareframe = new CompareFrame(connargs, null);
		int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
		int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
		compareframe.setLocation(screenWidth / 2 - compareframe.getWidth() / 2,
				screenHeight / 2 - compareframe.getHeight() / 2);
		compareframe.setVisible(true);
		this.setVisible(false);
	}

	private void keyvalueMouseClicked(java.awt.event.MouseEvent evt) {
		this.jLabel1.setText("键值信息");
		int rowNumber = tableInfo.getSelectedRow();
		if (rowNumber == -1) {
			JOptionPane.showMessageDialog(this, "请在上表中选择所需显示的表名！");
			return;
		}
		String tablename = tableInfo.getValueAt(rowNumber, 1).toString();
		List<List> list = Tool.getKeys(tablename, connargs);
		DefaultTableModel defaulttable = null;
		String[] name = { "约束名称", "列名", "参照表", "参照列" };
		Object[][] data = new Object[list.size()][4];
		for (int i = 0; i < list.size(); i++) {
			List temp = list.get(i);
			for (int j = 0; j < temp.size(); j++) {
				data[i][j] = temp.get(j);
			}
		}
		defaulttable = new DefaultTableModel(data, name);
		mytable.setModel(defaulttable);
	}

	private void indexMouseClicked(java.awt.event.MouseEvent evt) {
		this.jLabel1.setText("索引信息");
		int rowNumber = tableInfo.getSelectedRow();
		if (rowNumber == -1) {
			JOptionPane.showMessageDialog(this, "请在上表中选择所需显示的表名！");
			return;
		}
		String tablename = tableInfo.getValueAt(rowNumber, 1).toString();
		List<List> list = Tool.queryAllname(tablename, connargs);
		DefaultTableModel defaulttable = null;
		String[] name = { "索引名称", "索引类型", "列名" };
		String[][] data = new String[list.size()][3];

		for (int i = 0; i < list.size(); i++) {
			data[i][0] = list.get(i).get(5) == null ? "null" : list.get(i)
					.get(5).toString();
			data[i][1] = list.get(i).get(13) == null ? "null" : list.get(i)
					.get(13).toString();
			data[i][2] = list.get(i).get(7) == null ? "null" : list.get(i)
					.get(7).toString();
		}
		defaulttable = new DefaultTableModel(data, name);
		mytable.setModel(defaulttable);
	}

	private void checkMouseClicked(java.awt.event.MouseEvent evt) {
		this.jLabel1.setText("check约束");
		int rowNumber = tableInfo.getSelectedRow();
		if (rowNumber == -1) {
			JOptionPane.showMessageDialog(this, "请在上表中选择所需显示的表名！");
			return;
		}
		String tablename = tableInfo.getValueAt(rowNumber, 1).toString();
		List<List> list = Tool.queryAllname1(tablename, connargs);
		DefaultTableModel defaulttable = null;
		String[] name = { "约束名称", "描述" };
		String[][] data = new String[list.size()][2];

		for (int i = 0; i < list.size(); i++) {
			data[i][0] = list.get(i).get(2) == null ? "null" : list.get(i)
					.get(2).toString();
			data[i][1] = list.get(i).get(5) == null ? "null" : list.get(i)
					.get(5).toString();
		}
		defaulttable = new DefaultTableModel(data, name);
		mytable.setModel(defaulttable);
	}

	private void tableInfoMouseClicked(java.awt.event.MouseEvent evt) {
		String tablename = tableInfo.getValueAt(tableInfo.getSelectedRow(), 1)
				.toString();
		List<List> listfields = Tool.getFields(tablename, connargs);
		Object[][] columnkey = new Object[listfields.size()][5];
		for (int i = 0; i < listfields.size(); i++) {
			List temp = listfields.get(i);
			for (int j = 0; j < temp.size(); j++) {
				if (j == 2) {
					if ("NO".equals(temp.get(j) == null ? "" : temp.get(j)
							.toString())) {
						columnkey[i][j] = false;
					} else {
						columnkey[i][j] = true;
					}
				} else {
					columnkey[i][j] = temp.get(j);
				}

			}
		}
		columnInfo.setModel(new javax.swing.table.DefaultTableModel(columnkey,
				new String[] { "列名", "列类型", "可否为空", "默认值", "列描述" }) {
			Class[] types = new Class[] { java.lang.String.class,
					java.lang.String.class, java.lang.Boolean.class,
					java.lang.String.class, java.lang.String.class };
			boolean[] canEdit = new boolean[] { false, false, false, false,
					false };

			public Class getColumnClass(int columnIndex) {
				return types[columnIndex];
			}

			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return canEdit[columnIndex];
			}
		});

		checkMouseClicked(evt);//点击事件同时触发check约束的显示
	}

	//GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.JLabel backImage;
	private javax.swing.JButton check;
	private javax.swing.JTable columnInfo;
	private javax.swing.JButton compareDB1;
	private javax.swing.JButton compareDB2;
	private javax.swing.JButton index;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLayeredPane jLayeredPane1;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JScrollPane jScrollPane2;
	private javax.swing.JScrollPane jScrollPane3;
	private javax.swing.JButton keyvalue;
	private javax.swing.JTable mytable;
	private javax.swing.JButton quit;
	private javax.swing.JLabel redTips;
	private javax.swing.JButton submit;
	private javax.swing.JTable tableInfo;
	// End of variables declaration//GEN-END:variables

}