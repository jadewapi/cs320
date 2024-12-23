package Task;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TaskServiceTest {
    private TaskService service;
    
    @BeforeEach
    void setup() {
        service = new TaskService();
        service.addTask("T001", "Test Feature", "Test the new feature thoroughly");
    }
    
    @Test
    void testAddTask() {
        service.addTask("T002", "Implement Feature", "Implement the payment integration");
        assertNotNull(service.getTask("T002"));
    }
    
    @Test
    void testAddDuplicateTaskId() {
        assertThrows(IllegalArgumentException.class, () -> {
            service.addTask("T001", "Another", "Duplicate ID test");
        });
    }
    
    @Test
    void testDeleteTask() {
        service.deleteTask("T001");
        assertNull(service.getTask("T001"));
    }
    
    @Test
    void testDeleteNonExistentTask() {
        assertThrows(IllegalArgumentException.class, () -> {
            service.deleteTask("T999");
        });
    }
    
    @Test
    void testUpdateName() {
        service.updateName("T001", "Updated Name");
        assertEquals("Updated Name", service.getTask("T001").getName());
    }
    
    @Test
    void testUpdateDescription() {
        service.updateDescription("T001", "Updated Desc");
        assertEquals("Updated Desc", service.getTask("T001").getDescription());
    }
    
    @Test
    void testUpdateNonExistentTask() {
        assertThrows(IllegalArgumentException.class, () -> {
            service.updateName("T999", "Will Fail");
        });
    }
}