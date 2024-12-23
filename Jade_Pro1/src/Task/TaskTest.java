package Task;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class TaskTest {
    
    @Test
    void testValidTaskCreation() {
        Task task = new Task("T001", "Fix Bug", "Fix the login bug on the main page");
        assertEquals("T001", task.getTaskId());
        assertEquals("Fix Bug", task.getName());
        assertEquals("Fix the login bug on the main page", task.getDescription());
    }
    
    @Test
    void testInvalidTaskId() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Task(null, "Name", "Description");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Task("T00123456789", "Name", "Description");
        });
    }
    
    @Test
    void testInvalidTaskName() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Task("T001", null, "Description");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Task("T001", "ThisNameIsWayTooLongForTwentyChars", "Desc");
        });
    }
    
    @Test
    void testInvalidTaskDescription() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Task("T001", "Name", null);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Task("T001", "Name", "This description is way too long and should cause an exception to be thrown by the constructor");
        });
    }
    
    @Test
    void testSetters() {
        Task task = new Task("T001", "Fix Bug", "Fix the login bug");
        task.setName("Improve UI");
        assertEquals("Improve UI", task.getName());
        
        task.setDescription("Update the home page layout");
        assertEquals("Update the home page layout", task.getDescription());
    }
}