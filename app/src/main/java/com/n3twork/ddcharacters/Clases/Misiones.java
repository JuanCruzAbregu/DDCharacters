package com.n3twork.ddcharacters.Clases;

public class Misiones {


    private int _id;
    private String _mision;
    private String _descripcion;
    private int _idPersonaje;


    public Misiones(){}

    public Misiones(String _mision, String _descripcion, int _idPersonaje){

        this._mision      = _mision;
        this._descripcion = _descripcion;
        this._idPersonaje = _idPersonaje;

    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String get_mision() {
        return _mision;
    }

    public void set_mision(String _mision) {
        this._mision = _mision;
    }

    public String get_descripcion() {
        return _descripcion;
    }

    public void set_descripcion(String _descripcion) {
        this._descripcion = _descripcion;
    }

    public int get_idPersonaje() {
        return _idPersonaje;
    }

    public void set_idPersonaje(int _idPersonaje) {
        this._idPersonaje = _idPersonaje;
    }
}
