package ba.com.grisecorp.application.apps;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ba.com.grisecorp.application.apps.core.ApplicationService;
import ba.com.grisecorp.application.interfaces.IProjectAppService;
import ba.com.grisecorp.application.model.ProjectModel;
import ba.com.grisecorp.domain.aggregates.project.project.Project;
import ba.com.grisecorp.domain.aggregates.project.project.services.ProjectService;

@Service
public class ProjectAppService  extends ApplicationService<Project,ProjectModel> implements IProjectAppService{

	@Autowired
	private ProjectService _projectService;

	@Override
	public void InsertProject(ProjectModel project) 
	{
		_projectService.InsertProject(mapperToEntity(project, Project.class));
	}

	@Override
	public void UpdateProject(ProjectModel project) 
	{
		_projectService.UpdateProject(mapperToEntity(project, Project.class)); 
	}

	@Override
	public void DeleteProject(int id_project) 
	{
		_projectService.DeleteProject(id_project);
	}

	@Override
	public ProjectModel DetailProject(int id_project) 
	{
		return mapperToModel(_projectService.DetailProject(id_project), ProjectModel.class);
	}

	@Override
	public List<ProjectModel> GetAll() 
	{
		return mapperToModel(_projectService.GetAll(), ProjectModel.class);
	}

	@Override
	public List<ProjectModel> GetAll(ProjectModel project) 
	{
		return mapperToModel(_projectService.GetAll(mapperToEntity(project, Project.class)), ProjectModel.class);
	}
	
	@Override
	public List<ProjectModel> GetByName(String name)
	{
		return mapperToModel(_projectService.GetByName(name), ProjectModel.class);
	}
	
	@Override
	public List<ProjectModel> GetByPrograma(int id_programa)
	{
		return mapperToModel(_projectService.GetByPrograma(id_programa), ProjectModel.class);
	}
	
	@Override
	public List<ProjectModel> GetByStatus(int id_status)
	{
		return mapperToModel(_projectService.GetByStatus(id_status), ProjectModel.class);
	}
}
