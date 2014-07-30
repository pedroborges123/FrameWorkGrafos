/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.es.ifes.tpa.modelo;

import java.util.ArrayList;

/**
 *
 * @author 20091BSI0222
 */
public abstract class Grafo {
    
    protected ArrayList<Aresta> aretas;
    protected ArrayList<Vertice> vertices;
    protected int tempo;
    
    public abstract void makeAction();

    public int getTempo() {
        return tempo;
    }

    public void setTempo(int tempo) {
        this.tempo = tempo;
    }

    public ArrayList<Aresta> getAretas() {
        return aretas;
    }

    public void setAretas(ArrayList<Aresta> aretas) {
        this.aretas = aretas;
    }

    public ArrayList<Vertice> getVertices() {
        return vertices;
    }

    public void setVertices(ArrayList<Vertice> vertices) {
        this.vertices = vertices;
    }
    
    
    
}
