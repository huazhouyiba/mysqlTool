package dbBase.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

public class Synchronous {
	// ͬ��sql �ֶ�������������ֵ
	// ���û�е�ֵ
	// �����ݽ�����ɾ�� ���������н����жϽ�����ɾ �ģ�������ӻ���ȡ�����е�
	public static List<List<Object>> synchrodata(List<List<Object>> list) {
		if(list==null){
			return null;
		}
		List<List<Object>> sqls = new ArrayList<List<Object>>();
		int len = list.size();
		for (int i = 0; i < len - 1; i++) {
			List<Object> sql = new ArrayList<Object>();
			List<Object> l1 = list.get(i);
			List<Object> l2 = list.get(i + 1);
			int l1Len = l1.size();
			int l2Len = l2.size();
			if (l1Len == 0 && l2Len != 0) {// ����ʱ��Ĭ�϶��߽ṹһ��
				// ������ֵ����
				String str = createAddSql(l2);
				sql.add(str);
			}
			if (l1Len != 0 && l2Len == 0) {
				String str = createDelsql(CompareData.pKey1, l1);// jΪ��������
				sql.add(str);
			}
			// ������
			if (l1Len != 0 && l2Len != 0) {
				// String str=createUpdateSql(l1,l2);
				   String str = createUpdSql(l1,l2,CompareData.pKey1);
    			   sql.add(str);
			}
			sqls.add(sql);
			++i;
		}
		return sqls;
	}

	private static String createDelsql(String primaryKey, List<Object> l1) {// �������Ͱ�string����
		//String key1 = "";
		StringBuffer str = new StringBuffer();
		str.append("delete from ");
		Iterator<Entry<String, List<String>>> it = CompareData.MetaData
				.entrySet().iterator();
		while (it.hasNext()) {
			Entry<String, List<String>> entry = it.next();
			str.append(entry.getKey());
			//key1 = entry.getValue().get(CompareData.atKey+1);
			break;
		}
		Object obj = l1.get(CompareData.atKey+1);
		if(obj instanceof String) {
			String strid = obj.toString();
			str.append(" where " + primaryKey + " = '" +strid+ "';\r\n");
		} else if(obj instanceof Integer) {
			Integer intid = (Integer) obj;
			str.append(" where " + primaryKey + " = " +intid+ ";\r\n");
		}
		return str.toString();
	}

	private static String createAddSql(List<Object> l1) {
		Iterator<Entry<String, List<String>>> it = CompareData.MetaData
				.entrySet().iterator();
		StringBuffer str = new StringBuffer();
		str.append("insert into ");
		while (it.hasNext()) {
			Entry<String, List<String>> en = it.next();
			str.append(en.getKey());
			str.append(" ( ");
			List<String> colums = en.getValue();
			StringBuffer colstr = new StringBuffer();
			StringBuffer valstr = new StringBuffer();
			//ѭ���ж�û��ֵ���ֶβ�����insert���
			for (int j = 0; j < l1.size(); j++) {
				Object obj = l1.get(j);
				if(obj == null) {
					continue;
				} else if(obj instanceof String) {
					String strval = obj.toString();
					valstr.append("'" + strval + "' ,");
				} else if(obj instanceof Integer) {
					Integer intval = (Integer) obj;
					valstr.append(intval + " ,");
				} else {
					String strval = obj.toString();
					valstr.append("'" + strval + "' ,");
				}
				if (j == colums.size() - 1) {
					colstr.append(" " + colums.get(j));
				} else {
					colstr.append(" " + colums.get(j) + " ,");
				}
			}
			str.append(colstr);
			str.append(" ) values ( ");
			str.append(valstr);
			str.deleteCharAt(str.length()-1);
			str.append(" ) ;\r\n");
			break;
		}
		return str.toString();
	}
   
	//map1
    private static String createUpdSql(List<Object> l1, List<Object> l2, String primaryKey) {
    	List<Object> templ1 = l1;
    	List<Object> templ2 = l2;
    	StringBuffer strbuf = new StringBuffer();
    	int flag = 0;//��������ͬ��Ǻ�ѭ������
    	for(; flag<templ1.size(); flag++) {
    		Object objl1 = templ1.get(flag);
    		Object objl2 = templ2.get(flag);
    		if((objl1 == null) && (objl2 == null)) {
    			continue;
    		} else if(!(objl1.toString().equals(objl2.toString()))) {
    			break;
    		}
    	}
    	//�������ĳ��������ͬ���ؿմ�
    	if(flag >= templ1.size()) {
    		strbuf.append("");
    		return strbuf.toString();
    	}
    	strbuf.append("update ");
    	Iterator<Entry<String, List<String>>> it = CompareData.MetaData
    			.entrySet().iterator();
    	while(it.hasNext()) {
    		Entry<String, List<String>> entry = it.next();
    		strbuf.append(entry.getKey()+" set ");
    		List<String> columns = entry.getValue();
    		for(int j=0; j<l1.size(); j++) {
				Object objl1 = l1.get(j);
				Object objl2 = l2.get(j);
				if((objl1 == null) && (objl2 == null)) {
					continue;
	    		} else if(objl1.toString().equals(objl2.toString())) {
					continue;
				} else if(objl2 instanceof String) {
					String str2 = objl2.toString();
	    			strbuf.append(columns.get(j)+"='"+str2+"',");
				} else if(objl2 instanceof Integer) {
					Integer val = (Integer) objl2;
					strbuf.append(columns.get(j)+"="+val+",");
				} else {
					String str2 = objl2.toString();
	    			strbuf.append(columns.get(j)+"='"+str2+"',");
				}
    		}
			strbuf.deleteCharAt(strbuf.length()-1);
			Object objkey = l1.get(CompareData.atKey);
			if(objkey instanceof String) {
				String strkey = objkey.toString();
				strbuf.append(" where "+primaryKey+"='"+strkey+"';\r\n");
			} else if(objkey instanceof Integer) {
				Integer intkey = (Integer) objkey;
				strbuf.append(" where "+primaryKey+"="+intkey+";\r\n");
			}
    	}
    	
    	return strbuf.toString();
    }
	
}
