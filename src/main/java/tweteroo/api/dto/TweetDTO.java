package tweteroo.api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record TweetDTO(
    @NotBlank String username, 
    
    @NotNull String tweet) {
}
