<?php
namespace webapi\Data\Repository;

use webapi\Data\Core\Repository\Repository;
use webapi\Domain\Aggregates\GrupoEtapa\GrupoEtapa\Repository\IGrupoEtapaRepository;
class GrupoEtapaRepository  extends Repository implements IGrupoEtapaRepository
{

	public function __construct() {
		parent::__construct('webapi\Domain\Aggregates\GrupoEtapa\GrupoEtapa\GrupoEtapa');
	}
}


?>