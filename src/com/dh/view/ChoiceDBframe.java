/*
 * ChoiceDBframe.java
 *
 * Created on __DATE__, __TIME__
 */

package com.dh.view;

import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JOptionPane;

import com.dh.service.MySqlDBUtil;

import dbBase.entity.ConnArgs;

/**
 * 
 * @author __USER__
 */
public class ChoiceDBframe extends javax.swing.JFrame {
	
	private static String singleString="";

	/** Creates new form ChoiceDBframe */
	public ChoiceDBframe() {
		initComponents();
	}

	public ChoiceDBframe(int DBchoice,String single) {
		initComponents();
		singleString=single;
		if (DBchoice == 2) {
			topname.setText("���ݿ����Ϣ����");			
			if("��ṹ".equals(singleString)){	
				//�õ���ṹ�ȶ�ҳ�������2���ж��Ƿ�Ϊ�գ����Ϊ��������ڸ�ֵΪ����һ ����Ϣ
				ConnArgs conn2=CompareFrame.getConnargs2();
				if(null==conn2||null==conn2.getHostaddr()||null==conn2.getDbname()){
					ReadInfo(CompareFrame.getConnargs1());
				}else{
					ReadInfo(conn2);
				}				
			}else{
				//�õ������ݱȶ�ҳ�������2���ж��Ƿ�Ϊ�գ����Ϊ��������ڸ�ֵΪ����һ ����Ϣ
				ConnArgs conn2=CompareDataFrame.getConnargs2();
				if(null==conn2||null==conn2.getHostaddr()||null==conn2.getDbname()){
					ReadInfo(CompareDataFrame.getConnargs1());
				}else{
					ReadInfo(conn2);
				}	
			}			
		} else {
			if("��ṹ".equals(singleString)){
				ReadInfo(CompareFrame.getConnargs1());
			}else{
				ReadInfo(CompareDataFrame.getConnargs1());
			}	
		}
	}

	//GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		jLabel1 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		jLabel3 = new javax.swing.JLabel();
		jLabel4 = new javax.swing.JLabel();
		jLabel5 = new javax.swing.JLabel();
		DBaddress = new javax.swing.JTextField();
		DBport = new javax.swing.JTextField();
		DBname = new javax.swing.JTextField();
		DBusername = new javax.swing.JTextField();
		DBpwd = new javax.swing.JPasswordField();
		topname = new javax.swing.JLabel();
		jButton1 = new javax.swing.JButton();
		jButton2 = new javax.swing.JButton();

		setTitle("\u6570\u636e\u5e93\u5730\u5740\u914d\u7f6e");

		jLabel1.setText("\u76ee\u6807\u4e3b\u673a\u5730\u5740\uff1a");

		jLabel2.setText("\u7aef\u53e3\u53f7\uff1a");

		jLabel3.setText("\u6570\u636e\u5e93\u540d\u79f0\uff1a");

		jLabel4.setText("\u7528\u6237\u540d\uff1a");

		jLabel5.setText("\u5bc6\u7801\uff1a");

		topname.setFont(new java.awt.Font("΢���ź�", 1, 14));
		topname.setText("\u6570\u636e\u5e93\u4e00\u4fe1\u606f\u914d\u7f6e");

		jButton1.setText("\u786e\u5b9a");
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}
		});

		jButton2.setText("\u53d6\u6d88");
		jButton2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton2ActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addGap(31, 31, 31)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING)
												.addGroup(
														layout.createParallelGroup(
																javax.swing.GroupLayout.Alignment.TRAILING)
																.addComponent(
																		jLabel2)
																.addComponent(
																		jLabel1)
																.addComponent(
																		jLabel3)
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.LEADING)
																				.addComponent(
																						jButton1)
																				.addComponent(
																						jLabel4)))
												.addGroup(
														layout.createSequentialGroup()
																.addGap(45, 45,
																		45)
																.addComponent(
																		jLabel5)))
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING)
												.addGroup(
														layout.createSequentialGroup()
																.addPreferredGap(
																		javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.LEADING)
																				.addComponent(
																						DBpwd,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						112,
																						Short.MAX_VALUE)
																				.addComponent(
																						DBport,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						112,
																						Short.MAX_VALUE)
																				.addComponent(
																						DBname,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						112,
																						Short.MAX_VALUE)
																				.addComponent(
																						DBusername,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						112,
																						Short.MAX_VALUE)
																				.addComponent(
																						DBaddress,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						112,
																						Short.MAX_VALUE))
																.addGap(38, 38,
																		38))
												.addGroup(
														layout.createSequentialGroup()
																.addGap(26, 26,
																		26)
																.addComponent(
																		jButton2)
																.addContainerGap())))
				.addGroup(
						javax.swing.GroupLayout.Alignment.TRAILING,
						layout.createSequentialGroup()
								.addContainerGap(80, Short.MAX_VALUE)
								.addComponent(topname,
										javax.swing.GroupLayout.PREFERRED_SIZE,
										117,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(75, 75, 75)));
		layout.setVerticalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addContainerGap()
								.addComponent(topname,
										javax.swing.GroupLayout.PREFERRED_SIZE,
										22,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(14, 14, 14)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(jLabel1)
												.addComponent(
														DBaddress,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGap(28, 28, 28)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(jLabel2)
												.addComponent(
														DBport,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED,
										16, Short.MAX_VALUE)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(jLabel3)
												.addComponent(
														DBname,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGap(28, 28, 28)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(jLabel4)
												.addComponent(
														DBusername,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGap(18, 18, 18)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(jLabel5)
												.addComponent(
														DBpwd,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGap(18, 18, 18)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(jButton1)
												.addComponent(jButton2))
								.addContainerGap()));

		pack();
	}// </editor-fold>
	//GEN-END:initComponents

	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
		String dbaddress = DBaddress.getText();
		String dbport = DBport.getText();
		String dbname = DBname.getText();
		String dbusername = DBusername.getText();
		String dbpwd = DBpwd.getText();
		if (dbaddress == null || "".equals(dbaddress.trim())) {
			JOptionPane.showMessageDialog(this, "Ŀ��������ַ����Ϊ�գ�");
			return;
		}
		if (dbport == null || "".equals(dbport.trim())) {
			JOptionPane.showMessageDialog(this, "�˿ںŲ���Ϊ�գ�");
			return;
		}
		if (dbname == null || "".equals(dbname.trim())) {
			JOptionPane.showMessageDialog(this, "���ݿ����Ʋ���Ϊ�գ�");
			return;
		}
		if (dbusername == null || "".equals(dbusername.trim())) {
			JOptionPane.showMessageDialog(this, "�û�������Ϊ�գ�");
			return;
		}
		if (dbpwd == null || "".equals(dbpwd.trim())) {
			JOptionPane.showMessageDialog(this, "���벻��Ϊ�գ�");
			return;
		}

		ConnArgs conn = new ConnArgs(dbaddress,dbport,dbname,dbusername,dbpwd);	
		if (null==conn.getConn()) {
			JOptionPane.showMessageDialog(this,"�������ݿ�ʧ�ܣ�������������Ϣ�Ƿ���ȷ�������ݿ��Ƿ��������У�");
			return;
		}

//		ConnArgs conn = new ConnArgs(DBaddress.getText(), DBport.getText(),DBname.getText(), DBusername.getText(), DBpwd.getText());
		
		if("��ṹ".equals(singleString)){
			if ("���ݿ����Ϣ����".equals(topname.getText())) {
				//���������Ӷ���
				CompareFrame.setConnargs2(conn);
				//�����µ����Ӷ������´��µıȽ�ҳ��
				CompareFrame compareframe = new CompareFrame(CompareFrame.getConnargs1(),CompareFrame.getConnargs2());
				int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
				int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
				compareframe.setLocation(screenWidth / 2 - compareframe.getWidth()
						/ 2, screenHeight / 2 - compareframe.getHeight() / 2);
				compareframe.setVisible(true);				
			} else {				
				//���������Ӷ���
				CompareFrame.setConnargs1(conn);
				//�����µ����Ӷ������´��µıȽ�ҳ��
				CompareFrame compareframe =new CompareFrame(CompareFrame.getConnargs1(),CompareFrame.getConnargs2());
				int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
				int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
				compareframe.setLocation(screenWidth / 2 - compareframe.getWidth()
						/ 2, screenHeight / 2 - compareframe.getHeight() / 2);
				compareframe.setVisible(true);				
			}
		}else{
			if ("���ݿ����Ϣ����".equals(topname.getText())) {
				//���������Ӷ���
				CompareDataFrame.setConnargs2(conn);
				//�����µ����Ӷ������´��µıȽ�ҳ��
				CompareDataFrame comparedataframe = new CompareDataFrame(CompareDataFrame.getConnargs1(),CompareDataFrame.getConnargs2());
				int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
				int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
				comparedataframe.setLocation(screenWidth / 2 - comparedataframe.getWidth()
						/ 2, screenHeight / 2 - comparedataframe.getHeight() / 2);
				comparedataframe.setVisible(true);				
			} else {
				//ConnArgs conn=new ConnArgs(DBaddress.getText(),DBport.getText(),DBname.getText(),DBusername.getText(),DBpwd.getText());
				//���������Ӷ���
				CompareDataFrame.setConnargs1(conn);
				//�����µ����Ӷ������´��µıȽ�ҳ��
				CompareDataFrame comparedataframe = new CompareDataFrame(CompareDataFrame.getConnargs1(),CompareDataFrame.getConnargs2());
				int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
				int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
				comparedataframe.setLocation(screenWidth / 2 - comparedataframe.getWidth()
						/ 2, screenHeight / 2 - comparedataframe.getHeight() / 2);
				comparedataframe.setVisible(true);				
			}
		}
		this.setVisible(false);
	}

	private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
		int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
		int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
		if ("��ṹ".equals(singleString)) {
			CompareFrame compareframe = new CompareFrame(CompareFrame.getConnargs1(),CompareFrame.getConnargs2());
			compareframe.setLocation(screenWidth / 2 - compareframe.getWidth()
					/ 2, screenHeight / 2 - compareframe.getHeight() / 2);
			compareframe.setVisible(true);
		} else {
			CompareDataFrame comparedataframe = new CompareDataFrame(CompareDataFrame.getConnargs1(),CompareDataFrame.getConnargs2());
			comparedataframe.setLocation(
					screenWidth / 2 - comparedataframe.getWidth() / 2,
					screenHeight / 2 - comparedataframe.getHeight() / 2);
			comparedataframe.setVisible(true);
		}
		this.setVisible(false);
	}

	private void ReadInfo(ConnArgs connargs) {
		DBaddress.setText(connargs.getHostaddr());
		DBport.setText(connargs.getProtnum());
		DBname.setText(connargs.getDbname());
		DBusername.setText(connargs.getUser());
	}

	//GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.JTextField DBaddress;
	private javax.swing.JTextField DBname;
	private javax.swing.JTextField DBport;
	private javax.swing.JPasswordField DBpwd;
	private javax.swing.JTextField DBusername;
	private javax.swing.JButton jButton1;
	private javax.swing.JButton jButton2;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel topname;
	// End of variables declaration//GEN-END:variables

}