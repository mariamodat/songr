package com.d2.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
  @GetMapping("/hello")
  String hello() {
    return "HelloPage";
  }

  @GetMapping("/capitalize/{text}")
  public String capitalize(@PathVariable String text, Model model) {
    model.addAttribute("text", text.toUpperCase());
    return "capitalize";
  }


  @GetMapping("/")
  public String home() {
    return "homePage";
  }

  @ResponseBody
  @GetMapping("/albums")
  public String album(Model model) {
    Album album1 = new Album("I Told You I Like You", "Johnny Orlando, Mackenzie Ziegler", "59,436,114 ", "4 min 08 sec", "https://www.youtube.com/watch?v=ho0WBKPJtfc");
    Album album2 = new Album("Arcade ", "Duncan Laurence ", "48,397,097", "3 min 03 sec", "https://www.youtube.com/watch?v=IBy0bFYSMxo");
    Album album3 = new Album("Without Me", "Halsey ", "240,635,891", "3 min 23 sec", "https://www.youtube.com/watch?v=J6enOG547lk");
    Object[] albums = new Object[]{album1, album2, album3};
    model.addAttribute("albums", albums);
    return "albums";
  }


}




