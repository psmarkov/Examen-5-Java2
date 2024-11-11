package org.example.m5_examenfinal_horoscopo.Servelets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet(name = "MenuUsuario", value = "/MenuSVL")
public class MenuSVL extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("MenuUsuario.jsp");
    }


    @Override
    protected void doPost(HttpServletRequest miReq, HttpServletResponse resp) throws ServletException, IOException {

       String accion = miReq.getParameter("accion") ;

        // Servlet1 para enviar la accion del menu al servelet listar
        HttpSession session = miReq.getSession();
        session.setAttribute("accionMenu", accion);

        switch (accion){
           case "Buscar":
               // Reenviar la solicitud al Jsp
               RequestDispatcher dispatcher = miReq.getRequestDispatcher("BuscarUsuario.jsp");
               dispatcher.forward(miReq, resp);

               // buscar
               break;
            case "Modificar":
                // Reenviar la solicitud al Jsp
                RequestDispatcher dispatcherM = miReq.getRequestDispatcher("ModificarUsuario.jsp");
                dispatcherM.forward(miReq, resp);

                // buscar
                break;
           case "Listar":
               // Reenviar la solicitud al Servelet
               RequestDispatcher dispatcherListar = miReq.getRequestDispatcher("ListarUsuario");

               // Servlet1
               miReq.setAttribute("mensaje", "Hola desde Servlet1");
               dispatcherListar.forward(miReq, resp);

               break;

           case "Eliminar":
               // Reenviar la solicitud al Servelet
               RequestDispatcher dispatcherE = miReq.getRequestDispatcher("ListarUsuario");
               dispatcherE.forward(miReq, resp);

               break;

            case "Registrar":
                // Reenviar la solicitud al Jsp
                RequestDispatcher dispatcherR = miReq.getRequestDispatcher("CrearUsuario.jsp");
                dispatcherR.forward(miReq, resp);
                break;

           case "Horoscopo":
               // Reenviar la solicitud al Jsp
               RequestDispatcher dispatcherS = miReq.getRequestDispatcher("ConsultarHoroscopo");
               dispatcherS.forward(miReq, resp);
               break;

           case "Salir":
               // Crear cookies con el mismo nombre y tiempo de vida 0 para eliminarlas
               Cookie cookieNombre = new Cookie("nombre", "");
               // Establece el tiempo de vida en 0 para eliminarla
               cookieNombre.setMaxAge(0);

               // Añade la cookie al response para que el navegador la elimine
               resp.addCookie(cookieNombre);



               Cookie cookiePass = new Cookie("pass", "");
               // Establece el tiempo de vida en 0 para eliminarla
               cookiePass.setMaxAge(0);
               // Añade la cookie al response para que el navegador la elimine
               resp.addCookie(cookiePass);

               System.out.println("Las cookies 'nombre' y 'pass' han sido eliminadas.");
               break;

       }

    }

}
