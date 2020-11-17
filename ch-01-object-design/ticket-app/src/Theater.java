public class Theater {
    private TicketSeller ticketSeller;

    public Theater(TicketSeller ticketSeller) {
        this.ticketSeller = ticketSeller;
    }

    // 1. 작동하지만
    // 2. 한 코드 안에 너무 많은 사실이 포함되어 있고
    // 3. 의존성이 높아 코드가 구체적이기 때문에 다른 클래스의 변경에 취약함 
    // >> 클래스를 자율적인 존재로 변경

    // 4. 클래스들은 결국 데이터만 전달하는 클래스로 데이터의 역할만 수행 = 결국 enter라는 프로세스에서 전부 처리하는 절차적 프로그래밍
    // >> 프로세스가 사용하는 데이터를 소유한 클래스 내부로 옮겨짐(책임의 이동) = 객체지향 프로그래밍
    public void enter(Audience audience) {
        // >> TicketSeller 클래스 내부의 sellTo 메서드로 숨김
        // if (audience.getBag().hasInvitation()) {
        //     Ticket ticket = ticketSeller.getTicketOffice().getTicket();
        //     audience.getBag().setTicket(ticket);
        // } else {
        //     Ticket ticket = ticketSeller.getTicketOffice().getTicket();
        //     audience.getBag().minusAmount(ticket.getFee());
        //     ticketSeller.getTicketOffice().plusAmount(ticket.getFee());
        //     audience.getBag().setTicket(ticket);
        // }
        // >> ticketSeller의 sellTo 메서드만 인지 = 오직 TicketSeller의 인터페이스에만 의존
        ticketSeller.sellTo(audience);
    }
}
