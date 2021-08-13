package br.com.priscilasanfer.forum.dto

import br.com.priscilasanfer.forum.modelo.StatusTopico
import java.time.LocalDateTime

data class TopicoView(
        val id: Long?,
        val titulo: String,
        val mensagem: String,
        val status: StatusTopico,
        val dataCriacao: LocalDateTime
)
