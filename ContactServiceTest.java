import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContactServiceTest {

    private ContactService service;
    private Contact sampleContact;

    @BeforeEach
    void setUp() {
        service = new ContactService();
        sampleContact = new Contact("ID01", "John", "Doe", "1234567890", "123 Main St");
    }

    @Test
    void testAddContact_success() {
        service.addContact(sampleContact);
        assertNotNull(service.getContact("ID01"));
    }

    @Test
    void testAddContact_storesCorrectData() {
        service.addContact(sampleContact);
        Contact retrieved = service.getContact("ID01");
        assertEquals("John",        retrieved.getFirstName());
        assertEquals("Doe",         retrieved.getLastName());
        assertEquals("1234567890",  retrieved.getPhone());
        assertEquals("123 Main St", retrieved.getAddress());
    }

    @Test
    void testAddContact_duplicateId_throwsException() {
        service.addContact(sampleContact);
        Contact duplicate = new Contact("ID01", "Jane", "Smith", "0987654321", "456 Elm Ave");
        assertThrows(IllegalArgumentException.class, () -> service.addContact(duplicate));
    }

    @Test
    void testAddContact_nullContact_throwsException() {
        assertThrows(IllegalArgumentException.class, () -> service.addContact(null));
    }

    @Test
    void testAddMultipleContacts_success() {
        Contact c2 = new Contact("ID02", "Jane", "Smith", "0987654321", "456 Elm Ave");
        service.addContact(sampleContact);
        service.addContact(c2);
        assertNotNull(service.getContact("ID01"));
        assertNotNull(service.getContact("ID02"));
    }

    @Test
    void testDeleteContact_success() {
        service.addContact(sampleContact);
        service.deleteContact("ID01");
        assertNull(service.getContact("ID01"));
    }

    @Test
    void testDeleteContact_nonExistentId_throwsException() {
        assertThrows(IllegalArgumentException.class, () -> service.deleteContact("GHOST"));
    }

    @Test
    void testDeleteContact_doesNotAffectOtherContacts() {
        Contact c2 = new Contact("ID02", "Jane", "Smith", "0987654321", "456 Elm Ave");
        service.addContact(sampleContact);
        service.addContact(c2);
        service.deleteContact("ID01");
        assertNull(service.getContact("ID01"));
        assertNotNull(service.getContact("ID02"));
    }

    @Test
    void testUpdateFirstName_success() {
        service.addContact(sampleContact);
        service.updateFirstName("ID01", "Jane");
        assertEquals("Jane", service.getContact("ID01").getFirstName());
    }

    @Test
    void testUpdateFirstName_nonExistentId_throwsException() {
        assertThrows(IllegalArgumentException.class, () ->
            service.updateFirstName("GHOST", "Jane"));
    }

    @Test
    void testUpdateFirstName_null_throwsException() {
        service.addContact(sampleContact);
        assertThrows(IllegalArgumentException.class, () ->
            service.updateFirstName("ID01", null));
    }

    @Test
    void testUpdateFirstName_tooLong_throwsException() {
        service.addContact(sampleContact);
        assertThrows(IllegalArgumentException.class, () ->
            service.updateFirstName("ID01", "Johnathan12"));
    }

    @Test
    void testUpdateLastName_success() {
        service.addContact(sampleContact);
        service.updateLastName("ID01", "Smith");
        assertEquals("Smith", service.getContact("ID01").getLastName());
    }

    @Test
    void testUpdateLastName_nonExistentId_throwsException() {
        assertThrows(IllegalArgumentException.class, () ->
            service.updateLastName("GHOST", "Smith"));
    }

    @Test
    void testUpdateLastName_null_throwsException() {
        service.addContact(sampleContact);
        assertThrows(IllegalArgumentException.class, () ->
            service.updateLastName("ID01", null));
    }

    @Test
    void testUpdateLastName_tooLong_throwsException() {
        service.addContact(sampleContact);
        assertThrows(IllegalArgumentException.class, () ->
            service.updateLastName("ID01", "Smithsonian12"));
    }

    @Test
    void testUpdatePhone_success() {
        service.addContact(sampleContact);
        service.updatePhone("ID01", "5555555555");
        assertEquals("5555555555", service.getContact("ID01").getPhone());
    }

    @Test
    void testUpdatePhone_nonExistentId_throwsException() {
        assertThrows(IllegalArgumentException.class, () ->
            service.updatePhone("GHOST", "5555555555"));
    }

    @Test
    void testUpdatePhone_null_throwsException() {
        service.addContact(sampleContact);
        assertThrows(IllegalArgumentException.class, () ->
            service.updatePhone("ID01", null));
    }

    @Test
    void testUpdatePhone_invalidFormat_throwsException() {
        service.addContact(sampleContact);
        assertThrows(IllegalArgumentException.class, () ->
            service.updatePhone("ID01", "555-555-55"));
    }

    @Test
    void testUpdatePhone_withDashes_throwsException() {
        service.addContact(sampleContact);
        assertThrows(IllegalArgumentException.class, () ->
            service.updatePhone("ID01", "123-456-7890"));
    }

    @Test
    void testUpdatePhone_withSpaces_throwsException() {
        service.addContact(sampleContact);
        assertThrows(IllegalArgumentException.class, () ->
            service.updatePhone("ID01", "123 456 7890"));
    }

    @Test
    void testUpdateAddress_success() {
        service.addContact(sampleContact);
        service.updateAddress("ID01", "789 Oak Blvd");
        assertEquals("789 Oak Blvd", service.getContact("ID01").getAddress());
    }

    @Test
    void testUpdateAddress_nonExistentId_throwsException() {
        assertThrows(IllegalArgumentException.class, () ->
            service.updateAddress("GHOST", "789 Oak Blvd"));
    }

    @Test
    void testUpdateAddress_null_throwsException() {
        service.addContact(sampleContact);
        assertThrows(IllegalArgumentException.class, () ->
            service.updateAddress("ID01", null));
    }

    @Test
    void testUpdateAddress_tooLong_throwsException() {
        service.addContact(sampleContact);
        assertThrows(IllegalArgumentException.class, () ->
            service.updateAddress("ID01", "1234567890123456789012345678901"));
    }
}