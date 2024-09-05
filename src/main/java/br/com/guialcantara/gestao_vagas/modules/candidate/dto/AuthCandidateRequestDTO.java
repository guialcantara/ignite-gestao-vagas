package br.com.guialcantara.gestao_vagas.modules.candidate.dto;

import io.swagger.v3.oas.annotations.media.Schema;

public record AuthCandidateRequestDTO(
        @Schema(example = "gui_alcsantara3", requiredMode = Schema.RequiredMode.REQUIRED) String username,
        @Schema(example = "1234556245125", requiredMode = Schema.RequiredMode.REQUIRED) String password
) {
}
