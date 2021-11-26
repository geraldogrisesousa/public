package ba.com.grisecorp.application.interfaces;

import java.util.List;

import ba.com.grisecorp.application.model.ProjectModel;

public interface IProjectAppService {

	public void InsertProject(ProjectModel project);
	
	public void UpdateProject(ProjectModel project);
	
	public void DeleteProject(int id_project);
	 
	public ProjectModel DetailProject(int id_project);
	
	public List<ProjectModel> GetAll();
	
	public List<ProjectModel> GetAll(ProjectModel project);
	
	public List<ProjectModel> GetByName(String name);
	
	public List<ProjectModel> GetByPrograma(int id_programa);
	
	public List<ProjectModel> GetByStatus(int id_status);
}
