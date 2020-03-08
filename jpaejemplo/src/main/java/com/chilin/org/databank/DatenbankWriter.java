package com.chilin.org.databank;

import com.chilin.org.model.Usuario;
import com.chilin.org.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DatenbankWriter implements CommandLineRunner {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private DataReader dataReader;

    @Override
    public void run(String... args) throws Exception {
        List<Usuario> dataFromCsv = dataReader.createUsuariosFromCSVFile("usuariodata.csv");
        usuarioRepository.saveAll(dataFromCsv);
    }

}
