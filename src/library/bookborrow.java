package library;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
public class bookborrow extends JFrame implements ActionListener{
	/**
	 * �ڿ�����
	 */
	private static final long serialVersionUID = 1L;
	DataBaseManager db=new DataBaseManager();
	ResultSet rs;
	Container c;
	JPanel panel1,panel2;
	JLabel borrowname,bookname,borrowdate,returndate,is_return_label;
	JTextField borrowdateField,returndateField,is_return;
	JButton clear,yes,cancel;
	JComboBox<String> borrownameBox=new JComboBox<String>();
	JComboBox<String> booknameBox=new JComboBox<String>();
	public bookborrow()
	{
	
		super("�鼮����");
		c=getContentPane();
		c.setLayout(new BorderLayout());
		//		year=cal.get(Calendar.YEAR);
//		month=cal.get(Calendar.MONTH)+3;//��0��ʼ��
//		day=cal.get(Calendar.DAY_OF_MONTH);
//        java.text.SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");        
//       String cdate = sdf.format(cal.getTime());    
//      String da=Integer.toString(year)+"-0"+Integer.toString(month)+"-"+Integer.toString(day);
		borrowname=new JLabel("����������",JLabel.CENTER);
		bookname=new JLabel("����",JLabel.CENTER);
		borrowdate=new JLabel("��������",JLabel.CENTER);
//	    returndate=new JLabel("Ӧ������",JLabel.CENTER);
	    is_return_label=new JLabel("�Ƿ�黹",JLabel.CENTER);
	    borrowdateField=new JTextField(15); 
//	    borrowdateField.setText(cdate);
//	   returndateField=new JTextField(15);
//	   returndateField.setText(da);
	   is_return=new JTextField(15);
	   is_return.setText("��");
	   try{
			  String strSql="select student_name from reader ";
			  rs=db.getResult(strSql);
			  while(rs.next())
			  {
				  borrownameBox.addItem(rs.getString(1));
			  }
		  }catch(SQLException sqle){
				System.out.println(sqle.toString());
			}catch(Exception ex){
				System.out.println(ex.toString());
			}
	  try{
		  String strSQL="select book_name from book where book_count>borrowed_count";
		  rs=db.getResult(strSQL);
		  while(rs.next())
		  {
			  booknameBox.addItem(rs.getString(1));
		  }
	  }catch(SQLException sqle){
			System.out.println(sqle.toString());
		}catch(Exception ex){
			System.out.println(ex.toString());
		}
	  panel1=new JPanel();
	  panel1.setLayout(new GridLayout(5,2));
	  panel1.add(borrowname);
	  panel1.add(borrownameBox);
	  panel1.add(bookname);
	  panel1.add(booknameBox);
	  panel1.add(borrowdate);
	  panel1.add(borrowdateField);
//	  panel1.add(returndate);
//	  panel1.add(returndateField);
	  panel1.add(is_return_label);
	  panel1.add(is_return);
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
	  setSize(300,300);
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==cancel)
		{
			this.dispose();
		}
		else if(e.getSource()==clear)
		{
		
			borrowdateField.setText("");
//			returndateField.setText("");
			is_return.setText("");
		}
		else if(e.getSource()==yes)
		{
			if(borrownameBox.getSelectedItem().equals(""))
			{
				JOptionPane.showMessageDialog(null, "�Բ���û�ж��߽���");
			}
			else if(booknameBox.getSelectedItem().equals(""))
			{
				JOptionPane.showMessageDialog(null, "�Բ����������û����");
			}
			else {
				try{
					//ϵͳ����黹����
					//��ȡ����Ľ������ڣ��Զ���������
					String startDate=borrowdateField.getText().trim();
					SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
					Date dateStart=format.parse(startDate);
					Calendar cd=Calendar.getInstance();
					cd.setTime(dateStart);
					cd.add(Calendar.MONTH, 2);
					String returnDate=format.format(cd.getTime());
					String strSQL="insert into borrow(student_name,book_name,borrow_date,return_date,is_returned) values('"
									+borrownameBox.getSelectedItem()
									+"','"
									+booknameBox.getSelectedItem()
									+"','"
									+borrowdateField.getText().trim()
									+"','"
									+returnDate
									+"','"
									+is_return.getText().trim()
									+"')";
									
					if(db.updateSql(strSQL)){
						JOptionPane.showMessageDialog(null, "�������");
						strSQL = "update reader set borrow_count=borrow_count+1 where student_name='"+borrownameBox.getSelectedItem()
								+"'";
						db.updateSql(strSQL);
						strSQL="update book set borrowed_count=borrowed_count+1 where book_name='"+booknameBox.getSelectedItem()+"'";
						db.updateSql(strSQL);
						db.closeConnection();
						this.dispose();
					}else{
						JOptionPane.showMessageDialog(null, "����ʧ��");
						db.closeConnection();
						this.dispose();
					}
									}catch(Exception se){
										System.out.println(se.toString());
									}
			}
		}
	}

}
