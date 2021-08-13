package br.com.priscilasanfer.forum.service

import br.com.priscilasanfer.forum.dto.NovoTopicoForm
import br.com.priscilasanfer.forum.dto.TopicoView
import br.com.priscilasanfer.forum.mapper.TopicoViewMapper
import br.com.priscilasanfer.forum.modelo.Topico
import br.com.priscilasanfer.forum.repository.TopicoRepository
import org.springframework.stereotype.Service
import java.util.stream.Collectors
import javax.transaction.Transactional

@Service
class TopicoService(
        private val repository: TopicoRepository,
        private val topicoViewMapper: TopicoViewMapper,
        private val topicoFormMapper: TopicoFormMapper
) {

    fun listar(): List<TopicoView> {
        val topicos = repository.findAll()
        return topicos.stream().map { t ->
            topicoViewMapper.map(t)
        }.collect(Collectors.toList())
    }

    fun buscarPorId(id: Long): TopicoView {
        val topico = repository.findById(id)

        if (topico.isEmpty) {
            return throw NoSuchElementException("Topico com id ${id} não encontrado")
        }

        return topicoViewMapper.map(topico.get())

    }

    @Transactional
    fun cadastrar(form: NovoTopicoForm) {
        val topico = topicoFormMapper.map(form)
        repository.save(topico)
    }
}