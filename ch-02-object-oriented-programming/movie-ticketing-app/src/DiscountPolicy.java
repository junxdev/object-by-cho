import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Programming by difference(차이에 의한 프로그래밍): 부모 클래스와 다른 부분만을 추가해 새로운 클래스를 쉽고 빠르게 만드는 방법
// 추상 클래스로 구현하여 자식 클래스들이 인터페이스와 내부 구현을 함께 상속받도록 함
public abstract class DiscountPolicy {
    private List<DiscountCondition> conditions = new ArrayList<>();

    public DiscountPolicy(DiscountCondition ... conditions) {
        this.conditions = Arrays.asList(conditions);
    }

    public Money calculateDiscountAmount(Screening screening) {
        for(DiscountCondition each : conditions) {
            if (each.isSatisfiedBy(screening)) {
                return getDiscountAmount(screening);
            }
        }

        return Money.ZERO;
    }

    // Template Method Pattern
    // 부모 클래스에 기본적인 알고리즘을 구현하고 중간에 필요한 처리를 자식 클래스에 위임
    abstract protected Money getDiscountAmount(Screening screening);
}
