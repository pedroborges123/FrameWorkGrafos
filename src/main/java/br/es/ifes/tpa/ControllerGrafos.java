/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.es.ifes.tpa;

import br.es.ifes.tpa.modelo.Aresta;
import br.es.ifes.tpa.modelo.Cor;
import br.es.ifes.tpa.modelo.Grafo;
import br.es.ifes.tpa.modelo.TipoAtributo;
import br.es.ifes.tpa.modelo.Vertice;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author 20091BSI0222
 */
public class ControllerGrafos {

    private Grafo grafo;

    public ControllerGrafos(Grafo grafo) {
        this.grafo = grafo;
        this.grafo.setAretas(new ArrayList<Aresta>());
        this.grafo.setVertices(new ArrayList<Vertice>());

    }

//    private boolean validaGrafo(Grafo G) {
//
//        for (int i = 0; i < G.getAretas().size(); i++) {
//           
//        }
//        return false;
//
//    }
    // fazer o dfs 
    public void dfs() {
        this.grafo.setTempo(0);

        if (this.grafo.getAretas().isEmpty() && this.grafo.getVertices().isEmpty()) {
            throw new ExceptionInInitializerError("Este Grafo não contem todos os atributos necessarios para executar o DFS! ");
        }


        int tam = this.grafo.getVertices().size();
        for (int i = 0; i < tam; i++) {


            this.grafo.getVertices().get(i).getAtributos().put(TipoAtributo.cor, Cor.Branco);
            this.grafo.getVertices().get(i).getAtributos().put(TipoAtributo.pred, -1);
            this.grafo.getVertices().get(i).getAtributos().put(TipoAtributo.d, 0);
            this.grafo.getVertices().get(i).getAtributos().put(TipoAtributo.t, 0);

        }
        for (int i = 0; i < tam; i++) {
            if (this.grafo.getVertices().get(i).getAtributos().get(TipoAtributo.cor).equals(Cor.Branco)) {
                this.visita(this.grafo.getVertices().get(i));
            }

        }
        this.grafo.makeAction();
    }

    private ArrayList<Vertice> listAdj(Vertice v) {

        ArrayList<Vertice> listadj = new ArrayList<>();
        int tam = this.grafo.getAretas().size();
        for (int i = 0; i < tam; i++) {
            if (this.grafo.getAretas().get(i).getOrigem().equals(v)) {
                listadj.add(this.grafo.getAretas().get(i).getDestino());
            }

        }

        return listadj;

    }

    private void visita(Vertice v) {
        

        v.getAtributos().remove(TipoAtributo.cor);
        v.getAtributos().put(TipoAtributo.cor, Cor.Cinza);

        this.grafo.setTempo(this.grafo.getTempo() + 1);

        v.getAtributos().put(TipoAtributo.d, this.grafo.getTempo());

        ArrayList<Vertice> adj = this.listAdj(v);
        int tam = adj.size();
        for (int x = 0; x < tam; x++) {

            if (adj.get(x).getAtributos().get(TipoAtributo.cor).equals(Cor.Branco)) {

                adj.get(x).getAtributos().put(TipoAtributo.pred, v);
                this.visita(adj.get(x));
            }

        }
        v.getAtributos().put(TipoAtributo.cor, Cor.Preto);
        this.grafo.setTempo(this.grafo.getTempo() + 1);
        v.getAtributos().put(TipoAtributo.t, this.grafo.getTempo());


    }






}