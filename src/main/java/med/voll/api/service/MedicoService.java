package med.voll.api.service;

import med.voll.api.domain.dtos.medicos.DadosAtualizarMedico;
import med.voll.api.domain.dtos.medicos.DadosCadastroMedico;
import med.voll.api.domain.dtos.medicos.DadosListagemMedico;
import med.voll.api.domain.dtos.pacientes.DadosAtualizarPaciente;
import med.voll.api.domain.dtos.pacientes.DadosCadastroPaciente;
import med.voll.api.domain.dtos.pacientes.DadosListagemPaciente;
import med.voll.api.domain.model.Medico;
import med.voll.api.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

public interface MedicoService {


    public Medico inserir(DadosCadastroMedico dto);

    public Medico buscar(Long id);
    public Page<DadosListagemMedico> listar(Pageable pageable);

    public Medico atualizar(DadosAtualizarMedico dto, Long id);

    public void deletar(Long id);

}
