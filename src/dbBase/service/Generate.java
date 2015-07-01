package dbBase.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import dbBase.entity.Clomun;
import dbBase.entity.ColumnKey;

public class Generate {
	/**
	 * �����޸ı��ֶε�sql
	 * 
	 * @param list
	 * @return
	 */
	public static List<String> method(List<List<String>> list) {
		List<String> sql = new ArrayList<String>();
		StringBuffer sqlvalue = new StringBuffer("");
		for (List<String> ls : list) {
			if ("��".equals(ls.get(0))) {
				sqlvalue.append("ALTER TABLE ").append(ls.get(1))
						.append(" ADD ").append(ls.get(2) + " ")
						.append(ls.get(3) + " ").append(ls.get(4));
				sql.add(sqlvalue.toString());
			} else if ("ɾ".equals(ls.get(0))) {
				sqlvalue.append("ALTER TABLE ").append(ls.get(1))
						.append(" DROP ").append(ls.get(2));
				sql.add(sqlvalue.toString());
			} else {
				sqlvalue.append("ALTER TABLE ").append(ls.get(1))
						.append(" MODIFY COLUMN ").append(ls.get(2) + " ")
						.append(ls.get(3) + " ").append(ls.get(4));
				sql.add(sqlvalue.toString());
			}
			sqlvalue.setLength(0);
		}
		return sql;
	}

	/**
	 * �����޸ı��������sql
	 * 
	 * @param list
	 * @return
	 */
	public static List<String> method2(List<List<String>> list) {
		List<String> sql = new ArrayList<String>();
		StringBuffer sqlvalue = new StringBuffer("");
		for (List<String> ls : list) {
			if ("FK��".equals(ls.get(0))) {
				/*
				 * ALTER TABLE `test`.`test3` ADD CONSTRAINT `FK_test4` FOREIGN
				 * KEY (`number2`) REFERENCES `test1` (` number1`) ON DELETE
				 * CASCADE;
				 */
				sqlvalue.append("ALTER TABLE ").append(ls.get(1))
						.append(" ADD CONSTRAINT ")
						.append(ls.get(2) + " FOREIGN KEY ")
						.append("(" + ls.get(3) + ") REFERENCES ")
						.append(ls.get(4));
				sql.add(sqlvalue.toString());

			} else if ("FKɾ".equals(ls.get(0))) {
				/*
				 * ALTER TABLE test3 DROP FOREIGN KEY FK_test3; ALTER TABLE
				 * test3 DROP INDEX FK_test3;
				 */
				sqlvalue.append("ALTER TABLE ").append(ls.get(1))
						.append(" DROP FOREIGN KEY ").append(ls.get(2));
				sql.add(sqlvalue.toString());
				sqlvalue.setLength(0);
				sqlvalue.append("ALTER TABLE " + ls.get(1) + " DROP INDEX ")
						.append(ls.get(2));
				sql.add(sqlvalue.toString());
			} else if ("FK��".equals(ls.get(0))) {
				/*
				 * ALTER TABLE `test`.`test3` DROP FOREIGN KEY `FK_test3`; ALTER
				 * TABLE `test`.`test3` ADD CONSTRAINT `FK_test3` FOREIGN KEY
				 * (`number2`) REFERENCES `test1` (` number1`) ON DELETE
				 * CASCADE;
				 */
				sqlvalue.append("ALTER TABLE ").append(ls.get(1))
						.append(" DROP FOREIGN KEY " + ls.get(2));
				sql.add(sqlvalue.toString());
				sqlvalue.setLength(0);
				sqlvalue.append("ALTER TABLE ").append(ls.get(1))
						.append(" ADD CONSTRAINT ")
						.append(ls.get(2) + " FOREIGN KEY ")
						.append("(" + ls.get(3) + ") REFERENCES ")
						.append(ls.get(4));
				sql.add(sqlvalue.toString());
			} else if ("PK��".equals(ls.get(0))) {
				// ALTER TABLE `test`.`test3` ADD PRIMARY KEY(number1);
				sqlvalue.append("ALTER TABLE " + ls.get(1)
						+ " ADD PRIMARY KEY (" + ls.get(2) + ")");
				sql.add(sqlvalue.toString());
			} else if ("PKɾ".equals(ls.get(0))) {
				// ALTER TABLE `test`.`test3` DROP PRIMARY KEY;
				sqlvalue.append("ALTER TABLE " + ls.get(1)
						+ " DROP PRIMARY KEY");
				sql.add(sqlvalue.toString());
			} else if ("PK��".equals(ls.get(0))) {
				/*
				 * ALTER TABLE `test`.`test3` DROP PRIMARY KEY�� ADD PRIMARY
				 * KEY(number1);
				 */
				sqlvalue.append("ALTER TABLE " + ls.get(1)
						+ " DROP PRIMARY KEY" + ",ADD PRIMARY KEY(" + ls.get(2)
						+ ")");
				sql.add(sqlvalue.toString());
			}
			sqlvalue.setLength(0);
		}
		return sql;
	}

	public static void main(String[] args) {
		// list(��־λ,�������ֶ��������ͣ��Ƿ�Ϊ��) ��־λ�����ã���ɾ�ģ���
		List<String> sql = null;
		List<List<String>> lis = new ArrayList<List<String>>();
		List<String> list1 = new ArrayList<String>();

		Map<String, List<Object>> map1 = new HashMap<String, List<Object>>();
		Map<String, List<Object>> map2 = new HashMap<String, List<Object>>();

		/*
		 * List<List<Object>> results1 = null; //���ֶ� map1
		 * =CompareTables.compareFiled
		 * ("information_schema.COLUMNS",CompareTables.conn[0], "test",
		 * "test4"); map2
		 * =CompareTables.compareFiled("information_schema.COLUMNS"
		 * ,CompareTables.conn[1], "test", "test3"); map2 =
		 * CompareTables.comPare(map1, map2); map1 = CompareTables.comPare(map2,
		 * map1); results1 = CompareTables.combineMap(map1, map2); lis =
		 * getSQl(results1,"test.test4"); sql=method(lis);
		 */

		/*
		 * List<List<Object>> results1 = null; Connection[]
		 * conn=CompareTables.conn; //���ֵ map1
		 * =CompareTables.compareFiled("information_schema.KEY_COLUMN_USAGE"
		 * ,conn[0], "test", "test4"); map2
		 * =CompareTables.compareFiled("information_schema.KEY_COLUMN_USAGE"
		 * ,conn[1], "test", "test3"); map2 = CompareTables.comPare(map1, map2);
		 * map1 = CompareTables.comPare(map2, map1); results1 =
		 * CompareTables.combineMap(map1, map2);
		 * 
		 * lis=getSQl2(results1,"`test`.`test4`"); sql=method2(lis); for (String
		 * li : sql) { System.out.println(li); }
		 */
	}

	public static List<List<String>> getSQl(List<List<Object>> list,
			String Table_name) {// ��map1��map2ͬ��
		List<List<String>> listvalue = new ArrayList<List<String>>();
		List<String> listvalue2 = null;
		for (int i = 0; i < list.size() - 1; i++) {
			List<Object> l1 = list.get(i);
			List<Object> l2 = list.get(i + 1);
			int l1s = l1.size();
			int l2s = l2.size();
			System.out.println(l1s + "*" + l2s);
			if (l1s != 0 && l2s != 0) {
				if (l1.get(Clomun.dBcolumnType).equals(
						l2.get(Clomun.dBcolumnType))
						&& l1.get(Clomun.dBnullAble).equals(
								l2.get(Clomun.dBnullAble))) {
					++i;
					continue;
				}
				listvalue2 = new ArrayList<String>();
				// �޸�
				listvalue2.add("��");
				listvalue2.add(Table_name);
				listvalue2.add(l1.get(Clomun.dBcolumnName).toString());
				listvalue2.add(l2.get(Clomun.dBcolumnType).toString());
				if ("YES".equals(l2.get(Clomun.dBnullAble).toString())) {
					listvalue2.add("NULL");
				} else {
					listvalue2.add("NOT NULL");
				}
				listvalue.add(listvalue2);
			} else if (l1s != 0 && l2s == 0) {// map1��map2��һ��(ɾ������)
				listvalue2 = new ArrayList<String>();
				// ��map1ɾ������
				listvalue2.add("ɾ");
				listvalue2.add(Table_name);
				listvalue2.add(l1.get(Clomun.dBcolumnName).toString());
				listvalue.add(listvalue2);
			} else if (l1s == 0 && l2s != 0) {
				listvalue2 = new ArrayList<String>();
				// ��map1���Ӹ���
				listvalue2.add("��");
				listvalue2.add(Table_name);
				listvalue2.add(l2.get(Clomun.dBcolumnName).toString());
				listvalue2.add(l2.get(Clomun.dBcolumnType).toString());
				if ("YES".equals(l2.get(Clomun.dBnullAble).toString())) {
					listvalue2.add("NULL");
				} else {
					listvalue2.add("NOT NULL");
				}
				listvalue.add(listvalue2);
			}
			++i;
		}
		return listvalue;
	}

	public static List<List<String>> getSQl2(List<List<Object>> columnKey,
			String Table_name) {// ��map1��map2ͬ��
		List<List<String>> listvalue = new ArrayList<List<String>>();
		List<String> listvalue2 = null;
		for (int i = 0; i < columnKey.size() - 1; i++) {
			List<Object> column1 = columnKey.get(i);
			List<Object> column2 = columnKey.get(i + 1);
			int l1s = column1.size();
			int l2s = column2.size();

			if (l1s != 0 && l2s != 0) {

				if ("PRIMARY".equals(column2.get(ColumnKey.dBkeyName))) {
					if (column1.get(ColumnKey.dBkeyName).equals(
							column2.get(ColumnKey.dBkeyName))) {
						++i;
						continue;
					}
					/*
					 * list1.add("PK��"); list1.add("`test`.`test`");// ����
					 * list1.add("`number1`");// ����������
					 */
					listvalue2 = new ArrayList<String>();
					listvalue2.add("PK��");
					listvalue2.add(Table_name);
					listvalue2.add(column2.get(ColumnKey.dBcolumnName)
							.toString());
					listvalue.add(listvalue2);
				} else {
					if (column1.get(ColumnKey.dBkeyName).equals(
							column2.get(ColumnKey.dBkeyName))
							&& column1.get(ColumnKey.dBcolumnName).equals(
									column2.get(ColumnKey.dBcolumnName))
							&& column1.get(ColumnKey.dBreferTableName).equals(
									column2.get(ColumnKey.dBreferTableName))
							&& column1
									.get(ColumnKey.dBrefercolumnShemaName)
									.equals(column2
											.get(ColumnKey.dBrefercolumnShemaName))) {
						++i;
						continue;
					}
					listvalue2 = new ArrayList<String>();
					/*
					 * list1.add("��"); list1.add("`test`.`test`");//����
					 * list1.add("`FK_test3`");//���Լ����|������
					 * list1.add("Index_test3");//������
					 * list1.add("`number2`");//����������
					 * list1.add("`test1`(` number1`) ");//�������ı������
					 * lis.add(list1);
					 */
					listvalue2.add("FK��");
					listvalue2.add(Table_name);
					listvalue2
							.add("`" + column2.get(ColumnKey.dBkeyName) + "`");
					listvalue2.add("`" + column2.get(ColumnKey.dBcolumnName)
							+ "`");
					listvalue2.add("`"
							+ column2.get(ColumnKey.dBreferTableName)
							+ "`(`"
							+ column2.get(ColumnKey.dBrefercolumnShemaName)
									.toString() + "`)");
					listvalue.add(listvalue2);
				}
			} else if (l1s != 0 && l2s == 0) {// map1��map2��һ��(ɾ������)
				if ("PRIMARY".equals(column1.get(ColumnKey.dBkeyName))) {
					/*
					 * list1.add("PKɾ"); list1.add("`test`.`test`");// ����
					 */listvalue2 = new ArrayList<String>();
					listvalue2.add("PKɾ");
					listvalue2.add(Table_name);
					listvalue.add(listvalue2);
				} else {
					/*
					 * list1.add("ɾ"); list1.add("test.test");//����
					 * list1.add("KEY FK_test3");//���Լ����|������
					 */
					listvalue2 = new ArrayList<String>();
					// ��map1ɾ������
					listvalue2.add("FKɾ");
					listvalue2.add(Table_name);
					listvalue2.add(column1.get(ColumnKey.dBkeyName).toString());
					listvalue.add(listvalue2);
				}
			} else if (l1s == 0 && l2s != 0) {
				if ("PRIMARY".equals(column2.get(ColumnKey.dBkeyName))) {
					/*
					 * list1.add("PK��"); list1.add("`test`.`test`");// ����
					 * list1.add("`number2`");// ����������
					 */
					listvalue2 = new ArrayList<String>();
					listvalue2.add("PK��");
					listvalue2.add(Table_name);
					listvalue2.add(column2.get(ColumnKey.dBcolumnName)
							.toString());
					listvalue.add(listvalue2);
				} else {
					listvalue2 = new ArrayList<String>();
					// ����1�������Լ��
					listvalue2.add("FK��");
					listvalue2.add(Table_name);
					listvalue2
							.add("`" + column2.get(ColumnKey.dBkeyName) + "`");
					listvalue2.add("`" + column2.get(ColumnKey.dBcolumnName)
							+ "`");
					listvalue2.add("`"
							+ column2.get(ColumnKey.dBreferTableName)
							+ "`(`"
							+ column2.get(ColumnKey.dBrefercolumnShemaName)
									.toString() + "`)");
					listvalue.add(listvalue2);
				}
			}
			++i;
		}
		return listvalue;
	}
}
