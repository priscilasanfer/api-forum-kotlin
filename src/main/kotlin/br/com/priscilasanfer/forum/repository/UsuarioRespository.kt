package br.com.priscilasanfer.forum.repository

import br.com.priscilasanfer.forum.modelo.Usuario
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UsuarioRespository : JpaRepository<Usuario, Long> {
}