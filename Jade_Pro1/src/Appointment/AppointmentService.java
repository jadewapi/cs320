package Appointment;

import java.util.HashMap;
import java.util.Map;

public class AppointmentService {
    private final Map<String, Appointment> appointments = new HashMap<>();
    
    public void addAppointment(String appointmentId, java.util.Date date, String description) {
        if (appointments.containsKey(appointmentId)) {
            throw new IllegalArgumentException("Appointment with this ID already exists.");
        }
        Appointment appointment = new Appointment(appointmentId, date, description);
        appointments.put(appointmentId, appointment);
    }
    
    public void deleteAppointment(String appointmentId) {
        if (!appointments.containsKey(appointmentId)) {
            throw new IllegalArgumentException("Appointment not found.");
        }
        appointments.remove(appointmentId);
    }
    
    public Appointment getAppointment(String appointmentId) {
        return appointments.get(appointmentId);
    }
}