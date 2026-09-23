package br.com.etechoracio.ingresso.controller;

import br.com.etechoracio.ingresso.dto.RequestDTO;
import br.com.etechoracio.ingresso.dto.SalaResponseDTO;
import br.com.etechoracio.ingresso.service.SalaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.ServerResponse;

import java.util.List;

import static org.springframework.web.servlet.function.ServerResponse.status;

@RestController
@RequestMapping("/salas")
@CrossOrigin("*")
public class SalaController {

    @Autowired
    private SalaService salaService;

    @GetMapping
    public ResponseEntity<List<SalaResponseDTO>> listarSalasDisponiveis() {
        List<SalaResponseDTO> salasDisponiveis = salaService.listarsSalasDisponiveis();

        return ResponseEntity.ok(salasDisponiveis);
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<ServerResponse.BodyBuilder>> findByIdSalaDisponivel(@PathVariable Long id) {
        var result = salaService.findByIdSala(id);

        if (result.isPresent()) {

            return ResponseEntity.ok(List.of(status(200)));
        } else {
            return ResponseEntity.status(404).build();
        }
    }

    @PostMapping
    public ResponseEntity<SalaResponseDTO> criarSala(@RequestBody RequestDTO dto) {
        SalaResponseDTO novaSala = salaService.criarSala(dto);
        return ResponseEntity.status(201).body(novaSala);
    }
}