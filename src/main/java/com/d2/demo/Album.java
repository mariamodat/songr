package com.d2.demo;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "Albums")
public class Album {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  long id;
//  @Column(name = "title")
  String title;
//  @Column(name = "artist")
  String artist;
//  @Column(name = "songCount")
  String songCount;
//  @Column(name = "length")
  String length;

//  public List<Song> getSong() {
//    return (List<Song>) song;
//  }

  //  @Column(name = "imageUrl")
  String imageUrl;

  @OneToMany
    (mappedBy = "songsAlbum")
  private Set<Song> song;

  public Album(String title, String artist, String  songCount, String length, String imageUrl) {
    this.title = title;
    this.artist = artist;
    this.songCount = songCount;
    this.length = length;
    this.imageUrl = imageUrl;
  }

  public Album() {

  }

  public Set<Song> getSong() {
    return song;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getArtist() {
    return artist;
  }

  public void setArtist(String artist) {
    this.artist = artist;
  }

  public String getSongCount() {
    return songCount;
  }

  public void setSongCount(String songCount) {
    this.songCount = songCount;
  }

  public String getLength() {
    return length;
  }

  public void setLength(String length) {
    this.length = length;
  }

  public String getImageUrl() {
    return imageUrl;
  }

  public void setImageUrl(String imageUrl) {
    this.imageUrl = imageUrl;
  }

  @Override
  public String toString() {
    return "Album{" +
      "id=" + id +
      ", title='" + title + '\'' +
      ", artist='" + artist + '\'' +
      ", songCount='" + songCount + '\'' +
      ", length='" + length + '\'' +
      ", imageUrl='" + imageUrl + '\'' +
      '}';
  }
}
