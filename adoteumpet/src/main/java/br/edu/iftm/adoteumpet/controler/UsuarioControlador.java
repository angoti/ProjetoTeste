package br.edu.iftm.adoteumpet.controler;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.edu.iftm.adoteumpet.model.Usuario;
import br.edu.iftm.adoteumpet.repository.UsuarioRepository;

@Controller
public class UsuarioControlador {

    @Autowired
    UsuarioRepository repo;

    @GetMapping("/form-usuario")
    String cadastrarUsuario(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "form-usuario";
    }

    @PostMapping(value = "/form-usuario")
    public String gravarUsuario(@Valid Usuario usuario, BindingResult result, RedirectAttributes ra) {
        System.out.println("------------------- ********* ---------------------");
        for (ObjectError erro : result.getAllErrors()) {
            System.out.println(erro.getDefaultMessage());
        }
        if (result.hasErrors()) {
            return "form-usuario";
        }
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(usuario.getSenha());
        usuario.setSenha(encodedPassword);
        repo.gravaUsuario(usuario);
        ra.addFlashAttribute("message", "Usuário cadastrado com sucesso!");
        return "redirect:/form-usuario";
    }

    @RequestMapping(value = "/usuarios", method = RequestMethod.GET)
    public String exibirUsuarios(Model modelo) {
        modelo.addAttribute("usuarios", repo.buscaTodosUsuarios());
        return "usuarios";
    }

    @GetMapping(value = "/editar-usuario")
    public String editarUsuario(@RequestParam(name = "id", required = true) Integer cod, Model modelo) {
        modelo.addAttribute("usuario", repo.buscaPorId(cod));
        return "usuarios";
    }
}
