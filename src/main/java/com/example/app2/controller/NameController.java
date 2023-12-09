package com.example.app2.controller;

import com.example.app2.entity.Name;
import com.example.app2.service.NameService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/app2")
public class NameController {

    @Autowired
    private NameService nameService;
    @GetMapping("/all")
    List<Name> getAllName(){
        return nameService.getAllNames();
    }

    @PostMapping("/insert")
    Map<String,String> insertName(@RequestBody  Map<String,String> name) throws UnsupportedEncodingException {
      // Map<String,String> map  =  decodeString(name);

       // System.out.println("map: " + map);

        nameService.insertName(name);
       return Map.of("status","Success" ,"Description","inserted");
    }

    private static Map<String, String> decodeString(Map<String ,String> name) throws UnsupportedEncodingException {
        String jsonString = name.get("s1Key");

        // Using Gson to convert the JSON string back to a Map
        byte[] bytes = jsonString.getBytes("UTF-8");
        String decoded = new String(bytes, StandardCharsets.UTF_8);
        Gson gson = new Gson();
        Map<String, Object> map = gson.fromJson(decoded, Map.class);

   Map<String, String>  resultMap  = new HashMap<String, String>();
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            //System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        resultMap.put(entry.getKey(), entry.getValue().toString());
        }


  System.out.println(map);
        // Accessing values from the Map (for demonstration)
        /*for (Map.Entry<String, Object> entry : map.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }


        String[] possibleCharsets = {"UTF-8", "ISO-8859-1", "Windows-1252", "UTF-16", "US-ASCII"};

        for (String charset : possibleCharsets) {
            try {
                byte[] bytes = corruptedString.getBytes(charset);
                String decoded = new String(bytes, charset);
                System.out.println("Decoded with " + charset + ": " + decoded);
            } catch (Exception e) {
                System.out.println("Failed to decode with " + charset);
            }
        }*/
        return resultMap; // Or handle differently based on your application's needs
    }
}
