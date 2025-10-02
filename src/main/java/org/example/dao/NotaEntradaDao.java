package org.example.dao;

import org.example.model.NotaEntrada;
import org.example.util.Conexao;

import java.sql.*;
import java.time.LocalDate;

public class NotaEntradaDao {

    public void inserirNota(NotaEntrada nota) throws SQLException {
        String query = "INSERT INTO NotaEntrada (idFornecedor, dataEntrada) VALUES (?,?);";

        try (Connection connection = Conexao.conectar();
             PreparedStatement stmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setInt(1, nota.getIdFornecedor());
            stmt.setDate(2, java.sql.Date.valueOf(nota.getDataEntrada()));

            try {
                stmt.executeUpdate();
                ResultSet rs = stmt.getGeneratedKeys();

                if (rs.next()) {
                    nota.setId(rs.getInt(1));
                }
            } catch (SQLException e) {
                e.printStackTrace();
                throw e;
            }

        }

    }




    public void atualizarEstoque(int idMaterial, double quantidade) throws SQLException {
        String query = "UPDATE Material SET estoque = estoque + ? WHERE id = ?;";

        try (Connection connection = Conexao.conectar();
             PreparedStatement stmt = connection.prepareStatement(query)) {

            stmt.setDouble(1, quantidade);
            stmt.setInt(2, idMaterial);

            stmt.executeUpdate();
        }
    }


}
