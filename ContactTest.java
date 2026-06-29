import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContactTest {

    @Test
    void testValidContactCreation() {
        Contact contact = new Contact("ID01", "John", "Doe", "1234567890", "123 Main St");
        assertEquals("ID01",        contact.getContactId());
        assertEquals("John",        contact.getFirstName());
        assertEquals("Doe",         contact.getLastName());
        assertEquals("1234567890",  contact.getPhone());
        assertEquals("123 Main St", contact.getAddress());
    }

    @Test
    void testContactIdNull_throwsException() {
        assertThrows(IllegalArgumentException.class, () ->
            new Contact(null, "John", "Doe", "1234567890", "123 Main St"));
    }

    @Test
    void testContactIdTooLong_throwsException() {
        assertThrows(IllegalArgumentException.class, () ->
            new Contact("12345678901", "John", "Doe", "1234567890", "123 Main St"));
    }

    @Test
    void testContactIdExactly10Chars_isValid() {
        assertDoesNotThrow(() ->
            new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St"));
    }

    @Test
    void testContactIdEmpty_throwsException() {
        assertThrows(IllegalArgumentException.class, () ->
            new Contact("", "John", "Doe", "1234567890", "123 Main St"));
    }

    @Test
    void testFirstNameNull_throwsException() {
        assertThrows(IllegalArgumentException.class, () ->
            new Contact("ID01", null, "Doe", "1234567890", "123 Main St"));
    }

    @Test
    void testFirstNameTooLong_throwsException() {
        assertThrows(IllegalArgumentException.class, () ->
            new Contact("ID01", "Johnathan12", "Doe", "1234567890", "123 Main St"));
    }

    @Test
    void testFirstNameExactly10Chars_isValid() {
        assertDoesNotThrow(() ->
            new Contact("ID01", "Johnathan1", "Doe", "1234567890", "123 Main St"));
    }

    @Test
    void testFirstNameEmpty_throwsException() {
        assertThrows(IllegalArgumentException.class, () ->
            new Contact("ID01", "", "Doe", "1234567890", "123 Main St"));
    }

    @Test
    void testSetFirstNameNull_throwsException() {
        Contact contact = new Contact("ID01", "John", "Doe", "1234567890", "123 Main St");
        assertThrows(IllegalArgumentException.class, () -> contact.setFirstName(null));
    }

    @Test
    void testSetFirstNameTooLong_throwsException() {
        Contact contact = new Contact("ID01", "John", "Doe", "1234567890", "123 Main St");
        assertThrows(IllegalArgumentException.class, () -> contact.setFirstName("Johnathan12"));
    }

    @Test
    void testLastNameNull_throwsException() {
        assertThrows(IllegalArgumentException.class, () ->
            new Contact("ID01", "John", null, "1234567890", "123 Main St"));
    }

    @Test
    void testLastNameTooLong_throwsException() {
        assertThrows(IllegalArgumentException.class, () ->
            new Contact("ID01", "John", "Doeeeeeeee12", "1234567890", "123 Main St"));
    }

    @Test
    void testLastNameExactly10Chars_isValid() {
        assertDoesNotThrow(() ->
            new Contact("ID01", "John", "Doe1234567", "1234567890", "123 Main St"));
    }

    @Test
    void testLastNameEmpty_throwsException() {
        assertThrows(IllegalArgumentException.class, () ->
            new Contact("ID01", "John", "", "1234567890", "123 Main St"));
    }

    @Test
    void testSetLastNameNull_throwsException() {
        Contact contact = new Contact("ID01", "John", "Doe", "1234567890", "123 Main St");
        assertThrows(IllegalArgumentException.class, () -> contact.setLastName(null));
    }

    @Test
    void testSetLastNameTooLong_throwsException() {
        Contact contact = new Contact("ID01", "John", "Doe", "1234567890", "123 Main St");
        assertThrows(IllegalArgumentException.class, () -> contact.setLastName("Doeeeeeeee12"));
    }

    @Test
    void testPhoneNull_throwsException() {
        assertThrows(IllegalArgumentException.class, () ->
            new Contact("ID01", "John", "Doe", null, "123 Main St"));
    }

    @Test
    void testPhoneTooShort_throwsException() {
        assertThrows(IllegalArgumentException.class, () ->
            new Contact("ID01", "John", "Doe", "123456789", "123 Main St"));
    }

    @Test
    void testPhoneTooLong_throwsException() {
        assertThrows(IllegalArgumentException.class, () ->
            new Contact("ID01", "John", "Doe", "12345678901", "123 Main St"));
    }

    @Test
    void testPhoneWithLetters_throwsException() {
        assertThrows(IllegalArgumentException.class, () ->
            new Contact("ID01", "John", "Doe", "123456789A", "123 Main St"));
    }

    @Test
    void testPhoneExactly10Digits_isValid() {
        assertDoesNotThrow(() ->
            new Contact("ID01", "John", "Doe", "1234567890", "123 Main St"));
    }

    @Test
    void testSetPhoneNull_throwsException() {
        Contact contact = new Contact("ID01", "John", "Doe", "1234567890", "123 Main St");
        assertThrows(IllegalArgumentException.class, () -> contact.setPhone(null));
    }

    @Test
    void testSetPhoneInvalid_throwsException() {
        Contact contact = new Contact("ID01", "John", "Doe", "1234567890", "123 Main St");
        assertThrows(IllegalArgumentException.class, () -> contact.setPhone("badphone"));
    }

    @Test
    void testAddressNull_throwsException() {
        assertThrows(IllegalArgumentException.class, () ->
            new Contact("ID01", "John", "Doe", "1234567890", null));
    }

    @Test
    void testAddressTooLong_throwsException() {
        assertThrows(IllegalArgumentException.class, () ->
            new Contact("ID01", "John", "Doe", "1234567890", "1234567890123456789012345678901"));
    }

    @Test
    void testAddressExactly30Chars_isValid() {
        assertDoesNotThrow(() ->
            new Contact("ID01", "John", "Doe", "1234567890", "123456789012345678901234567890"));
    }

    @Test
    void testSetAddressNull_throwsException() {
        Contact contact = new Contact("ID01", "John", "Doe", "1234567890", "123 Main St");
        assertThrows(IllegalArgumentException.class, () -> contact.setAddress(null));
    }

    @Test
    void testSetAddressTooLong_throwsException() {
        Contact contact = new Contact("ID01", "John", "Doe", "1234567890", "123 Main St");
        assertThrows(IllegalArgumentException.class, () ->
            contact.setAddress("1234567890123456789012345678901"));
    }
}