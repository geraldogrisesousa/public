package ba.com.grisecorp.domain.aggregates.project.status.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ba.com.grisecorp.domain.aggregates.project.status.Status;

@Repository
public interface IStatusRepository  extends CrudRepository<Status, Integer>, JpaSpecificationExecutor<Status>
{
}
