package br.com.exibicaodonome.api.Controller;


import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/meu-nome")
public class ExibirNomeController {

    @RequestMapping
    @ResponseStatus(HttpStatus.OK)
    public String exibirNome() {
        return "Miguel Rodrigues Carneiro";
    }

}
