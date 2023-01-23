package tweteroo.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import tweteroo.api.dto.TweetDTO;
import tweteroo.api.model.Tweet;
import tweteroo.api.service.TweetService;

@RestController
@RequestMapping("/tweets")
public class TweetController {
    @Autowired
    private TweetService service;

    @GetMapping
    public Page<Tweet> findAllPage(@RequestParam(value = "page", required = false, defaultValue = "0") Integer page) {
        return service.listAll(page);
    }

    @GetMapping
    public List<Tweet> findByUsername(@RequestParam(value = "username", required = true) String username) {
        return service.listByUsername(username);
    }
    
    @PostMapping
    public String create(@RequestBody TweetDTO tweet) {
        return service.create(tweet);
    }
}
