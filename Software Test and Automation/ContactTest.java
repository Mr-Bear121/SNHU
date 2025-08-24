package Module_Three_Milestone.Module_Three_Milestone;


/*
 * Name: Evan Nagy
 * Date: 07/14/2025
 * 
 * */


import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;


public class ContactTest {

	@Test
	@DisplayName("Test for usernames with more than 10 chars")
	void testContactIDMoreThan10Chars() {
		
		Contact testContact = new Contact("olly", "oxen", "000", "000");
		if(testContact.getContactID().length() > 10) {
			fail("Contact ID has more than 10 characters");
			
		}
	}
	
	@Test
	@DisplayName("Contact First Name cannot have more than 10 characters")
	void testContactFirstNameMoreThanTenChars() {
		
		Contact testContact = new Contact("olly", "oxen", "000", "000");
		if(testContact.getFirstName().length() > 10) {
			fail("First Name has more than 10 characters");
			
		}
	}
	
	@Test
	@DisplayName("Contact Last Name cannot have more than 10 characters")
	void testContactLastNameMoreThanTenChars() {
		
		Contact testContact = new Contact("olly", "oxen", "000", "000");
		if(testContact.getLastName().length() > 10) {
			fail("First Name has more than 10 characters");
			
		}
	}
	
	@Test
	@DisplayName("Contact phone number is exactly 10 characters")
	void testContactNumberWithMoreThanTenCharacters() {
		
		Contact testContact = new Contact("olly", "oxen", "0000000000", "0000000000");
		if (testContact.getpNumber().length() != 10) {
			fail("Phone number length does not equal 10.");
			
		}
	}

	
	@Test
	@DisplayName("Contact Address Name cannot have more than 10 characters")
	void testContactAddressNameMoreThanTenChars() {
		
		Contact testContact = new Contact("olly", "LastName", "000",
				"123456789 is nine characters long" + "123456789 is another nine characters long");
		assertNotNull(testContact.getFirstName(),"First name was null.");
		
	}
	
	@Test
	@DisplayName("Contact Last Name cannot be null")
	void testContactFirstNameNotNull() {
		
		Contact testContact = new Contact(null, "oxen", "000", "000");
		assertNotNull(testContact.getFirstName(), "First name was null.");
		
	}
	
	@Test
	@DisplayName("Contact Last Name shall not be null")
	void testContactLastNameNotNull() {
		
		Contact testContact = new Contact("olly", null, "000", "000");
		assertNotNull(testContact.getLastName(), "Last name was null.");
		
	}
	
	@Test
	@DisplayName("Contact Last Name shall not be null")
	void testContactPhoneNotNull() {
		
		Contact testContact = new Contact("olly", "oxen", null, "0000000000");
		assertNotNull(testContact.getAddress(),"Address was null");
		
	}
}
