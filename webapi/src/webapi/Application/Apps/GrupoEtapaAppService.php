<?php
namespace webapi\Application\Apps;

use webapi\Application\Apps\Core\ApplicationService;
use webapi\Application\Interfaces\IGrupoEtapaAppService;
use webapi\Domain\Aggregates\GrupoEtapa\GrupoEtapa\Services\IGrupoEtapaService;

class GrupoEtapaAppService extends ApplicationService implements IGrupoEtapaAppService
{
	private $service;
	
	public function __construct() 
	{
		parent::__construct();
	    $this->service = $this->boot->get(IGrupoEtapaService::class); 
	}
	public function InserirGrupoEtapa($grupoEtapa)
	{
		$this->service->InserirGrupoEtapa($grupoEtapa);
	}
	
	public function AtualizarGrupoEtapa($grupoEtapa)
	{
		$this->service->AtualizarGrupoEtapa($grupoEtapa);
	}
	
	public function DeletarGrupoEtapa($id_grupoetapa)
	{
		$this->service->DeletarGrupoEtapa($id_grupoetapa);
	}
	
	public function ObterGrupoPorNome($nome)
	{
		return $this->service->ObterGrupoPorNome($nome);
	}
	
	public function ObterPorId($id_grupoetapa)
	{
		return $this->service->ObterPorId($id_grupoetapa);
	}
	
	public function ListarGrupoEtapa()
	{
		return $this->service->ListarGrupoEtapa();
	}
}
?>
