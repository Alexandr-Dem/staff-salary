package dem.alex.staffsalary.models;

import com.fasterxml.jackson.annotation.JsonValue;

public enum MonthEnum {
    JANUARY(15, "Январь"),
    FEBRUARY(19, "Февраль"),
    MARCH(22, "Март"),
    APRIL(22, "Апрель"),
    MAY(19, "Май"),
    JUNE(21, "Июнь"),
    JULY(22, "Июль"),
    AUGUST(22, "Август"),
    SEPTEMBER(22, "Сентябрь"),
    OCTOBER(21, "Октябрь"),
    NOVEMBER(20, "Ноябрь"),
    DECEMBER(22, "Декабрь");
    private final int workedDaysCount;
    @JsonValue
    private final String rusName;

    MonthEnum(final int workedDaysCount, final String rusName) {
        this.workedDaysCount = workedDaysCount;
        this.rusName = rusName;
    }

    public int getWorkedDaysCount() {
        return workedDaysCount;
    }

    public String getRusName() {
        return rusName;
    }
}
