package br.com.etechoracio.ingresso.repository;

import br.com.etechoracio.ingresso.dto.SalaResponseDTO;
import br.com.etechoracio.ingresso.entity.Sala;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface SalaRepository extends JpaRepository<Sala, Long> {

    @Query("SELECT s FROM Sala s WHERE s.dataExclusao IS NULL")
    Optional<Sala> findByIdAndDataExclusaoIsNull(Long id);
    List<Sala> findByIdSala(Long id,
                            LocalDateTime dataExclusao);
    List<Sala> findByDataExclusaoIsNull();
}