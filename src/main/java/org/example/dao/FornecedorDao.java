package org.example.dao;

import org.example.util.Conexao;
import org.example.model.Fornecedor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FornecedorDao {

    public Fornecedor cadastrarFornecedor(Fornecedor fornecedor) throws SQLException {
        String query = "INSERT INTO Fornecedor (nome,cnpj) VALUES (?,?);";
        try (Connection connection = Conexao.conectar();
             PreparedStatement stmt = connection.prepareStatement(query)) {


            stmt.setString(1, fornecedor.getNome());
            stmt.setString(2, fornecedor.getCnpj());

            stmt.executeUpdate();

        }
        return fornecedor;

    }


    public boolean verificarDuplicidadeFornecedor(Fornecedor fornecedor) throws SQLException {
        String query = "SELECT COUNT(0) AS linhas FROM Fornecedor WHERE nome = ? AND cnpj= ?;";

        try (Connection connection = Conexao.conectar();
             PreparedStatement stmt = connection.prepareStatement(query)) {

            stmt.setString(1, fornecedor.getNome());
            stmt.setString(2, fornecedor.getCnpj());

            ResultSet rs = stmt.executeQuery();

            if (rs.next() && rs.getInt("linhas") > 0) {
                return true;
            }
        }

        return false;
    }


    public List<Fornecedor> listarFornecedores() throws SQLException {
        List<Fornecedor> fornecedores = new ArrayList<>();

        String query = "SELECT id,nome,cnpj FROM Fornecedor;";

        try (Connection connection = Conexao.conectar();
             PreparedStatement stmt = connection.prepareStatement(query)) {
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String cnpj = rs.getString("cnpj");

                var fornecedor = new Fornecedor(id, nome, cnpj);
                fornecedores.add(fornecedor);

            }

        }
        return fornecedores;
    }


    public boolean validarExistencia(Fornecedor fornecedor) throws SQLException {
        String query = "SELECT COUNT(0) AS linhas FROM Fornecedor WHERE id = ?";

        try (Connection connection = Conexao.conectar();
             PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, fornecedor.getId());

            ResultSet rs = stmt.executeQuery();

            if (rs.next() && rs.getInt("linhas") > 0) {
                return true;
            }

        }
        return false;
    }


}
