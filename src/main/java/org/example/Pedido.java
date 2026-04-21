package org.example;

public class Pedido {

    private String numero;
    private PedidoEstado estado;

    public Pedido() {
        this.estado = PedidoEstadoCriado.getInstance();
    }

    public boolean pagar() {
        return estado.pagar(this);
    }

    public boolean enviar() {
        return estado.enviar(this);
    }

    public boolean entregar() {
        return estado.entregar(this);
    }

    public boolean cancelar() {
        return estado.cancelar(this);
    }

    public PedidoEstado getEstado() {
        return estado;
    }

    public void setEstado(PedidoEstado estado) {
        this.estado = estado;
    }

    public String getNomeEstado() {
        return estado.getEstado();
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }
}
