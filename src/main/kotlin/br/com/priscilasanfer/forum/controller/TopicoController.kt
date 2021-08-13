package br.com.priscilasanfer.forum.controller

import br.com.priscilasanfer.forum.dto.NovoTopicoDto
import br.com.priscilasanfer.forum.modelo.Topico
import br.com.priscilasanfer.forum.service.TopicoService
import org.springframework.web.bind.annotation.*
import javax.transaction.Transactional


@RestController
@RequestMapping("/topicos")
class TopicoController(val service: TopicoService) {


    @GetMapping
    fun listar(): List<Topico> {
        return service.listar()
    }

    @GetMapping("/{id}")
    fun buscaPorId(@PathVariable id: Long): Topico {
        return service.buscarPorId(id)
    }

    @PostMapping
    fun cadastrar(@RequestBody dto: NovoTopicoDto): Topico {
        return service.cadastrar(dto)
    }
}