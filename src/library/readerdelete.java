package library;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;
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
