package library;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
public class booklist extends JFrame implements ActionListener {
	/**
	 * 期刊列表
	 */
	private static final long serialVersionUID = 1L;
	DataBaseManager db=new DataBaseManager();
	ResultSet rs;
	Container c;
	JPanel panel1,panel2,panel3;
	JLabel bookname,authorname,press;
	JTextField booknamet,authornamet,presst;
	JButton search,exit;
	JTable table=null;
	DefaultTableModel defaultModel=null;
	public booklist()
	{
		super("书籍信息查询");
		c=getContentPane();
		c.setLayout(new BorderLayout());
		bookname=new JLabel("书名",JLabel.CENTER);
		authorname=new JLabel("作者",JLabel.CENTER);
		press=new JLabel("出版社",JLabel.CENTER);
		booknamet=new JTextField(15);
		authornamet=new JTextField(15);
		presst=new JTextField(15);
		search=new JButton("查询");
		exit=new JButton("退出");
		search.addActionListener(this);
		exit.addActionListener(this);
		panel1=new JPanel();
		panel1.add(bookname);
		panel1.add(booknamet);
		panel1.add(authorname);
		panel1.add(authornamet);
		panel2=new JPanel();
		panel2.add(press);
		panel2.add(presst);
		panel2.add(search);
		panel2.add(exit);
		String []name={"书号","书名","出版社","作者","出版日期","价格","图书数目","已借数目","剩余数目","藏书地址"};
		String [][]data=new String[0][0];
		defaultModel=new DefaultTableModel(data,name);
		table=new JTable(defaultModel);
		table.setPreferredScrollableViewportSize(new Dimension(400,80));
		JScrollPane s=new JScrollPane(table);
		panel3=new JPanel();
		panel3.add(s);
		c.add(panel1,BorderLayout.NORTH);
		c.add(panel2,BorderLayout.CENTER);
		c.add(panel3,BorderLayout.SOUTH);
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
			String strSQL="select book_id,book_name,press,author,press_date,price,book_count,borrowed_count,book_count-borrowed_count,store_address from book";
			String strSql=null;
			if(booknamet.getText().trim().equals("")&&authornamet.getText().trim().equals("")&&presst.getText().trim().equals(""))
			{
				strSql=strSQL;
			}
			else if(booknamet.getText().trim().equals("")&&authornamet.getText().trim().equals(""))
			{
				strSql="select book_id,book_name,press,author,press_date,price,book_count,borrowed_count,book_count-borrowed_count,store_address from book where press='"
						+presst.getText().trim()+"'";
			}
			else if(authornamet.getText().trim().equals("")&&presst.getText().trim().equals(""))
			{
				strSql="select book_id,book_name,press,author,press_date,price,book_count,borrowed_count,book_count-borrowed_count,store_address from book where book_name='"
						+booknamet.getText().trim()+"'";
			}
			else if(booknamet.getText().trim().equals("")&&presst.getText().trim().equals(""))
			{
				strSql="select book_id,book_name,press,author,press_date,price,book_count,borrowed_count,book_count-borrowed_count,store_address from book where author='"
						+authornamet.getText().trim()+"'";
			}
			else{
				strSql="select book_id,book_name,press,author,press_date,price,book_count,borrowed_count,book_count-borrowed_count,store_address from book where book_name='"
						+booknamet.getText().trim()
						+"'and author='"
						+authornamet.getText().trim()
						+"'and press='"
						+presst.getText().trim()+"'";
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
					insertRow.addElement(rs.getString(6));
					insertRow.addElement(rs.getString(7));
					insertRow.addElement(rs.getString(8));
					insertRow.addElement(rs.getString(9));
					insertRow.addElement(rs.getString(10));
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
