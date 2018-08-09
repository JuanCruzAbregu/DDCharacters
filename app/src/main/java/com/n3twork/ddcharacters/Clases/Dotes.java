package com.n3twork.ddcharacters.Clases;

public class Dotes {


    private int _id;
    private String _dote;
    private String _pagina;
    private int _idPersonaje;

    public Dotes(){

    }

    public Dotes(String _dote, String _pagina, int _idPersonaje){

        this._dote        = _dote;
        this._pagina      = _pagina;
        this._idPersonaje = _idPersonaje;

    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String get_dote() {
        return _dote;
    }

    public void set_dote(String _dote) {
        this._dote = _dote;
    }

    public String get_pagina() {
        return _pagina;
    }

    public void set_pagina(String _pagina) {
        this._pagina = _pagina;
    }

    public int get_idPersonaje() {
        return _idPersonaje;
    }

    public void set_idPersonaje(int _idPersonaje) {
        this._idPersonaje = _idPersonaje;
    }
}
