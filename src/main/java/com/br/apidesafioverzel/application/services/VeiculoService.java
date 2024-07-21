package com.br.apidesafioverzel.application.services;

import com.br.apidesafioverzel.adapters.out.repositories.VeiculoRepository;
import com.br.apidesafioverzel.domain.entities.Veiculo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VeiculoService {

    //TODO: Implementar as validaçoes de regras de negocio

    @Autowired
    private VeiculoRepository veiculoRepository;

    public VeiculoService(VeiculoRepository veiculoRepository) {
        this.veiculoRepository = veiculoRepository;
    }

    public Veiculo save(Veiculo veiculo) {
        return veiculoRepository.save(veiculo);
    }

    public Veiculo findByNome(String nome) {
        return veiculoRepository.findByNome(nome);
    }

    public Veiculo findById(Long id) {
        return veiculoRepository.findById(id).orElse(null);
    }

    public void delete(Long id) {
        veiculoRepository.deleteById(id);
    }

    public void update(Veiculo veiculo) {
        veiculoRepository.save(veiculo);
    }

    public boolean existsByNome(String nome) {
        return veiculoRepository.existsByNome(nome);
    }

}
