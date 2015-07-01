package dbBase.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBcon {  
    public static Connection getConnection(){
    	//Connection[] k={};
    	Connection con=null;
    	//Connection con2=null;
    	 try {
			Class.forName(Dbutil.driver);
			con=DriverManager.getConnection(Dbutil.url,Dbutil.user,Dbutil.pwd);
		//	con[1]=DriverManager.getConnection(Dbutil.url2,Dbutil.user2,Dbutil.pwd2);
    	 } catch (SQLException e) {
			System.out.println("SQL�쳣"+e.getMessage());
		}catch(ClassNotFoundException e){
			System.out.println("�ļ������ҵ� :  "+e.getMessage());
		}
    	 return con;
    }
    public static boolean closeConnection(Connection conn){
    	if(conn==null){
    		return true;
    	}
    	try {
			conn.close();
			return true;
		} catch (SQLException e) {
			System.out.println("���ݿ�ر����Ӵ��� :  "+e.getMessage());
			return false;
		}
    }
    public static void closeStatement(Statement statement) {
		if (statement == null) {
			return;
		} else {
			try {
				statement.close();
			} catch (SQLException e) {
				System.out.println("�ر�statement���� : " + e.getMessage());
			}
		}
	}
    public static void closeResultSet(ResultSet resultSet) {
		if (resultSet == null) {
			return;
		} else {
			try {
				resultSet.close();
			} catch (SQLException e) {
				System.out.println("�ر�ResultSet����" + e.getMessage());
			}
		}
	}
    public static void closePreparedStatement(
			PreparedStatement preparedStatement) {
		if (preparedStatement == null) {
			return;
		} else {
			try {
				preparedStatement.close();
			} catch (SQLException e) {
				System.out.println("�ر�PreparedStatement����" + e.getMessage());
			}
		}
	}
    public static void conCommit(Connection connection) {
		try {
			if (connection == null || connection.isClosed()) {
				return;
			} else {
				connection.commit();
			}
		} catch (SQLException e) {
		System.out.println("���ݿ��ύʱ����" + e.getMessage());
		}
	}

}
