package model;

import exception.DadosInvalidosException;

public abstract class Funcionario implements Identificavel {
    private int codigo;
    private String nome;
    private String cpf;
    private double salarioBase;

    public Funcionario(int codigo, String nome, String cpf, double salarioBase) throws DadosInvalidosException {
        validarCodigo(codigo);
        validarNome(nome);
        validarCpf(cpf);
        validarSalarioBase(salarioBase);

        this.codigo = codigo;
        this.nome = nome;
        this.cpf = cpf;
        this.salarioBase = salarioBase;
    }
    public abstract double calcularRemuneracao();

    @Override
    public int getCodigo() {
        return codigo;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) throws DadosInvalidosException{
        validarNome(nome);
        this.nome = nome;
    }
    public String getCpf() {
        return cpf;
    }
    public double getSalarioBase() {
        return salarioBase;
    }
    public void setSalarioBase(double salarioBase) throws DadosInvalidosException {
        validarSalarioBase(salarioBase);
        this.salarioBase = salarioBase;
    }
    private void validarCodigo(int codigo) throws DadosInvalidosException {
        if (codigo <=0) {
            throw new DadosInvalidosException("O código do funcionário deve ser maior que zero.");
        }
    }
    private void validarNome(String nome) throws DadosInvalidosException {
        if (nome == null || nome.trim().isEmpty()) {
            throw new DadosInvalidosException("O nome do funcionário não pode ser vazio.");
        }
    }
    private void validarCpf(String cpf) throws DadosInvalidosException {
        if (cpf == null || cpf.trim().isEmpty()) {
            throw new DadosInvalidosException("O CPF do funcionário não pode ser vazio.");
        }
    }
    private void validarSalarioBase(double cpf) throws DadosInvalidosException {
        if (salarioBase < 0) {
            throw new DadosInvalidosException("O salário base não pode ser negativo.");
        }
    }
}
