/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servifact.app.controller;


import com.servifact.app.dao.EmisorDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Adrian
 */
@Controller
public class InicioController {
    
     @Autowired
    private EmisorDao emisorDao;
    
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String inicio(){ 
//     Emisor e=  emisorDao.buscarEmisor("20353607783","2323");
//     System.out.println(e.getDpto());
//        
    return "index";
    }
    
}
