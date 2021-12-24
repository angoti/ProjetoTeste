package br.edu.iftm.adoteumpet.exceptions;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class WebControllerAdvice {

    @ExceptionHandler(org.springframework.dao.DataIntegrityViolationException.class)
    String participanteNaoEncontrado(org.springframework.dao.DataIntegrityViolationException ex, Model modelo) {
        System.out.println("------------------------> webcontrolleradvice");
        System.out.println(ex);
        modelo.addAttribute("error", ex.getMessage());
        return "error";
    }
}
