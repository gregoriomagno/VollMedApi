package med.voll.api.controller;

import med.voll.api.domain.dtos.medicos.DadosDetalhamentoMedico;
import med.voll.api.domain.dtos.pacientes.DadosAtualizarPaciente;
import med.voll.api.domain.dtos.pacientes.DadosCadastroPaciente;
import med.voll.api.domain.dtos.pacientes.DadosDetalhamentoPaciente;
import med.voll.api.domain.dtos.pacientes.DadosListagemPaciente;

import med.voll.api.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/paciente")
public class PacienteController {

    @Autowired
    private PacienteService service;
    @PostMapping
    @Transactional
    public ResponseEntity CriarPaciente(@RequestBody DadosCadastroPaciente dados, UriComponentsBuilder uriBuilder){
        var paciente  = service.inserir(dados);
        var uri = uriBuilder.path("/pacientes/{id}").buildAndExpand(paciente.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoPaciente(paciente));
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemPaciente>> listar(@PageableDefault (size=10, sort={"nome"} )Pageable paginacao){
        var page =   service.listar(paginacao);
        return ResponseEntity.ok(page);

    }

    @PutMapping
    @Transactional
    public ResponseEntity Atualizar(@RequestBody DadosAtualizarPaciente dados){
        var paciente  = service.atualizar(dados, dados.id());
        return ResponseEntity.ok(new DadosDetalhamentoPaciente(paciente));
    }
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity Excluir(@PathVariable Long id){
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }

}
