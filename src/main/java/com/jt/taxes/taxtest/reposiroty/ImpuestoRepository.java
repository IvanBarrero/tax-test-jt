package com.jt.taxes.taxtest.reposiroty;

import com.jt.taxes.taxtest.entity.Impuesto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface ImpuestoRepository extends JpaRepository<Impuesto, Long> {
    List<Impuesto> findByFechaMovimiento(LocalDate fechaMovimiento);
}
