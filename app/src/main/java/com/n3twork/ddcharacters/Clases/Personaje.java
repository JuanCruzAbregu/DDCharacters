package com.n3twork.ddcharacters.Clases;

/**
 * Created by N3TWORK on 21/2/2018.
 */

public class Personaje {

    private int _idPj;
    private String _nombrePj;
    private String _clasePj;
    private String _nivelPj;
    private String _razaPj;
    private String _alineamientoPj;
    private String _deidadPj;
    private String _tamañoPj;
    private String _sexoPj;
    private String _expPj;
    private String _expLow;
    private String _expHigh;
    private String _campañaPj;
    private String _controlAct;
    private String _puntFZA;
    private String _puntDES;
    private String _puntCON;
    private String _puntINT;
    private String _puntSAB;
    private String _puntCAR;
    private String _modFZA;
    private String _modDES;
    private String _modCON;
    private String _modINT;
    private String _modSAB;
    private String _modCAR;
    private String _ptsHab;
    private String _pg;
    private String _velocidad;
    private String _heridas;
    private String _ca;
    private String _toque;
    private String _iniciativa;
    private String _desprevenido;
    private String _ataque;
    private String _presa;
    private String _resConjuros;
    private String _redDanio;
    private String _bonfAtaque;
    private String _bonfDistancia;
    private String _salvFortaleza;
    private String _salvReflejos;
    private String _salvVoluntad;


    public Personaje(){

    }

    public Personaje(String _nombrePj, String _clasePj, String _nivelPj, String _razaPj, String _alineamientoPj,
                     String _deidadPj, String _tamañoPj, String _sexoPj, String _expPj,
                     String _expLow, String _expHigh, String _campañaPj, String _controlAct,
                     String _puntFZA, String _puntDES, String _puntCON, String _puntINT,
                     String _puntSAB, String _puntCAR, String _modFZA, String _modDES,
                     String _modCON, String _modINT, String _modSAB, String _modCAR, String _ptsHab,
                     String _pg, String _velocidad, String _heridas, String _ca, String _toque,
                     String _iniciativa, String _desprevenido, String _ataque, String _presa, String _resConjuros,
                     String _redDanio, String _bonfAtaque, String _bonfDistancia, String _salvFortaleza, String _salvReflejos,
                     String _salvVoluntad){

        this._nombrePj         = _nombrePj;
        this._clasePj          = _clasePj;
        this._nivelPj          = _nivelPj;
        this._razaPj           = _razaPj;
        this._alineamientoPj   = _alineamientoPj;
        this._deidadPj         = _deidadPj;
        this._tamañoPj         = _tamañoPj;
        this._sexoPj           = _sexoPj;
        this._expPj            = _expPj;
        this._expLow           = _expLow;
        this._expHigh          = _expHigh;
        this._campañaPj        = _campañaPj;
        this._controlAct       = _controlAct;
        this._puntFZA          = _puntFZA;
        this._puntDES          = _puntDES;
        this._puntCON          = _puntCON;
        this._puntINT          = _puntINT;
        this._puntSAB          = _puntSAB;
        this._puntCAR          = _puntCAR;
        this._modFZA           = _modFZA;
        this._modDES           = _modDES;
        this._modCON           = _modCON;
        this._modINT           = _modINT;
        this._modSAB           = _modSAB;
        this._modCAR           = _modCAR;
        this._ptsHab           = _ptsHab;
        this._pg               = _pg;
        this._velocidad        = _velocidad;
        this._heridas          = _heridas;
        this._ca               = _ca;
        this._toque            = _toque;
        this._iniciativa       = _iniciativa;
        this._desprevenido     = _desprevenido;
        this._ataque           = _ataque;
        this._presa            = _presa;
        this._resConjuros      = _resConjuros;
        this._redDanio         = _redDanio;
        this._bonfAtaque       = _bonfAtaque;
        this._bonfDistancia    = _bonfDistancia;
        this._salvFortaleza    = _salvFortaleza;
        this._salvReflejos     = _salvReflejos;
        this._salvVoluntad     = _salvVoluntad;

    }

    public int get_idPj() {
        return _idPj;
    }

    public void set_idPj(int _idPj) {
        this._idPj = _idPj;
    }

    public String get_nombrePj() {
        return _nombrePj;
    }

    public void set_nombrePj(String _nombrePj) {
        this._nombrePj = _nombrePj;
    }

    public String get_clasePj() {
        return _clasePj;
    }

    public void set_clasePj(String _clasePj) {
        this._clasePj = _clasePj;
    }

    public String get_nivelPj() {
        return _nivelPj;
    }

    public void set_nivelPj(String _nivelPj) {
        this._nivelPj = _nivelPj;
    }

    public String get_razaPj() {
        return _razaPj;
    }

    public void set_razaPj(String _razaPj) {
        this._razaPj = _razaPj;
    }

    public String get_alineamientoPj() {
        return _alineamientoPj;
    }

    public void set_alineamientoPj(String _alineamientoPj) {
        this._alineamientoPj = _alineamientoPj;
    }

    public String get_deidadPj() {
        return _deidadPj;
    }

    public void set_deidadPj(String _deidadPj) {
        this._deidadPj = _deidadPj;
    }

    public String get_tamañoPj() {
        return _tamañoPj;
    }

    public void set_tamañoPj(String _tamañoPj) {
        this._tamañoPj = _tamañoPj;
    }

    public String get_sexoPj() {
        return _sexoPj;
    }

    public void set_sexoPj(String _sexoPj) {
        this._sexoPj = _sexoPj;
    }

    public String get_expPj() {
        return _expPj;
    }

    public void set_expPj(String _expPj) {
        this._expPj = _expPj;
    }

    public String get_expLow() {
        return _expLow;
    }

    public void set_expLow(String _expLow) {
        this._expLow = _expLow;
    }

    public String get_expHigh() {
        return _expHigh;
    }

    public void set_expHigh(String _expHigh) {
        this._expHigh = _expHigh;
    }

    public String get_campañaPj() {
        return _campañaPj;
    }

    public void set_campañaPj(String _campañaPj) {
        this._campañaPj = _campañaPj;
    }

    public String get_controlAct() {
        return _controlAct;
    }

    public void set_controlAct(String _controlAct) {
        this._controlAct = _controlAct;
    }

    public String get_puntFZA() {
        return _puntFZA;
    }

    public void set_puntFZA(String _puntFZA) {
        this._puntFZA = _puntFZA;
    }

    public String get_puntDES() {
        return _puntDES;
    }

    public void set_puntDES(String _puntDES) {
        this._puntDES = _puntDES;
    }

    public String get_puntCON() {
        return _puntCON;
    }

    public void set_puntCON(String _puntCON) {
        this._puntCON = _puntCON;
    }

    public String get_puntINT() {
        return _puntINT;
    }

    public void set_puntINT(String _puntINT) {
        this._puntINT = _puntINT;
    }

    public String get_puntSAB() {
        return _puntSAB;
    }

    public void set_puntSAB(String _puntSAB) {
        this._puntSAB = _puntSAB;
    }

    public String get_puntCAR() {
        return _puntCAR;
    }

    public void set_puntCAR(String _puntCAR) {
        this._puntCAR = _puntCAR;
    }

    public String get_modFZA() {
        return _modFZA;
    }

    public void set_modFZA(String _modFZA) {
        this._modFZA = _modFZA;
    }

    public String get_modDES() {
        return _modDES;
    }

    public void set_modDES(String _modDES) {
        this._modDES = _modDES;
    }

    public String get_modCON() {
        return _modCON;
    }

    public void set_modCON(String _modCON) {
        this._modCON = _modCON;
    }

    public String get_modINT() {
        return _modINT;
    }

    public void set_modINT(String _modINT) {
        this._modINT = _modINT;
    }

    public String get_modSAB() {
        return _modSAB;
    }

    public void set_modSAB(String _modSAB) {
        this._modSAB = _modSAB;
    }

    public String get_modCAR() {
        return _modCAR;
    }

    public void set_modCAR(String _modCAR) {
        this._modCAR = _modCAR;
    }

    public String get_ptsHab() {
        return _ptsHab;
    }

    public void set_ptsHab(String _ptsHab) {
        this._ptsHab = _ptsHab;
    }

    public String get_pg() {
        return _pg;
    }

    public void set_pg(String _pg) {
        this._pg = _pg;
    }

    public String get_velocidad() {
        return _velocidad;
    }

    public void set_velocidad(String _velocidad) {
        this._velocidad = _velocidad;
    }

    public String get_heridas() {
        return _heridas;
    }

    public void set_heridas(String _heridas) {
        this._heridas = _heridas;
    }

    public String get_ca() {
        return _ca;
    }

    public void set_ca(String _ca) {
        this._ca = _ca;
    }

    public String get_toque() {
        return _toque;
    }

    public void set_toque(String _toque) {
        this._toque = _toque;
    }

    public String get_iniciativa() {
        return _iniciativa;
    }

    public void set_iniciativa(String _iniciativa) {
        this._iniciativa = _iniciativa;
    }

    public String get_desprevenido() {
        return _desprevenido;
    }

    public void set_desprevenido(String _desprevenido) {
        this._desprevenido = _desprevenido;
    }

    public String get_ataque() {
        return _ataque;
    }

    public void set_ataque(String _ataque) {
        this._ataque = _ataque;
    }

    public String get_presa() {
        return _presa;
    }

    public void set_presa(String _presa) {
        this._presa = _presa;
    }

    public String get_resConjuros() {
        return _resConjuros;
    }

    public void set_resConjuros(String _resConjuros) {
        this._resConjuros = _resConjuros;
    }

    public String get_redDanio() {
        return _redDanio;
    }

    public void set_redDanio(String _redDanio) {
        this._redDanio = _redDanio;
    }

    public String get_bonfAtaque() {
        return _bonfAtaque;
    }

    public void set_bonfAtaque(String _bonfAtaque) {
        this._bonfAtaque = _bonfAtaque;
    }

    public String get_bonfDistancia() {
        return _bonfDistancia;
    }

    public void set_bonfDistancia(String _bonfDistancia) {
        this._bonfDistancia = _bonfDistancia;
    }

    public String get_salvFortaleza() {
        return _salvFortaleza;
    }

    public void set_salvFortaleza(String _salvFortaleza) {
        this._salvFortaleza = _salvFortaleza;
    }

    public String get_salvReflejos() {
        return _salvReflejos;
    }

    public void set_salvReflejos(String _salvReflejos) {
        this._salvReflejos = _salvReflejos;
    }

    public String get_salvVoluntad() {
        return _salvVoluntad;
    }

    public void set_salvVoluntad(String _salvVoluntad) {
        this._salvVoluntad = _salvVoluntad;
    }
}
