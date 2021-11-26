package ba.com.grisecorp.domain.aggregates.project.project.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ba.com.grisecorp.domain.aggregates.project.project.Project;

@Repository
public interface IProjectRepository  extends CrudRepository<Project, Integer>, JpaSpecificationExecutor<Project>
{
	Optional<Project> getByName(final @Param("name") String name);
	
	@Query(value = "SELECT * FROM project WHERE id_programa = :id_programa", nativeQuery = true)
	List<Project> findByPrograma(final @Param("id_programa") int id_programa);
	
	@Query(value = "SELECT * FROM project WHERE id_status = :id_status", nativeQuery = true)
	List<Project> findByStatus(final @Param("id_status") int id_status);
}
