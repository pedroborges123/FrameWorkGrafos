/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.es.ifes.tpa.modelo;

import java.util.LinkedList;

/**
 *
 * @author 20091BSI0222
 */
public class Fila {

    private LinkedList<Object> fila;

    public Fila() {
        this.fila = new LinkedList<Object>();
    }

    public void insert(Object obj) {
        this.fila.addLast(obj);

    }

    public boolean isEmpty() {
        return this.fila.isEmpty();

    }

    public Object getFristOfQueue() {
        Object objeto;
        if (this.fila.isEmpty()) {
            return null;
        } else {
            objeto = this.fila.getFirst();
            this.fila.removeFirst();
            return objeto;
        }
    }

    public Object remove(Object obj) {

        return this.fila.removeFirst();

    }

    public void EmptyQueue() {
        while (!this.fila.isEmpty()) {
            this.fila.removeFirst();
        }
    }

}
