package dev.java10x.CadastroDeNinjas.Ninja;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ninja")
public class NinjaController {

    @GetMapping("/hello-world")
    public String HelloWorld() {
        return "Hello world";
    }

}
