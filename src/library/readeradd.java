package library;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;
public class readeradd extends JFrame implements ActionListener{
	/**
	 * ��Ӷ���
	 */
	private static final long serialVersionUID = 1L;
	DataBaseManager db=new DataBaseManager();
	ResultSet rs;
	Container c;
	JPanel panel1,panel2;
	JLabel id,name,zj,sex,age,tel,email,borrow,max_borrow,money;
	JTextField idt,namet,sext,aget,telt,emailt,borrowt,max_borrowt,moneyt;
	JComboBox<String> zjc;
	JButton add,cancel;
	public readeradd()
	{
		super("��Ӷ���");
		c=getContentPane();
		c.setLayout(new BorderLayout());
		id=new JLabel("���߱��",JLabel.CENTER);
		name=new JLabel("��������",JLabel.CENTER);
		zj=new JLabel("֤������",JLabel.CENTER);
		sex=new JLabel("�Ա�",JLabel.CENTER);
		age=new JLabel("����",JLabel.CENTER);
		tel=new JLabel("�绰",JLabel.CENTER);
		email=new JLabel("����",JLabel.CENTER);
		borrow=new JLabel("�ѽ���Ŀ",JLabel.CENTER);
		max_borrow=new JLabel("��������",JLabel.CENTER);
		money=new JLabel("Ѻ��",JLabel.CENTER);
		idt=new JTextField(15);
		namet=new JTextField(15);
		sext=new JTextField(15);
        aget=new JTextField(15);
        telt=new JTextField(15);
        emailt=new JTextField(15);
        borrowt=new JTextField(15);
        max_borrowt=new JTextField(15);
        max_borrowt.setText("7");
        moneyt=new JTextField(15);
		zjc=new JComboBox<String>();
		zjc.addItem("ѧ��֤");
		zjc.addItem("���֤");
		zjc.addItem("��ʦ֤");
		add=new JButton("���");
		cancel=new JButton("ȡ��");
		add.addActionListener(this);
		cancel.addActionListener(this);
		panel1=new JPanel();
		panel1.setLayout(new GridLayout(10,2));
		panel1.add(id);
		panel1.add(idt);
		panel1.add(name);
		panel1.add(namet);
		panel1.add(zj);
		panel1.add(zjc);
		panel1.add(sex);
		panel1.add(sext);
		panel1.add(age);
		panel1.add(aget);
		panel1.add(tel);
		panel1.add(telt);
		panel1.add(email);
		panel1.add(emailt);
		panel1.add(borrow);
		panel1.add(borrowt);
		panel1.add(max_borrow);
		panel1.add(max_borrowt);
		panel1.add(money);
		panel1.add(moneyt);
		c.add(panel1,BorderLayout.CENTER);
		panel2=new JPanel();
		panel2.add(add);
		panel2.add(cancel);
		c.add(panel2,BorderLayout.SOUTH);
		setSize(300,300);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==cancel)
		{
			db.closeConnection();
			this.dispose();
		}
		else if(e.getSource()==add)
		{
			if(idt.getText().trim().equals(""))
			{
				JOptionPane.showMessageDialog(null, "��Ų���Ϊ��");
			}
			else if(namet.getText().trim().equals(""))
			{
				JOptionPane.showMessageDialog(null, "��������Ϊ��");
			}
			else if(sext.getText().trim().equals(""))
			{
				JOptionPane.showMessageDialog(null, "�Ա���Ϊ��");
			}
			else if(aget.getText().trim().equals(""))
			{
				JOptionPane.showMessageDialog(null, "���䲻��Ϊ��");
			}
			else if(telt.getText().trim().equals(""))
			{
				JOptionPane.showMessageDialog(null, "�绰����Ϊ��");
			}
			else{
				try{
					String strSQL="insert into reader(student_id,student_name,zj_name,sex,age,tel,email,borrow_count,max_borrow,deposit)	values('"
									+idt.getText().trim()
									+"','"
									+namet.getText().trim()
									+"','"
									+zjc.getSelectedItem()
									+"','"
									+sext.getText().trim()
									+"','"
									+aget.getText().trim()
									+"','"
									+telt.getText().trim()
									+"','"
									+emailt.getText().trim()
									+"','"
									+borrowt.getText().trim()
									+"','"
									+max_borrowt.getText().trim()
									+"','"
									+moneyt.getText().trim()
									+"')";
									if(db.updateSql(strSQL))
									{
										this.dispose();
										JOptionPane.showMessageDialog(null,"��Ӷ��߳ɹ�");
									}
									else
									{
										JOptionPane.showMessageDialog(null,"��Ӷ���ʧ��");
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
