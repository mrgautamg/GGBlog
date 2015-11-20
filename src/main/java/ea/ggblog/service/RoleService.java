package ea.ggblog.service;

import java.util.List;



import ea.ggblog.domain.Role;




public interface RoleService {
	public void save(Role role);
	public Role getById(int id);
	public Role getByName(String name);
	public List<Role> getAll();
}
