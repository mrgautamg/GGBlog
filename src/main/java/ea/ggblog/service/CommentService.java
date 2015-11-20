package ea.ggblog.service;

import java.util.List;



import ea.ggblog.domain.Comment;




public interface CommentService {
	public void save(Comment comment);
	public Comment getById(String id);
	public List<Comment> getByPost(String post_id);
	public List<Comment> getAll();
}
