package ba.com.grisecorp.domain.core.Service;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import ba.com.grisecorp.data.repository.Intanciate;
import ba.com.grisecorp.data.repository.query.Query;
import ba.com.grisecorp.data.repository.specification.SearchCriteria;
import ba.com.grisecorp.data.repository.specification.SpecificationBuilder;
import ba.com.grisecorp.data.repository.specification.enums.SearchOperation;

public class CoreService<T>{

	@Autowired
	public Query<T> query;
	
	protected SpecificationBuilder<T> createCriteria(String propertyName,Object value, SearchOperation operation)
	{
		List<SearchCriteria> criteria = new ArrayList<SearchCriteria>();
		criteria.add(new SearchCriteria(propertyName, value, operation));
		SpecificationBuilder<T> specification = new SpecificationBuilder<T>(criteria);
		return specification;
	}
	
	protected Object getValue(T filter, String fieldName) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException
	{
		Field field = filter.getClass().getDeclaredField(fieldName); 
		field.setAccessible(true);
		Object value = field.get(filter);
		return value;
	}
	
	protected SearchOperation getOperation(Object value)
	{
		SearchOperation operation = SearchOperation.EQUAL;
		if(value instanceof String)
		{
			operation = SearchOperation.LIKE;
		}
		
		return operation;
	}
	
	protected Specification BuildCriteria(List<SpecificationBuilder<T>> specificationbList)
	{
		Specification specification = null;
		int specSize = specificationbList.size();
		int countSpec = 0;
		if(specSize > 0)
		{
			specification = Specification.where(specificationbList.get(0));
			if(specSize == 1)
			{
				return specification;
			}
			else
			{
				for(SpecificationBuilder<T> spec : specificationbList)
				{
					countSpec++;
					if(countSpec ==1) continue;
					specification = specification.or(spec);
				}
			}
		}
		
		return specification;
	}
	
	public List<T> GetAllByFilter(JpaSpecificationExecutor repository, T filter) 
	{	
		Specification spec = null;
		try
		{
		    List<SpecificationBuilder<T>> specificationbList = new ArrayList<SpecificationBuilder<T>>();
			Class clazz = filter.getClass();
			for(Field field : clazz.getDeclaredFields())
			{
				String fieldName = field.getName().toLowerCase();
				Object value =  this.getValue(filter, fieldName);
				SearchOperation operation = this.getOperation(value);
				SpecificationBuilder<T> sbuilder = this.createCriteria(fieldName, value, operation);
				specificationbList.add(sbuilder);
			}
			
			spec = this.BuildCriteria(specificationbList);
			
		}
		catch(Exception ex)
		{
			
		}
		
		return this.toList(repository.findAll(spec));
	}
	
	public List<T> toList(Iterable<T> list)
	{
		return  StreamSupport.stream(list.spliterator(), false).collect(Collectors.toList());
	}
	
	public <T> List<T> toList(Optional<T> opt) {
	    return opt.isPresent()
	            ? Collections.singletonList(opt.get())
	            : Collections.emptyList();
	}
	
}
