package repository;

import exception.FuncionarioJaCadastradoException;
import exception.FuncionarioNaoEncontradoException;
import model.Funcionario;
import java.util.ArrayList;
import java.util.List;


public class FuncionarioRepository {
    private final List<Funcionario> funcionarios = new ArrayList<>();

    public void salvar(Funcionario funcionario) throws FuncionarioJaCadastradoException {
        for (Funcionario f: funcionarios) {
            if (f.getCodigo() == funcionario.getCodigo() || f.getCpf().equals(funcionario.getCpf())) {
                throw new FuncionarioJaCadastradoException("Funcionário já cadastrado com esse código ou CPF");
            }
        }
        funcionarios.add(funcionario);
    }
    public Funcionario buscarPorCodigo(int codigo) throws FuncionarioNaoEncontradoException {
        for (Funcionario f: funcionarios) {
            if (f.getCodigo() == codigo) {
                return f;
            }
        }
        throw new FuncionarioNaoEncontradoException("Funcionário com código" + codigo + "não encontrado.");
    }
    public List<Funcionario> listarTodos() {
        return new ArrayList<>(funcionarios);
    }
    public void remover(int codigo) throws FuncionarioNaoEncontradoException {
        Funcionario f = buscarPorCodigo(codigo);
        funcionarios.remove(f);
    }
}
