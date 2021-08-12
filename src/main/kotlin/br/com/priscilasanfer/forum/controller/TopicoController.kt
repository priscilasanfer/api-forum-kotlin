package br.com.priscilasanfer.forum.controller

import br.com.priscilasanfer.forum.modelo.Topico
import br.com.priscilasanfer.forum.repository.TopicoRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/topicos")
class TopicoController(val repository: TopicoRepository) {

    @GetMapping
    fun listar(): List<Topico> {
        return repository.findAll()
    }
}