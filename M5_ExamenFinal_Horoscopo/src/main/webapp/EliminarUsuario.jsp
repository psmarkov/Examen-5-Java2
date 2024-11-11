

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="org.example.m5_examenfinal_horoscopo.DAO.Dto.UsuarioDto" %>



<html>

<head>
    
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">

        <link rel="stylesheet" href="./Styles/ListarUsuarios.css">
        <title>Eliminar Usuarios</title>

</head>


<body>
<div class="container" >

    <h4><i class="bi bi-brilliance"></i> Horoscopo Chino </h4>
    <br>

    <h1>Lista de Usuarios Registrados que puedes Eliminar</h1>
    <br>

        <table class="table table-dark">
          <thead>
              <tr>
                <th scope="col">#</th>
                <th scope="col">Nombre</th>
                <th scope="col">Username</th>
                <th scope="col">Email</th>
                <th scope="col">Fecha Nac</th>
                <th scope="col">Signo</th>
              </tr>
          </thead>
            <tbody>
            <%

                List<UsuarioDto> milistaJSP = (List<UsuarioDto>) request.getAttribute("lista");

                int i = 0;

                    for (UsuarioDto empleado : milistaJSP) {
                      i = i+1;

            %>
                        <tr>
                            <th scope="row"><%= empleado.getId()%> </th>
                            <td><%= empleado.getNombre() %></td>
                            <td><%= empleado.getUsername() %></td>
                            <td><%= empleado.getEmail() %></td>
                            <td><%= empleado.getFechaNacimiento() %></td>
                            <td><%= empleado.getHoroscopoId() %></td>
                        </tr>
            <% } %>

            </tbody>

        </table>

    <table class="table table-dark">
        <tbody>
        <tr>
            <form action = "EliminarUsuario" method="POST">
                <script>
                    document.getElementById("irEliminar").value = "buscar";

                </script>
                <td><p><input type="text" name = "idUsuario" placeholder="IDUsuarioo" id="miTexto1"></p></td>
                <td><button type="submit">Buscar</button></td>

            </form>
        </tr>
        </tbody>
    </table>

    <br>
    <br>

    <!-- Div para mostrar el detalle del usuario, se muestra si "mostrarDetalle" es verdadero detalleUsuario-->
   <div name="mostrarDetalle" style="display:<%= (request.getAttribute("mostrarDetalle") != null && request.getAttribute("mostrarDetalle").equals("true")) ? "block" : "none" %>;">

        <h2>Este es el Usuario que vas a Eliminar</h2>
    <br>


    <%
        UsuarioDto miUsuario = (UsuarioDto) request.getAttribute("usuarioEliminar");
        if (miUsuario != null) {
    %>
    <table class="table table-dark">
        <tbody>
        <tr>
            <td>
            <h1 id="indice" >ID : <%= miUsuario.getId() %></h1>
            <p>Nombre           : <%= miUsuario.getNombre() %></p>
            <p>Username         : <%= miUsuario.getUsername() %></p>
            <p>Email            : <%= miUsuario.getEmail() %></p>
            <p>Fecha de Nac     : <%= miUsuario.getFechaNacimiento() %></p>
            <p>Signo Horoscopo  : <%= miUsuario.getHoroscopoId() %></p>

            </td>
            <td>
                <form action = "EliminarUsuario" method="POST">
                    <script>
                        document.getElementById("miTexto1").value = "1";
                    </script>
                    <input type="hidden" name="accion" value="buscar" id="irEliminar">

                    <button type="submit" name="Eliminar" onclick="document.getElementById('irEliminar').value = this.name;"><i class="bi bi-check-circle-fill"></i>Ir ELiminar el Usuario</button>

                </form>
            </td>
        </tr>
        </tbody>
    </table>
    <% } %>

   </div>
    <!--  Fin del div que oculta el detalle del usuario -->
    <br><br>


   <form action = "ListarUsuario" method="POST">

        <script>
            document.getElementById("miTexto1").value = "1";
            document.getElementById("irEliminar").value = "buscar";

        </script>

        <input type="hidden" name="accion" value="buscar" id="miTexto">
        <button type="submit" name="salir" onclick="document.getElementById('miTexto').value = this.name;"><i class="bi bi-check-circle-fill"></i> Regresar al Menu </button>

    </form>


</div>
        <script
                src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous">

        </script>

</body>
</html>
