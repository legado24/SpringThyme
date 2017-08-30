/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servifact.app.dao;


import com.servifact.app.modelo.Emisor;
import com.servifact.app.modelo.UsuarioLogin;

/**
 *
 * @author Adrian
 */
public interface EmisorDao {
//    public TblEmisor getEmisor(String ruc);
     public Emisor buscarEmisor(String ruc, String keypassword);
     public UsuarioLogin getUsuarioLogin(String ruc, String perfil);
}
