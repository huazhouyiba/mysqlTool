/*
 * CompareFrame.java
 *
 * Created on __DATE__, __TIME__
 */

package com.dh.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Toolkit;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import com.dh.service.GetTableUtil;
import com.dh.service.Tool;

import dbBase.entity.Clomun;
import dbBase.entity.ConnArgs;
import dbBase.entity.Point;
import dbBase.service.CompareTables;
import dbBase.util.DBcon;

/**
 * 
 * @author __USER__
 */
public class CompareFrame extends javax.swing.JFrame {

	//用来接收页面传过来的链接对象信息或者保留页面重新生成的第一个DB链接
	private static ConnArgs connargs1;
	//用来保存页面输入的第二个数据库链接对象
	private static ConnArgs connargs2;

	private static Object[][] model1; // 存放tableInfo1的初始化数据
	private static Object[][] model2;

	/** Creates new form CompareFrame */
	public CompareFrame() {
		initComponents();
	}

	public CompareFrame(ConnArgs conn1, ConnArgs conn2) {
		initComponents();
		connargs1 = conn1;//保存第一个链接对象
		connargs2 = conn2;
		List<String> allTablesName1 = GetTableUtil.getAllTables(connargs1);
		Object[][] tableinfo1 = new Object[allTablesName1.size()][4];
		for (int i = 0; i < allTablesName1.size(); i++) {
			tableinfo1[i][0] = false;
			tableinfo1[i][1] = allTablesName1.get(i);
			tableinfo1[i][2] = "请输入中文名称！";
			tableinfo1[i][3] = allTablesName1.get(i);
		}
		model1=tableinfo1;
		tableInfo1.setModel(new javax.swing.table.DefaultTableModel(tableinfo1,
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
		//如果数据库二链接为空，就不执行查询操作
		if (null == connargs2 || null == connargs2.getConn()) {			
			return;
		}
		List<String> allTablesName2 = GetTableUtil.getAllTables(connargs2);
		Object[][] tableinfo2 = new Object[allTablesName2.size()][4];
		for (int i = 0; i < allTablesName2.size(); i++) {
			tableinfo2[i][0] = false;
			tableinfo2[i][1] = allTablesName2.get(i);
			tableinfo2[i][2] = "请输入中文名称！";
			tableinfo2[i][3] = allTablesName2.get(i);
		}
		model2=tableinfo2;
		tableInfo2.setModel(new javax.swing.table.DefaultTableModel(tableinfo2,
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
		jLabel5 = new javax.swing.JLabel();
		jLabel4 = new javax.swing.JLabel();
		jScrollPane4 = new javax.swing.JScrollPane();
		tableInfo1 = new javax.swing.JTable();
		jScrollPane1 = new javax.swing.JScrollPane();
		tableInfo2 = new javax.swing.JTable();
		jScrollPane2 = new javax.swing.JScrollPane();
		mytable2 = new javax.swing.JTable();
		check1 = new javax.swing.JButton();
		columnInfo1 = new javax.swing.JButton();
		index1 = new javax.swing.JButton();
		jScrollPane3 = new javax.swing.JScrollPane();
		mytable1 = new javax.swing.JTable();
		jScrollPane5 = new javax.swing.JScrollPane();
		compareTable = new javax.swing.JTable();
		keyvalue1 = new javax.swing.JButton();
		columnInfo2 = new javax.swing.JButton();
		check2 = new javax.swing.JButton();
		index2 = new javax.swing.JButton();
		keyvalue2 = new javax.swing.JButton();
		choiceDBtwo = new javax.swing.JButton();
		choiceDBone = new javax.swing.JButton();
		submitA_B = new javax.swing.JButton();
		submitB_A = new javax.swing.JButton();
		jLabel1 = new javax.swing.JLabel();
		backImage = new javax.swing.JLabel();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle("\u6570\u636e\u5e93\u8868\u7ed3\u6784\u6bd4\u5bf9\u7a97\u53e3");

		jLabel3.setText("\u5217\u8be6\u60c5\uff1a");
		jLabel3.setBounds(480, 260, 80, 17);
		jLayeredPane1.add(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);

		jLabel5.setText("\u6570\u636e\u5e93\u4e00\u6240\u6709\u8868\uff1a");
		jLabel5.setBounds(30, 30, 120, 17);
		jLayeredPane1.add(jLabel5, javax.swing.JLayeredPane.DEFAULT_LAYER);

		jLabel4.setText("\u6570\u636e\u5e93\u4e8c\u6240\u6709\u8868\uff1a");
		jLabel4.setBounds(490, 30, 120, 17);
		jLayeredPane1.add(jLabel4, javax.swing.JLayeredPane.DEFAULT_LAYER);

		tableInfo1.setModel(new javax.swing.table.DefaultTableModel(
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
		tableInfo1.setToolTipText("");
		tableInfo1.setName("");
		tableInfo1.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				tableInfo1MouseClicked(evt);
			}

			public void mousePressed(java.awt.event.MouseEvent evt) {
				tableInfo1MousePressed(evt);
			}
		});
		jScrollPane4.setViewportView(tableInfo1);

		jScrollPane4.setBounds(20, 50, 450, 200);
		jLayeredPane1.add(jScrollPane4, javax.swing.JLayeredPane.DEFAULT_LAYER);

		tableInfo2.setModel(new javax.swing.table.DefaultTableModel(
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
		tableInfo2.setToolTipText("");
		tableInfo2.setName("");
		tableInfo2.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				tableInfo2MouseClicked(evt);
			}

			public void mousePressed(java.awt.event.MouseEvent evt) {
				tableInfo2MousePressed(evt);
			}
		});
		jScrollPane1.setViewportView(tableInfo2);

		jScrollPane1.setBounds(480, 50, 440, 200);
		jLayeredPane1.add(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);

		mytable2.setModel(new javax.swing.table.DefaultTableModel(
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
		jScrollPane2.setViewportView(mytable2);

		jScrollPane2.setBounds(480, 280, 440, 130);
		jLayeredPane1.add(jScrollPane2, javax.swing.JLayeredPane.DEFAULT_LAYER);

		check1.setText("check\u7ea6\u675f");
		check1.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				check11MouseClicked(evt);
			}
		});
		check1.setBounds(210, 250, 100, 25);
		jLayeredPane1.add(check1, javax.swing.JLayeredPane.DEFAULT_LAYER);

		columnInfo1.setText("\u5217\u4fe1\u606f");
		columnInfo1.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				columnInfo1MouseClicked(evt);
			}
		});
		columnInfo1.setBounds(120, 250, 80, 25);
		jLayeredPane1.add(columnInfo1, javax.swing.JLayeredPane.DEFAULT_LAYER);

		index1.setText("\u7d22\u5f15");
		index1.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				index11MouseClicked(evt);
			}
		});
		index1.setBounds(320, 250, 70, 25);
		jLayeredPane1.add(index1, javax.swing.JLayeredPane.DEFAULT_LAYER);

		mytable1.setModel(new javax.swing.table.DefaultTableModel(
				new Object[][] {

				}, new String[] { "列名", "列类型", "可否为空", "默认值", "列描述" }) {
			Class[] types = new Class[] { java.lang.Object.class,
					java.lang.Object.class, java.lang.Boolean.class,
					java.lang.Object.class, java.lang.Object.class };
			boolean[] canEdit = new boolean[] { false, false, false, false,
					false };

			public Class getColumnClass(int columnIndex) {
				return types[columnIndex];
			}

			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return canEdit[columnIndex];
			}
		});
		jScrollPane3.setViewportView(mytable1);
		mytable1.getAccessibleContext().setAccessibleName("");

		jScrollPane3.setBounds(20, 280, 450, 130);
		jLayeredPane1.add(jScrollPane3, javax.swing.JLayeredPane.DEFAULT_LAYER);

		compareTable.setModel(new javax.swing.table.DefaultTableModel(
				new Object[][] {

				}, new String[] { "字段名称1", "数据类型1", "长度1", "可否为空1", "默认值1",
						"字段名称2", "数据类型2", "长度2", "可否为空2", "默认值2" }) {
			boolean[] canEdit = new boolean[] { false, false, false, false,
					false, false, false, false, false, false };

			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return canEdit[columnIndex];
			}
		});
		jScrollPane5.setViewportView(compareTable);

		jScrollPane5.setBounds(20, 420, 900, 220);
		jLayeredPane1.add(jScrollPane5, javax.swing.JLayeredPane.DEFAULT_LAYER);

		keyvalue1.setText("\u952e\u503c");
		keyvalue1.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				keyvalue11MouseClicked(evt);
			}
		});
		keyvalue1.setBounds(400, 250, 70, 25);
		jLayeredPane1.add(keyvalue1, javax.swing.JLayeredPane.DEFAULT_LAYER);

		columnInfo2.setText("\u5217\u4fe1\u606f");
		columnInfo2.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				columnInfo2MouseClicked(evt);
			}
		});
		columnInfo2.setBounds(570, 250, 80, 25);
		jLayeredPane1.add(columnInfo2, javax.swing.JLayeredPane.DEFAULT_LAYER);

		check2.setText("check\u7ea6\u675f");
		check2.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				check2MouseClicked(evt);
			}
		});
		check2.setBounds(660, 250, 100, 25);
		jLayeredPane1.add(check2, javax.swing.JLayeredPane.DEFAULT_LAYER);

		index2.setText("\u7d22\u5f15");
		index2.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				index2MouseClicked(evt);
			}
		});
		index2.setBounds(770, 250, 70, 25);
		jLayeredPane1.add(index2, javax.swing.JLayeredPane.DEFAULT_LAYER);

		keyvalue2.setText("\u952e\u503c");
		keyvalue2.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				keyvalue2MouseClicked(evt);
			}
		});
		keyvalue2.setBounds(850, 250, 70, 25);
		jLayeredPane1.add(keyvalue2, javax.swing.JLayeredPane.DEFAULT_LAYER);

		choiceDBtwo.setText("\u9009\u62e9\u6570\u636e\u5e93\u4e8c");
		choiceDBtwo.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				choiceDBtwoActionPerformed(evt);
			}
		});
		choiceDBtwo.setBounds(651, 10, 120, 25);
		jLayeredPane1.add(choiceDBtwo, javax.swing.JLayeredPane.DEFAULT_LAYER);

		choiceDBone.setText("\u9009\u62e9\u6570\u636e\u5e93\u4e00");
		choiceDBone.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				choiceDBoneActionPerformed(evt);
			}
		});
		choiceDBone.setBounds(180, 10, 130, 25);
		jLayeredPane1.add(choiceDBone, javax.swing.JLayeredPane.DEFAULT_LAYER);

		submitA_B
				.setText("\u6570\u636e\u5e93\u4e00\u540c\u6b65\u81f3\u6570\u636e\u5e93\u4e8c(B--->A)");
		submitA_B.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				submitA_BMouseClicked(evt);
			}
		});
		submitA_B.setBounds(140, 650, 220, 25);
		jLayeredPane1.add(submitA_B, javax.swing.JLayeredPane.DEFAULT_LAYER);

		submitB_A
				.setText("\u6570\u636e\u5e93\u4e8c\u540c\u6b65\u81f3\u6570\u636e\u5e93\u4e00(A--->B)");
		submitB_A.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				submitB_AMouseClicked(evt);
			}
		});
		submitB_A.setBounds(590, 650, 220, 25);
		jLayeredPane1.add(submitB_A, javax.swing.JLayeredPane.DEFAULT_LAYER);

		jLabel1.setText("\u5217\u8be6\u60c5\uff1a");
		jLabel1.setBounds(20, 260, 90, 17);
		jLayeredPane1.add(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
		backImage.setBounds(0, 0, 940, 680);
		jLayeredPane1.add(backImage, javax.swing.JLayeredPane.DEFAULT_LAYER);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jLayeredPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 938,
				Short.MAX_VALUE));
		layout.setVerticalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jLayeredPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 681,
				Short.MAX_VALUE));

		pack();
	}// </editor-fold>
	//GEN-END:initComponents

	private void tableInfo2MousePressed(java.awt.event.MouseEvent evt) {
		tableInfo1.setModel(new javax.swing.table.DefaultTableModel(model1,
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

	private void tableInfo1MousePressed(java.awt.event.MouseEvent evt) {	
		tableInfo2.setModel(new javax.swing.table.DefaultTableModel(model2,
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

	/**
	 * 设置表中的某一行为选中状态
	 * @param table  表名
	 * @param rowNumber 行索引
	 */
	private void rowSelected(JTable table, int rowNumber) {
		table.setRowSelectionInterval(rowNumber, rowNumber);
	}

	/**
	 * 动态插入一空行
	 * @param table 要插入的表名
	 * @param rowNumber 要插入的行号(注意：会在此行号处进行插入，而不是在此行号后进行追加)
	 */
	private void insertRow(JTable table, int rowNumber) {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		for (int i = model.getRowCount(); i < rowNumber; i++) {
			model.insertRow(i, new Object[] {false}); //如果要追加的那个表中的总行数小于要动态追加的行号，要在此行号之前增加空白行，否则会下标越界
		}
		model.insertRow(rowNumber, new Object[] {false});//动态追加行    
		table.setModel(model);
	}

	/**
	 * 删除表格中的空行，即动态插入行
	 * @param table 表名
	 */
	private void deleteRow(JTable table) {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		for (int i = 0; i < table.getRowCount(); i++) {
			String temp = table.getValueAt(i, 1) == null ? "" : table
					.getValueAt(i, 1).toString();
			String temp1 = table.getValueAt(i, 2) == null ? "" : table
					.getValueAt(i, 2).toString();
			if ("".equals(temp) || temp.trim().length() == 0
					|| "".equals(temp1) || temp1.trim().length() == 0) {
				model.removeRow(i); // 此操作为了在删除空白行
				i--; // 下标回退，否则会跳过下一行空白				
			}
		}
	}

	private void submitB_AMouseClicked(java.awt.event.MouseEvent evt) {
		// 弹出选择的表名
		String tablename1 = "";
		for (int i = 0; i < tableInfo1.getRowCount(); i++) {
			if ((Boolean) tableInfo1.getValueAt(i, 0)) {
				tablename1 += tableInfo1.getValueAt(i, 1);
				break;
			}
		}
		if ("".equals(tablename1)) {
			JOptionPane.showMessageDialog(this, "请在数据库一中选择要同步的表!(库一-->库二)");
			return;
		}

		String tablename2 = "";
		for (int i = 0; i < tableInfo2.getRowCount(); i++) {
			if ((Boolean) tableInfo2.getValueAt(i, 0)) {
				tablename2 += tableInfo2.getValueAt(i, 1);
				break;
			}
		}
		if ("".equals(tablename2)) {
			JOptionPane.showMessageDialog(this, "请在数据库二中选择被同步的表!");
			return;
		}
		if (JOptionPane.OK_CANCEL_OPTION == JOptionPane.showConfirmDialog(this,
				"确定从表" + tablename1 + "到表" + tablename2 + "?", "确认导表?",
				JOptionPane.OK_CANCEL_OPTION)) {
			return;
		}
		//SQL_Frame	(A-->B)
		SQL_Frame sqlframe = new SQL_Frame(connargs2, connargs1, tablename2,
				tablename1, "同步表结构:AtoB");
		int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
		int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
		sqlframe.setLocation(screenWidth / 2 - sqlframe.getWidth() / 2,
				screenHeight / 2 - sqlframe.getHeight() / 2);
		sqlframe.setVisible(true);
		this.setVisible(false);
	}

	private void submitA_BMouseClicked(java.awt.event.MouseEvent evt) {
		String tablename2 = "";
		for (int i = 0; i < tableInfo2.getRowCount(); i++) {
			if ((Boolean) tableInfo2.getValueAt(i, 0)) {
				tablename2 += tableInfo2.getValueAt(i, 1);
				break;
			}
		}
		if ("".equals(tablename2)) {
			JOptionPane.showMessageDialog(this, "请在数据库二中选择要同步的表!(库二-->库一)");
			return;
		}

		String tablename1 = "";
		for (int i = 0; i < tableInfo1.getRowCount(); i++) {
			if ((Boolean) tableInfo1.getValueAt(i, 0)) {
				tablename1 += tableInfo1.getValueAt(i, 1);
				break;
			}
		}
		if ("".equals(tablename1)) {
			JOptionPane.showMessageDialog(this, "请在数据库一中选择被同步的表!");
			return;
		}
		if (JOptionPane.OK_CANCEL_OPTION == JOptionPane.showConfirmDialog(this,
				"确定从表" + tablename2 + "到表" + tablename1 + "?", "确认导表?",
				JOptionPane.OK_CANCEL_OPTION)) {
			return;
		}
		//SQL_Frame	(B-->A)	
		SQL_Frame sqlframe = new SQL_Frame(connargs1, connargs2, tablename1,
				tablename2, "同步表结构:BtoA");
		int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
		int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
		sqlframe.setLocation(screenWidth / 2 - sqlframe.getWidth() / 2,
				screenHeight / 2 - sqlframe.getHeight() / 2);
		sqlframe.setVisible(true);
		this.setVisible(false);
	}

	private void choiceDBtwoActionPerformed(java.awt.event.ActionEvent evt) {
		ChoiceDBframe DBone = new ChoiceDBframe(2, "表结构");
		int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
		int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
		DBone.setLocation(screenWidth / 2 - DBone.getWidth() / 2, screenHeight
				/ 2 - DBone.getHeight() / 2);
		DBone.setVisible(true);
		this.setVisible(false);
	}

	private void choiceDBoneActionPerformed(java.awt.event.ActionEvent evt) {
		ChoiceDBframe DBone = new ChoiceDBframe(1, "表结构");
		int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
		int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
		DBone.setLocation(screenWidth / 2 - DBone.getWidth() / 2, screenHeight
				/ 2 - DBone.getHeight() / 2);
		DBone.setVisible(true);
		this.setVisible(false);
	}

	private void keyvalue2MouseClicked(java.awt.event.MouseEvent evt) {
		if (!checkConnargs2()) {
			return;
		}
		this.jLabel3.setText("键值信息");
		int rowNumber = tableInfo2.getSelectedRow();
		if (rowNumber == -1) {
			JOptionPane.showMessageDialog(this, "请在上表中选择所需显示的表名！");
			return;
		}
		String tablename = tableInfo2.getValueAt(rowNumber, 1).toString();
		List<List> list = Tool.getKeys(tablename, connargs2);
		DefaultTableModel defaulttable = null;
		String[] name = { "键名", "列名", "约束位置（若为外键值为1）", "外键所属表名", "外键所属列名" };
		Object[][] data = new Object[list.size()][5];
		for (int i = 0; i < list.size(); i++) {
			List temp = list.get(i);
			for (int j = 0; j < temp.size(); j++) {
				data[i][j] = temp.get(j);
			}
		}
		defaulttable = new DefaultTableModel(data, name);
		mytable2.setModel(defaulttable);
	}

	private void index2MouseClicked(java.awt.event.MouseEvent evt) {
		if (!checkConnargs2()) {
			return;
		}
		this.jLabel3.setText("索引信息");
		int rowNumber = tableInfo2.getSelectedRow();
		if (rowNumber == -1) {
			JOptionPane.showMessageDialog(this, "请在上表中选择所需显示的表名！");
			return;
		}
		String tablename = tableInfo2.getValueAt(rowNumber, 1).toString();
		List<List> list = Tool.queryAllname(tablename, connargs2);
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
		mytable2.setModel(defaulttable);
	}

	private void check2MouseClicked(java.awt.event.MouseEvent evt) {
		if (!checkConnargs2()) {
			return;
		}
		this.jLabel3.setText("check约束");
		int rowNumber = tableInfo2.getSelectedRow();
		if (rowNumber == -1) {
			JOptionPane.showMessageDialog(this, "请在上表中选择所需显示的表名！");
			return;
		}
		String tablename = tableInfo2.getValueAt(rowNumber, 1).toString();
		List<List> list = Tool.queryAllname1(tablename, connargs2);
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
		mytable2.setModel(defaulttable);
	}

	private void columnInfo1MouseClicked(java.awt.event.MouseEvent evt) {
		this.jLabel1.setText("列信息");
		int rowNumber = tableInfo1.getSelectedRow();
		if (rowNumber == -1) {
			JOptionPane.showMessageDialog(this, "请在上表中选择所需显示的表名！");
			return;
		}
		String tablename = tableInfo1.getValueAt(rowNumber, 1).toString();
		List<List> listfields = Tool.getFields(tablename, connargs1);
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
		mytable1.setModel(new javax.swing.table.DefaultTableModel(columnkey,
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
	}

	private void columnInfo1MouseClicked(String tablename) {
		this.jLabel1.setText("列信息");
		List<List> listfields = Tool.getFields(tablename, connargs1);
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
		mytable1.setModel(new javax.swing.table.DefaultTableModel(columnkey,
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
	}

	private void tableInfo2MouseClicked(java.awt.event.MouseEvent evt) {
		deleteRow(tableInfo2);
		mytable1Clear();
		mytable2Clear(); 
		//		// 如果数据库二链接为空，就不执行操作
		//		if (null == connargs2 || null == connargs2.getConn()) {
		//			return;
		//		}	
		int rowNumber2 = tableInfo2.getSelectedRow();
		if (rowNumber2 == -1) {
			return;
		}
		checkboxselected(tableInfo2);
		String tablename2 = tableInfo2.getValueAt(rowNumber2, 1).toString();
		for (int i = 0; i < tableInfo1.getRowCount(); i++) {
			if (tablename2.equals(tableInfo1.getValueAt(i, 1) == null ? ""
					: tableInfo1.getValueAt(i, 1).toString())) {
				rowSelected(tableInfo1, i);
				checkboxselected(tableInfo1);
				columnInfo1MouseClicked(tablename2);
				columnInfo2MouseClicked(tablename2);
				compareDisplay(tablename2, tablename2);
				return;
			}
		}
		insertRow(tableInfo1, rowNumber2);
		rowSelected(tableInfo1, rowNumber2);
		columnInfo2MouseClicked(tablename2);
		compareDisplay(tablename2, tablename2);
	}

	//检查connargs2是否为空，如果为空，给出提示！
	private boolean checkConnargs2() {
		if (null == connargs2 || null == connargs2.getHostaddr()
				|| null == connargs2.getConn()) {
			JOptionPane.showMessageDialog(this, "请先选择数据库二的连接信息！");
			return false;
		}
		return true;
	}

	private void columnInfo2MouseClicked(java.awt.event.MouseEvent evt) {
		if (!checkConnargs2()) {
			return;
		}
		this.jLabel3.setText("列信息");
		int rowNumber = tableInfo2.getSelectedRow();
		if (rowNumber == -1) {
			JOptionPane.showMessageDialog(this, "请在上表中选择所需显示的表名！");
			return;
		}
		String tablename = tableInfo2.getValueAt(rowNumber, 1).toString();
		List<List> listfields = Tool.getFields(tablename, connargs2);
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
		mytable2.setModel(new javax.swing.table.DefaultTableModel(columnkey,
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
	}

	private void columnInfo2MouseClicked(String tablename) {
		// 如果数据库二链接为空，就不执行查询操作
		if (null == connargs2 || null == connargs2.getConn()) {
			return;
		}
		this.jLabel3.setText("列信息");
		List<List> listfields = Tool.getFields(tablename, connargs2);
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
		mytable2.setModel(new javax.swing.table.DefaultTableModel(columnkey,
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
	}

	private void tableInfo1MouseClicked(java.awt.event.MouseEvent evt) {
		deleteRow(tableInfo1);
		mytable1Clear();
		mytable2Clear(); 
		// 显示列信息
		int rowNumber1 = tableInfo1.getSelectedRow();
		if (rowNumber1 == -1) {
			return;
		}
		checkboxselected(tableInfo1);
		String tablename1 = tableInfo1.getValueAt(rowNumber1, 1).toString();
		if (null == connargs2 || null == connargs2.getHostaddr()
				|| null == connargs2.getDbname()) {
			columnInfo1MouseClicked(tablename1);
			compareDisplay(tablename1, tablename1);
			return;
		}
		for (int i = 0; i < tableInfo2.getRowCount(); i++) {
			if (tablename1.equals(tableInfo2.getValueAt(i, 1) == null ? ""
					: tableInfo2.getValueAt(i, 1).toString())) {
				rowSelected(tableInfo2, i);
				checkboxselected(tableInfo2);
				columnInfo1MouseClicked(tablename1);
				columnInfo2MouseClicked(tablename1);
				compareDisplay(tablename1, tablename1);
				return;
			}
		}
		insertRow(tableInfo2, rowNumber1);
		rowSelected(tableInfo2, rowNumber1);
		columnInfo1MouseClicked(tablename1);
		compareDisplay(tablename1, tablename1);
	}

	private void mytable2Clear() {
		mytable2.setModel(new javax.swing.table.DefaultTableModel(
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
		
	}

	private void mytable1Clear() {
		mytable1.setModel(new javax.swing.table.DefaultTableModel(
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
		
	}

	private void checkboxselected(JTable tableInfo) {
		int rowNumber1 = tableInfo.getSelectedRow();
		for (int i = 0; i < tableInfo.getRowCount(); i++) {
			if (tableInfo.getValueAt(i, 0) != null
					&& (Boolean) tableInfo.getValueAt(i, 0)) {
				tableInfo.setValueAt(false, i, 0);
			}
		}
		if(rowNumber1==-1){
			return;
		}
		tableInfo.setValueAt(true, rowNumber1, 0);
	}

	private void submitMouseClicked(java.awt.event.MouseEvent evt) {
		// 弹出选择的表名
		// String tablename = "";
		// for (int i = 0; i < tableInfo2.getRowCount(); i++) {
		// if ((Boolean) tableInfo2.getValueAt(i, 0)) {
		// tablename += "," + tableInfo2.getValueAt(i, 1);
		// }
		// }
		// if ("".equals(tablename)) {
		// JOptionPane.showMessageDialog(this, "没有选择表！");
		// } else {
		// JOptionPane.showMessageDialog(this,
		// "当前选择的表为:" + tablename.substring(1));
		// }
		JOptionPane.showMessageDialog(this, "预留按钮！");
	}

	private void keyvalue11MouseClicked(java.awt.event.MouseEvent evt) {
		this.jLabel1.setText("键值信息");
		int rowNumber = tableInfo1.getSelectedRow();
		if (rowNumber == -1) {
			JOptionPane.showMessageDialog(this, "请在上表中选择所需显示的表名！");
			return;
		}
		String tablename = tableInfo1.getValueAt(rowNumber, 1).toString();
		List<List> list = Tool.getKeys(tablename, connargs1);
		DefaultTableModel defaulttable = null;
		String[] name = { "键名", "列名", "约束位置（若为外键值为1）", "外键所属表名", "外键所属列名" };
		Object[][] data = new Object[list.size()][5];
		for (int i = 0; i < list.size(); i++) {
			List temp = list.get(i);
			for (int j = 0; j < temp.size(); j++) {
				data[i][j] = temp.get(j);
			}
		}
		defaulttable = new DefaultTableModel(data, name);
		mytable1.setModel(defaulttable);
	}

	private void index11MouseClicked(java.awt.event.MouseEvent evt) {
		this.jLabel1.setText("索引信息");
		int rowNumber = tableInfo1.getSelectedRow();
		if (rowNumber == -1) {
			JOptionPane.showMessageDialog(this, "请在上表中选择所需显示的表名！");
			return;
		}
		String tablename = tableInfo1.getValueAt(rowNumber, 1).toString();
		List<List> list = Tool.queryAllname(tablename, connargs1);
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
		mytable1.setModel(defaulttable);
	}

	private void compareDBMouseClicked(java.awt.event.MouseEvent evt) {
		// 转到新的比对页面
		CompareFrame compareframe = new CompareFrame();
		int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
		int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
		compareframe.setLocation(screenWidth / 2 - compareframe.getWidth() / 2,
				screenHeight / 2 - compareframe.getHeight() / 2);
		compareframe.setVisible(true);
		this.setVisible(false);
	}

	private void check11MouseClicked(java.awt.event.MouseEvent evt) {
		this.jLabel1.setText("check约束");
		int rowNumber = tableInfo1.getSelectedRow();
		if (rowNumber == -1) {
			JOptionPane.showMessageDialog(this, "请在上表中选择所需显示的表名！");
			return;
		}
		String tablename = tableInfo1.getValueAt(rowNumber, 1).toString();
		List<List> list = Tool.queryAllname1(tablename, connargs1);
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
		mytable1.setModel(defaulttable);
	}

	public void compareDisplay(String tablename1, String tablename2) {
		Map<String, List<Object>> map1 = new HashMap<String, List<Object>>();
		Map<String, List<Object>> map2 = new HashMap<String, List<Object>>();
		map1 = CompareTables.compareFiled("information_schema.COLUMNS",
				connargs1.getConn(), connargs1.getDbname(), tablename1);
		// 如果数据库二链接为空，就不执行查询操作
		if (null != connargs2 && null != connargs2.getConn()) {
			map2 = CompareTables.compareFiled("information_schema.COLUMNS",
					connargs2.getConn(), connargs2.getDbname(), tablename2);
		}
		map2 = CompareTables.comPare(map1, map2);
		map1 = CompareTables.comPare(map2, map1);
		List<List<Object>> list = CompareTables.combineMap(map1, map2);

		Object[][] compareNumber = new Object[list.size() / 2][10];

		if (map1.isEmpty()) {
			for (int j = 0; j < list.size() / 2; j++) {
				compareNumber[j][0] = "";
				compareNumber[j][1] = "";
				compareNumber[j][2] = "";
				compareNumber[j][3] = "";
				compareNumber[j][4] = "";
				compareNumber[j][5] = list.get(j * 2 + 1).get(
						Clomun.dBcolumnName);
				compareNumber[j][6] = list.get(j * 2 + 1)
						.get(Clomun.dBdataType);
				compareNumber[j][7] = list.get(j * 2 + 1).get(Clomun.dBmaxLen);
				compareNumber[j][8] = list.get(j * 2 + 1)
						.get(Clomun.dBnullAble);
				compareNumber[j][9] = list.get(j * 2 + 1).get(Clomun.dBdefault);
			}
		} else if (map2.isEmpty()) {
			for (int j = 0; j < list.size() / 2; j++) {
				compareNumber[j][0] = list.get(j * 2).get(Clomun.dBcolumnName);
				compareNumber[j][1] = list.get(j * 2).get(Clomun.dBdataType);
				compareNumber[j][2] = list.get(j * 2).get(Clomun.dBmaxLen);
				compareNumber[j][3] = list.get(j * 2).get(Clomun.dBnullAble);
				compareNumber[j][4] = list.get(j * 2).get(Clomun.dBdefault);
				compareNumber[j][5] = "";
				compareNumber[j][6] = "";
				compareNumber[j][7] = "";
				compareNumber[j][8] = "";
				compareNumber[j][9] = "";
			}
		} else {
			for (int j = 0; j < list.size() / 2; j++) {
				compareNumber[j][0] = list.get(j * 2).get(Clomun.dBcolumnName);
				compareNumber[j][1] = list.get(j * 2).get(Clomun.dBdataType);
				compareNumber[j][2] = list.get(j * 2).get(Clomun.dBmaxLen);
				compareNumber[j][3] = list.get(j * 2).get(Clomun.dBnullAble);
				compareNumber[j][4] = list.get(j * 2).get(Clomun.dBdefault);
				compareNumber[j][5] = list.get(j * 2 + 1).get(
						Clomun.dBcolumnName);
				compareNumber[j][6] = list.get(j * 2 + 1)
						.get(Clomun.dBdataType);
				compareNumber[j][7] = list.get(j * 2 + 1).get(Clomun.dBmaxLen);
				compareNumber[j][8] = list.get(j * 2 + 1)
						.get(Clomun.dBnullAble);
				compareNumber[j][9] = list.get(j * 2 + 1).get(Clomun.dBdefault);
			}
		}
		String[] name = new String[] { "字段名称1", "数据类型1", "长度1", "可否为空1",
				"默认值1", "字段名称2", "数据类型2", "长度2", "可否为空2", "默认值2" };

		compareTable.setModel(new javax.swing.table.DefaultTableModel(
				compareNumber, name) {
			boolean[] canEdit = new boolean[] { false, false, false, false,
					false, false, false, false, false, false };

			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return canEdit[columnIndex];
			}
		});

		showcolor(getPonitXY(compareNumber, name), name);
	}

	private List<Point> getPonitXY(Object[][] compareNumber, String[] name) {
		int temp = name.length / 2;
		List<Point> listpoint = new ArrayList<Point>();
		for (int i = 0; i < compareNumber.length; i++) {
			for (int j = 0; j < temp; j++) {
				compareNumber[i][j] = compareNumber[i][j] == null ? ""
						: compareNumber[i][j].toString();
				compareNumber[i][j + temp] = compareNumber[i][j + temp] == null ? ""
						: compareNumber[i][j + temp].toString();
				if (!compareNumber[i][j].equals(compareNumber[i][j + temp])) {
					Point point = new Point();
					point.setX(i);
					point.setY(j + temp);
					listpoint.add(point);
				}
			}
		}
		return listpoint;
	}

	// 显示出有差异数据的特殊颜色
	public void showcolor(final List<Point> listpoint, Object[] name) {

		// 新建列表现器------------------------//

		DefaultTableCellRenderer tcr = new DefaultTableCellRenderer() {

			public Component getTableCellRendererComponent(JTable table,
					Object value, boolean isSelected, boolean hasFocus,
					int row, int column)

			{

				Component cell = super.getTableCellRendererComponent(table,
						value, isSelected, hasFocus, row, column);

				String test = "";
				// 获取需要的坐标
				for (int i = 0; i < listpoint.size(); i++) {
					test += row == listpoint.get(i).getX()
							&& column == listpoint.get(i).getY();
				}

				boolean flag = test.contains("true");

				if (flag) {
					cell.setBackground(Color.pink);
				} else {
					cell.setBackground(Color.WHITE);
				}
				return cell;
			}
		};

		for (int i = 0; i < name.length; i++) {
			compareTable.getColumn(name[i]).setCellRenderer(tcr);
		}
	}

	//GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.JLabel backImage;
	private javax.swing.JButton check1;
	private javax.swing.JButton check2;
	private javax.swing.JButton choiceDBone;
	private javax.swing.JButton choiceDBtwo;
	private javax.swing.JButton columnInfo1;
	private javax.swing.JButton columnInfo2;
	private javax.swing.JTable compareTable;
	private javax.swing.JButton index1;
	private javax.swing.JButton index2;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLayeredPane jLayeredPane1;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JScrollPane jScrollPane2;
	private javax.swing.JScrollPane jScrollPane3;
	private javax.swing.JScrollPane jScrollPane4;
	private javax.swing.JScrollPane jScrollPane5;
	private javax.swing.JButton keyvalue1;
	private javax.swing.JButton keyvalue2;
	private javax.swing.JTable mytable1;
	private javax.swing.JTable mytable2;
	private javax.swing.JButton submitA_B;
	private javax.swing.JButton submitB_A;
	private javax.swing.JTable tableInfo1;
	private javax.swing.JTable tableInfo2;

	// End of variables declaration//GEN-END:variables

	public static ConnArgs getConnargs1() {
		return connargs1;
	}

	public static void setConnargs1(ConnArgs connargs1) {
		CompareFrame.connargs1 = connargs1;
	}

	public static ConnArgs getConnargs2() {
		return connargs2;
	}

	public static void setConnargs2(ConnArgs connargs2) {
		CompareFrame.connargs2 = connargs2;
	}

}