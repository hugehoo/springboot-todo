package project.todo.v1.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import project.todo.BaseController;
import project.todo.v1.dto.TodoDto;
import project.todo.v1.service.TodoService;

import java.util.List;

@RestController
@RequestMapping("todo")
@RequiredArgsConstructor
public class TodoApi extends BaseController {

    private final TodoService service;

    @GetMapping
    public List<TodoDto> getTodos() {
        return service.getTodos();
    }

    @PostMapping
    public void createTodos(@RequestBody TodoDto todoDto) {
        service.createTodo(todoDto);
    }
}
