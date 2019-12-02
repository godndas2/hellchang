package org.hellchang.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HomeController {

    // TODO NEXT, DB INSERT TEST
    @GetMapping
    public String index() {
        return "10REPS!!";
    }
}
