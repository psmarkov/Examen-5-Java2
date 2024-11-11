
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="org.example.m5_examenfinal_horoscopo.DAO.Dto.UsuarioDto" %>
<%@ page import="java.util.Date" %>

<html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">

  <title>Horoscopo  Buscar un Usuario  </title>
  <link rel="stylesheet" href="./Styles/styles.css">

</head>
<body>

      <div class="container">
            <h3><i class="bi bi-brilliance"></i> Horoscopo Chino </h3>
            <br>
            <h1>Consultar por un Usuario </h1>

            <table class="table table-dark">
              <tbody>
                    <tr>
                       <form action = "BuscarUsuario" method="POST">
                           <script>
                               document.getElementById("miTexto").value = "buscar";
                           </script>
                            <td><p><input type="text" name = "idUsuario" placeholder="IDUsuarioo" id="miTexto1"></p></td>
                            <td><button type="submit">Buscar</button></td>

                       </form>
                    </tr>
                </tbody>
            </table>

        <br>
        <br>


          <%
            UsuarioDto miUsuario = (UsuarioDto) request.getAttribute("Encontrado");
            if (miUsuario != null) {
          %>

        <h1>ID : <%= miUsuario.getId() %></h1>
        <p>Nombre           : <%= miUsuario.getNombre() %></p>
        <p>Username         : <%= miUsuario.getUsername() %></p>
        <p>Email            : <%= miUsuario.getEmail() %></p>
        <p>Fecha de Nac     : <%= miUsuario.getFechaNacimiento() %></p>
        <p>Signo Horoscopo  : <%= miUsuario.getHoroscopoId() %></p>
        <% } %>

        <br><br>


          <form action = "BuscarUsuario" method="POST">

              <script>
                  document.getElementById("miTexto1").value = "1";
              </script>

              <input type="hidden" name="accion" value="buscar" id="miTexto">
              <button type="submit" name="salir" onclick="document.getElementById('miTexto').value = this.name;"><i class="bi bi-check-circle-fill"></i> Regresar al Menu </button>

          </form>

      </div>

</body>
</html>
