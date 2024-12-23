package Appointment;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.Date;
import java.util.Calendar;

public class AppointmentTest {
    
    @Test
    void testValidAppointment() {
        // Set date to a future date
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, 1);
        Date futureDate = cal.getTime();
        
        Appointment appt = new Appointment("A001", futureDate, "Dentist Appointment");
        assertEquals("A001", appt.getAppointmentId());
        assertEquals("Dentist Appointment", appt.getDescription());
        assertTrue(appt.getAppointmentDate().after(new Date()));
    }
    
    @Test
    void testInvalidAppointmentId() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, 1);
        Date futureDate = cal.getTime();
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment(null, futureDate, "Checkup");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("A12345678901", futureDate, "Checkup");
        });
    }
    
    @Test
    void testInvalidAppointmentDate() {
        Date pastDate = new Date(System.currentTimeMillis() - 86400000); // yesterday
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("A002", pastDate, "Past Appointment");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("A003", null, "Null Date");
        });
    }
    
    @Test
    void testInvalidDescription() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, 1);
        Date futureDate = cal.getTime();
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("A004", futureDate, null);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("A005", futureDate, "This description is way too long and should fail validation because it exceeds fifty characters in length.");
        });
    }
    
    @Test
    void testSetDescription() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, 1);
        Date futureDate = cal.getTime();
        Appointment appt = new Appointment("A006", futureDate, "Initial Desc");
        appt.setDescription("Updated Desc");
        assertEquals("Updated Desc", appt.getDescription());
    }
}