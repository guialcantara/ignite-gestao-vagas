package br.com.guialcantara.gestao_vagas.modules.candidate.services;

import br.com.guialcantara.gestao_vagas.modules.candidate.CandidateRepository;
import br.com.guialcantara.gestao_vagas.modules.candidate.dto.ProfileCandidateResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ProfileCandidate {

    @Autowired
    private CandidateRepository candidateRepository;


    public ProfileCandidateResponseDTO execute(UUID idCandidate) {
        var candidate = this.candidateRepository.findById(idCandidate)
                .orElseThrow(() -> new UsernameNotFoundException("User not foud"));

        var candidateDTO = ProfileCandidateResponseDTO.builder()
                .username(candidate.getUsername())
                .description(candidate.getDescription())
                .email(candidate.getEmail())
                .name(candidate.getName())
                .id(candidate.getId())
                .build();

        return candidateDTO;
    }
}
