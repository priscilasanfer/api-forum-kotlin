package br.com.priscilasanfer.forum.modelo

import java.time.LocalDateTime
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.ManyToOne

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
    @GeneratedValue
    var id: Long? = null
    val dataCriacao: LocalDateTime = LocalDateTime.now()
}