<?php
namespace webapi\Service\Routes;

use webapi\Application\Models\GrupoEtapaModel;
use webapi\Service\Controllers\GrupoEtapaController;
use webapi\CrossCutting\Mapper\Mapper;


$mapper = new Mapper();
$grupoCtrl = new GrupoEtapaController();
$model = new GrupoEtapaModel();

$app->get ( '/obter-grupo(/(:id))', function ($id) use  ($grupoCtrl){
	echo json_encode($grupoCtrl->ObterPorId($id));
});

$app->post ( '/obter-grupo-por-nome(/)', function () 
  use  ($grupoCtrl, $mapper, $model){	
	$app = \Slim\Slim::getInstance ();
	$json = json_decode ( $app->request()->getBody ());
	$nome = $json->nome;
	echo json_encode($grupoCtrl->ObterGrupoPorNome($nome));
});

$app->get ( '/listar-grupo', function () use  ($grupoCtrl){
	echo json_encode($grupoCtrl->ListarGrupoEtapa());
});

$app->post ( '/inserir-grupo(/)', function () 
  use  ($grupoCtrl, $mapper, $model){
	$app = \Slim\Slim::getInstance ();
	$json = json_decode ( $app->request ()->getBody ());
	$model = $mapper->ConvertTo($json, $model);
	echo json_encode ($grupoCtrl->InserirGrupoEtapa($model));
});

$app->post ( '/atualizar-grupo(/)', function () 
  use  ($grupoCtrl, $mapper, $model){
	$app = \Slim\Slim::getInstance ();
	$json = json_decode ( $app->request ()->getBody ());
	$model = $mapper->ConvertTo($json, $model);
	echo json_encode ($grupoCtrl->AtualizarGrupoEtapa($model));
});

$app->post ( '/deletar-grupo(/)', function () 
  use  ($grupoCtrl, $mapper, $model){
	$app = \Slim\Slim::getInstance ();
	$json = json_decode ( $app->request ()->getBody ());
	$id = $json->id;
	echo json_encode ($grupoCtrl->DeletarGrupoEtapa($id));
});
?>
