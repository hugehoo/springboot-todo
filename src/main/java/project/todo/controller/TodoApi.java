package project.todo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import project.todo.BaseController;
import project.todo.domain.Todo;
import project.todo.dto.TodoDto;
import project.todo.repository.TodoRepository;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("todo")
@RequiredArgsConstructor
public class TodoApi extends BaseController {

    private final TodoRepository repository;

    @GetMapping
    public String sample() {
        List<Todo> all = repository.findAll();
        for (Todo todo : all) {
            System.out.println(todo.getTodos());
        }
        return "string";
    }

    @PostMapping
    public void createTodos(@RequestBody TodoDto todoDto) {
        Todo todo = modelMapper.map(todoDto, Todo.class); // Entity 에 setter 가 없으면 매핑이 안된다.  -> 그럼 modelMapper 사용하려면 필연적으로 entity 의 setter 열어야하네 ?
        repository.save(todo);
    }
}
