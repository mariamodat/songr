package com.d2.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class HelloController {

  @Autowired
  AlbumRepository albumRepository;
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

//  @ResponseBody
  @GetMapping("/albums")
  public String album(Model model) {
    Album album1 = new Album("I Told You I Like You", "Johnny Orlando, Mackenzie Ziegler", "59,436,114 ", "4 min 08 sec", "https://images.genius.com/73c951f278662679356b9ea0631e2435.600x600x1.png");
    Album album2 = new Album("Arcade ", "Duncan Laurence ", "48,397,097", "3 min 03 sec", "https://i.ytimg.com/vi/L8IhgA3Du3Q/maxresdefault.jpg");
    Album album3 = new Album("Without Me", "Halsey ", "240,635,891", "3 min 23 sec", "https://swanstage.com/wp-content/uploads/2020/10/without-me-1.jpg");
    Object[] albums = new Object[]{album1, album2, album3};
    model.addAttribute("albums", albums);
    return "albums";
  }

  @PostMapping("/albums")
  public RedirectView addAlbum(@RequestParam String title, @RequestParam String artist,
                               @RequestParam String imageUrl, @RequestParam String length , @RequestParam String songCount) {
    Album album;

      album = new Album(title,artist,songCount,length,imageUrl);
      albumRepository.save(album);
      return new RedirectView("/albums");




  }



}




