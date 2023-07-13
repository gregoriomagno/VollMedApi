package med.voll.api.domain.dtos.pacientes;

import jakarta.validation.constraints.NotBlank;
import med.voll.api.domain.dtos.endereco.DadosEndereco;

public record DadosAtualizarPaciente(
        @NotBlank
        Long id,
        String nome,
        String telefone,
        DadosEndereco endereco) {


}
