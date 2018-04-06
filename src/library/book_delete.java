package library;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;
public class book_delete extends JFrame implements ActionListener {
	/**
	 * 删除图书
	 */
	private static final long serialVersionUID = 1L;
	DataBaseManager db=new DataBaseManager();
	ResultSet rs;
	Container c;
	JLabel TipLabel=new JLabel("请选择要删除的书名",JLabel.CENTER);
	JComboBox<String> bb=new JComboBox<String>();
	JButton yes,exit;
	JPanel panel1=new JPanel();
	public book_delete()
	{
		super("删除图书信息");
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
				String strSQL="select borrowed_count from book where book_name='"
						+bb.getSelectedItem()+"'";
				rs=db.getResult(strSQL);
				if(!rs.first())
				{
					JOptionPane.showMessageDialog(null,"书库里没有你要删除的书");
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
						JOptionPane.showMessageDialog(null,"此书还有学生没有还，不可删除");
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
