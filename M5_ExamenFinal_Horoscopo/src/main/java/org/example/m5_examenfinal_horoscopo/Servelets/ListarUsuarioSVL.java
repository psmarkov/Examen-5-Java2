package org.example.m5_examenfinal_horoscopo.Servelets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.m5_examenfinal_horoscopo.DAO.Dto.UsuarioDto;
import org.example.m5_examenfinal_horoscopo.DAO.SQL.UsuarioDaoSQL;
import org.example.m5_examenfinal_horoscopo.HelloServlet;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;


@WebServlet(name = "ListarUsuario", value = "/ListarUsuario")
public class ListarUsuarioSVL extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // Servlet2 accion del menu
        HttpSession session = req.getSession();
        String miAccionMenu = (String) session.getAttribute("accionMenu");

        //Obtengo el click del boton del submit
        String accion = req.getParameter("accion") ;


        if (accion.equals("salir")){
            // Reenviar la solicitud al JSP
            RequestDispatcher dispatcherSalir = req.getRequestDispatcher("MenuUsuario.jsp");
            dispatcherSalir.forward(req, resp);

        }else {


            // Servlet2
            String mensaje = (String) req.getAttribute("mensaje");
            // ... (utilizar el mensaje en Servlet2)
            System.out.println(mensaje);


            // Servlet2
            //HttpSession session = req.getSession();

            // Acceso a Dao y recibir e DTO con los datos
            UsuarioDaoSQL miUsuarioDaoSQL = new UsuarioDaoSQL();
            List<UsuarioDto> listaUsuariosDto = new ArrayList<>();

            // recibo los datos
            listaUsuariosDto = miUsuarioDaoSQL.getUsuariosAll();

            if (listaUsuariosDto != null) {

                req.setAttribute("lista", listaUsuariosDto);

                switch (miAccionMenu){

                        case "Listar":
                            // Reenviar la solicitud al JSP
                            RequestDispatcher dispatcher = req.getRequestDispatcher("ListarUsuario.jsp");
                            dispatcher.forward(req, resp);

                            break;

                        case "Eliminar":
                             // Reenviar la solicitud al JSP

                            // Servlet1
                            HttpSession sessionLista = req.getSession();
                            sessionLista.setAttribute("ListaUsuarios", listaUsuariosDto);


                            RequestDispatcher dispatcherE = req.getRequestDispatcher("EliminarUsuario.jsp");
                            dispatcherE.forward(req, resp);

                            break;


                }

            } else {
                mensaje = "No existen Usuarios para Listar ";

                req.setAttribute("errorMessage", mensaje);
                RequestDispatcher dispatcher = req.getRequestDispatcher("MensajesInfo.jsp");
                dispatcher.forward(req, resp);

            }

        }

    }

}

