package model;

import exception.DadosInvalidosException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FuncionarioCLTTest {
    @Test
    @DisplayName("Deve calclar a renumeração somando osalário base com benefícios")
    void deveCalcularRemuneracaoCorretamente() throws DadosInvalidosException {
        FuncionarioCLT clt = new FuncionarioCLT(1, "Guilherme", "123.456.789-00", 3000.00, 500.00);
        double remuneracaoEsperada = 3500.00;
        assertEquals(remuneracaoEsperada, clt.calcularRemuneracao());
    }
    @Test
    @DisplayName("Deve calcular os tributos aplicando 11% sobre o salário base.")
    void deveCalcularTributosCorretamente() throws DadosInvalidosException {
        FuncionarioCLT clt = new FuncionarioCLT(1, "Guilherme", "123.456.789-00", 3000.00, 500.00);
        double atributosEsperados = 330.00;
        assertEquals(atributosEsperados, clt.calcularTributos());
    }
    @Test
    @DisplayName("Deve lançar exceção quando o benefício for negativo.")
    void deveLancarExcecaoParaBeneficioNegativo() throws  DadosInvalidosException {
        assertThrows(DadosInvalidosException.class, () -> {
            new FuncionarioCLT(1, "Guilherme", "123.456.789-00", 3000.00, -100.00);
        });
    }
}
