package br.com.priscilasanfer.forum.modelo

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
data class Curso(
        val nome: String,
        val categoria: String
){
    @Id
    @GeneratedValue
    var id: Long? = null
}