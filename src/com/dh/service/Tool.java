package com.dh.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dbBase.entity.ConnArgs;
import dbBase.util.DBcon;




public class Tool { 
	
	/**
	 * ���ݱ�����ѯԼ��
	 * 
	 * @param T_name
	 */
	public static List<List> queryAllname1(String T_name,ConnArgs conn) {
		Statement st = null;
//		Connection conn = DBcon.getConnection();
		//Connection[] conn=DBcon.getConnection();
		String sql = "SELECT * FROM information_schema.TABLE_CONSTRAINTS  WHERE TABLE_SCHEMA='"+conn.getDbname()+"'and  TABLE_NAME='"
				+ T_name + "'";
		List<List> rowall = new ArrayList();
		try {
			st = conn.getConn().createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				List row = new ArrayList();
				for (int i = 1; i <= 6; i++) {
					row.add(rs.getObject(i));
				}
				rowall.add(row);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rowall;
	}

	/**
	 * ���ݱ�����ѯ����
	 * 
	 * @param T_name
	 */
	public static List<List> queryAllname(String T_name,ConnArgs conn) {
		Statement st = null;
		String sql = "SELECT * FROM information_schema.STATISTICS WHERE TABLE_SCHEMA='"+conn.getDbname()+"'and  TABLE_NAME='"
				+ T_name + "'";
		List<List> rowall = new ArrayList();
		try {
			st = conn.getConn().createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				List row = new ArrayList();
				for (int i = 1; i < 16; i++) {
					row.add(rs.getObject(i));
				}
				rowall.add(row);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rowall;
	}	
	
	/**
	 * ��ѯ�����ֶε���ϸ��Ϣ(�����������ͣ�Ĭ��ֵ���ɷ�Ϊ�գ�����)
	 * 
	 * @param tableName
	 *            :����
	 */
	public static List getFields(String tableName,ConnArgs conn) {

		List list = new ArrayList();

		PreparedStatement ps = null;
		// ��ȡ���ݿ�����Ӷ���
//		Connection conn = DBcon.getConnection();
//		Connection[] conn=DBcon.getConnection();
		// ����sql���
		String sql = "SELECT  column_name,column_type,is_nullable,column_default,extra FROM information_schema.COLUMNS WHERE TABLE_SCHEMA=? and TABLE_NAME=?;";
		// ����PreparedStatement����
		try {
			ps = conn.getConn().prepareStatement(sql);
			ps.setString(1, conn.getDbname());
			ps.setString(2, tableName);
			ResultSet rs = ps.executeQuery();		
			while (rs.next()) {
				List templist = new ArrayList();
				for(int i=1;i<=5;i++){
					templist.add(rs.getObject(i));
				}
				list.add(templist);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
			return list;
		}
	}
	
	/**
	 * ��ѯ���м�ֵ����ϸ��Ϣ(��������������ֵ�������ֶ���ΨһԼ����λ�ã���Ϊ���ֵΪ1����������������������������)
	 * @param tableName:����
	 *            
	 */
	public static List getKeys(String tableName,ConnArgs conn) {

		List list = new ArrayList();

		PreparedStatement ps = null;
		// ��ȡ���ݿ�����Ӷ���
//		Connection conn = DBcon.getConnection();
//		Connection[] conn=DBcon.getConnection();
		// ����sql���
		String sql = "SELECT  constraint_name,column_name,referenced_table_name,referenced_column_name  FROM information_schema.KEY_COLUMN_USAGE WHERE TABLE_SCHEMA=? and TABLE_NAME=?;";
		// ����PreparedStatement����
		try {
			ps = conn.getConn().prepareStatement(sql);
			ps.setString(1, conn.getDbname());
			ps.setString(2, tableName);
			ResultSet rs = ps.executeQuery();		
			while (rs.next()) {
				List templist = new ArrayList();
				for(int i=1;i<=4;i++){
					templist.add(rs.getObject(i));
				}
				list.add(templist);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
			return list;
		}

	}
	
	/**
	 * ��ѯ���е�����������Ϣ
	 * @param tableName:����
	 *            
	 */
	public static List getDatas(String tableName,ConnArgs conn) {
		Statement st = null;
		List list = new ArrayList();		
		// ����sql���
		String columnsql="SELECT COLUMN_NAME FROM information_schema.COLUMNS  WHERE TABLE_SCHEMA='"+conn.getDbname()+"' AND TABLE_NAME='"+tableName+"'";
		String sql = "SELECT * FROM "+conn.getDbname()+"."+tableName;
		
		try {
			st = conn.getConn().createStatement();
			//��ѯ���ֶ����Ʋ���ͳ���ֶθ���
			int colunmnNumber=0;
			List columnlist=new ArrayList();		
			ResultSet colunmnName=st.executeQuery(columnsql);				
			while(colunmnName.next()){
				colunmnNumber++;				
				columnlist.add(colunmnName.getObject(1));				
			}
			list.add(columnlist);
			//��ѯ������
			ResultSet rs = st.executeQuery(sql);
			List datalist=new ArrayList();
			while (rs.next()) {
				List<Object> templist = new ArrayList();
				for(int i=1;i<=colunmnNumber;i++){	
						templist.add(rs.getObject(i));					
				}
				datalist.add(templist);
			}
			list.add(datalist);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				st.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
			return list;
		}

	}
}
