package org.saopaulofc.sociotorcedor.repository;

import org.saopaulofc.sociotorcedor.model.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, String> {
}
