package br.com.guialcantara.gestao_vagas.modules.company.services;

import br.com.guialcantara.gestao_vagas.exceptions.CompanyNotFoundException;
import br.com.guialcantara.gestao_vagas.modules.company.repositories.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.guialcantara.gestao_vagas.modules.company.entities.JobEntity;
import br.com.guialcantara.gestao_vagas.modules.company.repositories.JobRepository;

@Service
public class CreateJob {

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private CompanyRepository companyRepository;

    public JobEntity execute(JobEntity jobEntity) {
        companyRepository.findById(jobEntity.getCompanyId()).orElseThrow(() -> {
            throw new CompanyNotFoundException();
        });

        return this.jobRepository.save(jobEntity);
    }
}
