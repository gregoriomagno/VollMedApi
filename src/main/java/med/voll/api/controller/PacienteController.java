package med.voll.api.controller;

import med.voll.api.paciente.DadosListagemPaciente;
import med.voll.api.paciente.Paciente;
import med.voll.api.paciente.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import med.voll.api.paciente.DadosCadastroPaciente;
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

//    @GetMapping
//    public Page<DadosListagemPaciente> listar(@PageableDefault (size=10, sort={"nome"} )Pageable paginacao){
//
//
//    }
}
