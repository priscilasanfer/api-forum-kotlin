package br.com.priscilasanfer.forum.service

import br.com.priscilasanfer.forum.modelo.Topico
import br.com.priscilasanfer.forum.repository.TopicoRepository
import org.springframework.stereotype.Service

@Service
class TopicoService(val repository: TopicoRepository) {

    fun listar(): List<Topico> {
        return repository.findAll()
    }

    fun buscarPorId(id: Long): Topico{
        val topico = repository.findById(id)

        if (topico.isEmpty){
            return throw NoSuchElementException("Topico com id ${id} não encontrado")
        }

        return topico.get()

    }
}