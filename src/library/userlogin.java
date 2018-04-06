package library;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
public class userlogin extends JFrame implements ActionListener{
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

}
