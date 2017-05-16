package com.greenfox.controller;


import com.greenfox.model.Greeting;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Bálint on 2017. 05. 16..
 */
@RestController
public class HelloRESTController {
  AtomicLong counter = new AtomicLong();

  @RequestMapping("/greeting")
  public Greeting greetWorld(@RequestParam String name) {
    Greeting greeting = new Greeting(counter.incrementAndGet(), name);
    return greeting;
  }
}
