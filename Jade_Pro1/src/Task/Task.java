package Task;
import java.util.Objects;

public class Task {
    private final String taskId;
    private String name;
    private String description;
    
    public Task(String taskId, String name, String description) {
        if (taskId == null || taskId.length() > 10) {
            throw new IllegalArgumentException("Task ID is invalid.");
        }
        this.taskId = taskId;
        
        if (name == null || name.length() > 20) {
            throw new IllegalArgumentException("Task name is invalid.");
        }
        this.name = name;
        
        if (description == null || description.length() > 50) {
            throw new IllegalArgumentException("Task description is invalid.");
        }
        this.description = description;
    }
    
    public String getTaskId() {
        return taskId;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        if (name == null || name.length() > 20) {
            throw new IllegalArgumentException("Task name is invalid.");
        }
        this.name = name;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        if (description == null || description.length() > 50) {
            throw new IllegalArgumentException("Task description is invalid.");
        }
        this.description = description;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Task)) return false;
        Task task = (Task) o;
        return Objects.equals(taskId, task.taskId);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(taskId);
    }
}