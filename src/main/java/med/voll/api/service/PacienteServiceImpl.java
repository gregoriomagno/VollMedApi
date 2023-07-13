package med.voll.api.service;

import med.voll.api.domain.dtos.pacientes.DadosAtualizarPaciente;
import med.voll.api.domain.dtos.pacientes.DadosCadastroPaciente;
import med.voll.api.domain.dtos.pacientes.DadosListagemPaciente;
import med.voll.api.domain.model.Paciente;
import med.voll.api.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PacienteServiceImpl implements PacienteService{

    @Autowired
    private PacienteRepository repository;
    @Override
    public void inserir(DadosCadastroPaciente dto) {
        repository.save(new Paciente(dto));
    }

//    @Override
//    public Paciente buscar(Long id){
//        return null;
//    }
    @Override
    public Page<DadosListagemPaciente> listar(Pageable pageable){
        return repository.findAllByAtivoTrue(pageable).map(DadosListagemPaciente::new);

    }
    @Override
    public void atualizar(DadosAtualizarPaciente dto, Long id){
        var paciente = repository.getReferenceById(id);
        paciente.atualizarDados(dto);
    }
    @Override
    public ResponseEntity deletar(Long id){
        var paciente = repository.getReferenceById(id);
        paciente.excluir();
        return ResponseEntity.noContent().build();
    }


}
