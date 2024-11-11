package org.example.m5_examenfinal_horoscopo.DAO.Dto;

import java.util.Date;

public class UsuarioDto {


    private int id;
    private String nombre;
    private String username;
    private String email;
    private Date fechaNacimiento;
    private String password;
    private String horoscopoId;


    public UsuarioDto() {
    }

    public UsuarioDto(int id, String nombre, String username, String email, Date fechaNacimiento, String password, String horoscopoId) {
        this.id = id;
        this.nombre = nombre;
        this.username = username;
        this.email = email;
        this.fechaNacimiento = fechaNacimiento;
        this.password = password;
        this.horoscopoId = horoscopoId;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getHoroscopoId() {
        return horoscopoId;
    }

    public void setHoroscopoId(String horoscopoId) {
        this.horoscopoId = horoscopoId;
    }

    @Override
    public String toString() {
        return "UsuarioDto{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                ", password='" + password + '\'' +
                ", horoscopoId=" + horoscopoId +
                '}';
    }

}
