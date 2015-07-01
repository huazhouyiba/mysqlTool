package dbBase.entity;

import java.sql.Connection;

import com.dh.service.MySqlDBUtil;

/**
 * ������װ���ݿ����Ӳ�����ʵ��
 * ���ڴ������Ӻʹ���
 * 2013-12-19
 */
public class ConnArgs {

	private String hostaddr;//Ŀ��������ַ
	private String portnum; //�˿ں�
	private String dbname;  //���ݿ���
	private String user;    //�����û���
	private String password;//��������
	
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
