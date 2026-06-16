package br.com.upe.repository;
import br.com.upe.model.Eletroposto;

public class EletropostoRepository {
    private Eletroposto[] eletropostos = new Eletroposto[10];
    private int contador = 0;

    public void cadastrarEletroposto(Eletroposto novoEletroposto) {
        if (contador == eletropostos.length) {
            Eletroposto[] novoArray = new Eletroposto[eletropostos.length * 2];
            for (int i = 0; i < eletropostos.length; i++) {
                novoArray[i] = eletropostos[i];
            }
            eletropostos = novoArray;
        }
        eletropostos[contador] = novoEletroposto;
        contador++;
    }

    public Eletroposto buscarEletroposto(int id) {
        for (int i = 0; i < contador; i++) {
            if (eletropostos[i].getId() == id) {
                return eletropostos[i];
            }
        }
        return null;
    }

    public boolean atualizarEletroposto(int id, Eletroposto eletropostoAtualizado) {
        for (int i = 0; i < contador; i++) {
            if (eletropostos[i].getId() == id) {
                eletropostos[i] = eletropostoAtualizado;
                return true;
            }
        }
        return false;
    }

    public boolean excluirEletroposto(int id) {
        for (int i = 0; i < contador; i++) {
            if (eletropostos[i].getId() == id) {
                for (int j = i; j < contador - 1; j++) {
                    eletropostos[j] = eletropostos[j + 1];
                }
                eletropostos[contador - 1] = null;
                contador--;
                return true;
            }
        }
        return false;
    }

    public br.com.upe.model.Eletroposto[] getEletropostos() {
        return this.eletropostos;
    }

    public int getContador() {
        return this.contador;
    }
}