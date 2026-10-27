package mx.unam.fi.melo.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController( "/")
public class TestController {

  @GetMapping
  public String test() {
    return "Mi primer API";
  }

}
