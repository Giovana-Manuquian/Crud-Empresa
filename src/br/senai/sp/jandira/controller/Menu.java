package br.senai.sp.jandira.controller;

import br.senai.sp.jandira.model.Funcionario;

import java.sql.SQLException;
import java.util.Scanner;

public class Menu {
    FuncionarioController funcionario = new FuncionarioController();
    public void executarMenu() throws SQLException {

        boolean continuar = true;

        Scanner scanner = new Scanner(System.in);

        while(continuar){
            System.out.println("-------------------------------------------------");
            System.out.println("                 Seja Bem-Vindo(a)               ");
            System.out.println("-------------------------------------------------");
            System.out.println("                       Menu                      ");
            System.out.println("-------------------------------------------------");
            System.out.println("1 - Cadastrar Funcionario                        ");
            System.out.println("2 - Listar Funcionario                           ");
            System.out.println("3 - Deletar Funcionario                          ");
            System.out.println("4 - Consultar Funcionario                        ");
            System.out.println("5 - Editar Funcionario                           ");
            System.out.println("6 - Sair                                         ");
            System.out.println("-------------------------------------------------");

            System.out.println("Escolha uma opção: ");
            int optionUser = scanner.nextInt();
            scanner.nextLine();

            switch (optionUser){
                case 1:
                    Funcionario newFuncionario = new Funcionario();
                    newFuncionario.cadastrarFuncionario();
                    funcionario.cadastrarFuncionarios(newFuncionario);
                    break;
                case 2:
                    System.out.println("/- Listar Funcionarios -/");
                    funcionario.listarFuncionarios();
                    break;
                case 3:
                    System.out.println("Informe o nome do(a) ex-funcionário(a): ");
                    String nomeDelete = scanner.nextLine();
                    funcionario.deletarFuncionarios(nomeDelete);
                    break;
                case 4:
                    System.out.println("Informe o nome que deseja pesquisar: ");
                    String Consultarnome = scanner.nextLine();
                    funcionario.consultarFuncionarios(Consultarnome);
                    break;
                case 5:
                    System.out.println("Informe o sobrenome que deseja editar: ");
                    String sobrenomeEditar = scanner.nextLine();
                    System.out.println("Informe o novo sobrenome: ");
                    String sobrenomeAtual = scanner.nextLine();
                    funcionario.editarFuncionarios(sobrenomeEditar,sobrenomeAtual);
                    break;
                case 6:
                    continuar = false;
                    break;
            }
        }
    }
}
