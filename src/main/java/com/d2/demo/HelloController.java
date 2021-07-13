package com.d2.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
public class HelloController {

  @Autowired
  AlbumRepository albumRepository;

//  @Autowired
//  SongRepository songRepository;
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

    albumRepository.save(album1);
    albumRepository.save(album2);
    albumRepository.save(album3);
//    Album albums1 = (Album) albumRepository.findAll();
    Album[] albums = new Album[]{album1, album2, album3,};
    model.addAttribute("albums", albumRepository.findAll());
    System.out.println(  "all repos >>>>>>>><<<<<<<<<  "+albumRepository.findAll());
    System.out.println();
//    return  albumRepository;

    return  "albums";
  }
  @PostMapping("/albums")
  ResponseEntity<Album> newStudent( String title,  String artist,
                                    String songCount,  String length ,  String imageUrl) {
    Album album = new Album( title, artist, imageUrl, length , songCount);
    albumRepository.save(album);
    return new ResponseEntity<>(album, HttpStatus.CREATED);
  }

//  @PostMapping("/songs")
//  public RedirectView addSongToAlbum(@RequestParam String title,@RequestParam String length,
//                                     @RequestParam String trackNumber ,@RequestParam String album) {
//    List<Album> albumWithThatTitle = albumRepository.find(album);
//    Song song;
//
//    if(albumWithThatTitle.size() > 0) {
//      try{
//        song = new Song(title,length,trackNumber, albumWithThatTitle.get(0));
//      }catch(NumberFormatException e){
//        e.printStackTrace();
//        return new RedirectView("/songs");
//      }
//      songRepository.save(song);
//    }
//
//    return new RedirectView("/songs");
//  }


//  @PostMapping("/albums")
//  public RedirectView addAlbum( String title,  String artist,
//                                String imageUrl,  String length ,  String songCount) {
//    Album album;
//    System.out.println("the title is :  "+title);
//      album = new Album(title,artist,songCount,length,imageUrl);
//
//    System.out.println("the artist is :  "+artist);
//
//    albumRepository.save(album);
//      return new RedirectView("/albums");
//
//  }





}




