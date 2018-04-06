package library;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
public class bookreturn extends JFrame implements ActionListener{
	/**
	 * �ڿ��黹
	 */
	private static final long serialVersionUID = 1L;
	DataBaseManager db=new DataBaseManager();
	ResultSet rs;
	JPanel panel1,panel2;
	Container c;
	JLabel namelabel,booklabel,returndatelabel;
	JTextField returnField;
	JButton clear,yes,cancel;
	JComboBox<String> bookname=new JComboBox<String>();
	JComboBox<String> readername=new JComboBox<String>();
	public bookreturn()
	{
		super("ͼ�黹��");
		c=getContentPane();
		c.setLayout(new BorderLayout());
		Calendar cal = Calendar.getInstance(); 
		  java.text.SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");        
	       String cdate = sdf.format(cal.getTime());   
		namelabel=new JLabel("����������",JLabel.CENTER);
		booklabel =new JLabel("����",JLabel.CENTER);
		returndatelabel=new JLabel("����",JLabel.CENTER);
		
		returnField=new JTextField(15);
		returnField.setText(cdate);
		try{
			String strSQL="select student_name from reader where borrow_count!=0";
			rs=db.getResult(strSQL);
			while(rs.next())
			{
				readername.addItem(rs.getString(1));
			}
		}catch(SQLException sqle){
			System.out.println(sqle.toString());
		}catch(Exception ex){
			System.out.println(ex.toString());
		}
			try{
				String strSQL="select book_name from borrow where is_returned='��'";
				rs=db.getResult(strSQL);
				while(rs.next())
				{
					bookname.addItem(rs.getString(1));
				}
			}catch(SQLException sqle){
				System.out.println(sqle.toString());
			}catch(Exception ex){
				System.out.println(ex.toString());
			}
		panel1=new JPanel();
		panel1.setLayout(new GridLayout(3,2));
		panel1.add(namelabel);
		panel1.add(readername);
		panel1.add(booklabel);
		panel1.add(bookname);
		panel1.add(returndatelabel);
		panel1.add(returnField);
		c.add(panel1,BorderLayout.CENTER);
        panel2=new JPanel();
        panel2.setLayout(new GridLayout(1,3));
        clear=new JButton("���");
        yes=new JButton("ȷ��");
        cancel=new JButton("ȡ��");
        clear.addActionListener(this);
        yes.addActionListener(this);
        cancel.addActionListener(this);
        panel2.add(clear);
        panel2.add(yes);
        panel2.add(cancel);
        c.add(panel2,BorderLayout.SOUTH);
        setVisible(true);
        setSize(300,200);
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==cancel)
		{
			this.dispose();
		}
		
		else if(e.getSource()==clear)
		{
			returnField.setText("");
		}
		else if(e.getSource()==yes)
		{
			if(readername.getSelectedItem().equals(""))
			{
				JOptionPane.showMessageDialog(null,"û�ж��߽���");
			}else if(bookname.getSelectedItem().equals("")){
				JOptionPane.showMessageDialog(null,"ͼ���û�н����");
			}else{
				try{
			     String strSQL="update borrow set act_returned ='"
			    		 +returnField.getText().trim()
			    		 +"',is_returned='��' where student_name='"
						+readername.getSelectedItem()
						+"' and book_name='"
						+bookname.getSelectedItem()+"'";
			     if(db.updateSql(strSQL))
			     {
			    	 JOptionPane.showMessageDialog(null,"�������");
			    	 strSQL="update reader set borrow_count=borrow_count-1 where student_name='"
			    			 +readername.getSelectedItem()+"'";
			    	 db.updateSql(strSQL);
			    	 strSQL="update book set borrowed_count=borrowed_count-1 where book_name='"
			    			 +bookname.getSelectedItem()+"'";
			    	 db.updateSql(strSQL);
			    	 db.closeConnection();
			    	 this.dispose();
			     }
			     else{
			    	 JOptionPane.showMessageDialog(null,"����ʧ��");
			    	 db.closeConnection();
			    	 this.dispose();
			     }
				}catch(Exception se){
					System.out.println(se.toString());
				}
			}/////
		}
		
	}

}
