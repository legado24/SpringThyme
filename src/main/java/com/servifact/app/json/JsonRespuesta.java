package com.servifact.app.json;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by _ADRIAN_ on 02/01/2017.
 */
public class JsonRespuesta<T> {

    @JsonProperty
    private Integer estado;

    @JsonProperty
    private String mensaje;
    @JsonProperty
    private List<T> data=new ArrayList<T>();


    private T item;


    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
