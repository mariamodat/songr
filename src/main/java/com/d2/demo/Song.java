package com.d2.demo;

import org.hibernate.annotations.ManyToAny;

import javax.persistence.*;

@Entity

public class Song {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  long id;
  String title;
  String length;
  String trackNumber;

  @ManyToOne
  Album songsAlbum;

  public Song(){}

  public Song(String title,String length, String trackNumber, Album songsAlbum){
    this.title = title;
    this.length = length;
    this.trackNumber = trackNumber;
    this.songsAlbum = songsAlbum;
  }


  public String getTitle() {
    return title;
  }

  public String getLength() {
    return length;
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
