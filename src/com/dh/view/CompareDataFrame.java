/*
 * CompareDataFrame.java
 *
 * Created on __DATE__, __TIME__
 */

package com.dh.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.dh.service.GetTableUtil;
import com.dh.service.Tool;

import dbBase.entity.Clomun;
import dbBase.entity.ConnArgs;
import dbBase.entity.Point;
import dbBase.service.CompareData;
import dbBase.service.CompareTables;

/**
 * 
 * @author __USER__
 */
public class CompareDataFrame extends javax.swing.JFrame {

	// ��������ҳ�洫���������Ӷ�����Ϣ���߱���ҳ���������ɵĵ�һ��DB����
	private static ConnArgs connargs1;
	// ��������ҳ������ĵڶ������ݿ����Ӷ���
	private static ConnArgs connargs2;

	private static Object[][] model1; // ���tableInfo1�ĳ�ʼ������
	private static Object[][] model2;

	//�к����飬��һλ����һ�ζ�̬���ӵ����������ڶ�λΪ��־λ(0����δ���ģ�������ֵ��ʾ�Ѹ���)��������ľ�Ӧ�����´ζ�̬����һ��֮ǰ���Ȱ���һ�ζ�̬���ӵ���ɾ������
	//	private static int[] deleteRowNumber={0,0};

	/** Creates new form CompareDataFrame */
	public CompareDataFrame() {
		initComponents();
	}

	public CompareDataFrame(ConnArgs conn1, ConnArgs conn2) {
		initComponents();
		connargs1 = conn1;
		connargs2 = conn2;
		//		deleteRowNumber[1]=0;//ÿ���´����ҳ��ʱ����Ҫ��֤��־λΪ0���������Է�ֹʹ����һ���������������к���ɾ�����ε����ݡ�
		List<String> allTablesName1 = GetTableUtil.getAllTables(connargs1);
		Object[][] tableinfo1 = new Object[allTablesName1.size()][4];
		for (int i = 0; i < allTablesName1.size(); i++) {
			tableinfo1[i][0] = false;
			tableinfo1[i][1] = allTablesName1.get(i);
			tableinfo1[i][2] = "�������������ƣ�";
			tableinfo1[i][3] = allTablesName1.get(i);
		}
		model1=tableinfo1;
		tableInfo1.setModel(new javax.swing.table.DefaultTableModel(tableinfo1,
				new String[] { "", "����", "���ı���", "Ӣ�ı���" }) {
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
		// ������ݿ������Ϊ�գ��Ͳ�ִ�в�ѯ����
		if (null == connargs2 || null == connargs2.getConn()) {
			return;
		}
		List<String> allTablesName2 = GetTableUtil.getAllTables(connargs2);
		Object[][] tableinfo2 = new Object[allTablesName2.size()][4];
		for (int i = 0; i < allTablesName2.size(); i++) {
			tableinfo2[i][0] = false;
			tableinfo2[i][1] = allTablesName2.get(i);
			tableinfo2[i][2] = "�������������ƣ�";
			tableinfo2[i][3] = allTablesName2.get(i);
		}
		model2=tableinfo2;
		tableInfo2.setModel(new javax.swing.table.DefaultTableModel(tableinfo2,
				new String[] { "", "����", "���ı���", "Ӣ�ı���" }) {
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
		jScrollPane3 = new javax.swing.JScrollPane();
		mytable1 = new javax.swing.JTable();
		jScrollPane5 = new javax.swing.JScrollPane();
		compareTable = new javax.swing.JTable();
		choiceDBtwo = new javax.swing.JButton();
		choiceDBone = new javax.swing.JButton();
		submitA_B = new javax.swing.JButton();
		submitB_A = new javax.swing.JButton();
		jLabel1 = new javax.swing.JLabel();
		backImage = new javax.swing.JLabel();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle("\u6570\u636e\u5e93\u8868\u6570\u636e\u6bd4\u5bf9\u7a97\u53e3");

		jLabel3.setText("\u8868\u6570\u636e\uff1a");
		jLabel3.setBounds(520, 260, 80, 17);
		jLayeredPane1.add(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);

		jLabel5.setText("\u6570\u636e\u5e93\u4e00\u6240\u6709\u8868\uff1a");
		jLabel5.setBounds(30, 30, 120, 17);
		jLayeredPane1.add(jLabel5, javax.swing.JLayeredPane.DEFAULT_LAYER);

		jLabel4.setText("\u6570\u636e\u5e93\u4e8c\u6240\u6709\u8868\uff1a");
		jLabel4.setBounds(530, 30, 120, 17);
		jLayeredPane1.add(jLabel4, javax.swing.JLayeredPane.DEFAULT_LAYER);

		tableInfo1.setModel(new javax.swing.table.DefaultTableModel(
				new Object[][] {

				}, new String[] { "", "����", "���ı���", "Ӣ�ı���" }) {
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

		jScrollPane4.setBounds(20, 50, 480, 200);
		jLayeredPane1.add(jScrollPane4, javax.swing.JLayeredPane.DEFAULT_LAYER);

		tableInfo2.setModel(new javax.swing.table.DefaultTableModel(
				new Object[][] {

				}, new String[] { "", "����", "���ı���", "Ӣ�ı���" }) {
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

		jScrollPane1.setBounds(520, 50, 480, 200);
		jLayeredPane1.add(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);

		mytable2.setModel(new javax.swing.table.DefaultTableModel(
				new Object[][] {

				}, new String[] { "�ֶ� 1", "�ֶ� 2", "�ֶ� 3", "�ֶ� 4", "�ֶ� 5" }) {
			boolean[] canEdit = new boolean[] { false, false, false, false,
					false };

			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return canEdit[columnIndex];
			}
		});
		jScrollPane2.setViewportView(mytable2);

		jScrollPane2.setBounds(520, 280, 480, 130);
		jLayeredPane1.add(jScrollPane2, javax.swing.JLayeredPane.DEFAULT_LAYER);

		mytable1.setModel(new javax.swing.table.DefaultTableModel(
				new Object[][] {

				}, new String[] { "�ֶ� 1", "�ֶ� 2", "�ֶ� 3", "�ֶ� 4", "�ֶ� 5" }) {
			boolean[] canEdit = new boolean[] { false, false, false, false,
					false };

			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return canEdit[columnIndex];
			}
		});
		jScrollPane3.setViewportView(mytable1);

		jScrollPane3.setBounds(20, 280, 480, 130);
		jLayeredPane1.add(jScrollPane3, javax.swing.JLayeredPane.DEFAULT_LAYER);

		compareTable.setModel(new javax.swing.table.DefaultTableModel(
				new Object[][] {

				}, new String[] { "�ֶ�1", "�ֶ�2", "�ֶ�3", "�ֶ�4", "�ֶ�5", "�ֶ�1",
						"�ֶ�2", "�ֶ�3", "�ֶ�4", "�ֶ�5" }) {
			boolean[] canEdit = new boolean[] { false, false, false, false,
					false, false, false, false, false, false };

			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return canEdit[columnIndex];
			}
		});
		jScrollPane5.setViewportView(compareTable);

		jScrollPane5.setBounds(20, 420, 980, 220);
		jLayeredPane1.add(jScrollPane5, javax.swing.JLayeredPane.DEFAULT_LAYER);

		choiceDBtwo.setText("\u9009\u62e9\u6570\u636e\u5e93\u4e8c");
		choiceDBtwo.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				choiceDBtwoActionPerformed(evt);
			}
		});
		choiceDBtwo.setBounds(700, 10, 120, 25);
		jLayeredPane1.add(choiceDBtwo, javax.swing.JLayeredPane.DEFAULT_LAYER);

		choiceDBone.setText("\u9009\u62e9\u6570\u636e\u5e93\u4e00");
		choiceDBone.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				choiceDBoneActionPerformed(evt);
			}
		});
		choiceDBone.setBounds(200, 10, 130, 25);
		jLayeredPane1.add(choiceDBone, javax.swing.JLayeredPane.DEFAULT_LAYER);

		submitA_B
				.setText("\u6570\u636e\u5e93\u4e00\u540c\u6b65\u81f3\u6570\u636e\u5e93\u4e8c(B--->A)");
		submitA_B.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				submitA_BMouseClicked(evt);
			}
		});
		submitA_B.setBounds(150, 650, 220, 25);
		jLayeredPane1.add(submitA_B, javax.swing.JLayeredPane.DEFAULT_LAYER);

		submitB_A
				.setText("\u6570\u636e\u5e93\u4e8c\u540c\u6b65\u81f3\u6570\u636e\u5e93\u4e00(A--->B)");
		submitB_A.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				submitB_AMouseClicked(evt);
			}
		});
		submitB_A.setBounds(640, 650, 220, 25);
		jLayeredPane1.add(submitB_A, javax.swing.JLayeredPane.DEFAULT_LAYER);

		jLabel1.setText("\u8868\u6570\u636e\uff1a");
		jLabel1.setBounds(20, 260, 90, 17);
		jLayeredPane1.add(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
		backImage.setBounds(0, 0, 1020, 680);
		jLayeredPane1.add(backImage, javax.swing.JLayeredPane.DEFAULT_LAYER);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jLayeredPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1015,
				Short.MAX_VALUE));
		layout.setVerticalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jLayeredPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 680,
				Short.MAX_VALUE));

		pack();
	}// </editor-fold>
	//GEN-END:initComponents

	private void tableInfo2MouseClicked(java.awt.event.MouseEvent evt) {
		deleteRow(tableInfo2);
		compareTableClear();		
		int rowNumber2 = tableInfo2.getSelectedRow();
		if(rowNumber2==-1){
			return;
		}
		String tablename2 = tableInfo2.getValueAt(rowNumber2, 1)==null?"":tableInfo2.getValueAt(rowNumber2, 1).toString();
		if("".equals(tablename2)){
//			JOptionPane.showMessageDialog(this, "");
			return;
		}
		checkboxselected(tableInfo2);
		// int rowNumber1 = tableInfo1.getSelectedRow();
		// if (rowNumber1 == -1) {
		for (int i = 0; i < tableInfo1.getRowCount(); i++) {
			if (tablename2.equals(tableInfo1.getValueAt(i, 1) == null ? ""
					: tableInfo1.getValueAt(i, 1).toString())) {
				rowSelected(tableInfo1, i);
				checkboxselected(tableInfo1);
				columnInfo1Display(tablename2);
				columnInfo2Display(tablename2);
				compareDisplay(tablename2, tablename2);
				return;
			}
		}
		insertRow(tableInfo1, rowNumber2);
		rowSelected(tableInfo1, rowNumber2);
		columnInfo2Display(tablename2);
			//		} 
			//		else {
			//			String tablename1 = tableInfo1.getValueAt(rowNumber1, 1).toString();
			//			if (tablename2.equals(tablename1)) {
			//				columnInfo1Display(tablename1);
			//				columnInfo2Display(tablename2);
			//				compareDisplay(tablename1, tablename2);
			//				return;
			//			}else{				
			//				columnInfo2Display(tablename2);
			//				JOptionPane.showMessageDialog(this, "�������ݿ���ѡ��ı�������ͬ�������������ݱȶԣ�");
			//			}
			//			
			//		}
	
	}

	private void tableInfo1MouseClicked(java.awt.event.MouseEvent evt) {	
		deleteRow(tableInfo1);	
		compareTableClear();	
		int rowNumber1 = tableInfo1.getSelectedRow();
		if(rowNumber1==-1){
			return;
		}
		String tablename1 = tableInfo1.getValueAt(rowNumber1, 1)==null?"":tableInfo1.getValueAt(rowNumber1, 1).toString();
		if("".equals(tablename1)){
//			JOptionPane.showMessageDialog(this, "");
			return;
		}
		checkboxselected(tableInfo1);
		if (null == connargs2 || null == connargs2.getHostaddr()
				|| null == connargs2.getDbname()) {
			columnInfo1Display(tablename1);
			return;
		}
		//		int rowNumber1 = tableInfo1.getSelectedRow();
		//		if (rowNumber1 == -1) {
		for (int i = 0; i < tableInfo2.getRowCount(); i++) {
			if (tablename1.equals(tableInfo2.getValueAt(i, 1) == null ? ""
					: tableInfo2.getValueAt(i, 1).toString())) {
				rowSelected(tableInfo2, i);
				checkboxselected(tableInfo2);
				columnInfo1Display(tablename1);
				columnInfo2Display(tablename1);
				compareDisplay(tablename1, tablename1);
				return;
			}
		}
		insertRow(tableInfo2, rowNumber1);
		rowSelected(tableInfo2, rowNumber1);
		columnInfo1Display(tablename1);
	}

	private void tableInfo2MousePressed(java.awt.event.MouseEvent evt) {
		tableInfo1.setModel(new javax.swing.table.DefaultTableModel(
				model1, new String[] { "", "����", "���ı���", "Ӣ�ı���" }) {
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
				new String[] { "", "����", "���ı���", "Ӣ�ı���" }) {
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
	 * ��ʼ��compareTable����compareTable���
	 */
	private void compareTableClear() {
		compareTable.setModel(new javax.swing.table.DefaultTableModel(
				new Object[][] {}, new String[] { "�ֶ�1", "�ֶ�2", "�ֶ�3", "�ֶ�4",
						"�ֶ�5", "�ֶ�1", "�ֶ�2", "�ֶ�3", "�ֶ�4", "�ֶ�5" }) {
			boolean[] canEdit = new boolean[] { false, false, false, false,
					false, false, false, false, false, false };
			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return canEdit[columnIndex];
			}
		});
		compareTable
				.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);// ����Ϊƽ���п�
	}

	/**
	 * ���ñ��е�ĳһ��Ϊѡ��״̬
	 * @param table  ����
	 * @param rowNumber ������
	 */
	private void rowSelected(JTable table, int rowNumber) {
		table.setRowSelectionInterval(rowNumber, rowNumber);
	}

	/**
	 * ��̬����һ����
	 * @param table Ҫ����ı���
	 * @param rowNumber Ҫ������к�(ע�⣺���ڴ��кŴ����в��룬�������ڴ��кź����׷��)
	 */
	private void insertRow(JTable table, int rowNumber) {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		for (int i = model.getRowCount(); i < rowNumber; i++) {
			model.insertRow(i, new Object[] {false}); //���Ҫ׷�ӵ��Ǹ����е�������С��Ҫ��̬׷�ӵ��кţ�Ҫ�ڴ��к�֮ǰ���ӿհ��У�������±�Խ��			
		}
		model.insertRow(rowNumber, new Object[] {false});//��̬׷����    		
		table.setModel(model);	 
	}

	/**
	 * ɾ������еĿ��У�����̬������
	 * @param table ����
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
				model.removeRow(i); // �˲���Ϊ����ɾ���հ���
				i--;                // �±���ˣ������������һ��				
			}
		}
	}

	private void columnInfo1Display(String tablename) {
		// if (null == connargs1.getHostaddr() && null == connargs1.getDbname()
		// && null == connargs1.getUser()
		// && null == connargs1.getPassword()) {
		// return;
		// }
		List list = Tool.getDatas(tablename, connargs1);
		List columnname = (List) list.get(0);
		List datalist = (List) list.get(1);
		String[] name = new String[columnname.size()];
		for (int i = 0; i < columnname.size(); i++) {
			name[i] = columnname.get(i).toString();
		}
		Object[][] datas = new Object[datalist.size()][name.length];
		for (int i = 0; i < datalist.size(); i++) {
			List templist = (List) datalist.get(i);
			for (int j = 0; j < templist.size(); j++) {
				datas[i][j] = templist.get(j);
			}
		}
		final boolean[] editable = new boolean[name.length];
		mytable1.setModel(new javax.swing.table.DefaultTableModel(datas, name) {
			boolean[] canEdit = editable;

			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return canEdit[columnIndex];
			}
		});
		// Ϊ��ʹ������ʾ�������ۣ��������м�¼��ʹ��ˮƽ������
		if (mytable1.getColumnModel().getColumnCount() > 5) {
			mytable1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);// ˮƽ������
		} else {
			mytable1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);// ����Ϊƽ���п�
		}
		// for(int i=0;i<mytable1.getColumnModel().getColumnCount();i++){
		// TableColumn column=mytable1.getColumnModel().getColumn(i);
		// column.setPreferredWidth(300);
		// column.setMinWidth(100);
		// column.setMaxWidth(100);
		// }
	}

	private void columnInfo2Display(String tablename) {
		if (null == connargs2 || null == connargs2.getHostaddr()
				|| null == connargs2.getDbname()) {
			return;
		}
		List list = Tool.getDatas(tablename, connargs2);
		List columnname = (List) list.get(0);
		List datalist = (List) list.get(1);
		String[] name = new String[columnname.size()];
		for (int i = 0; i < columnname.size(); i++) {
			name[i] = columnname.get(i).toString();
		}
		Object[][] datas = new Object[datalist.size()][name.length];
		for (int i = 0; i < datalist.size(); i++) {
			List templist = (List) datalist.get(i);
			for (int j = 0; j < templist.size(); j++) {
				datas[i][j] = templist.get(j);
			}
		}
		final boolean[] editable = new boolean[name.length];
		mytable2.setModel(new javax.swing.table.DefaultTableModel(datas, name) {
			boolean[] canEdit = editable;

			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return canEdit[columnIndex];
			}
		});
		if (mytable2.getColumnModel().getColumnCount() > 5) {
			mytable2.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);// ˮƽ������
		} else {
			mytable2.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);// ����Ϊƽ���п�
		}
	}

	private void submitB_AMouseClicked(java.awt.event.MouseEvent evt) {
		// ����ѡ��ı���
		String tablename1 = "";
		for (int i = 0; i < tableInfo1.getRowCount(); i++) {
			if ((Boolean) tableInfo1.getValueAt(i, 0)) {
				tablename1 += tableInfo1.getValueAt(i, 1);
				break;
			}
		}
		if ("".equals(tablename1)) {
			JOptionPane.showMessageDialog(this, "�������ݿ�һ��ѡ��Ҫͬ���ı�!(��һ-->���)");
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
			JOptionPane.showMessageDialog(this, "�������ݿ����ѡ��ͬ���ı�!");
			return;
		}
		if (!tablename1.equals(tablename2)) {
			JOptionPane.showMessageDialog(this, "��������ͬ������ִ��ͬ������!");
			return;
		}
		if (JOptionPane.OK_CANCEL_OPTION == JOptionPane.showConfirmDialog(this,
				"ȷ���ӱ�" + tablename1 + "����" + tablename2 + "?", "ȷ�ϵ���?",
				JOptionPane.OK_CANCEL_OPTION)) {
			return;
		}

		// �жϵ�ǰ��ѡ���־λkeyFlag��compareFlag
		Map<String, List<Object>> map1 = new HashMap<String, List<Object>>();
		Map<String, List<Object>> map2 = new HashMap<String, List<Object>>();
		List<List<Object>> list = new ArrayList<List<Object>>();
		// List<Object> li = new ArrayList<Object>();
		map1 = new CompareData().compareTableData(connargs1.getDbname(),
				tablename1, connargs1.getConn());
		if (null != connargs2 && null != connargs2.getHostaddr()
				&& null != connargs2.getDbname()) {
			map2 = new CompareData().compareTableData(connargs2.getDbname(),
					tablename2, connargs2.getConn());
		}
		if (!CompareData.keyFlag) {
			// ���������־λΪfalse,����ʾ����ֱ��������
			JOptionPane.showMessageDialog(this, "�����������ͬ������ִ������ͬ��������");
			CompareData.reset();
			compareTableClear();
			return;
		}
		if (!CompareData.compareFlag) {
			// ����ṹ��־λΪfalse,����ʾ����ֱ��������
			JOptionPane.showMessageDialog(this, "���ṹ����ͬ������ִ������ͬ��������");
			CompareData.reset();
			compareTableClear();
			return;
		}

		// SQL_Frame
		SQL_Frame sqlframe = new SQL_Frame(connargs2, connargs1, tablename2,
				tablename1, "ͬ��������:AtoB");
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
			JOptionPane.showMessageDialog(this, "�������ݿ����ѡ��Ҫͬ���ı�!(���-->��һ)");
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
			JOptionPane.showMessageDialog(this, "�������ݿ�һ��ѡ��ͬ���ı�!");
			return;
		}
		if (!tablename1.equals(tablename2)) {
			JOptionPane.showMessageDialog(this, "��������ͬ������ִ��ͬ������!");
			return;
		}
		if (JOptionPane.OK_CANCEL_OPTION == JOptionPane.showConfirmDialog(this,
				"ȷ���ӱ�" + tablename2 + "����" + tablename1 + "?", "ȷ�ϵ���?",
				JOptionPane.OK_CANCEL_OPTION)) {
			return;
		}
		//�жϵ�ǰ��ѡ���־λkeyFlag��compareFlag
		Map<String, List<Object>> map1 = new HashMap<String, List<Object>>();
		Map<String, List<Object>> map2 = new HashMap<String, List<Object>>();
		List<List<Object>> list = new ArrayList<List<Object>>();
		// List<Object> li = new ArrayList<Object>();
		map1 = new CompareData().compareTableData(connargs1.getDbname(),
				tablename1, connargs1.getConn());
		if (null != connargs2 && null != connargs2.getHostaddr()
				&& null != connargs2.getDbname()) {
			map2 = new CompareData().compareTableData(connargs2.getDbname(),
					tablename2, connargs2.getConn());
		}
		if (!CompareData.keyFlag) {
			//���������־λΪfalse,����ʾ����ֱ��������
			JOptionPane.showMessageDialog(this, "�����������ͬ������ִ������ͬ��������");
			CompareData.reset();
			compareTableClear();
			return;
		}
		if (!CompareData.compareFlag) {
			//����ṹ��־λΪfalse,����ʾ����ֱ��������
			JOptionPane.showMessageDialog(this, "���ṹ����ͬ������ִ������ͬ��������");
			CompareData.reset();
			compareTableClear();
			return;
		}

		SQL_Frame dataframe = new SQL_Frame(connargs1, connargs2, tablename1,
				tablename2, "ͬ��������:BtoA");
		int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
		int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
		dataframe.setLocation(screenWidth / 2 - dataframe.getWidth() / 2,
				screenHeight / 2 - dataframe.getHeight() / 2);
		dataframe.setVisible(true);
		this.setVisible(false);
	}

	private void choiceDBoneActionPerformed(java.awt.event.ActionEvent evt) {
		int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
		int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
		ChoiceDBframe DBone = new ChoiceDBframe(1, "������");
		DBone.setLocation(screenWidth / 2 - DBone.getWidth() / 2, screenHeight
				/ 2 - DBone.getHeight() / 2);
		DBone.setVisible(true);
		this.setVisible(false);
	}

	private void choiceDBtwoActionPerformed(java.awt.event.ActionEvent evt) {
		int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
		int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
		ChoiceDBframe DBone = new ChoiceDBframe(2, "������");
		DBone.setLocation(screenWidth / 2 - DBone.getWidth() / 2, screenHeight
				/ 2 - DBone.getHeight() / 2);
		DBone.setVisible(true);
		this.setVisible(false);
	}

	private void checkboxselected(JTable tableInfo) {
		int rowNumber1 = tableInfo.getSelectedRow();
		for (int i = 0; i < tableInfo.getRowCount(); i++) {
			if (tableInfo.getValueAt(i, 0)!=null && (Boolean) tableInfo.getValueAt(i, 0)) {
				tableInfo.setValueAt(false, i, 0);
			}
		}
		if(rowNumber1==-1){
			return;
		}
		tableInfo.setValueAt(true, rowNumber1, 0);
	}

	public void compareDisplay(String tablename1, String tablename2) {
		Map<String, List<Object>> map1 = new HashMap<String, List<Object>>();
		Map<String, List<Object>> map2 = new HashMap<String, List<Object>>();
		List<List<Object>> list = new ArrayList<List<Object>>();
		// List<Object> li = new ArrayList<Object>();
		map1 = new CompareData().compareTableData(connargs1.getDbname(),
				tablename1, connargs1.getConn());
		if (null != connargs2 && null != connargs2.getHostaddr()
				&& null != connargs2.getDbname()) {
			map2 = new CompareData().compareTableData(connargs2.getDbname(),
					tablename2, connargs2.getConn());
		}
		if (!CompareData.keyFlag) {
			//���������־λΪfalse,����ʾ����ֱ��������
			JOptionPane.showMessageDialog(this, "�����������ͬ������ִ�бȶԣ�");
			CompareData.reset();
			compareTableClear();
			return;
		}
		if (!CompareData.compareFlag) {
			//����ṹ��־λΪfalse,����ʾ����ֱ��������
			JOptionPane.showMessageDialog(this, "���ṹ����ͬ������ִ�бȶԣ�");
			CompareData.reset();
			compareTableClear();
			return;
		}

		map2 = CompareTables.comPare_sql(map1, map2);
		map1 = CompareTables.comPare_sql(map2, map1);// ÿ������ʾ��Ӧ�ֶε��������ԣ�
		list = CompareTables.combineMap(map1, map2);

		//���ñȶԵı�־λ
		CompareData.reset();

		if (null == list || list.isEmpty()) {
			return;
		}
		// ��Ϊֻ�п�һ�������ͬ���ұ�ṹ��ͬʱ�Ż�ȶ����ݣ����Ա��ֶ��������κ�һ�����Ӳ�ѯ����
		List namelist = (List) Tool.getDatas(tablename1, connargs1).get(0);
		String[] name = new String[namelist.size() * 2];
		for (int i = 0; i < namelist.size(); i++) {
			name[i] = "��һ:" + namelist.get(i).toString();
			name[i + namelist.size()] = "���:" + namelist.get(i).toString();
		}
		Object[][] compareNumber = new Object[list.size() / 2][name.length];
		// i��������Դ���� j��������Դ���� k���Ʊ����ʾ����
		for (int i = 0; i < list.size(); i += 2) {
			for (int j = 0; j < namelist.size(); j++) {
				if (list.get(i) != null && list.get(i).size() != 0) {
					compareNumber[i / 2][j] = list.get(i).get(j);
				} else {
					compareNumber[i / 2][j] = "";
				}
				if (list.get(i + 1) != null && list.get(i + 1).size() != 0) {
					compareNumber[i / 2][j + namelist.size()] = list.get(i + 1)
							.get(j);
				} else {
					compareNumber[i / 2][j + namelist.size()] = "";
				}
			}
		}
		compareTable.setModel(new javax.swing.table.DefaultTableModel(
				compareNumber, name));
		// Ϊ��ʹ������ʾ�������ۣ��������м�¼��ʹ��ˮƽ������
		if (compareTable.getColumnModel().getColumnCount() > 10) {
			compareTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);// ˮƽ������
		} else {
			compareTable
					.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);// ����Ϊƽ���п�
		}
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

	// ��ʾ���в������ݵ�������ɫ
	public void showcolor(final List<Point> listpoint, Object[] name) {

		// �½��б�����------------------------//

		DefaultTableCellRenderer tcr = new DefaultTableCellRenderer() {

			public Component getTableCellRendererComponent(JTable table,
					Object value, boolean isSelected, boolean hasFocus,
					int row, int column)

			{

				Component cell = super.getTableCellRendererComponent(table,
						value, isSelected, hasFocus, row, column);

				String test = "";
				// ��ȡ��Ҫ������
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
	private javax.swing.JButton choiceDBone;
	private javax.swing.JButton choiceDBtwo;
	private javax.swing.JTable compareTable;
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
		CompareDataFrame.connargs1 = connargs1;
	}

	public static ConnArgs getConnargs2() {
		return connargs2;
	}

	public static void setConnargs2(ConnArgs connargs2) {
		CompareDataFrame.connargs2 = connargs2;
	}

}