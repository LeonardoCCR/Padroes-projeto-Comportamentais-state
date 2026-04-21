package org.example;

public class PedidoEstadoCancelado extends PedidoEstado {

    private static PedidoEstadoCancelado instance = new PedidoEstadoCancelado();

    private PedidoEstadoCancelado() {
    }

    public static PedidoEstadoCancelado getInstance() {
        return instance;
    }

    @Override
    public String getEstado() {
        return "Cancelado";
    }
}
