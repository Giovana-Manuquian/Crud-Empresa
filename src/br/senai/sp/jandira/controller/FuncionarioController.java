package br.senai.sp.jandira.controller;

import br.senai.sp.jandira.model.Conexao;
import br.senai.sp.jandira.model.Funcionario;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class FuncionarioController {
    Conexao conexao = new Conexao();
    Connection objConnection = conexao.getConnection();

    public void cadastrarFuncionarios(Funcionario newFuncionario) throws SQLException {
        Statement statement = objConnection.createStatement();

        String queryCadastro = "INSERT INTO funcionario (idFuncionario, " +
                "nome, sobrenome, matricula, permissao, departamento_FK) values (" +
                newFuncionario.getIdFuncionario() + ",'" + newFuncionario.getNome() +
                "','" + newFuncionario.getSobrenome() + "','" + newFuncionario.getMatricula() +
                "'," + newFuncionario.getPermissao() + "," + newFuncionario.getDepartamento_FK() +
                ")";

        statement.executeUpdate(queryCadastro);
        System.out.println("Usuario(a) cadastrado(a) com sucesso");
    }
    public void listarFuncionarios() throws SQLException {
        //responsavel por executar a query no banco
        Statement statement = objConnection.createStatement();

        String queryConsulta = "SELECT * FROM funcionario";

        ResultSet resultSet = statement.executeQuery(queryConsulta);

        Funcionario funcionario = new Funcionario();

        while (resultSet.next()){
            funcionario.setIdFuncionario(resultSet.getInt("idFuncionario"));
            funcionario.setNome(resultSet.getString("nome"));
            funcionario.setSobrenome(resultSet.getString("sobrenome"));
            funcionario.setMatricula(resultSet.getString("matricula"));
            funcionario.setPermissao(resultSet.getInt("permissao"));
            funcionario.setDepartamento_FK(resultSet.getInt("departamento_FK"));

            System.out.println(funcionario.getIdFuncionario());
            System.out.println(funcionario.getNome());
            System.out.println(funcionario.getSobrenome());
            System.out.println(funcionario.getMatricula());
            System.out.println("____________________________");
        }
    }

    public void deletarFuncionarios(String nome) throws SQLException {
        System.out.println("Deletar " + nome);

        Statement statement = objConnection.createStatement();

        String queryDelete = "DELETE FROM funcionario WHERE nome = '" + nome + "'";

        try{
            statement.executeUpdate(queryDelete);
            System.out.println("Usuario(a) " + nome + " deletado(a) com sucesso");
        } catch (Exception erro){
            System.out.println(erro);
        }
    }
    public void consultarFuncionarios(String nome) throws SQLException {
        Statement statement = objConnection.createStatement();

        String queryPesquisa = "SELECT * FROM funcionario WHERE nome = '" + nome + "'";

        ResultSet resultSet = statement.executeQuery(queryPesquisa);

        Funcionario funcionario = new Funcionario();

        while (resultSet.next()){
            funcionario.setIdFuncionario(resultSet.getInt("idFuncionario"));
            funcionario.setNome(resultSet.getString("nome"));
            funcionario.setSobrenome(resultSet.getString("sobrenome"));

            System.out.println(funcionario.getIdFuncionario());
            System.out.println(funcionario.getNome());
            System.out.println(funcionario.getSobrenome());
            System.out.println("____________________________");
        }
    }
    public void editarFuncionarios(String nome, String sobrenome) throws SQLException {
        Statement statement = objConnection.createStatement();


        String queryEditar = "UPDATE funcionario SET sobrenome = '" + sobrenome + "' WHERE nome = '" + nome + "'";

        statement.executeUpdate(queryEditar);
        System.out.println("Funcionário(a) alterado(a) com sucesso");

    }
}
