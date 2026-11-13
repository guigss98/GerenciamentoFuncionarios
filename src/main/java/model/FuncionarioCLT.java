package model;

import exception.DadosInvalidosException;

public class FuncionarioCLT extends Funcionario implements Tributavel {
    private double beneficios;

    public FuncionarioCLT(int codigo, String nome, String cpf, double salarioBase, double beneficios) throws DadosInvalidosException {
        super(codigo, nome, cpf, salarioBase);
        validarBeneficios(beneficios);
        this.beneficios = beneficios;
    }
    @Override
    public double calcularRemuneracao() {
        return getSalarioBase() + beneficios;
    }
    @Override
    public double calcularTributos() {
        return getSalarioBase() * 0.11;
    }

    public double getBeneficios() {
        return beneficios;
    }

    public void setBeneficios(double beneficios) throws DadosInvalidosException {
        validarBeneficios(beneficios);
        this.beneficios = beneficios;
    }
    public void validarBeneficios(double beneficios) throws DadosInvalidosException {
        if (beneficios < 0) {
            throw new DadosInvalidosException("O valor dos beneficios não pode ser negativo.");
        }
    }
}
