package ba.com.grisecorp.domain.aggregates.project.programa.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ba.com.grisecorp.domain.aggregates.project.programa.Programa;

@Repository
public interface IProgramaRepository  extends CrudRepository<Programa, Integer>, JpaSpecificationExecutor<Programa>
{
	@Query(value = "SELECT * FROM programa WHERE id_grupoetapa = :id_grupo_etapa", nativeQuery = true)
	List<Programa> findByGrupo(final @Param("id_grupo_etapa") int id_grupo_etapa);
}
