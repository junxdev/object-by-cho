public class TicketSeller {
    private TicketOffice ticketOffice;

    public TicketSeller(TicketOffice ticketOffice) {
        this.ticketOffice = ticketOffice;
    }

    // >> 외부에서 접근할 수 없음
    // >> TicketSeller가 ticketOffice의 메서드를 스스로 수행할 수 밖에 없도록 캡슐화
    // public TicketOffice getTicketOffice() {
    //     return ticketOffice;
    // }

    public void sellTo(Audience audience) {
        // if (audience.getBag().hasInvitation()) {
        //     Ticket ticket = ticketOffice.getTicket();
        //     audience.getBag().setTicket(ticket);
        // } else {
        //     Ticket ticket = ticketOffice.getTicket();
        //     audience.getBag().minusAmount(ticket.getFee());
        //     ticketOffice.plusAmount(ticket.getFee());
        //     audience.getBag().setTicket(ticket);
        // }
        // >> Audience의 인터페이스에만 의존하도록 수정
        // >> 실제 구매에 필요한 변수와 작업은 Audience가 Audience 내부에서
        // >> Bag 클래스가 Wallet 클래스로 변경되어도 무관
        // ticketOffice.plusAmount(audience.buy(ticketOffice.getTicket()));
        ticketOffice.sellTicketTo(audience);
    }
}
