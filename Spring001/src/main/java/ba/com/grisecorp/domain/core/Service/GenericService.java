package ba.com.grisecorp.domain.core.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;



import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.hibernate.engine.internal.JoinSequence.Join;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import ba.com.grisecorp.data.repository.specification.SearchCriteria;
import ba.com.grisecorp.data.repository.specification.SpecificationBuilder;
import ba.com.grisecorp.data.repository.specification.enums.SearchOperation;


public class GenericService<T> extends CoreService<T> {

	public List<T> getAll(Iterable<T> list)
	{
		return  super.toList(list);
	}
	
	public List<T> GetAllByFilter(JpaSpecificationExecutor repository, T filter) 
	{	
		return super.GetAllByFilter(repository, filter);
	}
}
