package br.com.etechoracio.ingresso.service;

import br.com.etechoracio.ingresso.dto.RequestDTO;
import br.com.etechoracio.ingresso.dto.SalaResponseDTO;
import br.com.etechoracio.ingresso.entity.Sala;
import br.com.etechoracio.ingresso.mapper.SalaMapper;
import br.com.etechoracio.ingresso.repository.SalaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class SalaService
{

    @Autowired
    private SalaRepository salaRepository;

    @Autowired
    private SalaMapper salaMapper;

    public Optional<SalaResponseDTO> findByIdSala(Long id) {
        return salaRepository.findByIdAndDataExclusaoIsNull(id)
                .map(salaMapper::toDTO);
    }
    public List<SalaResponseDTO> listarsSalasDisponiveis() {
        var salas = salaRepository.findByDataExclusaoIsNull();
        return salaMapper.toRespostaDTOList(salas);
    }

    public SalaResponseDTO criarSala(RequestDTO dto) {
        Sala salaEntity = salaMapper.toEntity(dto);
        Sala salaSalva = salaRepository.save(salaEntity);
        SalaResponseDTO respostaDTO = salaMapper.toDTO(salaSalva);
        return respostaDTO;
    }
}