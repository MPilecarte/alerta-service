package br.com.fiap.alertaDesastres.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
public class AlertaDto {

    private Long id;
    private LocalDate data;
    private LocalTime hora;
}
