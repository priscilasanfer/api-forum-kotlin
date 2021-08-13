package br.com.priscilasanfer.forum.modelo

import java.time.LocalDateTime
import javax.persistence.*

@Entity
data class Resposta(
        val mensagem: String,
        @ManyToOne
        val autor: Usuario,
        @ManyToOne
        val topico: Topico,
        val solucao: Boolean
){
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
    val dataCriacao: LocalDateTime = LocalDateTime.now()
}