package com.dh.service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CreateSqlFileUtil {

	public static boolean createSqlFile(String path, String sqlstr) {
		File file = new File(path);
		return createSqlFile(file, sqlstr);
	}
	public static boolean createSqlFile(File file, String sqlstr) {
		if(file == null || sqlstr == null) {
			return false;
		}
		if(file.isFile()) {
			if(!file.exists()) {
				try {
					file.createNewFile();
				} catch (IOException e) {
					System.out.println("创建文件出错:" + e.getMessage());
				}
			}
		} else {
			if(!file.exists()) {
				file.mkdirs();
			}
			file = new File(file.getPath() + "\\TemplateSql.sql");
		}
		StringBuffer strbuf = new StringBuffer();
		BufferedWriter bufout = null;
		try {
			bufout = new BufferedWriter(new FileWriter(file));
			strbuf.append("/*==========================================================*/\n");
			strbuf.append("/* CREATE FROM:  MySQL DB Manager Tool                      */\n");
			DateFormat dateformat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			Date date = new Date();
			strbuf.append("/* CREATE TIME:  " + dateformat.format(date) + "                        */\n");
			strbuf.append("/*==========================================================*/\n\n");
			strbuf.append(sqlstr);
			strbuf.append("\n");
			bufout.write(strbuf.toString());
			bufout.close();
		} catch (IOException e) {
			System.out.println("文件写入错误:" + e.getMessage());
		}
		return true;
	}
}
