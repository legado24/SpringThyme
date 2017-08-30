package com.servifact.app.controller;

import com.servifact.app.json.JsonRespuesta;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by __Adrian__ on 24/8/2017.
 */
@RestController
@RequestMapping("restapifact")
public class TicketController {

    @GetMapping("/prueba")
    public JsonRespuesta pruebaServicio(@ModelAttribute(value="codvendedor") String  codVendedor) throws SQLException {
        JsonRespuesta respuesta=new JsonRespuesta();

        respuesta.setEstado(1);

        respuesta.setMensaje("Exito en la consulta");
        return respuesta;
    }

}
