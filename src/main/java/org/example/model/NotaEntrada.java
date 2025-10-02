package org.example.model;

import java.time.LocalDate;
import java.util.Date;

public class NotaEntrada {

    private int id;
    private int idFornecedor;
    private LocalDate dataEntrada;

    public NotaEntrada(int idFornecedor, Date dataEntrada) {
        this.idFornecedor = idFornecedor;
        this.dataEntrada = LocalDate.now();;
    }


    public NotaEntrada(int id, int idFornecedor, Date dataEntrada) {
        this.id = id;
        this.idFornecedor = idFornecedor;
        this.dataEntrada = LocalDate.now();;
    }

    public NotaEntrada(int idFornecedor) {
        this.idFornecedor = idFornecedor;
        this.dataEntrada = LocalDate.now();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdFornecedor() {
        return idFornecedor;
    }

    public void setIdFornecedor(int idFornecedor) {
        this.idFornecedor = idFornecedor;
    }

    public LocalDate getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(LocalDate dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

}
