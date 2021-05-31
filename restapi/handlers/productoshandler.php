<?php

class ProductosHandler {
    #Cargar todos los productos
    function get() {
        $resp = array(
            'status' => false
        );
        if (check_token()) {
            $resp['status'] = true;
            $resp['products'] = cargar_productos();
        } else {
            $resp['message'] = "Acceso denegado";
        }
        echo json_encode($resp);
    }

    #Agregar producto
    function post() {
        $resp = array(
            'status' => false,
        );

        if(!check_token()){
            $resp['message'] = "Acceso denegado";
            echo json_encode($resp);
            return;
        }
        $campos = ['nombre', 'cantidad', 'precio', 'categoria'];
        if (!is_set_and_not_empty($campos, false)) {
            $resp['message'] = 'Faltan argumentos';
            echo json_encode($resp);
            return;
        }
        $nombre = trim($_POST['nombre']);
        $cantidad = trim($_POST['cantidad']);
        $precio = trim($_POST['precio']);
        $categoria = trim($_POST['categoria']);
        if (
            !is_numeric($cantidad) ||
            !is_numeric($precio) ||
            !is_numeric($categoria)
        ) {
            $resp['message'] = 'Debes ingresar valores numericos';
            echo json_encode($resp);
            return;
        }

        if (
            !not_exceeds_str($nombre, 32) ||
            $categoria > 10
        ) {
            $resp['message'] = 'Argumentos exceden de los caracteres/numeros permitidos';
            echo json_encode($resp);
            return;
        }

        $id_insertado = agregar_producto($nombre, $cantidad, $precio, $categoria);
        $resp['status'] = true;
        $resp['inserted_id'] = intval($id_insertado);
        echo json_encode($resp);
    }
}

function cargar_productos() {
    $result = [];
    $query = MySQL::getInstance()->query("SELECT * FROM productos;");
    while ($row = $query->fetch(PDO::FETCH_ASSOC)) {
        $producto = [];
        $producto['id'] = (int)$row['id'];
        $producto['nombre'] = $row['nombre'];
        $producto['cantidad'] = (int)$row['cantidad'];
        $producto['precio'] = (double)$row['precio'];
        $producto['categoria'] = (int)$row['categoria'];
        array_push($result,$producto);
    }
    return $result;
}

function agregar_producto($nombre, $cantidad, $precio, $categoria) {
    $query = MySQL::getInstance()->prepare("INSERT INTO productos VALUES (NULL,:nombre,:cantidad,:precio,:categoria)");
    $query->bindValue(':nombre', $nombre, PDO::PARAM_STR);
    $query->bindValue(':cantidad', $cantidad, PDO::PARAM_INT);
    $query->bindValue(':precio', $precio, PDO::PARAM_INT);
    $query->bindValue(':categoria', $categoria, PDO::PARAM_INT);
    $query->execute();
    return MySQL::getInstance()->lastInsertId();
}
