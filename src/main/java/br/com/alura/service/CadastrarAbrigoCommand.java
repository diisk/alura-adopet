package br.com.alura.service;

import java.io.IOException;

import br.com.alura.client.ClientHttpConfiguration;

public class CadastrarAbrigoCommand implements Command{

    @Override
    public void execute() {
        try {
            ClientHttpConfiguration client = new ClientHttpConfiguration();
            AbrigoService abrigoService = new AbrigoService(client);
            abrigoService.cadastrarAbrigo();
        } catch (IOException | InterruptedException ex) {
            System.out.println(ex);
        }
    }

}
