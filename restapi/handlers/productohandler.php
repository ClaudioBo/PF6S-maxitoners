<?php

class ProductoHandler {
    #Borrar producto
    function delete($id) {
        $resp = array(
            'status' => false
        );
        if(check_token()){
            $resp['status'] = borrar_producto($id);
        } else {
            $resp['message'] = "Acceso denegado";
        }
        echo json_encode($resp);
    }

    #Editar producto
    function post($id) {
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
            $resp_error['message'] = 'Faltan argumentos';
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
            $resp_error['message'] = 'Debes ingresar valores numericos';
            echo json_encode($resp_error);
            return;
        }

        if (
            !not_exceeds_str($nombre, 32) ||
            $categoria > 10
        ) {
            $resp_error['message'] = 'Argumentos exceden de los caracteres/numeros permitidos';
            echo json_encode($resp_error);
            return;
        }

        $status = editar_producto($nombre, $cantidad, $precio, $categoria, $id);
        $resp = array(
            'status' => $status,
        );
        echo json_encode($resp);
    }
}

function borrar_producto($id) {
    $query = MySQL::getInstance()->prepare("DELETE FROM productos WHERE id = :id;");
    $query->bindValue(':id', $id, PDO::PARAM_INT);
    return $query->execute();
}

function editar_producto($nombre, $cantidad, $precio, $categoria, $id) {
    $query = MySQL::getInstance()->prepare(
        "UPDATE productos SET 
        nombre=:nombre,
        cantidad=:cantidad,
        precio=:precio,
        categoria=:categoria 
        WHERE id = :id;"
    );
    $query->bindValue(':nombre', $nombre, PDO::PARAM_STR);
    $query->bindValue(':cantidad', $cantidad, PDO::PARAM_INT);
    $query->bindValue(':precio', $precio, PDO::PARAM_INT);
    $query->bindValue(':categoria', $categoria, PDO::PARAM_INT);
    $query->bindValue(':id', $id, PDO::PARAM_INT);
    return $query->execute();
}
