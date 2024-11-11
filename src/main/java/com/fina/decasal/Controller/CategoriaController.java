package com.fina.decasal.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fina.decasal.DTO.CategoriaDTO;
import com.fina.decasal.Mapper.CategoriaMapper;
import com.fina.decasal.Service.CategoriaService;
import com.fina.decasal.model.Categoria;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/categoria")
public class CategoriaController {

    @Autowired
    CategoriaService service;

    @PostMapping
    public Categoria salva(@RequestBody Categoria categoria)  {
    return service.salvar(categoria);     
    }


    @DeleteMapping("/{id}")
    public void delete(@PathVariable ("id")Long id){
        service.deletar(id);
    }
    
    @GetMapping    
    public List<CategoriaDTO> listar(){
        List<Categoria> categorias = service.Listar(null);
        return CategoriaMapper.toList(categorias);
    }
    

}
