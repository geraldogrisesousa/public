<?php
namespace webapi\Application\Interfaces;

interface IGrupoEtapaAppService
{
	public function InserirGrupoEtapa($grupoEtapa);
	public function AtualizarGrupoEtapa($grupoEtapa);
	public function DeletarGrupoEtapa($id_grupoEtapa);
	public function ObterPorId($id_grupoEtapa);
	public function ObterGrupoPorNome($id_grupoEtapa);
	public function ListarGrupoEtapa();
}
?>