package br.com.priscilasanfer.forum.modelo

import com.fasterxml.jackson.annotation.JsonIgnore
import java.time.LocalDateTime
import javax.persistence.*

@Entity
data class Topico(
        var titulo: String,
        var mensagem: String,

        @ManyToOne
        val curso: Curso,

        @ManyToOne
        val autor: Usuario,
        @field:Enumerated(EnumType.STRING)
        val status: StatusTopico = StatusTopico.NAO_RESPONDIDO,

        @OneToMany(mappedBy = "topico")
        @JsonIgnore
        val resposta: List<Resposta> = ArrayList()
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
    val dataCriacao: LocalDateTime = LocalDateTime.now()
}
