public class Audience {
    private Bag bag;

    public Audience(Bag bag) {
        this.bag = bag;
    }

    // >> 외부에서 접근할 필요가 없으므로 제거
    // public Bag getBag() {
    //     return bag;
    // }

    // >> buy 요청을 받으면 스스로 가방 안에 초대장이 있는지 확인함
    // >> 따라서 외부에서는 Audience 내부의 Bag 클래스를 알 필요 없음
	public Long buy(Ticket ticket) {
        // if (bag.hasInvitation()) {
        //     bag.setTicket(ticket);
        //     return 0L;
        // } else {
        //     bag.setTicket(ticket);
        //     bag.minusAmount(ticket.getFee());
        //     return ticket.getFee();
        // }
        return bag.hold(ticket);
	}
}
