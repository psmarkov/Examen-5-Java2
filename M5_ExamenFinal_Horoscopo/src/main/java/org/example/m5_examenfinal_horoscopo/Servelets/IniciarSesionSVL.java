package org.example.m5_examenfinal_horoscopo.Servelets;


import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import org.example.m5_examenfinal_horoscopo.DAO.Dto.UsuarioDto;
import org.example.m5_examenfinal_horoscopo.DAO.SQL.UsuarioDaoSQL;

import java.io.IOException;

@WebServlet(name = "IniciarSesion", value = "/IniciarSesion")
public class IniciarSesionSVL extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest miReq, HttpServletResponse resp) throws ServletException, IOException {

        // Obtener datos del formulario
        String nombre = miReq.getParameter("nombre");
        String pass = miReq.getParameter("pass");

        // Acceso a Dao y recibir e DTO con los datos
        UsuarioDaoSQL miUsuarioDaoSQL = new UsuarioDaoSQL();
        UsuarioDto miUsuarioDTO = new UsuarioDto();

        // recibo los datos
        miUsuarioDTO = miUsuarioDaoSQL.getUsuariosByPass(nombre, pass);


        if (miUsuarioDTO != null){

            // Servlet1
            HttpSession session = miReq.getSession();
            session.setAttribute("nombreUsuario", nombre);
            session.setAttribute("passUsuario", pass);

            // Crear cookies con el nombre y la contraseña
            Cookie cookieNombre = new Cookie("nombre", nombre);
            Cookie cookiePass = new Cookie("pass", pass);

            // Configurar el tiempo de vida de las cookies en segundos ( 1 día = 86400 segundos)
            cookieNombre.setMaxAge(86400);
            cookiePass.setMaxAge(86400);

            // Agregar las cookies a la respuesta
            resp.addCookie(cookieNombre);
            resp.addCookie(cookiePass);


            // Reenviar la solicitud al JSP
            RequestDispatcher dispatcher = miReq.getRequestDispatcher("Respuesta.jsp");
            dispatcher.forward(miReq, resp);


        }else{
            miReq.setAttribute("errorMessage", "Usuario o contraseña incorrectos.");
            RequestDispatcher dispatcher = miReq.getRequestDispatcher("MensajesInfo.jsp");
            dispatcher.forward(miReq, resp);

        }

    }

}
