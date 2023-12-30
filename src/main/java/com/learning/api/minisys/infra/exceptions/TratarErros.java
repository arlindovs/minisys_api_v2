package com.learning.api.minisys.infra.exceptions;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Classe responsável por tratar exceções lançadas pelos controladores.
 * Esta classe utiliza a anotação @RestControllerAdvice para tratar exceções em um nível global.
 */
@ControllerAdvice
public class TratarErros {

    /**
     * Método para tratar exceções do tipo EntityNotFoundException.
     * Quando uma exceção deste tipo é lançada, este método retorna uma resposta HTTP 404.
     * @return ResponseEntity com status 404 (Not Found).
     */
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<?> tratarErro404() {
        return ResponseEntity.notFound().build();
    }

    /**
     * Método para tratar exceções do tipo MethodArgumentNotValidException.
     * Quando uma exceção deste tipo é lançada, este método retorna uma resposta HTTP 400 contendo os erros de validação.
     * @param exception Exceção que contém os erros de validação.
     * @return ResponseEntity com status 400 (Bad Request) e o corpo contendo os erros de validação.
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> tratarErro400(MethodArgumentNotValidException exception) {
        var erros = exception.getFieldErrors();

        return ResponseEntity.badRequest()
                .body(erros.stream().map(DadosErro::new).toList());
    }

    /**
     * Classe interna para representar os dados de um erro de validação.
     * Esta classe é utilizada para criar o corpo da resposta HTTP quando ocorre um erro de validação.
     */
    public record DadosErro(String campo, String mensagem) {
        /**
         * Construtor para criar um objeto DadosErro a partir de um objeto FieldError.
         *
         * @param erro Objeto FieldError que contém as informações do erro de validação.
         */
        public DadosErro(FieldError erro) {

            this(erro.getField(), erro.getDefaultMessage());
        }
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public ResponseEntity<String> errorLoginHttpResponse403(Exception ex) {
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(ex.getMessage());
    }
}



