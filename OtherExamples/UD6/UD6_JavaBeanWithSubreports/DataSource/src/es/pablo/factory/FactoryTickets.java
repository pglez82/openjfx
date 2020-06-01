package es.pablo.factory;

import es.pablo.models.Pedido;
import es.pablo.models.Ticket;

import java.util.ArrayList;
import java.util.List;

public class FactoryTickets
{
    public static List<Ticket> createListTickets()
    {
        List<Ticket> listTickets = new ArrayList<>();
        List<Pedido> listPedidosTicket1 = new ArrayList<>();
        listPedidosTicket1.add(new Pedido("Cachopo",2,20.0));
        listPedidosTicket1.add(new Pedido("Cocacola",1,3.0));
        listTickets.add(new Ticket(1,listPedidosTicket1));
        List<Pedido> listPedidosTicket2 = new ArrayList<>();
        listPedidosTicket2.add(new Pedido("Sopa",2,14.0));
        listPedidosTicket2.add(new Pedido("Caña",2,4.0));
        listTickets.add(new Ticket(2,listPedidosTicket2));
        return listTickets;
    }
}
