package med.voll.api.domain.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.domain.dtos.medicos.DadosAtualizarMedico;
import med.voll.api.domain.dtos.medicos.DadosCadastroMedico;
import med.voll.api.domain.dtos.medicos.Especialidade;


@Table(name = "medicos")
@Entity(name = "Medico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Medico {

        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private String nome;
    private String email;
    private String telefone;
    private String crm;
    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;
   @Embedded
    private Endereco endereco;

   private Boolean ativo;


    public Medico(DadosCadastroMedico dados) {
        this.nome = dados.nome();
        this.crm = dados.crm();
        this.email= dados.email();
        this.telefone = dados.telefone();
        this.especialidade = dados.especialidade();
        this.endereco = new Endereco(dados.endereco());
        this.ativo = true;
    }

    public void atualizarDados(DadosAtualizarMedico dados) {
        if(dados.nome() != null){
            this.nome = dados.nome();

        }
        if(dados.telefone() != null){
            this.telefone = dados.telefone();

        }
        if(dados.endereco() != null){
            this.endereco.atualizarDados(dados.endereco());

        }

    }
    public void excluir() {
        this.ativo = false ;
    }
}