<?php

function check_token() {
    $headers = getallheaders();
    if (array_key_exists("token", $headers)) {
        $message = $headers['token'];
        return $message == 'maxitoners2021-cJ0wK8uC7kK2aC8p';
    }
    return false;
}

function is_set_and_not_empty($campos, $is_get) {
    foreach ($campos as $campo) {
        if ($is_get) {
            if (!isset($_GET[$campo])) return false;
            if (strlen(trim($_GET[$campo])) == 0) return false;
        } else {
            if (!isset($_POST[$campo])) return false;
            if (strlen(trim($_POST[$campo])) == 0)  return false;
        }
    }
    return true;
}

function not_exceeds_str($var, $max) {
    if (strlen($var) > $max) {
        return false;
    }
    return true;
}
