/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.umanizales.apipaseobarcos.model;

import java.io.Serializable;

import com.umanizales.apipaseobarcos.model.excepcion.ListaSEExcepcion;


/**
 *
 * @author andre
 */
public class ListaSE implements Serializable{
    private Nodo cabeza;
    private  int  cont;

    public ListaSE() {
        this.cont = 0;
    }

    public Nodo getCabeza() {
        return cabeza;
    }

    public void setCabeza(Nodo cabeza) {
        this.cabeza = cabeza;
    }
    
    public void adicionarAlFinal(Object dato)  {
        if(cabeza==null){
            cabeza = new Nodo(dato);
            cont++;
        }else{
            Nodo temp = cabeza;
            while(temp.getSiguiente()!=null){
                temp=temp.getSiguiente();
            }
            //en el ultimo
            temp.setSiguiente(new Nodo(dato));
            cont++;
        }
    }

    public  void adicionarAlInicio(Object dato)
    {
        if (cabeza == null){
            cabeza = new Nodo(dato);
            cont++;
        }else {
            Nodo temp = new Nodo(dato);
            temp.setSiguiente(cabeza);
            cabeza=temp;

            cont ++;

        }
    }


    public String listadoNodos(){
        String listado = "";
        Nodo temp = cabeza;
        while(temp!=null)
        {
            listado = listado + temp.getDato();
            temp = temp.getSiguiente();
        }
        return listado;
    }

    public int getCont() {
        return cont;
    }

    public Object EncontrarDatoPorCodigo(String codigo){
        if (cabeza != null){
            Nodo temp=cabeza;
            while (temp!=null){
                if (temp.getDato().equals(codigo)){
                    return temp.getDato();
                }
                temp = temp.getSiguiente();
            }
        }
        return null;
    }
}
