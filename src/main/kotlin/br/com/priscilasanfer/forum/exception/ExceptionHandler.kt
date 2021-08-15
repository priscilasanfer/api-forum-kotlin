package br.com.priscilasanfer.forum.exception

import br.com.priscilasanfer.forum.dto.ErrorView
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice
import javax.servlet.http.HttpServletRequest

@RestControllerAdvice
class ExceptionHandler {

    @ExceptionHandler(NotFoundExeception::class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    fun handleNotFound(
            exeception: NotFoundExeception,
            request: HttpServletRequest
    ): ErrorView {
        return ErrorView(
                status = HttpStatus.NOT_FOUND.value(),
                error = HttpStatus.NOT_FOUND.name,
                message = exeception.message,
                path = request.servletPath
        )
    }
}