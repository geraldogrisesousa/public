<?php
namespace webapi\CrossCutting\Mapper;

use \stdClass;
use \ReflectionClass;
use \ReflectionObject;
use webapi\CrossCutting\Mapper\IMapper;


class Mapper implements IMapper
{
      
	function ConvertTo($sourceObject, $targetObject)
	{
		$sourceReflection = new ReflectionObject($sourceObject);
		$targetReflection = new ReflectionObject($targetObject);
		$sourceProperties = $sourceReflection->getProperties();
		foreach ($sourceProperties as $sourceProperty) {
			$sourceProperty->setAccessible(true);
			$name = $sourceProperty->getName();
			$value = $sourceProperty->getValue($sourceObject);
			if ($targetReflection->hasProperty($name)) {
				$targetProperty = $targetReflection->getProperty($name);
				$targetProperty->setAccessible(true);
				$targetProperty->setValue($targetObject,$value);
			} else {
				$targetObject->$name = $value;
			}
		}
		return $targetObject;
	}
}
?>
