package org.example;

public class PedidoEstadoPago extends PedidoEstado {

    private static PedidoEstadoPago instance = new PedidoEstadoPago();

    private PedidoEstadoPago() {
    }

    public static PedidoEstadoPago getInstance() {
        return instance;
    }
    @Override
    public String getEstado() {
        return "Pago";
    }

    @Override
    public boolean enviar(Pedido pedido) {
        pedido.setEstado(PedidoEstadoEnviado.getInstance());
        return true;
    }

    @Override
    public boolean cancelar(Pedido pedido) {
        pedido.setEstado(PedidoEstadoCancelado.getInstance());
        return true;
    }
}
