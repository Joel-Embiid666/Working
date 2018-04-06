package library;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
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
