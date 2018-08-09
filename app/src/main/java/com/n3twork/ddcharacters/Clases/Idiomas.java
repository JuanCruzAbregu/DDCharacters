package com.n3twork.ddcharacters.Clases;

public class Idiomas {

    private int _id;
    private String _idiomas;
    private int _idPersonaje;

    public Idiomas(){}

    public Idiomas(String _idiomas, int _idPersonaje){
        this._idiomas     = _idiomas;
        this._idPersonaje = _idPersonaje;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String get_idiomas() {
        return _idiomas;
    }

    public void set_idiomas(String _idiomas) {
        this._idiomas = _idiomas;
    }

    public int get_idPersonaje() {
        return _idPersonaje;
    }

    public void set_idPersonaje(int _idPersonaje) {
        this._idPersonaje = _idPersonaje;
    }
}
