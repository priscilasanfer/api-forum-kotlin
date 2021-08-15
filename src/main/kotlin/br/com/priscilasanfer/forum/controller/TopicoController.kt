package br.com.priscilasanfer.forum.controller

import br.com.priscilasanfer.forum.dto.AtualizacaoTopicoForm
import br.com.priscilasanfer.forum.dto.NovoTopicoForm
import br.com.priscilasanfer.forum.dto.TopicoView
import br.com.priscilasanfer.forum.service.TopicoService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder
import java.net.URI
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
    fun cadastrar(
            @RequestBody @Valid dto: NovoTopicoForm,
            uriBuilder: UriComponentsBuilder
    ): ResponseEntity<TopicoView> {
        val topicoview = service.cadastrar(dto)
        val uri = uriBuilder.path("/topicos/${topicoview.id}").build().toUri()
        return ResponseEntity.created(uri).body(topicoview)
    }

    @PutMapping("/{id}")
    fun atualizar(@RequestBody @Valid form: AtualizacaoTopicoForm, @PathVariable id: Long): ResponseEntity<TopicoView> {
        val topicoAtualizado = service.atualizar(form, id)
        return ResponseEntity.ok(topicoAtualizado)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deletar(@PathVariable id: Long) {
        return service.deletar(id)
    }
}