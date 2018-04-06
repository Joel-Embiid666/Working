package library;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
public class bookborrowlist extends JFrame implements ActionListener{
	/**
	 * �ڿ����ı�
	 */
	private static final long serialVersionUID = 1L;
	DataBaseManager db=new DataBaseManager();
	ResultSet rs;
	Container c;
	JPanel panel1,panel2;
	JLabel bookname,studentname;
	JTextField booknamet,studentnamet;
	JButton search,exit;
	JTable table=null;
	DefaultTableModel defaultModel=null;
	public bookborrowlist()
	{
		super("�����б�");
		c=getContentPane();
		c.setLayout(new BorderLayout());
		bookname=new JLabel("����",JLabel.CENTER);
		studentname=new JLabel("����",JLabel.CENTER);
		booknamet=new JTextField(15);
		studentnamet=new JTextField(15);
		search=new JButton("��ѯ");
		exit=new JButton("�˳�");
		search.addActionListener(this);
		exit.addActionListener(this);
		Box box1=Box.createHorizontalBox();
		box1.add(studentname);
		box1.add(studentnamet);
		box1.add(search);
		Box box2=Box.createHorizontalBox();
		box2.add(bookname);
		box2.add(booknamet);
		box2.add(exit);
		Box boxH=Box.createVerticalBox();
		boxH.add(box1);
		boxH.add(box2);
		boxH.add(Box.createVerticalGlue());
		panel1=new JPanel();
		panel1.add(boxH);
		panel2=new JPanel();
		String []name={"����","����","����ʱ��","Ӧ��ʱ��","�Ƿ�黹"};
		String [][]data=new String[0][0];
		defaultModel=new DefaultTableModel(data,name);
		table=new JTable(defaultModel);
		table.setPreferredScrollableViewportSize(new Dimension(400,80));
		JScrollPane s=new JScrollPane(table);
		panel2.add(s);
		c.add(panel1,BorderLayout.NORTH);
		c.add(panel2,BorderLayout.SOUTH);
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==exit)
		{
			db.closeConnection();
			this.dispose();
		}
		else if(e.getSource()==search)
		{
			String strSQL="select student_name,book_name,borrow_date,return_date,is_returned from borrow";
			String strSql=null;
			if(studentnamet.getText().trim().equals("")&&booknamet.getText().trim().equals(""))
			{
				strSql=strSQL;
			}
			else if(studentnamet.getText().trim().equals(""))
			{
				strSql="select student_name,book_name,borrow_date,return_date,is_returned from borrow where book_name='"
						+booknamet.getText().trim()+"'";
			}
			else if(booknamet.getText().trim().equals(""))
			{
				strSql="select student_name,book_name,borrow_date,return_date,is_returned from borrow where student_name='"
						+studentnamet.getText().trim()+"'";
			}
			else{
				strSql="select student_name,book_name,borrow_date,return_date,is_returned from borrow where student_name='"
						+studentnamet.getText().trim()
						+"'and book_name='"
						+booknamet.getText().trim()+"'";
				JOptionPane.showMessageDialog(null, "�����黹����7�쳬��");
			}
			try{
				int rowCount=defaultModel.getRowCount()-1;
				int j=rowCount;
				for(int i=0;i<=rowCount;i++)
				{
					defaultModel.removeRow(j);
					defaultModel.setRowCount(j);
					j=j-1;
				}
				rs=db.getResult(strSql);
				while(rs.next())
				{
					Vector<String> insertRow=new Vector<String>();
					insertRow.addElement(rs.getString(1));
					insertRow.addElement(rs.getString(2));
					insertRow.addElement(rs.getString(3));
					insertRow.addElement(rs.getString(4));
					insertRow.addElement(rs.getString(5));
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

}
