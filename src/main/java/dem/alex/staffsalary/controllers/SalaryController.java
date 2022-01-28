package dem.alex.staffsalary.controllers;

import dem.alex.staffsalary.dtoes.CountSalaryDto;
import dem.alex.staffsalary.models.UserSalary;
import dem.alex.staffsalary.services.SalaryService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/salary",produces = "application/json")
@AllArgsConstructor
public class SalaryController {

    private SalaryService salaryService;

    @PostMapping
    public UserSalary contSalary(@RequestBody CountSalaryDto countSalaryDto){
        return salaryService.countSalary(countSalaryDto);
    }

    @GetMapping("{userId}/{month}")
    public UserSalary findSalaryByUserIdAndMonth(@PathVariable("userId") Long userId, @PathVariable("month") String month){
        return salaryService.findSalaryByUserIdAndMonth(userId, month);
    }
}
