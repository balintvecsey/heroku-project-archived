package com.greenfox.controller;

import com.greenfox.model.Todo;
import com.greenfox.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Bálint on 2017. 05. 09..
 */
@Controller
@RequestMapping("/todo")
public class TodoController {

  private TodoRepository repository;

  @Autowired
  public TodoController(TodoRepository repository) {
    this.repository = repository;
  }

  @GetMapping(value = {"/list", "/"})
  public String list(@RequestParam(value = "isActive", required = false) boolean isActive, Model model) {
    if (isActive) {
      model.addAttribute("todos", repository.findAllByIsDoneFalse());
    } else {
      model.addAttribute("todos", repository.findAll());
    }
    return "todo";
  }

  @GetMapping("/add")
  public String addTodo() {
    return "add";
  }

  @GetMapping("/hit")
  public String hit(String title) {
    repository.save(new Todo(title));
    return "redirect:/todo/";
  }

  @GetMapping("/{id}/delete")
  public String delete(@PathVariable Long id) {
    repository.delete(id);
    return "redirect:/todo/";
  }

  @GetMapping("/{id}/edit")
  public String edit(@PathVariable Long id, Model model) {
    model.addAttribute("todo", repository.findOne(id));
    return "edit";
  }

  @PostMapping("/update")
  public String update(Model model, @RequestParam long id, String title, boolean isDone, boolean isUrgent) {
    model.addAttribute("todo", repository.findOne(id));
    Todo todo = repository.findOne(id);
    todo.setTitle(title);
    todo.setDone(isDone);
    todo.setUrgent(isUrgent);
    repository.save(todo);
    return "redirect:/todo/";
  }
}
