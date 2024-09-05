package br.com.guialcantara.gestao_vagas.modules.company.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.guialcantara.gestao_vagas.exceptions.UserFoundException;
import br.com.guialcantara.gestao_vagas.modules.company.entities.CompanyEntity;
import br.com.guialcantara.gestao_vagas.modules.company.services.CreateCompany;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/company")
@Tag(name = "Empresa", description = "Informações da empresa")
public class CompanyController {
  @Autowired
  private CreateCompany createCompany;

  @PostMapping("")
  public ResponseEntity<Object> create(@Valid @RequestBody CompanyEntity companyEntity) {
    try {
      var result = this.createCompany.execute(companyEntity);
      return ResponseEntity.ok().body(result);
    } catch (UserFoundException e) {
      return ResponseEntity.badRequest().body(e.getMessage());
    }
  }
}
