package br.com.priscilasanfer.forum.service

import br.com.priscilasanfer.forum.modelo.Topico
import br.com.priscilasanfer.forum.repository.TopicoRepository
import org.springframework.stereotype.Service

@Service
class TopicoService(val repository: TopicoRepository) {

    fun listar(): List<Topico> {
        return repository.findAll()
    }
}