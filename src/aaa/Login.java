package aaa;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.*;

import javax.swing.*;

//import �γ����.MainWindow;

public class Login {public static void main(String[] args) {
	LoginDialog dlg = new LoginDialog();
	dlg.setVisible(true);
}
}

class MainWindow extends JFrame { // ��������
static JTextArea textarea;// ����¼��ɼ���ǩ
JTextField bname;
JTextField author;
JTextField press;
//JButton sex;
JTextField pdate;
//JTextField birth;
MainWindow() {
	setTitle("��̨�ݹ���ϵͳ");
	setBounds(400, 200, 540, 300);
	setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	setLayout(null);// ����Ϊ��ʹ�ò��ֹ�����
	JTextArea textarea1=new JTextArea();
	textarea1.setBounds(5, 5, 515, 40);
	textarea1.setEditable(false);
	textarea1.setText("\t��ӭʹ�ú�̨����ϵͳ");
	textarea1.setFont(new Font("����",Font.BOLD,23));
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

void exitSystem() // �����˳�ϵͳ�¼�
{
	int ret = JOptionPane.showConfirmDialog(this, "�˳�ϵͳ��", "�˳�ϵͳ��",
			JOptionPane.YES_NO_OPTION);
	if (ret == JOptionPane.YES_OPTION) {
		// dispose(); //�����˳���¼�Ի������޸ĵ�¼�Ի����е�login()������
		System.exit(0);
	}
}

void createMenu() {
	// �����˵�������ӵ����嶥��
	JMenuBar mbar = new JMenuBar();
	setJMenuBar(mbar);

	// ����2������ʽ�˵�,����ӵ��˵���
	JMenu m1 = new JMenu("ϵͳ����");
	JMenu m2 = new JMenu("�û�����");
	JMenu m3 = new JMenu("����Ա����");
	mbar.add(m1);
	mbar.add(m2);
	mbar.add(m3);

	// �����˵���,����ӵ���Ӧ�Ĳ˵���
	JMenuItem mi11 = new JMenuItem("�޸�����");
	JMenuItem mi12 = new JMenuItem("�˳�ϵͳ");
	mi11.setEnabled(false);
	m1.add(mi11);
	m1.add(mi12);
	// Ϊ�˳�ϵͳ�˵�������¼�
	mi12.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			exitSystem();
		}
	});

	JMenuItem mi21 = new JMenuItem("¼���û���Ϣ");
	JMenuItem mi22 = new JMenuItem("��ѯ�û���Ϣ");
	JMenuItem mi23 = new JMenuItem("����Ա");
	JMenuItem mi24 = new JMenuItem("����Աɾ��");
	m2.add(mi21);
	m2.add(mi22);
	m2.add(mi23);
	m2.add(mi24);
	// Ϊ�ɼ�¼��˵�������¼�
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
	JMenuItem mi31 = new JMenuItem("¼�����Ա��Ϣ");
	JMenuItem mi32 = new JMenuItem("ѡ���ɫ");
	JMenuItem mi33 = new JMenuItem("��Ӫ������");
	//JMenuItem mi34 = new JMenuItem("�黹�ڿ�");
	m3.add(mi31);
	m3.add(mi32);
	m3.add(mi33);
	//m3.add(mi34);
	// Ϊ�ɼ�¼��˵�������¼�
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
void buyqikan() {// ����
	buyqikanDialog isd = new buyqikanDialog();
	isd.setVisible(true);
}void inqikan() {// ����
	ruqikanDialog isd = new ruqikanDialog();
	isd.setVisible(true);
}void inputreader() {// ����
	inputreaderDialog isd = new inputreaderDialog();
	isd.setVisible(true);
}
void updateInfo() {// �޸ķ���
		updatexinxiDialog isd = new updatexinxiDialog();
		isd.setVisible(true);
	}
void queryInfo() {// ��ѯ����
		queryxinxiDialog isd = new queryxinxiDialog();
		isd.setVisible(true);
	}
void deleteInfo() {// ɾ������
deletexinxiDialog isd = new deletexinxiDialog();
isd.setVisible(true);
}
void inputInfo() {// ¼�뷽��
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
setTitle("¼�����Ա��Ϣ");
setBounds(500, 250, 600, 300);
setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
setLayout(null);
setModal(true);//ģ̬�Ի��� �����봦����¼����Ϣ���ſɴ��������ģ�
createGUIElements();
}

void createGUIElements() {
JLabel namelbl = new JLabel("����Ա:");
namelbl.setBounds(180, 50, 70, 25);
add(namelbl);
name = new JTextField();
name.setBounds(250, 50, 130, 25);
add(name);
JLabel numberlbl = new JLabel("���:");
numberlbl.setBounds(180, 20, 70, 25);
add(numberlbl);
number = new JTextField();
number.setBounds(250, 20, 130, 25);
add(number);
JLabel sexlbl=new JLabel("���룺");
sexlbl.setBounds(180, 80, 70, 25);
add(sexlbl);

// ������ѡ��ť�������
final ButtonGroup btnGroup = new ButtonGroup();

// ����2����ѡ��ť,������λ�ü���С,���е�һ����ѡ��
final JRadioButton manRadioButton = new JRadioButton("��");
manRadioButton.setBounds(250, 80, 80, 25);
manRadioButton.setSelected(true);
final JRadioButton womanRadioButton = new JRadioButton("Ů");
womanRadioButton.setBounds(350, 80, 80, 25);
btnGroup.add(manRadioButton);
btnGroup.add(womanRadioButton);
add(manRadioButton);
add(womanRadioButton);
JLabel phonelbl = new JLabel("��ϵ��ʽ:");
phonelbl.setBounds(180, 110, 100, 25);
add(phonelbl);
phone = new JTextField();
phone.setBounds(250, 110, 130, 25);
add(phone);

JButton submitBtn = new JButton("¼��");
submitBtn.setBounds(150, 215, 70, 25);
add(submitBtn);
JButton cancelBtn = new JButton("����");
cancelBtn.setBounds(340, 215, 70, 25);
add(cancelBtn);
// ����ύ�ɼ��¼�
submitBtn.addActionListener(new ActionListener() {
	@Override
	public void actionPerformed(ActionEvent arg0) {
		String str1;
		if(btnGroup.getSelection() == manRadioButton.getModel()){ 
		    str1 = manRadioButton.getText();
		}
		else
			str1 = womanRadioButton.getText();
		String str = "���:"+ number.getText()+";����:" + name.getText()+";�Ա�:"+str1+";��ϵ��ʽ:"
				+ phone.getText()+"\n\r";
		MainWindow.setTextarea(str);// ����������ľ�̬������ʾ,�˴��ɸ�Ϊ�������ݿ���
	}
});
cancelBtn.addActionListener(new ActionListener() {
	@Override
	public void actionPerformed(ActionEvent arg0) {
		dispose();// �����ɼ�¼��Ի��򣬷���������
	}
});
}
}
class buyqikanDialog extends JDialog {// �޸ĳɼ��Ի�����
JTextField bname;
JTextField author4;
JTextField press;
//JButton sex;
JTextField pdate;
JTextField info;

buyqikanDialog() {
	setTitle("�����ڿ�");
	setBounds(500, 250, 600, 300);
	setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
	setLayout(null);
	setModal(true);
	createGUIElements();
}

void createGUIElements() {
	JLabel bnamelbl = new JLabel("����Ҫ�������ڿ���:");
	bnamelbl.setBounds(113, 20, 150, 25);
	add(bnamelbl);
	bname= new JTextField();
	bname.setBounds(260, 20, 130, 25);
	add(bname);
	JLabel infolbl=new JLabel("��Ϣ��");
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
	JButton querybtn=new JButton("����");
	querybtn.setBounds(400,20,70,25);
	add(querybtn);
	querybtn.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent arg0) {
	if(MainWindow.textarea.getText().indexOf(bname.getText())!=-1){
		//int index=MainWindow.textarea.getText().indexOf(bname.getText());
		//String a=MainWindow.textarea.getText().substring(index-3, MainWindow.textarea.getText().indexOf("\n\r",index));
		//info.setText(a);
		info.setText("�����ɹ���");
	}	
	else
		info.setText("����ʧ�ܣ�");
		}
	});
   addWindowListener(new WindowAdapter() {
	public void windowClosing(WindowEvent e) {
		dispose();// �����ɼ�¼��Ի��򣬷���������
	}
});		
}
}
class ruqikanDialog extends JDialog {// �޸ĳɼ��Ի�����
	JTextField bname;
	JTextField author4;
	JTextField press;
	//JButton sex;
	JTextField pdate;
	JTextField info;

	ruqikanDialog() {
		setTitle("�ڿ����");
		setBounds(500, 250, 600, 300);
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		setLayout(null);
		setModal(true);
		createGUIElements();
	}

	void createGUIElements() {
		JLabel bnamelbl = new JLabel("����Ҫ�����ڿ���:");
		bnamelbl.setBounds(113, 20, 150, 25);
		add(bnamelbl);
		bname= new JTextField();
		bname.setBounds(260, 20, 130, 25);
		add(bname);
		JLabel infolbl=new JLabel("��Ϣ��");
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
		JButton querybtn=new JButton("���");
		querybtn.setBounds(400,20,70,25);
		add(querybtn);
		querybtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
		if(MainWindow.textarea.getText().indexOf(bname.getText())!=-1){
			//int index=MainWindow.textarea.getText().indexOf(bname.getText());
			//String a=MainWindow.textarea.getText().substring(index-3, MainWindow.textarea.getText().indexOf("\n\r",index));
			//info.setText(a);
			info.setText("���ɹ���");
		}	
		else
			info.setText("���ʧ�ܣ�");
			}
		});
	   addWindowListener(new WindowAdapter() {
		public void windowClosing(WindowEvent e) {
			dispose();// �����ɼ�¼��Ի��򣬷���������
		}
	});		
	}	
}
class InputxinxiDialog extends JDialog {// ¼��ɼ��Ի�����
JTextField bname;
JTextField author;
JTextField press;
//JButton sex;
JTextField pdate;
//JTextField birth;

InputxinxiDialog() {
	setTitle("¼���ڿ���Ϣ");
	setBounds(500, 250, 600, 300);
	setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
	setLayout(null);
	setModal(true);
	createGUIElements();
}
void createGUIElements() {
	JLabel bnamelbl = new JLabel("�ڿ���:");
	bnamelbl.setBounds(180, 50, 70, 25);
	add(bnamelbl);
	bname = new JTextField();
	bname.setBounds(250, 50, 130, 25);
	add(bname);
	JLabel authorlbl = new JLabel("����:");
	authorlbl.setBounds(180, 20, 70, 25);
	add(authorlbl);
	author = new JTextField();
	author.setBounds(250, 20, 130, 25);
	add(author);
    JLabel presslbl = new JLabel("������:");
	presslbl.setBounds(180, 110, 100, 25);
	add(presslbl);
	press = new JTextField();
	press.setBounds(250, 110, 130, 25);
	add(press);
    JLabel pdatelbl = new JLabel("��������:");
	pdatelbl.setBounds(180, 140, 70, 25);
	add(pdatelbl);
	pdate = new JTextField();
	pdate.setBounds(250, 140, 130, 25);
	add(pdate);

	JButton submitBtn = new JButton("¼��");
	submitBtn.setBounds(150, 215, 70, 25);
	add(submitBtn);
	JButton cancelBtn = new JButton("����");
	cancelBtn.setBounds(340, 215, 70, 25);
	add(cancelBtn);
	// ����ύ�ɼ��¼�
	submitBtn.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			//String str1;
			//if(btnGroup.getSelection() == manRadioButton.getModel()){ 
			    //str1 = manRadioButton.getText();
			//}
			//else
				//str1 = womanRadioButton.getText();
			String str = "����Ա:"+ author.getText()+";�û���:" + bname.getText()+";��Ӫ������:"
	                     + press.getText()+";����ʱ��:"+pdate.getText()+"\n\r";
			MainWindow.setTextarea(str);// ����������ľ�̬������ʾ,�˴��ɸ�Ϊ�������ݿ���
		}
	});
	cancelBtn.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			dispose();// �����ɼ�¼��Ի��򣬷���������
		}
	});
	//addWindowListener(new WindowAdapter() {  //���x���ڹر�
		//public void windowClosing(WindowEvent e) {
			//dispose();
		//}
	//});
}
}
class queryxinxiDialog extends JDialog {// ��ѯ�ɼ��Ի�����
	JTextField bname1;
	JTextField info;
	queryxinxiDialog() {
		setTitle("��ѯ��Ϣ");
		setBounds(500, 250, 600, 300);
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		setLayout(null);
		setModal(true);
		
		createGUIElements();
	}

	void createGUIElements() {
		JLabel bnamelbl = new JLabel("�ڿ���:");
		JLabel infolbl=new JLabel("��Ϣ��");
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
		JButton querybtn=new JButton("��ѯ");
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
			info.setText("��ѯʧ�ܣ�");
			}
		});
	   addWindowListener(new WindowAdapter() {
		public void windowClosing(WindowEvent e) {
			dispose();// �����ɼ�¼��Ի��򣬷���������
		}
	});		
	}	
		}
	class updatexinxiDialog extends JDialog {// �޸ĳɼ��Ի�����
		JTextField bname;
		JTextField author4;
		JTextField press;
		//JButton sex;
		JTextField pdate;
		JTextField info;

		updatexinxiDialog() {
			setTitle("������Ϣ");
			setBounds(500, 250, 600, 300);
			setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
			setLayout(null);
			setModal(true);
			createGUIElements();
		}

		void createGUIElements() {
			JLabel bnamelbl = new JLabel("����Ҫ������Ϣ���ڿ���:");
			bnamelbl.setBounds(113, 20, 150, 25);
			add(bnamelbl);
			bname= new JTextField();
			bname.setBounds(260, 20, 130, 25);
			add(bname);
			
			JLabel infolbl=new JLabel("��Ϣ��");
			//bnamelbl.setBounds(180, 50, 70, 25);
			infolbl.setBounds(90, 160, 70, 25);
			infolbl.setEnabled(false);
			add(bnamelbl);
			add(infolbl);
			info=new JTextField();
			info.setBounds(135, 160, 420, 25);
			add(info);
			JButton querybtn=new JButton("����");
			querybtn.setBounds(400,20,70,25);
			add(querybtn);
			querybtn.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
			if(MainWindow.textarea.getText().indexOf(bname.getText())!=-1){
				//int index=MainWindow.textarea.getText().indexOf(bname.getText());
				//String a=MainWindow.textarea.getText().substring(index-3, MainWindow.textarea.getText().indexOf("\n\r",index));
				//info.setText(a);
				info.setText("���ĳɹ���");
			}	
			else
				info.setText("����ʧ�ܣ�");
				}
			});
		   addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dispose();// �����ɼ�¼��Ի��򣬷���������
			}
		});		
		}	
			
	}
	class deletexinxiDialog extends JDialog {// �޸ĳɼ��Ի�����
		JTextField bname;
		JTextField author4;
		JTextField press;
		//JButton sex;
		JTextField pdate;
		JTextField info;

		deletexinxiDialog() {
			setTitle("�黹��Ϣ");
			setBounds(500, 250, 600, 300);
			setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
			setLayout(null);
			setModal(true);
			createGUIElements();
		}

		void createGUIElements() {
			JLabel bnamelbl = new JLabel("����Ҫ�黹��Ϣ���ڿ���:");
			bnamelbl.setBounds(113, 20, 150, 25);
			add(bnamelbl);
			bname= new JTextField();
			bname.setBounds(260, 20, 130, 25);
			add(bname);
			
			JLabel infolbl=new JLabel("��Ϣ��");
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
			JButton querybtn=new JButton("�黹");
			querybtn.setBounds(400,20,70,25);
			add(querybtn);
			querybtn.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
			if(MainWindow.textarea.getText().indexOf(bname.getText())!=-1){
				//int index=MainWindow.textarea.getText().indexOf(bname.getText());
				//String a=MainWindow.textarea.getText().substring(index-3, MainWindow.textarea.getText().indexOf("\n\r",index));
				//info.setText(a);
				info.setText("�黹�ɹ���");
			}	
			else
				info.setText("�黹ʧ�ܣ�");
				}
			});
		   addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dispose();// �����ɼ�¼��Ի��򣬷���������
			}
		});		
		}	

	}

class LoginDialog extends JDialog {// ��¼�Ի�����
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
	// ���õ�¼�Ի���,������λ�ü���С��ģ̬��
	setTitle("��¼ϵͳ");
	setBounds(500, 250,500, 250);
	setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
	setLayout(null);
	setModal(true);
	// �����û����������ǩ
	usernamelbl = new JLabel("�û���:");
	usernamelbl.setBounds(100, 50, 50, 20);
	this.add(usernamelbl);
	passwordlbl = new JLabel("��  ��:");
	passwordlbl.setBounds(100, 82, 50, 20);
	this.add(passwordlbl);

	// �����û����������������,������ֵ
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

	// ������¼���˳���ť,������¼�
	loginBtn = new JButton("��¼");
	loginBtn.setBounds(130, 130, 60, 20);
	add(loginBtn);
	loginBtn.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			login();
		} // ��������
	});
	cancelBtn = new JButton("�˳�");
	cancelBtn.setBounds(230, 130, 60, 20);
	add(cancelBtn);
	cancelBtn.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			logout();
		}
	});
}

void login() // �����¼��ť�¼�
{
	String accout = username.getText().toString();
	String pwd = new String(password.getPassword());

	// ����û�����������ȷ,�����ص�¼�Ի���,��ʾ������
	if ( accout!=null && pwd.equals("123456")) {
		setVisible(false);// ֻ���ش���Ǳ�����⣬����dispose()��������
		JOptionPane.showMessageDialog(this, "�û�����" + accout + ",������" + pwd);
		showMianWindow();// ��ʾ������
	} else {
		//System.out.println("�û�������Ϊ�գ�����������!");
		//JOptionPane.showMessageDialog(this, "�û�������Ϊ�գ����������룡" );
		JOptionPane.showMessageDialog(this, "�û�����" + accout + ",������" + pwd);
	}
}

void logout(){// ����ȡ����ť�¼�
	int ret = JOptionPane.showConfirmDialog(this, "ѡ���ǣ�ȡ����¼��", "ȡ����¼",
			JOptionPane.YES_NO_OPTION);
	if (ret == JOptionPane.YES_OPTION) 
		dispose();
}

void showMianWindow() {// ��ʾ������
	MainWindow frm = new MainWindow();
	frm.setVisible(true);
}
// class LoginDialog 


}
