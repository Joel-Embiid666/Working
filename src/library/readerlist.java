package library;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
public class readerlist extends JFrame{
	/**
	 * �����б�
	 */
	private static final long serialVersionUID = 1L;
	DataBaseManager db=new DataBaseManager();
	ResultSet rs;
	Container c;
	JTable table=null;
	DefaultTableModel defaultModel=null;
	public readerlist()
	{
		super("�����б�");
		c=getContentPane();
		c.setLayout(new BorderLayout());
		String []name={"���߱��","��������","֤������","�Ա�","����","�绰����","����","�ѽ���Ŀ"};
		String [][]data=new String[0][0];
		defaultModel=new DefaultTableModel(data,name);
		table=new JTable(defaultModel);
		table.setPreferredScrollableViewportSize(new Dimension(400,80));
		JScrollPane s=new JScrollPane(table);
		c.add(s);
		setSize(300,200);
		setVisible(true);
		try{
			String strSQL="select student_id,student_name,zj_name,sex,age,tel,email,borrow_count from reader";
			rs=db.getResult(strSQL);
			while(rs.next())
			{
				Vector<String> insertRow=new Vector<String>();
				insertRow.addElement(rs.getString(1));
				insertRow.addElement(rs.getString(2));
				insertRow.addElement(rs.getString(3));
				insertRow.addElement(rs.getString(4));
				insertRow.addElement(rs.getString(5));
				insertRow.addElement(rs.getString(6));
				insertRow.addElement(rs.getString(7));
				insertRow.addElement(rs.getString(8));
	
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
