package ba.com.grisecorp.data.repository.query;

import java.util.List;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Join;

import org.springframework.stereotype.Service;

import ba.com.grisecorp.data.repository.specification.enums.SearchOperation;

@Service
public class Query<T> extends CoreQuery<T>{

private Class clazz;
	
	public Query()
	{
		super();
	}

	public Class getClazz() {
		return clazz;
	}

	public void setClazz(Class clazz) {
		this.clazz = clazz;
	}

	public Query from(Class clazz)
	{
		super.from(clazz);
		this.setClazz(clazz);
		return this;
	}
	
	public Query where(List<Predicate> predicateList)
	{
		super.builder.and(predicateList.toArray(new Predicate[0]));
		return this;
	}
	
	public Query where(Predicate predicate)
	{
		super.builder.and(predicate);
		return this;
	}
	
	public Query where(Predicate... predicateList)
	{
		Predicate[] predicates = predicateList;
		super.builder.and(predicates);
		return this;
	}
	
	public Query Join(Class<?> clazz)
	{
		String className = clazz.getSimpleName().toLowerCase();
		Root<?> rootClass  = super.root;
		Join<Object, Object> join = rootClass.join(className,JoinType.INNER);
		joins.put(className, JoinType.INNER);
		return this;
	}
	
	public Query Join(String path)
	{
		joins.put(path.toLowerCase(), JoinType.INNER);
		return this;
	}
	
	public Query LeftJoin(Class<?> clazz)
	{
		String className = clazz.getSimpleName().toLowerCase();
		Root<?> rootClass  = super.root;
		Join<Object, Object> join = rootClass.join(className,JoinType.LEFT);
		joins.put(className, JoinType.LEFT);
		return this;
	}
	
	public Query LeftJoin(String path)
	{
		joins.put(path.toLowerCase(), JoinType.LEFT);
		return this;
	}
	
	public Query RightJoin(Class<?> clazz)
	{
		String className = clazz.getSimpleName().toLowerCase();
		Root<?> rootClass  = super.root;
		Join<Object, Object> join = rootClass.join(className,JoinType.RIGHT);
		joins.put(className, JoinType.RIGHT);
		return this;
	}

	public Query RightJoin(String path)
	{
		joins.put(path.toLowerCase(), JoinType.RIGHT);
		return this;
	}
	
	public List<T> toList()
	{
		TypedQuery<T> typedQuery = super.entityManager.createQuery(super.createQuery);
		if(super.predicates.size() > 0)
		{
			 CriteriaQuery<T> query = super.createQuery.where(predicates.toArray(new Predicate[0]));
			 typedQuery = super.entityManager.createQuery(query);
		}
		
		return typedQuery.getResultList();
	}
	
	public T firstOrDefault()
	{
		TypedQuery<T> typedQuery =  super.entityManager.createQuery(super.createQuery);
		if(super.predicates.size() > 0)
		{
			 CriteriaQuery<T> query = super.createQuery.where(predicates.toArray(new Predicate[0]));
			 typedQuery = super.entityManager.createQuery(query);
		}
		
		return typedQuery.getSingleResult();
	}
	
	public Predicate equal(String key, Object value)
	{
		return this.equal(this.clazz, key, value);
	}
	
	public Predicate equal(String pathStr, String key, Object value)
	{
		Path path = super.convertToPath(pathStr);
		return this.add(path, key, value, SearchOperation.EQUAL);
	}
	
	public Predicate equal(Class<?> clazz, String key, Object value)
	{
		Join<Object,Object> join = this.getJoin(clazz);
		return super.add(join, key, value, SearchOperation.EQUAL);
	}
	
	public Predicate notEqual(String key, Object value)
	{
		return this.notEqual(this.clazz, key, value);
	}
	
	public Predicate notEqual(String pathStr, String key, Object value)
	{
		Path path = super.convertToPath(pathStr);
		return this.add(path, key, value, SearchOperation.NOT_EQUAL);
	}
	
	public Predicate notEqual(Class<?> clazz, String key, Object value)
	{
		Join<Object,Object> join = this.getJoin(clazz);
		return super.add(join, key, value, SearchOperation.NOT_EQUAL);
	}
	
	public Predicate like(String key, Object value)
	{
		return this.like(this.clazz, key, value);
	}
	
	public Predicate like(String pathStr, String key, Object value)
	{
		Path path = super.convertToPath(pathStr);
		return this.add(path, key, value, SearchOperation.LIKE);
	}

	public Predicate like(Class<?> clazz, String key, Object value)
	{
		Join<Object,Object> join = this.getJoin(clazz);
		return super.add(join, key, value, SearchOperation.LIKE);
	}
	
	public Predicate startsWith(String key, Object value)
	{
		return this.startsWith(this.clazz, key, value);
	}
	
	public Predicate startsWith(String pathStr, String key, Object value)
	{
		Path path = super.convertToPath(pathStr);
		return this.add(path, key, value, SearchOperation.START);
	}
	
	public Predicate startsWith(Class<?> clazz, String key, Object value)
	{
		Join<Object,Object> join = this.getJoin(clazz);
		return super.add(join, key, value, SearchOperation.START);
	}
	
	public Predicate endsWith(String key, Object value)
	{
		return this.endsWith(this.clazz, key, value);
	}
	
	public Predicate endsWith(String pathStr, String key, Object value)
	{
		Path path = super.convertToPath(pathStr);
		return this.add(path, key, value, SearchOperation.END);
	}
	
	public Predicate endsWith(Class<?> clazz, String key, Object value)
	{
		Join<Object,Object> join = this.getJoin(clazz);
		return super.add(join, key, value, SearchOperation.END);
	}
	
	public Predicate gt(String key, Object value)
	{
		return this.gt(this.clazz, key, value);
	}
	
	public Predicate gt(String pathStr, String key, Object value)
	{
		Path path = super.convertToPath(pathStr);
		return this.add(path, key, value, SearchOperation.GREATER_THAN);
	}
	
	public Predicate gt(Class<?> clazz, String key, Object value)
	{
		Join<Object,Object> join = this.getJoin(clazz);
		return super.add(join, key, value, SearchOperation.GREATER_THAN);
	}
	
	public Predicate ge(String key, Object value)
	{
		return this.ge(this.clazz, key, value);
	}
	
	public Predicate ge(String pathStr, String key, Object value)
	{
		Path path = super.convertToPath(pathStr);
		return this.add(path, key, value, SearchOperation.GREATER_THAN_EQUAL);
	}
	
	public Predicate ge(Class<?> clazz, String key, Object value)
	{
		Join<Object,Object> join = this.getJoin(clazz);
		return super.add(join, key, value, SearchOperation.GREATER_THAN_EQUAL);
	}
	
	public Predicate lt(String key, Object value)
	{
		return this.lt(this.clazz, key, value);
	}
	
	public Predicate lt(String pathStr, String key, Object value)
	{
		Path path = super.convertToPath(pathStr);
		return this.add(path, key, value, SearchOperation.LESS_THAN);
	}
	
	public Predicate lt(Class<?> clazz, String key, Object value)
	{
		Join<Object,Object> join = this.getJoin(clazz);
		return super.add(join, key, value, SearchOperation.LESS_THAN);
	}
	
	public Predicate le(String key, Object value)
	{
		return this.le(this.clazz, key, value);
	}
	
	public Predicate le(String pathStr, String key, Object value)
	{
		Path path = super.convertToPath(pathStr);
		return this.add(path, key, value, SearchOperation.LESS_THAN_EQUAL);
	}
	
	public Predicate le(Class<?> clazz, String key, Object value)
	{
		Join<Object,Object> join = this.getJoin(clazz);
		return super.add(join, key, value, SearchOperation.LESS_THAN_EQUAL);
	}
	
	public Predicate in(String key, Object value)
	{
		return this.in(this.clazz, key, value);
	}
	
	public Predicate in(String pathStr, String key, Object value)
	{
		Path path = super.convertToPath(pathStr);
		return this.add(path, key, value, SearchOperation.IN);
	}
	
	public Predicate in(Class<?> clazz, String key, Object value)
	{
		Join<Object,Object> join = this.getJoin(clazz);
		return super.add(join, key, value, SearchOperation.IN);
	}
	
	public Predicate notIn(String key, Object value)
	{
		return this.notIn(this.clazz, key, value);
	}
	
	public Predicate notIn(String pathStr, String key, Object value)
	{
		Path path = super.convertToPath(pathStr);
		return this.add(path, key, value, SearchOperation.NOT_IN);
	}
	
	public Predicate notIn(Class<?> clazz, String key, Object value)
	{
		Join<Object,Object> join = this.getJoin(clazz);
		return super.add(join, key, value, SearchOperation.NOT_IN);
	}
}
