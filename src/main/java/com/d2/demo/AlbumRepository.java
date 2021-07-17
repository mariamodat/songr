package com.d2.demo;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AlbumRepository extends JpaRepository<Album, Long> {
  List<Album> findByTitle(String title);
}
