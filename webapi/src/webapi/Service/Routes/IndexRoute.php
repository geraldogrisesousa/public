<?php
namespace webapi\Service\Routes;

$app->get ( '/', function () {
	echo json_encode ( [
			"api" => "Web Api",
			"version" => "1.0.0"
	]);
});
?>