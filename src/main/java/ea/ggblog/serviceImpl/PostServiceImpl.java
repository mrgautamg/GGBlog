package ea.ggblog.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ea.ggblog.domain.Post;
import ea.ggblog.repository.PostRepository;
import ea.ggblog.service.PostService;
@Service
@Transactional
public class PostServiceImpl implements PostService {
	@Autowired
	PostRepository postrepository;
	
	@Override
	public void save(Post post) {
		postrepository.save(post);

	}

	@Override
	public void update(Post post) {
		Post oldPost= postrepository.findOne(post.getId());
		oldPost.setContent(post.getContent());
		postrepository.save(oldPost);
		//postrepository.updateContent(post.getContent(),post.getId());
	}
	@Override
	public Post getById(int id) {
		return postrepository.findOne(id);
	}

	@Override
	public Post getByTitle(String title) {
		return postrepository.findbytitle(title);
	}

	@Override
	public List<Post> getByUserId(String userId) {
		return (List<Post>)postrepository.findbyUserId(userId);
	}
	
	@Override
	public List<Post> getAll() {
		return (List<Post>)postrepository.findAll();
	}

}
