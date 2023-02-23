package com.example.backend.controller;

import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.backend.model.ProdutoModelo;
import com.example.backend.model.mensagemModelo;
import com.example.backend.repositorio.produtoRepositorio;
import com.example.backend.servico.ProdutoServico;





@RestController
public class ProdutoControler {
    @Autowired
    private ProdutoServico ps;
    
    @Autowired
    private produtoRepositorio rp;

    @PostMapping("/cadastrar")
    public ResponseEntity<?> cadastrar(ProdutoModelo pm){
        return ps.CadastrarAltera(pm);
    }

    @PutMapping("/alterar/{id}")
    public ResponseEntity<?> alteraProduto(ProdutoModelo pm){
       return ps.CadastrarAltera(pm);
    }

    @GetMapping("/")
    public Iterable<ProdutoModelo> listar (){
        return rp.findAll();
    }

    @GetMapping(path = "/busca/{id}")
    public Optional<ProdutoModelo> lista (@PathVariable Long id){
        return rp.findById(id);
    }

    @DeleteMapping(path = "/deleta/{id}")
    public ResponseEntity<mensagemModelo> delete (@PathVariable Long id){
       return ps.deleta(id);
    }


}
