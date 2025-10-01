package org.example.model;

public enum Status {
    PENDENTE ("PENDENTE"),
    ATENDIDA ("ATENDIDA"),
    CANCELADO ("CANCELADO");


    private String status;

    Status(String status){
        this.status=status;
    }

    public String getStatus(){
        return status;
    }

    @Override
    public String toString(){
        return status;
    }

    }