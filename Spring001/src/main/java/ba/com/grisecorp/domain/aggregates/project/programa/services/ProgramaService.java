package ba.com.grisecorp.domain.aggregates.project.programa.services;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import ba.com.grisecorp.domain.core.Service.GenericService;
import ba.com.grisecorp.domain.aggregates.project.programa.Programa;
import ba.com.grisecorp.domain.aggregates.project.programa.repository.IProgramaRepository;

@Service
public class ProgramaService extends GenericService<Programa> implements IProgramaService {

	
	@Autowired
	private IProgramaRepository _programaRepository;
	
	@Override
	public void InsertPrograma(Programa programa)
	{
		_programaRepository.save(programa);
	}

	@Override
	public void UpdatePrograma(Programa programa) 
	{
		_programaRepository.save(programa);
	}

	@Override
	public void DeletePrograma(int id_programa)
	{
		_programaRepository.deleteById(id_programa);
	}
	
	@Override
	public Programa DetailPrograma(int id_programa) 
	{
		return _programaRepository.findById(id_programa).get();
	}

	@Override
	public List<Programa> GetAll() 
	{
		return getAll(_programaRepository.findAll());
	}
	
	public List<Programa> GetAll(Programa filtro) 
	{
		return GetAllByFilter(_programaRepository, filtro);
	}
	
	public List<Programa> getByGrupo(int id_grupo_etapa) 
	{
		return toList(_programaRepository.findByGrupo(id_grupo_etapa));
	}
}
