package med.voll.api.service;

import med.voll.api.domain.dtos.medicos.DadosAtualizarMedico;
import med.voll.api.domain.dtos.medicos.DadosCadastroMedico;
import med.voll.api.domain.dtos.medicos.DadosListagemMedico;
import med.voll.api.domain.model.Medico;
import med.voll.api.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class MedicoServiceImpl implements MedicoService{

    @Autowired
    private MedicoRepository repository;
    @Override
    public Medico inserir(DadosCadastroMedico dto){
        var medico= new Medico(dto);
        return repository.save(medico);
    }

    @Override
    public Medico buscar(Long id){
       return  repository.getReferenceById(id);
    }
    @Override
    public Page<DadosListagemMedico> listar(Pageable pageable){
        return   repository.findAllByAtivoTrue(pageable).map(DadosListagemMedico::new);
    }

    @Override
    public Medico atualizar(DadosAtualizarMedico dto, Long id){
        var medico = repository.getReferenceById(id);
        medico.atualizarDados(dto);
       return  medico;
    }

    @Override
    public void deletar(Long id){
        var medico = repository.getReferenceById(id);
        medico.excluir();
    }
}
