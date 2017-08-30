/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servifact.app.dao;


import com.servifact.app.modelo.Emisor;
import com.servifact.app.modelo.UsuarioLogin;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.jdbc.ReturningWork;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.*;
import java.util.logging.Level;

/**
 *
 * @author Adrian
 */
@Repository
@Transactional
public class EmisorDaoImpl implements EmisorDao {

    private static final Logger log = LoggerFactory.getLogger(EmisorDaoImpl.class);

    @Autowired
    private SessionFactory sessionFactory;

    private Session currentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    @Transactional(readOnly = true)
    public Emisor buscarEmisor(final String ruc, final String keypassword) {

        return sessionFactory.getCurrentSession().doReturningWork(new ReturningWork<Emisor>() {

            public Emisor execute(Connection connection) throws SQLException {
                try {
                    CallableStatement cst = connection.prepareCall("{ ? = call getemisor(?,?) }");
                    cst.registerOutParameter(1, Types.OTHER);
                    cst.setString(2, ruc);
                    cst.setString(3, keypassword);
                    cst.execute();
                    Emisor emisor = new Emisor();
                    ResultSet rs = (ResultSet) cst.getObject(1);
                    if (rs != null) {
                        while (rs.next()) {
                            emisor.setRucEmi(rs.getString(1));
                            emisor.setNombCom(rs.getString(2));
                            emisor.setUbigeo(rs.getString(3));
                            emisor.setDirecc(rs.getString(4));
                            emisor.setDpto(rs.getString(5));
                            emisor.setProv(rs.getString(6));
                            emisor.setDitr(rs.getString(7));
                            emisor.setCodPais(rs.getString(8));
                            emisor.setEstado(rs.getString(9));
                            emisor.setRutaCert(rs.getString(10));
                            emisor.setKeyStoPass(rs.getString(11));
                            emisor.setPrivKeyPass(rs.getString(12));
                            emisor.setPrivKeyAlias(rs.getString(13));
                            emisor.setPerfil(rs.getString(14));

                        }


                    }
                    return emisor;
                } catch (Exception e) {
                    log.debug("Ocurrio una excepcion " + e.getMessage());
                    return null;
                }
            }
        });
    }

    @Override
    public UsuarioLogin getUsuarioLogin(final String ruc, final String perfil) {
        UsuarioLogin usuarioLogin = new UsuarioLogin();
//
//        ResultSet rs = (ResultSet) currentSession().doReturningWork(new ReturningWork<ResultSet>() {
//
//            @Override
//            public ResultSet execute(Connection connection) {
//
//                try {
//                        CallableStatement function = connection.prepareCall("{ ? = call getusuariosunat(?,?) }");
//                    function.registerOutParameter(1, Types.OTHER);
//                    function.setString(2, ruc);
//                    function.setString(3, perfil);
//                    function.execute();
//                    return (ResultSet) function.getObject(1);
//                } catch (SQLException ex) {
//                    java.util.logging.Logger.getLogger(EmisorDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
//                    return null;
//                }
//            }
//        });
//
//        if (rs != null) {
//            try {
//                while (rs.next()) {
//
//                    usuarioLogin.setNumeroRuc(rs.getString(1));
//                    usuarioLogin.setUsuarioSunat(rs.getString(3));
//                    usuarioLogin.setClaveSol(rs.getString(4));
//                    usuarioLogin.setUrlServicio(rs.getString(6));
//                    
//
//                }
//            } catch (SQLException ex) {
//                java.util.logging.Logger.getLogger(EmisorDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
        return usuarioLogin;
    }
}
