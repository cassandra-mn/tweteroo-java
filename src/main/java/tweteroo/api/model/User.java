package tweteroo.api.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Data;
import lombok.NoArgsConstructor;

import tweteroo.api.dto.UserDTO;

@Data
@Entity
@NoArgsConstructor
@Table(
    name = "Users",
    uniqueConstraints = @UniqueConstraint(columnNames = "username")
)
public class User {
    public User(UserDTO dto) {
        this.username = dto.username();
        this.avatar = dto.avatar();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 50, nullable = false)
    private String username;

    @Column(length = 500, nullable = false)
    private String avatar;
}
