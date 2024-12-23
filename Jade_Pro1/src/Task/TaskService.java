package Task;
import java.util.HashMap;
import java.util.Map;

public class TaskService {
    private final Map<String, Task> tasks = new HashMap<>();
    
    public void addTask(String taskId, String name, String description) {
        if (tasks.containsKey(taskId)) {
            throw new IllegalArgumentException("Task with this ID already exists.");
        }
        Task newTask = new Task(taskId, name, description);
        tasks.put(taskId, newTask);
    }
    
    public void deleteTask(String taskId) {
        if (!tasks.containsKey(taskId)) {
            throw new IllegalArgumentException("Task not found.");
        }
        tasks.remove(taskId);
    }
    
    public void updateName(String taskId, String newName) {
        Task task = tasks.get(taskId);
        if (task == null) {
            throw new IllegalArgumentException("Task not found.");
        }
        task.setName(newName);
    }
    
    public void updateDescription(String taskId, String newDescription) {
        Task task = tasks.get(taskId);
        if (task == null) {
            throw new IllegalArgumentException("Task not found.");
        }
        task.setDescription(newDescription);
    }
    
    public Task getTask(String taskId) {
        return tasks.get(taskId);
    }
}
