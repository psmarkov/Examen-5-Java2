<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">

    <title>Horoscopo  Inicio de Sesion </title>
    <link rel="stylesheet" href="./Styles/styles.css">

</head>
<body>

<div class="container">
    <h3><i class="bi bi-brilliance"></i> Horoscopo Chino </h3>
    <br>

    <h1>Bienvenido a Horoscopo Chino </h1>
    <h2>Inicio de sesion </h2>

    <form action = "IniciarSesion" method="POST">
        <p><input type="text" name = "nombre" placeholder="UserName"></p>
        <p><input type="text" name = "pass" placeholder="Password"></p>
        <br><br>
        <button type="submit">Submit</button>
    </form>

    <br>

    <p>© 2024 Horoscopo  Chino. All Rights Reserved | Design by Paula</p>
</div>

<script
        src = "https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js">

</script>

</body>
</html>