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
public class Vertice {
    
    private Integer id;
    private String nome;
    private Map<TipoAtributo, Object> atributos;

    public Vertice(String nome) {
        this.nome = nome;
        this.id = Singleton.INSTANCE.getNextSerial();
        this.atributos= new HashMap<>();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Map<TipoAtributo, Object> getAtributos() {
        return atributos;
    }

    public void setAtributos(Map<TipoAtributo, Object> atributos) {
        this.atributos = atributos;
    }
    
    
    
}
