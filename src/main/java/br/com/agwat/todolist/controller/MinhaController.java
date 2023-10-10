package br.com.agwat.todolist.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// @controller  é usado quando precisa de uma flexibilidade maior.

//@Controller // componente camada da requisição com as demais camadas Model e BDD
@RestController// @RestControlle é usado para realizar uma API

@RequestMapping("/primeiraRota/")
//@RequestMapping criação de Rota http://localhost:8080/primeiraRota
public class MinhaController {
    /**
     * 
     * Get - Buscar uma Informação
     * Post - Adicionar um dado/informação
     * Put - Alterar um dado/informação
     * Delete - Remover um dado
     * Patch - Alterar somente una parte da info/dado. 
     * 
     **/


    //Método (funcionalidade de uma Classe)
    @GetMapping("/")
    public String primeiraMensagem(){
        return "Funcionou";
    }
}
