package org.saopaulofc.sociotorcedor.service.imp;

import org.saopaulofc.sociotorcedor.model.Endereco;
import org.saopaulofc.sociotorcedor.model.Usuario;
import org.saopaulofc.sociotorcedor.repository.EnderecoRepository;
import org.saopaulofc.sociotorcedor.repository.UsuarioRepository;
import org.saopaulofc.sociotorcedor.service.UsuarioService;
import org.saopaulofc.sociotorcedor.service.ViaCepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
@Service
public class UsuarioImplementacao implements UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private ViaCepService viaCepService;

    @Override
    public void inserirUsuario(Usuario usuario) {criarUsuarioValidoComCep(usuario);}

    @Override
    public void atualizarUsuario(Long id, Usuario usuario) {
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);
        if (usuarioOptional.isPresent()){
            usuarioRepository.save(usuario);
        } else {throw new NoSuchElementException("Usuário não encontrado");}
    }

    @Override
    public void deletarUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }

    @Override
    public Optional<Usuario> visualizarPeloId(Long id) {
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);
        if (usuarioOptional.isPresent()){
            return usuarioOptional;
        } else {throw new NoSuchElementException("Usuário não encontrado");}
    }

    @Override
    public List<Usuario> visualizarTodos() {
        List<Usuario> listaUsuarios = usuarioRepository.findAll();
        return listaUsuarios;
    }

    private void criarUsuarioValidoComCep(Usuario usuario){
        //Pesquisando usuário no banco de dados
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(usuario.getId());
        //Caso o usuário não existe, fazer a criação de seu endereço primeiro, para não dar erro na API
        if (usuarioOptional.isEmpty()){
            String cep = usuario.getEndereco().getCep();
            //Pesquisando o endereço do usuário no banco de dados de endereços
            Endereco endereco = enderecoRepository.findById(cep).orElseGet(() -> {
                //Caso o endereço ainda não exista, acessar o ViaCep (API Externa) e criar
                Endereco novoEndereco = viaCepService.obterEndereco(cep);
                enderecoRepository.save(novoEndereco);
                return novoEndereco;
            });
            usuario.setEndereco(endereco);
        } else {
            throw new RuntimeException("Usuário já existente");
        }
        usuarioRepository.save(usuario);
    }

}
