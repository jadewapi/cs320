package Contact;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ContactServiceTest {
    private ContactService service;
    
    @BeforeEach
    void setup() {
        service = new ContactService();
        service.addContact("C001", "John", "Doe", "1234567890", "111 Park Ave");
    }
    
    @Test
    void testAddContact() {
        service.addContact("C002", "Jane", "Smith", "0987654321", "222 Park Ave");
        assertNotNull(service.getContact("C002"));
    }
    
    @Test
    void testAddContactWithDuplicateId() {
        assertThrows(IllegalArgumentException.class, () -> {
            service.addContact("C001", "Mike", "Roe", "1111111111", "333 Park Ave");
        });
    }
    
    @Test
    void testDeleteContact() {
        assertNotNull(service.getContact("C001"));
        service.deleteContact("C001");
        assertNull(service.getContact("C001"));
    }
    
    @Test
    void testDeleteNonExistentContact() {
        assertThrows(IllegalArgumentException.class, () -> {
            service.deleteContact("C999");
        });
    }
    
    @Test
    void testUpdateFirstName() {
        service.updateFirstName("C001", "Michael");
        assertEquals("Michael", service.getContact("C001").getFirstName());
    }
    
    @Test
    void testUpdateNonExistentContact() {
        assertThrows(IllegalArgumentException.class, () -> {
            service.updateLastName("C999", "Something");
        });
    }
    
    @Test
    void testUpdatePhone() {
        service.updatePhone("C001", "0000000000");
        assertEquals("0000000000", service.getContact("C001").getPhone());
    }
    
    @Test
    void testUpdateAddress() {
        service.updateAddress("C001", "999 Park Ave");
        assertEquals("999 Park Ave", service.getContact("C001").getAddress());
    }
}