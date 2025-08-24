package Module_Three_Milestone.Module_Three_Milestone;

/*
 * Name: Evan Nagy
 * Date: 07/14/2025
 * 
 * */

import java.util.ArrayList;

public class ContactService {
	
	public ArrayList<Contact> contactList = new ArrayList<Contact>();
	
	public void displayContactList() {
		
		for (int counter = 0; counter < contactList.size(); counter++){
			System.out.println("\t Contact ID: " + contactList.get(counter).getContactID());
			System.out.println("\t First Name: " + contactList.get(counter).getFirstName());
			System.out.println("\t Last Name: " + contactList.get(counter).getLastName());
			System.out.println("\t Phone Number: " + contactList.get(counter).getpNumber());
			System.out.println("\t Address: " + contactList.get(counter).getAddress() + "\n");
			
		}
	}
	
	public void addContact(String firstName, String lastName, String pNumber, String address) {
		
		Contact contact = new Contact(firstName, lastName, pNumber, address);
		contactList.add(contact);
		
	}
	
	public Contact getContact(String contactID) {
		
		Contact contact = new Contact(null, null, null, null);
		for (int counter = 0; counter < contactList.size(); counter++) {
			
			if (contactList.get(counter).getContactID().contentEquals(contactID)) {
				contact = contactList.get(counter);
				
			}
		}
		return contact;
	}
	
	public void deleteContact(String contactID) {
		
		for(int count = 0; count < contactList.size(); count++) {
			
			if (contactList.get(count).getContactID().equals(contactID)){
				contactList.remove(count);
				break;
				
			}
			
			if(count == contactList.size() - 1) {
				System.out.println("Contact ID:" + contactID + " not present.");
				
			}
		}
	}
	public void updateFirstName(String updateString, String contactID) {
		
		for(int count = 0; count < contactList.size();count++) {
			
			if(contactList.get(count).getContactID().equals(contactID)) {
				
				contactList.get(count).setFirstName(updateString);
				break;
				
			}
			if(count == contactList.size() - 1) {
				
				System.out.println("Contact ID: " + contactID + " not present.");
				
			}
		}
	}
	public void updateLastName(String updateString, String contactID) {
		
		for(int count = 0; count < contactList.size();count++) {
			
			if(contactList.get(count).getContactID().equals(contactID)) {
				
				contactList.get(count).setLastName(updateString);
				break;
				
			}
			
			if(count == contactList.size() - 1) {
				
				System.out.println("Contact ID: " + contactID + " not present.");
			}
		}
	}
	public void updatePNumber(String updatedString, String contactID) {
		
		for(int count = 0; count < contactList.size();count++) {
			
			if(contactList.get(count).getContactID().equals(contactID)) {
				contactList.get(count).setpNumber(updatedString);
				break;
				
			}
			
			if(count == contactList.size() - 1) {
				System.out.println("Contact ID: " + contactID + " not present.");
			}
		}
		
	}
	public void updateAddress(String updatedString, String contactID) {
		
		
		for(int count = 0; count < contactList.size();count++) {
			
			if(contactList.get(count).getContactID().equals(contactID)) {
				contactList.get(count).setAddress(updatedString);
				break;
				
			}
			
			if(count == contactList.size() - 1) {
				System.out.println("Contact ID: " + contactID + " not present.");
				
			}
		}
	}
}
