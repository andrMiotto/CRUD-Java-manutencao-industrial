package org.example.model;

import javax.xml.crypto.Data;

public class Requisicao {

    private int id;
    private String setor;
    private Data dataSolicitacao;
    private Status status;

    public Requisicao(String setor, Data dataSolicitacao, Status status) {
        this.setor = setor;
        this.dataSolicitacao = dataSolicitacao;
        this.status = status;
    }

    public Requisicao(int id, String setor, Data dataSolicitacao, Status status) {
        this.id = id;
        this.setor = setor;
        this.dataSolicitacao = dataSolicitacao;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public Data getDataSolicitacao() {
        return dataSolicitacao;
    }

    public void setDataSolicitacao(Data dataSolicitacao) {
        this.dataSolicitacao = dataSolicitacao;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
