package com.n3twork.ddcharacters.Clases;

public class OtrosConjuros  {

    private int _idPj;
    private String _dominios;
    private String _escuela;
    private int _idPersonaje;

    public OtrosConjuros(){

    }

    public OtrosConjuros(String _dominios, String _escuela, int _idPersonaje){

        this._dominios    = _dominios;
        this._escuela     = _escuela;
        this._idPersonaje = _idPersonaje;

    }

    public int get_idPj() {
        return _idPj;
    }

    public void set_idPj(int _idPj) {
        this._idPj = _idPj;
    }

    public String get_dominios() {
        return _dominios;
    }

    public void set_dominios(String _dominios) {
        this._dominios = _dominios;
    }

    public String get_escuela() {
        return _escuela;
    }

    public void set_escuela(String _escuela) {
        this._escuela = _escuela;
    }

    public int get_idPersonaje() {
        return _idPersonaje;
    }

    public void set_idPersonaje(int _idPersonaje) {
        this._idPersonaje = _idPersonaje;
    }
}
