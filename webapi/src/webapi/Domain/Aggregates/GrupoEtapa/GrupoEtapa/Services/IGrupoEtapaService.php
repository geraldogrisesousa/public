<?php
namespace webapi\Domain\Aggregates\GrupoEtapa\GrupoEtapa\Services;

interface IGrupoEtapaService
{
	public function InserirGrupoEtapa($grupoEtapa);
	public function AtualizarGrupoEtapa($grupoEtapa);
	public function DeletarGrupoEtapa($id_grupoetapa);
	public function ObterPorId($id_grupoetapa);
	public function ObterGrupoPorNome($nome);
	public function ListarGrupoEtapa();
}
?>