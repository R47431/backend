package com.example.backend.repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.backend.model.ProdutoModelo;


@Repository
public interface produtoRepositorio extends CrudRepository<ProdutoModelo,Long> {

}
