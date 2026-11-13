package org.example;

import exception.DadosInvalidosException;
import exception.FuncionarioJaCadastradoException;
import exception.FuncionarioNaoEncontradoException;
import model.Funcionario;
import model.FuncionarioCLT;
import model.FuncionarioComissionado;
import model.FuncionarioPJ;
import repository.FuncionarioRepository;
import service.FuncionarioService;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FuncionarioRepository repository = new FuncionarioRepository();
        FuncionarioService service = new FuncionarioService(repository);

        int opcao = -1;

        while (opcao != 0) {
            System.out.println("\nSISTEMA DE GERENCIAMENTO DE FUNCIONÁRIOS");
            System.out.println("1.Cadastrar Funcionário CLT");
            System.out.println("2.Cadastrar Funcionário PJ");
            System.out.println("3.Cadastrar Funcionário Comissionado");
            System.out.println("4.Listar Todos os Funcionários");
            System.out.println("5.Buscar Funcionário por Código");
            System.out.println("6.Remover Funcionário por Código");
            System.out.println("7.Calcular Total da Folha e Tributos");
            System.out.println("0.Sair");
            System.out.print("Escolha uma opção: ");

            try {
                opcao = Integer.parseInt(scanner.nextLine());

                if (opcao == 1) {
                    System.out.print("Código: ");
                    int codigo = Integer.parseInt(scanner.nextLine());
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("CPF: ");
                    String cpf = scanner.nextLine();
                    System.out.print("Salário Base: ");
                    double salarioBase = Double.parseDouble(scanner.nextLine());
                    System.out.print("Benefícios: ");
                    double beneficios = Double.parseDouble(scanner.nextLine());

                    FuncionarioCLT clt = new FuncionarioCLT(codigo, nome, cpf, salarioBase, beneficios);
                    service.cadastrarFuncionario(clt);
                    System.out.println("Funcionário CLT cadastrado com sucesso!");

                } else if (opcao == 2) {
                    System.out.print("Código: ");
                    int codigo = Integer.parseInt(scanner.nextLine());
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("CPF: ");
                    String cpf = scanner.nextLine();
                    System.out.print("Valor por Projeto: ");
                    double valorProjeto = Double.parseDouble(scanner.nextLine());
                    System.out.print("Quantidade de Projetos: ");
                    int qtdProjetos = Integer.parseInt(scanner.nextLine());

                    FuncionarioPJ pj = new FuncionarioPJ(codigo, nome, cpf, valorProjeto, qtdProjetos);
                    service.cadastrarFuncionario(pj);
                    System.out.println("Funcionário PJ cadastrado com sucesso!");

                } else if (opcao == 3) {
                    System.out.print("Código: ");
                    int codigo = Integer.parseInt(scanner.nextLine());
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("CPF: ");
                    String cpf = scanner.nextLine();
                    System.out.print("Salário Base: ");
                    double salarioBase = Double.parseDouble(scanner.nextLine());
                    System.out.print("Total de Vendas: ");
                    double totalVendas = Double.parseDouble(scanner.nextLine());
                    System.out.print("Percentual de Comissão (%): ");
                    double percentual = Double.parseDouble(scanner.nextLine());

                    FuncionarioComissionado comissionado = new FuncionarioComissionado(codigo, nome, cpf, salarioBase, totalVendas, percentual);
                    service.cadastrarFuncionario(comissionado);
                    System.out.println("Funcionário Comissionado cadastrado com sucesso!");

                } else if (opcao == 4) {
                    List<Funcionario> lista = service.listarTodos();
                    if (lista.isEmpty()) {
                        System.out.println("Nenhum funcionário cadastrado.");
                    } else {
                        System.out.println("\n--- Lista de Funcionários ---");
                        for (Funcionario f : lista) {
                            System.out.println("Código: " + f.getCodigo() + " | Nome: " + f.getNome() + " | Remuneração: R$ " + f.calcularRemuneracao());
                        }
                    }

                } else if (opcao == 5) {
                    System.out.print("Digite o código do funcionário: ");
                    int codigo = Integer.parseInt(scanner.nextLine());
                    Funcionario f = service.buscarPorCodigo(codigo);
                    System.out.println("Encontrado -> Código: " + f.getCodigo() + " | Nome: " + f.getNome() + " | CPF: " + f.getCpf() + " | Remuneração: R$ " + f.calcularRemuneracao());

                } else if (opcao == 6) {
                    System.out.print("Digite o código para remover: ");
                    int codigo = Integer.parseInt(scanner.nextLine());
                    service.removerFuncionario(codigo);
                    System.out.println("Funcionário removido com sucesso!");

                } else if (opcao == 7) {
                    System.out.println("Total da Folha de Pagamento: R$ " + service.calcularTotalFolhaPagamento());
                    System.out.println("Total de Tributos Recolhidos: R$ " + service.calcularTotalTributos());

                } else if (opcao == 0) {
                    System.out.println("Encerrando o sistema...");
                } else {
                    System.out.println("Opção inválida! Tente novamente.");
                }

            } catch (DadosInvalidosException | FuncionarioJaCadastradoException | FuncionarioNaoEncontradoException e) {
                System.out.println("Erro de negócio: " + e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println("Erro de entrada: Digite um número válido (use ponto para decimais, ex: 1500.0).");
            }
        }

        scanner.close();
    }
}