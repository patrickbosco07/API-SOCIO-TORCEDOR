package org.saopaulofc.sociotorcedor.service;

import org.saopaulofc.sociotorcedor.model.Usuario;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface UsuarioService {

    public Usuario inserirUsuario(Usuario usuario);
    public Usuario atualizarUsuario(Long id, Usuario usuario);
    public void deletarUsuario(Long id);
    public Optional<Usuario> visualizarPeloId(Long id);
    public List<Usuario> visualizarTodos();

}
