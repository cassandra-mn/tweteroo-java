package tweteroo.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import jakarta.validation.Valid;
import tweteroo.api.dto.TweetDTO;
import tweteroo.api.model.Tweet;
import tweteroo.api.repository.TweetRepository;
import tweteroo.api.repository.UserRepository;

@Service
public class TweetService {
    @Autowired
    private TweetRepository repository;
    
    @Autowired
    private UserRepository userRepository;

    public Page<Tweet> listAll(int page) {
        PageRequest pageable = PageRequest.of(0, 5).withPage(page);

        return repository.findAll(pageable);
    }

    public List<Tweet> listByUsername(String username) {
        return repository.findByUsername(username);
    }

    public String create(@Valid TweetDTO dto) {
        String avatar = userRepository.findByUsername(dto.username()).getAvatar();

        repository.save(new Tweet(dto, avatar));

        return "OK";
    }
}
