package com.d2.demo;

import java.util.List;

public interface AlbumRepository extends JpaRepository<Album, Long> {

  public List<Album> findByTitle(String title);
}
