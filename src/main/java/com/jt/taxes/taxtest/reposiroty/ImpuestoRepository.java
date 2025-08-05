package com.jt.taxes.taxtest.reposiroty;

import com.jt.taxes.taxtest.dto.ResumenPorFechaDto;
import com.jt.taxes.taxtest.entity.Impuesto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface ImpuestoRepository extends JpaRepository<Impuesto, Long> {
    List<Impuesto> findByFechaMovimiento(LocalDate fechaMovimiento);

    @Query("""
            SELECT new com.jt.taxes.taxtest.dto.ResumenPorFechaDto(COUNT(i), SUM(i.valor))
            FROM Impuesto i WHERE i.fechaMovimiento = :fechaMovimiento AND i.tipoHorario = :tipoHorario
            """)
    ResumenPorFechaDto findResumenPorFechaDtoByFechaMovimientoAndTipoHorario(LocalDate fechaMovimiento,
                                                                             Character tipoHorario);
}
