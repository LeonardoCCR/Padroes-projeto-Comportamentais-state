package org.example;

public class PedidoEstadoEnviado extends PedidoEstado {

    private static PedidoEstadoEnviado instance = new PedidoEstadoEnviado();

    private PedidoEstadoEnviado() {
    }

    public static PedidoEstadoEnviado getInstance() {
        return instance;
    }

    @Override
    public String getEstado() {
        return "Enviado";
    }

    @Override
    public boolean entregar(Pedido pedido) {
        pedido.setEstado(PedidoEstadoEntregue.getInstance());
        return true;
    }
}
