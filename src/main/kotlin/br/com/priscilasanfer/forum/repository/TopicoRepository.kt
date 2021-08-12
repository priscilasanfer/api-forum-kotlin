package br.com.priscilasanfer.forum.repository

import br.com.priscilasanfer.forum.modelo.Topico
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TopicoRepository: JpaRepository<Topico, Long> {
}