package com.d2.demo;

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;
import java.util.Set;

//@CrossOrigin (origins = "http://localhost:8080")
@Controller
public class HelloController {

  @Autowired
  AlbumRepository albumRepository;
  @Autowired
SongRepository songRepository;

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
  // get the three albums only :

  @GetMapping("/albums")
  public String album(Model model) {
    Album album1 = new Album("I Told You I Like You", "Johnny Orlando, Mackenzie Ziegler", "59,436,114 ", "4 min 08 sec", "https://images.genius.com/73c951f278662679356b9ea0631e2435.600x600x1.png");
    Album album2 = new Album("Arcade ", "Duncan Laurence ", "48,397,097", "3 min 03 sec", "https://i.ytimg.com/vi/L8IhgA3Du3Q/maxresdefault.jpg");
    Album album3 = new Album("Without Me", "Halsey ", "240,635,891", "3 min 23 sec", "https://swanstage.com/wp-content/uploads/2020/10/without-me-1.jpg");

    Iterable<Album> albums = albumRepository.findAll();

    Album[] albumss = new Album[]{album1, album2, album3,};
    model.addAttribute("albums", albumss);
    model.addAttribute("albums1", albums);

    System.out.println();
    return "albums";
  }

  @PostMapping("/albums")
  RedirectView addAlbum(String title, String artist,
                        String songCount, String length, String imageUrl) {
    Album album = new Album(title, artist, imageUrl, length, songCount);
    albumRepository.save(album);
//    albumRepository.deleteAll();
    return new RedirectView("/albums");
  }

@PostMapping("/albums/{albumId}/songs")
  ResponseEntity <Album> addSongToAlbum (@PathVariable  Long albumId, Long songId ){

    Album album = albumRepository.findById(albumId).orElseThrow(IllegalStateException::new);

Song song = songRepository.findById(songId).orElseThrow(IllegalStateException::new);
song.setSongsAlbum(album);
  songRepository.save(song);
return  new ResponseEntity<Album>(album ,HttpStatus.OK );

}


}






