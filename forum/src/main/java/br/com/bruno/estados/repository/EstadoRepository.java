package br.com.bruno.estados.repository;


import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.bruno.estados.model.Estado;
import br.com.bruno.estados.model.StatusRegiao;


@Repository
public interface EstadoRepository extends JpaRepository<Estado, Long> {
    List<Estado> findByregiao(StatusRegiao regiao);
    
    List<Estado>findAll(Sort sort);
}
