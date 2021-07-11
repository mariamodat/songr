package com.d2.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

  @Test
  void constructorTest() {

    Album album = new Album("Hello from test! ","Mariam","11","2min","xxxx");
    Assertions.assertEquals("Hello from test! ",album.title);
    Assertions.assertEquals("Mariam",album.artist);
    Assertions.assertEquals("11",album.songCount);
    Assertions.assertEquals("2min",album.length);
    Assertions.assertEquals("xxxx",album.imageUrl);

  }

}
