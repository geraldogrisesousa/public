package ba.com.grisecorp.domain.aggregates.project.grupoetapa.services;

import java.util.List;

import ba.com.grisecorp.domain.aggregates.project.grupoetapa.GrupoEtapa;

public interface IGrupoEtapaService {

	public void InsertGrupoEtapa(GrupoEtapa grupo);
	
	public void UpdateGrupoEtapa(GrupoEtapa grupo);
	
	public void DeleteGrupoEtapa(int id_grupo);
	
	public GrupoEtapa DetailGrupoEtapa(int id_grupo);
	
	public List<GrupoEtapa> GetAll();
}
