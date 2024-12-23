package Appointment;

import java.util.Date;
import java.util.Objects;

public class Appointment {
    private final String appointmentId;
    private final Date appointmentDate;
    private String description;
    
    public Appointment(String appointmentId, Date appointmentDate, String description) {
        if (appointmentId == null || appointmentId.length() > 10) {
            throw new IllegalArgumentException("Appointment ID is invalid.");
        }
        this.appointmentId = appointmentId;
        
        if (appointmentDate == null || appointmentDate.before(new Date())) {
            throw new IllegalArgumentException("Appointment date is invalid (null or in the past).");
        }
        this.appointmentDate = appointmentDate;
        
        if (description == null || description.length() > 50) {
            throw new IllegalArgumentException("Description is invalid.");
        }
        this.description = description;
    }
    
    public String getAppointmentId() {
        return appointmentId;
    }
    
    public Date getAppointmentDate() {
        return appointmentDate;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        if (description == null || description.length() > 50) {
            throw new IllegalArgumentException("Description is invalid.");
        }
        this.description = description;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Appointment)) return false;
        Appointment that = (Appointment) o;
        return Objects.equals(appointmentId, that.appointmentId);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(appointmentId);
    }
}