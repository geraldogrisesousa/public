<?php
namespace webapi\Application\Models;

class GrupoEtapaModel 
{
	
	private $id_grupoetapa;
	private $nome;
	
	public function getId_grupoetapa(){
		return $this->id_grupoetapa;
	}

	public function setId_grupoetapa($id_grupoetapa){
		$this->id_grupoetapa = $id_grupoetapa;
	}

	public function getNome(){
		return $this->nome;
	}

	public function setNome($nome){
		$this->nome = $nome;
	}
}

?>