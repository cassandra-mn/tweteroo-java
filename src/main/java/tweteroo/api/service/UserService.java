package tweteroo.api.service;

import jakarta.validation.Valid;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tweteroo.api.dto.UserDTO;
import tweteroo.api.model.User;
import tweteroo.api.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public List<User> listAll() {
        return repository.findAll();
    }

    public String create(@Valid UserDTO dto) {
        repository.save(new User(dto));
        return "OK";
    }

    public void update(Long id, UserDTO dto) {
        repository.findById(id).map(user -> {
            if (dto.username().length() > 0)
                user.setUsername(dto.username());

            if (dto.avatar().length() > 0)
                user.setAvatar(dto.avatar());

            return repository.save(user);
        });
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
