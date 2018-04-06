package library;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;
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
