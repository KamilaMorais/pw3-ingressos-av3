package br.com.etechoracio.ingresso.mapper;

import br.com.etechoracio.ingresso.dto.RequestDTO;
import br.com.etechoracio.ingresso.dto.SalaResponseDTO;
import br.com.etechoracio.ingresso.entity.Sala;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring",
        uses = SalaMapper.class)
public interface SalaMapper {
    List<SalaResponseDTO> toRespostaDTOList(List<Sala> entities);
    SalaResponseDTO toDTO(Sala sala);
    Sala toEntity(RequestDTO dto);
}