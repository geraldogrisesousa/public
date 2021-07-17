<?php
$loader = require __DIR__ . '/vendor/autoload.php';

$app = new \Slim\Slim(array(
   'debug' => true,
));

$path = __DIR__ . "/src/webapi/Service/Routes/";
foreach(scandir($path) as $file){
	if (!in_array($file,array(".","..")))
    {
		require $path.$file;
	}
}

$app->run();
?>