package com.example.joinTwoJson.controllers;

import com.example.joinTwoJson.model.Json;
import com.example.joinTwoJson.service.ImpJsonService;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.HashSet;


@RestController
@RequestMapping("/implementJson")
public class ImpJsonController {
    private final ImpJsonService impJsonService;

    public ImpJsonController(ImpJsonService impJsonService) {
        this.impJsonService = impJsonService;
    }
    @GetMapping(path = "add")
    public HashSet<Json> add(@PathParam("url") String url, @PathParam("path") String path){
         return impJsonService.url(url, path);
    }
    //Get запрос для перевірки програми
    //http://localhost:8080/implementJson/add?url=https://sciforce.solutions/downloads/sciforce-java-test1.json&path=sciforce-java-test2.json

}
