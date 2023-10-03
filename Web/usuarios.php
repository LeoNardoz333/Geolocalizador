<?php
require("conexion.php");
$user=$_GET['usuario'];
$pass=$_GET['pass'];
$usuario=$conexion->query("select us.id, us.nombre, us.apellidoP, us.apellidoM, u.usuario, us.pass, us.permisos 
from users us join usuario u on us.id = u.fkUsers where u.usuario='".$user."' and us.pass='".$pass."'");
while($fila=$usuario->fetch_array()){
    echo $fila['id']."も".$fila['nombre']."も".$fila['apellidoP'].
    "も".$fila['apellidoM']."も".$fila['usuario']."も".$fila['pass']."も".$fila['permisos'];
}

$conexion->close();