package ea.ggblog.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ea.ggblog.domain.User;
import ea.ggblog.repository.RoleRepository;
import ea.ggblog.repository.UserRepository;
import ea.ggblog.service.UserService;
@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userrepository;

	@Autowired
	RoleRepository rolerepository;
	@Override
	public void save(User user,int roleid) {
		user.setRole(rolerepository.findOne(roleid));
		userrepository.save(user);
	}

	@Override
	public User getById(String id) {
		return userrepository.findOne(id);
	}

	@Override
	public User getByName(String name) {
		return userrepository.findByName(name);
	}

	@Override
	public List<User> getAll() {
		return (List<User>) userrepository.findAll();
	}

}
