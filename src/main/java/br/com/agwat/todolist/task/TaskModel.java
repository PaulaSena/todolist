package br.com.agwat.todolist.task;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

//classe modelo de usuário TaskController.

    /** Atributos de uma tarefa
     * 
     * Usuário
     * Descrição
     * Título
     * Data de Início
     * Data de Témino
     * Prioridade
     * 
     * **/

@Data //facilita a manipulação de dados criando getters e setters para todos os atributos da classe
@Entity (name = "td_tasks") // Nome da tabela
public class TaskModel {
    
    @Id //definindo o ID abaixo como chave primaria
    @GeneratedValue (generator = "UUID") // Solicitando que gere o ID UUID automaticamente.
    private UUID id;
    private String description;

    //limitando para 50 caracteres no meu titulo
    @Column (length = 50)  //sempre sem ;
    private String title;
    private LocalDateTime startAt;
    private LocalDateTime endAt;
    private String priority;

    private UUID idUser; // id para associar o usuario a tarefa

    @CreationTimestamp // Quando a tarefa for criada no banco de dados
    private LocalDateTime createdAt; // Local que foi criada

}
