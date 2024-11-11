<%--
  Created by IntelliJ IDEA.
  User: paula
  Date: 30-10-2024
  Time: 21:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
    <link rel="stylesheet" href="./Styles/styles.css">

    <title>Consultar Horoscopo</title>
</head>
<body>

<div class="container">
    <h3><i class="bi bi-brilliance"></i> Horoscopo Chino </h3>
    <br>
    <h1>Conoce cual es tu signo </h1>

    <br>

            <p id="nombreJsp" >Hola  ${nombreJsp}   tu signo es </p>
            <p id="fechNacJsp" style="display: none;">${fechNacJsp}</p>



            <br>
            <h4 id="signoJsp" span style="font-weight: bold;">${signoJsp}</h4>
            <br><br>


    <table class="table table-dark">
        <tbody>

        <tr>
            <h5 >Quieres averiguar el signo de otro usuario ?</h5>
            <form action = "ConsultarHoroscopo" method="POST" >
                <script>
                    document.getElementById("miTexto").value = "buscar";
                </script>

                <p> <input type="hidden" name="accion" value="Signo" id="miTexto3"></p>

                <td>
                    <p><input type="text" name="idUsuario" placeholder="IDUsuarioo" id="miTexto1"></p>
                </td>
                <td>
                    <button type="submit" name="Signo" onclick="document.getElementById('miTexto3').value = this.name;">Buscar</button>
                </td>


            </form>
        </tr>
        </tbody>
    </table>

<br><br> <br>
    <form action="ListarUsuario" method="POST">

        <script>
            document.getElementById("miTexto1").value = "1";
        </script>

        <input type="hidden" name="accion" value="buscar" id="miTexto">
        <button type="submit" name="salir" onclick="document.getElementById('miTexto').value = this.name;"><i class="bi bi-check-circle-fill"></i> Regresar al Menu </button>

    </form>


    <br>

</div>

<script
        src = "https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js">

</script>

</body>
</html>
