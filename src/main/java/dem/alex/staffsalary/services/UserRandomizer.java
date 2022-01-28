package dem.alex.staffsalary.services;

import dem.alex.staffsalary.models.User;

import java.util.Random;

public class UserRandomizer {
    private String[] names = {"Прокофьев Константин Сергеевич","Щукина Елена Ильинична","Сидорова Маргарита Мирославовна","Румянцев Алексей Ильич","Кузьмина Есения Степановна","Кочетов Егор Даниилович","Макеева Ева Матвеевна","Воронина Есения Александровна","Павловская София Яновна","Гончаров Даниил Львович","Михайлов Сергей Романович","Пономарева Олеся Владимировна","Иванова Ульяна Максимовна","Волкова Мия Ильинична","Максимов Иван Георгиевич","Русаков Николай Артёмович","Трифонова Арина Анатольевна","Журавлева Ксения Арсентьевна","Панфилова Дарья Владимировна","Чернова Анна Даниловна","Комаров Максим Иванович","Морозова Василиса Ивановна","Николаева Любовь Марковна","Кузнецова Ксения Денисовна","Ермакова Кристина Мирославовна","Савельев Никита Саввич","Соловьев Вадим Ильич","Федоров Максим Даниилович","Белов Александр Андреевич","Горбачев Матвей Дмитриевич","Родионов Александр Владиславович","Ситникова Татьяна Матвеевна","Соловьев Константин Александрович","Корчагин Егор Демидович","Андреев Андрей Степанович","Гаврилов Даниил Павлович","Максимова Арина Олеговна","Еремин Фёдор Андреевич","Никифорова Ксения Матвеевна","Юдина Амелия Артемьевна","Васильева Анна Дмитриевна","Трофимов Лев Назарович","Стариков Тимофей Даниилович","Дьяков Руслан Даниилович","Харитонова Камила Михайловна","Борисов Николай Романович","Медведев Иван Миронович","Исаева Арина Егоровна","Беляков Даниил Егорович","Руднев Павел Романович","Кузнецова Василиса Константиновна","Большакова Анна Ивановна","Алексеева Василиса Григорьевна","Васильев Даниил Максимович","Петров Тимур Максимович","Кузнецова Алиса Дмитриевна","Петров Кирилл Ильич","Булгакова Анна Егоровна","Краснова Варвара Ильинична","Лазарев Давид Фёдорович","Гусева Алиса Фёдоровна","Михеева Кира Ильинична","Комарова Ульяна Игоревна","Сергеев Андрей Арсентьевич","Назарова Ева Романовна","Муравьева Елизавета Борисовна","Алексеева Елизавета Алексеевна","Кириллова София Александровна","Мальцев Владислав Янович","Тимофеев Артём Андреевич","Ефимова Екатерина Дмитриевна","Сычева Елизавета Александровна","Иванова Полина Георгиевна","Ушакова Софья Дмитриевна","Грачева Анна Тимуровна","Сухова Арина Александровна","Баранова Ева Ярославовна","Куликова Варвара Максимовна","Фролов Максим Ильич","Терехов Иван Савельевич","Курочкина Анна Саввична","Ефимов Илья Иванович","Кузнецова Диана Сергеевна","Осипова Екатерина Демидовна","Наумов Николай Саввич","Беляев Роман Андреевич","Кошелев Максим Вадимович","Шилова Сафия Григорьевна","Горшков Иван Ильич","Титов Егор Тимофеевич","Львов Лев Максимович","Покровская Василиса Марковна","Козлов Павел Миронович","Павлов Максим Иванович","Кузьмин Михаил Леонидович","Щербакова Софья Максимовна","Волков Василий Робертович","Дмитриев Дмитрий Львович","Горелова Лилия Андреевна","Смирнов Даниил Егорович"};
    private String[] positions = {"Бухгалтер", "Программист", "Юрист", "Экономист", "Менеджер", "Сисадмин"};
    private int[] salaries = {30_000, 40_000, 50_000, 60_000, 70_000, 80_000, 90_000, 100_000};
    private int[] premiums = {5,10,15,20,25,30,35,40,45,50};

    public User getRandomUser(final int id) {
        String name = getRandomName();
        String position = getRandomPosition();
        int salary = getRandomSalary();
        int premium = getRandomPremium();
        return new User(id, name, position, salary,premium);
    }

    private String getRandomName() {
        return names[new Random().nextInt(names.length)];
    }

    private String getRandomPosition() {
        return positions[new Random().nextInt(positions.length)];
    }

    private int getRandomSalary() {
        return salaries[new Random().nextInt(salaries.length)];
    }

    private int getRandomPremium() {
        return premiums[new Random().nextInt(premiums.length)];
    }

}