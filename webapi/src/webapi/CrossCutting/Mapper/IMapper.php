<?php
namespace webapi\CrossCutting\Mapper;
interface IMapper
{
    public function ConvertTo($sourceObject, $targetObject);
}

?>