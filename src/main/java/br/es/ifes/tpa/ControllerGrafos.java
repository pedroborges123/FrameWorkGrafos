/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.es.ifes.tpa;

import br.es.ifes.tpa.modelo.Aresta;
import br.es.ifes.tpa.modelo.Cor;
import br.es.ifes.tpa.modelo.Fila;
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
            this.grafo.getVertices().get(i).getAtributos().clear();
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

        int tam = this.grafo.getAretas().size();
        for (int x = 0; x < tam; x++) {
            if (this.grafo.getAretas().get(x).getOrigem().equals(v)) {

                if (this.grafo.getAretas().get(x).getDestino().getAtributos().get(TipoAtributo.cor).equals(Cor.Branco)) {

                    this.grafo.getAretas().get(x).getDestino().getAtributos().put(TipoAtributo.pred, v);
                    this.visita(this.grafo.getAretas().get(x).getDestino());
                }
            }
        }
        v.getAtributos().put(TipoAtributo.cor, Cor.Preto);
        this.grafo.setTempo(this.grafo.getTempo() + 1);
        v.getAtributos().put(TipoAtributo.t, this.grafo.getTempo());

    }

    public void VisitaBFS() {

        this.grafo.setTempo(0);

        if (this.grafo.getAretas().isEmpty() && this.grafo.getVertices().isEmpty()) {

            throw new ExceptionInInitializerError("Este Grafo não contem todos os atributos necessarios para executar o BFS! ");
        }

        int tam = this.grafo.getVertices().size();

        for (int i = 0; i < tam; i++) {
            this.grafo.getVertices().get(i).getAtributos().clear();
            this.grafo.getVertices().get(i).getAtributos().put(TipoAtributo.cor, Cor.Branco);
            this.grafo.getVertices().get(i).getAtributos().put(TipoAtributo.d, Integer.MAX_VALUE);
            this.grafo.getVertices().get(i).getAtributos().put(TipoAtributo.antecessor, null);

        }
        for (int j = 0; j < tam; j++) {
            if (this.grafo.getVertices().get(j).getAtributos().get(TipoAtributo.cor).equals(Cor.Branco)) {
                this.BFS(this.grafo.getVertices().get(j));

            }

        }
        this.grafo.makeAction();
    }

    private void BFS(Vertice s) {
        Fila Q = new Fila();

        s.getAtributos().put(TipoAtributo.cor, Cor.Cinza);

        s.getAtributos().put(TipoAtributo.d, 0);
        Q.EmptyQueue();
        Q.insert(s);
        while (!Q.isEmpty()) {
            Vertice u = (Vertice) Q.remove(s);
            for (int i = 0; i < this.grafo.getAretas().size(); i++) {
                if (this.grafo.getAretas().get(i).getOrigem().equals(u)) {
                    if (this.grafo.getAretas().get(i).getDestino().getAtributos().get(TipoAtributo.cor).equals(Cor.Branco)) {

                        this.grafo.getAretas().get(i).getDestino().getAtributos().put(TipoAtributo.cor, Cor.Cinza);
                        int t = 1 + (int) u.getAtributos().get(TipoAtributo.d);
                        this.grafo.getAretas().get(i).getDestino().getAtributos().put(TipoAtributo.d, t);
                        this.grafo.getAretas().get(i).getDestino().getAtributos().put(TipoAtributo.antecessor, u);
                        Q.insert(this.grafo.getAretas().get(i).getDestino());

                    }

                }

            }
            u.getAtributos().put(TipoAtributo.cor, Cor.Preto);
        }

    }

}
