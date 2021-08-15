package br.com.priscilasanfer.forum.controller

import br.com.priscilasanfer.forum.dto.AtualizacaoTopicoForm
import br.com.priscilasanfer.forum.dto.NovoTopicoForm
import br.com.priscilasanfer.forum.dto.TopicoView
import br.com.priscilasanfer.forum.service.TopicoService
import org.springframework.web.bind.annotation.*
import javax.validation.Valid


@RestController
@RequestMapping("/topicos")
class TopicoController(val service: TopicoService) {


    @GetMapping
    fun listar(): List<TopicoView> {
        return service.listar()
    }

    @GetMapping("/{id}")
    fun buscaPorId(@PathVariable id: Long): TopicoView {
        return service.buscarPorId(id)
    }

    @PostMapping
    fun cadastrar(@RequestBody @Valid dto: NovoTopicoForm) {
        return service.cadastrar(dto)
    }

    @PutMapping("/{id}")
    fun atualizar(@RequestBody @Valid form: AtualizacaoTopicoForm, @PathVariable id: Long){
        return service.atualizar(form, id)
    }

    @DeleteMapping("/{id}")
    fun deletar(@PathVariable id: Long){
        return service.deletar(id)
    }
}