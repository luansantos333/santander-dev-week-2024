package me.dio.domain.controller;

import me.dio.domain.model.User;
import me.dio.domain.service.Impl.UserServiceImpl;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping ("/santander")
public class UserController {

    @Autowired
    private final UserServiceImpl userService;

    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping ("/users")
    public ResponseEntity <Iterable<User>> getAllUsers () {

        return ResponseEntity.ok(userService.findAll());

    }

    @GetMapping ("/users/{id}")
    public ResponseEntity<User> getUsersById (@PathVariable Long id) {

        return ResponseEntity.ok(userService.findById(id));

    }

    @PostMapping ("/create")
    public ResponseEntity<User> createNewUser (@RequestBody User user) {

        User userCreated = userService.createUser(user);
        URI uri = ServletUriComponentsBuilder.
                fromCurrentRequestUri().
                path("/users/{id}").
                buildAndExpand(userCreated.getId()).
                toUri();

        return ResponseEntity.created(uri).body(userCreated);

    }

    @PutMapping ("/update/{id}")
    public ResponseEntity<User> updateUser (@PathVariable Long id, @RequestBody User user) {

        return ResponseEntity.ok(userService.updateUser(id, user));

    }

    @DeleteMapping ("/delte/{id}")
    public void deleteUser (@PathVariable Long id) {

        userService.deletUserById(id);

    }


}
