package tweteroo.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import tweteroo.api.model.Tweet;

public interface TweetRepository extends PagingAndSortingRepository<Tweet, Long>, JpaRepository<Tweet, Long>  {

}
