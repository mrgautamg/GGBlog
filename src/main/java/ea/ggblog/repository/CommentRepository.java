package ea.ggblog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ea.ggblog.domain.Comment;
@Repository
public interface CommentRepository extends CrudRepository<Comment, String> {
	@Query("select c from Comment c where c.post.id=:post_id")
	List<Comment> findbypostid(@Param("post_id")String post_id);

}
