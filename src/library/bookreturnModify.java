package library;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
public class bookreturnModify extends JFrame implements ActionListener{
	/**
	 * 期刊归还状态修改
	 */
	private static final long serialVersionUID = 1L;
	DataBaseManager db=new DataBaseManager();
	ResultSet rs;
		JPanel panel1,panel2,panel3;
		Container c;
		JLabel tiplabel=new JLabel("输入还书者姓名和书名单击确定，将调出此书的相关信息");
		JLabel borrowlabel,namelabel,borrowdate;
		JTextField borrowField,nameField,dateField;
		JButton clear,yes,update,cancel;
		public bookreturnModify()
		{
			super("修改图书还入信息");
			c=getContentPane();
			c.setLayout(new BorderLayout());
			panel3=new JPanel();
			panel3.add(tiplabel);
			c.add(panel3,BorderLayout.NORTH);
			borrowlabel=new JLabel("还书者姓名",JLabel.CENTER);
			namelabel=new JLabel("书名",JLabel.CENTER);
			borrowdate=new JLabel("还书日期",JLabel.CENTER);
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
			clear=new JButton("清空");
			yes=new JButton("确定");
			update=new JButton("更新");
			cancel=new JButton("取消");
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
					String strSQL="select student_name,book_name,act_returned from borrow where student_name='"
							+borrowField.getText().trim()
							+"'and book_name='"
							+nameField.getText().trim()+"'";
					rs=db.getResult(strSQL);
					if(!rs.first())
					{
						JOptionPane.showMessageDialog(null,"此学生没有借过书");
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
				String strSQL="update borrow set return_date='"+dateField.getText().trim()+"' where student_name='"
						+borrowField.getText().trim()+"'and book_name='"
						+nameField.getText().trim()+"'";
				if(db.updateSql(strSQL))
				{
					JOptionPane.showMessageDialog(null,"更新成功");
					db.closeConnection();this.dispose();
				}
				else{
					JOptionPane.showMessageDialog(null,"更新失败");
					db.closeConnection();this.dispose();
				}
			}
		}

}
