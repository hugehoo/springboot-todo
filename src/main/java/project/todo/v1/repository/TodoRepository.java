package project.todo.v1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.todo.v1.domain.Todo;

public interface TodoRepository extends JpaRepository<Todo, Long> {


}
