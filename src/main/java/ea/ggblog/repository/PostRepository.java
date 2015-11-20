package ea.ggblog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Modifying;
import ea.ggblog.domain.Post;
@Repository
public interface PostRepository extends CrudRepository<Post, Integer> {
@Query("select p from Post p where p.title=:title")
	Post findbytitle(@Param("title")String title);

@Query("select p from Post p join p.user u where  u.id=:userId")
List<Post> findbyUserId(@Param("userId")String userId);

@Modifying
@Query("UPDATE Post p SET p.Content = :Content  WHERE p.id = :id")
  Integer updateContent(@Param("Content") String content, @Param("id") int id);   
}


