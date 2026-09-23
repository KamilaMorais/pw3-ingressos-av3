package br.com.etechoracio.ingresso.controller;

import br.com.etechoracio.ingresso.dto.FilmeResponseDTO;
import br.com.etechoracio.ingresso.dto.FilmeSessoesResponseDTO;
import br.com.etechoracio.ingresso.service.FilmeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.function.LongConsumer;

@RestController
@RequestMapping("/filmes")
@CrossOrigin("*")
public class FilmeController {

    @Autowired
    private FilmeService filmeService;

    @GetMapping("/em-cartaz")
    public List<FilmeResponseDTO> findByEmCartaz() {
        return filmeService.findByEmCartaz();
    }

    @GetMapping("/{id}/sessoes")
    public ResponseEntity<FilmeSessoesResponseDTO> findBySessoesByFilmeId(@PathVariable Long id)
    {
        var result = filmeService.findByIdWithSessoes(id);
        if(result.isPresent()){
            return ResponseEntity.ok(result.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
