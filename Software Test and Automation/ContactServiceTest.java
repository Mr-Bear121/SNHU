package Module_Three_Milestone.Module_Three_Milestone;


/*
 * Name: Evan Nagy
 * Date: 07/14/2025
 * 
 * */


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

//import Module_Three_Milestone.Contact;
//import Module_Three_Milestone.ContactService;

import org.junit.jupiter.api.Order;

@TestMethodOrder(OrderAnnotation.class)
public class ContactServiceTest {

	@Test
	@DisplayName("Test Update First Name.")
	@Order(1)
	void testUpdateFirstName() {
		
		ContactService testService = new ContactService();
		testService.addContact("Mr.","David", "0000000000" ,"123 Lora Lane");
		testService.updateFirstName("guard", "0");
		testService.displayContactList();
		assertEquals("guard", testService.getContact("0").getFirstName(), "First name was not updated.");
		
	}
	
	@Test
	@DisplayName("Test update Last Name")
	@Order(2)
	void testUpdateLastName() {
		
		ContactService service = new ContactService();
		service.addContact("Mr.","David", "0000000000" ,"123 Lora Lane");
		service.updateLastName("Smith", "0");
		assertEquals("Smith",service.getContact("0").getLastName(), "Phone number was not updated");
		
	}
	
	@Test
	@DisplayName("Test update Phone Number")
	@Order(3)
	void testUpdatePhoneNumber() {
		
		ContactService testService = new ContactService();
		testService.addContact("Mr.","David", "0000000000" ,"123 Lora Lane");
		testService.updatePNumber("9999999999", "0");
		assertEquals("9999999999",testService.getContact("0").getpNumber(),"Phone number was not updated.");
		
	}
	
	@Test
	@DisplayName("Test update address.")
	@Order(4)
	void testUpdateAddress() {
		
		ContactService service = new ContactService();
		service.addContact("Mr.","David", "0000000000" ,"123 Lora Lane");
		service.displayContactList();
		service.updateAddress("555 Somewhere Street", "0");
		service.displayContactList();
		assertEquals("555 Somewhere Street", service.getContact("0").getAddress(), "Address was not updated.");
		
	}

	
	@Test
	@DisplayName("Test ability to delete contacts")
	@Order(5)
	void testDeleteContact() {
		
		ContactService testService = new ContactService();
		testService.addContact("Mr.","David", "000" ,"123 Lora Lane");
		testService.deleteContact("0");
		// make sure that contact list is empty
		ArrayList<Contact> contactListEmpty = new ArrayList<Contact>();
		testService.displayContactList();
		assertEquals(testService.contactList, contactListEmpty, "The contact was not deleted.");
		
	}
	
	@Test
	@DisplayName("Test that our service can add a contact.")
	@Order(6)
	void testAddContact() {
		
		ContactService testService = new ContactService();
		testService.addContact("Mr.","David", "000" ,"123 Lora Lane");
		testService.displayContactList();
		assertNotNull(testService.getContact("0"),"Contact was not added correctly.");
		
	}
}
