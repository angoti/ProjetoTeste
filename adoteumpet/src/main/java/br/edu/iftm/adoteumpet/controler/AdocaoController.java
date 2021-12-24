package br.edu.iftm.adoteumpet.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.edu.iftm.adoteumpet.model.Animal;
import br.edu.iftm.adoteumpet.repository.AnimalRepository;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class AdocaoController {

    @Autowired
    AnimalRepository repo;

    @GetMapping("/adote")
    public String solicitaAdocao(Model modelo) {
        List<Animal> lista = repo.buscaAnimaisEmAdocao();
        modelo.addAttribute("listaDeAnimais", lista);
        return "adote";
    }

    @GetMapping("/solicita-adocao")
    public String getMethodName(@RequestParam String param) {
        return "";
    }
    
}
