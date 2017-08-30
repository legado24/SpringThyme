/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servifact.app.modelo;

/**
 *
 * @author Adrian
 */
public class UsuarioLogin {
    
    private String numeroRuc;
    private String username;
    private String password;
    private String usuarioSunat;
    private String claveSol;
    private String perfil;
    private String urlServicio;

    public String getUrlServicio() {
        return urlServicio;
    }

    public void setUrlServicio(String urlServicio) {
        this.urlServicio = urlServicio;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    public String getNumeroRuc() {
        return numeroRuc;
    }

    public void setNumeroRuc(String numeroRuc) {
        this.numeroRuc = numeroRuc;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsuarioSunat() {
        return usuarioSunat;
    }

    public void setUsuarioSunat(String usuarioSunat) {
        this.usuarioSunat = usuarioSunat;
    }

    public String getClaveSol() {
        return claveSol;
    }

    public void setClaveSol(String claveSol) {
        this.claveSol = claveSol;
    }
    
    
}
