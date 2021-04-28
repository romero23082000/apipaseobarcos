package com.umanizales.apipaseobarcos.service;


import com.umanizales.apipaseobarcos.model.Empleado;
import com.umanizales.apipaseobarcos.model.ListaSE;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@Service
public class ListaSEService {
    private ListaSE listaSE;

    public ListaSEService() {
        this.listaSE = new ListaSE();
        //bd llenar la lista
        listaSE.adicionarAlInicio(new Empleado("pedro perez","1007234253",5000000));
        listaSE.adicionarAlInicio(new Empleado("andres romero","100798212",7000000));
    }
    public int contarNodos(){
        return listaSE.getCont();
    }

    public String listarNodos(){
    return listaSE.listadoNodos();
    }
}

