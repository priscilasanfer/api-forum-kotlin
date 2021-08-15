package br.com.priscilasanfer.forum.service

import br.com.priscilasanfer.forum.exception.NotFoundExeception
import br.com.priscilasanfer.forum.modelo.Usuario
import br.com.priscilasanfer.forum.repository.UsuarioRespository
import org.springframework.stereotype.Service

@Service
class UsuarioService (private val repository: UsuarioRespository) {

    fun buscarPorId(id: Long): Usuario {
        // return repository.getOne(id)
        return repository.findById(id).orElseThrow{NotFoundExeception("Usuario com id ${id} não encontrado")}
    }
}