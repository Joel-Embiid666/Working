package library;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;
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
