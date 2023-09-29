package com.projetct.smartBlock;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("teste")
public class testeResource {
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public void teste(){
        System.out.printf("teste");
    }}
