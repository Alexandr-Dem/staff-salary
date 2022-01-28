package dem.alex.staffsalary.models;


import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of ={"userId", "month"})
public class UserSalary {

    private long userId;
    private MonthEnum month;
    private int salary;
    private int premium;
    private int resultSalary;

    public UserSalary(final long userId, final MonthEnum month, final int salary, final int premium, final int resultSalary) {
        this.userId = userId;
        this.month = month;
        this.salary = salary;
        this.premium = premium;
        this.resultSalary = resultSalary;
    }

}