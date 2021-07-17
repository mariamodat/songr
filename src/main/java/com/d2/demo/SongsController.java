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
public class SongsController {

  @Autowired
  AlbumRepository albumRepository;
  @Autowired
  SongRepository songRepository;

  @GetMapping("/songs")
  public String getAllSongs(Model model) {
    Iterable<Song> songs = songRepository.findAll();
    model.addAttribute("songs", songs);
    return "allSongs";
  }

  @GetMapping("/songs/add")
  public String addSongsForm() {
    return "addSongsToAlbum";
  }


  @GetMapping("/songs/{id}")
  public String getOneSong(@PathVariable Long id , Model m) {
    Song song = songRepository.findById(id).orElseThrow(IllegalStateException::new);
    m.addAttribute("song"  ,song);
//    songRepository.deleteAll();
    return  "oneSong";
  }

//  @GetMapping("/album/{title}")
//  public String getAlbum(Model m, @PathVariable String title) {
//
//    List<Album> albumWithThatTitle = albumRepository.findByTitle(title);
//    if (albumWithThatTitle.size() > 0) {
//      List<Song> songs = albumWithThatTitle.get(0).getSong();
//      m.addAttribute("album", albumWithThatTitle.get(0));
//      m.addAttribute("songs", songs);
//      return "album";
//    }
//
//    return "albums";
//  }


  @PostMapping ("/songs")
  public RedirectView addSong ( String title,String length, String trackNumber){

    Song song1 = new Song( title,length,trackNumber);
    Song song = songRepository.save(song1);
return new RedirectView( "/songs");
  }

}
