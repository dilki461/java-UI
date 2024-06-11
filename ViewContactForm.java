import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class ViewContactForm extends JFrame{

	private ViewByNameForm viewByNameForm;
	private ViewByBirthdayForm viewByBirthdayForm;
	private ViewBySalaryForm viewBySalaryForm;
	
	private JLabel titleLabel;

	private JButton btnListName; 
	private JButton btnListSalary; 
	private JButton btnListBirthday; 
	private JButton btnCancel; 

	
	ViewContactForm(){
		setSize(500,400);
		setTitle("CONTACT LIST");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		//-Title 
		titleLabel=new JLabel("Contacts List");
		titleLabel.setHorizontalAlignment(JLabel.CENTER);
		titleLabel.setFont(new Font("",1,30));
		add("North",titleLabel);

		//-button 

		JPanel buttonPanel=new JPanel(new FlowLayout(FlowLayout.RIGHT));

		btnCancel=new JButton("Cancel");
		btnCancel.setFont(new Font("",1,12));
		btnCancel.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				ViewContactForm.this.dispose();
			}
		});
			
		buttonPanel.add(btnCancel);
		add("South",buttonPanel);

		//-button 
		//JPanel centerMainbtnPanel=new JPanel(new FlowLayout(FlowLayout.RIGHT)); 
		JPanel centerbtnPanel=new JPanel(new GridLayout(3,1));

		btnListName=new JButton("List by Name");
		btnListName.setFont(new Font("",1,12));

		//----Name List Button Event-------
        btnListName.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				viewByNameForm=new ViewByNameForm();
				
				viewByNameForm.setVisible(true);
			}
		});

		JPanel nameBtnPanel=new JPanel(new FlowLayout(FlowLayout.CENTER));
        nameBtnPanel.add(btnListName);
		centerbtnPanel.add(nameBtnPanel);

		btnListSalary=new JButton("List by Salary");
		btnListSalary.setFont(new Font("",1,12));

		btnListSalary.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				viewBySalaryForm=new ViewBySalaryForm();
				
				viewBySalaryForm.setVisible(true);
			}
		});

		JPanel salaryBtnPanel=new JPanel(new FlowLayout(FlowLayout.CENTER));
        salaryBtnPanel.add(btnListSalary);
		centerbtnPanel.add(salaryBtnPanel);

		btnListBirthday=new JButton("List by Birthday");
		btnListBirthday.setFont(new Font("",1,12));

		btnListBirthday.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				viewByBirthdayForm=new ViewByBirthdayForm();
				
				viewByBirthdayForm.setVisible(true);
			}
		});

		JPanel birthdayBtnPanel=new JPanel(new FlowLayout(FlowLayout.CENTER));
        birthdayBtnPanel.add(btnListBirthday);
		centerbtnPanel.add(birthdayBtnPanel);

		//centerMainbtnPanel.add(centerbtnPanel);
		add("Center",centerbtnPanel);


		
	}
	
	
}
