package org.saopaulofc.sociotorcedor.repository;

import org.saopaulofc.sociotorcedor.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    boolean findByCpf(String cpf);
}
