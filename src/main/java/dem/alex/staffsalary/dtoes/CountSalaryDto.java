package dem.alex.staffsalary.dtoes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CountSalaryDto {
    private long userId;
    private String month;
    private int absenceDayCount;
    private int overworkDayCount;
}
