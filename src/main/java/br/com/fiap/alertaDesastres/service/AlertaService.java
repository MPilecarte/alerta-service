package br.com.fiap.alertaDesastres.service;



import br.com.fiap.alertaDesastres.model.Alerta;

import br.com.fiap.alertaDesastres.repository.AlertaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class AlertaService {

    @Autowired
    private AlertaRepository alertaRepository;

    public Alerta adicionar(Alerta alerta){
        return alertaRepository.save(alerta);
    }

    public Alerta buscarPorId(Long id){

        Optional<Alerta> alertaOptional = alertaRepository.findById(id);

        if(alertaOptional.isPresent()){
            return alertaOptional.get();
        }else {
            throw new RuntimeException("Alerta nao encontrado");
        }


    }

    public List<Alerta> listarAlertas(){
        return alertaRepository.findAll();
    }

    public void excluir(Long id){
        Optional<Alerta> alertaOptional = alertaRepository.findById(id);

        if (alertaOptional.isPresent()){
            alertaRepository.delete(alertaOptional.get());
        } else{
            throw new RuntimeException("Alerta nao encontrado");
        }
    }

    public List<Alerta> mostrarAlertasPorData(LocalDate dataInicial, LocalDate dataFinal){
        return alertaRepository.findByDataBetween(dataInicial, dataFinal);
    }

    public Alerta atualizar(Alerta alerta){
        Optional<Alerta> alertaOptional = alertaRepository.findById(alerta.getId());

        if (alertaOptional.isPresent()){
            return alertaRepository.save(alerta);
        } else{
            throw new RuntimeException("Nao existe esse alerta");
        }
    }
}
