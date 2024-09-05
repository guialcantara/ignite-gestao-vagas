package br.com.guialcantara.gestao_vagas.modules.company.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class CreateJobDTO {
  @Schema(example = "Vaga para pessoa desenvolvedora junior", requiredMode = Schema.RequiredMode.REQUIRED)
  private String description;
  @Schema(example = "Plano de saúde, Gym pass", requiredMode = Schema.RequiredMode.REQUIRED)
  private String benefits;
  @Schema(example = "JUNIOR", requiredMode = Schema.RequiredMode.REQUIRED)
  private String level;
}
