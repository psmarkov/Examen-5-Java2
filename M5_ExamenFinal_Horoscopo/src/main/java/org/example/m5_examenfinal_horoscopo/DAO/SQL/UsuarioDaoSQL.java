package org.example.m5_examenfinal_horoscopo.DAO.SQL;


import org.example.m5_examenfinal_horoscopo.DAO.Dto.HoroscopoDto;
import org.example.m5_examenfinal_horoscopo.DAO.Dto.UsuarioDto;
import org.example.m5_examenfinal_horoscopo.Modelo.Entities.Horoscopo;
import org.example.m5_examenfinal_horoscopo.Modelo.Entities.Usuario;
import org.example.m5_examenfinal_horoscopo.Modelo.MapperModelo.MapperUsuario;
import org.example.m5_examenfinal_horoscopo.ProcesaConeccion.DatabaseConnection;

import java.awt.*;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;



public class UsuarioDaoSQL extends MapperUsuario {

    //CONEXION A LA BD
    private final DatabaseConnection databaseConnection;

    public UsuarioDaoSQL() {
        databaseConnection = DatabaseConnection.getInstance();
    }

    //SELECT BUSQUEDA EN LA TABLA DE USUARIOS por ID
    public UsuarioDto getUsuarioById(int id) {
        String sql = "SELECT * FROM Usuarios WHERE Id = ?";

        Usuario usuario = null;
        UsuarioDto miUsuarioDto = new UsuarioDto();

        try (Connection connection = databaseConnection.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();


            if (rs.next()) {
                // Obtengo los datos de la base de datos a la entidad
                usuario = new Usuario();
                usuario.setId(rs.getInt("ID"));
                usuario.setNombre(rs.getString("NOMBRE"));
                usuario.setUsername(rs.getString("USERNAME"));
                usuario.setEmail(rs.getString("EMAIL"));
                usuario.setFechaNacimiento(rs.getDate("FECHA_NACIMIENTO"));
                usuario.setPassword(rs.getString("PASSWORDD"));
                usuario.setHoroscopoId(rs.getString("ANIMAL"));

                // Paso los datos de la entidad al DTO
                miUsuarioDto = MapperUsuario.toDTO(usuario);

            }else{
                System.out.println("Usuario no encontrado: " + id);
                return null;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return miUsuarioDto;
    }

    // SELECT BUSCAR POR NOMBRE DE USUARIO Y PASSWORD
    public UsuarioDto getUsuariosByUser(String userNameX) {

        String sql = "SELECT * FROM usuarios where USERNAME = ?";
        Usuario usuario = null;
        UsuarioDto miUsuarioDto = new UsuarioDto();

        //  UsuarioDto miUsuarioDto = null;
        try (Connection connection = databaseConnection.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {

            pstmt.setString(1, userNameX);


            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {

                // Obtengo los datos de la base de datos a la entidad
                usuario = new Usuario();
                usuario.setId(rs.getInt("ID"));
                usuario.setNombre(rs.getString("NOMBRE"));
                usuario.setEmail(rs.getString("EMAIL"));
                usuario.setFechaNacimiento(rs.getDate("FECHA_NACIMIENTO"));
                usuario.setPassword(rs.getString("PASSWORDD"));
                usuario.setHoroscopoId(rs.getString("ANIMAL"));

                // Paso los datos de la entidad al DTO

                miUsuarioDto = MapperUsuario.toDTO(usuario);

                return miUsuarioDto;

            } else {
                System.out.println("Usuario no encontrado: " + userNameX);
                return null;
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return miUsuarioDto;
    }

    // SELECT BUSCAR POR NOMBRE DE USUARIO Y PASSWORD
    public UsuarioDto getUsuariosByPass(String userNameX, String passX) {

        String sql = "SELECT * FROM usuarios where USERNAME = ? and PASSWORDD = ?";
        Usuario usuario = null;
        UsuarioDto miUsuarioDto = new UsuarioDto();

      //  UsuarioDto miUsuarioDto = null;
        try (Connection connection = databaseConnection.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {

            pstmt.setString(1, userNameX);
            pstmt.setString(2, passX);

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {

                // Obtengo los datos de la base de datos a la entidad
                usuario = new Usuario();
                usuario.setId(rs.getInt("ID"));
                usuario.setNombre(rs.getString("NOMBRE"));
                usuario.setEmail(rs.getString("EMAIL"));
                usuario.setFechaNacimiento(rs.getDate("FECHA_NACIMIENTO"));
                usuario.setPassword(rs.getString("PASSWORDD"));
                usuario.setHoroscopoId(rs.getString("ANIMAL"));

                // Paso los datos de la entidad al DTO

                miUsuarioDto = MapperUsuario.toDTO(usuario);

                return miUsuarioDto;

            } else {
                System.out.println("Usuario no encontrado: " + userNameX);
                return null;
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return miUsuarioDto;
    }


    // SELECT LISTAR TODOS LOS USUARIO
    public List<UsuarioDto> getUsuariosAll(){

        String sql = "SELECT * FROM usuarios";
        Usuario usuario = null;


        try (Connection connection = databaseConnection.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {

          ResultSet rs = pstmt.executeQuery();

            List<UsuarioDto> listaUsuariosDto = new ArrayList<>();
            UsuarioDto miUsuarioDto = new UsuarioDto();

            while (rs.next()) {

                // agrego cada registro de la bd a la lista
                Usuario usuarioE = new Usuario(
                        rs.getInt("ID"),
                        rs.getString("NOMBRE"),
                        rs.getString("USERNAME"),
                        rs.getString("EMAIL"),
                        rs.getDate("FECHA_NACIMIENTO"),
                        rs.getString("PASSWORDD"),
                        rs.getString("ANIMAL")
                );
                miUsuarioDto = MapperUsuario.toDTO(usuarioE);
                listaUsuariosDto.add(miUsuarioDto);
            }
            System.out.println(listaUsuariosDto);
            return listaUsuariosDto;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
      //  return listaUsuariosDto; hay que poner un valor en caso de error

    }

    // SELECT LISTAR TODOS LOS USUARIO
    public List<HoroscopoDto> getHoroscopoAll(){

        String sql = "SELECT * FROM horoscopo";


        try (Connection connection = databaseConnection.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {

            ResultSet rs = pstmt.executeQuery();

            List<HoroscopoDto> listaHoroscopoDto = new ArrayList<>();
            HoroscopoDto  miHoroscopoDto = new HoroscopoDto();
            while (rs.next()) {

                // agrego cada registro de la bd a la lista
                Horoscopo horoscopoE = new Horoscopo(
                        rs.getString("horoscopo"),
                        rs.getDate("fecha inicio"),
                        rs.getDate("fecha final")

                );


                miHoroscopoDto = MapperUsuario.toDTOhoroscopo(horoscopoE);
                listaHoroscopoDto.add(miHoroscopoDto);
            }

            return listaHoroscopoDto;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
        //  return listaUsuariosDto; hay que poner un valor en caso de error

    }

    // SELECT ELIMINAR LOS USUARIO
    public void getUpdateUsuarios(UsuarioDto usuarioDtoX){

        String sql = "UPDATE usuarios SET ID = ?, NOMBRE = ?, USERNAME = ?, EMAIL = ?, FECHA_NACIMIENTO = ?, PASSWORDD = ?, ANIMAL = ? where ID = ?;";

        try (Connection connection = databaseConnection.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {

            pstmt.setInt(1, usuarioDtoX.getId());
            pstmt.setString(2, usuarioDtoX.getNombre());
            pstmt.setString(3, usuarioDtoX.getUsername());
            pstmt.setString(4, usuarioDtoX.getEmail());

            // Convertir la fecha de java.util.Date a java.sql.Date
            java.util.Date utilDate = usuarioDtoX.getFechaNacimiento();
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
            pstmt.setDate(5, sqlDate);

            pstmt.setString(6, usuarioDtoX.getPassword());
            pstmt.setString(7, usuarioDtoX.getHoroscopoId());

            pstmt.setInt(8, usuarioDtoX.getId());

            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    // SELECT ELIMINAR LOS USUARIO
    public void getEliminaUsuarios(int indice){

        String sql = "DELETE FROM usuarios where ID = ?";
        Usuario usuario = null;

        try (Connection connection = databaseConnection.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {

            pstmt.setInt(1, indice);

            pstmt.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    // SELECT ELIMINAR LOS USUARIO
    public void getIsertUsuarios(UsuarioDto miUsuarioDto){

        String sql = "INSERT INTO usuarios (ID, NOMBRE, USERNAME, EMAIL, FECHA_NACIMIENTO , PASSWORDD , ANIMAL ) VALUES (?, ?,?,?,?,?,?);";


        Usuario usuario = null;

        try (Connection connection = databaseConnection.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {

            pstmt.setInt(1, miUsuarioDto.getId());
            pstmt.setString(2, miUsuarioDto.getNombre());
            pstmt.setString(3, miUsuarioDto.getUsername());
            pstmt.setString(4, miUsuarioDto.getEmail());

            // Convertir la fecha de java.util.Date a java.sql.Date
            java.util.Date utilDate = miUsuarioDto.getFechaNacimiento();
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
            pstmt.setDate(5, sqlDate);

            pstmt.setString(6, miUsuarioDto.getPassword());
            pstmt.setString(7, miUsuarioDto.getHoroscopoId());

         pstmt.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}

