package br.com.guialcantara.gestao_vagas.modules.company.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.guialcantara.gestao_vagas.modules.company.dto.AuthCompanyDTO;
import br.com.guialcantara.gestao_vagas.modules.company.services.AuthCompany;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/company")
@Tag(name = "Empresa", description = "Informações da empresa")
public class AuthCompanyController {

  @Autowired
  private AuthCompany authCompany;

  @PostMapping("/auth")
  public ResponseEntity<Object> create(@RequestBody AuthCompanyDTO authCompanyDTO) {
    try {
      var result = this.authCompany.execute(authCompanyDTO);
      return ResponseEntity.ok().body(result);
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
    }
  }

}
