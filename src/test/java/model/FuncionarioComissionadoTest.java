package model;

import exception.DadosInvalidosException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FuncionarioComissionadoTest {
    @Test
    @DisplayName("Deve calcular a remuneração somando o salário base com a comissão das vendas")
    void deveCalcularRemuneracaoCorretamente() throws DadosInvalidosException {
        FuncionarioComissionado comissionado = new FuncionarioComissionado(3, "Bruna", "999.888.777-66", 2000.00, 50000.00, 10.00);
        double remuneracaoEsperada = 7000.00;
        assertEquals(remuneracaoEsperada, comissionado.calcularRemuneracao());
    }
    @Test
    @DisplayName("Deve lançar exceção para percentual de comissão inválido (menor que 0 ou maior que 100).")
    void deveLancarExcecaoParaComissaoInvalida() {
        assertThrows(DadosInvalidosException.class, () -> {
            new FuncionarioComissionado(3, "Bruna", "999.888.777-66", 2000.00, 50000.00, 150.00);
        });
    }
}
