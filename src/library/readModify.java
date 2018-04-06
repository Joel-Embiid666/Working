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
public class readModify extends JFrame implements ActionListener{
	/**
	 * ������Ϣ�޸�
	 */
	private static final long serialVersionUID = 1L;
	DataBaseManager db=new DataBaseManager();
	ResultSet rs;
	JPanel panel1,panel2,panel3;
	JLabel TipLabel=new JLabel("����ѧ�ŵ�ȷ�� ���������˶��ߵ������Ϣ");
	JLabel id,name,zj,sex,age,tel,email,borrow;
	JTextField idt,namet,sext,aget,telt,emailt,borrowt;
	JComboBox<String> zjc;
	Container c;
	JButton clear,yes,update,exit;
	public readModify()
	{
		super("�޸Ķ�����Ϣ");
		c=getContentPane();
		c.setLayout(new BorderLayout());
		panel3=new JPanel();
		panel3.add(TipLabel);
		c.add(panel3,BorderLayout.NORTH);
		id=new JLabel("���߱��",JLabel.CENTER);
		name=new JLabel("��������",JLabel.CENTER);
		zj=new JLabel("֤������",JLabel.CENTER);
		sex=new JLabel("�Ա�",JLabel.CENTER);
		age=new JLabel("����",JLabel.CENTER);
		tel=new JLabel("�绰",JLabel.CENTER);
		email=new JLabel("����",JLabel.CENTER);
		borrow=new JLabel("�ѽ���Ŀ",JLabel.CENTER);
		idt=new JTextField(15);
		namet=new JTextField(15);
		sext=new JTextField(15);
        aget=new JTextField(15);
        telt=new JTextField(15);
        emailt=new JTextField(15);
        borrowt=new JTextField(15);
		zjc=new JComboBox<String>();
		zjc.addItem("ѧ��֤");
		zjc.addItem("���֤");
		zjc.addItem("��ʦ֤");
		panel1=new JPanel();
		panel1.setLayout(new GridLayout(8,2));
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
		c.add(panel1,BorderLayout.CENTER);
		 panel2=new JPanel();
		 panel2.setLayout(new GridLayout(1,4));
		 clear=new JButton("���");
		 yes=new JButton("ȷ��");
		 update=new JButton("����");
		 exit=new JButton("�˳�");
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
			idt.setText("");
			namet.setText("");
			sext.setText("");
			aget.setText("");
			telt.setText("");
			emailt.setText("");
			
		}
		else if(e.getSource()==yes)
		{
			
			try{
				String strSQL="select * from reader where student_id='"
						+idt.getText().trim()+"'";
				rs=db.getResult(strSQL);
				while(rs.next()){
					idt.setText(rs.getString("student_id"));
					namet.setText(rs.getString("student_name"));
					zjc.setSelectedItem(rs.getString("zj_name"));
					sext.setText(rs.getString("sex"));
					aget.setText(rs.getString("age"));
					telt.setText(rs.getString("tel"));
					emailt.setText(rs.getString("email"));
					borrowt.setText(rs.getString("borrow_count"));
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
				String strSQL="update reader set student_id='"
						+idt.getText().trim()+"',student_name='"
						+namet.getText().trim()+"',zj_name='"
						+zjc.getSelectedItem()+"',sex='"
						+sext.getText().trim()+"',age='"
						+aget.getText().trim()+"',tel='"
						+telt.getText().trim()+"',email='"
						+emailt.getText().trim()+"' where student_id='"+idt.getText().trim()+"'";
				
				if(db.updateSql(strSQL))
				{
					this.dispose();
					JOptionPane.showMessageDialog(null,"���¶��߳ɹ�");
				}
				else {
					JOptionPane.showMessageDialog(null,"���¶���ʧ��");
				}
				db.closeConnection();
			}catch(Exception sqle){
				System.out.println(sqle.toString());
			}
		}
	}

}
