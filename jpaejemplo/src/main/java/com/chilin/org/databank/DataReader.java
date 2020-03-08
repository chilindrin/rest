package com.chilin.org.databank;

import com.chilin.org.model.Usuario;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Slf4j
@Component
public class DataReader {

    private static final String COMMA = ",";

    public List<Usuario> createUsuariosFromCSVFile(String fileName) {
        ClassLoader cl = this.getClass().getClassLoader();
        InputStream inputStream = cl.getResourceAsStream(fileName);
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
        List<Usuario> inputList = br.lines().map(mapToItem).collect(Collectors.toList());
        try {
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return inputList;
    }

    private Function<String, Usuario> mapToItem = (line) -> {
        String[] row = line.split(COMMA);// a CSV has comma separated lines
        Usuario usuario = new Usuario();
        usuario.setNombre(row[0]);
        usuario.setApellido(row[1]);
        usuario.setCantidadruedas(Integer.parseInt(row[2]));
        usuario.setModelo(Integer.parseInt(row[3]));
        return usuario;
    };

}
