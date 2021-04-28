/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.umanizales.apipaseobarcos.model.excepcion;

/**
 *
 * @author andre
 */
public class ListaSEExcepcion extends Exception{
//obliga a tener un mensaje de excepcion
    public ListaSEExcepcion(String string) {
        super(string);
    }
    
}
