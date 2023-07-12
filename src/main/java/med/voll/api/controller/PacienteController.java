package med.voll.api.controller;

import med.voll.api.medico.DadosAtualizarMedico;
import med.voll.api.paciente.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/paciente")
public class PacienteController {

    @Autowired
    private PacienteRepository repository;
    @PostMapping
    @Transactional
    public void CriarPaciente(@RequestBody DadosCadastroPaciente dados){
        repository.save(new Paciente(dados));
        System.out.println("Cadastro paciente: "+ dados);

    }

    @GetMapping
    public Page<DadosListagemPaciente> listar(@PageableDefault (size=10, sort={"nome"} )Pageable paginacao){
        return repository.findAllByAtivoTrue(paginacao).map(DadosListagemPaciente::new);
    }

    @PutMapping
    @Transactional
    public void Atualizar(@RequestBody DadosAtualizarPaciente dados){
        var paciente = repository.getReferenceById(dados.id());
        paciente.atualizarDados(dados);
    }
    @DeleteMapping("/{id}")
    @Transactional
    public void Excluir(@PathVariable Long id){
        var paciente = repository.getReferenceById(id);
        paciente.excluir();
    }

}
