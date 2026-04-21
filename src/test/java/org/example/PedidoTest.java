package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PedidoTest {

    @Test
    void deveIniciarCriado() {
        Pedido pedido = new Pedido();
        assertEquals(PedidoEstadoCriado.getInstance(), pedido.getEstado());
    }
    @Test
    void devePagarPedidoCriado() {
        Pedido pedido = new Pedido();
        assertTrue(pedido.pagar());
        assertEquals(PedidoEstadoPago.getInstance(), pedido.getEstado());
    }
    @Test
    void naoDeveEnviarPedidoCriado() {
        Pedido pedido = new Pedido();
        assertFalse(pedido.enviar());

        assertEquals(PedidoEstadoCriado.getInstance(), pedido.getEstado());
    }

    @Test
    void naoDeveEntregarPedidoCriado() {
        Pedido pedido = new Pedido();

        assertFalse(pedido.entregar());

        assertEquals(PedidoEstadoCriado.getInstance(), pedido.getEstado());
    }

    @Test
    void deveEnviarPedidoPago() {
        Pedido pedido = new Pedido();
        pedido.pagar();

        assertTrue(pedido.enviar());

        assertEquals(PedidoEstadoEnviado.getInstance(), pedido.getEstado());
    }

    @Test
    void naoDeveEntregarPedidoPago() {
        Pedido pedido = new Pedido();
        pedido.pagar();

        assertFalse(pedido.entregar());

        assertEquals(PedidoEstadoPago.getInstance(), pedido.getEstado());
    }

    @Test
    void deveEntregarPedidoEnviado() {
        Pedido pedido = new Pedido();

        pedido.pagar();
        pedido.enviar();

        assertTrue(pedido.entregar());
        assertEquals(PedidoEstadoEntregue.getInstance(), pedido.getEstado());
    }

    @Test
    void deveCancelarPedidoCriado() {
        Pedido pedido = new Pedido();

        assertTrue(pedido.cancelar());
        assertEquals(PedidoEstadoCancelado.getInstance(), pedido.getEstado());
    }

    @Test
    void deveCancelarPedidoPago() {
        Pedido pedido = new Pedido();

        pedido.pagar();

        assertTrue(pedido.cancelar());
        assertEquals(PedidoEstadoCancelado.getInstance(), pedido.getEstado());
    }

    @Test
    void naoDeveCancelarPedidoEntregue() {
        Pedido pedido = new Pedido();

        pedido.pagar();
        pedido.enviar();
        pedido.entregar();

        assertFalse(pedido.cancelar());
        assertEquals(PedidoEstadoEntregue.getInstance(), pedido.getEstado());
    }

    @Test
    void devePercorrerFluxoCompleto() {
        Pedido pedido = new Pedido();

        assertTrue(pedido.pagar());
        assertTrue(pedido.enviar());
        assertTrue(pedido.entregar());

        assertEquals(PedidoEstadoEntregue.getInstance(), pedido.getEstado()
        );
    }
}
