package com.n3twork.ddcharacters.Clases;

public class Hitos {

    private int _id;
    private String _hito;
    private int _idPersonaje;


    public Hitos(){}

    public Hitos(String _hito, int _idPersonaje){

        this._hito        = _hito;
        this._idPersonaje = _idPersonaje;

    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String get_hito() {
        return _hito;
    }

    public void set_hito(String _hito) {
        this._hito = _hito;
    }

    public int get_idPersonaje() {
        return _idPersonaje;
    }

    public void set_idPersonaje(int _idPersonaje) {
        this._idPersonaje = _idPersonaje;
    }
}
