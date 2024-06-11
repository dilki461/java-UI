import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;

class ViewByBirthdayForm extends JFrame{
	private JTable tblCustomerDetails;
	private DefaultTableModel dtm;

	private JLabel titleLabel;

	private JButton btnHome; 
	private JButton btnReload;

	
	ViewByBirthdayForm(){
		setSize(500,400);
		setTitle("LIST CONTACTS BY Birthday");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		//-Title 
		titleLabel=new JLabel("LIST CONTACTS BY Birthday");
		titleLabel.setHorizontalAlignment(JLabel.CENTER);
		titleLabel.setFont(new Font("",1,30));
		add("North",titleLabel);

		//-button 

		btnReload=new JButton("Reload");
		btnReload.setFont(new Font("",1,20));
		btnReload.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				ContactController.viewByBirthday();
				ContactList contactList=DBConnection.getInstance().getContactList();
				dtm.setRowCount(0);
				for(int i=0; i<contactList.getSize(); i++){
					Contact contact=contactList.get(i);
					Object[] rowData={contact.getId(), contact.getName(),contact.getPhoneNumber(),contact.getCompanyName(),contact.getSalary(),contact.getBirthday()};
					dtm.addRow(rowData);
				}
			}
		});
		


		btnHome=new JButton("Back To Home");
		btnHome.setFont(new Font("",1,15));

		btnHome.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				ViewByBirthdayForm.this.dispose();
			}
		});

		JPanel buttonMainPanel=new JPanel(new GridLayout(1,1));
		JPanel btnPanel=new JPanel(new FlowLayout(FlowLayout.RIGHT));
		btnPanel.add(btnReload);
		btnPanel.add(btnHome);
		

		buttonMainPanel.add(btnPanel);

		add("South",buttonMainPanel);

		//-Table 

		String[] columnsName={"Customer Id","Name","Contact Number","Company","Salary","BirthDay"};
		dtm=new DefaultTableModel(columnsName,0);
		
		tblCustomerDetails=new JTable(dtm);
		
		JScrollPane tablePane=new JScrollPane(tblCustomerDetails);
		
		add("Center",tablePane);

		
	}
	
	
}
