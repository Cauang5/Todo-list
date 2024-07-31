package com.todo_list.Desafio.Todo.entity.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum Status {

    PENDENTE(1),
    ANALISE(2),
    COMPLETADO(3);

    @Getter
    private int valor;

    public static Status fromValor(int valor) {
        for (Status status : Status.values()) {
            if (status.getValor() == valor) {
                return status;
            }
        }
        throw new IllegalArgumentException("Valor inválido");
    }
}
