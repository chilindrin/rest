package com.chilin.org.aver;

import com.chilin.org.model.Usuario;
import com.chilin.org.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ConexionDB implements CommandLineRunner {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public void run(String... args) throws Exception {
        Usuario prueba = new Usuario();
        prueba.setNombre("Andres");
        prueba.setApellido("Guerrero");
        prueba.setModelo(83);
        prueba.setCantidadruedas(4);
        List<Usuario> result = usuarioRepository.findAll();
        usuarioRepository.save(prueba);
    }
}
