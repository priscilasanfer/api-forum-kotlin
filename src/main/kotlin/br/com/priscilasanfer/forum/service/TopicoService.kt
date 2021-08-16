package br.com.priscilasanfer.forum.service

import br.com.priscilasanfer.forum.dto.AtualizacaoTopicoForm
import br.com.priscilasanfer.forum.dto.NovoTopicoForm
import br.com.priscilasanfer.forum.dto.TopicoView
import br.com.priscilasanfer.forum.exception.NotFoundExeception
import br.com.priscilasanfer.forum.mapper.TopicoFormMapper
import br.com.priscilasanfer.forum.mapper.TopicoViewMapper
import br.com.priscilasanfer.forum.repository.TopicoRepository
import org.springframework.beans.BeanUtils
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class TopicoService(
        private val repository: TopicoRepository,
        private val topicoViewMapper: TopicoViewMapper,
        private val topicoFormMapper: TopicoFormMapper
) {

    fun listar(nomeCurso: String?): List<TopicoView> {
        val topicos = if (nomeCurso == null) {
            repository.findAll()
        } else {
            repository.findByCursoNome(nomeCurso)
        }

        return topicos.stream().map { t ->
            topicoViewMapper.map(t)
        }.collect(Collectors.toList())
    }

    fun buscarPorId(id: Long): TopicoView {
        val topico = repository.findById(id).orElseThrow { NotFoundExeception("Topico com id: ${id} não encontrado") }
        return topicoViewMapper.map(topico)
    }

    fun cadastrar(form: NovoTopicoForm): TopicoView {
        val topico = topicoFormMapper.map(form)
        repository.save(topico)

        return topicoViewMapper.map(topico)
    }


    fun atualizar(form: AtualizacaoTopicoForm, id: Long): TopicoView {
        var topicoAtual = repository.findById(id).orElseThrow { NotFoundExeception("Topico com id: ${id} não encontrado") }
        BeanUtils.copyProperties(form, topicoAtual)
        repository.save(topicoAtual)
        return topicoViewMapper.map(topicoAtual)
    }

    fun deletar(id: Long) {
        repository.deleteById(id)
    }
}