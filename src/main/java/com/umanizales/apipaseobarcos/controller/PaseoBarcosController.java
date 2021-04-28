package com.umanizales.apipaseobarcos.controller;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path =  "/paseobarcos")
@Validated
public class PaseoBarcosController {

    @GetMapping
        public  String getMessage(){
            return "Hola rome";
        }
        @GetMapping(path= "/message2")
        public  String Message2(){
            return "Soy un segundo mensaje";
        }
        @GetMapping(path= "/message3/{saludo}")
        public  String Message3(@PathVariable("saludo")String saludo){
            return "hola " + saludo;
        }
}
