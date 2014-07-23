/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.es.ifes.tpa.modelo;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author 20091BSI0222
 */
public class Aresta {

    private Vertice origem;
    private Vertice destino;
    private Map<TipoAtributo, Object> atributos;

    public Aresta(Vertice origem, Vertice destino) {
        this.origem = origem;
        this.destino = destino;
        this.atributos = new HashMap<>();
    }

    public Vertice getOrigem() {
        return origem;
    }

    public void setOrigem(Vertice origem) {
        this.origem = origem;
    }

    public Vertice getDestino() {
        return destino;
    }

    public void setDestino(Vertice destino) {
        this.destino = destino;
    }

    public Map<TipoAtributo, Object> getAtributos() {
        return atributos;
    }

    public void setAtributos(Map<TipoAtributo, Object> atributos) {
        this.atributos = atributos;
    }

    @Override
    public String toString() {
        return "Aresta{" + "origem: " + origem + "----->>> destino: " + destino + '}';
    }
    
    
    
}
