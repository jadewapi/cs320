package Appointment;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Calendar;
import java.util.Date;

public class AppointmentServiceTest {
    private AppointmentService service;
    private Date futureDate;
    
    @BeforeEach
    void setup() {
        service = new AppointmentService();
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, 2);
        futureDate = cal.getTime();
        service.addAppointment("A001", futureDate, "Checkup");
    }
    
    @Test
    void testAddAppointment() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, 5);
        Date anotherFutureDate = cal.getTime();
        
        service.addAppointment("A002", anotherFutureDate, "Consultation");
        assertNotNull(service.getAppointment("A002"));
    }
    
    @Test
    void testAddDuplicateAppointment() {
        assertThrows(IllegalArgumentException.class, () -> {
            service.addAppointment("A001", futureDate, "Another Checkup");
        });
    }
    
    @Test
    void testDeleteAppointment() {
        assertNotNull(service.getAppointment("A001"));
        service.deleteAppointment("A001");
        assertNull(service.getAppointment("A001"));
    }
    
    @Test
    void testDeleteNonExistentAppointment() {
        assertThrows(IllegalArgumentException.class, () -> {
            service.deleteAppointment("A999");
        });
    }
}