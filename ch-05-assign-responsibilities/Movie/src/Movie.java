import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public abstract class Movie {
// public class Movie {
    private String title;
    private Duration runningTime;
    private Money fee;
    private List<DiscountCondition> discountConditions;
    // private List<PeriodCondition> periodConditions;
    // private List<SequenceCondition> sequenceConditions;

    // private MovieType movietype;
    // private Money discountAmount;
    // private double discountPercent;

    public Movie(String title, Duration runningTime, Money fee, DiscountCondition... discountConditions) {
        this.title = title;
        this.runningTime = runningTime;
        this.fee = fee;
        this.discountConditions = Arrays.asList(discountConditions);
    }

    // 응답하는 메서드 구현
    public Money calculateMovieFee(Screening screening) {
        if(isDiscountable(screening)) {
            return fee.minus(calculateDiscountAmount());
        }

        return fee;
    };

    private boolean isDiscountable(Screening screening) {
        // return checkPeriodConditions(screening) || checkSequenceConditions(screening);
        return discountConditions.stream()
            .anyMatch(condition -> condition.isSatisfiedBy(screening));
    }

    // private boolean checkPeriodConditions(Screening screening) {
    //     return periodConditions.stream()
    //             .anyMatch(condition -> condition.isSatisfiedBy(screening));
    // }

    // private boolean checkSequenceConditions(Screening screening) {
    //     return sequenceConditions.stream()
    //             .anyMatch(condition -> condition.isSatisfiedBy(screening));
    // }

    abstract protected Money calculateDiscountAmount();
        // switch(movietype) {
        //     case AMOUNT_DISCOUNT:
        //         return calculateAmountDiscountAmount();
        //     case PERCENT_DISCOUNT:
        //         return calculatePercentDiscountAmount();
        //     case NONE_DISCOUNT:
        //         return calculateNoneDiscountAmount();
        // }

        // throw new IllegalArgumentException();

    // private Money calculateAmountDiscountAmount() {
    //     return discountAmount;
    // }

    // private Money calculatePercentDiscountAmount() {
    //     return fee.times(discountPercent);
    // }

    protected Money getFee() {
        return fee;
    }

    private Money calculateNoneDiscountAmount() {
        return Money.ZERO;
    }
}