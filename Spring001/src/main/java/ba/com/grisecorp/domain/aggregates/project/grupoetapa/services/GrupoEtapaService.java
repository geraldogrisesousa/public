package ba.com.grisecorp.domain.aggregates.project.grupoetapa.services;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import ba.com.grisecorp.domain.core.Service.GenericService;
import ba.com.grisecorp.domain.aggregates.project.grupoetapa.GrupoEtapa;
import ba.com.grisecorp.domain.aggregates.project.grupoetapa.repository.IGrupoEtapaRepository;

@Service
public class GrupoEtapaService extends GenericService<GrupoEtapa> implements IGrupoEtapaService {

	
	@Autowired
	private IGrupoEtapaRepository _grupoetapaRepository;
	
	@Override
	public void InsertGrupoEtapa(GrupoEtapa grupo)
	{
		_grupoetapaRepository.save(grupo);
	}

	@Override
	public void UpdateGrupoEtapa(GrupoEtapa grupo) 
	{
		_grupoetapaRepository.save(grupo);
	}

	@Override
	public void DeleteGrupoEtapa(int id_grupo_etapa)
	{
		_grupoetapaRepository.deleteById(id_grupo_etapa);
	}
	
	@Override
	public GrupoEtapa DetailGrupoEtapa(int id_grupo_etapa) 
	{
		return _grupoetapaRepository.findById(id_grupo_etapa).get();
	}

	@Override
	public List<GrupoEtapa> GetAll() 
	{
		return getAll(_grupoetapaRepository.findAll());
	}

}
