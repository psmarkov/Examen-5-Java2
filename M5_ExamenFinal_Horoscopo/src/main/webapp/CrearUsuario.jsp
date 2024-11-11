
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
    <link rel="stylesheet" href="./Styles/styles.css">
    <title>Registro de usuario </title>
</head>

<body>

<div class="container">
    <h3><i class="bi bi-brilliance"></i> Horoscopo Chino </h3>
    <br>

    <h1>Bienvenido a Horoscopo Chino </h1>
    <h2>Registrar un Usuario Nuevo </h2>

    <form action = "CrearUsuario" method="POST">


        <p><input type="text" name = "nombre" placeholder="Nombre"></p>
        <p><input type="text" name = "userName" placeholder="UserName"></p>
        <p><input type="text" name = "pass" placeholder="Password"></p>
        <p><input type="text" name = "email" placeholder="Email"></p>
        <p><input type="text" name = "fNac" placeholder="Fecha de Nac"></p>
        <p><input type="text" name = "signo" placeholder="Signo Horoscopo "></p>O

        <br><br>
        <button type="submit">Submit</button>
    </form>

    <form action = "CrearUsuario" method="POST">
        <br><br>
        <input type="hidden" name="accion" value="buscar" id="miTexto">
        <button type="submit" name="salir" onclick="document.getElementById('miTexto').value = this.name;"><i class="bi bi-check-circle-fill"></i> Regresar al Menu </button>

    </form>




    <br>

    <p>© 2024 Horoscopo  Chino. All Rights Reserved | Design by Paula</p>
</div>

<script
        src = "https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js">

</script>
</body>
</html>
