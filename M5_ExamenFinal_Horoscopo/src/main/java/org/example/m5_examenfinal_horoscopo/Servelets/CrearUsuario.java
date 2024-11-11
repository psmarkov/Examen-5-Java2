package org.example.m5_examenfinal_horoscopo.Servelets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.m5_examenfinal_horoscopo.DAO.Dto.UsuarioDto;
import org.example.m5_examenfinal_horoscopo.DAO.SQL.UsuarioDaoSQL;
import org.example.m5_examenfinal_horoscopo.Modelo.MapperModelo.MapperUsuario;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.text.ParseException;
import java.text.SimpleDateFormat;


@WebServlet(name = "CrearUsuario", value = "/CrearUsuario")
public class CrearUsuario extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //Obtengo el click del boton del submit
        String accion = req.getParameter("accion");
        if (accion == null) {
            // accion = miReq.getParameter("idUsuario");
            accion = "buscar";
        }


        if (accion.equals("salir")) {
            // Reenviar la solicitud al JSP
            RequestDispatcher dispatcherSalir = req.getRequestDispatcher("MenuUsuario.jsp");
            dispatcherSalir.forward(req, resp);

        } else {

            //Recibo los parametros del jsp
            String nombreJsp = req.getParameter("nombre");
            String userNameJsp = req.getParameter("userName");
            String passJsp = req.getParameter("pass");
            String emailJsp = req.getParameter("email");
            String fNacJsp = req.getParameter("fNac");
            String signoJsp = req.getParameter("signo");


            // Acceso a Dao y recibir lISTA
            UsuarioDaoSQL miUsuarioDaoSQL = new UsuarioDaoSQL();
            List<UsuarioDto> listaUsuariosDto = new ArrayList<>();
            listaUsuariosDto = miUsuarioDaoSQL.getUsuariosAll();

            int idJsp = listaUsuariosDto.size() + 1;

            // ver que no exista en la base de datos
            UsuarioDto miUsuarioDTO = miUsuarioDaoSQL.getUsuariosByUser(userNameJsp);

            if (miUsuarioDTO != null) {

                // USUARIO EXISTE no se puede registrar
                //req.setAttribute("errorMessage", "Usuario no encontrado.");
                req.setAttribute("errorMessage", "Usuario ya Existe");
                RequestDispatcher dispatcher = req.getRequestDispatcher("MensajesInfo.jsp");
                dispatcher.forward(req, resp);

            } else {
                //USUARIO NO EXISTE

                //MAPEAR DEL JSP A DTO
                UsuarioDto usuarioDto = new UsuarioDto();

                usuarioDto.setId(idJsp);
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
                miUsuarioDaoSQL.getIsertUsuarios(usuarioDto);


                req.setAttribute("errorMessage", "Usuario Registrado con Exito");
                RequestDispatcher dispatcher = req.getRequestDispatcher("MensajesInfo.jsp");
                dispatcher.forward(req, resp);

            }


        }
    }
}