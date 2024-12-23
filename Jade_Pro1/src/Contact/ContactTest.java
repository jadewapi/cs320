package Contact;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ContactTest {
    
    @Test
    public void testValidContactCreation() {
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Main St");
        assertNotNull(contact);
        assertEquals("12345", contact.getContactId());
        assertEquals("John", contact.getFirstName());
        assertEquals("Doe", contact.getLastName());
        assertEquals("1234567890", contact.getPhone());
        assertEquals("123 Main St", contact.getAddress());
    }
    
    @Test
    public void testInvalidContactId() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(null, "John", "Doe", "1234567890", "123 Main St");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345678901", "John", "Doe", "1234567890", "123 Main St");
        });
    }
    
    @Test
    public void testInvalidFirstName() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("123", null, "Doe", "1234567890", "123 Main St");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("123", "JohnJohnJohn", "Doe", "1234567890", "123 Main St");
        });
    }
    
    @Test
    public void testInvalidLastName() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("123", "John", null, "1234567890", "123 Main St");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("123", "John", "DoeDoeDoeDoe", "1234567890", "123 Main St");
        });
    }
    
    @Test
    public void testInvalidPhone() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("123", "John", "Doe", null, "123 Main St");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("123", "John", "Doe", "12345", "123 Main St");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("123", "John", "Doe", "ABCDEFGHIJ", "123 Main St");
        });
    }
    
    @Test
    public void testInvalidAddress() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("123", "John", "Doe", "1234567890", null);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("123", "John", "Doe", "1234567890", "This address is way too long to be valid because it exceeds 30 chars");
        });
    }
    
    @Test
    public void testSetters() {
        Contact contact = new Contact("123", "John", "Doe", "1234567890", "123 Main St");
        contact.setFirstName("Jane");
        assertEquals("Jane", contact.getFirstName());
        
        contact.setLastName("Smith");
        assertEquals("Smith", contact.getLastName());
        
        contact.setPhone("0987654321");
        assertEquals("0987654321", contact.getPhone());
        
        contact.setAddress("456 Elm St");
        assertEquals("456 Elm St", contact.getAddress());
    }
}