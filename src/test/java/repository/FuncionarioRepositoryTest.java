package repository;

import exception.DadosInvalidosException;
import exception.FuncionarioJaCadastradoException;
import exception.FuncionarioNaoEncontradoException;
import model.Funcionario;
import model.FuncionarioCLT;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FuncionarioRepositoryTest {

    private FuncionarioRepository repository;

    @BeforeEach
    void setUp() {
        repository = new FuncionarioRepository();
    }
    @Test
    @DisplayName("Deve salvar um funcionário com sucesso")
    void deveSalvarFuncionario() throws DadosInvalidosException, FuncionarioJaCadastradoException, FuncionarioNaoEncontradoException {
        Funcionario f = new FuncionarioCLT(1, "Guilherme", "123.456.789-00", 3000.0, 500.0);
        repository.salvar(f);
        assertEquals(1, repository.listarTodos().size());
        assertEquals("Guilherme", repository.buscarPorCodigo(1).getNome());
    }
    @Test
    @DisplayName("Deve lançar exceção ao tentar salvar funcionário com código duplicado")
    void deveLancarExcecaoParaCodigoDuplicado() throws DadosInvalidosException, FuncionarioJaCadastradoException {
        Funcionario f1 = new FuncionarioCLT(1, "Guilherme", "123.456.789-00", 3000.0, 500.0);
        Funcionario f2 = new FuncionarioCLT(1, "Maria", "999.888.777-66", 2500.0, 300.0);
        repository.salvar(f1);
        assertThrows(FuncionarioJaCadastradoException.class, () -> {
            repository.salvar(f2);
        });
    }

    @Test
    @DisplayName("Deve lançar exceção ao buscar código inexistente")
    void deveLancarExcecaoParaCodigoInexistente() {
        assertThrows(FuncionarioNaoEncontradoException.class, () -> {
            repository.buscarPorCodigo(99);
        });
    }
}