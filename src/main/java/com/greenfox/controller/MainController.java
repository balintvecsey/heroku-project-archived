package com.greenfox.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Bálint on 2017. 05. 16..
 */
@Controller
public class MainController {

  @RequestMapping("/")
  public String main(){
    return "index";
  }
}
