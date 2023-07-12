package med.voll.api.paciente;

import jakarta.validation.constraints.NotBlank;
import med.voll.api.endereco.DadosEndereco;
import med.voll.api.endereco.Endereco;

public record DadosAtualizarPaciente(
        @NotBlank
        Long id,
        String nome,
        String telefone,
        DadosEndereco endereco) {


}
