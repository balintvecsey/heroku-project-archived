package com.greenfox.model;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by Bálint on 2017. 05. 16..
 */
@Getter
@Setter
public class Greeting {
  private long id;
  private String content;

  public Greeting() {
    id = 1;
    content = "Hello, World!";
  }

  public Greeting(Long id, String name) {
    this.id = id;
    this.content = "Hello, " + name + "!";
  }
}
