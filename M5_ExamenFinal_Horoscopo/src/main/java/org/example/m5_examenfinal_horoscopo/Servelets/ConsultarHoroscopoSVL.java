package org.example.m5_examenfinal_horoscopo.Servelets;


import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.m5_examenfinal_horoscopo.DAO.Dto.HoroscopoDto;
import org.example.m5_examenfinal_horoscopo.DAO.Dto.UsuarioDto;
import org.example.m5_examenfinal_horoscopo.DAO.SQL.UsuarioDaoSQL;

import java.awt.*;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;

@WebServlet(name = "ConsultarHoroscopo", value = "/ConsultarHoroscopo")
public class ConsultarHoroscopoSVL extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //Obtengo el click del boton del submit
        String accion = req.getParameter("accion");
        String idUsuario = req.getParameter("idUsuario");

        if (accion == null) {
            // accion = miReq.getParameter("idUsuario");
            accion = "buscar";
        }

        if (accion.equals("salir")) {
            // Reenviar la solicitud al JSP
            RequestDispatcher dispatcherSalir = req.getRequestDispatcher("MenuUsuario.jsp");
            dispatcherSalir.forward(req, resp);

        } else {

            // Inicializar variables para almacenar los valores de las cookies
            String nombre = null;
            String pass = null;

            // Obtener las cookies
            Cookie[] cookies = req.getCookies();

            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    switch (cookie.getName()) {
                        case "nombre" -> nombre = cookie.getValue();
                        case "pass" -> pass = cookie.getValue();
                    }
                    // Si ya tenemos ambos valores, podemos salir del bucle
                    if (nombre != null && pass != null) break;
                }
            }


            // Mostrar los valores obtenidos

            UsuarioDaoSQL miUsuarioDaoSQL = new UsuarioDaoSQL();

            List<HoroscopoDto> listaHoroscopoDto = new ArrayList<>();
            List<UsuarioDto> listaUsuariosDto = new ArrayList<>();


            listaHoroscopoDto = miUsuarioDaoSQL.getHoroscopoAll();
            listaUsuariosDto = miUsuarioDaoSQL.getUsuariosAll();


            String miNombre = "";
            Date fechNac = new Date();
           // buscar usuario para obtener fecha de nacimieto
            for (UsuarioDto dtoUsuario : listaUsuariosDto) {

                // ver si viene de buscar otro usuario
                if (accion.equals("Signo")){

                    if (dtoUsuario.getId() == Integer.parseInt(idUsuario) ) {
                        fechNac = dtoUsuario.getFechaNacimiento();
                        miNombre = dtoUsuario.getNombre();
                    }


                }else {

                    if (dtoUsuario.getUsername().equals(nombre)) {
                        fechNac = dtoUsuario.getFechaNacimiento();
                        miNombre = dtoUsuario.getNombre();
                    }

                }
            }

            String miSigno = "";

            for (HoroscopoDto dtoHoroscopo : listaHoroscopoDto) {
                if (fechNac.after(dtoHoroscopo.getFechaInicio())){
                    if(fechNac.before(dtoHoroscopo.getFechaFinal())){
                        // Encontre el signo
                        miSigno = dtoHoroscopo.getAnimal();

                    }
                }
            }

             // Mostrar el signo por pantalla Enviar a la solicitud
             req.setAttribute("signoJsp",miSigno);
             req.setAttribute("nombreJsp" ,miNombre);
             //req.setAttribute("fechNacJsp" ,fechNac);

            // Reenviar la solicitud al JSP
            RequestDispatcher dispatcherSalir = req.getRequestDispatcher("ConsultaSigno.jsp");
            dispatcherSalir.forward(req, resp);
        }
    }
}
