package org.example.dao;

import org.example.model.NotaEntrada;
import org.example.model.NotaEntradaItem;
import org.example.util.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EntradaItemDao {

    public NotaEntradaItem inserirItemNota(NotaEntradaItem notaEntradaItem) throws SQLException {
        String query = "INSERT INTO NotaEntradaItem (idNotaEntrada, idMaterial,quantidade)VALUES (?,?,?);";

        try (Connection connection = Conexao.conectar();
             PreparedStatement stmt = connection.prepareStatement(query)) {

            stmt.setInt(1, notaEntradaItem.getIdNotaEntrada());
            stmt.setInt(2, notaEntradaItem.getIdMaterial());
            stmt.setDouble(3, notaEntradaItem.getQuantidade());

            stmt.executeUpdate();

        }
        return notaEntradaItem;
    }
}
