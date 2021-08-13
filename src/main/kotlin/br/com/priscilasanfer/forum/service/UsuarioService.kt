package br.com.priscilasanfer.forum.service

import br.com.priscilasanfer.forum.modelo.Usuario
import br.com.priscilasanfer.forum.repository.UsuarioRespository
import org.springframework.stereotype.Service

@Service
class UsuarioService (val repository: UsuarioRespository) {

    fun buscarPorId(id: Long): Usuario {
        val usuario = repository.findById(id)

        if (usuario.isEmpty){
            return throw NoSuchElementException("Usuario com id ${id} não encontrado")
        }

        return usuario.get()
    }
}