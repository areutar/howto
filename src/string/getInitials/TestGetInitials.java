package string.getInitials;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class TestGetInitials {
    @ParameterizedTest
    @CsvSource(delimiter = '|', value = { "Владимир Семенович Высоцкий|В.С.В.",
            "Гуев Тимур Ахсарбекович|Г.Т.А.",
            "Михаил Иванович Кузнецов|М.И.К." })
    void testGetInitials(String input, String expected) {
        assertEquals(expected, GetInitials.getInitials(input));
    }
}
