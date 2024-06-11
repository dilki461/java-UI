import java.time.LocalDate;

public class ContactController{
	public static boolean addContact(Contact contact){
		ContactList contactList=DBConnection.getInstance().getContactList();
		contactList.add(contact);
		return true;
	}
	public static Contact[] getAllContact(){
		ContactList contactList=DBConnection.getInstance().getContactList();
		Contact[] tempContactArray=new Contact[contactList.getSize()];
		for (int i = 0; i < contactList.getSize(); i++){
			tempContactArray[i]=contactList.get(i);
		}
		return tempContactArray;
	}
	
	public static String generateId(){
		ContactList contactList=DBConnection.getInstance().getContactList();
		if(contactList.getSize()==0){
			return "C0001";
		}else{
			return String.format("C%04d",(contactList.getSize()+1));
		}
		
	}

	public static boolean isValidPhoneNumber(String phoneNumber){
		if(phoneNumber.length()==10 && phoneNumber.charAt(0)=='0'){
            for(int i=1; i<phoneNumber.length(); i++){
                if(!Character.isDigit(phoneNumber.charAt(i))){
                    return false;
                }
            }
            return true;
        }
        return false;
	}

 	public static boolean isValidBirthday(String birthday){
        String y=birthday.substring(0,4);
		int year=Integer.parseInt(y);
		String m=birthday.substring(5,7);
		int month=Integer.parseInt(m);
		String d=birthday.substring(8,10);
		int day=Integer.parseInt(d);
		LocalDate currentDate = LocalDate.now();
		int currentMonthValue = currentDate.getMonthValue();
		int currentYear=currentDate.getYear();    
		int currentMonthDate=currentDate.getDayOfMonth();
		
		if(birthday.length()!=10){
			return false;
		}
		if(year%4!=0 & month==2){
			if(day>28){
				return false;
			}else{
				return true;
			}
		}
		if(year%4==0 & month==2){
			if(day>29){
				return false;
			}else{
				return true;
			}
		}
		if(month==4 || month==6 || month==9 || month==11){
			if(day>30){
				return false;					
			}
		}
		if(month==1 || month==3 || month==5 || month==7 || month==8 || month==10 || month==12){
			if(day>31){
				return false;
			}	
		}
		if(month>12){
			return false;
		}
		if(year<currentYear){
			return true;
		}else if(year==currentYear){
			if(month<currentMonthValue){
				return true;
			}else if(month==currentMonthValue){
				if(day<=currentMonthDate){
					return true;
				}
			}
		}
		return false;
    }	
	public static boolean isValidSalary(double salary){
        return salary>0;
    }

    public static Contact searchContact(String selector){
		ContactList contactList=DBConnection.getInstance().getContactList();
		int index =contactList.searchByContacts(selector);
       if(index!=-1){
			return contactList.get(index);
		}
		return null;
	}

    public static boolean updateContact(Contact contact){
		ContactList contactList=DBConnection.getInstance().getContactList();
		int index=contactList.indexOf(contact);
		contactList.remove(index);
		contactList.add(index,contact);	
		return true;
	}

    
    public static boolean deleteContact(Contact contact){
		ContactList contactList=DBConnection.getInstance().getContactList();
		int index=contactList.indexOf(contact);
		contactList.remove(index);
		return true;
	}
	public static void viewByName(){
		ContactList contactList=DBConnection.getInstance().getContactList();
		contactList.sortingByName();
	}
	public static void viewBySalary(){
		ContactList contactList=DBConnection.getInstance().getContactList();
		contactList.sortingBySalary();
	}
	public static void viewByBirthday(){
		ContactList contactList=DBConnection.getInstance().getContactList();
		contactList.sortingByBirthday();
	}
}
