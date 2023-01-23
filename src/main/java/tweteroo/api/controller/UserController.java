package tweteroo.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tweteroo.api.dto.UserDTO;
import tweteroo.api.model.User;
import tweteroo.api.service.UserService;

@RestController
@RequestMapping("/sign-up")
public class UserController {
    @Autowired
    private UserService service;

    @GetMapping
    public List<User> findAll() {
        return service.listAll();
    }

    @PostMapping
    public String create(@RequestBody UserDTO user) {
        return service.create(user);
    }

    @PutMapping("/{id}") 
    public void update(@RequestBody UserDTO user, @PathVariable Long id) {
        service.update(id, user);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
