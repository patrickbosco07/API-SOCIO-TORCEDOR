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
    public void atualizar(@PathVariable String cpf, @RequestBody Usuario usuario){
        usuarioService.atualizarUsuario(cpf,usuario);
    }
    @DeleteMapping("/{id}")
    public void excluir(@PathVariable String cpf){
        usuarioService.deletarUsuario(cpf);
    }
    @GetMapping("/{id}")
    public Optional<Usuario> visualizarPeloId(@PathVariable String cpf){
        return usuarioService.visualizarPeloId(cpf);
    }

    @GetMapping
    public List<Usuario> visualizarUsuarios(){
        return usuarioService.visualizarTodos();
    }
}
