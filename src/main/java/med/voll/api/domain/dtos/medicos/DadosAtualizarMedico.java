package med.voll.api.domain.dtos.medicos;

import jakarta.validation.constraints.NotBlank;
import med.voll.api.domain.dtos.endereco.DadosEndereco;

public record DadosAtualizarMedico(
       @NotBlank
        Long id,
        String nome,
        String telefone,
        DadosEndereco endereco) {
}
