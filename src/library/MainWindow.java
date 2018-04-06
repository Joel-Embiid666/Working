package library;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;
@SuppressWarnings("unused")
public class MainWindow extends JFrame implements ActionListener{
	/**
	 * ������
	 */
	private static final long serialVersionUID = 1L;
	JPanel panel1;
	Container c;
	JMenuBar MenuB;
	JMenu system,book,borrow,retu,info,usermag;
	JMenu student;////
	JMenuItem userLogin,userAdd,userModify,userDelete,exit,bookAdd,bookModify,bookDelete,
	bookBorrow,bookBorrowinfo,bookReturn,bookReturninfo,bookList,bookBorrowList,userList,message;
	JMenuItem studentAdd,studentDelete,studentModify,readerlist;////
	JLabel titlelabel;
	JLabel l1;//
	public MainWindow()
	{
		
		super("ͼ��ݹ���ϵͳ");
		Calendar cal = Calendar.getInstance(); 
		cal.get(Calendar.YEAR);
		java.text.SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");        
	       String cdate = sdf.format(cal.getTime())+" ͼ�����ϵͳ  Version 1.0";
		MenuB=new JMenuBar();
		system=new JMenu("ϵͳ����");
		usermag=new JMenu("����Ա����"); 
		userLogin=new JMenuItem("����Ա��¼");
		userAdd=new JMenuItem("��ӹ���Ա");
		userModify=new JMenuItem("�޸Ĺ���Ա");
		userDelete=new JMenuItem("ɾ������Ա");
		exit=new JMenuItem("�˳�");
		system.add(userLogin);
		system.add(usermag);
		system.add(exit);
		usermag.add(userAdd);
		usermag.add(userModify);
		usermag.add(userDelete);
		userLogin.addActionListener(this);
		userAdd.addActionListener(this);
		userModify.addActionListener(this);
		userDelete.addActionListener(this);
		exit.addActionListener(this);
		MenuB.add(system);
		student=new JMenu("���߹���");////
		studentAdd=new JMenuItem("����ע��");
		studentDelete=new JMenuItem("ɾ��������Ϣ");
		studentModify=new JMenuItem("�޸Ķ�����Ϣ");
		readerlist=new JMenuItem("�����б�");
		borrow=new JMenu("�������");
		bookBorrow=new JMenuItem("�鼮����");
		bookBorrowinfo=new JMenuItem("������Ϣ�޸�");
		borrow.add(bookBorrow);
		borrow.add(bookBorrowinfo);
		bookBorrow.addActionListener(this);
		bookBorrowinfo.addActionListener(this);
		retu=new JMenu("�������");
		bookReturn=new JMenuItem("�鼮�黹");
		bookReturninfo=new JMenuItem("�黹��Ϣ�޸�");
		retu.add(bookReturn);
		retu.add(bookReturninfo);
		bookReturn.addActionListener(this);
		bookReturninfo.addActionListener(this);
		student.add(studentAdd);
		student.add(studentDelete);
		student.add(studentModify);
		student.add(readerlist);
		student.add(borrow);
		student.add(retu);
		studentAdd.addActionListener(this);
		studentDelete.addActionListener(this);
		studentModify.addActionListener(this);
		MenuB.add(student);
		book=new JMenu("�鼮����");
		bookAdd=new JMenuItem("����鼮");
		bookModify=new JMenuItem("�޸��鼮");
		bookDelete=new JMenuItem("ɾ���鼮");
		book.add(bookAdd);
		book.add(bookModify);
		book.add(bookDelete);
		bookAdd.addActionListener(this);
		bookModify.addActionListener(this);
		bookDelete.addActionListener(this);
		MenuB.add(book);
	
		
		info=new JMenu("�οͲ�ѯ");
		bookList=new JMenuItem("�鼮��ѯ");
		bookBorrowList=new JMenuItem("���Ĳ�ѯ");
		message=new JMenuItem("��������");
		userList=new JMenuItem("��������");
		info.add(bookList);
		info.add(bookBorrowList);
		//info.add(readerlist);
		bookList.addActionListener(this);
		bookBorrowList.addActionListener(this);
		userList.addActionListener(this);
		message.addActionListener(this);
		readerlist.addActionListener(this);
		MenuB.add(info);
		MenuB.add(message);
		MenuB.add(userList);
		Icon icon = new ImageIcon("G://eclipse//library//library.jpg");
		titlelabel=new JLabel(icon);
		titlelabel.setBackground(Color.blue);	
		c=getContentPane();
		c.setLayout(new BorderLayout());
		setJMenuBar(MenuB);//
		panel1=new JPanel();
		panel1.setLayout(new BorderLayout());
		panel1.add(titlelabel,BorderLayout.CENTER);
		c.add(panel1,BorderLayout.CENTER);
		setBounds(100,50,400,300);
		setSize(1024,600);
		l1=new JLabel(cdate);
		panel1.add(l1,BorderLayout.SOUTH);
		extracted();
	    usermag.setEnabled(false);
		book.setEnabled(false);
		borrow.setEnabled(false);
		retu.setEnabled(false);
		info.setEnabled(true);
		student.setEnabled(false);
		message.setEnabled(false);
		setVisible(true);
		
	}
	@SuppressWarnings("deprecation")
	private void extracted() {
		show();
	}
	@SuppressWarnings("deprecation")
	public void actionPerformed(ActionEvent e)
	{
		if(e.getActionCommand()=="����Ա��¼")
		{
			userlogin frame=new userlogin(this);
			Dimension framesize=frame.getPreferredSize();
			Dimension mainframesize=getSize();
			Point loc=getLocation();
			frame.setLocation((mainframesize.width-framesize.width)/2+loc.x,(mainframesize.height-framesize.height)/2+loc.y);
			frame.pack();
			frame.show();
		}
		else if(e.getActionCommand()=="��ӹ���Ա")
		{
			useradd add=new useradd();
			Dimension framesize=add.getPreferredSize();
			Dimension mainframesize=getSize();
			Point loc=getLocation();
			add.setLocation((mainframesize.width-framesize.width)/2+loc.x,(mainframesize.height-framesize.height)/2+loc.y);
			add.pack();
			add.show();
		}
		else if(e.getActionCommand()=="�޸Ĺ���Ա")
		{
			usermodify add=new usermodify();
			Dimension framesize=add.getPreferredSize();
			Dimension mainframesize=getSize();
			Point loc=getLocation();
			add.setLocation((mainframesize.width-framesize.width)/2+loc.x,(mainframesize.height-framesize.height)/2+loc.y);
			add.pack();
			add.show();
		}
		else if(e.getActionCommand()=="ɾ������Ա")
		{
			userdelete add=new userdelete();
			Dimension framesize=add.getPreferredSize();
			Dimension mainframesize=getSize();
			Point loc=getLocation();
			add.setLocation((mainframesize.width-framesize.width)/2+loc.x,(mainframesize.height-framesize.height)/2+loc.y);
			add.pack();
			add.show();
		}
		else if(e.getActionCommand()=="����ע��")
		{
			readeradd add=new readeradd();
			Dimension framesize=add.getPreferredSize();
			Dimension mainframesize=getSize();
			Point loc=getLocation();
			add.setLocation((mainframesize.width-framesize.width)/2+loc.x,(mainframesize.height-framesize.height)/2+loc.y);
			add.pack();
			add.show();
		}
		else if(e.getActionCommand()=="�޸Ķ�����Ϣ")
		{
			readModify add=new readModify();
			Dimension framesize=add.getPreferredSize();
			Dimension mainframesize=getSize();
			Point loc=getLocation();
			add.setLocation((mainframesize.width-framesize.width)/2+loc.x,(mainframesize.height-framesize.height)/2+loc.y);
			add.pack();
			add.show();
		}
		else if(e.getActionCommand()=="ɾ��������Ϣ")
		{
			readerdelete add=new readerdelete();
			Dimension framesize=add.getPreferredSize();
			Dimension mainframesize=getSize();
			Point loc=getLocation();
			add.setLocation((mainframesize.width-framesize.width)/2+loc.x,(mainframesize.height-framesize.height)/2+loc.y);
			add.pack();
			add.show();
		}
		else if(e.getActionCommand()=="����鼮")
		{
			book_add add=new book_add();
			Dimension framesize=add.getPreferredSize();
			Dimension mainframesize=getSize();
			Point loc=getLocation();
			add.setLocation((mainframesize.width-framesize.width)/2+loc.x,(mainframesize.height-framesize.height)/2+loc.y);
			add.pack();
			add.show();
		}
		else if(e.getActionCommand()=="�޸��鼮")
		{
			book_modify add=new book_modify();
			Dimension framesize=add.getPreferredSize();
			Dimension mainframesize=getSize();
			Point loc=getLocation();
			add.setLocation((mainframesize.width-framesize.width)/2+loc.x,(mainframesize.height-framesize.height)/2+loc.y);
			add.pack();
			add.show();
		}
		else if(e.getActionCommand()=="ɾ���鼮")
		{
			book_delete add=new book_delete();
			Dimension framesize=add.getPreferredSize();
			Dimension mainframesize=getSize();
			Point loc=getLocation();
			add.setLocation((mainframesize.width-framesize.width)/2+loc.x,(mainframesize.height-framesize.height)/2+loc.y);
			add.pack();
			add.show();
		}
		else if(e.getActionCommand()=="�鼮����")
		{
			bookborrow add=new bookborrow();
			Dimension framesize=add.getPreferredSize();
			Dimension mainframesize=getSize();
			Point loc=getLocation();
			add.setLocation((mainframesize.width-framesize.width)/2+loc.x,(mainframesize.height-framesize.height)/2+loc.y);
			add.pack();
			add.show();
		}
		else if(e.getActionCommand()=="������Ϣ�޸�")
		{
			bookborrowModify add=new bookborrowModify();
			Dimension framesize=add.getPreferredSize();
			Dimension mainframesize=getSize();
			Point loc=getLocation();
			add.setLocation((mainframesize.width-framesize.width)/2+loc.x,(mainframesize.height-framesize.height)/2+loc.y);
			add.pack();
			add.show();
		}
		else if(e.getActionCommand()=="�鼮�黹")
		{
		bookreturn add=new bookreturn();
		Dimension framesize=add.getPreferredSize();
		Dimension mainframesize=getSize();
		Point loc=getLocation();
		add.setLocation((mainframesize.width-framesize.width)/2+loc.x,(mainframesize.height-framesize.height)/2+loc.y);
		add.pack();
		add.show();
		}
		else if(e.getActionCommand()=="�黹��Ϣ�޸�")
		{
			bookreturnModify add=new bookreturnModify();
			Dimension framesize=add.getPreferredSize();
			Dimension mainframesize=getSize();
			Point loc=getLocation();
			add.setLocation((mainframesize.width-framesize.width)/2+loc.x,(mainframesize.height-framesize.height)/2+loc.y);
			add.pack();
			add.show();
		}
		else if(e.getActionCommand()=="�鼮��ѯ")
		{
			booklist add=new booklist();
			Dimension framesize=add.getPreferredSize();
			Dimension mainframesize=getSize();
			Point loc=getLocation();
			add.setLocation((mainframesize.width-framesize.width)/2+loc.x,(mainframesize.height-framesize.height)/2+loc.y);
			add.pack();
			add.show();
		}
		else if(e.getActionCommand()=="���Ĳ�ѯ")
		{
			bookborrowlist add=new bookborrowlist();
			Dimension framesize=add.getPreferredSize();
			Dimension mainframesize=getSize();
			Point loc=getLocation();
			add.setLocation((mainframesize.width-framesize.width)/2+loc.x,(mainframesize.height-framesize.height)/2+loc.y);
			add.pack();
			add.show();
		}
		else if(e.getActionCommand()=="��������")
		{
			Message add=new Message();
			Dimension framesize=add.getPreferredSize();
			Dimension mainframesize=getSize();
			Point loc=getLocation();
			add.setLocation((mainframesize.width-framesize.width)/2+loc.x,(mainframesize.height-framesize.height)/2+loc.y);
			add.pack();
			add.show();
		}
		else if(e.getActionCommand()=="��������")
		{
			userlist add=new userlist();
			Dimension framesize=add.getPreferredSize();
			Dimension mainframesize=getSize();
			Point loc=getLocation();
			add.setLocation((mainframesize.width-framesize.width)/2+loc.x,(mainframesize.height-framesize.height)/2+loc.y);
			add.pack();
			add.show();
		}
		else if(e.getActionCommand()=="�����б�")
		{
			readerlist add=new readerlist();
			Dimension framesize=add.getPreferredSize();
			Dimension mainframesize=getSize();
			Point loc=getLocation();
			add.setLocation((mainframesize.width-framesize.width)/2+loc.x,(mainframesize.height-framesize.height)/2+loc.y);
			add.pack();
			add.show();
		}
		else if(e.getActionCommand()=="�˳�")
		{
			this.dispose();System.exit(0);
		}
	}
	public void setEnable(String powerType)
	{
		if(powerType.trim().equals("ϵͳ����Ա"))
		{
			usermag.setEnabled(true);
			book.setEnabled(true);
			borrow.setEnabled(true);
			retu.setEnabled(true);
			info.setEnabled(true);
			student.setEnabled(true);
			message.setEnabled(true);
			
		}
		else if(powerType.trim().equals("�鼮����Ա"))
		{
			usermag.setEnabled(false);
			book.setEnabled(true);
			borrow.setEnabled(false);
			retu.setEnabled(false);
			info.setEnabled(true);
			student.setEnabled(false);
			message.setEnabled(true);
		}
		else if(powerType.trim().equals("���Ĺ���Ա"))
		{
			usermag.setEnabled(false);
			book.setEnabled(false);
			borrow.setEnabled(true);
			retu.setEnabled(true);
			info.setEnabled(true);
			student.setEnabled(true);
			message.setEnabled(true);
		}
		else if(powerType.trim().equals("else"))
		{
			usermag.setEnabled(false);
			book.setEnabled(false);
			borrow.setEnabled(false);
			retu.setEnabled(false);
			info.setEnabled(true);
			student.setEnabled(false);
			message.setEnabled(true);
		}
	}
	 public static void main(String []args)
	 {
		 new MainWindow();
	 }
	 public static class userlogin extends JFrame implements ActionListener{
			/**
			 * �û���¼
			 */
			private static final long serialVersionUID = 1L;
		DataBaseManager db=new DataBaseManager();
		Container c;
		ResultSet rs;
		static MainWindow mainframe;
		JPanel panel1,panel2;
		JLabel userlabel,pswlabel;
		JTextField userField;
		JPasswordField pswField;
		JButton yes,cancel;
		public userlogin(MainWindow mainframe)
		{
			super("����Ա��¼");
			userlogin.mainframe=mainframe;
			userlabel=new JLabel("�û���",JLabel.CENTER);
			pswlabel=new JLabel("����",JLabel.CENTER);
			userField=new JTextField(10);
			pswField=new JPasswordField(10);
			yes=new JButton("ȷ��");
			cancel=new JButton("ȡ��");
			yes.addActionListener(this);
			cancel.addActionListener(this);
			c=getContentPane();
			c.setLayout(new BorderLayout());
			panel1=new JPanel();
			panel1.setLayout(new GridLayout(2,2));
			panel1.add(userlabel);
			panel1.add(userField);
			panel1.add(pswlabel);
			panel1.add(pswField);
			c.add(panel1,BorderLayout.CENTER);
			panel2=new JPanel();
			panel2.add(yes);
			panel2.add(cancel);
			c.add(panel2,BorderLayout.SOUTH);
			setSize(300,300);
			setVisible(true);

		}
		public void actionPerformed(ActionEvent e)
		{
			if(e.getSource()==cancel)
			{
				mainframe.setEnable("else");
				this.dispose();
			}
			else
			{
				char []password=pswField.getPassword();
				String Password=new String(password);
				if(userField.getText().trim().equals(""))
				{
					JOptionPane.showMessageDialog(null,"�û���������Ϊ��");
				}
				if(Password.equals(""))
				{
					JOptionPane.showMessageDialog(null,"���벻����Ϊ��");
					return;
				}
				
				String strSQL="select * from USR where user_name='"+
				userField.getText().trim()+"'and password='"+Password+"'";
				rs=db.getResult(strSQL);			
				boolean is=false;
				try{
					is=rs.first();
				}catch(SQLException sqle){
					System.out.println(sqle.toString());
				}
				if(!is)
				{
					JOptionPane.showMessageDialog(null, "�û��������ڻ����������");
					mainframe.setEnable("else");
				}else{
					try{
						rs.first();
						mainframe.setEnable(rs.getString("power").trim());
						JOptionPane.showMessageDialog(null, "��½�ɹ�");
						//��½�ɹ����Զ������ѽ��ĳ����鼮����ʾ��Ӧ������<=7����û�
						String sql="select student_name,book_name,borrow_date,return_date,is_returned from borrow";
						ResultSet rs=db.getResult(sql);
						String []name={"����","����","����ʱ��","Ӧ��ʱ��","�Ƿ�黹"};
						String [][]data=new String[0][0];
						DefaultTableModel defaultModel=new DefaultTableModel(data,name);
						JTable table=new JTable(defaultModel);
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
						db.closeConnection();
						this.dispose();
					}catch(SQLException sqle2){
						System.out.println(sqle2.toString());
					}
				}
			}
		}

	 }public class userlist extends JFrame{
			/**
			 * �û��б�
			 */
			private static final long serialVersionUID = 1L;
			DataBaseManager db=new DataBaseManager();
			ResultSet rs;
			Container c;
			JTable table=null;
			DefaultTableModel defaultModel=null;
			public userlist()
			{
				super("����Ա��Ϣһ��");
				c=getContentPane();
				c.setLayout(new BorderLayout());
				String []name={"����Ա����","Ȩ��","��ϵ����"};
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
	 public class useradd  extends JFrame implements ActionListener{
			/**
			 *����û� 
			 */
			private static final long serialVersionUID = 1L;
		DataBaseManager db=new DataBaseManager();
		ResultSet rs;
		Container c;
		JPanel panel1,panel2;
		JLabel userlabel,pswlabel,pswconlabel,loginprivelegelabel,phone;
		JTextField userTextField,phonet;
		JPasswordField pswField,pswconField;
		JComboBox<String> loginprivelege;
		JButton add,cancel;
		public useradd()
		{
			super("��ӹ���Ա");
			c=getContentPane();
			c.setLayout(new BorderLayout());
			userlabel=new JLabel("�û���",JLabel.CENTER);
			pswlabel=new JLabel("����",JLabel.CENTER);
			pswconlabel=new JLabel("ȷ������",JLabel.CENTER);
			loginprivelegelabel=new JLabel("��¼Ȩ��",JLabel.CENTER);
			phone=new JLabel("��ϵ����",JLabel.CENTER);
			userTextField=new JTextField(10);
			pswField=new JPasswordField(10);
			pswconField=new JPasswordField(10);
			phonet=new JTextField(10);
			loginprivelege=new JComboBox<String>();
			loginprivelege.addItem("ϵͳ����Ա");
			loginprivelege.addItem("�鼮����Ա");
			loginprivelege.addItem("���Ĺ���Ա");
			add=new JButton("���");
			cancel=new JButton("ȡ��");
			add.addActionListener(this);
			cancel.addActionListener(this);
			panel1=new JPanel();
			panel1.setLayout(new GridLayout(5,2));
			panel1.add(userlabel);
			panel1.add(userTextField);
			panel1.add(pswlabel);
			panel1.add(pswField);
			panel1.add(pswconlabel);
			panel1.add(pswconField);
			panel1.add(loginprivelegelabel);
			panel1.add(loginprivelege);
			panel1.add(phone);
			panel1.add(phonet);
			c.add(panel1,BorderLayout.CENTER);
			panel2=new JPanel();
			panel2.add(add);
			panel2.add(cancel);
			c.add(panel2,BorderLayout.SOUTH);
			setSize(300,300);
			setVisible(true);
		}
		@SuppressWarnings("deprecation")
		public void actionPerformed(ActionEvent e)
		{
			if(e.getSource()==cancel)
			{
				db.closeConnection();
				this.dispose();
			}
			else if(e.getSource()==add)
			{
				try {
					String strSQL="select * from USR where user_name='"+
						userTextField.getText().trim()+"'";
					if(userTextField.getText().trim().equals(""))
					{
						JOptionPane.showMessageDialog(null,"�û���������Ϊ��");
					}
					else if(pswField.getText().trim().equals(""))
					{
						JOptionPane.showMessageDialog(null,"���벻����Ϊ��");
					}
					else if(phonet.getText().trim().equals(""))
					{
						JOptionPane.showMessageDialog(null,"���벻����Ϊ��");
					}
					else if(!pswField.getText().trim().equals(pswconField.getText().trim()))
					{
						JOptionPane.showMessageDialog(null,"������������벻һ��");
					}
					else
					{
						if(db.getResult(strSQL).first())
						{
							JOptionPane.showMessageDialog(null,"���û��Ѿ����ڣ������������û���");
						}
					
						else{
							strSQL="insert into USR(user_name,password,power��tel) values('"+
									userTextField.getText().trim()+"','"+
									pswField.getText().trim()+"','"+
									loginprivelege.getSelectedItem()+"','"+
									phonet.getText().trim()+"')";
							if(db.updateSql(strSQL))
				            {
				                this.dispose();
				                JOptionPane.showMessageDialog(null,"����û��ɹ�");
				             }else {
				                JOptionPane.showMessageDialog(null,"����û�ʧ��");
				             }
						}        
					}
					
			}catch(SQLException sqle){
				System.out.println(sqle.toString());
			}catch(Exception ex){
				System.out.println(ex.toString());
			}
			}
		}}
	 public class userdelete extends JFrame implements ActionListener{
			/**
			 * ɾ���û�
			 */
			private static final long serialVersionUID = 1L;
			DataBaseManager db=new DataBaseManager();
			ResultSet rs;
			JPanel panel1,panel2;
			Container c;
			JLabel userlabel,pswlabel;
			JTextField userTextField;
			JPasswordField pswField;
			JButton yes,cancel;
			public userdelete()
			{
				super("ɾ������Ա");
				c=getContentPane();
				c.setLayout(new BorderLayout());
				userlabel=new JLabel("�û���",JLabel.CENTER);
				pswlabel=new JLabel("����",JLabel.CENTER);
				userTextField=new JTextField(10);
				pswField=new JPasswordField(10);
				yes=new JButton("ȷ��");
				cancel=new JButton("ȡ��");
				yes.addActionListener(this);
				cancel.addActionListener(this);
				panel1=new JPanel();
				panel1.setLayout(new GridLayout(2,2));
				panel1.add(userlabel);
				panel1.add(userTextField);
				panel1.add(pswlabel);
				panel1.add(pswField);
				c.add(panel1,BorderLayout.CENTER);
				panel2=new JPanel();
				panel2.add(yes);
				panel2.add(cancel);
			 c.add(panel2,BorderLayout.SOUTH);
			 setSize(300,200);
			 setVisible(true);
				
			}
			public void actionPerformed(ActionEvent e)
			{
				try{
					if(e.getSource()==cancel)
					{
						db.closeConnection();
						this.dispose();
					}
					else if(e.getSource()==yes)
					{
						char []password=pswField.getPassword();
						String passwordSTR=new String(password);
						String strSQL="select * from USR where user_name='"
								+userTextField.getText().trim()+"'and "
										+ "password='"+passwordSTR+"'";
						if(userTextField.getText().trim().equals(""))
						{
							JOptionPane.showMessageDialog(null,"�û���������Ϊ��");
						}
						else if(pswField.equals(""))
						{
							JOptionPane.showMessageDialog(null,"���벻����Ϊ��");
						}
						else if(db.getResult(strSQL).first())
						{
							strSQL="delete from USR where user_name='"
									+userTextField.getText().trim()+"'";
							if(db.updateSql(strSQL))
							{
								this.dispose();
								JOptionPane.showMessageDialog(null,"ɾ���ɹ�");
							}
							else{
								JOptionPane.showMessageDialog(null,"ɾ��ʧ��");
								this.dispose();
							}
							db.closeConnection();
						}else{
							JOptionPane.showMessageDialog(null,"�����ڴ��û������������");
						}
					}
				}catch(SQLException sqle){
					System.out.println(sqle.toString());
				}catch(Exception ex){
					System.out.println(ex.toString());
				}
			}

		}
	 public class usermodify extends JFrame implements ActionListener{
			/**
			 * �û���Ϣ�޸�
			 */
			private static final long serialVersionUID = 1L;
			DataBaseManager db=new DataBaseManager();
			ResultSet rs;
			Container c;
			JPanel panel1,panel2;
			JLabel userlabel, pswlabel,newpswlabel,pswconlabel;
			JTextField userfiled;
			JPasswordField pswField,newpswField,pswconField;
			JButton update,cancel;
			public usermodify()
			{
				super("�޸Ĺ���Ա");
				c=getContentPane();
				c.setLayout(new BorderLayout());
				userlabel=new JLabel("�û���",JLabel.CENTER);
				pswlabel=new JLabel("ԭ����",JLabel.CENTER);
				newpswlabel=new JLabel("������",JLabel.CENTER);
				pswconlabel=new JLabel("ȷ��������",JLabel.CENTER);
				userfiled=new JTextField(10);
				pswField=new JPasswordField(10);
				newpswField=new JPasswordField(10);
				pswconField=new JPasswordField(10);
				update=new JButton("����");
				cancel=new JButton("ȡ��");
				update.addActionListener(this);
				cancel.addActionListener(this);
				panel1=new JPanel();
				panel1.setLayout(new GridLayout(4,2));
				panel1.add(userlabel);
				panel1.add(userfiled);
				panel1.add(pswlabel);
				panel1.add(pswField);
				panel1.add(newpswlabel);
				panel1.add(newpswField);
				panel1.add(pswconlabel);
				panel1.add(pswconField);
				c.add(panel1,BorderLayout.CENTER);
				panel2=new JPanel();
				panel2.add(update);
				panel2.add(cancel);
				c.add(panel2,BorderLayout.SOUTH);
				setSize(300,300);
				setVisible(true);
			}
			public void actionPerformed(ActionEvent e)
			{
				if(e.getSource()==cancel)
				{
					db.closeConnection();
					this.dispose();
				}
				else if(e.getSource()==update)
				{
					try{
						char []password=pswField.getPassword();
						String passwordSTR=new String(password);
						char []newPassword=newpswField.getPassword();
						String newPasswordSTR=new String(newPassword);
						char []comPassword=pswconField.getPassword();
						String comPasswordSTR=new String(comPassword);
						String strSQL="select * from USR where user_name='"
								+userfiled.getText().trim()+"'and "
										+ "password='"+passwordSTR+"'";
						if(userfiled.getText().trim().equals(""))
						{
							JOptionPane.showMessageDialog(null,"�û���������Ϊ��");
						}
						else if(passwordSTR.equals(""))
						{
							JOptionPane.showMessageDialog(null,"ԭ���벻����Ϊ��");
						}
						else if(!newPasswordSTR.equals(comPasswordSTR))
						{
							JOptionPane.showMessageDialog(null,"��������������벻һ��");
						}else{
							if(!db.getResult(strSQL).first())
							{
								JOptionPane.showMessageDialog(null,"���û������ڻ���ԭ���벻��ȷ");
							}
							else{
								strSQL="update USR set password='"
										+newPasswordSTR+"'where user_name='"
										+userfiled.getText().trim()+"'";
								if(db.updateSql(strSQL))
								{
									this.dispose();
									JOptionPane.showMessageDialog(null,"��������ɹ�");
								}
								else {
									JOptionPane.showMessageDialog(null,"��������ʧ��");
								}
								db.closeConnection();
							}
						}
					}catch(SQLException sqle){
						System.out.println(sqle.toString());
					}catch(Exception ex){
						System.out.println(ex.toString());
					}
				}
			}
		}
	 public class readeradd extends JFrame implements ActionListener{
			/**
			 * ��Ӷ���
			 */
			private static final long serialVersionUID = 1L;
			DataBaseManager db=new DataBaseManager();
			ResultSet rs;
			Container c;
			JPanel panel1,panel2;
			JLabel id,name,zj,sex,age,tel,email,borrow,max_borrow,money;
			JTextField idt,namet,sext,aget,telt,emailt,borrowt,max_borrowt,moneyt;
			JComboBox<String> zjc;
			JButton add,cancel;
			public readeradd()
			{
				super("��Ӷ���");
				c=getContentPane();
				c.setLayout(new BorderLayout());
				id=new JLabel("���߱��",JLabel.CENTER);
				name=new JLabel("��������",JLabel.CENTER);
				zj=new JLabel("֤������",JLabel.CENTER);
				sex=new JLabel("�Ա�",JLabel.CENTER);
				age=new JLabel("����",JLabel.CENTER);
				tel=new JLabel("�绰",JLabel.CENTER);
				email=new JLabel("����",JLabel.CENTER);
				borrow=new JLabel("�ѽ���Ŀ",JLabel.CENTER);
				max_borrow=new JLabel("��������",JLabel.CENTER);
				money=new JLabel("Ѻ��",JLabel.CENTER);
				idt=new JTextField(15);
				namet=new JTextField(15);
				sext=new JTextField(15);
		        aget=new JTextField(15);
		        telt=new JTextField(15);
		        emailt=new JTextField(15);
		        borrowt=new JTextField(15);
		        max_borrowt=new JTextField(15);
		        max_borrowt.setText("7");
		        moneyt=new JTextField(15);
				zjc=new JComboBox<String>();
				zjc.addItem("ѧ��֤");
				zjc.addItem("���֤");
				zjc.addItem("��ʦ֤");
				add=new JButton("���");
				cancel=new JButton("ȡ��");
				add.addActionListener(this);
				cancel.addActionListener(this);
				panel1=new JPanel();
				panel1.setLayout(new GridLayout(10,2));
				panel1.add(id);
				panel1.add(idt);
				panel1.add(name);
				panel1.add(namet);
				panel1.add(zj);
				panel1.add(zjc);
				panel1.add(sex);
				panel1.add(sext);
				panel1.add(age);
				panel1.add(aget);
				panel1.add(tel);
				panel1.add(telt);
				panel1.add(email);
				panel1.add(emailt);
				panel1.add(borrow);
				panel1.add(borrowt);
				panel1.add(max_borrow);
				panel1.add(max_borrowt);
				panel1.add(money);
				panel1.add(moneyt);
				c.add(panel1,BorderLayout.CENTER);
				panel2=new JPanel();
				panel2.add(add);
				panel2.add(cancel);
				c.add(panel2,BorderLayout.SOUTH);
				setSize(300,300);
				setVisible(true);
			}
			public void actionPerformed(ActionEvent e)
			{
				if(e.getSource()==cancel)
				{
					db.closeConnection();
					this.dispose();
				}
				else if(e.getSource()==add)
				{
					if(idt.getText().trim().equals(""))
					{
						JOptionPane.showMessageDialog(null, "��Ų���Ϊ��");
					}
					else if(namet.getText().trim().equals(""))
					{
						JOptionPane.showMessageDialog(null, "��������Ϊ��");
					}
					else if(sext.getText().trim().equals(""))
					{
						JOptionPane.showMessageDialog(null, "�Ա���Ϊ��");
					}
					else if(aget.getText().trim().equals(""))
					{
						JOptionPane.showMessageDialog(null, "���䲻��Ϊ��");
					}
					else if(telt.getText().trim().equals(""))
					{
						JOptionPane.showMessageDialog(null, "�绰����Ϊ��");
					}
					else{
						try{
							String strSQL="insert into reader(student_id,student_name,zj_name,sex,age,tel,email,borrow_count,max_borrow,deposit)	values('"
											+idt.getText().trim()
											+"','"
											+namet.getText().trim()
											+"','"
											+zjc.getSelectedItem()
											+"','"
											+sext.getText().trim()
											+"','"
											+aget.getText().trim()
											+"','"
											+telt.getText().trim()
											+"','"
											+emailt.getText().trim()
											+"','"
											+borrowt.getText().trim()
											+"','"
											+max_borrowt.getText().trim()
											+"','"
											+moneyt.getText().trim()
											+"')";
											if(db.updateSql(strSQL))
											{
												this.dispose();
												JOptionPane.showMessageDialog(null,"��Ӷ��߳ɹ�");
											}
											else
											{
												JOptionPane.showMessageDialog(null,"��Ӷ���ʧ��");
												this.dispose();
											}
											db.closeConnection();
				
						}catch(Exception ex)
						{
							System.out.println(ex.toString());
						}
					}
			}
		}

		}
	 public class readerdelete extends JFrame implements ActionListener{
			/**
			 * ɾ������
			 */
			private static final long serialVersionUID = 1L;
			DataBaseManager db=new DataBaseManager();
			ResultSet rs;
			Container c;
			JLabel TipLabel=new JLabel("������Ҫɾ�����ߵ�id",JLabel.CENTER);
			JTextField ww=new JTextField(15);
			JButton yes,exit;
			JPanel panel1=new JPanel();
			public readerdelete()
			{
				super("ɾ��������Ϣ");
				c=getContentPane();
				c.setLayout(new BorderLayout());
				c.add(TipLabel,BorderLayout.NORTH);
				c.add(ww,BorderLayout.CENTER);
				yes=new JButton("ȷ��");
				exit=new JButton("�˳�");
				yes.addActionListener(this);
				exit.addActionListener(this);
				panel1.add(yes);
				panel1.add(exit);
				c.add(panel1,BorderLayout.SOUTH);
				setVisible(true);
			}
			public void actionPerformed(ActionEvent e)
			{
				if(e.getSource()==exit)
				{
					this.dispose();
				}
				else if(e.getSource()==yes)
				{
					try{
						String strSQL="select borrow_count from reader where student_id='"
								+ww.getText().trim()+"'";
						rs=db.getResult(strSQL);
						if(!rs.first())
						{
							JOptionPane.showMessageDialog(null,"û����Ҫɾ���Ķ���");
						}
						else
						{
							String strSql="delete from reader where student_id='"
									+ww.getText().trim()
									+"'and borrow_count=0";	
							rs.first();
							int count=rs.getInt(1);
							if(!(count==0))
							{
								JOptionPane.showMessageDialog(null,"�˶��߻�����δ��������ɾ��");
							}
							else if(db.updateSql(strSql))
							{
								JOptionPane.showMessageDialog(null,"ɾ���ɹ�");
								db.closeConnection();
								this.dispose();
							}
							else{
								JOptionPane.showMessageDialog(null,"ɾ��ʧ��");
								db.closeConnection();
								this.dispose();
							}
						}
						
					}catch(SQLException sqle){
						System.out.println(sqle.toString());
					}catch(Exception ex){
						System.out.println(ex.toString());
					}
				}
			}

		}
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
	 public class readModify extends JFrame implements ActionListener{
			/**
			 * ������Ϣ�޸�
			 */
			private static final long serialVersionUID = 1L;
			DataBaseManager db=new DataBaseManager();
			ResultSet rs;
			JPanel panel1,panel2,panel3;
			JLabel TipLabel=new JLabel("����ѧ�ŵ�ȷ�� ���������˶��ߵ������Ϣ");
			JLabel id,name,zj,sex,age,tel,email,borrow;
			JTextField idt,namet,sext,aget,telt,emailt,borrowt;
			JComboBox<String> zjc;
			Container c;
			JButton clear,yes,update,exit;
			public readModify()
			{
				super("�޸Ķ�����Ϣ");
				c=getContentPane();
				c.setLayout(new BorderLayout());
				panel3=new JPanel();
				panel3.add(TipLabel);
				c.add(panel3,BorderLayout.NORTH);
				id=new JLabel("���߱��",JLabel.CENTER);
				name=new JLabel("��������",JLabel.CENTER);
				zj=new JLabel("֤������",JLabel.CENTER);
				sex=new JLabel("�Ա�",JLabel.CENTER);
				age=new JLabel("����",JLabel.CENTER);
				tel=new JLabel("�绰",JLabel.CENTER);
				email=new JLabel("����",JLabel.CENTER);
				borrow=new JLabel("�ѽ���Ŀ",JLabel.CENTER);
				idt=new JTextField(15);
				namet=new JTextField(15);
				sext=new JTextField(15);
		        aget=new JTextField(15);
		        telt=new JTextField(15);
		        emailt=new JTextField(15);
		        borrowt=new JTextField(15);
				zjc=new JComboBox<String>();
				zjc.addItem("ѧ��֤");
				zjc.addItem("���֤");
				zjc.addItem("��ʦ֤");
				panel1=new JPanel();
				panel1.setLayout(new GridLayout(8,2));
				panel1.add(id);
				panel1.add(idt);
				panel1.add(name);
				panel1.add(namet);
				panel1.add(zj);
				panel1.add(zjc);
				panel1.add(sex);
				panel1.add(sext);
				panel1.add(age);
				panel1.add(aget);
				panel1.add(tel);
				panel1.add(telt);
				panel1.add(email);
				panel1.add(emailt);
				panel1.add(borrow);
				panel1.add(borrowt);
				c.add(panel1,BorderLayout.CENTER);
				 panel2=new JPanel();
				 panel2.setLayout(new GridLayout(1,4));
				 clear=new JButton("���");
				 yes=new JButton("ȷ��");
				 update=new JButton("����");
				 exit=new JButton("�˳�");
				 panel2.add(clear);
				 panel2.add(yes);
				 panel2.add(update);
				 panel2.add(exit);
				 clear.addActionListener(this);
				 yes.addActionListener(this);
				 update.addActionListener(this);
				 exit.addActionListener(this);
				 update.setEnabled(false);
				 c.add(panel1,BorderLayout.CENTER);
				 c.add(panel2,BorderLayout.SOUTH);
				 setVisible(true);	 
			}
			public void actionPerformed(ActionEvent e)
			{
				if(e.getSource()==exit)
				{
					this.dispose();;
				}
				else if(e.getSource()==clear)
				{
					idt.setText("");
					namet.setText("");
					sext.setText("");
					aget.setText("");
					telt.setText("");
					emailt.setText("");
					
				}
				else if(e.getSource()==yes)
				{
					
					try{
						String strSQL="select * from reader where student_id='"
								+idt.getText().trim()+"'";
						rs=db.getResult(strSQL);
						while(rs.next()){
							idt.setText(rs.getString("student_id"));
							namet.setText(rs.getString("student_name"));
							zjc.setSelectedItem(rs.getString("zj_name"));
							sext.setText(rs.getString("sex"));
							aget.setText(rs.getString("age"));
							telt.setText(rs.getString("tel"));
							emailt.setText(rs.getString("email"));
							borrowt.setText(rs.getString("borrow_count"));
						}
						update.setEnabled(true);
					}catch(NullPointerException upe){
						System.out.println(upe.toString());
					}catch(Exception es){
						System.out.println(es.toString());
					}
				}
				else if(e.getSource()==update)
				{
					try{
						String strSQL="update reader set student_id='"
								+idt.getText().trim()+"',student_name='"
								+namet.getText().trim()+"',zj_name='"
								+zjc.getSelectedItem()+"',sex='"
								+sext.getText().trim()+"',age='"
								+aget.getText().trim()+"',tel='"
								+telt.getText().trim()+"',email='"
								+emailt.getText().trim()+"' where student_id='"+idt.getText().trim()+"'";
						
						if(db.updateSql(strSQL))
						{
							this.dispose();
							JOptionPane.showMessageDialog(null,"���¶��߳ɹ�");
						}
						else {
							JOptionPane.showMessageDialog(null,"���¶���ʧ��");
						}
						db.closeConnection();
					}catch(Exception sqle){
						System.out.println(sqle.toString());
					}
				}
			}

		}
	 private static class DataBaseManager{
			Connection con;
			ResultSet rs;
			Statement stmt;
			public DataBaseManager()
			{
				try{
					Class.forName("oracle.odbc.driver.OracleDriver");
					con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE",
							"xujun","123456");
					stmt=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
					
				}catch(ClassNotFoundException e){
					System.out.println("Failed to load JDBC/ODBC driver.");
					e.printStackTrace();
					System.exit(1);
				}catch(SQLException sqle){
					System.out.println(sqle.toString());
				}
			}
				public ResultSet getResult(String strSQL)
				{
					try{
						rs=stmt.executeQuery(strSQL);
						return rs;
					}catch(SQLException sqle){
						System.out.println(sqle.toString());
						return null;
					}
				}
				public boolean updateSql(String strSQL)
				{
					try{
						stmt.executeQuery(strSQL);
						con.commit();
						return true;
						
					}catch(SQLException sqle){
						System.out.println(sqle.toString());
						return false;
					}
				}
				public void closeConnection(){
					try{
						con.close();
					}catch(SQLException sqle){
						System.out.println(sqle.toString());
					}
				}
				

		}
	 public class book_add extends JFrame implements ActionListener {
			/**
			 * ���ͼ��
			 */
			private static final long serialVersionUID = 1L;
			DataBaseManager db=new DataBaseManager();
			ResultSet rs;
			JPanel panel1,panel2;
			JLabel book_id_label,book_name_label,author_label,
			press_label,press_date_label,price_label,book_num_label,borrowed_num_label,address;
			JTextField book_id_TextField,book_name_TextField,author_TextField,
			press_TextField,press_date_TextField,price_TextField,book_num_TextField,
			borrowed_count;
			JComboBox<String> addresst;
			Container c;
			JButton clear,add,exit;
			public book_add()
			{
				super("���ͼ����Ϣ");
				c=getContentPane();
				c.setLayout(new BorderLayout());
				book_id_label=new JLabel("���",JLabel.CENTER);
				book_name_label=new JLabel("����",JLabel.CENTER);
				author_label=new JLabel("����",JLabel.CENTER);
				press_label=new JLabel("������",JLabel.CENTER);
				press_date_label=new JLabel("��������",JLabel.CENTER);
				price_label=new JLabel("�۸�",JLabel.CENTER);
				book_num_label=new JLabel("�����",JLabel.CENTER);
				borrowed_num_label=new JLabel("�ѽ�����",JLabel.CENTER);
				address=new JLabel("�����ַ",JLabel.CENTER);
				 book_id_TextField=new JTextField(15);
				 book_name_TextField=new JTextField(15);
				 author_TextField=new JTextField(15);
				 press_TextField=new JTextField(15);
				 press_date_TextField=new JTextField(15);
				 price_TextField=new JTextField(15);
				 book_num_TextField=new JTextField(15);
				 borrowed_count=new JTextField(15);
				 borrowed_count.setText("0");
				 addresst=new JComboBox<String>();
				 addresst.addItem("���ӽ�ͼ���");
				 addresst.addItem("�ɻ���ͼ���");
				 addresst.addItem("������ͼ���");
				 addresst.addItem("����·ͼ���");
				 panel1=new JPanel();
				 panel1.setLayout(new GridLayout(9,2));
				 panel1.add(book_id_label);
				 panel1.add(book_id_TextField);
				 panel1.add(book_name_label);
				 panel1.add(book_name_TextField);
				 panel1.add(press_label);
				 panel1.add(press_TextField);
				 panel1.add(author_label); 
				 panel1.add(author_TextField);
				 panel1.add(press_date_label);
				 panel1.add(press_date_TextField);
				 panel1.add(price_label);
				 panel1.add(price_TextField);
				 panel1.add(book_num_label);
				 panel1.add(book_num_TextField);
				 panel1.add(borrowed_num_label);
				 panel1.add(borrowed_count);
				 panel1.add(address);
				 panel1.add(addresst);
				 panel2=new JPanel();
				 panel2.setLayout(new GridLayout(1,3));
				 clear=new JButton("���");
				 clear.addActionListener(this);
				 add=new JButton("���");
				 add.addActionListener(this);
				 exit=new JButton("�˳�");
				 exit.addActionListener(this);
				 panel2.add(clear);
				 panel2.add(add);
				 panel2.add(exit);
				 c.add(panel1,BorderLayout.CENTER);
				 c.add(panel2,BorderLayout.SOUTH);
				 setVisible(true);
			}
			public void actionPerformed(ActionEvent e)
			{
				if(e.getSource()==exit)
				{
					this.dispose();
				}
				else if(e.getSource()==clear)
				{
					book_id_TextField.setText("");
					book_name_TextField.setText("");
					author_TextField.setText("");
					press_TextField.setText("");
					press_date_TextField.setText("");
					price_TextField.setText("");
					book_num_TextField.setText("");
					
				}
				else if(e.getSource()==add)
				{
					if(book_id_TextField.getText().trim().equals(""))
					{
						JOptionPane.showMessageDialog(null, "��Ų���Ϊ��");
					}
					else if(book_name_TextField.getText().trim().equals(""))
					{
						JOptionPane.showMessageDialog(null, "��������Ϊ��");
					}
					else if(author_TextField.getText().trim().equals(""))
					{
						JOptionPane.showMessageDialog(null, "���߲���Ϊ��");
					}
					else if(press_TextField.getText().trim().equals(""))
					{
						JOptionPane.showMessageDialog(null, "�����粻��Ϊ��");
					}
					else if(press_date_TextField.getText().trim().equals(""))
					{
						JOptionPane.showMessageDialog(null, "�������ڲ���Ϊ��");
					}
					else if(price_TextField.getText().trim().equals(""))
					{
						JOptionPane.showMessageDialog(null, "�۸���Ϊ��");
					}
					else if(book_num_TextField.getText().trim().equals(""))
					{
						JOptionPane.showMessageDialog(null, "��治��Ϊ��");
					}
					else if(borrowed_count.getText().trim().equals(""))
					{
						JOptionPane.showMessageDialog(null, "����������Ϊ��");
					}
					
					else {
						try{
							String strSQL="insert into book(book_id,book_name,press,author,press_date,price,book_count,borrowed_count,store_address)	values('"
											+book_id_TextField.getText().trim()
											+"','"
											+book_name_TextField.getText().trim()
											+"','"
											+press_TextField.getText().trim()
											+"','"
											+author_TextField.getText().trim()
											+"','"
											+press_date_TextField.getText().trim()
											+"','"
											+price_TextField.getText().trim()
											+"','"
											+book_num_TextField.getText().trim()
											+"','"
											+borrowed_count.getText().trim()
											+"','"
											+addresst.getSelectedItem()+"')";
											if(db.updateSql(strSQL))
											{
												this.dispose();
												JOptionPane.showMessageDialog(null,"���ͼ��ɹ�");
											}
											else
											{
												JOptionPane.showMessageDialog(null,"���ͼ��ʧ��");
												this.dispose();
											}
											db.closeConnection();
				
						}catch(Exception ex)
						{
							System.out.println(ex.toString());
						}
					}
				}
			}

		}
	 public class book_delete extends JFrame implements ActionListener {
			/**
			 * ɾ��ͼ��
			 */
			private static final long serialVersionUID = 1L;
			DataBaseManager db=new DataBaseManager();
			ResultSet rs;
			Container c;
			JLabel TipLabel=new JLabel("��ѡ��Ҫɾ��������",JLabel.CENTER);
			JComboBox<String> bb=new JComboBox<String>();
			JButton yes,exit;
			JPanel panel1=new JPanel();
			public book_delete()
			{
				super("ɾ��ͼ����Ϣ");
				c=getContentPane();
				c.setLayout(new BorderLayout());
				 try{
					  String strSQL="select book_name from book where book_count>borrowed_count";
					  rs=db.getResult(strSQL);
					  while(rs.next())
					  {
						  bb.addItem(rs.getString(1));
					  }
				  }catch(SQLException sqle){
						System.out.println(sqle.toString());
					}catch(Exception ex){
						System.out.println(ex.toString());
					}
				c.add(TipLabel,BorderLayout.NORTH);
				c.add(bb,BorderLayout.CENTER);
				yes=new JButton("ȷ��");
				exit=new JButton("�˳�");
				yes.addActionListener(this);
				exit.addActionListener(this);
				panel1.add(yes);
				panel1.add(exit);
				c.add(panel1,BorderLayout.SOUTH);
				setVisible(true);
			}
			public void actionPerformed(ActionEvent e)
			{
				if(e.getSource()==exit)
				{
					this.dispose();
				}
				else if(e.getSource()==yes)
				{
					try{
						String strSQL="select borrowed_count from book where book_name='"
								+bb.getSelectedItem()+"'";
						rs=db.getResult(strSQL);
						if(!rs.first())
						{
							JOptionPane.showMessageDialog(null,"�����û����Ҫɾ������");
						}
						else
						{
							String strSql="delete from book where book_name='"
									+bb.getSelectedItem()
									+"'and borrowed_count=0";	
							rs.first();
							int count=rs.getInt(1);
							if(!(count==0))
							{
								JOptionPane.showMessageDialog(null,"���黹��ѧ��û�л�������ɾ��");
							}
							else if(db.updateSql(strSql))
							{
								JOptionPane.showMessageDialog(null,"ɾ���ɹ�");
								db.closeConnection();
								this.dispose();
							}
							else{
								JOptionPane.showMessageDialog(null,"ɾ��ʧ��");
								db.closeConnection();
								this.dispose();
							}
						}
						
					}catch(SQLException sqle){
						System.out.println(sqle.toString());
					}catch(Exception ex){
						System.out.println(ex.toString());
					}
				}
			}

		}
	 public class book_modify extends JFrame implements ActionListener{
			/**
			 * �޸�ͼ����Ϣ
			 */
			private static final long serialVersionUID = 1L;
			DataBaseManager db=new DataBaseManager();
			ResultSet rs;
			JPanel panel1,panel2,panel3;
			JLabel TipLabel=new JLabel("����������ȷ�� ������������������Ϣ");
			JLabel book_name_label,author_label,
			press_label,press_date_label,price_label;
			JTextField book_name_TextField,author_TextField,
			press_TextField,press_date_TextField,price_TextField;
			Container c;
			JButton clear,yes,update,exit;
			public book_modify()
			{
				super("�޸�ͼ����Ϣ");
				c=getContentPane();
				c.setLayout(new BorderLayout());
				panel3=new JPanel();
				panel3.add(TipLabel);
				c.add(panel3,BorderLayout.NORTH);
				book_name_label=new JLabel("����",JLabel.CENTER);
				author_label=new JLabel("����",JLabel.CENTER);
				press_label=new JLabel("������",JLabel.CENTER);
				press_date_label=new JLabel("��������",JLabel.CENTER);
				price_label=new JLabel("�۸�",JLabel.CENTER);
				 book_name_TextField=new JTextField(15);
				 author_TextField=new JTextField(15);
				 press_TextField=new JTextField(15);
				 press_date_TextField=new JTextField(15);
				 price_TextField=new JTextField(15);
				 panel1=new JPanel();
				 panel1.setLayout(new GridLayout(6,2));
				 panel1.add(book_name_label);
				 panel1.add(book_name_TextField);
				 panel1.add(author_label); 
				 panel1.add(author_TextField);
				 panel1.add(press_label);
				 panel1.add(press_TextField);
				 panel1.add(press_date_label);
				 panel1.add(press_date_TextField);
				 panel1.add(price_label);
				 panel1.add(price_TextField);
				 panel2=new JPanel();
				 panel2.setLayout(new GridLayout(1,4));
				 clear=new JButton("���");
				 yes=new JButton("ȷ��");
				 update=new JButton("����");
				 exit=new JButton("�˳�");
				 panel2.add(clear);
				 panel2.add(yes);
				 panel2.add(update);
				 panel2.add(exit);
				 clear.addActionListener(this);
				 yes.addActionListener(this);
				 update.addActionListener(this);
				 exit.addActionListener(this);
				 update.setEnabled(false);
				 c.add(panel1,BorderLayout.CENTER);
				 c.add(panel2,BorderLayout.SOUTH);
				 setVisible(true);	 
			}
			public void actionPerformed(ActionEvent e)
			{
				if(e.getSource()==exit)
				{
					this.dispose();;
				}
				else if(e.getSource()==clear)
				{
					book_name_TextField.setText("");
					author_TextField.setText("");
					press_TextField.setText("");
					press_date_TextField.setText("");
					price_TextField.setText("");
				}
				else if(e.getSource()==yes)
				{
					
					try{
						String strSQL="select * from book where book_name='"
								+book_name_TextField.getText().trim()+"'";
						rs=db.getResult(strSQL);
						while(rs.next()){
							book_name_TextField.setText(rs.getString("book_name"));
							author_TextField.setText(rs.getString("author"));
							press_TextField.setText(rs.getString("press"));
							press_date_TextField.setText(rs.getString("press_date"));
							price_TextField.setText(rs.getString("price"));
						}
						update.setEnabled(true);
					}catch(NullPointerException upe){
						System.out.println(upe.toString());
					}catch(Exception es){
						System.out.println(es.toString());
					}
				}
				else if(e.getSource()==update)
				{
					try{
						String strSQL="update book set book_name='"
								+book_name_TextField.getText().trim()+"',press='"
								+press_TextField.getText().trim()+"',author='"
								+author_TextField.getText().trim()+"',press_date='"
								+press_date_TextField.getText().trim()+"',price='"
								+price_TextField.getText().trim()+"' where book_name='"+book_name_TextField.getText().trim()+"'";
						
						if(db.updateSql(strSQL))
						{
							this.dispose();
							JOptionPane.showMessageDialog(null,"����ͼ��ɹ�");
						}
						else {
							JOptionPane.showMessageDialog(null,"����ͼ��ʧ��");
						}
						db.closeConnection();
					}catch(Exception sqle){
						System.out.println(sqle.toString());
					}
				}
			}

		}
	 public class booklist extends JFrame implements ActionListener {
			/**
			 * �ڿ��б�
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
				super("�鼮��Ϣ��ѯ");
				c=getContentPane();
				c.setLayout(new BorderLayout());
				bookname=new JLabel("����",JLabel.CENTER);
				authorname=new JLabel("����",JLabel.CENTER);
				press=new JLabel("������",JLabel.CENTER);
				booknamet=new JTextField(15);
				authornamet=new JTextField(15);
				presst=new JTextField(15);
				search=new JButton("��ѯ");
				exit=new JButton("�˳�");
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
				String []name={"���","����","������","����","��������","�۸�","ͼ����Ŀ","�ѽ���Ŀ","ʣ����Ŀ","�����ַ"};
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
		}public class bookborrow extends JFrame implements ActionListener{
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
//				month=cal.get(Calendar.MONTH)+3;//��0��ʼ��
//				day=cal.get(Calendar.DAY_OF_MONTH);
//		        java.text.SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");        
//		       String cdate = sdf.format(cal.getTime());    
//		      String da=Integer.toString(year)+"-0"+Integer.toString(month)+"-"+Integer.toString(day);
				borrowname=new JLabel("����������",JLabel.CENTER);
				bookname=new JLabel("����",JLabel.CENTER);
				borrowdate=new JLabel("��������",JLabel.CENTER);
//			    returndate=new JLabel("Ӧ������",JLabel.CENTER);
			    is_return_label=new JLabel("�Ƿ�黹",JLabel.CENTER);
			    borrowdateField=new JTextField(15); 
//			    borrowdateField.setText(cdate);
//			   returndateField=new JTextField(15);
//			   returndateField.setText(da);
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
//			  panel1.add(returndate);
//			  panel1.add(returndateField);
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
//					returndateField.setText("");
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
public class bookborrowModify extends JFrame implements ActionListener{
	/**
	 * �ڿ�����״̬�޸�
	 */
	private static final long serialVersionUID = 1L;
	DataBaseManager db=new DataBaseManager();
	ResultSet rs;
	JPanel panel1,panel2,panel3;
	Container c;
	JLabel tiplabel=new JLabel("�����������������������ȷ��������������������Ϣ");
	JLabel borrowlabel,namelabel,borrowdate;
	JTextField borrowField,nameField,dateField;
	JButton clear,yes,update,cancel;
	public bookborrowModify()
	{
		super("�޸�ͼ�������Ϣ");
		c=getContentPane();
		c.setLayout(new BorderLayout());
		panel3=new JPanel();
		panel3.add(tiplabel);
		c.add(panel3,BorderLayout.NORTH);
		borrowlabel=new JLabel("����������",JLabel.CENTER);
		namelabel=new JLabel("����",JLabel.CENTER);
		borrowdate=new JLabel("��������",JLabel.CENTER);
		borrowField=new JTextField(15);
		nameField=new JTextField(15);
		dateField=new JTextField(15);
		panel1=new JPanel();
		panel1.setLayout(new GridLayout(3,2));
		panel1.add(borrowlabel);
		panel1.add(borrowField);
		panel1.add(namelabel);
		panel1.add(nameField);
		panel1.add(borrowdate);
		panel1.add(dateField);
		c.add(panel1,BorderLayout.CENTER);
		panel2=new JPanel();
		panel2.setLayout(new GridLayout(1,4));
		clear=new JButton("���");
		yes=new JButton("ȷ��");
		update=new JButton("����");
		cancel=new JButton("ȡ��");
		clear.addActionListener(this);
		yes.addActionListener(this);
		update.addActionListener(this);
		cancel.addActionListener(this);
		panel2.add(clear);
		panel2.add(yes);
		panel2.add(update);
		panel2.add(cancel);
		c.add(panel2,BorderLayout.SOUTH);
		setVisible(true);
		setSize(400,200);
		
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==clear)
		{
			borrowField.setText("");
			nameField.setText("");
			dateField.setText("");	
		}
		else if(e.getSource()==cancel)
		{
			this.dispose();
		}
		else if(e.getSource()==yes)
		{
			try{
				String strSQL="select student_name,book_name,borrow_date from borrow where student_name='"
						+borrowField.getText().trim()
						+"'and book_name='"
						+nameField.getText().trim()+"'";
				rs=db.getResult(strSQL);
				if(!rs.first())
				{
					JOptionPane.showMessageDialog(null,"��ѧ��û�н�������û�д���");
				}else{
					borrowField.setText(rs.getString(1));
					nameField.setText(rs.getString(2));
					dateField.setText(rs.getString(3));
					update.setEnabled(true);
				}
					
					}catch(Exception ex)
					{
						System.out.println(ex.toString());
					}
		}
		else if(e.getSource()==update)
		{
			String strSQL="update borrow set borrow_date='"+dateField.getText().trim()+"' where student_name='"
					+borrowField.getText().trim()+"'and book_name='"
					+nameField.getText().trim()+"'";
			if(db.updateSql(strSQL))
			{
				JOptionPane.showMessageDialog(null,"���³ɹ�");
				db.closeConnection();this.dispose();
			}
			else{
				JOptionPane.showMessageDialog(null,"����ʧ��");
				db.closeConnection();this.dispose();
			}
		}
	}

}
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
public class bookreturnModify extends JFrame implements ActionListener{
	/**
	 * �ڿ��黹״̬�޸�
	 */
	private static final long serialVersionUID = 1L;
	DataBaseManager db=new DataBaseManager();
	ResultSet rs;
		JPanel panel1,panel2,panel3;
		Container c;
		JLabel tiplabel=new JLabel("���뻹������������������ȷ��������������������Ϣ");
		JLabel borrowlabel,namelabel,borrowdate;
		JTextField borrowField,nameField,dateField;
		JButton clear,yes,update,cancel;
		public bookreturnModify()
		{
			super("�޸�ͼ�黹����Ϣ");
			c=getContentPane();
			c.setLayout(new BorderLayout());
			panel3=new JPanel();
			panel3.add(tiplabel);
			c.add(panel3,BorderLayout.NORTH);
			borrowlabel=new JLabel("����������",JLabel.CENTER);
			namelabel=new JLabel("����",JLabel.CENTER);
			borrowdate=new JLabel("��������",JLabel.CENTER);
			borrowField=new JTextField(15);
			nameField=new JTextField(15);
			dateField=new JTextField(15);
			panel1=new JPanel();
			panel1.setLayout(new GridLayout(3,2));
			panel1.add(borrowlabel);
			panel1.add(borrowField);
			panel1.add(namelabel);
			panel1.add(nameField);
			panel1.add(borrowdate);
			panel1.add(dateField);
			c.add(panel1,BorderLayout.CENTER);
			panel2=new JPanel();
			panel2.setLayout(new GridLayout(1,4));
			clear=new JButton("���");
			yes=new JButton("ȷ��");
			update=new JButton("����");
			cancel=new JButton("ȡ��");
			clear.addActionListener(this);
			yes.addActionListener(this);
			update.addActionListener(this);
			cancel.addActionListener(this);
			panel2.add(clear);
			panel2.add(yes);
			panel2.add(update);
			panel2.add(cancel);
			c.add(panel2,BorderLayout.SOUTH);
			setVisible(true);
			setSize(400,200);
			
		}
		public void actionPerformed(ActionEvent e)
		{
			if(e.getSource()==clear)
			{
				borrowField.setText("");
				nameField.setText("");
				dateField.setText("");	
			}
			else if(e.getSource()==cancel)
			{
				this.dispose();
			}
			else if(e.getSource()==yes)
			{
				try{
					String strSQL="select student_name,book_name,act_returned from borrow where student_name='"
							+borrowField.getText().trim()
							+"'and book_name='"
							+nameField.getText().trim()+"'";
					rs=db.getResult(strSQL);
					if(!rs.first())
					{
						JOptionPane.showMessageDialog(null,"��ѧ��û�н����");
					}else{
						borrowField.setText(rs.getString(1));
						nameField.setText(rs.getString(2));
						dateField.setText(rs.getString(3));
						update.setEnabled(true);
					}
						
						}catch(Exception ex)
						{
							System.out.println(ex.toString());
						}
			}
			else if(e.getSource()==update)
			{
				String strSQL="update borrow set return_date='"+dateField.getText().trim()+"' where student_name='"
						+borrowField.getText().trim()+"'and book_name='"
						+nameField.getText().trim()+"'";
				if(db.updateSql(strSQL))
				{
					JOptionPane.showMessageDialog(null,"���³ɹ�");
					db.closeConnection();this.dispose();
				}
				else{
					JOptionPane.showMessageDialog(null,"����ʧ��");
					db.closeConnection();this.dispose();
				}
			}
		}

}
public class Message extends JFrame{
	/**
	 * ����
	 */
	private static final long serialVersionUID = 1L;
	DataBaseManager db=new DataBaseManager();
	ResultSet rs;
	Container c;
	JTable table=null;
	DefaultTableModel defaultModel=null;
	public Message()
	{
		super("�������");
		c=getContentPane();
		c.setLayout(new BorderLayout());
		String []name={"���߱��","����","�Ƿ���","ʣ������"};
		String [][]data=new String[0][0];
		defaultModel=new DefaultTableModel(data,name);
		table=new JTable(defaultModel);
		table.setPreferredScrollableViewportSize(new Dimension(400,80));
		JScrollPane s=new JScrollPane(table);
		c.add(s);
		setSize(300,200);
		setVisible(true);
		try{
			String strSQL="select student_name,book_name,is_returned,remain from borrow";
			rs=db.getResult(strSQL);
			while(rs.next())
			{
				Vector<String> insertRow=new Vector<String>();
				insertRow.addElement(rs.getString(1));
				insertRow.addElement(rs.getString(2));
     			insertRow.addElement(rs.getString(3));
				insertRow.addElement(rs.getString(4));
	
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
