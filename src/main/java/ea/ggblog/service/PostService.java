package ea.ggblog.service;

import java.util.List;


import ea.ggblog.domain.Post;



public interface PostService {

	public void save(Post post);
	public void update(Post post);
	public Post getById(int id);
	public Post getByTitle(String Title);
	public List<Post> getAll();
	public List<Post> getByUserId(String userId);
}
