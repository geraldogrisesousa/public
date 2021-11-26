package ba.com.grisecorp.domain.aggregates.project.project.services;

import java.util.List;

import ba.com.grisecorp.domain.aggregates.project.project.Project;

public interface IProjectService {

	public void InsertProject(Project project);
	
	public void UpdateProject(Project project);
	
	public void DeleteProject(int id_project);
	
	public Project DetailProject(int id_project);
	
	public List<Project> GetAll();
	
	public List<Project> GetAll(Project filtro);
	
	public List<Project> GetByName(String name);
	
	public List<Project> GetByPrograma(int id_programa);
	
	public List<Project> GetByStatus(int id_status);
}
