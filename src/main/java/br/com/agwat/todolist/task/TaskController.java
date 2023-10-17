package br.com.agwat.todolist.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// @controller é usado quando precisa de uma flexibilidade maior.
// @RestControlle é usado para realizar uma API
// @Controller componente camada da requisição com as demais camadas Model e BDD
// @RequestMapping ("/primeiraRota") criação de Rota http://localhost:8080/primeiraRota
 /*
     * 1º - Criar variavel privada para chamar a interface e utilizar a notação @Autowired para o Spring gerenciar 
     * instanciar, atualizar, salvar... automaticamente. ((Isso evita que as variaveis criadas fiquem como nulas sem ser inicializadas.))
     * 2º - private ITaskRepository taskRepository; ((taskRepository)) variavel da interface
     * 3º - @PostMapping("/") para enviar os dados para o banco.
     * 4º - Criar variavel para salvar dados da model e carregar o banco (taskCreated)
     * 5º - Run... e verificar no H2
     */
    

@RestController
@RequestMapping("/tasks")
public class TaskController {

   
    @Autowired
    private ITaskRepository taskRepository;

@PostMapping("/")


public TaskModel create(@RequestBody TaskModel taskModel){
    System.out.println("Chegou no Controler Task!!");

    var taskCreated =this.taskRepository.save(taskModel);
    return taskCreated;

}


/*
@GetMapping("/")
public String SegundaMensagem(){
    return "Funcionou";
} */

}

