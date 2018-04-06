package aaa;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.*;

import javax.swing.*;

//import 课程设计.MainWindow;

public class Login {public static void main(String[] args) {
	LoginDialog dlg = new LoginDialog();
	dlg.setVisible(true);
}
}

class MainWindow extends JFrame { // 主窗体类
static JTextArea textarea;// 回显录入成绩标签
JTextField bname;
JTextField author;
JTextField press;
//JButton sex;
JTextField pdate;
//JTextField birth;
MainWindow() {
	setTitle("后台馆管理系统");
	setBounds(400, 200, 540, 300);
	setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	setLayout(null);// 设置为不使用布局管理器
	JTextArea textarea1=new JTextArea();
	textarea1.setBounds(5, 5, 515, 40);
	textarea1.setEditable(false);
	textarea1.setText("\t欢迎使用后台管理系统");
	textarea1.setFont(new Font("宋体",Font.BOLD,23));
	textarea1.setForeground(Color.red);
    textarea=new JTextArea();
	textarea.setBounds(5, 55, 515, 800);
	textarea.setEditable(false);
	textarea.setRows(100);
	add(textarea);
	add(textarea1);
	createMenu();
	addWindowListener(new WindowAdapter() {
		public void windowClosing(WindowEvent e) {
			exitSystem();
		}
	});
}

void exitSystem() // 处理退出系统事件
{
	int ret = JOptionPane.showConfirmDialog(this, "退出系统吗？", "退出系统吗？",
			JOptionPane.YES_NO_OPTION);
	if (ret == JOptionPane.YES_OPTION) {
		// dispose(); //不能退出登录对话框，需修改登录对话框中的login()方法。
		System.exit(0);
	}
}

void createMenu() {
	// 创建菜单栏并添加到窗体顶部
	JMenuBar mbar = new JMenuBar();
	setJMenuBar(mbar);

	// 创建2个下拉式菜单,并添加到菜单栏
	JMenu m1 = new JMenu("系统管理");
	JMenu m2 = new JMenu("用户管理");
	JMenu m3 = new JMenu("管理员管理");
	mbar.add(m1);
	mbar.add(m2);
	mbar.add(m3);

	// 创建菜单项,并添加到相应的菜单下
	JMenuItem mi11 = new JMenuItem("修改密码");
	JMenuItem mi12 = new JMenuItem("退出系统");
	mi11.setEnabled(false);
	m1.add(mi11);
	m1.add(mi12);
	// 为退出系统菜单项添加事件
	mi12.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			exitSystem();
		}
	});

	JMenuItem mi21 = new JMenuItem("录入用户信息");
	JMenuItem mi22 = new JMenuItem("查询用户信息");
	JMenuItem mi23 = new JMenuItem("管理员");
	JMenuItem mi24 = new JMenuItem("管理员删除");
	m2.add(mi21);
	m2.add(mi22);
	m2.add(mi23);
	m2.add(mi24);
	// 为成绩录入菜单项添加事件
	mi21.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			inputInfo();
		}
	});
	mi22.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			queryInfo();
		}
	});
	

	mi23.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			updateInfo();
		}
	});	
	

	mi24.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			deleteInfo();
		}
	});	
	JMenuItem mi31 = new JMenuItem("录入管理员信息");
	JMenuItem mi32 = new JMenuItem("选择角色");
	JMenuItem mi33 = new JMenuItem("运营商类型");
	//JMenuItem mi34 = new JMenuItem("归还期刊");
	m3.add(mi31);
	m3.add(mi32);
	m3.add(mi33);
	//m3.add(mi34);
	// 为成绩录入菜单项添加事件
	mi31.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			inputreader();
		}
	});
	mi32.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			buyqikan();
		}
	});
	mi33.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			inqikan();
		}
	});
}
void buyqikan() {// 方法
	buyqikanDialog isd = new buyqikanDialog();
	isd.setVisible(true);
}void inqikan() {// 方法
	ruqikanDialog isd = new ruqikanDialog();
	isd.setVisible(true);
}void inputreader() {// 方法
	inputreaderDialog isd = new inputreaderDialog();
	isd.setVisible(true);
}
void updateInfo() {// 修改方法
		updatexinxiDialog isd = new updatexinxiDialog();
		isd.setVisible(true);
	}
void queryInfo() {// 查询方法
		queryxinxiDialog isd = new queryxinxiDialog();
		isd.setVisible(true);
	}
void deleteInfo() {// 删除方法
deletexinxiDialog isd = new deletexinxiDialog();
isd.setVisible(true);
}
void inputInfo() {// 录入方法
	InputxinxiDialog isd = new InputxinxiDialog();
	isd.setVisible(true);
}

static void setTextarea(String str) {
	textarea.setText(textarea.getText()+str);
}
}
//class MainWindow

class inputreaderDialog extends JDialog {
JTextField name;
JTextField number;
JTextField phone;
JButton sex;
//JTextField zhuanye;
//JTextField birth;

inputreaderDialog() {
setTitle("录入管理员信息");
setBounds(500, 250, 600, 300);
setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
setLayout(null);
setModal(true);//模态对话框 （必须处理完录入信息，才可处理其他的）
createGUIElements();
}

void createGUIElements() {
JLabel namelbl = new JLabel("管理员:");
namelbl.setBounds(180, 50, 70, 25);
add(namelbl);
name = new JTextField();
name.setBounds(250, 50, 130, 25);
add(name);
JLabel numberlbl = new JLabel("编号:");
numberlbl.setBounds(180, 20, 70, 25);
add(numberlbl);
number = new JTextField();
number.setBounds(250, 20, 130, 25);
add(number);
JLabel sexlbl=new JLabel("密码：");
sexlbl.setBounds(180, 80, 70, 25);
add(sexlbl);

// 创建单选按钮管理组件
final ButtonGroup btnGroup = new ButtonGroup();

// 创建2个单选按钮,并设置位置及大小,其中第一个被选中
final JRadioButton manRadioButton = new JRadioButton("男");
manRadioButton.setBounds(250, 80, 80, 25);
manRadioButton.setSelected(true);
final JRadioButton womanRadioButton = new JRadioButton("女");
womanRadioButton.setBounds(350, 80, 80, 25);
btnGroup.add(manRadioButton);
btnGroup.add(womanRadioButton);
add(manRadioButton);
add(womanRadioButton);
JLabel phonelbl = new JLabel("联系方式:");
phonelbl.setBounds(180, 110, 100, 25);
add(phonelbl);
phone = new JTextField();
phone.setBounds(250, 110, 130, 25);
add(phone);

JButton submitBtn = new JButton("录入");
submitBtn.setBounds(150, 215, 70, 25);
add(submitBtn);
JButton cancelBtn = new JButton("重置");
cancelBtn.setBounds(340, 215, 70, 25);
add(cancelBtn);
// 添加提交成绩事件
submitBtn.addActionListener(new ActionListener() {
	@Override
	public void actionPerformed(ActionEvent arg0) {
		String str1;
		if(btnGroup.getSelection() == manRadioButton.getModel()){ 
		    str1 = manRadioButton.getText();
		}
		else
			str1 = womanRadioButton.getText();
		String str = "编号:"+ number.getText()+";姓名:" + name.getText()+";性别:"+str1+";联系方式:"
				+ phone.getText()+"\n\r";
		MainWindow.setTextarea(str);// 调用主窗体的静态方法显示,此处可改为存入数据库中
	}
});
cancelBtn.addActionListener(new ActionListener() {
	@Override
	public void actionPerformed(ActionEvent arg0) {
		dispose();// 撤销成绩录入对话框，返回主窗体
	}
});
}
}
class buyqikanDialog extends JDialog {// 修改成绩对话框类
JTextField bname;
JTextField author4;
JTextField press;
//JButton sex;
JTextField pdate;
JTextField info;

buyqikanDialog() {
	setTitle("征订期刊");
	setBounds(500, 250, 600, 300);
	setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
	setLayout(null);
	setModal(true);
	createGUIElements();
}

void createGUIElements() {
	JLabel bnamelbl = new JLabel("输入要征订的期刊名:");
	bnamelbl.setBounds(113, 20, 150, 25);
	add(bnamelbl);
	bname= new JTextField();
	bname.setBounds(260, 20, 130, 25);
	add(bname);
	JLabel infolbl=new JLabel("信息：");
	//bnamelbl.setBounds(180, 50, 70, 25);
	infolbl.setBounds(90, 160, 70, 25);
	infolbl.setEnabled(false);
	add(bnamelbl);
	add(infolbl);
	//bname1 = new JTextField();
	//bname1.setBounds(230, 50, 130, 25);
	//add(bname1);
	info=new JTextField();
	info.setBounds(135, 160, 420, 25);
	add(info);
	JButton querybtn=new JButton("征订");
	querybtn.setBounds(400,20,70,25);
	add(querybtn);
	querybtn.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent arg0) {
	if(MainWindow.textarea.getText().indexOf(bname.getText())!=-1){
		//int index=MainWindow.textarea.getText().indexOf(bname.getText());
		//String a=MainWindow.textarea.getText().substring(index-3, MainWindow.textarea.getText().indexOf("\n\r",index));
		//info.setText(a);
		info.setText("征订成功！");
	}	
	else
		info.setText("征订失败！");
		}
	});
   addWindowListener(new WindowAdapter() {
	public void windowClosing(WindowEvent e) {
		dispose();// 撤销成绩录入对话框，返回主窗体
	}
});		
}
}
class ruqikanDialog extends JDialog {// 修改成绩对话框类
	JTextField bname;
	JTextField author4;
	JTextField press;
	//JButton sex;
	JTextField pdate;
	JTextField info;

	ruqikanDialog() {
		setTitle("期刊入库");
		setBounds(500, 250, 600, 300);
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		setLayout(null);
		setModal(true);
		createGUIElements();
	}

	void createGUIElements() {
		JLabel bnamelbl = new JLabel("输入要入库的期刊名:");
		bnamelbl.setBounds(113, 20, 150, 25);
		add(bnamelbl);
		bname= new JTextField();
		bname.setBounds(260, 20, 130, 25);
		add(bname);
		JLabel infolbl=new JLabel("信息：");
		//bnamelbl.setBounds(180, 50, 70, 25);
		infolbl.setBounds(90, 160, 70, 25);
		infolbl.setEnabled(false);
		add(bnamelbl);
		add(infolbl);
		//bname1 = new JTextField();
		//bname1.setBounds(230, 50, 130, 25);
		//add(bname1);
		info=new JTextField();
		info.setBounds(135, 160, 420, 25);
		add(info);
		JButton querybtn=new JButton("入库");
		querybtn.setBounds(400,20,70,25);
		add(querybtn);
		querybtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
		if(MainWindow.textarea.getText().indexOf(bname.getText())!=-1){
			//int index=MainWindow.textarea.getText().indexOf(bname.getText());
			//String a=MainWindow.textarea.getText().substring(index-3, MainWindow.textarea.getText().indexOf("\n\r",index));
			//info.setText(a);
			info.setText("入库成功！");
		}	
		else
			info.setText("入库失败！");
			}
		});
	   addWindowListener(new WindowAdapter() {
		public void windowClosing(WindowEvent e) {
			dispose();// 撤销成绩录入对话框，返回主窗体
		}
	});		
	}	
}
class InputxinxiDialog extends JDialog {// 录入成绩对话框类
JTextField bname;
JTextField author;
JTextField press;
//JButton sex;
JTextField pdate;
//JTextField birth;

InputxinxiDialog() {
	setTitle("录入期刊信息");
	setBounds(500, 250, 600, 300);
	setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
	setLayout(null);
	setModal(true);
	createGUIElements();
}
void createGUIElements() {
	JLabel bnamelbl = new JLabel("期刊名:");
	bnamelbl.setBounds(180, 50, 70, 25);
	add(bnamelbl);
	bname = new JTextField();
	bname.setBounds(250, 50, 130, 25);
	add(bname);
	JLabel authorlbl = new JLabel("作者:");
	authorlbl.setBounds(180, 20, 70, 25);
	add(authorlbl);
	author = new JTextField();
	author.setBounds(250, 20, 130, 25);
	add(author);
    JLabel presslbl = new JLabel("出版社:");
	presslbl.setBounds(180, 110, 100, 25);
	add(presslbl);
	press = new JTextField();
	press.setBounds(250, 110, 130, 25);
	add(press);
    JLabel pdatelbl = new JLabel("出版日期:");
	pdatelbl.setBounds(180, 140, 70, 25);
	add(pdatelbl);
	pdate = new JTextField();
	pdate.setBounds(250, 140, 130, 25);
	add(pdate);

	JButton submitBtn = new JButton("录入");
	submitBtn.setBounds(150, 215, 70, 25);
	add(submitBtn);
	JButton cancelBtn = new JButton("重置");
	cancelBtn.setBounds(340, 215, 70, 25);
	add(cancelBtn);
	// 添加提交成绩事件
	submitBtn.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			//String str1;
			//if(btnGroup.getSelection() == manRadioButton.getModel()){ 
			    //str1 = manRadioButton.getText();
			//}
			//else
				//str1 = womanRadioButton.getText();
			String str = "管理员:"+ author.getText()+";用户名:" + bname.getText()+";运营商类型:"
	                     + press.getText()+";出版时间:"+pdate.getText()+"\n\r";
			MainWindow.setTextarea(str);// 调用主窗体的静态方法显示,此处可改为存入数据库中
		}
	});
	cancelBtn.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			dispose();// 撤销成绩录入对话框，返回主窗体
		}
	});
	//addWindowListener(new WindowAdapter() {  //点击x窗口关闭
		//public void windowClosing(WindowEvent e) {
			//dispose();
		//}
	//});
}
}
class queryxinxiDialog extends JDialog {// 查询成绩对话框类
	JTextField bname1;
	JTextField info;
	queryxinxiDialog() {
		setTitle("查询信息");
		setBounds(500, 250, 600, 300);
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		setLayout(null);
		setModal(true);
		
		createGUIElements();
	}

	void createGUIElements() {
		JLabel bnamelbl = new JLabel("期刊名:");
		JLabel infolbl=new JLabel("信息：");
		bnamelbl.setBounds(180, 50, 70, 25);
		infolbl.setBounds(90, 160, 70, 25);
		infolbl.setEnabled(false);
		add(bnamelbl);
		add(infolbl);
		bname1 = new JTextField();
		bname1.setBounds(230, 50, 130, 25);
		add(bname1);
		info=new JTextField();
		info.setBounds(135, 160, 420, 25);
		add(info);
		JButton querybtn=new JButton("查询");
		querybtn.setBounds(370,50,70,25);
		add(querybtn);
		querybtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
		if(MainWindow.textarea.getText().indexOf(bname1.getText())!=-1){
			int index=MainWindow.textarea.getText().indexOf(bname1.getText());
			String a=MainWindow.textarea.getText().substring(index-3, MainWindow.textarea.getText().indexOf("\n\r",index));
			info.setText(a);
		}	
		else
			info.setText("查询失败！");
			}
		});
	   addWindowListener(new WindowAdapter() {
		public void windowClosing(WindowEvent e) {
			dispose();// 撤销成绩录入对话框，返回主窗体
		}
	});		
	}	
		}
	class updatexinxiDialog extends JDialog {// 修改成绩对话框类
		JTextField bname;
		JTextField author4;
		JTextField press;
		//JButton sex;
		JTextField pdate;
		JTextField info;

		updatexinxiDialog() {
			setTitle("借阅信息");
			setBounds(500, 250, 600, 300);
			setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
			setLayout(null);
			setModal(true);
			createGUIElements();
		}

		void createGUIElements() {
			JLabel bnamelbl = new JLabel("输入要借阅信息的期刊名:");
			bnamelbl.setBounds(113, 20, 150, 25);
			add(bnamelbl);
			bname= new JTextField();
			bname.setBounds(260, 20, 130, 25);
			add(bname);
			
			JLabel infolbl=new JLabel("信息：");
			//bnamelbl.setBounds(180, 50, 70, 25);
			infolbl.setBounds(90, 160, 70, 25);
			infolbl.setEnabled(false);
			add(bnamelbl);
			add(infolbl);
			info=new JTextField();
			info.setBounds(135, 160, 420, 25);
			add(info);
			JButton querybtn=new JButton("借阅");
			querybtn.setBounds(400,20,70,25);
			add(querybtn);
			querybtn.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
			if(MainWindow.textarea.getText().indexOf(bname.getText())!=-1){
				//int index=MainWindow.textarea.getText().indexOf(bname.getText());
				//String a=MainWindow.textarea.getText().substring(index-3, MainWindow.textarea.getText().indexOf("\n\r",index));
				//info.setText(a);
				info.setText("借阅成功！");
			}	
			else
				info.setText("借阅失败！");
				}
			});
		   addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dispose();// 撤销成绩录入对话框，返回主窗体
			}
		});		
		}	
			
	}
	class deletexinxiDialog extends JDialog {// 修改成绩对话框类
		JTextField bname;
		JTextField author4;
		JTextField press;
		//JButton sex;
		JTextField pdate;
		JTextField info;

		deletexinxiDialog() {
			setTitle("归还信息");
			setBounds(500, 250, 600, 300);
			setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
			setLayout(null);
			setModal(true);
			createGUIElements();
		}

		void createGUIElements() {
			JLabel bnamelbl = new JLabel("输入要归还信息的期刊名:");
			bnamelbl.setBounds(113, 20, 150, 25);
			add(bnamelbl);
			bname= new JTextField();
			bname.setBounds(260, 20, 130, 25);
			add(bname);
			
			JLabel infolbl=new JLabel("信息：");
			//bnamelbl.setBounds(180, 50, 70, 25);
			infolbl.setBounds(90, 160, 70, 25);
			infolbl.setEnabled(false);
			add(bnamelbl);
			add(infolbl);
			//bname1 = new JTextField();
			//bname1.setBounds(230, 50, 130, 25);
			//add(bname1);
			info=new JTextField();
			info.setBounds(135, 160, 420, 25);
			add(info);
			JButton querybtn=new JButton("归还");
			querybtn.setBounds(400,20,70,25);
			add(querybtn);
			querybtn.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
			if(MainWindow.textarea.getText().indexOf(bname.getText())!=-1){
				//int index=MainWindow.textarea.getText().indexOf(bname.getText());
				//String a=MainWindow.textarea.getText().substring(index-3, MainWindow.textarea.getText().indexOf("\n\r",index));
				//info.setText(a);
				info.setText("归还成功！");
			}	
			else
				info.setText("归还失败！");
				}
			});
		   addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dispose();// 撤销成绩录入对话框，返回主窗体
			}
		});		
		}	

	}

class LoginDialog extends JDialog {// 登录对话框类
JLabel usernamelbl;
JLabel passwordlbl;
JTextField username;
JPasswordField password;
JButton loginBtn;
JButton cancelBtn;

LoginDialog() {
	createGUIElements();
}

void createGUIElements() {
	// 设置登录对话框,并设置位置及大小、模态等
	setTitle("登录系统");
	setBounds(500, 250,500, 250);
	setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
	setLayout(null);
	setModal(true);
	// 创建用户名与密码标签
	usernamelbl = new JLabel("用户名:");
	usernamelbl.setBounds(100, 50, 50, 20);
	this.add(usernamelbl);
	passwordlbl = new JLabel("密  码:");
	passwordlbl.setBounds(100, 82, 50, 20);
	this.add(passwordlbl);

	// 创建用户名与密码输入组件,并赋处值
	username = new JTextField();
	username.setEditable(true);
	username.setHorizontalAlignment(SwingConstants.LEFT);
	username.setColumns(20);
	username.setBounds(175, 50, 105, 20);
	this.add(username);
	password = new JPasswordField("123456");
	password.setBounds(175, 82, 105, 20);
	password.setEchoChar('*');
	this.add(password);

	// 创建登录与退出按钮,并添加事件
	loginBtn = new JButton("登录");
	loginBtn.setBounds(130, 130, 60, 20);
	add(loginBtn);
	loginBtn.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			login();
		} // 方法结束
	});
	cancelBtn = new JButton("退出");
	cancelBtn.setBounds(230, 130, 60, 20);
	add(cancelBtn);
	cancelBtn.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			logout();
		}
	});
}

void login() // 处理登录按钮事件
{
	String accout = username.getText().toString();
	String pwd = new String(password.getPassword());

	// 如果用户名与密码正确,则隐藏登录对话框,显示主窗体
	if ( accout!=null && pwd.equals("123456")) {
		setVisible(false);// 只隐藏存在潜在问题，可用dispose()彻底销毁
		JOptionPane.showMessageDialog(this, "用户名是" + accout + ",密码是" + pwd);
		showMianWindow();// 显示主窗体
	} else {
		//System.out.println("用户名不能为空，请重新输入!");
		//JOptionPane.showMessageDialog(this, "用户名不能为空，请重新输入！" );
		JOptionPane.showMessageDialog(this, "用户名是" + accout + ",密码是" + pwd);
	}
}

void logout(){// 处理取消按钮事件
	int ret = JOptionPane.showConfirmDialog(this, "选择是，取消登录。", "取消登录",
			JOptionPane.YES_NO_OPTION);
	if (ret == JOptionPane.YES_OPTION) 
		dispose();
}

void showMianWindow() {// 显示主窗体
	MainWindow frm = new MainWindow();
	frm.setVisible(true);
}
// class LoginDialog 


}
