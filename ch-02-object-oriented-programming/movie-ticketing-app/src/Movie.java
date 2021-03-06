import java.time.Duration;

public class Movie {
    private String title;
    private Duration runningTime;
    private Money fee;
    private DiscountPolicy discountPolicy;

    // 실행 시점에는 DiscountPolicy를 구현한 클래스의 인스턴스에 의존
    // >> 클래스 사이의 의존성과 객체 사이의 의존성은 동일하지 않을 수 있음
    // >> 코드가 유연해지고 확장 가능하지만 직관적으로 이해하기 어려움 = Trade-off 발생
    public Movie(String title, Duration runningTime, Money fee, DiscountPolicy discountPolicy) {
        this.title = title;
        this.runningTime = runningTime;
        this.fee = fee;
        // 자식 클래스가 부모 클래스를 대신하는 Upcasting 발생
        this.discountPolicy = discountPolicy;
    }

    public Money getFee() {
        return fee;
    }

    public Money calculateMovieFee(Screening screening) {
        // Movie 클래스에서 책임을 맡아 처리하므로 협력이 일관적이지 않음
        // 책임의 위치를 결정하기 위해 조건문을 사용하는 것은 대부분 좋지 않은 선택
        // if (discountPolicy == null) {
        //     return fee;
        // }
        
        // DiscountPolicy의 인터페이스에 정의된 calculateDiscountAmount 메시지를 전송
        // 협력하는 객체가 어떤 클래스의 인스턴스인지는 중요하지 않음
        // 인스턴스가 해당 메시지를 처리할 수만 있으면 상관 없음
        // 여기서 메시지는 할인 정책이 있으면 할인 금액을 계산해달라는 메시지
        // 메서드는 AmountDiscountPolicy의 메서드가 될 수도 있음 = 메서드는 실행 시 수신하는 클래스에 따라 달라짐 = 다형성
        // 메시지와 메서드를 실행 시점에 바인딩 = 지연 바인딩(Lazy binding) 또는 동적 바인딩(Dynamic binding)
        // 컴파일 시점에 결정 = 초기 바인딩(Early binding) 또는 정적 바인딩(Static binding)
        return fee.minus(discountPolicy.calculateDiscountAmount(screening));
    }

    // 합성을 하면 메시지만 알기 때문에 인터페이스와 약하게 결합
    // >> 구현을 효과적으로 캡슐화
    // >> 의존성이 낮기 때문에 유연한 설계
    public void changeDiscountPolicy(DiscountPolicy discountPolicy) {
        this.discountPolicy = discountPolicy;
    }

    // 코드를 재사용하는 경우 합성, 다형성을 위해 인터페이스를 재사용하는 경우 상속과 합성을 조합
}
