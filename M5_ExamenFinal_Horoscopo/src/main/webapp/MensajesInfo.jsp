
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head> <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Horoscopo  Mensaje de Error </title>
    <link rel="stylesheet" href="./Styles/styles.css">
</head>

<body>
<%
    // Recibimos el atributo errorMessage del servlet
    String errorMessage = (String) request.getAttribute("errorMessage");
    String mensajeReg = "Usuario o contraseña incorrectos.";
%>
           <div class="container">

            <br>
            <h1>Mensaje del Servidor</h1>
               <p id="errorMessage">${errorMessage}</p>
               <br>

               <form action="MensajesError" method="post">
                   <input type="hidden" name="errorMessage" value="${errorMessage}">
                   <input type="submit" value="Salir">
               </form>


               <%-- Formulario oculto que solo se muestra si errorMessage es "aaa" --%>
               <form id="myForm" action="MensajesError" method="POST" style="<%= (errorMessage.equals(mensajeReg)) ? "" : "display: none;" %>">
                   <p><input type="hidden" name="errorMessage" value="buscar" id="rec"></p>
                   <button type="submit" name="Registrarse" onclick="document.getElementById('rec').value = this.name;">Registrarse</button>
               </form>



    </div>

</body>
</html>
