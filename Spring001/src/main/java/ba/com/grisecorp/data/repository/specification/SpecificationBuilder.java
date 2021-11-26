package ba.com.grisecorp.data.repository.specification;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import ba.com.grisecorp.data.repository.specification.enums.SearchOperation;


public class SpecificationBuilder<T> implements Specification<T> {

	private static final long serialVersionUID = 1L;
	private List<SearchCriteria> criteriaList;

	public SpecificationBuilder() {
	    this.criteriaList = new ArrayList<>();
	}
	

	public SpecificationBuilder(List<SearchCriteria> criteriaList) {
	    this.criteriaList = criteriaList;
	}

	public void add(SearchCriteria criteria) {
	    criteriaList.add(criteria);
    }

	@Override
	public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
	    List<Predicate> predicates = new ArrayList<>();
	    PredicateBuilder<T> predicateBuilder = new PredicateBuilder<T>();
	    predicateBuilder.setRoot(root);
	    predicateBuilder.setBuilder(criteriaBuilder);
	    for (SearchCriteria criteria : criteriaList)
	    {
	    	predicates.add(predicateBuilder.checkOperation(criteria));
	    }
	    
	    return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
	}
	

	
}



