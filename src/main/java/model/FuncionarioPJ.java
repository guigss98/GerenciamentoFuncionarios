package model;

import exception.DadosInvalidosException;

public class FuncionarioPJ extends Funcionario {
    private double valorPorProjeto;
    private int quantidadeProjetos;

    public FuncionarioPJ(int codigo, String nome, String cpf, double valorPorProjeto, int quantidadeProjetos) throws DadosInvalidosException {
        super(codigo, nome,cpf, valorPorProjeto);
        validarQuantidadeProjetos(quantidadeProjetos);
        this.valorPorProjeto = valorPorProjeto;
        this.quantidadeProjetos = quantidadeProjetos;
    }
    @Override
    public double calcularRemuneracao() {
        return valorPorProjeto * quantidadeProjetos;
    }
    public double getValorPorProjeto () {
        return valorPorProjeto;
    }
    public void setValorPorProjeto(double valorPorProjeto) throws DadosInvalidosException {
        validarQuantidadeProjetos(quantidadeProjetos);
        this.valorPorProjeto = valorPorProjeto;
    }
    private void validarQuantidadeProjetos(int quantidadeProjetos) throws DadosInvalidosException {
        if (quantidadeProjetos < 0) {
            throw new DadosInvalidosException(("A quantidade de projetos não pode ser negativa."));
        }
    }
}
