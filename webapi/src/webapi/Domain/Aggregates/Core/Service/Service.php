<?php
namespace webapi\Domain\Aggregates\Core\Service;

use webapi\CrossCuttingIoc\BootService;
use webapi\CrossCuttingIoc\BootStrapper;


class Service extends BootService
{
    public function __construct() 
    {
        parent::__construct();
    }
}
?>