package org.saopaulofc.sociotorcedor.controller;

import org.saopaulofc.sociotorcedor.model.Usuario;
import org.saopaulofc.sociotorcedor.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public void inserir (@RequestBody Usuario usuario){
        usuarioService.inserirUsuario(usuario);
    }
    @PutMapping("/{id}")
    public void atualizar(@PathVariable Long id, @RequestBody Usuario usuario){
        usuarioService.atualizarUsuario(id,usuario);
    }
    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id){
        usuarioService.deletarUsuario(id);
    }
    @GetMapping("/{id}")
    public Optional<Usuario> visualizarPeloId(@PathVariable Long id){
        var user = usuarioService.visualizarPeloId(id);
        return user;
    }

    @GetMapping
    public List<Usuario> visualizarUsuarios(){
        var listaUsuarios = usuarioService.visualizarTodos();
        return listaUsuarios;
    }
}
