package med.voll.api.domain.dtos.pacientes;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import med.voll.api.domain.dtos.endereco.DadosEndereco;

public record DadosCadastroPaciente(
        @NotBlank
        String nome,
        @NotBlank
        String email,
        @NotBlank
        String telefone,
        @NotBlank @Pattern(regexp = "\\d{3}\\.?\\d{3}\\.?\\d{3}\\-?\\d{2}")
        String cpf,
        @NotBlank
        @Valid
        DadosEndereco endereco) {
}
