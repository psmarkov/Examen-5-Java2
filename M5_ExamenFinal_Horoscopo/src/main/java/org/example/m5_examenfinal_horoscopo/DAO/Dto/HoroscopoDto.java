package org.example.m5_examenfinal_horoscopo.DAO.Dto;

import java.util.Date;

public class HoroscopoDto {


    private String animal;
    private Date fechaInicio;
    private Date fechaFinal;

    public HoroscopoDto() {
    }

    public HoroscopoDto(String animal, Date fechaInicio, Date fechaFinal) {

        this.animal = animal;
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
    }



    public String getAnimal() {
        return animal;
    }

    public void setAnimal(String animal) {
        this.animal = animal;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(Date fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    @Override
    public String toString() {
        return "Horoscopo{" +

                ", animal='" + animal + '\'' +
                ", fechaInicio=" + fechaInicio +
                ", fechaFinal=" + fechaFinal +
                '}';
    }


}
