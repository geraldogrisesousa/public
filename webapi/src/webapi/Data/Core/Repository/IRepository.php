<?php 
namespace webapi\Data\Core\Repository;
interface IRepository
{
    public function insert($object);
    public function update($object);
    public function delete($id);
    public function deleteObject($object);
    public function findById($id);
    public function findAll();
    public function findOne($object);
    public function findBy($object);
    public function executeQuery($query);
}
?>