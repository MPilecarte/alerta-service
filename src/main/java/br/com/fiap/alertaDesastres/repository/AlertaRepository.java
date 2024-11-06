package br.com.fiap.alertaDesastres.repository;


import br.com.fiap.alertaDesastres.model.Alerta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface AlertaRepository extends JpaRepository<Alerta, Long> {

    public Alerta findByNivelRisco(String nivelRisco);


    public List<Alerta> findByDataBetween(LocalDate dataInicial, LocalDate dataFinal);
}
