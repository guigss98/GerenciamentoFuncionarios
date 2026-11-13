# Sistema de Gerenciamento de Funcionários

Projeto desenvolvido em Java para a Atividade Avaliativa de Programação Orientada a Objetos. O sistema permite cadastrar funcionários (CLT, PJ e Comissionado), buscar, listar, remover e calcular a folha de pagamento e os tributos.

## Como o projeto está organizado
- `model`: Classes dos funcionários e interfaces.
- `repository`: Guarda a lista de funcionários na memória.
- `service`: Faz os cálculos de pagamento, tributos e buscas.
- `exception`: Erros personalizados (como CPF inválido ou funcionário não encontrado).
- `org.example`: Contém o arquivo `Main.java` com o menu do sistema.

## Como rodar o sistema
1. Abra o projeto no IntelliJ IDEA.
2. Abra o arquivo `src/main/java/org/example/Main.java`.
3. Clique no botão verde de **Play** ao lado do `main` para usar o menu no console.

## Como rodar os testes
1. Na árvore de pastas à esquerda, clique com o botão direito sobre a pasta `src/test`.
2. Clique em **Run 'Tests in 'test''** para verificar se todos os testes com JUnit 5 estão passando.