package com.d2.demo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.ManyToAny;

import javax.persistence.*;

@Entity
@Table (name = "Songs")
public class Song {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  long id;
  String title;
  String length;
  String trackNumber;

  @ManyToOne
  @JsonIgnore
  @JoinColumn(name = "songs_album_id")
  Album songsAlbum;

  public Song(){}

  public Song(String title,String length, String trackNumber){
    this.title = title;
    this.length = length;
    this.trackNumber = trackNumber;

  }


  public String getTitle() {
    return title;
  }

  public String getLength() {
    return length;
  }

  public void setSongsAlbum(Album songsAlbum) {
    this.songsAlbum = songsAlbum;
  }

  public String getTrackNumber() {
    return trackNumber;
  }

  public Album getSongsAlbum() {
    return songsAlbum;
  }

  public long getId() {
    return id;
  }
}
