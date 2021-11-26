package ba.com.grisecorp.data.repository.query;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ba.com.grisecorp.data.repository.specification.PredicateBuilder;
import ba.com.grisecorp.data.repository.specification.SearchCriteria;
import ba.com.grisecorp.data.repository.specification.enums.SearchOperation;

@Service
public class CoreQuery<T> {

	@PersistenceContext
	protected EntityManager entityManager;

	protected Root<?> root;
	
	protected CriteriaQuery<T> createQuery;
	
	protected CriteriaBuilder builder;
	
	protected List<Predicate> predicates;
	
	protected Map<String,JoinType> joins;
	
	
	@Transactional
	public CoreQuery from(Class clazz)
	{
		predicates = new ArrayList<Predicate>();
		joins = new HashMap<String,JoinType>();
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<T> cq  = (CriteriaQuery<T>) cb.createQuery(clazz);
		Root<?> root = (Root<?>) cq.from(clazz);
		this.setBuilder(cb);
		this.setCreateQuery(cq);
		this.setRoot(root);
		return this;
	}
	
	
	public CriteriaBuilder getBuilder()
	{
		return this.builder;
	}
	
	public void setBuilder(CriteriaBuilder builder)
	{
		this.builder = builder;
	}
	
	public CriteriaQuery<T> getCreateQuery()
	{
		return this.createQuery;
	}
	
	public void setCreateQuery(CriteriaQuery<T> cq)
	{
		this.createQuery = cq;
	}
	
	public Root<?> getRoot()
	{
		return this.root;
	}
	
	public void setRoot(Root<?> root)
	{
		this.root = root;
	}
	
	public List<Predicate> getPredicates()
	{
		return this.predicates;
	}
	
	public void setPredicates(List<Predicate> predicates)
	{
		this.predicates = predicates;
	}
	
	public Predicate add(String key, Object value)
	{
		SearchOperation operation = SearchOperation.EQUAL;
		if(value instanceof String)
		{
			operation = SearchOperation.LIKE;
		}
		
		return this.add(key, value, operation);
	}
	
	public Predicate add(String key, Object value, SearchOperation operation)
	{
		PredicateBuilder<T> predicateBuilder = this.getPredicateBuilder();
		SearchCriteria criteria = new SearchCriteria(key, value, operation);
		Predicate predicate = predicateBuilder.checkOperation(criteria);
		this.predicates.add(predicate);
		return predicate;
	}
	
	public Predicate add(Root<?> clazz, String key, Object value, SearchOperation operation)
	{
		PredicateBuilder<T> predicateBuilder = this.getPredicateBuilder();
		SearchCriteria criteria = new SearchCriteria(key, value, operation);
		Predicate predicate = predicateBuilder.checkOperation(criteria, clazz);
		this.predicates.add(predicate);
		return predicate;
	}
	
	public Predicate add(String className, String key, Object value, SearchOperation operation)
	{
		PredicateBuilder<T> predicateBuilder = this.getPredicateBuilder();
		SearchCriteria criteria = new SearchCriteria(key, value, operation);
		Predicate predicate = null;// predicateBuilder.checkOperation(criteria, clazz);
		this.predicates.add(predicate);
		return predicate;
	}
	
	public Predicate add(Path path, String key, Object value, SearchOperation operation)
	{
		PredicateBuilder<T> predicateBuilder = this.getPredicateBuilder();
		SearchCriteria criteria = new SearchCriteria(key, value, operation);
		Predicate predicate = predicateBuilder.checkOperation(criteria, path);
		this.predicates.add(predicate);
		return predicate;
	}
	
	private PredicateBuilder<T> getPredicateBuilder()
	{
		PredicateBuilder<T> predicateBuilder = new PredicateBuilder<T>();
		predicateBuilder.setRoot(this.root);
		predicateBuilder.setBuilder(this.builder);
		return predicateBuilder;
	}
	
	protected Path convertToPath(String pathStr)
	{
		String[] paths = pathStr.toLowerCase().split("\\.");
		Join<Object, Object> jresult = null;
		int size = paths.length;
		int count = 0;
		String pathConcat = "";
		String separator = ".";
		if(size > 0)
		{
			
			pathConcat = paths[0];
			jresult =  this.getFirstJoin(pathConcat);
	        if(size == 1)
	        {
	        	return jresult;
	        }
	        else
	        {
	        	for(String pth : paths)
	    		{
	        		count++;
	        		if(count == 1) continue;
	        		pathConcat += separator + pth;
	        		JoinType joinType = this.getJoinType(pathConcat);
	        		jresult = jresult.join(pth, joinType);
	     		}
	        }
		}

		return jresult;
	}
	
	private JoinType getJoinType(String path)
	{
		JoinType joinType = joins.get(path);
		joinType = joinType == null ? joinType.INNER : joinType;
		return joinType;
	}
	
	private Join<Object, Object> getFirstJoin(String first)
	{
		JoinType joinType = this.getJoinType(first);
		Join<Object, Object> join = this.root.join(first, joinType);
        return join;
	}
	
	protected Root<?> getJoinRootClass(String className)
	{
		Root<?> rootClass = this.root;
		return rootClass;
	}
	
	protected Join<Object,Object> getJoin(Class<?> clazz)
	{
		String className = clazz.getSimpleName().toLowerCase();
		JoinType joinType = joins.get(className);
		Root<?> rootClass = this.getJoinRootClass(clazz.getSimpleName());
		return rootClass.join(className, joinType);
	}

}
