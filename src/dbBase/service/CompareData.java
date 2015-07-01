package dbBase.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dbBase.entity.ColumnKey;
import dbBase.util.DBcon;

//比对数据
public class CompareData { 
	public static Map<String, List<String>> MetaData = new HashMap<String, List<String>>();
	public static int atKey;
	public static String pKey1 = "";// 分别获取两次主键
	public static int keymode = 1;
	public static String pKey2 = "";
	public static boolean haskey=true;
	public static boolean keyFlag = true;// 判断主键是否一致
	public static int mode = 1;
	public static int map1size = 0;
	public static int map2size = 0;
	public static boolean compareFlag = true;// 判断结构是否一致

	public Map<String, List<Object>> compareTableData(String dbbase,
			String tablename, Connection conn) {
		Map<String, List<Object>> map1 = new HashMap<String, List<Object>>();
		String sql = "SELECT * FROM information_schema.COLUMNS WHERE TABLE_SCHEMA= '"
				+ dbbase + "' AND TABLE_NAME = '" + tablename + "'";
		String sql2 = "SELECT  *  FROM information_schema.KEY_COLUMN_USAGE  WHERE  TABLE_SCHEMA='"
				+ dbbase + "'  AND TABLE_NAME='" + tablename + "'";
		getPkey(conn, sql2);
		if(keymode == 1 &&("".equals(pKey1)||"".equals(pKey2))){
			return null;
		}
		getMap(conn, sql);
		if (mode == 1 && map1size != map2size) {
			compareFlag = false;
		}
		if (keymode == 1 && !(pKey1.equals(pKey2))) {
			keyFlag = false;
		}

		String str = "SELECT * FROM " + dbbase + "." + tablename;
		map1 = executeDataQuery(conn, str);
		return map1;
	}

	private void getPkey(Connection conn2, String sql) {// keymode表示第一次或者第二次执行
		StringBuffer pkey = new StringBuffer();
		Statement statement = null;
		ResultSet rs = null;
		try {
			statement = conn2.createStatement();
			rs = statement.executeQuery(sql);
			while (rs.next()) {
				String column = rs.getString(ColumnKey.dBcolumnName + 1);
				int type = rs.getInt(ColumnKey.dBuniqueCposition + 1);
				if (type != 1) {
					pkey.append(column + ",");
				}
			}
			if(pkey.length()==0){//任何一个比对数据的表中没有主键，则退出
				haskey=false;//判断表中是否包含主键
				return;
			}
			if (keymode == 1&&("".equals(pKey1))) {
				pKey1 = pkey.toString();
				pKey1 = pKey1.substring(0, pKey1.length() - 1);
			}
			if (keymode == 2&&("".equals(pKey2))) {
				pKey2 = pkey.toString();
				pKey2 = pKey2.substring(0, pKey2.length() - 1);
			}
			keymode = keymode == 1 ? 2 : 1;
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void getMap(Connection conn2, String sql) {// mode表示此方法第几次调用

		Statement statement = null;
		ResultSet rs = null;
		try {
			statement = conn2.createStatement();
			rs = statement.executeQuery(sql);
			List<String> list = new ArrayList<String>();
			String str = "";
			int m = 0;
			while (rs.next()) {
				if (MetaData.isEmpty()) {
					str = rs.getString(2) + "." + rs.getString(3);
					MetaData.put(str, new ArrayList<String>());
				}
				if (mode == 1) {
					map1size++;
				}
				if (mode == 2) {
					map2size++;
				}
				String s = rs.getString(4);
				list.add(rs.getString(4));
				if (!s.equals(pKey1)) {
					m++;
				}
				if (s.equals(pKey1)) {
					atKey = m;// 记录主键位置
				}
			}
			if (MetaData.get(str) != null) {
				MetaData.put(str, list);
			}
			mode = mode == 1 ? 2 : 1;
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public Map<String, List<Object>> executeDataQuery(Connection con, String sql) {
		Map<String, List<Object>> map = new HashMap<String, List<Object>>();
		List<Object> eliment = null;
		Statement statement = null;
		ResultSet rs = null;
		try {
			statement = con.createStatement();
			rs = statement.executeQuery(sql);
			ResultSetMetaData rt = rs.getMetaData();
			int i = rt.getColumnCount();
			while (rs.next()) {
				eliment = new ArrayList<Object>();
				if (keyFlag && compareFlag) {
					for (int j = 1; j <= i; j++) {
						eliment.add(rs.getObject(j));
					}
					if (pKey1.contains(",")) {
						String key = "";
						String[] str = pKey1.split(",");
						for (int j = 0; j < str.length; j++) {
							key = key + "," + rs.getString(str[j]);
						}
						key = key.substring(1, key.length());
						map.put(key, eliment);
					} else {
						map.put(rs.getString(pKey1), eliment);
					}
				} else {
					return null;
				}
			}
			return map;
		} catch (SQLException e) {
			System.out.println("获取数据出现异常： " + e.getMessage());
			return null;
		} finally {
			DBcon.closeResultSet(rs);
			DBcon.closeStatement(statement);
			// DBcon.closeConnection(con);
		}
	}

	public static void reset() {
		if (!compareFlag) {
			compareFlag = true;
		}
		if (!keyFlag) {
			keyFlag = true;
		}
		if (atKey != 0) {
			atKey = 0;
		}
		if (!("".equals(pKey1))) {
			pKey1 = "";
		}
		if (!("".equals(pKey2))) {
			pKey2 = "";
		}
		if (map1size != 0) {
			map1size = 0;
		}
		if (map2size != 0) {
			map2size = 0;
		}
	}

}
