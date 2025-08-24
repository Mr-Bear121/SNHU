package Module_Three_Milestone.Module_Three_Milestone;
/*
 * Name: Evan Nagy
 * Date: 07/14/2025
 * 
 * */

import java.util.concurrent.atomic.AtomicLong;

public class Contact {
	private final String contactID;
	private String firstName;
	private String lastName;
	private String pNumber;
	private String address;
	private AtomicLong uniqueID = new AtomicLong();
	
	public Contact(String firstName, String lastName,String pNumber, String address) {
		
		this.contactID = String.valueOf(uniqueID.getAndIncrement());
		
		
		if(firstName == null || firstName.isEmpty()) {
			this.firstName = "NULL";
			
		} else if(firstName.length() > 10) {
			this.firstName = firstName.substring(0,10);
			
		} else {
			this.firstName = firstName;
			
		}
		
		
		if(lastName == null || lastName.isEmpty()) {
			this.lastName = "NULL";
			
		} else if(lastName.length() > 10) {
			this.lastName = lastName.substring(0,10);
			
		} else {
			
			this.lastName = lastName;
		}
		
		if(pNumber == null || pNumber.isEmpty() || pNumber.length() != 10) {
			this.pNumber = "00";
		} else {
			
			this.pNumber = pNumber;
		}
		
		
		if(address == null || address.isEmpty()) {
			this.address = "NULL";
			
		} else if(address == null || address.isEmpty()) {
			this.address = "NULL";
			
		}else if(address.length() > 30) {
			this.address = address.substring(0,30);
			
		} else {
			this.address = address;
		}
	}
	
	//Getters
	public String getContactID() {
		return contactID;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getpNumber() {
		return pNumber;
	}

	public String getAddress() {
		return address;
	}

	// Setters
	/*
	 * The setters follow the same rules as the constructor.
	 */
	public void setFirstName(String firstName) {
		if (firstName == null || firstName.isEmpty()) {
			this.firstName = "NULL";

		// If first name is longer than 10 characters, just grab the first 10 characters
		} else if (firstName.length() > 10) {
			this.firstName = firstName.substring(0, 10);
			
		} else {
			this.firstName = firstName;
			
		}
	}
	
	public void setLastName(String lastName) {
		
		if(lastName == null || lastName.isEmpty()) {
			this.lastName = "NULL";
			
		} else if(lastName.length() > 10) {
			this.lastName = lastName.substring(0,10);
			
		}else {
			
			this.lastName = lastName;
		}
	}
	
	public void setpNumber(String pNumber) {
		
		if(pNumber == null || pNumber.isEmpty() || pNumber.length() != 10) {
			
			this.pNumber = "00";
			
		} else {
			
			this.pNumber = pNumber;
		}
	}
	
	public void setAddress(String address) {
		
		if(address == null || address.isEmpty()) {
			
			this.address = null;
			
		} else if(address.length() > 30){
			
			this.address = address.substring(0,30);
		
		} else {
			this.address = address;
		}
	}
	
}
