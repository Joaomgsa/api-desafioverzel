package com.br.apidesafioverzel.adapters.in.controllers;

import com.br.apidesafioverzel.application.dto.VeiculoDTO;
import com.br.apidesafioverzel.application.services.VeiculoService;
import com.br.apidesafioverzel.domain.entities.Veiculo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/veiculos")
public class VeiculoController {

    @Autowired
    private VeiculoService veiculoService;

    public VeiculoController(VeiculoService veiculoService) {
        this.veiculoService = veiculoService;
    }

    @GetMapping("/{id}")
    public VeiculoDTO findById(@PathVariable Long id) {
        Veiculo veiculo = veiculoService.findById(id);
        return new VeiculoDTO(veiculo);
    }

    /*TODO: - Implementar a listagem de veiculos
            - Implementar a listagem de veiculos por marca
            - Implementar a listagem de veiculos por ano
            - Implementar a listagem de veiculos por preço
     */
    @PostMapping
    public void save(@RequestBody VeiculoDTO veiculoDTO) {
        Veiculo veiculo = new Veiculo();
        veiculo.setId(veiculoDTO.getId());
        veiculo.setNome(veiculoDTO.getNome());
        veiculo.setMarca(veiculoDTO.getMarca());
        veiculo.setFoto(veiculoDTO.getFoto());
        veiculo.setAno(veiculoDTO.getAno());
        veiculo.setPreco(veiculoDTO.getPreco());
        veiculoService.save(veiculo);
    }
}
