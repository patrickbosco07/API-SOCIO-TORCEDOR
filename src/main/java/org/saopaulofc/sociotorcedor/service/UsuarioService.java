package org.saopaulofc.sociotorcedor.service;

import org.saopaulofc.sociotorcedor.model.Usuario;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface UsuarioService {

    public void inserirUsuario(Usuario usuario);
    public void atualizarUsuario(String cpf, Usuario usuario);
    public void deletarUsuario(String cpf);
    public Optional<Usuario> visualizarPeloId(String cpf);
    public List<Usuario> visualizarTodos();

}
