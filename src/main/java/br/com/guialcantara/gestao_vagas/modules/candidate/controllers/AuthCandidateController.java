package br.com.guialcantara.gestao_vagas.modules.candidate.controllers;

import br.com.guialcantara.gestao_vagas.modules.candidate.dto.AuthCandidateRequestDTO;
import br.com.guialcantara.gestao_vagas.modules.candidate.services.AuthCandidate;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/candidate")
@Tag(name = "Candidato", description = "Informações do candidato")
public class AuthCandidateController {

    @Autowired
    AuthCandidate authCandidate;

    @PostMapping("/auth")
    @Operation(summary = "Autenticação de candidato", description = "Essa função é responsável por autenticar um candidato")
    public ResponseEntity<Object> authenticate(@RequestBody AuthCandidateRequestDTO authCandidateRequestDTO){
        try {
            var result = this.authCandidate.execute(authCandidateRequestDTO);
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
        }
    }
}
