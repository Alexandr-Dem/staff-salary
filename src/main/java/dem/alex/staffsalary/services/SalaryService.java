package dem.alex.staffsalary.services;

import dem.alex.staffsalary.dtoes.CountSalaryDto;
import dem.alex.staffsalary.models.UserSalary;
import dem.alex.staffsalary.models.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SalaryService {

    private final UserService userService;

    private static final int DAYS_IN_MONTH = 22;
    private static final int ALLOWABLE_NUMBER_OF_PASSES = 1;
    private final Map<Long, List<UserSalary>> salariesByUserIdCache = new HashMap<>();


    public SalaryService(final UserService userService) {
        this.userService = userService;
    }

    public UserSalary findSalaryByUserIdAndMonth(Long userId, String month) {
        return salariesByUserIdCache.getOrDefault(userId, Collections.emptyList())
                .stream().filter(us -> us.getMonth().equals(month))
                .findAny().orElse(null);
    }

    public UserSalary countSalary(CountSalaryDto dto){
        final User user = userService.getUserById(dto.getUserId());
        int salary = user.getSalary();
        int salaryForDay = salary / DAYS_IN_MONTH;
        int resultSalary = salary;
        int premium = 0;
        //вычитаем из зп оплату за дни пропусков
        for (int i = 0; i < dto.getAbsenceDayCount(); i++) {
            resultSalary= resultSalary - salaryForDay;
        }
        //прибавляем к зп оплату за дни в РВД
        for (int i = 0; i < dto.getOverworkDayCount(); i++){
            resultSalary = resultSalary + salaryForDay * 2;
        }
        //Прибавляем премию, если не превышено допустимое количество пропусков
        if (dto.getAbsenceDayCount() <=  ALLOWABLE_NUMBER_OF_PASSES) {
            premium = salary * user.getPremiumPercent() / 100;
            resultSalary = resultSalary + premium;
        }
        UserSalary userSalary = new UserSalary(
                user.getId(),
                dto.getMonth(),
                salary,
                premium,
                resultSalary
        );
        saveUserSalary(userSalary);
        return userSalary;
    }

    private void saveUserSalary(UserSalary userSalary) {
        List<UserSalary> salaries = salariesByUserIdCache.get(userSalary.getUserId());
        if (salaries == null) {
            salaries = new ArrayList<>();
            salariesByUserIdCache.put(userSalary.getUserId(), salaries);
        } else {
            //удаляем подсчитанную ранее зп из кэша, если она там есть
            salaries.removeIf(s -> s.equals(userSalary));
        }
        salaries.add(userSalary);
    }

}
