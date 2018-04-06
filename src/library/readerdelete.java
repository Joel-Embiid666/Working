package library;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;
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
