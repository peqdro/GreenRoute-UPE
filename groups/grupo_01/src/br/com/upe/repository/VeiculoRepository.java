package br.com.upe.repository;

import br.com.upe.model.Veiculo;

public class VeiculoRepository {
    private Veiculo[] veiculos = new Veiculo[10];
    private int contador = 0;

    public void cadastrarVeiculo(Veiculo novoVeiculo) {
        if (contador == veiculos.length) {
            Veiculo[] novoArray = new Veiculo[veiculos.length * 2];
            for (int i = 0; i < veiculos.length; i++) {
                novoArray[i] = veiculos[i];
            }
            veiculos = novoArray;
        }
        veiculos[contador] = novoVeiculo;
        contador++;
    }

    public Veiculo buscarVeiculo(int id) {
        for (int i = 0; i < contador; i++) {
            if (veiculos[i].getId() == id) {
                return veiculos[i];
            }
        }
        return null;
    }

    public boolean atualizarVeiculo(int id, Veiculo veiculoAtualizado) {
        for (int i = 0; i < contador; i++) {
            if (veiculos[i].getId() == id) {
                veiculos[i] = veiculoAtualizado;
                return true;
            }
        }
        return false;
    }

    public boolean excluirVeiculo(int id) {
        for (int i = 0; i < contador; i++) {
            if (veiculos[i].getId() == id) {
                for (int j = i; j < contador - 1; j++) {
                    veiculos[j] = veiculos[j + 1];
                }
                veiculos[contador - 1] = null;
                contador--;
                return true;
            }
        }
        return false;
    }
}