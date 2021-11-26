package ba.com.grisecorp.domain.aggregates.project.programa.services;

import java.util.List;

import ba.com.grisecorp.domain.aggregates.project.programa.Programa;

public interface IProgramaService {

	public void InsertPrograma(Programa programa);
	
	public void UpdatePrograma(Programa programa);
	
	public void DeletePrograma(int id_programa);
	
	public Programa DetailPrograma(int id_programa);
	
	public List<Programa> GetAll();
	
	List<Programa> getByGrupo(int id_grupo_etapa);
	
}
