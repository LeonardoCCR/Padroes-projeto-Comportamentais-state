package org.example;

public class PedidoEstadoCriado extends PedidoEstado {

    private static PedidoEstadoCriado instance = new PedidoEstadoCriado();

    private PedidoEstadoCriado() {
    }

    public static PedidoEstadoCriado getInstance() {
        return instance;
    }

    @Override
    public String getEstado() {
        return "Criado";
    }

    @Override
    public boolean pagar(Pedido pedido) {
        pedido.setEstado(PedidoEstadoPago.getInstance());
        return true;
    }

    @Override
    public boolean cancelar(Pedido pedido) {
        pedido.setEstado(PedidoEstadoCancelado.getInstance());
        return true;
    }


}
