package med.voll.api.domain.dtos.pacientes;

import med.voll.api.domain.model.Endereco;
import med.voll.api.domain.model.Medico;
import med.voll.api.domain.model.Paciente;

public record DadosDetalhamentoPaciente(Long id, String nome,String cpf, String email,String telefone, Endereco endereco) {
    public DadosDetalhamentoPaciente(Paciente paciente){
        this(paciente.getId(), paciente.getNome(), paciente.getCpf(),paciente.getEmail(),  paciente.getTelefone(),  paciente.getEndereco() );
    }
}
