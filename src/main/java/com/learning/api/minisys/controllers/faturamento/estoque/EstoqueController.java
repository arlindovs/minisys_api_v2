package com.learning.api.minisys.controllers.faturamento.estoque;

import com.learning.api.minisys.dtos.faturamento.estoque.EstoqueDto;
import com.learning.api.minisys.entitys.faturamento.estoque.EstoqueEntity;
import com.learning.api.minisys.repositories.cadastro.integrante.IntegranteRepository;
import com.learning.api.minisys.repositories.cadastro.item.ItemRepository;
import com.learning.api.minisys.repositories.cadastro.item.UnidadeMedidaRepository;
import com.learning.api.minisys.repositories.faturamento.estoque.EstoqueRepository;
import com.learning.api.minisys.repositories.faturamento.nota_fiscal.NotaFiscalDetalheRepository;
import com.learning.api.minisys.repositories.faturamento.ordem_servico.OrdemServicoDetalheRepository;
import com.learning.api.minisys.repositories.faturamento.pedido.PedidoDetalheRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/estoques")
public class EstoqueController {

    @Autowired
    private EstoqueRepository estoqueRepository;
    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private UnidadeMedidaRepository unidadeMedidaRepository;
    @Autowired
    private IntegranteRepository integranteRepository;
    @Autowired
    private PedidoDetalheRepository pedidoDetalheRepository;
    @Autowired
    private OrdemServicoDetalheRepository ordemServicoDetalheRepository;
    @Autowired
    private NotaFiscalDetalheRepository notaFiscalDetalheRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<Void> cadastrarEstoque(@RequestBody @Valid EstoqueDto estoqueDto) {
        EstoqueEntity estoque = new EstoqueEntity(estoqueDto);

        if (estoqueDto.item() != null) {
            itemRepository.findById(estoqueDto.item().getCODIGO()).ifPresent(estoque::setItem);
        }

        if (estoqueDto.unidadeMedida() != null) {
            unidadeMedidaRepository.findById(estoqueDto.unidadeMedida().getCODIGO())
                    .ifPresent(estoque::setUnidadeMedida);
        }

        if (estoqueDto.funcionario() != null) {
            integranteRepository.findById(estoqueDto.funcionario().getCODIGO())
                    .ifPresent(estoque::setFuncionario);
        }

        if (estoqueDto.pedidoDetalhe() != null) {
            pedidoDetalheRepository.findById(estoqueDto.pedidoDetalhe().getCODIGO())
                    .ifPresent(estoque::setPedidoDetalhe);
        }

        if (estoqueDto.ordemServicoDetalhe() != null) {
            ordemServicoDetalheRepository.findById(estoqueDto.ordemServicoDetalhe().getCODIGO())
                    .ifPresent(estoque::setOrdemServicoDetalhe);
        }

        if (estoqueDto.notaFiscalDetalhe() != null) {
            notaFiscalDetalheRepository.findById(estoqueDto.notaFiscalDetalhe().getCODIGO())
                    .ifPresent(estoque::setNotaFiscalDetalhe);
        }

        estoqueRepository.save(estoque);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public Iterable<EstoqueDto> listarEstoques() {
        return estoqueRepository.findAll().stream().map(EstoqueDto::new).toList();
    }

    @GetMapping("/{CODIGO}")
    public ResponseEntity<EstoqueDto> buscarEstoque(Long CODIGO) {
        var estoque = estoqueRepository.getReferenceById(CODIGO);

        return ResponseEntity.ok(new EstoqueDto(estoque));
    }

    @PutMapping
    @Transactional
    public ResponseEntity<EstoqueDto> atualizarEstoque(@RequestBody @Valid EstoqueDto estoqueDto) {
        EstoqueEntity estoque = estoqueRepository.findById(estoqueDto.CODIGO())
                .orElseThrow(() -> new RuntimeException("Estoque não encontrado"));

        estoque.atualizarEstoque(estoqueDto);

        if (estoqueDto.item() != null) {
            itemRepository.findById(estoqueDto.item().getCODIGO()).ifPresent(estoque::setItem);
        } else {
            estoque.setItem(null);
        }

        if (estoqueDto.unidadeMedida() != null) {
            unidadeMedidaRepository.findById(estoqueDto.unidadeMedida().getCODIGO())
                    .ifPresent(estoque::setUnidadeMedida);
        } else {
            estoque.setUnidadeMedida(null);
        }

        if (estoqueDto.funcionario() != null) {
            integranteRepository.findById(estoqueDto.funcionario().getCODIGO())
                    .ifPresent(estoque::setFuncionario);
        } else {
            estoque.setFuncionario(null);
        }

        if (estoqueDto.pedidoDetalhe() != null) {
            pedidoDetalheRepository.findById(estoqueDto.pedidoDetalhe().getCODIGO())
                    .ifPresent(estoque::setPedidoDetalhe);
        } else {
            estoque.setPedidoDetalhe(null);
        }

        if (estoqueDto.ordemServicoDetalhe() != null) {
            ordemServicoDetalheRepository.findById(estoqueDto.ordemServicoDetalhe().getCODIGO())
                    .ifPresent(estoque::setOrdemServicoDetalhe);
        } else {
            estoque.setOrdemServicoDetalhe(null);
        }

        if (estoqueDto.notaFiscalDetalhe() != null) {
            notaFiscalDetalheRepository.findById(estoqueDto.notaFiscalDetalhe().getCODIGO())
                    .ifPresent(estoque::setNotaFiscalDetalhe);
        } else {
            estoque.setNotaFiscalDetalhe(null);
        }

        estoqueRepository.save(estoque);

        return ResponseEntity.ok(new EstoqueDto(estoque));
    }

    @DeleteMapping("/{CODIGO}")
    @Transactional
    public ResponseEntity<Void> deletarEstoque(Long CODIGO) {
        estoqueRepository.deleteById(CODIGO);

        return ResponseEntity.noContent().build();
    }
}
