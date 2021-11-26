package ba.com.grisecorp.application.apps.core;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;

public class ApplicationService<S,T> {

	protected ModelMapper _mapper;
	
	public ApplicationService()
	{
		_mapper = new ModelMapper();
	}
	
	public T mapperToModel(S source, Class<T> targetClass) 
	{
		return _mapper.map(source, targetClass);
	}
	
	public S mapperToEntity(T source, Class<S> targetClass) 
	{
		return _mapper.map(source, targetClass);
	}
	
	public List<T> mapperToModel(List<S> source, Class<T> targetClass) {
	    return source
	      .stream()
	      .map(element -> _mapper.map(element, targetClass))
	      .collect(Collectors.toList());
	}
	
	public List<S> mapperToEntity(List<T> source, Class<S> targetClass) {
	    return source
	      .stream()
	      .map(element -> _mapper.map(element, targetClass))
	      .collect(Collectors.toList());
	}

}
