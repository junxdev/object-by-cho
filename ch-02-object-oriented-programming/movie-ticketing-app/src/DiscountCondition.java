// 구현은 공유할 필요가 없고 순수하게 인터페이스만 공유하고 싶을 때 사용
public interface DiscountCondition {
    boolean isSatisfiedBy(Screening screening);
}
