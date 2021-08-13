package br.com.priscilasanfer.forum.service

import br.com.priscilasanfer.forum.dto.NovoTopicoForm
import br.com.priscilasanfer.forum.dto.TopicoView
import br.com.priscilasanfer.forum.modelo.Topico
import br.com.priscilasanfer.forum.repository.TopicoRepository
import org.springframework.stereotype.Service
import java.util.stream.Collectors
import javax.transaction.Transactional

@Service
class TopicoService(
        val repository: TopicoRepository,
        val cursoService: CursoService,
        val usuarioService: UsuarioService) {

    fun listar(): List<TopicoView> {
        val topicos = repository.findAll()
        return topicos.stream().map { t ->
            TopicoView(
                    id = t.id,
                    titulo = t.titulo,
                    mensagem = t.mensagem,
                    status = t.status,
                    dataCriacao = t.dataCriacao
            )
        }.collect(Collectors.toList())
    }

    fun buscarPorId(id: Long): TopicoView {
        val topico = repository.findById(id)

        if (topico.isEmpty) {
            return throw NoSuchElementException("Topico com id ${id} não encontrado")
        }

        return TopicoView(
                id = topico.get().id,
                titulo = topico.get().titulo,
                mensagem = topico.get().mensagem,
                status = topico.get().status,
                dataCriacao = topico.get().dataCriacao
        )

    }

    @Transactional
    fun cadastrar(dto: NovoTopicoForm) {
        val topico = Topico(
                titulo = dto.titulo,
                mensagem = dto.mensagem,
                curso = cursoService.buscarPorId(dto.idCurso),
                autor = usuarioService.buscarPorId(dto.idAutor)
        )
        repository.save(topico)
    }
}