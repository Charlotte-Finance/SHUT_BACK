package com.example.shut_be.controllers;

import com.example.shut_be.domains.Preference;
import com.example.shut_be.domains.User;
import com.example.shut_be.services.PreferenceService;
import com.example.shut_be.services.RestService;
import com.example.shut_be.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    PreferenceService preferenceService;

    @GetMapping("")
    public List<User> list() {
        return userService.listAllUser();
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> get(@PathVariable Integer id) {
        try {
            User user = userService.getUser(id);
            return new ResponseEntity<>(user, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/")
    public ResponseEntity<User> add(@RequestBody User user) {
        try {
            User postUser = (userService.saveUser(user));
            Preference preference = new Preference(postUser.getId());
            preferenceService.savePreference(preference);
            return new ResponseEntity<>(postUser, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody Map<String, String> userData) {
        try {
            User user = userService.getUserByLogin(userData.get("email"), userData.get("password"));
            onUserConnect(user.getId());
            return new ResponseEntity<>(user, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}/preferences")
    public ResponseEntity<Preference> getPreference(@PathVariable Integer id) {
        try {
            Preference preference = preferenceService.getPreferenceByUserId(id);
            return new ResponseEntity<>(preference, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        userService.deleteUser(id);
    }


    public void onUserConnect(int userId){
        Preference preference = preferenceService.getPreferenceByUserId(userId);
        RestTemplateBuilder rest = new RestTemplateBuilder();
        RestService service = new RestService(rest);
        service.sendUpdate(preference);
    }
}
