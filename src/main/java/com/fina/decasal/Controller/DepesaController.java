package com.fina.decasal.Controller;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fina.decasal.Service.DespesaService;
import com.fina.decasal.model.Despesa;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/despesa")
public class DepesaController {

    @Autowired
    private DespesaService service;
    
    @DeleteMapping("/{id}")
    public void delete (Long id){
        service.deletar(id);
    }

    @PostMapping
    public Despesa salvar (@RequestBody Despesa despesa) {     
        return service.salvar(despesa);
    }
    
    @GetMapping("/despesas/intervalo")
    public List<Despesa> buscarDespesasPorIntervalo(
            @RequestParam("dataInicio") Date dataInicio,
            @RequestParam("dataFim") Date dataFim) {
        return service.buscarDespesasPorIntervaloDeDatas(dataInicio, dataFim);
    }

    @GetMapping("/soma/{categoriaId}")
    public Double obterSomaCategoria(@PathVariable Long categoriaId) {
        return service.somaPorCategoria(categoriaId);
    }
    

}
