package library;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
public class book_add extends JFrame implements ActionListener {
	/**
	 * 添加图书
	 */
	private static final long serialVersionUID = 1L;
	DataBaseManager db=new DataBaseManager();
	ResultSet rs;
	JPanel panel1,panel2;
	JLabel book_id_label,book_name_label,author_label,
	press_label,press_date_label,price_label,book_num_label,borrowed_num_label,address;
	JTextField book_id_TextField,book_name_TextField,author_TextField,
	press_TextField,press_date_TextField,price_TextField,book_num_TextField,
	borrowed_count;
	JComboBox<String> addresst;
	Container c;
	JButton clear,add,exit;
	public book_add()
	{
		super("添加图书信息");
		c=getContentPane();
		c.setLayout(new BorderLayout());
		book_id_label=new JLabel("编号",JLabel.CENTER);
		book_name_label=new JLabel("名称",JLabel.CENTER);
		author_label=new JLabel("作者",JLabel.CENTER);
		press_label=new JLabel("出版社",JLabel.CENTER);
		press_date_label=new JLabel("出版日期",JLabel.CENTER);
		price_label=new JLabel("价格",JLabel.CENTER);
		book_num_label=new JLabel("库存数",JLabel.CENTER);
		borrowed_num_label=new JLabel("已借阅数",JLabel.CENTER);
		address=new JLabel("藏书地址",JLabel.CENTER);
		 book_id_TextField=new JTextField(15);
		 book_name_TextField=new JTextField(15);
		 author_TextField=new JTextField(15);
		 press_TextField=new JTextField(15);
		 press_date_TextField=new JTextField(15);
		 price_TextField=new JTextField(15);
		 book_num_TextField=new JTextField(15);
		 borrowed_count=new JTextField(15);
		 borrowed_count.setText("0");
		 addresst=new JComboBox<String>();
		 addresst.addItem("扬子津图书馆");
		 addresst.addItem("荷花池图书馆");
		 addresst.addItem("瘦西湖图书馆");
		 addresst.addItem("淮海路图书馆");
		 panel1=new JPanel();
		 panel1.setLayout(new GridLayout(9,2));
		 panel1.add(book_id_label);
		 panel1.add(book_id_TextField);
		 panel1.add(book_name_label);
		 panel1.add(book_name_TextField);
		 panel1.add(press_label);
		 panel1.add(press_TextField);
		 panel1.add(author_label); 
		 panel1.add(author_TextField);
		 panel1.add(press_date_label);
		 panel1.add(press_date_TextField);
		 panel1.add(price_label);
		 panel1.add(price_TextField);
		 panel1.add(book_num_label);
		 panel1.add(book_num_TextField);
		 panel1.add(borrowed_num_label);
		 panel1.add(borrowed_count);
		 panel1.add(address);
		 panel1.add(addresst);
		 panel2=new JPanel();
		 panel2.setLayout(new GridLayout(1,3));
		 clear=new JButton("清空");
		 clear.addActionListener(this);
		 add=new JButton("添加");
		 add.addActionListener(this);
		 exit=new JButton("退出");
		 exit.addActionListener(this);
		 panel2.add(clear);
		 panel2.add(add);
		 panel2.add(exit);
		 c.add(panel1,BorderLayout.CENTER);
		 c.add(panel2,BorderLayout.SOUTH);
		 setVisible(true);
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==exit)
		{
			this.dispose();
		}
		else if(e.getSource()==clear)
		{
			book_id_TextField.setText("");
			book_name_TextField.setText("");
			author_TextField.setText("");
			press_TextField.setText("");
			press_date_TextField.setText("");
			price_TextField.setText("");
			book_num_TextField.setText("");
			
		}
		else if(e.getSource()==add)
		{
			if(book_id_TextField.getText().trim().equals(""))
			{
				JOptionPane.showMessageDialog(null, "书号不能为空");
			}
			else if(book_name_TextField.getText().trim().equals(""))
			{
				JOptionPane.showMessageDialog(null, "书名不能为空");
			}
			else if(author_TextField.getText().trim().equals(""))
			{
				JOptionPane.showMessageDialog(null, "作者不能为空");
			}
			else if(press_TextField.getText().trim().equals(""))
			{
				JOptionPane.showMessageDialog(null, "出版社不能为空");
			}
			else if(press_date_TextField.getText().trim().equals(""))
			{
				JOptionPane.showMessageDialog(null, "出版日期不能为空");
			}
			else if(price_TextField.getText().trim().equals(""))
			{
				JOptionPane.showMessageDialog(null, "价格不能为空");
			}
			else if(book_num_TextField.getText().trim().equals(""))
			{
				JOptionPane.showMessageDialog(null, "库存不能为空");
			}
			else if(borrowed_count.getText().trim().equals(""))
			{
				JOptionPane.showMessageDialog(null, "借阅数不能为空");
			}
			
			else {
				try{
					String strSQL="insert into book(book_id,book_name,press,author,press_date,price,book_count,borrowed_count,store_address)	values('"
									+book_id_TextField.getText().trim()
									+"','"
									+book_name_TextField.getText().trim()
									+"','"
									+press_TextField.getText().trim()
									+"','"
									+author_TextField.getText().trim()
									+"','"
									+press_date_TextField.getText().trim()
									+"','"
									+price_TextField.getText().trim()
									+"','"
									+book_num_TextField.getText().trim()
									+"','"
									+borrowed_count.getText().trim()
									+"','"
									+addresst.getSelectedItem()+"')";
									if(db.updateSql(strSQL))
									{
										this.dispose();
										JOptionPane.showMessageDialog(null,"添加图书成功");
									}
									else
									{
										JOptionPane.showMessageDialog(null,"添加图书失败");
										this.dispose();
									}
									db.closeConnection();
		
				}catch(Exception ex)
				{
					System.out.println(ex.toString());
				}
			}
		}
	}

}
