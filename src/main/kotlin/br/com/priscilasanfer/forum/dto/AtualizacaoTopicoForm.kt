package br.com.priscilasanfer.forum.dto

import javax.validation.constraints.NotEmpty
import javax.validation.constraints.Size

data class AtualizacaoTopicoForm(
        @field:NotEmpty @field:Size(min = 5, max = 100) val titulo: String,
        @field:NotEmpty val mensagem: String
)