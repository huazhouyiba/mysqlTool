package dbBase.entity;

import java.sql.Connection;

import com.dh.service.MySqlDBUtil;

/**
 * 用作封装数据库连接参数的实体
 * 便于创建连接和传参
 * 2013-12-19
 */
public class ConnArgs {

	private String hostaddr;//目标主机地址
	private String portnum; //端口号
	private String dbname;  //数据库名
	private String user;    //连接用户名
	private String password;//连接密码
	
	private Connection conn;
	
	public ConnArgs() {		
	}
	
	public ConnArgs(String hostaddr, String portnum, String dbname,
			String user, String password) {
		super();
		this.hostaddr = hostaddr;
		this.portnum = portnum;
		this.dbname = dbname;
		this.user = user;
		this.password = password;
		this.conn = new MySqlDBUtil().getConnection(this);
	}

	public String getHostaddr() {
		return hostaddr;
	}
	public void setHostaddr(String hostaddr) {
		this.hostaddr = hostaddr;
	}
	public String getProtnum() {
		return portnum;
	}
	public void setProtnum(String protnum) {
		this.portnum = protnum;
	}
	public String getDbname() {
		return dbname;
	}
	public void setDbname(String dbname) {
		this.dbname = dbname;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public Connection getConn() {
		return conn;
	}
	
	public String toString() {
		return "ConnArgs [hostaddr=" + hostaddr + ", protnum=" + portnum
				+ ", dbname=" + dbname + ", user=" + user + ", password="
				+ password + "]";
	}
}
