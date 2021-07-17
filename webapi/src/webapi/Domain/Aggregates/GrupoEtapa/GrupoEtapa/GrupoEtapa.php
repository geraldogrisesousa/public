<?php
namespace webapi\Domain\Aggregates\GrupoEtapa\GrupoEtapa;


use webapi\Domain\Aggregates\Core\Entity;

/**
* @Entity
* @Table(name="grupoetapa")
*/
class GrupoEtapa extends Entity 
{
	/**
	* @var integer @id_grupoetapa
	* @Id
    * @Column(name="id_grupoetapa", type="integer")
    * @GeneratedValue(strategy="AUTO")
    */
	private $id_grupoetapa;
	
	
	/**
	*
	* @Column(name="nome", type="string" , length=30) 
	*/
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