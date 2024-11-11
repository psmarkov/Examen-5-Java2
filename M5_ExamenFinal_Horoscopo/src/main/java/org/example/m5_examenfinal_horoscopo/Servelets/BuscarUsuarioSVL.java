package org.example.m5_examenfinal_horoscopo.Servelets;


import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import org.example.m5_examenfinal_horoscopo.DAO.Dto.UsuarioDto;
import org.example.m5_examenfinal_horoscopo.DAO.SQL.UsuarioDaoSQL;


import java.io.IOException;

@WebServlet(name = "BuscarUsuario", value = "/BuscarUsuario")
public class BuscarUsuarioSVL extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest miReq, HttpServletResponse resp) throws ServletException, IOException {

        // Servlet2 accion del menu
        HttpSession session = miReq.getSession();
        String miAccionMenu = (String) session.getAttribute("accionMenu");

        //Obtengo el click del boton del submit
        String accion = miReq.getParameter("accion");
        if (accion == null){
           // accion = miReq.getParameter("idUsuario");
            accion = "buscar";
        }


        if (accion.equals("salir")) {
            // Reenviar la solicitud al JSP
            RequestDispatcher dispatcherSalir = miReq.getRequestDispatcher("MenuUsuario.jsp");
            dispatcherSalir.forward(miReq, resp);

        } else {

            //Obtengo el click del boton del submit
            String idUsuario = miReq.getParameter("idUsuario");


            // Acceso a Dao y recibir e DTO con los datos
            UsuarioDaoSQL miUsuarioDaoSQL = new UsuarioDaoSQL();
            UsuarioDto miUsuarioDTO = new UsuarioDto();

            // recibo los datos
              miUsuarioDTO = miUsuarioDaoSQL.getUsuarioById(Integer.parseInt(idUsuario));

            if (miUsuarioDTO != null) {

                    // Reenviar la solicitud al JSP
                    miReq.setAttribute("Encontrado", miUsuarioDTO);
                    miReq.getRequestDispatcher("BuscarUsuario.jsp").forward(miReq, resp);


            } else {
                miReq.setAttribute("errorMessage", "Usuario no encontrado.");
                RequestDispatcher dispatcher = miReq.getRequestDispatcher("MensajesInfo.jsp");
                dispatcher.forward(miReq, resp);

            }

        }

    }
}
