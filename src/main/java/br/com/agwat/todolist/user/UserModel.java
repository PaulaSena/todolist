package br.com.agwat.todolist.user;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

//classe modelo de usuário UserController.
//gets seter 

@Data
@Entity(name = "td_users")
public class UserModel {

   @Id  //Definir como chave primaria (jakarta)
   @GeneratedValue (generator = "UUID") //Gerar o ID automático

  // @Column(name = "usuario") // definindo o nome da coluna
  @Column(unique = true) // id unico sem duplicidade
   private UUID id;
  @Column(unique = true) // id unico sem duplicidade
   private String username;
   private String name;
   private String passwordString;

   @CreationTimestamp // o dado ao ser criado armazena automaticamente.
   private LocalDateTime createdAT; // definindo a data de criação (camelCase cria um _ separando no banco)
}
