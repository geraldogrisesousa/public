package ba.com.grisecorp.domain.aggregates.project.project.services;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import ba.com.grisecorp.domain.core.Service.GenericService;
import ba.com.grisecorp.domain.aggregates.project.project.Project;
import ba.com.grisecorp.domain.aggregates.project.project.repository.IProjectRepository;
import ba.com.grisecorp.domain.aggregates.project.status.Status;

@Service
public class ProjectService extends GenericService<Project> implements IProjectService {

	
	@Autowired
	private IProjectRepository _projectRepository;
	
	@Override
	public void InsertProject(Project project)
	{
		_projectRepository.save(project);
	}

	@Override
	public void UpdateProject(Project project) 
	{
		_projectRepository.save(project);
	}

	@Override
	public void DeleteProject(int id_project)
	{
		_projectRepository.deleteById(id_project);
	}
	
	@Override
	public Project DetailProject(int id_project) 
	{
		return _projectRepository.findById(id_project).get();
	}

	@Override
	public List<Project> GetAll() 
	{
		return getAll(_projectRepository.findAll());
	}
	
	public List<Project> GetAll(Project filtro) 
	{
		return GetAllByFilter(_projectRepository, filtro);
	}
	
	public List<Project> GetByPrograma(int id_programa) 
	{
		return _projectRepository.findByPrograma(id_programa);
	}
	
	public List<Project> GetByStatus(int id_status) 
	{
		return _projectRepository.findByStatus(id_status);
	}
	
	public List<Project> GetByName(String name) 
	{
		return toList(_projectRepository.getByName(name));
	}
	
	/*public List<Project> GetByName(String name)
	{
		query = query.from(Project.class);
		query = query.Join("Programa");
		return query.where(query.like("Programa.GrupoEtapa","name", name)).toList();
	}*/
	
	

}
