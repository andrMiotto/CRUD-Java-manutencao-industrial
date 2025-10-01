package org.example.dao;

import org.example.model.Material;
import org.example.util.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MaterialDao {


    public Material cadastrarMateriais(Material material) throws SQLException {

        String query = "INSERT INTO Material nome, unidade, estoque VALUES (?,?,?);";

        try (Connection connection = Conexao.conectar();
             PreparedStatement stmt = connection.prepareStatement(query)) {

            stmt.setString(1, material.getNome());
            stmt.setString(2, material.getUnidade());
            stmt.setDouble(3, material.getEstoque());

            stmt.executeUpdate();


        }
        return material;

    }

    public boolean verificarDuplicidadeMaterial(Material material) throws SQLException {
        String query = "SELECT COUNT(0) AS linhas FROM Material WHERE nome = ?;";

        try (Connection connection = Conexao.conectar();
             PreparedStatement stmt = connection.prepareStatement(query)) {

            stmt.setString(1, material.getNome());

            ResultSet rs = stmt.executeQuery();

            if (rs.next() && rs.getInt("linhas") > 0) {
                return true;
            }

        }
        return false;

    }
}
