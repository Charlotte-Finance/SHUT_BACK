package com.example.shut_be.controllers;

import com.example.shut_be.domains.Pic;
import com.example.shut_be.services.PicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;

@RestController
@RequestMapping("/values")
public class ValueController {
    @Autowired
    PicService picService;

    @GetMapping("")
    public Integer getValue() {
        return fetchValueFromObject();
    }

    public Integer fetchValueFromObject() {
        try {
            URL url = new URL("http://192.168.179.132/decibel");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer content = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();
            String value = content.toString();
            int decibel =  (int)Double.parseDouble(value.substring(9, value.length() - 1));
            return decibel;
        } catch (MalformedURLException | ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Random rand = new Random();
        return rand.nextInt(71);
    }
}
