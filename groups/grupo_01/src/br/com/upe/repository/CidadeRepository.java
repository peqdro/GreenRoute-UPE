package br.com.upe.repository;
import br.com.upe.model.Cidade;

public class CidadeRepository {
    private Cidade[] cidades = new Cidade[10];
    private int contador = 0;

    public void cadastrarCidade(Cidade novaCidade) {
        if (contador == cidades.length) {
            Cidade[] novoArray = new Cidade[cidades.length * 2];
            for (int i = 0; i < cidades.length; i++) {
                novoArray[i] = cidades[i];
            }
            cidades = novoArray;
        }
        cidades[contador] = novaCidade;
        contador++;
    }

    public Cidade buscarCidade(int id) {
        for (int i = 0; i < contador; i++) {
            if (cidades[i].getId() == id) {
                return cidades[i];
            }
        }
        return null;
    }
    public boolean atualizarCidade(int id, Cidade cidadeAtualizada){
        for (int i = 0; i < contador; i++) {
            if (cidades[i].getId() == id) {
                cidades[i] = cidadeAtualizada;
                return true;
            }
        }
        return false;

    }
    public boolean excluirCidade(int id){
        for (int i = 0; i < contador; i++) {
            if (cidades[i].getId() == id) {
                for (int j = i; j < contador - 1; j++) {
                    cidades[j] = cidades[j + 1];
                }
                cidades[contador - 1] = null;

                contador--;
                return true;
            }
        }
        return false;

    }
}
