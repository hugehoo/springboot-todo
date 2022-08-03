package project.todo.v1.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import project.todo.BaseController;
import project.todo.v1.domain.Todo;
import project.todo.v1.dto.TodoDto;
import project.todo.v1.repository.TodoRepository;
import project.todo.v1.service.TodoService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("todo")
@RequiredArgsConstructor
public class TodoApi extends BaseController {

    private final TodoService service;


    @GetMapping
    public List<TodoDto> sample() {
//        List<Todo> all = repository.findAll();
//        for (Todo todo : all) {
//            System.out.println(todo.getTodos());
//        }
//        return "string";
        List<Todo> todos = service.getTodos();
        List<TodoDto> dtoList = new ArrayList<>();
        for (Todo todo : todos) {
            TodoDto map = modelMapper.map(todo, TodoDto.class);
            dtoList.add(map);
        }
//        TodoDto map = modelMapper.map(todos, TodoDto.class);
        System.out.println(dtoList);
        return dtoList;
    }

    @PostMapping
    public void createTodos(@RequestBody TodoDto todoDto) {
        service.createTodo(todoDto);
//        Todo todo = modelMapper.map(todoDto, Todo.class); Entity 에 setter 가 없으면 매핑이 안된다.  -> 그럼 modelMapper 사용하려면 필연적으로 entity 의 setter 열어야하네 ?
//        repository.save(todo);
    }
}
