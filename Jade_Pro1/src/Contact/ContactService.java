package Contact;

import java.util.HashMap;
import java.util.Map;

public class ContactService {
    private final Map<String, Contact> contacts = new HashMap<>();
    
    public void addContact(String contactId, String firstName, String lastName, String phone, String address) {
        if (contacts.containsKey(contactId)) {
            throw new IllegalArgumentException("Contact with this ID already exists.");
        }
        Contact newContact = new Contact(contactId, firstName, lastName, phone, address);
        contacts.put(contactId, newContact);
    }
    
    public void deleteContact(String contactId) {
        if (!contacts.containsKey(contactId)) {
            throw new IllegalArgumentException("Contact not found.");
        }
        contacts.remove(contactId);
    }
    
    public void updateFirstName(String contactId, String newFirstName) {
        Contact contact = contacts.get(contactId);
        if (contact == null) {
            throw new IllegalArgumentException("Contact not found.");
        }
        contact.setFirstName(newFirstName);
    }
    
    public void updateLastName(String contactId, String newLastName) {
        Contact contact = contacts.get(contactId);
        if (contact == null) {
            throw new IllegalArgumentException("Contact not found.");
        }
        contact.setLastName(newLastName);
    }
    
    public void updatePhone(String contactId, String newPhone) {
        Contact contact = contacts.get(contactId);
        if (contact == null) {
            throw new IllegalArgumentException("Contact not found.");
        }
        contact.setPhone(newPhone);
    }
    
    public void updateAddress(String contactId, String newAddress) {
        Contact contact = contacts.get(contactId);
        if (contact == null) {
            throw new IllegalArgumentException("Contact not found.");
        }
        contact.setAddress(newAddress);
    }
    
    public Contact getContact(String contactId) {
        return contacts.get(contactId);
    }
}