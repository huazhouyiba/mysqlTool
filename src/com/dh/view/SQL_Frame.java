/*
 * SQL_Frame.java
 *
 * Created on __DATE__, __TIME__
 */

package com.dh.view;

import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JOptionPane;
import javax.swing.text.BadLocationException;

import dbBase.entity.ConnArgs;
import dbBase.service.CompareData;
import dbBase.service.CompareTables;
import dbBase.service.Generate;
import dbBase.service.Synchronous;

/**
 *
 * @author  __USER__
 */
public class SQL_Frame extends javax.swing.JFrame {

	private static String singlestring = "";
	private ConnArgs connargs1;
	private ConnArgs connargs2;

	/** Creates new form SQL_Frame */
	public SQL_Frame() {
		initComponents();
	}

	public SQL_Frame(ConnArgs conn1, ConnArgs conn2, String table1,
			String table2, String single) {
		initComponents();
		singlestring = single;
		connargs1 = conn1;
		connargs2 = conn2;
		if (single.startsWith("同步表结构")) {
			topname.setText("SQL语句(" + single + "):" + table2 + "到" + table1);
			SQLdisplay(conn1, conn2, table1, table2);
		} else {
			topname.setText("SQL语句(" + single + "):" + table2 + "到" + table1);
			Datadisplay(conn1, conn2, table1, table2);
		}

	}

	/** This method is called from within the constructor to
	 * initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is
	 * always regenerated by the Form Editor.
	 */
	//GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		topname = new javax.swing.JLabel();
		jScrollPane1 = new javax.swing.JScrollPane();
		Information = new javax.swing.JTextArea();
		btn_commit = new javax.swing.JButton();
		btn_quit = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		topname.setText("SQL\u8bed\u53e5\uff1a");

		Information.setColumns(20);
		Information.setRows(5);
		jScrollPane1.setViewportView(Information);

		btn_commit.setText("\u6267\u884cSQL");
		btn_commit.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btn_commitActionPerformed(evt);
			}
		});

		btn_quit.setText("\u53d6\u6d88");
		btn_quit.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btn_quitActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						javax.swing.GroupLayout.Alignment.TRAILING,
						layout.createSequentialGroup()
								.addContainerGap(557, Short.MAX_VALUE)
								.addComponent(btn_commit).addGap(29, 29, 29)
								.addComponent(btn_quit).addGap(72, 72, 72))
				.addGroup(
						layout.createSequentialGroup()
								.addGap(28, 28, 28)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.TRAILING,
												false)
												.addComponent(
														topname,
														javax.swing.GroupLayout.Alignment.LEADING,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														Short.MAX_VALUE)
												.addComponent(
														jScrollPane1,
														javax.swing.GroupLayout.Alignment.LEADING,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														718, Short.MAX_VALUE))
								.addContainerGap(48, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addComponent(topname,
										javax.swing.GroupLayout.PREFERRED_SIZE,
										38,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(jScrollPane1,
										javax.swing.GroupLayout.PREFERRED_SIZE,
										316,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(btn_quit)
												.addComponent(btn_commit))
								.addContainerGap(
										javax.swing.GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)));

		pack();
	}// </editor-fold>
	//GEN-END:initComponents

	private void btn_commitActionPerformed(java.awt.event.ActionEvent evt) {		
		String sqlinfo=Information.getText();
		if ( null == sqlinfo  || sqlinfo.trim().length() == 0 || "".equals(sqlinfo)) {
			JOptionPane.showMessageDialog(this, "sql语句为空，不需要执行！");
			return;
		}		
//		if (JOptionPane.OK_OPTION == JOptionPane.showConfirmDialog(this,
//				"确认执行同步SQL语句?", "确认窗口", JOptionPane.OK_CANCEL_OPTION)) {
			
//			String[] sql=sqlinfo.split(";");			
//			for(int i=0;i<sql.length-1;i++){
//				System.out.println(sql[i]); 
//			}
			
//			if ("AtoB".equals(singlestring.split(":")[1])) {
//				Connection conn= connargs2.getConn();
//				Statement st =null;
//				try {
//					st = conn.createStatement();
//					conn.commit();
//				} catch (SQLException e) {
//					try {
//						conn.rollback();
//					} catch (SQLException e1) {
//						JOptionPane.showMessageDialog(this, "数据回滚异常！");
//						// TODO Auto-generated catch block
//						e1.printStackTrace();
//					}
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}finally{
//					try {
//						st.close();						
//					} catch (SQLException e) { 
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//				}
//			} else if ("BtoA".equals(singlestring.split(":")[1])) {		
//			}
//			JOptionPane.showMessageDialog(this, "导入成功！");
//		}
	}

	private void btn_quitActionPerformed(java.awt.event.ActionEvent evt) {
		int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
		int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
		if (singlestring.startsWith("同步表结构")) {
			CompareFrame compareframe = new CompareFrame(
					CompareFrame.getConnargs1(), CompareFrame.getConnargs2());
			compareframe.setLocation(screenWidth / 2 - compareframe.getWidth()
					/ 2, screenHeight / 2 - compareframe.getHeight() / 2);
			compareframe.setVisible(true);
		} else {
			CompareDataFrame comparedataframe = new CompareDataFrame(
					CompareDataFrame.getConnargs1(),
					CompareDataFrame.getConnargs2());
			comparedataframe.setLocation(
					screenWidth / 2 - comparedataframe.getWidth() / 2,
					screenHeight / 2 - comparedataframe.getHeight() / 2);
			comparedataframe.setVisible(true);
		}
		this.setVisible(false);
	}

	private void SQLdisplay(ConnArgs conn1, ConnArgs conn2, String table1,
			String table2) {
		Map<String, List<Object>> map1 = new HashMap<String, List<Object>>();
		Map<String, List<Object>> map2 = new HashMap<String, List<Object>>();
		List<List<Object>> results1 = null;
		List<String> sql1 = null;
		List<String> sql2 = null;
		List<List<String>> lis = new ArrayList<List<String>>();
		map1 = CompareTables.compareFiled("information_schema.COLUMNS",
				conn1.getConn(), conn1.getDbname(), table1);
		map2 = CompareTables.compareFiled("information_schema.COLUMNS",
				conn2.getConn(), conn2.getDbname(), table2);
		map2 = CompareTables.comPare_sql(map1, map2);
		map1 = CompareTables.comPare_sql(map2, map1);
		results1 = CompareTables.combineMap(map1, map2);
		lis = Generate.getSQl(results1, "`" + conn1.getDbname() + "`.`"
				+ table1 + "`");
		sql1 = Generate.method(lis);

		map1 = CompareTables.compareFiled(
				"information_schema.KEY_COLUMN_USAGE", conn1.getConn(),
				conn1.getDbname(), table1);
		map2 = CompareTables.compareFiled(
				"information_schema.KEY_COLUMN_USAGE", conn2.getConn(),
				conn2.getDbname(), table2);
		map2 = CompareTables.comPare_sql(map1, map2);
		map1 = CompareTables.comPare_sql(map2, map1);
		results1 = CompareTables.combineMap(map1, map2);
		lis = Generate.getSQl2(results1, "`" + conn1.getDbname() + "`.`"
				+ table1 + "`");
		sql2 = Generate.method2(lis);
		String temp = "";
		for (String li : sql1) {
			temp += li + ";\r\n";
		}
		for (String li : sql2) {
			temp += li + ";\r\n";
		}
		Information.setText(temp);
	}

	//调用方法显示数据同步的SQL语句
	private void Datadisplay(ConnArgs conn1, ConnArgs conn2, String table1,
			String table2) {
		Map<String, List<Object>> map1 = new HashMap<String, List<Object>>();
		Map<String, List<Object>> map2 = new HashMap<String, List<Object>>();
		List<List<Object>> results = new ArrayList<List<Object>>();
		map1 = new CompareData().compareTableData(conn1.getDbname(), table1,
				conn1.getConn());
		map2 = new CompareData().compareTableData(conn2.getDbname(), table2,
				conn2.getConn());
		map2 = CompareTables.comPare_sql(map1, map2);
		map1 = CompareTables.comPare_sql(map2, map1);// 每个行显示对应字段的所有属性，
		results = CompareTables.combineMap(map1, map2);
		List list = Synchronous.synchrodata(results);
		String temp = "";
		if (null == list || list.isEmpty()) {
			Information.setText("此数据表为空表！");
			return;
		}
		for (int i = 0; i < list.size(); i++) {
			List templist = (List) list.get(i);
			for (int j = 0; j < templist.size(); j++) {
				temp += templist.get(j).toString();
			}
		}
		Information.setText(temp);
	}

	//GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.JTextArea Information;
	private javax.swing.JButton btn_commit;
	private javax.swing.JButton btn_quit;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JLabel topname;
	// End of variables declaration//GEN-END:variables

}