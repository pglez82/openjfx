package es.pablo.models;

import java.util.List;

public class Ticket {
    private Integer numTicket;
    private List<Pedido> listPedidos;

    public Ticket(Integer numTicket, List<Pedido> listPedidos) {
        this.numTicket = numTicket;
        this.listPedidos = listPedidos;
    }

    public Integer getNumTicket() {
        return numTicket;
    }

    public List<Pedido> getListPedidos() {
        return listPedidos;
    }
}
