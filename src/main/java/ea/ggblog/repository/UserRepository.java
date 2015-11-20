package ea.ggblog.repository;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ea.ggblog.domain.User;
@Repository
public interface UserRepository extends CrudRepository<User, String> {
	@Query("select u from User u where u.username=:username")
	User findByName(@Param("username")String name);

}
