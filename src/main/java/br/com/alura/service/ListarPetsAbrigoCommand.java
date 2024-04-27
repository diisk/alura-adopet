package br.com.alura.service;

import java.io.IOException;

import br.com.alura.client.ClientHttpConfiguration;

public class ListarPetsAbrigoCommand implements Command {

    @Override
    public void execute() {
        try {
            ClientHttpConfiguration client = new ClientHttpConfiguration();
            PetService petService = new PetService(client);
            petService.listarPetsAbrigo();
        } catch (IOException | InterruptedException ex) {
            System.out.println(ex);
        }
    }

}
