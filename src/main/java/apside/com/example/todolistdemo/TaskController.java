package apside.com.example.todolistdemo;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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
        System.out.println(taskRepository.findByIsDoneTrue());
        return taskRepository.findByIsDoneTrue();
    }

//    TODO add, update
//    TODO bouton, routing


}
