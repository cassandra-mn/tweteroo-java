package tweteroo.api.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;
import tweteroo.api.dto.TweetDTO;

@Data
@Entity
@NoArgsConstructor
public class Tweet {
    public Tweet(TweetDTO tweet, String avatar) {
        this.username = tweet.username();
        this.text = tweet.tweet();
        this.avatar = avatar;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) 
    private Long id;

    @Column(length = 50, nullable = false)
    private String username;

    @Column(length = 280, nullable = false)
    private String text;
    
    @Column(length = 500, nullable = false)
    private String avatar;
}
