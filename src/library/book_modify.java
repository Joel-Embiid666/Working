package library;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
public class book_modify extends JFrame implements ActionListener{
	/**
	 * 修改图书信息
	 */
	private static final long serialVersionUID = 1L;
	DataBaseManager db=new DataBaseManager();
	ResultSet rs;
	JPanel panel1,panel2,panel3;
	JLabel TipLabel=new JLabel("输入书名点确定 ，将调出此书的相关信息");
	JLabel book_name_label,author_label,
	press_label,press_date_label,price_label;
	JTextField book_name_TextField,author_TextField,
	press_TextField,press_date_TextField,price_TextField;
	Container c;
	JButton clear,yes,update,exit;
	public book_modify()
	{
		super("修改图书信息");
		c=getContentPane();
		c.setLayout(new BorderLayout());
		panel3=new JPanel();
		panel3.add(TipLabel);
		c.add(panel3,BorderLayout.NORTH);
		book_name_label=new JLabel("名称",JLabel.CENTER);
		author_label=new JLabel("作者",JLabel.CENTER);
		press_label=new JLabel("出版社",JLabel.CENTER);
		press_date_label=new JLabel("出版日期",JLabel.CENTER);
		price_label=new JLabel("价格",JLabel.CENTER);
		 book_name_TextField=new JTextField(15);
		 author_TextField=new JTextField(15);
		 press_TextField=new JTextField(15);
		 press_date_TextField=new JTextField(15);
		 price_TextField=new JTextField(15);
		 panel1=new JPanel();
		 panel1.setLayout(new GridLayout(6,2));
		 panel1.add(book_name_label);
		 panel1.add(book_name_TextField);
		 panel1.add(author_label); 
		 panel1.add(author_TextField);
		 panel1.add(press_label);
		 panel1.add(press_TextField);
		 panel1.add(press_date_label);
		 panel1.add(press_date_TextField);
		 panel1.add(price_label);
		 panel1.add(price_TextField);
		 panel2=new JPanel();
		 panel2.setLayout(new GridLayout(1,4));
		 clear=new JButton("清空");
		 yes=new JButton("确定");
		 update=new JButton("更新");
		 exit=new JButton("退出");
		 panel2.add(clear);
		 panel2.add(yes);
		 panel2.add(update);
		 panel2.add(exit);
		 clear.addActionListener(this);
		 yes.addActionListener(this);
		 update.addActionListener(this);
		 exit.addActionListener(this);
		 update.setEnabled(false);
		 c.add(panel1,BorderLayout.CENTER);
		 c.add(panel2,BorderLayout.SOUTH);
		 setVisible(true);	 
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==exit)
		{
			this.dispose();;
		}
		else if(e.getSource()==clear)
		{
			book_name_TextField.setText("");
			author_TextField.setText("");
			press_TextField.setText("");
			press_date_TextField.setText("");
			price_TextField.setText("");
		}
		else if(e.getSource()==yes)
		{
			
			try{
				String strSQL="select * from book where book_name='"
						+book_name_TextField.getText().trim()+"'";
				rs=db.getResult(strSQL);
				while(rs.next()){
					book_name_TextField.setText(rs.getString("book_name"));
					author_TextField.setText(rs.getString("author"));
					press_TextField.setText(rs.getString("press"));
					press_date_TextField.setText(rs.getString("press_date"));
					price_TextField.setText(rs.getString("price"));
				}
				update.setEnabled(true);
			}catch(NullPointerException upe){
				System.out.println(upe.toString());
			}catch(Exception es){
				System.out.println(es.toString());
			}
		}
		else if(e.getSource()==update)
		{
			try{
				String strSQL="update book set book_name='"
						+book_name_TextField.getText().trim()+"',press='"
						+press_TextField.getText().trim()+"',author='"
						+author_TextField.getText().trim()+"',press_date='"
						+press_date_TextField.getText().trim()+"',price='"
						+price_TextField.getText().trim()+"' where book_name='"+book_name_TextField.getText().trim()+"'";
				
				if(db.updateSql(strSQL))
				{
					this.dispose();
					JOptionPane.showMessageDialog(null,"更新图书成功");
				}
				else {
					JOptionPane.showMessageDialog(null,"更新图书失败");
				}
				db.closeConnection();
			}catch(Exception sqle){
				System.out.println(sqle.toString());
			}
		}
	}

}
