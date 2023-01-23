package tweteroo.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import tweteroo.api.model.Tweet;

public interface TweetRepository extends PagingAndSortingRepository<Tweet, Long>, JpaRepository<Tweet, Long>  {
    List<Tweet> findByUsername(String username);
}
