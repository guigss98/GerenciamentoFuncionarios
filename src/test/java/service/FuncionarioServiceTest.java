package service;

import exception.DadosInvalidosException;
import exception.FuncionarioJaCadastradoException;
import exception.FuncionarioNaoEncontradoException;
import model.Funcionario;
import model.FuncionarioCLT;
import model.FuncionarioPJ;
import repository.FuncionarioRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class FuncionarioServiceTest {

    private FuncionarioRepository repository;
    private FuncionarioService service;

    @BeforeEach
    void setUp() {
        repository = new FuncionarioRepository();
        service = new FuncionarioService(repository);
    }
    @Test
    @DisplayName("Deve calcular o total da folha somando as remunerações de todos os funcionários")
    void deveCalcularTotalFolhaPagamento() throws DadosInvalidosException, FuncionarioJaCadastradoException {
        FuncionarioCLT clt = new FuncionarioCLT(1, "Guilherme", "123.456.789-00", 3000.0, 500.0);
        FuncionarioPJ pj = new FuncionarioPJ(2, "João", "987.654.321-00", 2000.0, 2);

        service.cadastrarFuncionario(clt);
        service.cadastrarFuncionario(pj);

        assertEquals(7500.0, service.calcularTotalFolhaPagamento());
    }
    @Test
    @DisplayName("Deve calcular tributos apenas dos funcionários que são Tributáveis")
    void deveCalcularTotalTributosApenasDeTributaveis() throws DadosInvalidosException, FuncionarioJaCadastradoException {
        FuncionarioCLT clt = new FuncionarioCLT(1, "Guilherme", "123.456.789-00", 3000.0, 500.0);
        FuncionarioPJ pj = new FuncionarioPJ(2, "João", "987.654.321-00", 2000.0, 2);

        service.cadastrarFuncionario(clt);
        service.cadastrarFuncionario(pj);

        assertEquals(330.0, service.calcularTotalTributos());
    }
    @Test
    @DisplayName("Deve buscar funcionários usando métodos sobrecarregados (código, CPF e nome)")
    void deveBuscarFuncionariosPorSobrecarga() throws DadosInvalidosException, FuncionarioJaCadastradoException, FuncionarioNaoEncontradoException {
        FuncionarioCLT clt = new FuncionarioCLT(1, "Guilherme", "123.456.789-00", 3000.0, 500.0);
        FuncionarioPJ pj = new FuncionarioPJ(2, "João", "987.654.321-00", 2000.0, 2);

        service.cadastrarFuncionario(clt);
        service.cadastrarFuncionario(pj);

        Funcionario porCodigo = service.buscarFuncionario(1);
        assertEquals("Guilherme", porCodigo.getNome());

        Funcionario porCpf = service.buscarFuncionario("987.654.321-00");
        assertEquals("João", porCpf.getNome());

        List<Funcionario> porNome = service.buscarFuncionario("Guilherme", false);
        assertEquals(1, porNome.size());
    }
}