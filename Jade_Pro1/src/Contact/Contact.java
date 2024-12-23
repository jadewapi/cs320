package Contact;
import java.util.Objects;

public class Contact {
    private final String contactId;
    private String firstName;
    private String lastName;
    private String phone;
    private String address;
    
    public Contact(String contactId, String firstName, String lastName, String phone, String address) {
        // Validate Contact ID
        if (contactId == null || contactId.length() > 10) {
            throw new IllegalArgumentException("Contact ID is invalid.");
        }
        this.contactId = contactId;
        
        // Validate firstName
        if (firstName == null || firstName.length() > 10) {
            throw new IllegalArgumentException("First name is invalid.");
        }
        this.firstName = firstName;
        
        // Validate lastName
        if (lastName == null || lastName.length() > 10) {
            throw new IllegalArgumentException("Last name is invalid.");
        }
        this.lastName = lastName;
        
        // Validate phone
        if (phone == null || phone.length() != 10 || !phone.matches("\\d+")) {
            throw new IllegalArgumentException("Phone number is invalid.");
        }
        this.phone = phone;
        
        // Validate address
        if (address == null || address.length() > 30) {
            throw new IllegalArgumentException("Address is invalid.");
        }
        this.address = address;
    }
    
    public String getContactId() {
        return contactId;
    }
    
    public String getFirstName() {
        return firstName;
    }
    
    public void setFirstName(String firstName) {
        if (firstName == null || firstName.length() > 10) {
            throw new IllegalArgumentException("First name is invalid.");
        }
        this.firstName = firstName;
    }
    
    public String getLastName() {
        return lastName;
    }
    
    public void setLastName(String lastName) {
        if (lastName == null || lastName.length() > 10) {
            throw new IllegalArgumentException("Last name is invalid.");
        }
        this.lastName = lastName;
    }
    
    public String getPhone() {
        return phone;
    }
    
    public void setPhone(String phone) {
        if (phone == null || phone.length() != 10 || !phone.matches("\\d+")) {
            throw new IllegalArgumentException("Phone number is invalid.");
        }
        this.phone = phone;
    }
    
    public String getAddress() {
        return address;
    }
    
    public void setAddress(String address) {
        if (address == null || address.length() > 30) {
            throw new IllegalArgumentException("Address is invalid.");
        }
        this.address = address;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Contact)) return false;
        Contact contact = (Contact) o;
        return Objects.equals(contactId, contact.contactId);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(contactId);
    }
}