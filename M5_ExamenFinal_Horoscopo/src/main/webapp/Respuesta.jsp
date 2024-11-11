
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Respuesta del Formulario HOROSCOPO</title>
    <link rel="stylesheet" href="./Styles/styles.css">


</head>
<body>

        <div class="container">

            <h1>Bienvenido a Hosocopo Chino </h1>
            <h2>Los valores son </h2>

            <form action = "MenuSVL" method="get">
                <br>
                <p>UserName: ${nombreUsuario}</p>
                <p>Password: ${passUsuario}</p>
                <br>
                <br>

                <button type="submit">Salir</button>
            </form>

            <br>

            <p>© 2017 Formulario de Contacto. All Rights Reserved | Design by Paula</p>
        </div>

</body>
</html>