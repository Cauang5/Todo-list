package com.todo_list.Desafio.Todo.entity.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum Status {

    PENDENTE(1, "pendente"),
    ANALISE(2, "analise"),
    COMPLETO(3, "completo");

    @Getter
    private int valor;
    private String descricao;

    public static Status fromValor(int valor, String descricao) {
        for (Status status : Status.values()) {
            if (status.getValor() == valor) {
                return status;
            }
        }
        throw new IllegalArgumentException("Valor inválido");
    }
}
