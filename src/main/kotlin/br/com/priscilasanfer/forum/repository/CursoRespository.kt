package br.com.priscilasanfer.forum.repository

import br.com.priscilasanfer.forum.modelo.Curso
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CursoRespository : JpaRepository<Curso, Long> {
}