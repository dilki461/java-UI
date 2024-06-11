import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

class HomePage extends JFrame{
    public static ArrayList <Contact>contactList=new ArrayList<>();
	
	private AddContactForm addContactForm;
	private ViewContactForm viewContactForm;
    private UpdateContactForm updateContactForm;
    private SearchContactForm searchContactForm;
    private DeleteContactForm deleteContactForm;
    
     
    private JLabel lblTitle1;
    private JLabel lblTitle2;
    private JLabel  lblTitle3;
    private JLabel lblimg;

	private JButton btnAddContact;	
	private JButton btnSearchContact;	
	private JButton btnDeleteContact;	
	private JButton btnUpdateContact;	
	private JButton btnViewContact;	
	private JButton btnExit;	

    HomePage(){
        setTitle("Home Page");
		setSize(700,500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
        setLayout(null);
        setResizable(false);
        
        JPanel leftPanel=new JPanel();
        leftPanel.setLayout(null);
        leftPanel.setBounds(0,0,300,500);
        leftPanel.setBackground(new Color(20,40,100));
        
        lblTitle1 =new JLabel("iFriend");
        lblTitle1.setFont(new Font("",1,50));
        lblTitle1.setBounds(50,110,300,40);
        lblTitle1.setForeground(new Color(80,80,100));
        leftPanel.add(lblTitle1);

        lblTitle2 =new JLabel("Contact Manager");
        lblTitle2.setFont(new Font("",1,20));
        lblTitle2.setBounds(50,140,300,40);
        lblTitle2.setForeground(new Color(80,80,100));
        leftPanel.add(lblTitle2);

        lblimg =new JLabel(new ImageIcon("/C:/Users/Admin/Desktop/hw/javahw/oop/course work/4/img.png"));
        lblimg.setBounds(0,200,300,400);
        leftPanel.add(lblimg);

        
        JPanel rightPanel=new JPanel();
        rightPanel.setLayout(null);
        rightPanel.setBounds(300,0,400,500);
        rightPanel.setBackground(new Color(80,80,100));

        lblTitle3 =new JLabel("Home Page");
        lblTitle3.setFont(new Font("",1,30));
        lblTitle3.setBounds(110,20,300,40);
        lblTitle3.setForeground(new Color(20,40,100));
        rightPanel.add(lblTitle3);

        btnAddContact=new JButton("Add Contact");
        btnAddContact.setFont(new Font("",1,20));
        btnAddContact.setForeground(new Color(20,40,100));
        btnAddContact.setBounds(90,140,200,30);

        
        btnAddContact.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				addContactForm=new AddContactForm();
                addContactForm.setVisible(true);
			}
		});

        btnSearchContact=new JButton("Search Contact");
        btnSearchContact.setFont(new Font("",1,20));
        btnSearchContact.setForeground(new Color(20,40,100));
        btnSearchContact.setBounds(90,190,200,30);

        btnSearchContact.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				searchContactForm=new SearchContactForm();
                searchContactForm.setVisible(true);
			}
		});
       
        btnDeleteContact=new JButton("Delete Contact");
        btnDeleteContact.setFont(new Font("",1,20));
        btnDeleteContact.setForeground(new Color(20,40,100));
        btnDeleteContact.setBounds(90,240,200,30);

        btnDeleteContact.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				deleteContactForm=new DeleteContactForm();
                deleteContactForm.setVisible(true);
			}
		});   

        btnUpdateContact=new JButton("Update Contact");
        btnUpdateContact.setFont(new Font("",1,20));
        btnUpdateContact.setForeground(new Color(20,40,100));
        btnUpdateContact.setBounds(90,290,200,30);

        btnUpdateContact.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				updateContactForm=new UpdateContactForm();
                updateContactForm.setVisible(true);
			}
		});

        btnViewContact=new JButton("View Contact");
        btnViewContact.setFont(new Font("",1,20));
        btnViewContact.setForeground(new Color(20,40,100));
        btnViewContact.setBounds(90,340,200,30);

        btnViewContact.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				viewContactForm=new ViewContactForm();
                viewContactForm.setVisible(true);
			}
		});

        btnExit=new JButton("Exit");
        btnExit.setFont(new Font("",1,20));
        btnExit.setForeground(new Color(20,40,100));
        btnExit.setBounds(140,390,100,30);

        btnExit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				System.exit(0);
			}
		});

        rightPanel.add(btnAddContact);
        rightPanel.add(btnSearchContact);
        rightPanel.add(btnDeleteContact);
        rightPanel.add(btnUpdateContact);
        rightPanel.add(btnViewContact);
        rightPanel.add(btnExit);
        
        add(leftPanel);
        add(rightPanel);
    }
}
