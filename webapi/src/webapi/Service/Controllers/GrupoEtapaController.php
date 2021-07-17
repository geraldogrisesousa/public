<?php
namespace webapi\Service\Controllers;

use webapi\Service\Controllers\Core\CoreController;
use webapi\Application\Interfaces\IGrupoEtapaAppService;

class GrupoEtapaController extends CoreController
{
	private $appService;
	
	public function __construct() 
	{
		parent::__construct();
	    $this->appService =  $this->boot->get(IGrupoEtapaAppService::class);
	}
	
	public function InserirGrupoEtapa($grupoEtapa)
	{
		try
		{
			$this->appService->InserirGrupoEtapa($grupoEtapa);
			return $this->ResponseOk("Registro inserido com sucesso", null);
	    }
		catch(Exception $ex)
		{
			return $this->ResponseError($ex);
		}
	}
	
	public function AtualizarGrupoEtapa($grupoEtapa)
	{
		try
		{
			$this->appService->AtualizarGrupoEtapa($grupoEtapa);
			return $this->ResponseOk("Registro atualizado com sucesso", null);
	    }
		catch(Exception $ex)
		{
			return $this->ResponseError($ex);
		}
	}
	
	public function DeletarGrupoEtapa($id_grupoetapa)
	{
		try
		{
			$this->appService->DeletarGrupoEtapa($id_grupoetapa);
			return $this->ResponseOk("Registro removido com sucesso", null);
	    }
		catch(Exception $ex)
		{
			return $this->ResponseError($ex);
		}
	}
	
	public function ObterPorId($id_grupoetapa)
	{
		try
		{
			$data = $this->appService->ObterPorId($id_grupoetapa);
			return $this->ResponseOk("Registro obtido com sucesso", $data);
	    }
		catch(Exception $ex)
		{
			return $this->ResponseError($ex);
		}
	}
	
	public function ObterGrupoPorNome($nome)
	{
		try
		{
			$data = $this->appService->ObterGrupoPorNome($nome);
			return $this->ResponseOk("Registro obtido com sucesso", $data);
	    }
		catch(Exception $ex)
		{
			return $this->ResponseError($ex);
		}
	}
	
	public function ListarGrupoEtapa()
	{
		try
		{
			$data = $this->appService->ListarGrupoEtapa();
			return $this->ResponseOk("Registros obtidos com sucesso", $data);
	    }
		catch(Exception $ex)
		{
			return $this->ResponseError($ex);
		}
	}
}
?>
