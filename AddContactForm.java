import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class AddContactForm extends JFrame{
	private JLabel titleLabel;
	
	private JButton btnAdd;
	private JButton btnCancel;
	private JButton btnHomePage;
	
	
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
	

	AddContactForm(){
		setSize(500,400);
		setTitle("Add Contact Form");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		
		
//-Title 
		titleLabel=new JLabel("Add Contact Form");
		titleLabel.setHorizontalAlignment(JLabel.CENTER);
		titleLabel.setFont(new Font("",1,30));
		add("North",titleLabel);
//-button 
		JPanel buttonMainPanel=new JPanel(new GridLayout(2,1));
		JPanel buttonPanel=new JPanel(new FlowLayout(FlowLayout.RIGHT));
		btnAdd=new JButton("Add Contact");
		btnAdd.setFont(new Font("",1,12));
		btnAdd.addActionListener(new ActionListener(){
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
					boolean canAdd=true;
					if(!isValidPhoneNumber){
						canAdd=false;
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
						canAdd=false;
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
						canAdd=false;
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
					if(canAdd){
						boolean isAdded=ContactController.addContact(contact);
						if(isAdded){
							int reply = JOptionPane.showConfirmDialog(null, "Do you want to add another contact ?","Message",JOptionPane.YES_NO_OPTION);
							if (reply == JOptionPane.YES_OPTION){
								txtId.setText(ContactController.generateId());
								txtName.setText("");
								txtCompany.setText("");
								txtContactNumber.setText("");
								txtSalary.setText("");
								txtBirthday.setText("");
	
							}else if (reply == JOptionPane.NO_OPTION){
								AddContactForm.this.dispose();
							}
						
						}
					}
				}catch(NumberFormatException e){
					JOptionPane.showMessageDialog(null,"Feilds are empty! ");
				}
			}
		});
		
	
		buttonPanel.add(btnAdd);
		
		btnCancel=new JButton("Cancel");
		btnCancel.setFont(new Font("",1,12));
		btnCancel.addActionListener(new ActionListener(){
			
		 	public void actionPerformed(ActionEvent evt){
				txtId.setText(ContactController.generateId());
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
				AddContactForm.this.dispose();
			}
		});

		buttonPanel2.add(btnHomePage);

		buttonMainPanel.add(buttonPanel2);

		add("South",buttonMainPanel);

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
		
		add("West",labelPanel);
		
		JPanel textPanel=new JPanel(new GridLayout(6,1));

		txtId=new JTextField(4);
		txtId.setFont(new Font("",1,20));
		JPanel idTextPanel=new JPanel(new FlowLayout(FlowLayout.LEFT)); 
		txtId.setEditable(false);
		txtId.setText(ContactController.generateId());
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
		
		add("Center",textPanel);
		
	}
	
}
