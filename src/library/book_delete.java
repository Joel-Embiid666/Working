package library;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;
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
