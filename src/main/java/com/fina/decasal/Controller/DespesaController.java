package com.fina.decasal.Controller;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fina.decasal.Service.DespesaService;
import com.fina.decasal.model.Categoria;
import com.fina.decasal.model.Despesa;
import com.fina.decasal.model.Usuario;
import com.fina.decasal.DTO.DespesaDTO;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/despesa")
public class DespesaController {

    @Autowired
    private DespesaService service;

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deletar(id);
    }

    @PostMapping("/cadastrar")
    public Despesa cadastrar(@RequestBody DespesaDTO despesaDTO) {
        Despesa despesa = new Despesa();
        despesa.setDescricao(despesaDTO.descricao());
        despesa.setValor(despesaDTO.valor());
        despesa.setData(despesaDTO.datahora());

        Categoria categoria = service.buscarCategoriaPorId(despesaDTO.categoriaId());
        Usuario pagador = service.buscarUsuarioPorId(despesaDTO.pagadorId());

        despesa.setCategoria(categoria);
        despesa.setPagador(pagador);

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

    @GetMapping("/soma/{pagadorId}")
    public Double totalPagoPagador(@PathVariable Long pagadorId, @RequestParam Date inicio, @RequestParam Date fim) {
        return service.calcularTotalPagoPorPagador(pagadorId, inicio, fim);
    }

    @GetMapping("/valorIdealPorPessoa")
    public Double calcularValorIdealPorPessoa(@RequestParam Date inicio, @RequestParam Date fim) {
        return service.calcularValorIdealPorPessoa(inicio, fim);
    }

    @GetMapping("/calcularAjuste")
    public String calcularAjuste(@RequestParam("totalPagoMarido") Double totalPagomarido,
            @RequestParam("totalPagoEsposa") Double totalPagoEsposa) {
        return service.calcularAjusteEntrePessoas(totalPagomarido, totalPagoEsposa);
    }
}
