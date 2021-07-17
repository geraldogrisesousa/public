<?php
namespace webapi\Data\Core\Repository;
use Doctrine\ORM\EntityManager;
use Doctrine\ORM\Tools\Setup;
use webapi\Data\Core\Repository\IRepository;
use webapi\CrossCuttingIoc\BootService;

class Repository extends BootService  implements IRepository
{
   public $entityManager;
   private $entityPath;
   
   public function __construct($entityPath) 
   {
	  parent::__construct();
	  $this->entityPath = $entityPath;
	  $this->entityManager = $this->createEntityManager ();
   }

   public function createEntityManager() {

	   $path = array (
		 ''
	   );
	   $devMode = true;
       $config = Setup::createAnnotationMetadataConfiguration ( $path, $devMode );

	   $connectionOptions =  array (
		 'dbname' => 'sgep',
		 'user' => 'root',
		 'password' => '',
		 'host' => 'localhost',
		 'driver' => 'pdo_mysql'
	   );

	   return EntityManager::create ( $connectionOptions, $config );
	}
		
	public function insert($object){
		$this->entityManager->persist($object);
		$this->entityManager->flush();
	}
	
	public function update($object){
		$this->entityManager->merge($object);
		$this->entityManager->flush();
	}
	
	public function delete($id){
		$object = $this->findById($id);
		$this->entityManager->remove($object);
		$this->entityManager->flush();
	}
	
	public function deleteObject($object){
		$this->entityManager->remove($object);
		$this->entityManager->flush();
	}
	
	public function findById($id){
		return $this->entityManager ->find ( $this->entityPath ,$id) ;
	}
	
	public function findAll(){
		$collection = $this->entityManager ->getRepository ( $this->entityPath )->findAll ();

		$data = array ();
		foreach ( $collection as $obj ) {
			$data [] = $obj;
		}

		return $data;
	}
	
	public function findOne($object)
	{
		$search = (array) $object;
		return $this->entityManager ->getRepository ( $this->entityPath )->findOneBy($search);
	}
	
	public function findBy($object)
	{
		$search = $this->getSearch($object);
		return $this->entityManager ->getRepository ( $this->entityPath )->findBy($search);
	}
	
	public function executeQuery($sql)
	{
		$query = $this->entityManager->createQuery($sql);
		return $query->getResult();
	}
	
	private function getSearch($object)
	{
		$search = $object;
		if(!is_array($search))
			$search = (array) $object;
		return $search;
	}
}

?>