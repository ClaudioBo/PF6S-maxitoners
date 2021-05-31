<?php
require("api/toro.php");
require("lib/mysql.php");
require("lib/validaciones.php");
require("handlers/hellohandler.php");
require("handlers/productohandler.php");
require("handlers/productoshandler.php");

//Error
ToroHook::add("404",  function () {
    echo json_encode(array(
        'status' => 'false',
        'message' => 'No encontrado',
    ));
});

// Rutas
Toro::serve(
    array(
        "/" => "HelloHandler",
        "/producto" => "ProductosHandler",
        "/producto/:number" => "ProductoHandler",
    )
);
