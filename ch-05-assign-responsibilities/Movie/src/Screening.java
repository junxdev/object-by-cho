import java.time.LocalDateTime;

public class Screening {
    // 책임을 수행하는 데 필요한 인스턴스 변수
    private Movie movie;
    private int sequence;
    private LocalDateTime whenScreened;

    public int getSequence() {
        return sequence;
    }

    public LocalDateTime getWhenScreened() {
        return whenScreened;
    }

    // 어떤 고객이 몇 명을 예매하라라는 메시지에 응답하는 메서드
    public Reservation reserve(Customer customer, int audienceCount) {
        return new Reservation(customer, this, calculateFee(audienceCount), audienceCount);
    }

    // 가격을 계산하라 메시지를 전송
    private Money calculateFee(int audienceCount) {
        // Movie에 대한 사전 지식이 없이 메시지 결정
        return movie.calculateMovieFee(this).times(audienceCount);
    }
}
