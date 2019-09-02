package com.example.nicol.elink.Usuario;

import com.example.nicol.elink.BandejaNoticias.BandejaNoticias;

public class Inversor extends Usuario {

    private BandejaNoticias bandejaNoticias;
    private double dinero;

    public Inversor(){}
    public Inversor(String id, String nombreUsuario, String email) {
        super(id, nombreUsuario, email);
        bandejaNoticias = new BandejaNoticias();
    }

    /**
     * Aumenta el dinero actual del inversor sumandole el monto pasado
     * @param monto dinero añadido al inversor
     * @return monto actual del inversor
     */
    public double depositar(double monto){
        this.dinero += monto;
        return this.dinero;
    }

    //Getters y Setters

    public BandejaNoticias getBandejaNoticias() {
        return bandejaNoticias;
    }

    public void setBandejaNoticias(BandejaNoticias bandejaNoticias) {
        this.bandejaNoticias = bandejaNoticias;
    }

    public double getDinero() {
        return dinero;
    }

    public void setDinero(double dinero) {
        this.dinero = dinero;
    }
}
