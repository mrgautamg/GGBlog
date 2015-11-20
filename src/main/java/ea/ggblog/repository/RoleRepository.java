package ea.ggblog.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ea.ggblog.domain.Role;
@Repository
public interface RoleRepository extends CrudRepository<Role, Integer> {
@Query("select r from Role r where r.Name=:name")
	Role findbyname(@Param("name")String name);

}
