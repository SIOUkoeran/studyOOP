package Ch01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TicketOffice {
    private Long amount;

    private List<Ticket> tickets = new ArrayList<>();

    public void SellTicketTo(Audience audience){
        plusAmount(audience.buy(getTicket()));
    }
    public TicketOffice(Long amount, Ticket... tickets){
        this.amount = amount;
        this.tickets.addAll(Arrays.asList(tickets));
    }

    private void plusAmount(Long amount){
        this.amount += amount;
    }

    private Ticket getTicket() {
        return tickets.remove(0);
    }
}
