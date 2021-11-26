package ba.com.grisecorp.domain.aggregates.project.grupoetapa.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ba.com.grisecorp.domain.aggregates.project.grupoetapa.GrupoEtapa;

@Repository
public interface IGrupoEtapaRepository  extends CrudRepository<GrupoEtapa, Integer>, JpaSpecificationExecutor<GrupoEtapa>
{
}
