<?php
namespace webapi\Domain\Aggregates\Core;

use \JsonSerializable;

class Entity implements JsonSerializable 
{
	public function jsonSerialize() {
        return [
            
        ];
    }
}

?>