package med.voll.api.service;

import med.voll.api.domain.dtos.pacientes.DadosAtualizarPaciente;
import med.voll.api.domain.dtos.pacientes.DadosCadastroPaciente;
import med.voll.api.domain.dtos.pacientes.DadosListagemPaciente;
import med.voll.api.domain.model.Paciente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface PacienteService {

    public void inserir(DadosCadastroPaciente dto);

//    public Paciente buscar(Long id);
    public Page<DadosListagemPaciente> listar(Pageable pageable);

    public void atualizar(DadosAtualizarPaciente dto, Long id);

    public ResponseEntity deletar(Long id);


}
