import java.time.LocalDateTime;

public class Screening {
    // 외부의 간섭, 개입을 최소화하고 필요한 것만 요청받도록 접근 제어
    // 일반적으로 상태는 숨기고 행동만 공개 
    private Movie movie;
    private int sequence;
    private LocalDateTime whenScreened;

    // Implementation 시작
    private Money calculateFee(int audienceCount) {
        // Movie의 calculateMovieFee의 존재를 알 수 없음. 단지 메시지에 응답할 것을 기대하고 메시지 전송 = 협력
        // Movie는 메시지를 수신하고 임의의 메서드로 메시지를 처리
        return movie.calculateMovieFee(this).times(audienceCount);
    }
    // Implementation 끝

    // Public interface 시작
    // 클래스 작성자는 외부에 끼치는 영향을 걱정하지 않고 내부 구현 변경
    // 클라이언트 프로그래머는 인터페이스만 알면 되므로 간편
    // 변경의 용이함을 위한 설계
    public Screening(Movie movie, int sequence, LocalDateTime whenScreened) {
        this.movie = movie;
        this.sequence = sequence;
        this.whenScreened = whenScreened;
    }

    public Reservation reserve(Customer customer, int audienceCount) {
        return new Reservation(customer, this, calculateFee(audienceCount), audienceCount);
    }
    
    public LocalDateTime getStartTime() {
        return whenScreened;
    }
    
    public boolean isSequence(int sequence) {
        return this.sequence == sequence;
    }
    
    public Money getMovieFee() {
        return movie.getFee();
    }
    // Public interface 끝
}
