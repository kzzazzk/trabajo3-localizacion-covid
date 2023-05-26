package com.practica.genericas;

import java.util.HashMap;
import java.util.function.Consumer;

public class PersonPropertyHashMap {
    private HashMap<Integer, Consumer<String>> propertyMap = new HashMap<>();
    // Definir las acciones a realizar para cada posición del arreglo
    public PersonPropertyHashMap(Persona persona) {
        propertyMap.put(1, persona::setDocumento);
        propertyMap.put(2, persona::setNombre);
        propertyMap.put(3, persona::setApellidos);
        propertyMap.put(4, persona::setEmail);
        propertyMap.put(5, persona::setDireccion);
        propertyMap.put(6, persona::setCp);
        propertyMap.put(7, s -> persona.setFechaNacimiento(parsearFecha(s)));
    }
    private FechaHora parsearFecha (String fecha) {
        int dia, mes, anio;
        String[] valores = fecha.split("\\/");
        dia = Integer.parseInt(valores[0]);
        mes = Integer.parseInt(valores[1]);
        anio = Integer.parseInt(valores[2]);
        FechaHora fechaHora = new FechaHora(dia, mes, anio, 0, 0);
        return fechaHora;
    }

    public Consumer<String> get(int i) {
        return propertyMap.get(i);
    }

}
