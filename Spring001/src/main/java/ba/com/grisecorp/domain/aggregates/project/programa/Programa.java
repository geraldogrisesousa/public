package ba.com.grisecorp.domain.aggregates.project.programa;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import ba.com.grisecorp.domain.aggregates.project.grupoetapa.GrupoEtapa;
import ba.com.grisecorp.domain.aggregates.project.project.Project;


@Entity
public class Programa
{ 

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_programa")
	private int idprograma;

	@Column(name="name")
	private String name;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_grupoetapa")
    private GrupoEtapa grupoetapa;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "programa")
	private List<Project> projetos;

	public int getIdprograma() 
	{
		return this.idprograma;
	}
	
	public void setIdprograma(int idprograma) 
	{
		this.idprograma = idprograma;
	}
	
	public String getName() 
	{
		return this.name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public GrupoEtapa getGrupoEtapa() {
		return grupoetapa;
	}

	public void setGrupoEtapa(GrupoEtapa grupoetapa) {
		this.grupoetapa = grupoetapa;
	}

	public List<Project> getProjetos() {
		return projetos;
	}

	public void setProjetos(List<Project> projetos) {
		this.projetos = projetos;
	}
	
}
