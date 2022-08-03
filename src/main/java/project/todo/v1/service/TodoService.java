package project.todo.v1.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import project.todo.v1.domain.Todo;
import project.todo.v1.dto.TodoDto;
import project.todo.v1.repository.TodoRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoService {

    private final TodoRepository repository;

    public List<Todo> getTodos() {
        List<Todo> todos = repository.findAll();
        return todos;
    }

    public void createTodo(TodoDto todo) {
        Todo todoEntity = Todo.builder()
                .todos(todo.getTodos())
                .done(todo.isDone())
                .build();
        repository.save(todoEntity);
    }

}
