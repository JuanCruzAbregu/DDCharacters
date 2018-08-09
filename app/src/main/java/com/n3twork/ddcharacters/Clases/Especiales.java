package com.n3twork.ddcharacters.Clases;

public class Especiales {

    private int _id;
    private String _aptitudes;
    private int _idPersonaje;

    public Especiales(){

    }

    public Especiales(String _idiomas, int _idPersonaje){

        this._aptitudes = _idiomas;
        this._idPersonaje = _idPersonaje;

    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String get_aptitudes() {
        return _aptitudes;
    }

    public void set_aptitudes(String _aptitudes) {
        this._aptitudes = _aptitudes;
    }

    public int get_idPersonaje() {
        return _idPersonaje;
    }

    public void set_idPersonaje(int _idPersonaje) {
        this._idPersonaje = _idPersonaje;
    }
}
