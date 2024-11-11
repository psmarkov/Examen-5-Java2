package org.example.m5_examenfinal_horoscopo.Servelets;

import com.mysql.cj.xdevapi.Session;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.m5_examenfinal_horoscopo.DAO.Dto.UsuarioDto;

import java.io.IOException;
import java.util.List;


@WebServlet(name = "MensajesError", value = "/MensajesError")
public class MensajesErrorSVL extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();

        // Obtene el parámetro errorMessage del request
        String errorMessage = req.getParameter("errorMessage");

        switch (errorMessage) {

            case "Usuario no encontrado.":
                // Reenviar la solicitud al JSP
                RequestDispatcher dispatcher = req.getRequestDispatcher("MenuUsuario.jsp");
                dispatcher.forward(req, resp);

                break;

            case "Usuario o contraseña incorrectos.":
                // Reenviar la solicitud al JSP
                RequestDispatcher dispatcherE = req.getRequestDispatcher("index.jsp");
                dispatcherE.forward(req, resp);

                break;

            case "Registrarse":
                // Reenviar la solicitud al JSP
                RequestDispatcher dispatcherReg = req.getRequestDispatcher("CrearUsuario.jsp");
                dispatcherReg.forward(req, resp);

                break;


            case "Usuario eliminado correctamente":
                // Reenviar la solicitud al JSP

                //obtengo los valores guardados en la session
                UsuarioDto usuarioEliminadoM = (UsuarioDto) session.getAttribute("usuarioEliminado");
                List<UsuarioDto> lista = (List<UsuarioDto>) session.getAttribute("listaUsuarios");


                // Cargo los valores en la solicitud
                req.setAttribute("usuarioEliminar", usuarioEliminadoM);
                req.setAttribute("lista", lista);

                //Inicializo la variable
                req.setAttribute("accion" , "buscar");
                req.setAttribute("idUsuario", "1");

                // atributo indicando que el div con los detalles debe ser visible
                //req.setAttribute("mostrarDetalle", "false"); // Este atributo controla la visibilidad

                RequestDispatcher dispatcherA = req.getRequestDispatcher("EliminarUsuario.jsp");
                dispatcherA.forward(req, resp);

                break;
            case  "Usuario Registrado con Exito":
                // Reenviar la solicitud al JSP
                RequestDispatcher dispatcherR = req.getRequestDispatcher("MenuUsuario.jsp");
                dispatcherR.forward(req, resp);

                break;

            case  "Usuario ya Existe":
                // Reenviar la solicitud al JSP
                RequestDispatcher dispatcherY = req.getRequestDispatcher("MenuUsuario.jsp");
                dispatcherY.forward(req, resp);

                break;

        }

    }

}
