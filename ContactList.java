public class ContactList{
	private Node start;
	
//////////////////////////////////
//  add(Contact contact)
//////////////////////////////////		
public void add(Contact contact){
	Node n1=new Node(contact);
	if(isEmpty()){
		start=n1;
	}else{
		Node tempNode =start;
		while(tempNode.next!=null){
			tempNode=tempNode.next;
		}
		tempNode.next=n1;
	}
}
///////////////////////////////////
//  add(int index,Contact contact)
//////////////////////////////////	
public void add(int index,Contact contact){
	Node n1=new Node(contact);
	if(isValidIndex(index)){
		if(index==0){
			n1.next=start;
			start=n1;
		}else{
			Node tempNode=start;
			for(int i=0;i<index-1;i++){
				tempNode=tempNode.next;
			}
			n1.next=tempNode.next;
			tempNode.next=n1;
		
		}
	}
}

/////////////////////////
//isEmpty
//////////////////////	
private boolean isEmpty(){
	return start==null;
}

/////////////////////////
//clear
//////////////////////	
public void clear(){
	start=null;
}


/////////////////////////
//getSize
//////////////////////	
public int getSize(){
	Node temp=start;
	int count=0;
	while(temp!=null){
		count++;
		temp=temp.next;
	}
	return count;
}
/////////////////////////
//isValidIndex
//////////////////////	
public boolean isValidIndex(int index){
	return index>=0&&index<=getSize();
}

	
//////////
//remove---delete
//////////

public  void remove(int index){
	if(isValidIndex(index)){
		if(index==0){
			start=start.next;
		}else{
			Node tempNode=start;
			for(int i=0;i<index-1;i++){
				tempNode=tempNode.next;
			}
			tempNode.next=tempNode.next.next;
		}
	}
}

//////////
// remove(Contact contact)
//////////

public void remove(Contact contact){
	remove(indexOf(contact));
}
//////////
// indexOf(Contact contact)
//////////
public int indexOf(Contact contact){
	Node temp=start;
	int index=-1;
	while(temp!=null){
		index++;
		if(temp.contact.equals(contact)){
			return index;
		}
		temp=temp.next;
	}
	return -1;
}

//////////
// contains(Contact contact)
//////////
public boolean contains(Contact contact){
	return indexOf(contact)!=-1;
}

/////////////////////////
//get
//////////////////////		
public Contact get(int index){
	if(isValidIndex(index)){
		if(index==0){
			return start.contact;
		}else{
			Node temp=start;
			for(int i=0; i<index; i++){
				temp=temp.next;
			}
			return temp.contact;
		}
	}
	return null;
}

////////////
//printList
////////////	
public void printList(){
	System.out.println(toString());
}

////////////
//toString
////////////	
public String toString(){
	String list="[";
	Node temp=start;
	while(temp!=null){
		list+=temp.contact+", "; //temp.contact.toString()
		temp=temp.next;
	}
	return isEmpty()? "[empty]":list+"\b\b]";
}


//////////////////////////////////
//search By Name Or Phone Number
/////////////////////////////////	
	public  int searchByContacts(String selector){
		Node tempNode =start;
        for(int i=0; i<getSize(); i++){
            if(tempNode.contact.getId().equals(selector) ||tempNode.contact.getName().equals(selector) || tempNode.contact.getPhoneNumber().equals(selector)){
                return i;
            }
            tempNode=tempNode.next;
        }
        return -1;
    }
///////////////
//  returnContactArray()
//////////////	
    public Contact[] returnContactArray(){
		Contact returnContactArray[]=new Contact[getSize()];
		Node tempNode =start;
		for(int i=0;i<getSize();i++){
			returnContactArray[i]=tempNode.contact;
			tempNode=tempNode.next;
		}
		return returnContactArray;
	}





///////////////
// sort sortingByName
//////////////	
	public  void sortingByName(){	
		Node temp=start, index=null;
        if(start==null){
            return;
        }else{
            while(temp!=null){
                index=temp.next;

                while(index!=null){
                    if(temp.contact.getName().compareTo(index.contact.getName())>0){
                        Contact tempContacts=temp.contact;
                        temp.contact=index.contact;
                        index.contact=tempContacts;
                    }
                    index=index.next;
                }
                temp=temp.next;
            }
        }
         
	}
///////////////
// sort sortingBySalary
//////////////		
	  public void sortingBySalary(){
        Node temp=start, index=null;
        if(start==null){
            return;
        }else{
            while(temp!=null){
                index=temp.next;

                while(index!=null){
                    if(temp.contact.getSalary()>index.contact.getSalary()){
                        Contact tempContacts=temp.contact;
                        temp.contact=index.contact;
                        index.contact=tempContacts;
                    }
                    index=index.next;
                }
                temp=temp.next;
            }
        }

        for(int i=0; i<getSize(); i++) {
            System.out.printf("| %-12s| %-12s| %-12s| %-12s| %-12.2f| %-12s|\n",get(i).getId(),get(i).getName(),get(i).getPhoneNumber(),get(i).getCompanyName(),get(i).getSalary(),get(i).getBirthday());
        }

    }

///////////////
// sort sortingByBirthday
//////////////		
	public  void sortingByBirthday(){
	Node temp=start, index=null;
        if(start==null){
            return;
        }else{
            while(temp!=null){
                index=temp.next;

                while(index!=null){
                    if(temp.contact.getBirthday().compareTo(index.contact.getBirthday())>0){
                        Contact tempContacts=temp.contact;
                        temp.contact=index.contact;
                        index.contact=tempContacts;
                    }
                    index=index.next;
                }
                temp=temp.next;
            }
		}
       
		for(int i=0; i<getSize(); i++) {
			System.out.printf("| %-12s| %-12s| %-12s| %-12s| %-12.2f| %-12s|\n",get(i).getId(),get(i).getName(),get(i).getPhoneNumber(),get(i).getCompanyName(),get(i).getSalary(),get(i).getBirthday());
		}
		
		
        
	}	
 	
	class Node{
		private Contact contact;
		private Node next;
		Node(Contact contact){
			this.contact=contact;
		}
	}
}
