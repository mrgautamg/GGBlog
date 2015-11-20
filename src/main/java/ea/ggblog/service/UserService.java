package ea.ggblog.service;

import java.util.List;

import ea.ggblog.domain.User;

public interface UserService {
public void save(User user,int roleid);
public User getById(String id);
public User getByName(String name);
public List<User> getAll();
}
