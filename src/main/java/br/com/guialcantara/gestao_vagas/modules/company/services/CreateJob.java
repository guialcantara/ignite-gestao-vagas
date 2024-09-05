package br.com.guialcantara.gestao_vagas.modules.company.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.guialcantara.gestao_vagas.modules.company.entities.JobEntity;
import br.com.guialcantara.gestao_vagas.modules.company.repositories.JobRepository;

@Service
public class CreateJob {

  @Autowired
  private JobRepository jobRepository;

  public JobEntity execute(JobEntity jobEntity) {
    return this.jobRepository.save(jobEntity);
  }
}
