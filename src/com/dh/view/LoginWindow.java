package com.dh.view;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

import com.dh.service.MySqlDBUtil;

import dbBase.entity.ConnArgs;




/**  
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
public class LoginWindow extends javax.swing.JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7876803491027351537L;
	
	private JLabel lbl_hostaddr;
	private JTextField txt_hostaddr;
	private JLabel lbl_portnum;
	private JTextField txt_portnum;
	private JButton btn_cancel;
	private JButton btn_access;
	private JPasswordField txt_password;
	private JLabel lbl_password;
	private JTextField txt_username;
	private JLabel lbl_username;
	private JTextField txt_dbname;
	private JLabel lbl_dbname;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				LoginWindow inst = new LoginWindow();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);				
			}
		});
	}
	
	public LoginWindow() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setResizable(false);
			getContentPane().setLayout(null);
			this.setTitle("\u6570\u636e\u5e93\u8fde\u63a5");
			{
				lbl_hostaddr = new JLabel();
				getContentPane().add(lbl_hostaddr);
				lbl_hostaddr.setText("jLabel1");
				lbl_hostaddr.setBounds(12, 30, 90, 30);
				lbl_hostaddr.setText("\u76ee\u6807\u4e3b\u673a\u5730\u5740:");
				lbl_hostaddr.setHorizontalAlignment(SwingConstants.RIGHT);
			}
			{
				txt_hostaddr = new JTextField();
				getContentPane().add(txt_hostaddr);
				txt_hostaddr.setBounds(110, 30, 160, 30);
				txt_hostaddr.setText("127.0.0.1");
				txt_hostaddr.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						txt_hostaddr.setText("");
					}
				});
			}
			{
				lbl_portnum = new JLabel();
				getContentPane().add(lbl_portnum);
				lbl_portnum.setText("\u7aef\u53e3\u53f7:");
				lbl_portnum.setBounds(12, 80, 90, 30);
				lbl_portnum.setHorizontalAlignment(SwingConstants.RIGHT);
			}
			{
				txt_portnum = new JTextField();
				getContentPane().add(txt_portnum);
				txt_portnum.setBounds(110, 80, 160, 30);
				txt_portnum.setText("3306");
				txt_portnum.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						txt_portnum.setText("");
					}
				});
			}
			{
				lbl_dbname = new JLabel();
				getContentPane().add(lbl_dbname);
				lbl_dbname.setText("\u6570\u636e\u5e93\u540d:");
				lbl_dbname.setBounds(12, 130, 90, 30);
				lbl_dbname.setHorizontalAlignment(SwingConstants.RIGHT);
			}
			{
				txt_dbname = new JTextField();
				getContentPane().add(txt_dbname);
				txt_dbname.setBounds(110, 130, 160, 30);
				txt_dbname.setText("mysql");
				txt_dbname.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						txt_dbname.setText("");
					}
				});
			}
			{
				lbl_username = new JLabel();
				getContentPane().add(lbl_username);
				lbl_username.setText("\u7528\u6237\u540d:");
				lbl_username.setBounds(12, 180, 90, 30);
				lbl_username.setHorizontalAlignment(SwingConstants.RIGHT);
			}
			{
				txt_username = new JTextField();
				getContentPane().add(txt_username);
				txt_username.setBounds(110, 180, 160, 30);
				txt_username.setText("root");
				txt_username.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
						txt_username.setText("");
					}
				});
			}
			{
				lbl_password = new JLabel();
				getContentPane().add(lbl_password);
				lbl_password.setText("\u5bc6\u7801:");
				lbl_password.setBounds(12, 230, 90, 30);
				lbl_password.setHorizontalAlignment(SwingConstants.RIGHT);
			}
			{
				txt_password = new JPasswordField();
				getContentPane().add(txt_password);
				txt_password.setBounds(110, 230, 160, 30);
			}
			{
				btn_access = new JButton();
				getContentPane().add(btn_access);
				btn_access.setText("\u8fde\u63a5");
				btn_access.setBounds(70, 275, 80, 30);
				btn_access.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						if(!checkEmpty()) {
							String hostaddr = txt_hostaddr.getText();
							String portnum = txt_portnum.getText();
							String dbname = txt_dbname.getText();
							String username = txt_username.getText();
							String password = new String(txt_password.getPassword());
							ConnArgs ca = new ConnArgs(hostaddr, portnum, dbname, username, password);						
							//判断是否连接上	
							if(checkConnection()) {
								//转到新的窗口
								Myframe myframe = new Myframe(ca);
								int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
								int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
								myframe.setLocation(screenWidth / 2 - myframe.getWidth() / 2,
										screenHeight / 2 - myframe.getHeight() / 2);
								myframe.setVisible(true);
								LoginWindow.this.setVisible(false);
							}
						}
					}
				});
			}
			{
				btn_cancel = new JButton();
				getContentPane().add(btn_cancel);
				btn_cancel.setText("\u53d6\u6d88");
				btn_cancel.setBounds(170, 275, 80, 30);
				btn_cancel.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						System.exit(0);
					}
				});
			}
			pack();
			this.setSize(300, 350);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}
	
	/**
	 * 检查文本框是否为空
	 * @return true为空，false为非空
	 */
	private boolean checkEmpty() {
		String hostaddr = txt_hostaddr.getText();
		String portnum = txt_portnum.getText();
		String dbname = txt_dbname.getText();
		String username = txt_username.getText();
		String password = new String(txt_password.getPassword());
		if(hostaddr==null || hostaddr.trim()=="") {
			return true;
		} else if(portnum==null || portnum.trim()=="") {
			return true;
		} else if(dbname==null || dbname.trim()=="") {
			return true;
		} else if(username==null || username.trim()=="") {
			return true;
		} else if(password==null || password.trim()=="") {
			return true;
		}
		return false;
	}
	
	/**
	 * 检查连接是否成功
	 * @return true为成功，false为失败
	 */
	private  boolean checkConnection() {
		String hostaddr = txt_hostaddr.getText();
		String portnum = txt_portnum.getText();
		String dbname = txt_dbname.getText();
		String username = txt_username.getText();
		String password = new String(txt_password.getPassword());
		ConnArgs ca = new ConnArgs(hostaddr, portnum, dbname, username, password);	
		if(new MySqlDBUtil().getConnection(ca) != null) {
			return true;
		}
		return false;
	}

}
