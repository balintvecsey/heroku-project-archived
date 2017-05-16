package com.greenfox.repository;

import com.greenfox.model.Todo;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Bálint on 2017. 05. 09..
 */
public interface TodoRepository extends CrudRepository<Todo, Long> {
  List<Todo> findAllByIsDoneFalse();
}
