package com.fina.decasal.Service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fina.decasal.DTO.DespesaDTO;
import com.fina.decasal.model.Categoria;
import com.fina.decasal.model.Despesa;
import com.fina.decasal.model.Usuario;
import com.fina.decasal.repository.CategoriaRepository;
import com.fina.decasal.repository.DespesaRepository;
import com.fina.decasal.repository.UsuarioRepository;

@Service
public class DespesaService {

    @Autowired
    private DespesaRepository repository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    public Despesa salvar(Despesa novaDespesa){
        return repository.save(novaDespesa);
    }

    public void deletar(Long id){
         repository.deleteById(id);
    }

    public Despesa editar (Long id, DespesaDTO despesaDTO){
        Despesa desp = repository.findById(id).orElse(null);
        desp.setDescricao(despesaDTO.descricao());
        desp.setValor(despesaDTO.valor());

        Categoria categoria = categoriaRepository.findById(despesaDTO.categoriaId()).orElseThrow(() -> new IllegalArgumentException("Categoria não encontrada"));
        desp.setCategoria(categoria);

        Usuario pagador = usuarioRepository.findById(despesaDTO.pagadorId()).orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado"));
        desp.setPagador(pagador);
        return repository.save(desp);
    }

    public List <Despesa> buscarDespesasPorIntervaloDeDatas(Date Inicio, Date Fim ){
        return repository.findByDataBetween(Inicio, Fim);

    }

    public Double somaPorCategoria(Long categoriaId){
    Double soma = repository.sumByCategoriaId(categoriaId);
    return soma != null ? soma: 0.0;
    }

    public Double calcularTotalPagoPorPagador(Long pagadorId, Date inicio, Date fim) {
        return repository.sumByPagadorIdAndDataBetween(pagadorId, inicio, fim);
    }

    public Double calcularValorIdealPorPessoa(Date inicio, Date fim) {
        Double totalDespesas = repository.sumByDataBetween(inicio, fim);
        return totalDespesas / 2;
    }
    
    public String calcularAjusteEntrePessoas(Double totalPagoMarido, Double totalPagoEsposa) {
        Double valorIdeal = (totalPagoMarido + totalPagoEsposa) / 2;
        
        if (totalPagoMarido > valorIdeal) {
            return "Esposa deve pagar para o Marido: R$ " + (totalPagoMarido - valorIdeal);
        } else if (totalPagoEsposa > valorIdeal) {
            return "Marido deve pagar para a Esposa: R$ " + (totalPagoEsposa - valorIdeal);
        } else {
            return "Nenhum ajuste necessário";
        }
    }
    
}
