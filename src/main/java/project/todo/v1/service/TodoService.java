package project.todo.v1.service;


import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import project.todo.v1.domain.Todo;
import project.todo.v1.dto.TodoDto;
import project.todo.v1.repository.TodoRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoService {

    private final TodoRepository repository;
    private final ModelMapper modelMapper;

    public List<TodoDto> getTodos() {
        List<Todo> todos = repository.findAll();
        List<TodoDto> todoDto = new ArrayList<>();
        todos.forEach(todo -> todoDto.add(modelMapper.map(todo, TodoDto.class)));
        return todoDto;
    }

    public void createTodo(TodoDto todo) {
        Todo todoEntity = Todo.builder()
                .todos(todo.getTodos())
                .done(todo.isDone())
                .build();
        repository.save(todoEntity);
    }

}
