package org.example.m5_examenfinal_horoscopo.Modelo.MapperModelo;

import org.example.m5_examenfinal_horoscopo.DAO.Dto.HoroscopoDto;
import org.example.m5_examenfinal_horoscopo.DAO.Dto.UsuarioDto;
import org.example.m5_examenfinal_horoscopo.Modelo.Entities.Horoscopo;
import org.example.m5_examenfinal_horoscopo.Modelo.Entities.Usuario;

import java.util.Date;

public class MapperUsuario {


        public static UsuarioDto toDTO(Usuario usuario) {
            UsuarioDto usuarioDto = new UsuarioDto();

            usuarioDto.setId(usuario.getId());
            usuarioDto.setNombre(usuario.getNombre());
            usuarioDto.setUsername(usuario.getUsername());
            usuarioDto.setEmail(usuario.getEmail());
            usuarioDto.setFechaNacimiento(usuario.getFechaNacimiento());
            usuarioDto.setPassword(usuario.getPassword());
            usuarioDto.setHoroscopoId(usuario.getHoroscopoId());

            return usuarioDto;
        }

        public static Usuario toEntity(UsuarioDto usuarioDto) {
            Usuario usuario = new Usuario();

            usuario.setId(usuarioDto.getId());
            usuario.setNombre(usuarioDto.getNombre());
            usuario.setUsername(usuarioDto.getUsername());
            usuario.setEmail(usuarioDto.getEmail());
            usuario.setFechaNacimiento(usuarioDto.getFechaNacimiento());
            usuario.setPassword(usuarioDto.getPassword());
            usuario.setHoroscopoId(usuarioDto.getHoroscopoId());

            return usuario;
        }

    public static HoroscopoDto toDTOhoroscopo(Horoscopo horoscopo) {
        HoroscopoDto horoscopoDto = new HoroscopoDto();

        horoscopoDto.setAnimal(horoscopo.getAnimal());
        horoscopoDto.setFechaInicio(horoscopo.getFechaInicio());
        horoscopoDto.setFechaFinal(horoscopo.getFechaFinal());

        return horoscopoDto;
    }

}


