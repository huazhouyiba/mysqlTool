package dbBase.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import dbBase.entity.Clomun;
import dbBase.entity.Point;

public class CompareTables {
	public static Map<String, List<Object>> compareFiled(String fDatabase,
			Connection conn, String database, String table) {
		Map<String, List<Object>> map1 = new HashMap<String, List<Object>>();
		StringBuffer str = new StringBuffer("SELECT * FROM ");
		str.append(fDatabase);
		if (database != "" && table != "") {
			str.append(" WHERE TABLE_SCHEMA= '" + database
					+ "' and TABLE_NAME = '" + table + "'");
		}
		map1 = SQLCommand.executeQuery(conn, str.toString(), fDatabase);
		return map1;
	}

	// 对map2添加没有的键值
	public static Map<String, List<Object>> comPare(
			Map<String, List<Object>> map1, Map<String, List<Object>> map2) {
		if (map1 != null && !map1.isEmpty()) {
			if (map2 != null && map2.size() != 0) {
				Iterator<Entry<String, List<Object>>> it = map1.entrySet()
						.iterator();
				while (it.hasNext()) {
					Entry<String, List<Object>> en = it.next();
					String str = en.getKey();
					int len = map1.get(en.getKey()).size();
					if (map2.get(en.getKey()) == null) {// map2不存在该键值，赋值为空
						List<Object> list = new ArrayList<Object>();
						for (int j = 0; j < len; j++) {
							list.add("");
						}
						map2.put(str, list);
						continue;// 没有该列
					}
				}
			}
		}
		return map2;
	}

	public static Map<String, List<Object>> comPare_sql(
			Map<String, List<Object>> map1, Map<String, List<Object>> map2) {
		if (map1 != null && !map1.isEmpty()) {
			if (map2 != null && map2.size() != 0) {
				Iterator<Entry<String, List<Object>>> it = map1.entrySet()
						.iterator();
				while (it.hasNext()) {
					Entry<String, List<Object>> en = it.next();
					String str = en.getKey();
					if (map2.get(en.getKey()) == null) {// map2不存在该键值，赋值为空
						List<Object> list = new ArrayList<Object>();
						map2.put(str, list);
						continue;// 没有该列
					}
				}
			}
		}
		return map2;
	}

	public static List<List<Object>> combineMap(Map<String, List<Object>> map1,
			Map<String, List<Object>> map2) {
		if ((map1 == null || map1.isEmpty())
				&& (map2 == null || map2.isEmpty())) {
			return null;
		}
		List<List<Object>> results = new ArrayList<List<Object>>();
		Iterator<Entry<String, List<Object>>> it = map1.entrySet().iterator();
		while (it.hasNext()) {
			Entry<String, List<Object>> en = it.next();
			List<Object> list = new ArrayList<Object>();
			String str = en.getKey();
			if (map1 != null) {
				results.add(map1.get(str));
			} else {
				results.add(list);
			}

			if (map2 != null) {
				results.add(map2.get(str));
			} else {
				results.add(list);
			}
		}
		return results;
	}

	// 返回增加颜色坐标集
	public static List<Point> comColorFlag(List<List<Object>> list) {
		List<Point> region = new ArrayList<Point>();
		for (int i = 0; i < list.size() - 1; i++) {
			List<Object> l1 = list.get(i);
			List<Object> l2 = list.get(i + 1);
			int l1s = l1.size();
			int l2s = l2.size();
			if (l1s == 0 || l2s == 0) {
				++i;
				continue;
			} else {
				if (l1.get(Clomun.dBcolumnType) != l2.get(Clomun.dBcolumnType)) {
					region.add(new Point(i / 2, Clomun.dBcolumnType));
				}
				if (l1.get(Clomun.dBcolumnkey) != l2.get(Clomun.dBcolumnkey)) {
					region.add(new Point(i / 2, Clomun.dBcolumnkey));
				}
				if (l1.get(Clomun.dBschema) != l2.get(Clomun.dBschema)) {
					region.add(new Point(i / 2, Clomun.dBschema));
				}
			}
			++i;
		}
		return region;
	}
}
