import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TicketOffice {
    private Long amount;
    private List<Ticket> tickets = new ArrayList<>();
    
    public TicketOffice(Long amount, Ticket ... tickets) {
        this.amount = amount;
        this.tickets.addAll(Arrays.asList(tickets));
    }

    // TicketOffice의 자율성이 높아졌으나 Audience에 대한 의존성이 추가 = Trade-off 상황에서 선택 필요
    // Audience에 대한 결합도를 낮추는 방향으로 선택할 수 있음!
    public void sellTicketTo(Audience audience) {
        plusAmount(audience.buy(getTicket()));
    }

    // public Ticket getTicket() {
    private Ticket getTicket() {
        return tickets.remove(0);
    }

    public void minusAmount(Long amount) {
        this.amount -= amount;
    }

    // public void plusAmount(Long amount) {
    private void plusAmount(Long amount) {
        this.amount += amount;
    }
}
