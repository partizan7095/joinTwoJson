package com.example.joinTwoJson.service;

import com.example.joinTwoJson.model.Json;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.*;
import java.net.URL;
import java.util.*;
import java.util.stream.Collectors;

@Service
@JsonIgnoreProperties(ignoreUnknown = true)
public class ImpJsonService {
    public HashSet<Json> url(String url, String path) throws NullPointerException {
        ObjectMapper objectMapper = new ObjectMapper();
        List<Json> json = null;
        HashSet<Json> hashSet = new HashSet<>();
        try {
            json = objectMapper.readValue(new URL(url).openStream(), new TypeReference<List<Json>>(){});
            json.addAll(objectMapper.readValue(new File(path), new TypeReference<List<Json>>(){}));
            Map<String, Map<String, Integer>> collect = json.stream()
                    .collect(Collectors.groupingBy(Json::getProductUuid, Collectors.groupingBy(Json::getProductName, Collectors.summingInt(Json::getAmount))));
            //Не зрозумів як в Stream зробити щоб зразу сумувати amount і не робити Map, на тех-інтервʼю хочу щоб ви обʼяснили :-)
            for (String s : collect.keySet()) {
                for (String s1 : collect.get(s).keySet()) {
                    hashSet.add(new Json(s,s1,collect.get(s).get(s1)));
                }
            }

        } catch (IOException e ) {
            e.printStackTrace();
        }
        //додав щоб показати зразу кількість елементів
        System.out.println(hashSet.size());
        return hashSet;
    }
}
