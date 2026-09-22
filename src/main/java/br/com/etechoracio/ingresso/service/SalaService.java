package br.com.etechoracio.ingresso.service;

import br.com.etechoracio.ingresso.dto.SalaResponseDTO;
import br.com.etechoracio.ingresso.mapper.SalaMapper;
import br.com.etechoracio.ingresso.repository.SalaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class SalaService {

    @Autowired
    private SalaRepository salaRepository;

    @Autowired
    private SalaMapper salaMapper;

    public Optional<List<SalaResponseDTO>> findByIdSala(Long id){
        return salaRepository.findById(id).map(sala -> {
            var salas = salaRepository.findByIdSala(id, LocalDateTime.now());
            return salaMapper.toRespostaDTOList(salas);
        });
    }
}
