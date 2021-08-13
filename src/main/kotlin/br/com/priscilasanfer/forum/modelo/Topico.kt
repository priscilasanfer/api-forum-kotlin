package br.com.priscilasanfer.forum.modelo

import com.fasterxml.jackson.annotation.JsonIgnore
import java.time.LocalDateTime
import javax.persistence.*

@Entity
data class Topico(
        val titulo: String,
        val mensagem: String,

        @ManyToOne(cascade=[CascadeType.ALL])
        val curso: Curso,

        @ManyToOne(cascade=[CascadeType.ALL])
        val autor: Usuario,
        @field:Enumerated(EnumType.STRING)
        val status: StatusTopico = StatusTopico.NAO_RESPONDIDO,

        @OneToMany(cascade=[CascadeType.ALL], orphanRemoval = true)
        @JsonIgnore
        val resposta: List<Resposta> = ArrayList()
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
    val dataCriacao: LocalDateTime = LocalDateTime.now()
}
