package ba.com.grisecorp.service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ba.com.grisecorp.application.apps.ProjectAppService;
import ba.com.grisecorp.application.model.ProjectModel;
import ba.com.grisecorp.service.controller.core.Controller;
import ba.com.grisecorp.service.controller.core.Response;


@RestController
@RequestMapping(value = "/api/v1/")
@CrossOrigin("*")
public class ProjectController extends Controller
{
	@Autowired
	private ProjectAppService _projectAppService;
	
	@PostMapping(value = "/InserirProjeto")
	public  ResponseEntity<Response>  insertProject(@RequestBody ProjectModel project) 
	{
		try 
		{
			_projectAppService.InsertProject(project);
			 return ResponseOk();
		}
		catch(Exception ex)
		{
			return ResponseError(ex);
		}
	}
	
	@PostMapping(value = "/AtualizarProjeto")
	public ResponseEntity<Response> updateProject(@RequestBody ProjectModel project)
	{
		try 
		{
			_projectAppService.UpdateProject(project);
			return ResponseOk();
		}
		catch(Exception ex)
		{
			return ResponseError(ex);
		}
	}
	
	@PostMapping(value = "/DeletarProjeto")
	public ResponseEntity<Response> deleteProject(@PathVariable int id) 
	{
		try 
		{
			_projectAppService.DeleteProject(id);
			return ResponseOk();
		}
		catch(Exception ex)
		{
			return ResponseError(ex);
		}
	}
	
	@GetMapping(value = "/DetalharProjeto/{id}")
	public ResponseEntity<Response> detalharProjeto(@PathVariable int id)
	{
		try 
		{
			return ResponseOk( _projectAppService.DetailProject(id));
		}
		catch(Exception ex)
		{
			return ResponseError(ex);
		}
	}
	
	@GetMapping(value = "/ListarProjetos")
	public ResponseEntity<Response> getAll()
	{
		try 
		{
			return ResponseOk(_projectAppService.GetAll());
		}
		catch(Exception ex)
		{
			return ResponseError(ex);
		}
	}
	
	@PostMapping(value = "/ListarProjetosFiltro")
	public ResponseEntity<Response> getAll(@RequestBody ProjectModel project)
	{
		try 
		{  
			return ResponseOk(_projectAppService.GetAll(project));
		}
		catch(Exception ex)
		{
			return ResponseError(ex);
		}
	}
	
	@GetMapping(value = "/ListarPorNome/{name}")
	public ResponseEntity<Response> getByName(@PathVariable String name)
	{
		try 
		{
			return ResponseOk(_projectAppService.GetByName(name));
		}
		catch(Exception ex)
		{
			return ResponseError(ex);
		}
	}
	
	@GetMapping(value = "/ListarPorPrograma/{id_programa}")
	public ResponseEntity<Response> getByPrograma(@PathVariable int id_programa)
	{
		try 
		{
			return ResponseOk(_projectAppService.GetByPrograma(id_programa));
		}
		catch(Exception ex)
		{
			return ResponseError(ex);
		}
	}
	
	@GetMapping(value = "/ListarPorStatus/{id_status}")
	public ResponseEntity<Response> getByStatus(@PathVariable int id_status)
	{
		try 
		{
			return ResponseOk(_projectAppService.GetByStatus(id_status));
		}
		catch(Exception ex)
		{
			return ResponseError(ex);
		}
	}
}
