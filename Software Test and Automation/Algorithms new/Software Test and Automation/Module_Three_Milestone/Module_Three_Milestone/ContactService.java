package Module_Three_Milestone.Module_Three_Milestone;

/*
 * Name: Evan Nagy
 * Date: 07/14/2025
 * 
 * */

import java.util.HashMap;
import java.util.Map;

public class ContactService {
	// my hashmap used to store my contacts
	private HashMap<String, Contact> contactList = new HashMap<String, Contact>();
	
	public void displayContactList() {
		// creates an entry so  we can receive an entry from the contact list and iterate over every entry.
		for (Map.Entry<String, Contact> entry : contactList.entrySet()){
			// display contacts in hashmap.
			System.out.println("\t Contact ID: " + entry.getKey());
			System.out.println("\t First Name: " + entry.getValue().getFirstName());
			System.out.println("\t Last Name: " + entry.getValue().getLastName());
			System.out.println("\t Phone Number: " + entry.getValue().getpNumber());
			System.out.println("\t Address: " + entry.getValue().getAddress() + "\n");
			
		}
	}
	// add a contact to the hashmap
	public String addContact(String firstName, String lastName, String pNumber, String address) {
		//create a new contact based on parameters
		Contact contact = new Contact(firstName, lastName, pNumber, address);
		//add contact
		contactList.put(contact.getContactID(),contact);
		return contact.getContactID();
	}
	// retrieve contact from hashmap
	public Contact getContact(String contactID) {
		//does the contactID exist in our contact list? true or false
		if(contactIDExists(contactID)) {
				//True: return the contact associated with this id
				return contactList.get(contactID);
			
			}
			// if there is no contactID within our contactList. Then return nothing.
			return null;
	}
	//remove contact from hashmap
	public String deleteContact(String contactID) {
			//does the contactID exist in our contact list? true or false
			if(contactIDExists(contactID)) {
				//True: remove contact
				contactList.remove(contactID);
				return contactID;
			
			}
			return null;
		
	}
	//update hashmap contact firstname field
	public void updateFirstName(String updateString, String contactID) {
		//does the contactID exist in our contact list? true or false
			if(contactIDExists(contactID)) {
				//True: update the contact associated with that ID
				contactList.get(contactID).setFirstName(updateString);
				
			}else{
				// if contactID not present, then inform user
				System.out.println("Contact ID: " + contactID + " not present.");
			}
			
		
	}
	// update lastname of contact from hashmap
	public void updateLastName(String updateString, String contactID) {
			//does the contactID exist in our contact list? true or false
			if(contactIDExists(contactID)) {
				// True: update the contact associated with that ID
				contactList.get(contactID).setLastName(updateString);
			}
			
	}
	// update phone number contact within
	public void updatePNumber(String updatedString, String contactID) {
		//does the contactID exist in our contact list? true or false
		if(contactIDExists(contactID)) {
				// True: update the contact associated with that ID
				contactList.get(contactID).setpNumber(updatedString);
			}
		
	}
	// update the address of contact within hashmap
	public void updateAddress(String updatedString, String contactID) {
		//does the contactID exist in our contact list? true or false
		if(contactIDExists(contactID)) {
				// True: update the contact associated with that ID
				contactList.get(contactID).setAddress(updatedString);
		}
	}
	
	// check if there is a valid ID in our contact list.
	private boolean contactIDExists(String contactID) {
		if(contactList.containsKey(contactID)) {
			// if there is a key then return true;
			return true;
			
		}else{
			// if contactID not present, then inform user
			System.out.println("Contact ID: " + contactID + " not present.");
		}
		// if there is no ID then return false;
		return false;
	}
}
