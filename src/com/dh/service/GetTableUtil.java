package com.dh.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dbBase.entity.ConnArgs;

public class GetTableUtil {

	/**
	 * ��ȡ���б����Ƶķ���
	 * @param conn ����һ�����ݿ����Ӷ���
	 * @return ����һ�����
	 */
	public static List<String> getAllTables(ConnArgs connArgs) {
		String sql = "SELECT * FROM information_schema.TABLES WHERE TABLE_SCHEMA=?";
		
		ResultSet rs = MySqlDBUtil.executeQuery(connArgs.getConn(), sql, connArgs.getDbname());
		
		List<String> tables = new ArrayList<String>();
		try {
			while(rs.next()) {
				tables.add(rs.getString("table_name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//MySqlDBUtil.colseAll();
		}		
		return tables;
	}
	
}
