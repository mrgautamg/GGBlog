package ea.ggblog.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ea.ggblog.domain.Role;
import ea.ggblog.repository.RoleRepository;
import ea.ggblog.service.RoleService;
@Service
@Transactional
public class RoleServiceImpl implements RoleService {
	@Autowired
	RoleRepository rolerepository;
	@Override
	public void save(Role role) {
		rolerepository.save(role);

	}

	@Override
	public Role getById(int id) {
		return rolerepository.findOne(id);
	}

	@Override
	public Role getByName(String name) {
		return rolerepository.findbyname(name);
	}

	@Override
	public List<Role> getAll() {
		return (List<Role>)rolerepository.findAll();
	}

}
