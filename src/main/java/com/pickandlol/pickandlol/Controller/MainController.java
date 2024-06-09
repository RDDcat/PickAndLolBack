package com.pickandlol.pickandlol.Controller;

import com.pickandlol.pickandlol.Aspect.TimeRestricted;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
    @GetMapping("/")
    public String health(){
        return "server on health check";
    }
    @TimeRestricted
    @GetMapping("/save")
    public String save(){
        return "server on health check";
    }

}
