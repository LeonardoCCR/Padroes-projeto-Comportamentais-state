package org.example;

public class PedidoEstadoEntregue extends PedidoEstado {

    private static PedidoEstadoEntregue instance =new PedidoEstadoEntregue();

    private PedidoEstadoEntregue() {
    }

    public static PedidoEstadoEntregue getInstance() {
        return instance;
    }

    @Override
    public String getEstado() {
        return "Entregue";
    }
}
