package br.com.priscilasanfer.forum.mapper

import br.com.priscilasanfer.forum.dto.TopicoView
import br.com.priscilasanfer.forum.modelo.Topico
import org.springframework.stereotype.Component

@Component
class TopicoViewMapper : Mapper<Topico, TopicoView> {

    override fun map(t: Topico): TopicoView {
        return TopicoView(
                id = t.id,
                titulo = t.titulo,
                mensagem = t.mensagem,
                status = t.status,
                dataCriacao = t.dataCriacao
        )
    }
}