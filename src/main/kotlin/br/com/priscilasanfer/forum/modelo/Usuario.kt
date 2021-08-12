package br.com.priscilasanfer.forum.modelo

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
data class Usuario(
        val nome: String,
        val email: String
) {
    @Id
    @GeneratedValue
    var id: Long? = null
}
