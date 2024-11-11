
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>   <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
    <link rel="stylesheet" href="./Styles/MenuUsuario.css">

    <title>Horoscopo  Inicio de Sesion </title>
    <style>

    </style>
</head>
<body>
<div class="container">
    <h4><i class="bi bi-brilliance"></i> Horoscopo Chino </h4>
    <br>

    <h1>Gestión de usuarios</h1>
    <br>

    <form action="MenuSVL" method="post">
        <input type="hidden" name="accion" value="buscar" id="miTexto">


    <button type="submit" name="Buscar" onclick="document.getElementById('miTexto').value = this.name;"><i class="bi bi-check-circle-fill"></i> Buscar Usuario</button>
    <button type="submit" name="Listar" onclick="document.getElementById('miTexto').value = this.name;"><i class="bi bi-check-circle-fill"></i> Listar Usuarios</button>

    <button type="submit" name="Registrar" onclick="document.getElementById('miTexto').value = this.name;"><i class="bi bi-check-circle-fill"></i> Registrar Usuarios</button>
    <button type="submit" name="Modificar" onclick="document.getElementById('miTexto').value = this.name;"><i class="bi bi-check-circle-fill"></i> Modificar Usuario</button>
    <button type="submit" name="Eliminar" onclick="document.getElementById('miTexto').value = this.name;"><i class="bi bi-check-circle-fill"></i> Eliminar Usuario</button>
     <button type="submit" name="Horoscopo" onclick="document.getElementById('miTexto').value = this.name;"><i class="bi bi-check-circle-fill"></i> Consulta tu Horoscopo</button>

    <br><br><br><br><br>


    <button type="submit" name="Salir" onclick="document.getElementById('miTexto').value = this.name;" class="red-button"><i class="bi bi-check-circle-fill"></i> Salir</button>
</Form>

</div>

<script
        src = "https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js">

</script>

</body>
</html>
