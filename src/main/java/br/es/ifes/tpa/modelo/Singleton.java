/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.es.ifes.tpa.modelo;

/**
 *
 * @author Pedro
 */
public enum Singleton {
    
    INSTANCE;
    
    private int cont = 0;
    
    public synchronized int getNextSerial(){
        return cont ++;
        
    }
}
