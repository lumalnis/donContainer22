package com.donContainer.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class ErrorController implements org.springframework.boot.web.servlet.error.ErrorController {

    @RequestMapping(value = "/error", method = {RequestMethod.GET, RequestMethod.POST}) //colocamos mas de un parametro
    public String mostrarPaginaDeError(Model model, HttpServletRequest httpServletRequest) {
        String msjError = "";
        int codigoError = (int) httpServletRequest.getAttribute("javax.servlet.error.status_code"); //Busca el codigo de error q manda las paginas

        switch (codigoError) {
            case 400:
                msjError = "El recurso solicitado no existe";
                break;
            case 401:
                msjError = "No se encuentra autorizado"; //debe iniciar sesion
                break;
            case 403:
                msjError = "No tiene permisos para acceder al recurso"; //por roles
                break;
            case 404:
                msjError = "El recurso solicitado no se ha encontrado";
                break;
            case 500:
                msjError = "El servidor no pudo realizar la petición con éxito";
                break;
            default:
                msjError = "Error";

        }
        model.addAttribute("codigo", codigoError);
        model.addAttribute("mensaje", msjError);
        return "error";
    }
}