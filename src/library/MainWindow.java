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
	 * 主窗口
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
		
		super("图书馆管理系统");
		Calendar cal = Calendar.getInstance(); 
		cal.get(Calendar.YEAR);
		java.text.SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");        
	       String cdate = sdf.format(cal.getTime())+" 图书管理系统  Version 1.0";
		MenuB=new JMenuBar();
		system=new JMenu("系统管理");
		usermag=new JMenu("管理员管理"); 
		userLogin=new JMenuItem("管理员登录");
		userAdd=new JMenuItem("添加管理员");
		userModify=new JMenuItem("修改管理员");
		userDelete=new JMenuItem("删除管理员");
		exit=new JMenuItem("退出");
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
		student=new JMenu("读者管理");////
		studentAdd=new JMenuItem("读者注册");
		studentDelete=new JMenuItem("删除读者信息");
		studentModify=new JMenuItem("修改读者信息");
		readerlist=new JMenuItem("读者列表");
		borrow=new JMenu("借书管理");
		bookBorrow=new JMenuItem("书籍出借");
		bookBorrowinfo=new JMenuItem("出借信息修改");
		borrow.add(bookBorrow);
		borrow.add(bookBorrowinfo);
		bookBorrow.addActionListener(this);
		bookBorrowinfo.addActionListener(this);
		retu=new JMenu("还书管理");
		bookReturn=new JMenuItem("书籍归还");
		bookReturninfo=new JMenuItem("归还信息修改");
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
		book=new JMenu("书籍管理");
		bookAdd=new JMenuItem("添加书籍");
		bookModify=new JMenuItem("修改书籍");
		bookDelete=new JMenuItem("删除书籍");
		book.add(bookAdd);
		book.add(bookModify);
		book.add(bookDelete);
		bookAdd.addActionListener(this);
		bookModify.addActionListener(this);
		bookDelete.addActionListener(this);
		MenuB.add(book);
	
		
		info=new JMenu("游客查询");
		bookList=new JMenuItem("书籍查询");
		bookBorrowList=new JMenuItem("借阅查询");
		message=new JMenuItem("超期提醒");
		userList=new JMenuItem("关于我们");
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
		if(e.getActionCommand()=="管理员登录")
		{
			userlogin frame=new userlogin(this);
			Dimension framesize=frame.getPreferredSize();
			Dimension mainframesize=getSize();
			Point loc=getLocation();
			frame.setLocation((mainframesize.width-framesize.width)/2+loc.x,(mainframesize.height-framesize.height)/2+loc.y);
			frame.pack();
			frame.show();
		}
		else if(e.getActionCommand()=="添加管理员")
		{
			useradd add=new useradd();
			Dimension framesize=add.getPreferredSize();
			Dimension mainframesize=getSize();
			Point loc=getLocation();
			add.setLocation((mainframesize.width-framesize.width)/2+loc.x,(mainframesize.height-framesize.height)/2+loc.y);
			add.pack();
			add.show();
		}
		else if(e.getActionCommand()=="修改管理员")
		{
			usermodify add=new usermodify();
			Dimension framesize=add.getPreferredSize();
			Dimension mainframesize=getSize();
			Point loc=getLocation();
			add.setLocation((mainframesize.width-framesize.width)/2+loc.x,(mainframesize.height-framesize.height)/2+loc.y);
			add.pack();
			add.show();
		}
		else if(e.getActionCommand()=="删除管理员")
		{
			userdelete add=new userdelete();
			Dimension framesize=add.getPreferredSize();
			Dimension mainframesize=getSize();
			Point loc=getLocation();
			add.setLocation((mainframesize.width-framesize.width)/2+loc.x,(mainframesize.height-framesize.height)/2+loc.y);
			add.pack();
			add.show();
		}
		else if(e.getActionCommand()=="读者注册")
		{
			readeradd add=new readeradd();
			Dimension framesize=add.getPreferredSize();
			Dimension mainframesize=getSize();
			Point loc=getLocation();
			add.setLocation((mainframesize.width-framesize.width)/2+loc.x,(mainframesize.height-framesize.height)/2+loc.y);
			add.pack();
			add.show();
		}
		else if(e.getActionCommand()=="修改读者信息")
		{
			readModify add=new readModify();
			Dimension framesize=add.getPreferredSize();
			Dimension mainframesize=getSize();
			Point loc=getLocation();
			add.setLocation((mainframesize.width-framesize.width)/2+loc.x,(mainframesize.height-framesize.height)/2+loc.y);
			add.pack();
			add.show();
		}
		else if(e.getActionCommand()=="删除读者信息")
		{
			readerdelete add=new readerdelete();
			Dimension framesize=add.getPreferredSize();
			Dimension mainframesize=getSize();
			Point loc=getLocation();
			add.setLocation((mainframesize.width-framesize.width)/2+loc.x,(mainframesize.height-framesize.height)/2+loc.y);
			add.pack();
			add.show();
		}
		else if(e.getActionCommand()=="添加书籍")
		{
			book_add add=new book_add();
			Dimension framesize=add.getPreferredSize();
			Dimension mainframesize=getSize();
			Point loc=getLocation();
			add.setLocation((mainframesize.width-framesize.width)/2+loc.x,(mainframesize.height-framesize.height)/2+loc.y);
			add.pack();
			add.show();
		}
		else if(e.getActionCommand()=="修改书籍")
		{
			book_modify add=new book_modify();
			Dimension framesize=add.getPreferredSize();
			Dimension mainframesize=getSize();
			Point loc=getLocation();
			add.setLocation((mainframesize.width-framesize.width)/2+loc.x,(mainframesize.height-framesize.height)/2+loc.y);
			add.pack();
			add.show();
		}
		else if(e.getActionCommand()=="删除书籍")
		{
			book_delete add=new book_delete();
			Dimension framesize=add.getPreferredSize();
			Dimension mainframesize=getSize();
			Point loc=getLocation();
			add.setLocation((mainframesize.width-framesize.width)/2+loc.x,(mainframesize.height-framesize.height)/2+loc.y);
			add.pack();
			add.show();
		}
		else if(e.getActionCommand()=="书籍出借")
		{
			bookborrow add=new bookborrow();
			Dimension framesize=add.getPreferredSize();
			Dimension mainframesize=getSize();
			Point loc=getLocation();
			add.setLocation((mainframesize.width-framesize.width)/2+loc.x,(mainframesize.height-framesize.height)/2+loc.y);
			add.pack();
			add.show();
		}
		else if(e.getActionCommand()=="出借信息修改")
		{
			bookborrowModify add=new bookborrowModify();
			Dimension framesize=add.getPreferredSize();
			Dimension mainframesize=getSize();
			Point loc=getLocation();
			add.setLocation((mainframesize.width-framesize.width)/2+loc.x,(mainframesize.height-framesize.height)/2+loc.y);
			add.pack();
			add.show();
		}
		else if(e.getActionCommand()=="书籍归还")
		{
		bookreturn add=new bookreturn();
		Dimension framesize=add.getPreferredSize();
		Dimension mainframesize=getSize();
		Point loc=getLocation();
		add.setLocation((mainframesize.width-framesize.width)/2+loc.x,(mainframesize.height-framesize.height)/2+loc.y);
		add.pack();
		add.show();
		}
		else if(e.getActionCommand()=="归还信息修改")
		{
			bookreturnModify add=new bookreturnModify();
			Dimension framesize=add.getPreferredSize();
			Dimension mainframesize=getSize();
			Point loc=getLocation();
			add.setLocation((mainframesize.width-framesize.width)/2+loc.x,(mainframesize.height-framesize.height)/2+loc.y);
			add.pack();
			add.show();
		}
		else if(e.getActionCommand()=="书籍查询")
		{
			booklist add=new booklist();
			Dimension framesize=add.getPreferredSize();
			Dimension mainframesize=getSize();
			Point loc=getLocation();
			add.setLocation((mainframesize.width-framesize.width)/2+loc.x,(mainframesize.height-framesize.height)/2+loc.y);
			add.pack();
			add.show();
		}
		else if(e.getActionCommand()=="借阅查询")
		{
			bookborrowlist add=new bookborrowlist();
			Dimension framesize=add.getPreferredSize();
			Dimension mainframesize=getSize();
			Point loc=getLocation();
			add.setLocation((mainframesize.width-framesize.width)/2+loc.x,(mainframesize.height-framesize.height)/2+loc.y);
			add.pack();
			add.show();
		}
		else if(e.getActionCommand()=="超期提醒")
		{
			Message add=new Message();
			Dimension framesize=add.getPreferredSize();
			Dimension mainframesize=getSize();
			Point loc=getLocation();
			add.setLocation((mainframesize.width-framesize.width)/2+loc.x,(mainframesize.height-framesize.height)/2+loc.y);
			add.pack();
			add.show();
		}
		else if(e.getActionCommand()=="关于我们")
		{
			userlist add=new userlist();
			Dimension framesize=add.getPreferredSize();
			Dimension mainframesize=getSize();
			Point loc=getLocation();
			add.setLocation((mainframesize.width-framesize.width)/2+loc.x,(mainframesize.height-framesize.height)/2+loc.y);
			add.pack();
			add.show();
		}
		else if(e.getActionCommand()=="读者列表")
		{
			readerlist add=new readerlist();
			Dimension framesize=add.getPreferredSize();
			Dimension mainframesize=getSize();
			Point loc=getLocation();
			add.setLocation((mainframesize.width-framesize.width)/2+loc.x,(mainframesize.height-framesize.height)/2+loc.y);
			add.pack();
			add.show();
		}
		else if(e.getActionCommand()=="退出")
		{
			this.dispose();System.exit(0);
		}
	}
	public void setEnable(String powerType)
	{
		if(powerType.trim().equals("系统管理员"))
		{
			usermag.setEnabled(true);
			book.setEnabled(true);
			borrow.setEnabled(true);
			retu.setEnabled(true);
			info.setEnabled(true);
			student.setEnabled(true);
			message.setEnabled(true);
			
		}
		else if(powerType.trim().equals("书籍管理员"))
		{
			usermag.setEnabled(false);
			book.setEnabled(true);
			borrow.setEnabled(false);
			retu.setEnabled(false);
			info.setEnabled(true);
			student.setEnabled(false);
			message.setEnabled(true);
		}
		else if(powerType.trim().equals("借阅管理员"))
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
			 * 用户登录
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
			super("管理员登录");
			userlogin.mainframe=mainframe;
			userlabel=new JLabel("用户名",JLabel.CENTER);
			pswlabel=new JLabel("密码",JLabel.CENTER);
			userField=new JTextField(10);
			pswField=new JPasswordField(10);
			yes=new JButton("确定");
			cancel=new JButton("取消");
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
					JOptionPane.showMessageDialog(null,"用户名不可以为空");
				}
				if(Password.equals(""))
				{
					JOptionPane.showMessageDialog(null,"密码不可以为空");
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
					JOptionPane.showMessageDialog(null, "用户名不存在或者密码错误！");
					mainframe.setEnable("else");
				}else{
					try{
						rs.first();
						mainframe.setEnable(rs.getString("power").trim());
						JOptionPane.showMessageDialog(null, "登陆成功");
						//登陆成功后自动检索已借阅出的书籍，显示出应还日期<=7天的用户
						String sql="select student_name,book_name,borrow_date,return_date,is_returned from borrow";
						ResultSet rs=db.getResult(sql);
						String []name={"读者","书名","借阅时间","应还时间","是否归还"};
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
	 public class useradd  extends JFrame implements ActionListener{
			/**
			 *添加用户 
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
			super("添加管理员");
			c=getContentPane();
			c.setLayout(new BorderLayout());
			userlabel=new JLabel("用户名",JLabel.CENTER);
			pswlabel=new JLabel("密码",JLabel.CENTER);
			pswconlabel=new JLabel("确认密码",JLabel.CENTER);
			loginprivelegelabel=new JLabel("登录权限",JLabel.CENTER);
			phone=new JLabel("联系号码",JLabel.CENTER);
			userTextField=new JTextField(10);
			pswField=new JPasswordField(10);
			pswconField=new JPasswordField(10);
			phonet=new JTextField(10);
			loginprivelege=new JComboBox<String>();
			loginprivelege.addItem("系统管理员");
			loginprivelege.addItem("书籍管理员");
			loginprivelege.addItem("借阅管理员");
			add=new JButton("添加");
			cancel=new JButton("取消");
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
						JOptionPane.showMessageDialog(null,"用户名不可以为空");
					}
					else if(pswField.getText().trim().equals(""))
					{
						JOptionPane.showMessageDialog(null,"密码不可以为空");
					}
					else if(phonet.getText().trim().equals(""))
					{
						JOptionPane.showMessageDialog(null,"号码不可以为空");
					}
					else if(!pswField.getText().trim().equals(pswconField.getText().trim()))
					{
						JOptionPane.showMessageDialog(null,"两次输入的密码不一致");
					}
					else
					{
						if(db.getResult(strSQL).first())
						{
							JOptionPane.showMessageDialog(null,"此用户已经存在，请重新输入用户名");
						}
					
						else{
							strSQL="insert into USR(user_name,password,power，tel) values('"+
									userTextField.getText().trim()+"','"+
									pswField.getText().trim()+"','"+
									loginprivelege.getSelectedItem()+"','"+
									phonet.getText().trim()+"')";
							if(db.updateSql(strSQL))
				            {
				                this.dispose();
				                JOptionPane.showMessageDialog(null,"添加用户成功");
				             }else {
				                JOptionPane.showMessageDialog(null,"添加用户失败");
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
			 * 删除用户
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
				super("删除管理员");
				c=getContentPane();
				c.setLayout(new BorderLayout());
				userlabel=new JLabel("用户名",JLabel.CENTER);
				pswlabel=new JLabel("密码",JLabel.CENTER);
				userTextField=new JTextField(10);
				pswField=new JPasswordField(10);
				yes=new JButton("确定");
				cancel=new JButton("取消");
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
							JOptionPane.showMessageDialog(null,"用户名不可以为空");
						}
						else if(pswField.equals(""))
						{
							JOptionPane.showMessageDialog(null,"密码不可以为空");
						}
						else if(db.getResult(strSQL).first())
						{
							strSQL="delete from USR where user_name='"
									+userTextField.getText().trim()+"'";
							if(db.updateSql(strSQL))
							{
								this.dispose();
								JOptionPane.showMessageDialog(null,"删除成功");
							}
							else{
								JOptionPane.showMessageDialog(null,"删除失败");
								this.dispose();
							}
							db.closeConnection();
						}else{
							JOptionPane.showMessageDialog(null,"不存在此用户或者密码错误");
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
			 * 用户信息修改
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
				super("修改管理员");
				c=getContentPane();
				c.setLayout(new BorderLayout());
				userlabel=new JLabel("用户名",JLabel.CENTER);
				pswlabel=new JLabel("原密码",JLabel.CENTER);
				newpswlabel=new JLabel("新密码",JLabel.CENTER);
				pswconlabel=new JLabel("确认新密码",JLabel.CENTER);
				userfiled=new JTextField(10);
				pswField=new JPasswordField(10);
				newpswField=new JPasswordField(10);
				pswconField=new JPasswordField(10);
				update=new JButton("更新");
				cancel=new JButton("取消");
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
							JOptionPane.showMessageDialog(null,"用户名不可以为空");
						}
						else if(passwordSTR.equals(""))
						{
							JOptionPane.showMessageDialog(null,"原密码不可以为空");
						}
						else if(!newPasswordSTR.equals(comPasswordSTR))
						{
							JOptionPane.showMessageDialog(null,"两次输入的新密码不一致");
						}else{
							if(!db.getResult(strSQL).first())
							{
								JOptionPane.showMessageDialog(null,"此用户不存在或者原密码不正确");
							}
							else{
								strSQL="update USR set password='"
										+newPasswordSTR+"'where user_name='"
										+userfiled.getText().trim()+"'";
								if(db.updateSql(strSQL))
								{
									this.dispose();
									JOptionPane.showMessageDialog(null,"更新密码成功");
								}
								else {
									JOptionPane.showMessageDialog(null,"更新密码失败");
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
			 * 添加读者
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
				super("添加读者");
				c=getContentPane();
				c.setLayout(new BorderLayout());
				id=new JLabel("读者编号",JLabel.CENTER);
				name=new JLabel("读者姓名",JLabel.CENTER);
				zj=new JLabel("证件类型",JLabel.CENTER);
				sex=new JLabel("性别",JLabel.CENTER);
				age=new JLabel("年龄",JLabel.CENTER);
				tel=new JLabel("电话",JLabel.CENTER);
				email=new JLabel("邮箱",JLabel.CENTER);
				borrow=new JLabel("已借数目",JLabel.CENTER);
				max_borrow=new JLabel("最大借书数",JLabel.CENTER);
				money=new JLabel("押金",JLabel.CENTER);
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
				zjc.addItem("学生证");
				zjc.addItem("身份证");
				zjc.addItem("教师证");
				add=new JButton("添加");
				cancel=new JButton("取消");
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
						JOptionPane.showMessageDialog(null, "编号不可为空");
					}
					else if(namet.getText().trim().equals(""))
					{
						JOptionPane.showMessageDialog(null, "姓名不可为空");
					}
					else if(sext.getText().trim().equals(""))
					{
						JOptionPane.showMessageDialog(null, "性别不能为空");
					}
					else if(aget.getText().trim().equals(""))
					{
						JOptionPane.showMessageDialog(null, "年龄不能为空");
					}
					else if(telt.getText().trim().equals(""))
					{
						JOptionPane.showMessageDialog(null, "电话不能为空");
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
												JOptionPane.showMessageDialog(null,"添加读者成功");
											}
											else
											{
												JOptionPane.showMessageDialog(null,"添加读者失败");
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
			 * 删除读者
			 */
			private static final long serialVersionUID = 1L;
			DataBaseManager db=new DataBaseManager();
			ResultSet rs;
			Container c;
			JLabel TipLabel=new JLabel("请输入要删除读者的id",JLabel.CENTER);
			JTextField ww=new JTextField(15);
			JButton yes,exit;
			JPanel panel1=new JPanel();
			public readerdelete()
			{
				super("删除读者信息");
				c=getContentPane();
				c.setLayout(new BorderLayout());
				c.add(TipLabel,BorderLayout.NORTH);
				c.add(ww,BorderLayout.CENTER);
				yes=new JButton("确定");
				exit=new JButton("退出");
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
							JOptionPane.showMessageDialog(null,"没有你要删除的读者");
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
								JOptionPane.showMessageDialog(null,"此读者还有书未还，不可删除");
							}
							else if(db.updateSql(strSql))
							{
								JOptionPane.showMessageDialog(null,"删除成功");
								db.closeConnection();
								this.dispose();
							}
							else{
								JOptionPane.showMessageDialog(null,"删除失败");
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
			 * 读者列表
			 */
			private static final long serialVersionUID = 1L;
			DataBaseManager db=new DataBaseManager();
			ResultSet rs;
			Container c;
			JTable table=null;
			DefaultTableModel defaultModel=null;
			public readerlist()
			{
				super("读者列表");
				c=getContentPane();
				c.setLayout(new BorderLayout());
				String []name={"读者编号","读者姓名","证件类型","性别","年龄","电话号码","邮箱","已借数目"};
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
			 * 读者信息修改
			 */
			private static final long serialVersionUID = 1L;
			DataBaseManager db=new DataBaseManager();
			ResultSet rs;
			JPanel panel1,panel2,panel3;
			JLabel TipLabel=new JLabel("输入学号点确定 ，将调出此读者的相关信息");
			JLabel id,name,zj,sex,age,tel,email,borrow;
			JTextField idt,namet,sext,aget,telt,emailt,borrowt;
			JComboBox<String> zjc;
			Container c;
			JButton clear,yes,update,exit;
			public readModify()
			{
				super("修改读者信息");
				c=getContentPane();
				c.setLayout(new BorderLayout());
				panel3=new JPanel();
				panel3.add(TipLabel);
				c.add(panel3,BorderLayout.NORTH);
				id=new JLabel("读者编号",JLabel.CENTER);
				name=new JLabel("读者姓名",JLabel.CENTER);
				zj=new JLabel("证件类型",JLabel.CENTER);
				sex=new JLabel("性别",JLabel.CENTER);
				age=new JLabel("年龄",JLabel.CENTER);
				tel=new JLabel("电话",JLabel.CENTER);
				email=new JLabel("邮箱",JLabel.CENTER);
				borrow=new JLabel("已借数目",JLabel.CENTER);
				idt=new JTextField(15);
				namet=new JTextField(15);
				sext=new JTextField(15);
		        aget=new JTextField(15);
		        telt=new JTextField(15);
		        emailt=new JTextField(15);
		        borrowt=new JTextField(15);
				zjc=new JComboBox<String>();
				zjc.addItem("学生证");
				zjc.addItem("身份证");
				zjc.addItem("教师证");
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
				 clear=new JButton("清空");
				 yes=new JButton("确定");
				 update=new JButton("更新");
				 exit=new JButton("退出");
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
							JOptionPane.showMessageDialog(null,"更新读者成功");
						}
						else {
							JOptionPane.showMessageDialog(null,"更新读者失败");
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
			 * 添加图书
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
				super("添加图书信息");
				c=getContentPane();
				c.setLayout(new BorderLayout());
				book_id_label=new JLabel("编号",JLabel.CENTER);
				book_name_label=new JLabel("名称",JLabel.CENTER);
				author_label=new JLabel("作者",JLabel.CENTER);
				press_label=new JLabel("出版社",JLabel.CENTER);
				press_date_label=new JLabel("出版日期",JLabel.CENTER);
				price_label=new JLabel("价格",JLabel.CENTER);
				book_num_label=new JLabel("库存数",JLabel.CENTER);
				borrowed_num_label=new JLabel("已借阅数",JLabel.CENTER);
				address=new JLabel("藏书地址",JLabel.CENTER);
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
				 addresst.addItem("扬子津图书馆");
				 addresst.addItem("荷花池图书馆");
				 addresst.addItem("瘦西湖图书馆");
				 addresst.addItem("淮海路图书馆");
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
				 clear=new JButton("清空");
				 clear.addActionListener(this);
				 add=new JButton("添加");
				 add.addActionListener(this);
				 exit=new JButton("退出");
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
						JOptionPane.showMessageDialog(null, "书号不能为空");
					}
					else if(book_name_TextField.getText().trim().equals(""))
					{
						JOptionPane.showMessageDialog(null, "书名不能为空");
					}
					else if(author_TextField.getText().trim().equals(""))
					{
						JOptionPane.showMessageDialog(null, "作者不能为空");
					}
					else if(press_TextField.getText().trim().equals(""))
					{
						JOptionPane.showMessageDialog(null, "出版社不能为空");
					}
					else if(press_date_TextField.getText().trim().equals(""))
					{
						JOptionPane.showMessageDialog(null, "出版日期不能为空");
					}
					else if(price_TextField.getText().trim().equals(""))
					{
						JOptionPane.showMessageDialog(null, "价格不能为空");
					}
					else if(book_num_TextField.getText().trim().equals(""))
					{
						JOptionPane.showMessageDialog(null, "库存不能为空");
					}
					else if(borrowed_count.getText().trim().equals(""))
					{
						JOptionPane.showMessageDialog(null, "借阅数不能为空");
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
												JOptionPane.showMessageDialog(null,"添加图书成功");
											}
											else
											{
												JOptionPane.showMessageDialog(null,"添加图书失败");
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
			 * 删除图书
			 */
			private static final long serialVersionUID = 1L;
			DataBaseManager db=new DataBaseManager();
			ResultSet rs;
			Container c;
			JLabel TipLabel=new JLabel("请选择要删除的书名",JLabel.CENTER);
			JComboBox<String> bb=new JComboBox<String>();
			JButton yes,exit;
			JPanel panel1=new JPanel();
			public book_delete()
			{
				super("删除图书信息");
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
				yes=new JButton("确定");
				exit=new JButton("退出");
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
							JOptionPane.showMessageDialog(null,"书库里没有你要删除的书");
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
								JOptionPane.showMessageDialog(null,"此书还有学生没有还，不可删除");
							}
							else if(db.updateSql(strSql))
							{
								JOptionPane.showMessageDialog(null,"删除成功");
								db.closeConnection();
								this.dispose();
							}
							else{
								JOptionPane.showMessageDialog(null,"删除失败");
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
			 * 修改图书信息
			 */
			private static final long serialVersionUID = 1L;
			DataBaseManager db=new DataBaseManager();
			ResultSet rs;
			JPanel panel1,panel2,panel3;
			JLabel TipLabel=new JLabel("输入书名点确定 ，将调出此书的相关信息");
			JLabel book_name_label,author_label,
			press_label,press_date_label,price_label;
			JTextField book_name_TextField,author_TextField,
			press_TextField,press_date_TextField,price_TextField;
			Container c;
			JButton clear,yes,update,exit;
			public book_modify()
			{
				super("修改图书信息");
				c=getContentPane();
				c.setLayout(new BorderLayout());
				panel3=new JPanel();
				panel3.add(TipLabel);
				c.add(panel3,BorderLayout.NORTH);
				book_name_label=new JLabel("名称",JLabel.CENTER);
				author_label=new JLabel("作者",JLabel.CENTER);
				press_label=new JLabel("出版社",JLabel.CENTER);
				press_date_label=new JLabel("出版日期",JLabel.CENTER);
				price_label=new JLabel("价格",JLabel.CENTER);
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
				 clear=new JButton("清空");
				 yes=new JButton("确定");
				 update=new JButton("更新");
				 exit=new JButton("退出");
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
							JOptionPane.showMessageDialog(null,"更新图书成功");
						}
						else {
							JOptionPane.showMessageDialog(null,"更新图书失败");
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
		}public class bookborrow extends JFrame implements ActionListener{
			/**
			 * 期刊借阅
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
			
				super("书籍出借");
				c=getContentPane();
				c.setLayout(new BorderLayout());
				//		year=cal.get(Calendar.YEAR);
//				month=cal.get(Calendar.MONTH)+3;//从0开始的
//				day=cal.get(Calendar.DAY_OF_MONTH);
//		        java.text.SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");        
//		       String cdate = sdf.format(cal.getTime());    
//		      String da=Integer.toString(year)+"-0"+Integer.toString(month)+"-"+Integer.toString(day);
				borrowname=new JLabel("借阅者姓名",JLabel.CENTER);
				bookname=new JLabel("书名",JLabel.CENTER);
				borrowdate=new JLabel("借书日期",JLabel.CENTER);
//			    returndate=new JLabel("应还日期",JLabel.CENTER);
			    is_return_label=new JLabel("是否归还",JLabel.CENTER);
			    borrowdateField=new JTextField(15); 
//			    borrowdateField.setText(cdate);
//			   returndateField=new JTextField(15);
//			   returndateField.setText(da);
			   is_return=new JTextField(15);
			   is_return.setText("否");
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
			  clear=new JButton("清空");
			  yes=new JButton("确定");
			  cancel=new JButton("取消");
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
						JOptionPane.showMessageDialog(null, "对不起，没有读者借阅");
					}
					else if(booknameBox.getSelectedItem().equals(""))
					{
						JOptionPane.showMessageDialog(null, "对不起，现在书库没有书");
					}
					else {
						try{
							//系统计算归还日期
							//获取输入的借阅日期，自动加两个月
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
								JOptionPane.showMessageDialog(null, "借阅完成");
								strSQL = "update reader set borrow_count=borrow_count+1 where student_name='"+borrownameBox.getSelectedItem()
										+"'";
								db.updateSql(strSQL);
								strSQL="update book set borrowed_count=borrowed_count+1 where book_name='"+booknameBox.getSelectedItem()+"'";
								db.updateSql(strSQL);
								db.closeConnection();
								this.dispose();
							}else{
								JOptionPane.showMessageDialog(null, "借阅失败");
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
			 * 期刊借阅表
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
				super("借阅列表");
				c=getContentPane();
				c.setLayout(new BorderLayout());
				bookname=new JLabel("书名",JLabel.CENTER);
				studentname=new JLabel("人名",JLabel.CENTER);
				booknamet=new JTextField(15);
				studentnamet=new JTextField(15);
				search=new JButton("查询");
				exit=new JButton("退出");
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
				String []name={"读者","书名","借阅时间","应还时间","是否归还"};
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
						JOptionPane.showMessageDialog(null, "你借的书还还有7天超期");
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
	 * 期刊借阅状态修改
	 */
	private static final long serialVersionUID = 1L;
	DataBaseManager db=new DataBaseManager();
	ResultSet rs;
	JPanel panel1,panel2,panel3;
	Container c;
	JLabel tiplabel=new JLabel("输入借阅者姓名和书名单击确定，将调出此书的相关信息");
	JLabel borrowlabel,namelabel,borrowdate;
	JTextField borrowField,nameField,dateField;
	JButton clear,yes,update,cancel;
	public bookborrowModify()
	{
		super("修改图书出借信息");
		c=getContentPane();
		c.setLayout(new BorderLayout());
		panel3=new JPanel();
		panel3.add(tiplabel);
		c.add(panel3,BorderLayout.NORTH);
		borrowlabel=new JLabel("借阅者姓名",JLabel.CENTER);
		namelabel=new JLabel("书名",JLabel.CENTER);
		borrowdate=new JLabel("借书日期",JLabel.CENTER);
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
		clear=new JButton("清空");
		yes=new JButton("确定");
		update=new JButton("更新");
		cancel=new JButton("取消");
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
					JOptionPane.showMessageDialog(null,"此学生没有借过书或者没有此书");
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
				JOptionPane.showMessageDialog(null,"更新成功");
				db.closeConnection();this.dispose();
			}
			else{
				JOptionPane.showMessageDialog(null,"更新失败");
				db.closeConnection();this.dispose();
			}
		}
	}

}
public class bookreturn extends JFrame implements ActionListener{
			/**
			 * 期刊归还
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
				super("图书还入");
				c=getContentPane();
				c.setLayout(new BorderLayout());
				Calendar cal = Calendar.getInstance(); 
				  java.text.SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");        
			       String cdate = sdf.format(cal.getTime());   
				namelabel=new JLabel("还书者姓名",JLabel.CENTER);
				booklabel =new JLabel("书名",JLabel.CENTER);
				returndatelabel=new JLabel("日期",JLabel.CENTER);
				
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
						String strSQL="select book_name from borrow where is_returned='否'";
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
		        clear=new JButton("清除");
		        yes=new JButton("确定");
		        cancel=new JButton("取消");
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
						JOptionPane.showMessageDialog(null,"没有读者借书");
					}else if(bookname.getSelectedItem().equals("")){
						JOptionPane.showMessageDialog(null,"图书馆没有借过书");
					}else{
						try{
					     String strSQL="update borrow set act_returned ='"
					    		 +returnField.getText().trim()
					    		 +"',is_returned='是' where student_name='"
								+readername.getSelectedItem()
								+"' and book_name='"
								+bookname.getSelectedItem()+"'";
					     if(db.updateSql(strSQL))
					     {
					    	 JOptionPane.showMessageDialog(null,"还书完成");
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
					    	 JOptionPane.showMessageDialog(null,"还书失败");
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
	 * 期刊归还状态修改
	 */
	private static final long serialVersionUID = 1L;
	DataBaseManager db=new DataBaseManager();
	ResultSet rs;
		JPanel panel1,panel2,panel3;
		Container c;
		JLabel tiplabel=new JLabel("输入还书者姓名和书名单击确定，将调出此书的相关信息");
		JLabel borrowlabel,namelabel,borrowdate;
		JTextField borrowField,nameField,dateField;
		JButton clear,yes,update,cancel;
		public bookreturnModify()
		{
			super("修改图书还入信息");
			c=getContentPane();
			c.setLayout(new BorderLayout());
			panel3=new JPanel();
			panel3.add(tiplabel);
			c.add(panel3,BorderLayout.NORTH);
			borrowlabel=new JLabel("还书者姓名",JLabel.CENTER);
			namelabel=new JLabel("书名",JLabel.CENTER);
			borrowdate=new JLabel("还书日期",JLabel.CENTER);
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
			clear=new JButton("清空");
			yes=new JButton("确定");
			update=new JButton("更新");
			cancel=new JButton("取消");
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
						JOptionPane.showMessageDialog(null,"此学生没有借过书");
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
					JOptionPane.showMessageDialog(null,"更新成功");
					db.closeConnection();this.dispose();
				}
				else{
					JOptionPane.showMessageDialog(null,"更新失败");
					db.closeConnection();this.dispose();
				}
			}
		}

}
public class Message extends JFrame{
	/**
	 * 留言
	 */
	private static final long serialVersionUID = 1L;
	DataBaseManager db=new DataBaseManager();
	ResultSet rs;
	Container c;
	JTable table=null;
	DefaultTableModel defaultModel=null;
	public Message()
	{
		super("超期情况");
		c=getContentPane();
		c.setLayout(new BorderLayout());
		String []name={"读者编号","书名","是否超期","剩余天数"};
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
