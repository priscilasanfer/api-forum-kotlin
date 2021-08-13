package br.com.priscilasanfer.forum.service

import br.com.priscilasanfer.forum.dto.NovoTopicoDto
import br.com.priscilasanfer.forum.modelo.Topico
import br.com.priscilasanfer.forum.repository.TopicoRepository
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
class TopicoService(
        val repository: TopicoRepository,
        val cursoService: CursoService,
        val usuarioService: UsuarioService) {

    fun listar(): List<Topico> {
        return repository.findAll()
    }

    fun buscarPorId(id: Long): Topico {
        val topico = repository.findById(id)

        if (topico.isEmpty) {
            return throw NoSuchElementException("Topico com id ${id} não encontrado")
        }

        return topico.get()

    }

    @Transactional
    fun cadastrar(dto: NovoTopicoDto): Topico {
        val topico = Topico(
                titulo = dto.titulo,
                mensagem = dto.mensagem,
                curso = cursoService.buscarPorId(dto.idCurso),
                autor = usuarioService.buscarPorId(dto.idAutor)
        )

        return repository.save(topico)
    }
}