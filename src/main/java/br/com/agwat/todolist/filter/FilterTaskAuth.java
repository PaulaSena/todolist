package br.com.agwat.todolist.filter;

import java.io.IOException;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import br.com.agwat.todolist.user.IUserRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class FilterTaskAuth extends OncePerRequestFilter {

    @Autowired
    private IUserRepository userRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        /* Pegar a autenticação(usuário e senha) */ 
            // pegar parte de um conteudo
            // Authorization.substring(5).trim(); //
            // pegando so a senha YW5hcGF1bGFzZW5hOjEyMzQ1
        var Authorization = request.getHeader("Authorization");

        var authEncoded = Authorization.substring("Basic".length()).trim();
            // System.out.println("Authorization");
            // System.out.println(user_password);

        byte[] authDecode = Base64.getDecoder().decode(authEncoded);
            // System.out.println("Authorization");
            // System.out.println(authDecode);
        var authString = new String(authDecode);
            // System.out.println("Authorization");
            // System.out.println(authString);

            // cria um array apartir do Split ["anapaula","123"]
        String [] credentials = authString.split(":");
        String username = credentials[0];
        String passwordString = credentials[1];
        System.out.println("Authorization");

        System.out.println(username);
        System.out.println(passwordString);

        /* Validar Usuário */
        var user = this.userRepository.findByUsername(username);
        if(user == null){
            response.sendError(401, "Usuário sem autorização!");

        /* Validar Senha  */
        /* Segue viagem  */

        filterChain.doFilter(request, response);



        }

    }

    /*
     * troca de implements filter para extends OncePerRequestFilter
     * public class FilterTaskAuth implements Filter {
     * 
     * @Override
     * public void doFilter(ServletRequest request, ServletResponse response,
     * FilterChain chain)
     * throws IOException, ServletException {
     * 
     * // doFilter Execultar alguma ação, barrar, siga em Frente
     * // Ele recebe request, response e o Chain o que passos pra frente
     * System.out.println("Chegou no Filtro!!");
     * chain.doFilter(request, response);
     * 
     * }
     */

}
