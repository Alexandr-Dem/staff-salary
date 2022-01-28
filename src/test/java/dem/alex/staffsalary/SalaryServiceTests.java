package dem.alex.staffsalary;

import dem.alex.staffsalary.dtoes.CountSalaryDto;
import dem.alex.staffsalary.models.User;
import dem.alex.staffsalary.models.UserSalary;
import dem.alex.staffsalary.services.SalaryService;
import dem.alex.staffsalary.services.UserService;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class SalaryServiceTests {

	@InjectMocks
	private SalaryService salaryService;

	@Mock
	private UserService userService;

	private final User user = new User(1,"name","position",30_000, 10);;

	@Test
	public void contSalaryTest() {
		when(userService.getUserById(anyLong())).thenReturn(user);
		CountSalaryDto dto = new CountSalaryDto(user.getId(), "match", 1, 2);
		UserSalary userSalary = salaryService.countSalary(dto);
		Assertions.assertEquals(userSalary.getSalary(),30_000);
		Assertions.assertEquals(userSalary.getPremium(),3_000);
		Assertions.assertEquals(userSalary.getResultSalary(),37_089);
	}

	@Test
	public void contSalaryWithoutPremiumTest() {
		when(userService.getUserById(anyLong())).thenReturn(user);
		CountSalaryDto dto = new CountSalaryDto(user.getId(), "match", 2, 0);
		UserSalary userSalary = salaryService.countSalary(dto);
		Assertions.assertEquals(userSalary.getSalary(),30_000);
		Assertions.assertEquals(userSalary.getPremium(),0);
		Assertions.assertEquals(userSalary.getResultSalary(),27_274);
	}

}
