package tweteroo.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tweteroo.api.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
