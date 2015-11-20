package ea.ggblog.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ea.ggblog.domain.Comment;
import ea.ggblog.repository.CommentRepository;
import ea.ggblog.service.CommentService;
@Service
@Transactional
public class CommentServiceImpl implements CommentService {

	@Autowired
	CommentRepository commentrepository;
	@Override
	public void save(Comment comment) {
		commentrepository.save(comment);

	}

	@Override
	public Comment getById(String id) {
		return commentrepository.findOne(id);
	}

	@Override
	public List<Comment> getByPost(String post_id) {
		return (List<Comment>)commentrepository.findbypostid(post_id);
	}

	@Override
	public List<Comment> getAll() {
		return (List<Comment>)commentrepository.findAll();
	}

}
