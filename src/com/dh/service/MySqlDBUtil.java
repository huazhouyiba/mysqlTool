package com.dh.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import dbBase.entity.ConnArgs;

public class MySqlDBUtil {

	private  Connection conn = null;
	private static PreparedStatement pst = null;
	private static ResultSet rs = null;
	public static final String driver = "com.mysql.jdbc.Driver";
	public static String url = null;
	public static String user = null;
	public static String password = null;

	/**
	 * ����mysql���ݿ⣬���һ�����Ӷ���ķ���
	 * @param hostaddr Ŀ��������ַ
	 * @param portnum �˿ں�
	 * @param dbname ���ӵ����ݿ���
	 * @param user �û���
	 * @param password ����
	 * @return �������Ӷ���
	 */
	public  Connection getConnection(ConnArgs connargs) {
		Connection conn = null;
		String url = "jdbc:mysql://" + connargs.getHostaddr() + ":" + connargs.getProtnum() + "/" + connargs.getDbname();
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, connargs.getUser(), connargs.getPassword());
		} catch (ClassNotFoundException e) {
			System.out.println("�������س���:" + e.getMessage());
		} catch (SQLException e) {
			System.out.println("�������ӳ���:" + e.getMessage());
		}
		//����������ӳɹ�����ѽ����������Ϣд�������ļ�
//		if(conn != null) {
//			String path = System.getProperty("user.dir") + File.separator
//					+ "application.properties";
//			File file = new File(path);
//			try {
//				BufferedReader bufin = new BufferedReader(new FileReader(file));
//				StringBuffer strbuf = new StringBuffer();
//				String str = null;
//				String urlPrefix = "jdbc.url=jdbc:mysql://";
//				String userPrefix = "jdbc.username=";
//				String pwdPrefix = "jdbc.password=";
//				while((str = bufin.readLine()) != null) {
//					if(str.contains(urlPrefix)) {
//						strbuf.append(urlPrefix);
//						strbuf.append(connargs.getHostaddr()+":");
//						strbuf.append(connargs.getProtnum()+"/");
//						strbuf.append(connargs.getDbname()+"\n");
//					} else if(str.contains(userPrefix)) {
//						strbuf.append(userPrefix);
//						strbuf.append(connargs.getUser()+"\n");
//					} else if(str.contains(pwdPrefix)) {
//						strbuf.append(pwdPrefix);
//						strbuf.append(connargs.getPassword()+"\n");
//					} else {
//						strbuf.append(str+"\n");
//					}
//				}
//				bufin.close();
//				BufferedWriter bufout = new BufferedWriter(new FileWriter(file));
//				bufout.write(strbuf.toString());
//				bufout.close();
//			} catch (FileNotFoundException e) {
//				System.out.println("�Ҳ����ļ�����:" + e.getMessage());
//			} catch (IOException e) {
//				System.out.println("��д�����ļ�����:" + e.getMessage());
//			}
//		}
		return conn;
	}
//	public  Connection getConnection() {
//		Connection conn = null;
//		Properties properties = new Properties();
//		String filePath = System.getProperty("user.dir") + File.separator
//				+ "application.properties";
//		File file = new File(filePath);
//		InputStream fileinput = null;
//		try {
//			fileinput = new FileInputStream(file);
//			properties.load(fileinput);
//			url = properties.getProperty("jdbc.url");
//			user = properties.getProperty("jdbc.username");
//			password = properties.getProperty("jdbc.password");
//			fileinput.close();			
//			Class.forName(driver);
//			conn = DriverManager.getConnection(url, user, password);
//		} catch (FileNotFoundException e) {
//			System.out.println("���������ļ�����������:" + e.getMessage());
//		} catch (IOException e) {
//			System.out.println("�����ļ���������������:" + e.getMessage());
//		} catch (ClassNotFoundException e) {
//			System.out.println("�������س���:" + e.getMessage());
//		} catch (SQLException e) {
//			System.out.println("�������ӳ���:" + e.getMessage());
//		}
//		return conn;
//	}
	
	/**
	 * ִ��sql���ķ���
	 * @param conn ����һ�����ݿ����Ӷ���
	 * @param sql ����ִ�е�sql���
	 * @param params �ɱ����������sql������ռλ���Ĳ���
	 * @return ���ؽ����
	 */
	public static ResultSet executeQuery(Connection conn, String sql, Object... params) {
		try {
			pst = conn.prepareStatement(sql);
			if(params != null && params.length != 0) {
				for(int i=0; i<params.length; i++) {
					pst.setObject(i+1, params[i]);
				}
			}
			rs = pst.executeQuery();
		} catch (SQLException e) {
			System.out.println("SQLԤ��������ȡ����:" + e.getMessage());
		}
		return rs;
	}
	
	
//	public static void colseAll() {
//		try {
//			if(rs!=null) {
//				rs.close();
//			}
//		} catch (SQLException e) {
//			System.out.println("�رղ�ѯ���������:" + e.getMessage());
//		} finally {
//			rs = null;
//		}
//		try {
//			if(pst!=null) {
//				pst.close();
//			}
//		} catch (SQLException e) {
//			System.out.println("�ر�Ԥ����������:" + e.getMessage());
//		} finally {
//			pst = null;
//		}
//		try {
//			if(conn!=null) {
//				conn.close();
//			}
//		} catch (SQLException e) {
//			System.out.println("�ر����ݿ����ӳ���:" + e.getMessage());
//		} finally {
//			conn = null;
//		}
//	}
}
