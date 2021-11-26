package ba.com.grisecorp.data.repository.specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import ba.com.grisecorp.data.repository.specification.enums.SearchOperation;

public class PredicateBuilder<T> {
	private Root<?> root;
	private CriteriaBuilder builder;
	
	public Root<?> getRoot() {
		return root;
	}

	public void setRoot(Root<?> root) {
		this.root = root;
	}

	public CriteriaBuilder getBuilder() {
		return builder;
	}

	public void setBuilder(CriteriaBuilder builder) {
		this.builder = builder;
	}
	
	public Predicate checkOperation(SearchCriteria criteria)
	{
		return this.checkOperation(criteria, this.root);
	}

	public Predicate checkOperation(SearchCriteria criteria, Root<?> clazz )
	{
		return this.checkOperation(criteria, clazz );
	}
	
	public Predicate checkOperation(SearchCriteria criteria, Path pathClass )
	{
		String key = criteria.getKey();
		Object value = criteria.getValue();
		SearchOperation operation = criteria.getOperation();
		Predicate predicate = null;
		switch(operation)
		{
			case GREATER_THAN:
				predicate = this.builder.greaterThan(pathClass.get(key), value.toString());
			break;
			case LESS_THAN:
				predicate = this.builder.lessThan(pathClass.get(key), value.toString());
			    break;
		    case GREATER_THAN_EQUAL:
		    	predicate = this.builder.greaterThanOrEqualTo(pathClass.get(key), value.toString());
			    break;
		    case LESS_THAN_EQUAL:
		    	predicate = this.builder.lessThanOrEqualTo(pathClass.get(key), value.toString());
			    break;
		    case NOT_EQUAL:
		    	predicate = this.builder.notEqual(pathClass.get(key), value.toString());
			    break;
		    case EQUAL:
		    	predicate = this.builder.equal(pathClass.get(key), value.toString());
			    break;
		    case LIKE:
		    	predicate = this.builder.like(pathClass.get(key), "%" + value.toString().toLowerCase() + "%");
			    break;
		    case START:
		    	predicate = this.builder.like(pathClass.get(key),  value.toString().toLowerCase() + "%");
			    break;
		    case END:
		    	predicate = this.builder.like(pathClass.get(key), "%" + value.toString().toLowerCase());
			    break;
		    case IN:
		    	predicate = this.builder.in(pathClass.get(key)).value(value);
			    break;
		    case NOT_IN:
		    	predicate = this.builder.not(pathClass.get(key)).in(value);
			    break;
		}

		return predicate;
	}
}
