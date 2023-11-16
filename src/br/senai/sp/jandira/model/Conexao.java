package br.senai.sp.jandira.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    private String servidor, banco, user, password;

    //tipo de var, representa conexao com banco
    public Connection conexao;

    //construtor
    public Conexao(){
        //setando as variaveis para conexao via construtor (usando encapsulamento)
        this.servidor = "localhost";
        this.banco = "db_senai_java";
        this.user = "root";
        this.password = "bcd127";
    }

    //usa o drive para acessar banco
    public void connectDriver(){
        try {
            this.conexao = DriverManager.getConnection("jdbc:mysql://" + this.servidor + "/" + this.banco, this.user, this.password);
        } catch (SQLException erro){
            System.out.println(erro);
        }
    }
    public Connection getConnection(){
        connectDriver();
        return conexao;
    }
}
