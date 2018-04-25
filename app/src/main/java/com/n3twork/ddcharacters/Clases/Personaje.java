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
    private String _cerradura;
    private String _arte;
    private String _intenciones;
    private String _avistar;
    private String _buscar;
    private String _concentracion;
    private String _concConjuros;
    private String _escritura;
    private String _diplomacia;
    private String _disfrazarse;
    private String _enganiar;
    private String _equilibrio;
    private String _escapismo;
    private String _esconderse;
    private String _escuchar;
    private String _falsificar;
    private String _interpretar1;
    private String _interpretar2;
    private String _interpretar3;
    private String _intimidar;
    private String _mecanismo;
    private String _manos;
    private String _montar;
    private String _sigilo;
    private String _nadar;
    private String _oficio;
    private String _piruetas;
    private String _info;
    private String _arcano;
    private String _arquitectura;
    private String _dungeons;
    private String _geografia;
    private String _historia;
    private String _local;
    private String _planos;
    private String _naturaleza;
    private String _nobleza;
    private String _religion;
    private String _saltar;
    private String _sanar;
    private String _supervivencia;
    private String _tasacion;
    private String _animales;
    private String _trepar;
    private String _objMagico;
    private String _cuerdas;


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
                     String _salvVoluntad, String _cerradura, String _arte, String _intenciones, String _avistar, String _buscar,
                     String _concentracion, String _concConjuros, String _escritura, String _diplomacia, String _disfrazarse,
                     String _enganiar, String _equilibrio, String _escapismo, String _esconderse, String _escuchar, String _falsificar,
                     String _interpretar1, String _interpretar2, String _interpretar3, String _intimidar, String _mecanismo,
                     String _manos, String _montar, String _sigilo, String _nadar, String _oficio, String _piruetas,String _info,
                     String _arcano, String _arquitectura, String _dungeons, String _geografia, String _historia, String _local,
                     String _planos, String _naturaleza, String _nobleza, String _religion, String _saltar,
                     String _sanar, String _supervivencia, String _tasacion, String _animales, String _trepar,
                     String _objMagico, String _cuerdas){

        this._nombrePj       = _nombrePj;
        this._clasePj        = _clasePj;
        this._nivelPj        = _nivelPj;
        this._razaPj         = _razaPj;
        this._alineamientoPj = _alineamientoPj;
        this._deidadPj       = _deidadPj;
        this._tamañoPj       = _tamañoPj;
        this._sexoPj         = _sexoPj;
        this._expPj          = _expPj;
        this._expLow         = _expLow;
        this._expHigh        = _expHigh;
        this._campañaPj      = _campañaPj;
        this._controlAct     = _controlAct;
        this._puntFZA        = _puntFZA;
        this._puntDES        = _puntDES;
        this._puntCON        = _puntCON;
        this._puntINT        = _puntINT;
        this._puntSAB        = _puntSAB;
        this._puntCAR        = _puntCAR;
        this._modFZA         = _modFZA;
        this._modDES         = _modDES;
        this._modCON         = _modCON;
        this._modINT         = _modINT;
        this._modSAB         = _modSAB;
        this._modCAR         = _modCAR;
        this._ptsHab         = _ptsHab;
        this._pg             = _pg;
        this._velocidad      = _velocidad;
        this._heridas        = _heridas;
        this._ca             = _ca;
        this._toque          = _toque;
        this._iniciativa     = _iniciativa;
        this._desprevenido   = _desprevenido;
        this._ataque         = _ataque;
        this._presa          = _presa;
        this._resConjuros    = _resConjuros;
        this._redDanio       = _redDanio;
        this._bonfAtaque     = _bonfAtaque;
        this._bonfDistancia  = _bonfDistancia;
        this._salvFortaleza  = _salvFortaleza;
        this._salvReflejos   = _salvReflejos;
        this._salvVoluntad   = _salvVoluntad;
        this._cerradura      = _cerradura;
        this._arte           = _salvVoluntad;
        this._intenciones    = _intenciones;
        this._avistar        = _avistar;
        this._buscar         = _buscar;
        this._concentracion  = _concentracion;
        this._concConjuros   = _concConjuros;
        this._escritura      = _escritura;
        this._diplomacia     = _diplomacia;
        this._disfrazarse    = _disfrazarse;
        this._enganiar       = _enganiar;
        this._equilibrio     = _equilibrio;
        this._escapismo      = _escapismo;
        this._esconderse     = _esconderse;
        this._escuchar       = _escuchar;
        this._falsificar     = _falsificar;
        this._interpretar1   = _interpretar1;
        this._interpretar2   = _interpretar2;
        this._interpretar3   = _interpretar3;
        this._intimidar      = _intimidar;
        this._mecanismo      = _mecanismo;
        this._manos          = _manos;
        this._montar         = _montar;
        this._sigilo         = _sigilo;
        this._nadar          = _nadar;
        this._oficio         = _oficio;
        this._piruetas       = _piruetas;
        this._info           = _info;
        this._arcano         = _arcano;
        this._arquitectura   = _arquitectura;
        this._dungeons       = _dungeons;
        this._geografia      = _geografia;
        this._historia       = _historia;
        this._local          = _local;
        this._planos         = _planos;
        this._naturaleza     = _naturaleza;
        this._religion       = _religion;
        this._saltar         = _saltar;
        this._sanar          = _sanar;
        this._supervivencia  = _supervivencia;
        this._tasacion       = _tasacion;
        this._animales       = _animales;
        this._trepar         = _trepar;
        this._objMagico      = _objMagico;
        this._cuerdas        = _cuerdas;

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

    public String get_cerradura() {
        return _cerradura;
    }

    public void set_cerradura(String _cerradura) {
        this._cerradura = _cerradura;
    }

    public String get_arte() {
        return _arte;
    }

    public void set_arte(String _arte) {
        this._arte = _arte;
    }

    public String get_intenciones() {
        return _intenciones;
    }

    public void set_intenciones(String _intenciones) {
        this._intenciones = _intenciones;
    }

    public String get_avistar() {
        return _avistar;
    }

    public void set_avistar(String _avistar) {
        this._avistar = _avistar;
    }

    public String get_buscar() {
        return _buscar;
    }

    public void set_buscar(String _buscar) {
        this._buscar = _buscar;
    }

    public String get_concentracion() {
        return _concentracion;
    }

    public void set_concentracion(String _concentracion) {
        this._concentracion = _concentracion;
    }

    public String get_concConjuros() {
        return _concConjuros;
    }

    public void set_concConjuros(String _concConjuros) {
        this._concConjuros = _concConjuros;
    }

    public String get_escritura() {
        return _escritura;
    }

    public void set_escritura(String _escritura) {
        this._escritura = _escritura;
    }

    public String get_diplomacia() {
        return _diplomacia;
    }

    public void set_diplomacia(String _diplomacia) {
        this._diplomacia = _diplomacia;
    }

    public String get_disfrazarse() {
        return _disfrazarse;
    }

    public void set_disfrazarse(String _disfrazarse) {
        this._disfrazarse = _disfrazarse;
    }

    public String get_enganiar() {
        return _enganiar;
    }

    public void set_enganiar(String _enganiar) {
        this._enganiar = _enganiar;
    }

    public String get_equilibrio() {
        return _equilibrio;
    }

    public void set_equilibrio(String _equilibrio) {
        this._equilibrio = _equilibrio;
    }

    public String get_escapismo() {
        return _escapismo;
    }

    public void set_escapismo(String _escapismo) {
        this._escapismo = _escapismo;
    }

    public String get_esconderse() {
        return _esconderse;
    }

    public void set_esconderse(String _esconderse) {
        this._esconderse = _esconderse;
    }

    public String get_escuchar() {
        return _escuchar;
    }

    public void set_escuchar(String _escuchar) {
        this._escuchar = _escuchar;
    }

    public String get_falsificar() {
        return _falsificar;
    }

    public void set_falsificar(String _falsificar) {
        this._falsificar = _falsificar;
    }

    public String get_interpretar1() {
        return _interpretar1;
    }

    public void set_interpretar1(String _interpretar1) {
        this._interpretar1 = _interpretar1;
    }

    public String get_interpretar2() {
        return _interpretar2;
    }

    public void set_interpretar2(String _interpretar2) {
        this._interpretar2 = _interpretar2;
    }

    public String get_interpretar3() {
        return _interpretar3;
    }

    public void set_interpretar3(String _interpretar3) {
        this._interpretar3 = _interpretar3;
    }

    public String get_intimidar() {
        return _intimidar;
    }

    public void set_intimidar(String _intimidar) {
        this._intimidar = _intimidar;
    }

    public String get_mecanismo() {
        return _mecanismo;
    }

    public void set_mecanismo(String _mecanismo) {
        this._mecanismo = _mecanismo;
    }

    public String get_manos() {
        return _manos;
    }

    public void set_manos(String _manos) {
        this._manos = _manos;
    }

    public String get_montar() {
        return _montar;
    }

    public void set_montar(String _montar) {
        this._montar = _montar;
    }

    public String get_sigilo() {
        return _sigilo;
    }

    public void set_sigilo(String _sigilo) {
        this._sigilo = _sigilo;
    }

    public String get_nadar() {
        return _nadar;
    }

    public void set_nadar(String _nadar) {
        this._nadar = _nadar;
    }

    public String get_oficio() {
        return _oficio;
    }

    public void set_oficio(String _oficio) {
        this._oficio = _oficio;
    }

    public String get_piruetas() {
        return _piruetas;
    }

    public void set_piruetas(String _piruetas) {
        this._piruetas = _piruetas;
    }

    public String get_info() {
        return _info;
    }

    public void set_info(String _info) {
        this._info = _info;
    }

    public String get_arcano() {
        return _arcano;
    }

    public void set_arcano(String _arcano) {
        this._arcano = _arcano;
    }

    public String get_arquitectura() {
        return _arquitectura;
    }

    public void set_arquitectura(String _arquitectura) {
        this._arquitectura = _arquitectura;
    }

    public String get_dungeons() {
        return _dungeons;
    }

    public void set_dungeons(String _dungeons) {
        this._dungeons = _dungeons;
    }

    public String get_geografia() {
        return _geografia;
    }

    public void set_geografia(String _geografia) {
        this._geografia = _geografia;
    }

    public String get_historia() {
        return _historia;
    }

    public void set_historia(String _historia) {
        this._historia = _historia;
    }

    public String get_local() {
        return _local;
    }

    public void set_local(String _local) {
        this._local = _local;
    }

    public String get_planos() {
        return _planos;
    }

    public void set_planos(String _planos) {
        this._planos = _planos;
    }

    public String get_naturaleza() {
        return _naturaleza;
    }

    public void set_naturaleza(String _naturaleza) {
        this._naturaleza = _naturaleza;
    }

    public String get_nobleza() {
        return _nobleza;
    }

    public void set_nobleza(String _nobleza) {
        this._nobleza = _nobleza;
    }

    public String get_religion() {
        return _religion;
    }

    public void set_religion(String _religion) {
        this._religion = _religion;
    }

    public String get_saltar() {
        return _saltar;
    }

    public void set_saltar(String _saltar) {
        this._saltar = _saltar;
    }

    public String get_sanar() {
        return _sanar;
    }

    public void set_sanar(String _sanar) {
        this._sanar = _sanar;
    }

    public String get_supervivencia() {
        return _supervivencia;
    }

    public void set_supervivencia(String _supervivencia) {
        this._supervivencia = _supervivencia;
    }

    public String get_tasacion() {
        return _tasacion;
    }

    public void set_tasacion(String _tasacion) {
        this._tasacion = _tasacion;
    }

    public String get_animales() {
        return _animales;
    }

    public void set_animales(String _animales) {
        this._animales = _animales;
    }

    public String get_trepar() {
        return _trepar;
    }

    public void set_trepar(String _trepar) {
        this._trepar = _trepar;
    }

    public String get_objMagico() {
        return _objMagico;
    }

    public void set_objMagico(String _objMagico) {
        this._objMagico = _objMagico;
    }

    public String get_cuerdas() {
        return _cuerdas;
    }

    public void set_cuerdas(String _cuerdas) {
        this._cuerdas = _cuerdas;
    }
}
