package br.com.priscilasanfer.forum.service

import br.com.priscilasanfer.forum.exception.NotFoundExeception
import br.com.priscilasanfer.forum.modelo.Curso
import br.com.priscilasanfer.forum.repository.CursoRespository
import org.springframework.stereotype.Service

@Service
class CursoService(private val repository: CursoRespository) {

    fun buscarPorId(id: Long): Curso {
        return repository.findById(id).orElseThrow { NotFoundExeception("Curso com id ${id} não encontrado") }
    }
}