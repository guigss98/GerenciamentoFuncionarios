package model;

import exception .DadosInvalidosException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FuncionarioPJTest {
    @Test
    @DisplayName("Deve calcular a remuneração multiplicando o valor do projeto pela quantidade")
    void deveCalcularRemuneracaoCorretamente() throws DadosInvalidosException {
        FuncionarioPJ pj = new FuncionarioPJ(2, "João", "987.654.321-00", 1500.00, 3);
        double remuneracaoEsperada = 4500.00;
        assertEquals(remuneracaoEsperada, pj.calcularRemuneracao());
    }
    @Test
    @DisplayName("Deve lançar exceção quando a quantidade de projetos for negativa.")
    void deveLancarExcecaoParaQuantidadeProjetosNegativa() {
        assertThrows(DadosInvalidosException.class, () -> {
            new FuncionarioPJ(2, "João", "987.654.321-00", 1500.00, -1);
        });
    }


}
