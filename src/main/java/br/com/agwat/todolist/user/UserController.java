package br.com.agwat.todolist.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.datasource.UserCredentialsDataSourceAdapter;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import at.favre.lib.crypto.bcrypt.BCrypt;

@RestController
@RequestMapping("/users")

public class UserController {
    /**
     * String (texto)
     * Integer (int) Números Inteiros
     * Double(double) Números 0.0000
     * Float (float) Números 0.000
     * char (a c)
     * Date (data)
     * void  - sem retorno do método
     * 
     * *** Para realizar uma requisição tem que usar o @RequestBody
     * 
     *     receber os dados do usuário  // para isso crie uma classe modelo de usuário UserController.
     *         //public void create(){}   // criando um objeto 
     *    BODY Para realizar uma requisição tem que usar o @RequestBody
     * /
       @PostMapping -> Metodo de enviar dados o mesmo utiliza a Rota do http://127.0.01:8080/users */
    /**
     * Crio uma variavel privada e Chamo a interface.
     * Criar variavel para salvar dados da model e carregar o banco
     * **/

     @Autowired
     private IUserRepository userRepository;

    @PostMapping("/")
    
    public ResponseEntity create(@RequestBody UserModel userModel){
        var user = this.userRepository.findByUsername(userModel.getUsername()); // pegue o user name e verifiq se ja esta no banco

        if(user != null){
          //  System.out.println("Usuário Já Existe");
            //mensagem de erro
            //Status code ex: 200, 500.
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Usuário Já Existe!");
        }

        //fazendo o Hast para encriptografar a senha
        var passwordHashred = BCrypt.withDefaults().hashToString(12, userModel.getPasswordString().toCharArray());
        userModel.setPasswordString(passwordHashred);

        var userCreated = this.userRepository.save(userModel);
       return ResponseEntity.status(HttpStatus.CREATED).body(userCreated);
        }
    
}
