package br.com.agwat.todolist.user;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
     * **/

     //receber os dados do usuário  // para isso crie uma classe modelo de usuário UserController.
        //public void create(){}

   
     // criando um objeto 

    /*
     **** BODY Para realizar uma requisição tem que usar o @RequestBody

     @PostMapping -> Metodo de enviar dados o mesmo utiliza a Rota do 

     http://127.0.01:8080/users 
    */

    @PostMapping("/")
    
    public void create(@RequestBody UserModel userModel){
        System.out.println(userModel.name);

    }
    
}
