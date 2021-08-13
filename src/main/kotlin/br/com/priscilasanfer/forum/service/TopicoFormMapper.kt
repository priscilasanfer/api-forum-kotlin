package br.com.priscilasanfer.forum.service

import br.com.priscilasanfer.forum.dto.NovoTopicoForm
import br.com.priscilasanfer.forum.mapper.Mapper
import br.com.priscilasanfer.forum.modelo.Topico
import org.springframework.stereotype.Component

@Component
class TopicoFormMapper(
        private val cursoService: CursoService,
        private val usuarioService: UsuarioService,
) : Mapper<NovoTopicoForm, Topico> {
    override fun map(t: NovoTopicoForm): Topico {
        return Topico(
                titulo = t.titulo,
                mensagem = t.mensagem,
                curso = cursoService.buscarPorId(t.idCurso),
                autor = usuarioService.buscarPorId(t.idAutor)
        )
    }
}
