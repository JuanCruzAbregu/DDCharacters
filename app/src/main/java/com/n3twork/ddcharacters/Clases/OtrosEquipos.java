package com.n3twork.ddcharacters.Clases;

public class OtrosEquipos {

    private int    _idPj;
    private String _otrasObjeto;
    private String _otrasPagina;
    private String _otrasPeso;
    private String _otrasValor;
    private String _otrasMoneda;
    private int _idPersonaje;

    public OtrosEquipos(){

    }

    public OtrosEquipos(String _otrasObjeto, String _otrasPagina, String _otrasPeso, String _otrasValor, String _otrasMoneda, int _idPersonaje){

        this._otrasObjeto  = _otrasObjeto;
        this._otrasPagina  = _otrasPagina;
        this._otrasPeso    = _otrasPeso;
        this._otrasValor   = _otrasValor;
        this._otrasMoneda  = _otrasMoneda;
        this._idPersonaje = _idPersonaje;

    }

    public int get_idPj() {
        return _idPj;
    }

    public void set_idPj(int _idPj) {
        this._idPj = _idPj;
    }

    public String get_otrasObjeto() {
        return _otrasObjeto;
    }

    public void set_otrasObjeto(String _otrasObjeto) {
        this._otrasObjeto = _otrasObjeto;
    }

    public String get_otrasPagina() {
        return _otrasPagina;
    }

    public void set_otrasPagina(String _otrasPagina) {
        this._otrasPagina = _otrasPagina;
    }

    public String get_otrasPeso() {
        return _otrasPeso;
    }

    public void set_otrasPeso(String _otrasPeso) {
        this._otrasPeso = _otrasPeso;
    }

    public String get_otrasValor() {
        return _otrasValor;
    }

    public void set_otrasValor(String _otrasValor) {
        this._otrasValor = _otrasValor;
    }

    public String get_otrasMoneda() {
        return _otrasMoneda;
    }

    public void set_otrasMoneda(String _otrasMoneda) {
        this._otrasMoneda = _otrasMoneda;
    }

    public int get_idPersonaje() {
        return _idPersonaje;
    }

    public void set_idPersonaje(int _idPersonaje) {
        this._idPersonaje = _idPersonaje;
    }

}
