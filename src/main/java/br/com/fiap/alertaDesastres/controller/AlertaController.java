package br.com.fiap.alertaDesastres.controller;



import br.com.fiap.alertaDesastres.model.Alerta;
import br.com.fiap.alertaDesastres.service.AlertaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api")
public class AlertaController {

    @Autowired
    private AlertaService alertaService;

    // Adicionar um novo alerta
    @PostMapping("/alerta")
    public ResponseEntity<Alerta>adicionarAlerta(@RequestBody Alerta alerta) {
        Alerta novoAlerta = alertaService.adicionar(alerta);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoAlerta);
    }

    // Buscar alerta por ID
    @GetMapping("/{id}")
    public ResponseEntity<Alerta> buscarPorId(@PathVariable Long id) {
        try {
            Alerta alerta = alertaService.buscarPorId(id);
            return ResponseEntity.ok(alerta);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    // Listar todos os alertas
    @GetMapping
    public ResponseEntity<List<Alerta>> listarTodos() {
        List<Alerta> alertas = alertaService.listarAlertas();
        return ResponseEntity.ok(alertas);
    }

    // Excluir alerta por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        try {
            alertaService.excluir(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    // Atualizar um alerta existente
    @PutMapping("/{id}")
    public ResponseEntity<Alerta> atualizarAlerta(@PathVariable Long id, @RequestBody Alerta alerta) {
        alerta.setId(id); // Garante que o ID é o mesmo do parâmetro da URL
        try {
            Alerta alertaAtualizado = alertaService.atualizar(alerta);
            return ResponseEntity.ok(alertaAtualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    // Endpoint para mostrar alertas entre duas datas
    @GetMapping("/data")
    public ResponseEntity<List<Alerta>> mostrarAlertasPorData(
            @RequestParam("dataInicial") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataInicial,
            @RequestParam("dataFinal") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataFinal) {
        List<Alerta> alertas = alertaService.mostrarAlertasPorData(dataInicial, dataFinal);
        return ResponseEntity.ok(alertas);
    }


}
