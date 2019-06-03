package apside.com.example.todolistdemo;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class TaskController {

    public TaskController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    private final TaskRepository taskRepository;

    @GetMapping("/tasks")
    public List<Task> getTasks() {
//        System.out.println(taskRepository.findAll());
        return taskRepository.findAll();
    }

    @GetMapping("/done")
    public List<Task> getDoneTasks() {
//        System.out.println(taskRepository.findByDoneTrue());
        return taskRepository.findByDoneTrue();
    }

    @PostMapping("/add")
    public Task addTask(@RequestBody Task task, BindingResult result, Model model) {
        System.out.println("Spring addTask :" + task);
        taskRepository.save(task);
        return task;
    }

    @PostMapping("/update")
    public void updateTask(Task task, BindingResult result, Model model) {
        System.out.println("Spring updateTask :" + task);
        taskRepository.save(task);
        model.addAttribute("tasks", taskRepository.findAll());
    }

    @DeleteMapping("/delete")
    public void deleteTask(Task task) {
        taskRepository.delete(task);
    }

//    TODO add, update
//    TODO bouton, routing


}
