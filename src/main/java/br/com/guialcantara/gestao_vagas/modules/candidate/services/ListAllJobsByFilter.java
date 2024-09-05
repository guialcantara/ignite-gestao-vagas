package br.com.guialcantara.gestao_vagas.modules.candidate.services;

import br.com.guialcantara.gestao_vagas.modules.company.entities.JobEntity;
import br.com.guialcantara.gestao_vagas.modules.company.repositories.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListAllJobsByFilter {

    @Autowired
    private JobRepository jobRepository;

    public List<JobEntity> execute(String filter){
       return this.jobRepository.findByDescriptionContainingIgnoreCase(filter);
    }
}
