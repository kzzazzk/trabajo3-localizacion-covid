package com.practica.genericas;

import java.util.HashMap;
import java.util.function.Consumer;

public class PersonPositionHashMap {
    private HashMap<Integer, Consumer<String>> propertyMap = new HashMap<>();
    private String fecha = null, hora;
    private float latitud, longitud;

    // Definir las acciones a realizar para cada posición del arreglo
    public PersonPositionHashMap(PosicionPersona posicionPersona) {
        propertyMap.put(1, posicionPersona::setDocumento);
        propertyMap.put(2, value -> fecha = value);
        propertyMap.put(3, value -> {
            hora = value;
            posicionPersona.setFechaPosicion(parsearFecha(fecha, hora));
        });
        propertyMap.put(4, value -> latitud = Float.parseFloat(value));
        propertyMap.put(5, value -> {
            longitud = Float.parseFloat(value);
            posicionPersona.setCoordenada(new Coordenada(latitud, longitud));
        });
    }

    private FechaHora parsearFecha(String fecha, String hora) {
        String[] fechaValues = fecha.split("\\/");
        String[] horaValues = hora.split("\\:");

        int dia = Integer.parseInt(fechaValues[0]);
        int mes = Integer.parseInt(fechaValues[1]);
        int anio = Integer.parseInt(fechaValues[2]);
        int minuto = Integer.parseInt(horaValues[0]);
        int segundo = Integer.parseInt(horaValues[1]);

        return new FechaHora(dia, mes, anio, minuto, segundo);
    }

    public Consumer<String> get(int i) {
        return propertyMap.get(i);
    }
}