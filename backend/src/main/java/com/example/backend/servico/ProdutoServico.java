package com.example.backend.servico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.backend.model.ProdutoModelo;
import com.example.backend.model.mensagemModelo;
import com.example.backend.repositorio.produtoRepositorio;



@Service    
public class ProdutoServico {
    
    @Autowired
    private produtoRepositorio pr;

    @Autowired
    private mensagemModelo mm;
    
    
    public ResponseEntity<?> CadastrarAltera(ProdutoModelo pm){
        if(pm.getProduto().equals("")){
            mm.setMensagem("nome");
            return new ResponseEntity<mensagemModelo>(mm,HttpStatus.BAD_REQUEST);
        }else if(pm.getPreco() == null){
            mm.setMensagem("preço");
            return new ResponseEntity<mensagemModelo>(mm,HttpStatus.BAD_REQUEST);
        }else{
            return new ResponseEntity<ProdutoModelo>(pr.save(pm), HttpStatus.CREATED);
        }
    }

    public ResponseEntity<mensagemModelo> deleta (Long id){
        pr.deleteById(id);
        mm.setMensagem("produto deletado");
        return new  ResponseEntity<mensagemModelo>(mm, HttpStatus.OK);
        
    }
}
