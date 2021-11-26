package ba.com.grisecorp.domain.aggregates.project.status;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import ba.com.grisecorp.domain.aggregates.project.project.Project;

@Entity
public class Status
{ 

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_status")
	private int idstatus;

	@Column(name="name")
	private String name;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "status")
	private List<Project> projetos;
	
	public int getIdstatus() 
	{
		return this.idstatus;
	}
	
	public void setIdstatus(int idstatus) 
	{
		this.idstatus = idstatus;
	}
	
	public String getName() 
	{
		return this.name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}

	public List<Project> getProjetos() {
		return projetos;
	}

	public void setProjetos(List<Project> projetos) {
		this.projetos = projetos;
	}
}
