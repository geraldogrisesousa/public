<?php
namespace webapi\Domain\Aggregates\GrupoEtapa\GrupoEtapa\Services;

use webapi\CrossCutting\Mapper\IMapper;
use webapi\Domain\Aggregates\GrupoEtapa\GrupoEtapa\GrupoEtapa;
use webapi\Domain\Aggregates\GrupoEtapa\GrupoEtapa\Repository\IGrupoEtapaRepository;
use webapi\Domain\Aggregates\Core\Service\Service;
use webapi\Domain\Aggregates\GrupoEtapa\GrupoEtapa\Services\IGrupoEtapaService;
use \stdClass;

class GrupoEtapaService extends Service implements IGrupoEtapaService
{
	private $repository;
	private $entity;
	private $mapper;
	
	public function __construct() 
	{
		parent::__construct();
		$this->entity = new GrupoEtapa();
		$this->mapper =  $this->boot->get(IMapper::class);
		$this->repository = $this->boot->get(IGrupoEtapaRepository::class);
	}

	public function InserirGrupoEtapa($grupoEtapa)
	{
		$this->entity = $this->mapper->ConvertTo($grupoEtapa, $this->entity);
		$this->repository->insert($this->entity);
	}
	
	public function AtualizarGrupoEtapa($grupoEtapa)
	{
		$this->entity = $this->mapper->ConvertTo($grupoEtapa, $this->entity);
		$this->repository->update($this->entity);
	}
	
	public function DeletarGrupoEtapa($id_grupoetapa)
	{
		$this->repository->delete($id_grupoetapa);
	}
	
	public function ObterPorId($id_grupoetapa)
	{
		return $this->repository->findById($id_grupoetapa);
	}
	
	public function ObterGrupoPorNome($nome)
	{
		$search = new stdClass();
		$search->nome = $nome;
		return $this->repository->findBy($search);
	}
	
	public function ListarGrupoEtapa()
	{
		return $this->repository->findAll();
	}
}
?>