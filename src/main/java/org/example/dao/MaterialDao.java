package org.example.dao;

import org.example.model.Material;
import org.example.util.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MaterialDao {


    private int id;

    public Material cadastrarMateriais(Material material) throws SQLException {

        String query = "INSERT INTO Material (nome, unidade, estoque) VALUES (?,?,?);";

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

    public List<Material> listarTodos() throws SQLException {
        List<Material> materiais = new ArrayList<>();
        String query = "SELECT id, nome, unidade, estoque FROM Material WHERE estoque > 0";

        try (Connection connection = Conexao.conectar();
             PreparedStatement stmt = connection.prepareStatement(query)) {
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String unidade = rs.getString("unidade");
                Double estoque = rs.getDouble("estoque");

                var material = new Material(id, nome, unidade, estoque);
                materiais.add(material);

            }

        }
        return materiais;
    }


    public boolean verificarExistencia(Material material) throws SQLException {
        String query = "SELECT COUNT(0) AS linhas FROM Material WHERE id = ?;";

        try (Connection connection = Conexao.conectar();
             PreparedStatement stmt = connection.prepareStatement(query)) {

            stmt.setInt(1, material.getId());

            ResultSet rs = stmt.executeQuery();
            if (rs.next() && rs.getInt("linhas") > 0) {
                return true;
            }

            return false;
        }
    }


}
