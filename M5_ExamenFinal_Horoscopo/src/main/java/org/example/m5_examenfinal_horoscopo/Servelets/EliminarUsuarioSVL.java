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


import java.util.List;
import java.io.IOException;

@WebServlet(name = "EliminarUsuario", value = "/EliminarUsuario")
public class EliminarUsuarioSVL extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // Servlet2
        HttpSession session = req.getSession();
        List<UsuarioDto> miListaE = (List<UsuarioDto>) session.getAttribute("ListaUsuarios");
        session.setAttribute("listaUsuarios", miListaE);


        //Obtengo el numero ingresado para bscar
        String indiceUsuario = req.getParameter("idUsuario");
        String accionEliminar = req.getParameter("accion");


        // Si no se ha indicado una acción, asignar "Buscar" por defecto
        if (accionEliminar == null || accionEliminar.isEmpty()) {

            accionEliminar = (String) session.getAttribute("GuardoAccion");


            if (accionEliminar == null) {
                accionEliminar = "Buscar"; // Valor predeterminado si no existe en la sesión
            }else{
                if (accionEliminar.equals("Eliminar")){
                    accionEliminar = "buscar";
                }
            }
        }


        //SECCION  PARA ELIMINAR UN USUARIO
        if (accionEliminar.equals("Eliminar")){

            String idUsuarioEliminar = (String) session.getAttribute("GuardoID");

            // Buscar y eliminar el usuario en la lista
            for (UsuarioDto dtoUsuario : miListaE) {
                if (dtoUsuario.getId() == Integer.parseInt(idUsuarioEliminar)) {

                    // Eliminar el usuario de la lista
                    miListaE.remove(dtoUsuario);

                    // Actualizar la lista en la sesión
                    session.setAttribute("ListaUsuarios", miListaE);



                    // ir al Dao a ejecutar consulta eliminar
                    UsuarioDaoSQL miUsuarioDaoSQL = new UsuarioDaoSQL();
                    miUsuarioDaoSQL.getEliminaUsuarios(Integer.parseInt(idUsuarioEliminar));



                    // Guardar la ID del usuario y la acción en la sesión
                    session.setAttribute("GuardoID", idUsuarioEliminar);
                    session.setAttribute("GuardoAccion", accionEliminar);

                    // Enviar un mensaje de éxito y redirigir al JSP
                    String mensaje = "Usuario eliminado correctamente";
                    req.setAttribute("errorMessage", mensaje);
                    req.setAttribute("lista", miListaE);
                    req.setAttribute("usuarioEliminar", dtoUsuario);

                    //Inicializo la variable
                    req.setAttribute("accion" , "buscar");
                    req.setAttribute("idUsuario", "1");

                    RequestDispatcher dispatcher = req.getRequestDispatcher("MensajesInfo.jsp");
                    dispatcher.forward(req, resp);

                    break; // Salir del bucle después de eliminar al usuario
                }
            }

        }else {

            //SECCION PARA MOSTRAR EL USUARIO LECCIONADO
            for (UsuarioDto dtoUsuario : miListaE) {

                if (dtoUsuario.getId() == Integer.parseInt(indiceUsuario)) {

                    // Servlet1 envio la listasse cargan para enviarlos
                    session.setAttribute("ListaUsuarios", miListaE);
                    session.setAttribute("usuarioEliminado", dtoUsuario);

                    // Cargo los valores en la solicitud
                    req.setAttribute("usuarioEliminar", dtoUsuario);
                    req.setAttribute("lista", miListaE);

                    //Guardo el Id de usuario en la sesion
                    session.setAttribute("GuardoID",indiceUsuario);
                    session.setAttribute("GuardoAccion",accionEliminar);

                    // atributo indicando que el div con los detalles debe ser visible
                    req.setAttribute("mostrarDetalle", "true"); // Este atributo controla la visibilidad


                    // Envío los datos al JSP
                    req.getRequestDispatcher("EliminarUsuario.jsp").forward(req, resp);

                    break;
                }
            }
        }

    }

}
