// Criação da Interface

/**
 * Criação de uma CAMADA para gerenciar o Objeto(Entity tb_Users) via post
 * receber do UserModel os dados e passar para o nosso banco de dados 
 * salvar, alterar, Excluir na tabela.
 * CAMADA Repository - Definir uma interface
 * 
 * Possui os métodos mas não cria os metodos nela
 * para isso são necessarios classes externas.
 * Interface só faz representação.
 */


package br.com.agwat.todolist.user;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;


/* * Clicando no JpaRepository, vemos que a Classe recebe um GENERATOR(atributos dinamicos)
* com esses parametros preencidos é possivel utilizar os medodos dessa classe.
* JpaRepository <>
*  public interface JpaRepository<T, ID> extends ListCrudRepository<T, ID>  
* <<< T - qual Classe esta representando?  No caso a Entidade UserModel ,
*    ID - qual tipo de ID essa entidade tem? No caso UUID >>>
* Para utilizar esses metodos preciso instancia-lo no UserControler.
*/

public interface IUserRepository extends JpaRepository <UserModel, UUID>{
    // pedindo para procurar um metodo
    UserModel findByUsername(String username);
    
}
