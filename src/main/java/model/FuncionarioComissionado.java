package model;

import exception.DadosInvalidosException;

public class FuncionarioComissionado extends Funcionario {
    private double totalVendas;
    private double percentualComissao;

    public FuncionarioComissionado(int codigo, String nome, String cpf, double salarioBase, double totalVendas, double percentualComissao) throws DadosInvalidosException {
        super(codigo, nome, cpf, salarioBase);
        validarTotalVendas(totalVendas);
        validarPercentualComissao(percentualComissao);
        this.totalVendas = totalVendas;
        this.percentualComissao = percentualComissao;
    }
    @Override
    public double calcularRemuneracao() {
        return getSalarioBase() + (totalVendas * (percentualComissao / 100.0));
    }

    public double getTotalVendas() {
        return totalVendas;
    }

    public void setTotalVendas(double totalVendas) throws DadosInvalidosException {
        validarTotalVendas(totalVendas);
        this.totalVendas = totalVendas;
    }

    public double getPercentualComissao() {
        return percentualComissao;
    }

    public void setPercentualComissao(double percentualComissao) throws DadosInvalidosException {
        validarPercentualComissao(percentualComissao);
        this.percentualComissao = percentualComissao;
    }
    private void validarTotalVendas(double totalVendas) throws  DadosInvalidosException {
        if (totalVendas < 0) {
            throw new DadosInvalidosException("O total de vendas não pode ser negativo.");
        }
    }
    public void validarPercentualComissao(double percentualComissao) throws DadosInvalidosException {
        if (percentualComissao < 0 || percentualComissao > 100) {
            throw new DadosInvalidosException("O percentual de comissão deve ser entre 0 e 100.");
        }
    }
}
