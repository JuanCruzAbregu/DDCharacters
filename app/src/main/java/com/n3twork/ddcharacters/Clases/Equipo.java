package com.n3twork.ddcharacters.Clases;

public class Equipo {


    private int    _idPj;
    private String _arma1Arma;
    private String _arma1Danio;
    private String _arma1Critico;
    private String _arma1Tipo;
    private String _arma1Peso;
    private String _arma1Alcance;
    private String _arma1Notas;
    private String _arma1Municion;
    private String _arma2Arma;
    private String _arma2Danio;
    private String _arma2Critico;
    private String _arma2Tipo;
    private String _arma2Peso;
    private String _arma2Alcance;
    private String _arma2Notas;
    private String _arma2Municion;
    private String _arma3Arma;
    private String _arma3Danio;
    private String _arma3Critico;
    private String _arma3Tipo;
    private String _arma3Peso;
    private String _arma3Alcance;
    private String _arma3Notas;
    private String _arma3Municion;
    private String _arma4Arma;
    private String _arma4Danio;
    private String _arma4Critico;
    private String _arma4Tipo;
    private String _arma4Peso;
    private String _arma4Alcance;
    private String _arma4Notas;
    private String _arma4Municion;
    private String _arma5Arma;
    private String _arma5Danio;
    private String _arma5Critico;
    private String _arma5Tipo;
    private String _arma5Peso;
    private String _arma5Alcance;
    private String _arma5Notas;
    private String _arma5Municion;
    private String _armaduraArmadura;
    private String _armaduraCa;
    private String _armaduraDesMax;
    private String _armaduraTipo;
    private String _armaduraPen;
    private String _armaduraVelocidad;
    private String _armaduraPeso;
    private String _armaduraFallo;
    private String _armaduraEsp;
    private int _idPersonaje;

    public Equipo(){

    }

    public Equipo(String _arma1Arma, String _arma1Danio, String _arma1Critico,
                  String _arma1Tipo, String _arma1Peso,  String _arma1Alcance, String _arma1Notas, String _arma1Municion,
                  String _arma2Arma, String _arma2Danio, String _arma2Critico, String _arma2Tipo, String _arma2Peso, String _arma2Alcance, String _arma2Notas, String _arma2Municion,
                  String _arma3Arma, String _arma3Danio, String _arma3Critico, String _arma3Tipo, String _arma3Peso, String _arma3Alcance, String _arma3Notas, String _arma3Municion,
                  String _arma4Arma, String _arma4Danio, String _arma4Critico, String _arma4Tipo, String _arma4Peso, String _arma4Alcance, String _arma4Notas, String _arma4Municion,
                  String _arma5Arma, String _arma5Danio, String _arma5Critico, String _arma5Tipo, String _arma5Peso, String _arma5Alcance, String _arma5Notas, String _arma5Municion,
                  String _armaduraArmadura, String _armaduraCa, String _armaduraDesMax, String _armaduraTipo, String _armaduraPen,
                  String _armaduraVelocidad, String _armaduraPeso, String _armaduraFallo, String _armaduraEsp, int _idPersonaje){

        this._arma1Arma = _arma1Arma;
        this._arma1Danio = _arma1Danio;
        this._arma1Critico = _arma1Critico;
        this._arma1Tipo = _arma1Tipo;
        this._arma1Peso = _arma1Peso;
        this._arma1Alcance = _arma1Alcance;
        this._arma1Notas = _arma1Notas;
        this._arma1Municion = _arma1Municion;
        this._arma2Arma = _arma2Arma;
        this._arma2Danio = _arma2Danio;
        this._arma2Critico = _arma2Critico;
        this._arma2Tipo = _arma2Tipo;
        this._arma2Peso = _arma2Peso;
        this._arma2Alcance = _arma2Alcance;
        this._arma2Notas = _arma2Notas;
        this._arma2Municion = _arma2Municion;
        this._arma3Arma = _arma3Arma;
        this._arma3Danio = _arma3Danio;
        this._arma3Critico = _arma3Critico;
        this._arma3Tipo = _arma3Tipo;
        this._arma3Peso = _arma3Peso;
        this._arma3Alcance = _arma3Alcance;
        this._arma3Notas = _arma3Notas;
        this._arma3Municion = _arma3Municion;
        this._arma4Arma = _arma4Arma;
        this._arma4Danio = _arma4Danio;
        this._arma4Critico = _arma4Critico;
        this._arma4Tipo = _arma4Tipo;
        this._arma4Peso = _arma4Peso;
        this._arma4Alcance = _arma4Alcance;
        this._arma4Notas = _arma4Notas;
        this._arma4Municion = _arma4Municion;
        this._arma5Arma = _arma5Arma;
        this._arma5Danio = _arma5Danio;
        this._arma5Critico = _arma5Critico;
        this._arma5Tipo = _arma5Tipo;
        this._arma5Peso = _arma5Peso;
        this._arma5Alcance = _arma5Alcance;
        this._arma5Notas = _arma5Notas;
        this._arma5Municion = _arma5Municion;
        this._armaduraArmadura = _armaduraArmadura;
        this._armaduraCa = _armaduraCa;
        this._armaduraDesMax = _armaduraDesMax;
        this._armaduraTipo = _armaduraTipo;
        this._armaduraPen = _armaduraPen;
        this._armaduraVelocidad = _armaduraVelocidad;
        this._armaduraPeso = _armaduraPeso;
        this._armaduraFallo = _armaduraFallo;
        this._armaduraEsp = _armaduraEsp;
        this._idPersonaje = _idPersonaje;

    }

    public int get_idPj() {
        return _idPj;
    }

    public void set_idPj(int _idPj) {
        this._idPj = _idPj;
    }

    public String get_arma1Arma() {
        return _arma1Arma;
    }

    public void set_arma1Arma(String _arma1Arma) {
        this._arma1Arma = _arma1Arma;
    }

    public String get_arma1Danio() {
        return _arma1Danio;
    }

    public void set_arma1Danio(String _arma1Danio) {
        this._arma1Danio = _arma1Danio;
    }

    public String get_arma1Critico() {
        return _arma1Critico;
    }

    public void set_arma1Critico(String _arma1Critico) {
        this._arma1Critico = _arma1Critico;
    }

    public String get_arma1Tipo() {
        return _arma1Tipo;
    }

    public void set_arma1Tipo(String _arma1Tipo) {
        this._arma1Tipo = _arma1Tipo;
    }

    public String get_arma1Peso() {
        return _arma1Peso;
    }

    public void set_arma1Peso(String _arma1Peso) {
        this._arma1Peso = _arma1Peso;
    }

    public String get_arma1Alcance() {
        return _arma1Alcance;
    }

    public void set_arma1Alcance(String _arma1Alcance) {
        this._arma1Alcance = _arma1Alcance;
    }

    public String get_arma1Notas() {
        return _arma1Notas;
    }

    public void set_arma1Notas(String _arma1Notas) {
        this._arma1Notas = _arma1Notas;
    }

    public String get_arma1Municion() {
        return _arma1Municion;
    }

    public void set_arma1Municion(String _arma1Municion) {
        this._arma1Municion = _arma1Municion;
    }

    public String get_arma2Arma() {
        return _arma2Arma;
    }

    public void set_arma2Arma(String _arma2Arma) {
        this._arma2Arma = _arma2Arma;
    }

    public String get_arma2Danio() {
        return _arma2Danio;
    }

    public void set_arma2Danio(String _arma2Danio) {
        this._arma2Danio = _arma2Danio;
    }

    public String get_arma2Critico() {
        return _arma2Critico;
    }

    public void set_arma2Critico(String _arma2Critico) {
        this._arma2Critico = _arma2Critico;
    }

    public String get_arma2Tipo() {
        return _arma2Tipo;
    }

    public void set_arma2Tipo(String _arma2Tipo) {
        this._arma2Tipo = _arma2Tipo;
    }

    public String get_arma2Peso() {
        return _arma2Peso;
    }

    public void set_arma2Peso(String _arma2Peso) {
        this._arma2Peso = _arma2Peso;
    }

    public String get_arma2Alcance() {
        return _arma2Alcance;
    }

    public void set_arma2Alcance(String _arma2Alcance) {
        this._arma2Alcance = _arma2Alcance;
    }

    public String get_arma2Notas() {
        return _arma2Notas;
    }

    public void set_arma2Notas(String _arma2Notas) {
        this._arma2Notas = _arma2Notas;
    }

    public String get_arma2Municion() {
        return _arma2Municion;
    }

    public void set_arma2Municion(String _arma2Municion) {
        this._arma2Municion = _arma2Municion;
    }

    public String get_arma3Arma() {
        return _arma3Arma;
    }

    public void set_arma3Arma(String _arma3Arma) {
        this._arma3Arma = _arma3Arma;
    }

    public String get_arma3Danio() {
        return _arma3Danio;
    }

    public void set_arma3Danio(String _arma3Danio) {
        this._arma3Danio = _arma3Danio;
    }

    public String get_arma3Critico() {
        return _arma3Critico;
    }

    public void set_arma3Critico(String _arma3Critico) {
        this._arma3Critico = _arma3Critico;
    }

    public String get_arma3Tipo() {
        return _arma3Tipo;
    }

    public void set_arma3Tipo(String _arma3Tipo) {
        this._arma3Tipo = _arma3Tipo;
    }

    public String get_arma3Peso() {
        return _arma3Peso;
    }

    public void set_arma3Peso(String _arma3Peso) {
        this._arma3Peso = _arma3Peso;
    }

    public String get_arma3Alcance() {
        return _arma3Alcance;
    }

    public void set_arma3Alcance(String _arma3Alcance) {
        this._arma3Alcance = _arma3Alcance;
    }

    public String get_arma3Notas() {
        return _arma3Notas;
    }

    public void set_arma3Notas(String _arma3Notas) {
        this._arma3Notas = _arma3Notas;
    }

    public String get_arma3Municion() {
        return _arma3Municion;
    }

    public void set_arma3Municion(String _arma3Municion) {
        this._arma3Municion = _arma3Municion;
    }

    public String get_arma4Arma() {
        return _arma4Arma;
    }

    public void set_arma4Arma(String _arma4Arma) {
        this._arma4Arma = _arma4Arma;
    }

    public String get_arma4Danio() {
        return _arma4Danio;
    }

    public void set_arma4Danio(String _arma4Danio) {
        this._arma4Danio = _arma4Danio;
    }

    public String get_arma4Critico() {
        return _arma4Critico;
    }

    public void set_arma4Critico(String _arma4Critico) {
        this._arma4Critico = _arma4Critico;
    }

    public String get_arma4Tipo() {
        return _arma4Tipo;
    }

    public void set_arma4Tipo(String _arma4Tipo) {
        this._arma4Tipo = _arma4Tipo;
    }

    public String get_arma4Peso() {
        return _arma4Peso;
    }

    public void set_arma4Peso(String _arma4Peso) {
        this._arma4Peso = _arma4Peso;
    }

    public String get_arma4Alcance() {
        return _arma4Alcance;
    }

    public void set_arma4Alcance(String _arma4Alcance) {
        this._arma4Alcance = _arma4Alcance;
    }

    public String get_arma4Notas() {
        return _arma4Notas;
    }

    public void set_arma4Notas(String _arma4Notas) {
        this._arma4Notas = _arma4Notas;
    }

    public String get_arma4Municion() {
        return _arma4Municion;
    }

    public void set_arma4Municion(String _arma4Municion) {
        this._arma4Municion = _arma4Municion;
    }

    public String get_arma5Arma() {
        return _arma5Arma;
    }

    public void set_arma5Arma(String _arma5Arma) {
        this._arma5Arma = _arma5Arma;
    }

    public String get_arma5Danio() {
        return _arma5Danio;
    }

    public void set_arma5Danio(String _arma5Danio) {
        this._arma5Danio = _arma5Danio;
    }

    public String get_arma5Critico() {
        return _arma5Critico;
    }

    public void set_arma5Critico(String _arma5Critico) {
        this._arma5Critico = _arma5Critico;
    }

    public String get_arma5Tipo() {
        return _arma5Tipo;
    }

    public void set_arma5Tipo(String _arma5Tipo) {
        this._arma5Tipo = _arma5Tipo;
    }

    public String get_arma5Peso() {
        return _arma5Peso;
    }

    public void set_arma5Peso(String _arma5Peso) {
        this._arma5Peso = _arma5Peso;
    }

    public String get_arma5Alcance() {
        return _arma5Alcance;
    }

    public void set_arma5Alcance(String _arma5Alcance) {
        this._arma5Alcance = _arma5Alcance;
    }

    public String get_arma5Notas() {
        return _arma5Notas;
    }

    public void set_arma5Notas(String _arma5Notas) {
        this._arma5Notas = _arma5Notas;
    }

    public String get_arma5Municion() {
        return _arma5Municion;
    }

    public void set_arma5Municion(String _arma5Municion) {
        this._arma5Municion = _arma5Municion;
    }

    public int get_idPersonaje() {
        return _idPersonaje;
    }

    public void set_idPersonaje(int _idPersonaje) {
        this._idPersonaje = _idPersonaje;
    }

    public String get_armaduraArmadura() {
        return _armaduraArmadura;
    }

    public void set_armaduraArmadura(String _armaduraArmadura) {
        this._armaduraArmadura = _armaduraArmadura;
    }

    public String get_armaduraCa() {
        return _armaduraCa;
    }

    public void set_armaduraCa(String _armaduraCa) {
        this._armaduraCa = _armaduraCa;
    }

    public String get_armaduraDesMax() {
        return _armaduraDesMax;
    }

    public void set_armaduraDesMax(String _armaduraDesMax) {
        this._armaduraDesMax = _armaduraDesMax;
    }

    public String get_armaduraTipo() {
        return _armaduraTipo;
    }

    public void set_armaduraTipo(String _armaduraTipo) {
        this._armaduraTipo = _armaduraTipo;
    }

    public String get_armaduraPen() {
        return _armaduraPen;
    }

    public void set_armaduraPen(String _armaduraPen) {
        this._armaduraPen = _armaduraPen;
    }

    public String get_armaduraVelocidad() {
        return _armaduraVelocidad;
    }

    public void set_armaduraVelocidad(String _armaduraVelocidad) {
        this._armaduraVelocidad = _armaduraVelocidad;
    }

    public String get_armaduraPeso() {
        return _armaduraPeso;
    }

    public void set_armaduraPeso(String _armaduraPeso) {
        this._armaduraPeso = _armaduraPeso;
    }

    public String get_armaduraFallo() {
        return _armaduraFallo;
    }

    public void set_armaduraFallo(String _armaduraFallo) {
        this._armaduraFallo = _armaduraFallo;
    }

    public String get_armaduraEsp() {
        return _armaduraEsp;
    }

    public void set_armaduraEsp(String _armaduraEsp) {
        this._armaduraEsp = _armaduraEsp;
    }
}
