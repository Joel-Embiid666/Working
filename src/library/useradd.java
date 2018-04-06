package library;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;
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


