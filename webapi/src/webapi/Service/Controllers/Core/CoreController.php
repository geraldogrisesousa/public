<?php
namespace webapi\Service\Controllers\Core;
use webapi\CrossCutting\Mapper\Mapper;
use webapi\CrossCuttingIoc\BootStrapper;
use  webapi\CrossCuttingIoc\BootService;
use \stdClass;
use \ReflectionClass;

class CoreController extends BootService
{
   public $response;
   public function __construct() 
   {
       parent::__construct();
   }

   
   public function ResponseOk($message, $data)
   {
	   return array(
	     "error"=>"false",
		 "statusCode"=>200,
		 "message"=>$message,
		 "data"=>$this->ConvertToJson($data)
	   );
   }
   
   public function ResponseError($error)
   {
	   return array(
	     "error"=>"true",
		 "statusCode"=>500,
		 "message"=>$error->getMessage(),
		 "data"=>null
	   );
   }
   
   private function ConvertToJson($object) {
	 $response = $object;
	 if(is_object($object))
	 {
		$response = $this->ConvertToResponse($object);  
	 }
 
	 if(is_array($object))
	 {
		$response = [];
		foreach($object as $obj)
		{
		  $response[] = $this->ConvertToResponse($obj); 
		}
	 }
	 
	 return json_encode($response);
   }
   
   private function ConvertToResponse($object)
   {
	   $response = new stdClass();
	   $mapper = new Mapper();
	   $response = $mapper->ConvertTo($object, $response);
	   return $response;
   }
 
}
?>
