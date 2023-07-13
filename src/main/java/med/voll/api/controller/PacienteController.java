package med.voll.api.controller;

import med.voll.api.domain.dtos.pacientes.DadosAtualizarPaciente;
import med.voll.api.domain.dtos.pacientes.DadosCadastroPaciente;
import med.voll.api.domain.dtos.pacientes.DadosListagemPaciente;

import med.voll.api.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/paciente")
public class PacienteController {

    @Autowired
    private PacienteService service;
    @PostMapping
    @Transactional
    public void CriarPaciente(@RequestBody DadosCadastroPaciente dados){
        service.inserir(dados);
    }

    @GetMapping
    public Page<DadosListagemPaciente> listar(@PageableDefault (size=10, sort={"nome"} )Pageable paginacao){
        return  service.listar(paginacao);
    }

    @PutMapping
    @Transactional
    public void Atualizar(@RequestBody DadosAtualizarPaciente dados){
          service.atualizar(dados, dados.id());
    }
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity Excluir(@PathVariable Long id){
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }

}
