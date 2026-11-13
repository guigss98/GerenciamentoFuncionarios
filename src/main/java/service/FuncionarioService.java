package service;

import exception.FuncionarioJaCadastradoException;
import exception.FuncionarioNaoEncontradoException;
import model.Funcionario;
import model.Tributavel;
import repository.FuncionarioRepository;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioService {

    private final FuncionarioRepository repository;
    public FuncionarioService(FuncionarioRepository repository) {
        this.repository = repository;
    }
    public void cadastrarFuncionario(Funcionario funcionario) throws FuncionarioJaCadastradoException {
        repository.salvar(funcionario);
    }
    public Funcionario buscarPorCodigo(int codigo) throws FuncionarioNaoEncontradoException {
        return repository.buscarPorCodigo(codigo);
    }
    public Funcionario buscarFuncionario(int codigo) throws FuncionarioNaoEncontradoException {
        return repository.buscarPorCodigo(codigo);
    }
    public Funcionario buscarFuncionario(String cpf) throws FuncionarioNaoEncontradoException {
        for (Funcionario f : repository.listarTodos()) {
            if (f.getCpf().equals(cpf)) {
                return f;
            }
        }
        throw new FuncionarioNaoEncontradoException("Funcionário com CPF " + cpf + " não encontrado.");
    }
    public List<Funcionario> buscarFuncionario(String nome, boolean buscaExata) throws FuncionarioNaoEncontradoException {
        List<Funcionario> encontrados = new ArrayList<>();
        for (Funcionario f: repository.listarTodos()) {
            if (buscaExata) {
                if (f.getNome().equalsIgnoreCase(nome)) {
                    encontrados.add(f);
                }
            } else {
                if (f.getNome().toLowerCase().contains(nome.toLowerCase())) {
                    encontrados.add(f);
                }
            }
        }
        if (encontrados.isEmpty()) {
            throw new FuncionarioNaoEncontradoException("Nenhum funcionário encontrado com o nome: " + nome);
        }
        return encontrados;
    }
    public List<Funcionario> listarTodos() {
        return repository.listarTodos();
    }
    public void removerFuncionario(int codigo) throws FuncionarioNaoEncontradoException {
        repository.remover(codigo);
    }
    public double calcularTotalFolhaPagamento() {
        double total = 0.0;
        for (Funcionario f: repository.listarTodos()) {
            total += f.calcularRemuneracao();
        }
        return total;
    }
    public double calcularTotalTributos() {
        double totalTributos = 0.0;
        for (Funcionario f: repository.listarTodos()) {
            if (f instanceof Tributavel tributavel) {
                totalTributos += tributavel.calcularTributos();
            }
        }
        return totalTributos;
    }
}