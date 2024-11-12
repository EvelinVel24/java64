package main.java.com.tu_proyecto.servicio;
import java.util.List;

public interface IUsuarioServicio {
    List<Usuario> listarUsuarios();
    void agregarUsuario(Usuario usuario);
    void editarUsuario(Usuario usuario);
    void eliminarUsuario(String username);
    Usuario buscarUsuario(String username);
}
