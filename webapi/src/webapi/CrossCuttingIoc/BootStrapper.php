<?php
namespace webapi\CrossCuttingIoc;

use DI;

use webapi\CrossCutting\Mapper\IMapper;
use webapi\CrossCutting\Mapper\Mapper;
use webapi\Data\Core\Repository\IRepository;
use webapi\Data\Core\Repository\Repository;

use webapi\Application\Interfaces\IGrupoEtapaAppService;
use webapi\Application\Apps\GrupoEtapaAppService;
use webapi\Domain\Aggregates\GrupoEtapa\GrupoEtapa\Repository\IGrupoEtapaRepository;
use webapi\Data\Repository\GrupoEtapaRepository;
use webapi\Domain\Aggregates\GrupoEtapa\GrupoEtapa\Services\IGrupoEtapaService;
use webapi\Domain\Aggregates\GrupoEtapa\GrupoEtapa\Services\GrupoEtapaService;

class BootStrapper 
{
   public static function RegisterServices()
   {
	  
	  return [
		// Application
		IGrupoEtapaAppService::class => DI\create(GrupoEtapaAppService::class),

        // Domain
		IGrupoEtapaService::class => DI\create(GrupoEtapaService::class),
		IGrupoEtapaRepository::class => DI\create(GrupoEtapaRepository::class),

		// Data
		IRepository::class => DI\create(Repository::class),

		// CrossCutting
		IMapper::class => DI\create(Mapper::class),

	  ];
   } 
}
?>
