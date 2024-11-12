package main.java.com.tu_proyecto.controlador;

import com.tu_proyecto.servicio.IUsuarioServicio;
import com.tu_proyecto.modelo.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UsuarioControlador {

    @Autowired
    private IUsuarioServicio usuarioServicio;

    // Listar usuarios
    @GetMapping("/")
    public String listarUsuarios(Model model) {
        model.addAttribute("usuarios", usuarioServicio.listarUsuarios());
        return "index";
    }

    // Mostrar formulario para agregar usuario
    @GetMapping("/agregar")
    public String mostrarFormularioAgregar(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "agregar";
    }

    // Procesar formulario de agregar usuario
    @PostMapping("/agregar")
    public String agregarUsuario(@ModelAttribute Usuario usuario) {
        usuarioServicio.agregarUsuario(usuario);
        return "redirect:/";
    }

    // Mostrar formulario para editar usuario
    @GetMapping("/editar/{username}")
    public String mostrarFormularioEditar(@PathVariable String username, Model model) {
        Usuario usuario = usuarioServicio.buscarUsuario(username);
        model.addAttribute("usuario", usuario);
        return "editar";
    }

    // Procesar formulario de editar usuario
    @Post
