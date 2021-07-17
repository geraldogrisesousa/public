<?php
namespace webapi\CrossCuttingIoc;

use  webapi\CrossCuttingIoc\BootStrapper;


class BootService 
{
    protected $boot;
    public function __construct() 
    {
       $this->boot = $this->GetDependencies();
    }

    private function GetDependencies()
    {
         $containerBuilder = new \DI\ContainerBuilder();
         $containerBuilder->useAutowiring(true);
         $containerBuilder->addDefinitions(BootStrapper::RegisterServices());
         $container = $containerBuilder->build();
         return $container;
    }
   
}
?>
