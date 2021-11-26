package ba.com.grisecorp.domain.aggregates.project.grupoetapa;

import java.util.List;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import ba.com.grisecorp.domain.aggregates.project.programa.Programa;

@Entity(name="grupoetapa")
public class GrupoEtapa
{ 

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_grupoetapa")
	private int idgrupoetapa;

	@Column(name="name")
	private String name;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "grupoetapa")
	private List<Programa> programas;
	
	public int getIdgrupoetapa() 
	{
		return this.idgrupoetapa;
	}
	
	public void setId_grupo_etapa(int idgrupoetapa) 
	{
		this.idgrupoetapa = idgrupoetapa;
	}
	
	public String getName() 
	{
		return this.name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}

	public List<Programa> getProgramas() {
		return programas;
	}

	public void setPrograma(List<Programa> programas) {
		this.programas = programas;
	}
	
	
}
