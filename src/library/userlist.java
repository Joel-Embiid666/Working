package library;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
public class userlist extends JFrame{
	/**
	 * 用户列表
	 */
	private static final long serialVersionUID = 1L;
	DataBaseManager db=new DataBaseManager();
	ResultSet rs;
	Container c;
	JTable table=null;
	DefaultTableModel defaultModel=null;
	public userlist()
	{
		super("管理员信息一览");
		c=getContentPane();
		c.setLayout(new BorderLayout());
		String []name={"管理员姓名","权限","联系号码"};
		String [][]data=new String[0][0];
		defaultModel=new DefaultTableModel(data,name);
		table=new JTable(defaultModel);
		table.setPreferredScrollableViewportSize(new Dimension(400,80));
		JScrollPane s=new JScrollPane(table);
		c.add(s);
		setSize(300,200);
		setVisible(true);
		try{
			String strSQL="select user_name,power,tel from USR";
			rs=db.getResult(strSQL);
			while(rs.next())
			{
				Vector<String> insertRow=new Vector<String>();
				insertRow.addElement(rs.getString(1));
				insertRow.addElement(rs.getString(2));
				insertRow.addElement(rs.getString(3));
				defaultModel.addRow(insertRow);
			}
			table.revalidate();
		}catch(SQLException sqle){
			System.out.println(sqle.toString());
		}catch(Exception ex){
			System.out.println(ex.toString());
		}
	}

}
