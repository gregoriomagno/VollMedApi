package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.domain.dtos.medicos.DadosAtualizarMedico;
import med.voll.api.domain.dtos.medicos.DadosCadastroMedico;
import med.voll.api.domain.dtos.medicos.DadosDetalhamentoMedico;
import med.voll.api.domain.dtos.medicos.DadosListagemMedico;
import med.voll.api.service.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private MedicoService service;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroMedico dados, UriComponentsBuilder uriBuilder){

        var medico = service.inserir(dados);
        var uri = uriBuilder.path("/medicos/{id}").buildAndExpand(medico.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoMedico(medico));

    }
    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id){
        var medico = service.buscar(id);
        return ResponseEntity.ok(new DadosDetalhamentoMedico(medico));
    }
    @GetMapping
    public ResponseEntity<Page<DadosListagemMedico>> listar(@PageableDefault(size=10, sort={"nome"} ) Pageable paginacao){
        var page = service.listar(paginacao);
        return ResponseEntity.ok(page);
    }
    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody DadosAtualizarMedico dados){
        var medico = service.atualizar(dados,dados.id());
        return ResponseEntity.ok(new DadosDetalhamentoMedico(medico));
    }
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id){
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}

