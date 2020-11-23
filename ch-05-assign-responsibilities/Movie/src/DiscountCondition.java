// import java.time.DayOfWeek;
// import java.time.LocalTime;

// 공유할 내부 구현이 없으므로 인터페이스로
public interface DiscountCondition {
    boolean isSatisfiedBy(Screening screening);
}

// public class DiscountCondition {
//     // 인터페이스를 위한 내부 구현
//     private DiscountConditionType type;
//     private int sequence;
//     private DayOfWeek dayOfWeek;
//     private LocalTime startTime;
//     private LocalTime endTime;

//     // 순번 조건에 따라 변경
//     private boolean isSatisfiedBySequence(Screening screening) {
//         return sequence == screening.getSequence();
//     }

//     // 기간 조건에 따라 변경
//     private boolean isSatisfiedByPeriod(Screening screening) {
//         return dayOfWeek.equals(screening.getWhenScreened().getDayOfWeek()) &&
//             startTime.compareTo(screening.getWhenScreened().toLocalTime()) <= 0 &&
//             endTime.compareTo(screening.getWhenScreened().toLocalTime()) >= 0;
//     }
//     // 변경 사유가 다른 것은 응집도가 낮다는 것

//     // 응답 메서드
//     // 조건 개수 변경에 따라 조건문 변경
//     public boolean isSatisfiedBy(Screening screening) {
//         if(type == DiscountConditionType.PERIOD) {
//             return isSatisfiedByPeriod(screening);
//         }

//         return isSatisfiedBySequence(screening);
//     }
// }
