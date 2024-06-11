import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class UpdateContactForm extends JFrame{
	private JLabel titleLabel;
	
	private JButton btnUpdate;
	private JButton btnCancel;
	private JButton btnHomePage;
	private JButton btnSearch;
	
	
	private JLabel lblId;
	private JLabel lblName;
	private JLabel lblContactNumber;
	private JLabel lblCompany;
	private JLabel lblSalary;
	private JLabel lblBirthday;
	
	private JTextField txtId;
	private JTextField txtName;
	private JTextField txtContactNumber;
	private JTextField txtCompany;
	private JTextField txtSalary;
	private JTextField txtBirthday;
	
	private JTextField txtSearch;
	

	UpdateContactForm(){
		setSize(500,400);
		setTitle("Update Contact Form");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
//-Title 
		titleLabel=new JLabel("Update Contact");
		titleLabel.setHorizontalAlignment(JLabel.CENTER);
		titleLabel.setFont(new Font("",1,30));
		
//-button Panel
		JPanel buttonMainPanel=new JPanel(new GridLayout(2,1));
		JPanel buttonPanel=new JPanel(new FlowLayout(FlowLayout.RIGHT));
		

//--Search Panel
		JPanel searchPanel=new JPanel(new FlowLayout(FlowLayout.CENTER));

		txtSearch =new JTextField(20);
		txtSearch.setFont(new Font("",1,15));
		searchPanel.add(txtSearch);

		btnSearch =new JButton("Search");
		btnSearch.setFont(new Font("",1,15));
		btnSearch.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				String selector=txtSearch.getText();
				Contact contact =ContactController.searchContact(selector);	
				if(selector.equals("")){
					JOptionPane.showMessageDialog(null, "Invalid Search..");
				}else if(contact!=null){
					txtId.setText(contact.getId());	
					txtName.setText(contact.getName());	
					txtContactNumber.setText(contact.getPhoneNumber());	
					txtCompany.setText(contact.getCompanyName());	
					txtSalary.setText(""+contact.getSalary());	
					txtBirthday.setText(contact.getBirthday());
				}else{
					int option= JOptionPane.showConfirmDialog(null,"Contact not Found...Do you need search again? "," ",JOptionPane.YES_NO_OPTION);
					if(option==JOptionPane.YES_OPTION){
						txtSearch.setText("");
						txtSearch.requestFocus();
					}
				}	
			}
		});
		searchPanel.add(btnSearch);
//--label Panel
		JPanel labelPanel=new JPanel(new GridLayout(6,1));
		
		lblId=new JLabel("Id");
		lblId.setFont(new Font("",1,20));
		labelPanel.add(lblId);
	
		lblName=new JLabel("Name");
		lblName.setFont(new Font("",1,20));
		labelPanel.add(lblName);
		
		lblContactNumber=new JLabel("Contact Number");
		lblContactNumber.setFont(new Font("",1,20));
		labelPanel.add(lblContactNumber);

		lblCompany=new JLabel("Company");
		lblCompany.setFont(new Font("",1,20));
		labelPanel.add(lblCompany);
			
		lblSalary=new JLabel("Salary");
		lblSalary.setFont(new Font("",1,20));
		labelPanel.add(lblSalary);

		lblBirthday=new JLabel("Birthday");
		lblBirthday.setFont(new Font("",1,20));
		labelPanel.add(lblBirthday);
		
		JPanel northMainPanel=new JPanel(new GridLayout(2,1));
		northMainPanel.add(titleLabel);
		northMainPanel.add(searchPanel);

		add("North",northMainPanel);
		add("West",labelPanel);

		add("West",labelPanel);
		
		JPanel textPanel=new JPanel(new GridLayout(6,1));

		txtId=new JTextField(4);
		txtId.setFont(new Font("",1,20));
		JPanel idTextPanel=new JPanel(new FlowLayout(FlowLayout.LEFT)); 
		idTextPanel.add(txtId);
		textPanel.add(idTextPanel);
		
		txtName=new JTextField(18);
		txtName.setFont(new Font("",1,20));
		JPanel nameTextPanel=new JPanel(new FlowLayout(FlowLayout.LEFT)); 
		nameTextPanel.add(txtName);
		textPanel.add(nameTextPanel);
		
		txtContactNumber=new JTextField(12);
		txtContactNumber.setFont(new Font("",1,20));
		JPanel contactNumberTextPanel=new JPanel(new FlowLayout(FlowLayout.LEFT)); 
		contactNumberTextPanel.add(txtContactNumber);
		textPanel.add(contactNumberTextPanel);

		txtCompany=new JTextField(18);
		txtCompany.setFont(new Font("",1,20));
		JPanel companyPanel=new JPanel(new FlowLayout(FlowLayout.LEFT)); 
		companyPanel.add(txtCompany);
		textPanel.add(companyPanel);
		
		txtSalary=new JTextField(6);
		txtSalary.setFont(new Font("",1,20));
		JPanel salaryTextPanel=new JPanel(new FlowLayout(FlowLayout.LEFT)); 
		salaryTextPanel.add(txtSalary);
		textPanel.add(salaryTextPanel);

		txtBirthday=new JTextField(15);
		txtBirthday.setFont(new Font("",1,20));
		JPanel birthdatePanel=new JPanel(new FlowLayout(FlowLayout.LEFT)); 
		birthdatePanel.add(txtBirthday);
		textPanel.add(birthdatePanel);

//button
		btnUpdate=new JButton("Update");
		btnUpdate.setFont(new Font("",1,12));
		btnUpdate.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				try{
					String id=txtId.getText();
					String name=txtName.getText();
					String contactNumber=txtContactNumber.getText();
					String company=txtCompany.getText();
					double salary=Double.parseDouble(txtSalary.getText());
					String bday=txtBirthday.getText();

					Contact contact=new Contact(id,name,contactNumber,company,salary,bday);
					boolean isValidPhoneNumber=ContactController.isValidPhoneNumber(contactNumber);
					boolean isValidSalary=ContactController.isValidSalary(salary);
					boolean isValidBirthday=ContactController.isValidBirthday(bday);
					boolean canUpdate=true;

					if(!isValidPhoneNumber){
						canUpdate=false;
						int option=JOptionPane.showConfirmDialog(null, "Invalid Phone number!Do you want to enter again?","Message",JOptionPane.YES_NO_OPTION);
						if(option==JOptionPane.YES_OPTION){
							txtContactNumber.setText("");
							txtContactNumber.requestFocus();
						}else if(option==JOptionPane.NO_OPTION){
							txtId.setText(ContactController.generateId());
							txtName.setText("");
							txtCompany.setText("");
							txtContactNumber.setText("");
							txtSalary.setText("");
							txtBirthday.setText("");
						}
					}
					if(!isValidSalary){
						canUpdate=false;
						int option=JOptionPane.showConfirmDialog(null, "Invalid Salary! Do you want to enter again?","Message",JOptionPane.YES_NO_OPTION);
						if(option==JOptionPane.YES_OPTION){
							txtSalary.setText("");
							txtSalary.requestFocus();
						}else if(option==JOptionPane.NO_OPTION){
							txtId.setText(ContactController.generateId());
							txtName.setText("");
							txtCompany.setText("");
							txtContactNumber.setText("");
							txtSalary.setText("");
							txtBirthday.setText("");
						}
					}
					if(!isValidBirthday){
						canUpdate=false;
						int option=JOptionPane.showConfirmDialog(null, "Invalid Birthday! Do you want to enter again?","Message",JOptionPane.YES_NO_OPTION);
						if(option==JOptionPane.YES_OPTION){
							txtBirthday.setText("");
							txtBirthday.requestFocus();
						}else if(option==JOptionPane.NO_OPTION){
							txtId.setText(ContactController.generateId());
							txtName.setText("");
							txtCompany.setText("");
							txtContactNumber.setText("");
							txtSalary.setText("");
							txtBirthday.setText("");
						}
					}
					if(canUpdate){
						boolean isUpdated=ContactController.updateContact(contact);
						if(isUpdated){
							int reply = JOptionPane.showConfirmDialog(null, "Update Successfully! Do you want to Update another contact ?"," ",JOptionPane.YES_NO_OPTION);
							if (reply == JOptionPane.YES_OPTION){
								txtId.setText(ContactController.generateId());
								txtName.setText("");
								txtCompany.setText("");
								txtContactNumber.setText("");
								txtSalary.setText("");
								txtBirthday.setText("");
	
							}else if (reply == JOptionPane.NO_OPTION){
								UpdateContactForm.this.dispose();
							}
						
						}
					}else{
						JOptionPane.showMessageDialog(null, "Invalid Update!");
					}
					
				}catch(NumberFormatException e){
					JOptionPane.showMessageDialog(null,"Feilds are empty! ");
				}
				
			}
		});
		
		buttonPanel.add(btnUpdate);
		
		btnCancel=new JButton("Cancel");
		btnCancel.setFont(new Font("",1,12));
		btnCancel.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				txtSearch.setText("");
				txtId.setText("");
				txtName.setText("");
				txtContactNumber.setText("");
				txtCompany.setText("");
				txtSalary.setText("");
				txtBirthday.setText("");
			}
		});
		
		buttonPanel.add(btnCancel);
		buttonMainPanel.add(buttonPanel);

		JPanel buttonPanel2=new JPanel(new FlowLayout(FlowLayout.RIGHT));
		btnHomePage=new JButton("Back To Home Page");
		btnHomePage.setFont(new Font("",1,15));
		btnHomePage.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				UpdateContactForm.this.dispose();
			}
		});

		buttonPanel2.add(btnHomePage);

		buttonMainPanel.add(buttonPanel2);

		add("South",buttonMainPanel);
		
		add("Center",textPanel);
		
		
	}
	
}
