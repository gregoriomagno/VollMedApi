package med.voll.api.medico;

import jakarta.validation.constraints.NotBlank;
import med.voll.api.endereco.DadosEndereco;

public record DadosAtualizarMedico(
       @NotBlank
        Long id,
        String nome,
        String telefone,
        DadosEndereco endereco) {
}
