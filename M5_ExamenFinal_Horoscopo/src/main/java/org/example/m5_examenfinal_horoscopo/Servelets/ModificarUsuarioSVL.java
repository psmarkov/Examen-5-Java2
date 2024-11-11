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

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "ModificarUsuario", value = "/ModificarUsuario")
public class ModificarUsuarioSVL extends HttpServlet {


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

        //Obtengo el click del boton del submit
        String accion2 = miReq.getParameter("accion2");
        if (accion2 == null){

            accion2 = "buscar";
        }

        if (accion.equals("salir")) {
            // Reenviar la solicitud al JSP
            RequestDispatcher dispatcherSalir = miReq.getRequestDispatcher("MenuUsuario.jsp");
            dispatcherSalir.forward(miReq, resp);

        } else {
            // Acceso a Dao y recibir e DTO con los datos
            UsuarioDaoSQL miUsuarioDaoSQL = new UsuarioDaoSQL();

            if (accion2.equals("Modificar")) {

                //Recibo los parametros del jsp
                String idJssp = miReq.getParameter("ID");
                String nombreJsp = miReq.getParameter("nombre");
                String userNameJsp = miReq.getParameter("userName");
                String passJsp = miReq.getParameter("pass");
                String emailJsp = miReq.getParameter("email");
                String fNacJsp = miReq.getParameter("fNac");
                String signoJsp = miReq.getParameter("signo");

                //MAPEAR DEL JSP A DTO
                UsuarioDto usuarioDto = new UsuarioDto();

                usuarioDto.setId(Integer.parseInt(idJssp));
                usuarioDto.setNombre(nombreJsp);
                usuarioDto.setUsername(userNameJsp);
                usuarioDto.setEmail(emailJsp);


                // Convierte a date
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd"); // Cambiar el formato para coincidir con el de la entrada

                // Convertir String a java.util.Date
                Date utilDate = null;
                try {
                    utilDate = formatter.parse(fNacJsp);
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }

                // Convertir java.util.Date a java.sql.Date
                Date sqlDate = new Date(utilDate.getTime());


                usuarioDto.setFechaNacimiento(utilDate);
                usuarioDto.setPassword(passJsp);
                usuarioDto.setHoroscopoId(signoJsp);

                //Paso el Dto al DAO la consulta para insertar
                miUsuarioDaoSQL.getUpdateUsuarios(usuarioDto);

                miReq.setAttribute("errorMessage", "Usuario Registrado con Exito");
                RequestDispatcher dispatcher = miReq.getRequestDispatcher("MensajesInfo.jsp");
                dispatcher.forward(miReq, resp);


            }else {


                //Obtengo el click del boton del submit
                String idUsuario = miReq.getParameter("idUsuario");


                // Acceso a Dao y recibir e DTO con los datos
                UsuarioDto miUsuarioDTO = new UsuarioDto();

                // recibo los datos
                miUsuarioDTO = miUsuarioDaoSQL.getUsuarioById(Integer.parseInt(idUsuario));

                if (miUsuarioDTO != null) {


                    // Reenviar la solicitud al JSP
                    miReq.setAttribute("Encontrado", miUsuarioDTO);
                    miReq.getRequestDispatcher("ModificarUsuario.jsp").forward(miReq, resp);


                } else {
                    miReq.setAttribute("errorMessage", "Usuario no encontrado.");
                    RequestDispatcher dispatcher = miReq.getRequestDispatcher("MensajesInfo.jsp");
                    dispatcher.forward(miReq, resp);

                }
            }


        }

    }

}
