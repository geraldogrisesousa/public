package ba.com.grisecorp.domain.aggregates.project.project;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import ba.com.grisecorp.domain.aggregates.project.programa.Programa;
import ba.com.grisecorp.domain.aggregates.project.status.Status;

@Entity
public class Project
{ 

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_project")
	private int idproject;

	@Column(name="name")
	private String name;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_programa")
    private Programa programa;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_status")
    private Status status;

	public int getIdproject() {
		return idproject;
	}

	public void setIdproject(int idproject) {
		this.idproject = idproject;
	}

	public String getName() 
	{
		return this.name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}

	public Programa getPrograma() {
		return programa;
	}

	public void setPrograma(Programa programa) {
		this.programa = programa;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
	
}
