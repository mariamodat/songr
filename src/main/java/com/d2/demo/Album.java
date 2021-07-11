package com.d2.demo;

public class Album {
  public String title;
  public String artist;
  public String songCount;
  public String length ;
  public String imageUrl ;

  public Album(String title, String artist, String  songCount, String length, String imageUrl) {
    this.title = title;
    this.artist = artist;
    this.songCount = songCount;
    this.length = length;
    this.imageUrl = imageUrl;
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
}
