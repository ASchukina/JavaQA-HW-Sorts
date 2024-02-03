package ru.netology.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

public class AviaSoulsTest {
    AviaSouls sales = new AviaSouls();

    Ticket ticket1 = new Ticket("Moscow", "St. Petersburg", 15_000, 8, 10);
    Ticket ticket2 = new Ticket("St. Petersburg", "Moscow", 13_000, 11, 13);
    Ticket ticket3 = new Ticket("Moscow", "Krasnodar", 3_500, 6, 10);
    Ticket ticket4 = new Ticket("Moscow", "St. Petersburg", 5_000, 16, 21);
    Ticket ticket5 = new Ticket("Moscow", "St. Petersburg", 7_000, 14, 17);
    Ticket ticket6 = new Ticket("Moscow", "Oryol", 7_000, 14, 18);

    // Тест метода compareTo

    @Test
    public void whenTicketPriceBigger() {

        sales.add(ticket1);
        sales.add(ticket2);
        sales.add(ticket3);
        sales.add(ticket4);
        sales.add(ticket5);
        sales.add(ticket6);

        int expected = 1;
        int actual = ticket1.compareTo(ticket2);

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void whenTicketPriceLess() {

        sales.add(ticket1);
        sales.add(ticket2);
        sales.add(ticket3);
        sales.add(ticket4);
        sales.add(ticket5);
        sales.add(ticket6);

        int expected = -1;
        int actual = ticket3.compareTo(ticket2);

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void whenTicketPriceEqually() {

        sales.add(ticket1);
        sales.add(ticket2);
        sales.add(ticket3);
        sales.add(ticket4);
        sales.add(ticket5);
        sales.add(ticket6);

        int expected = 0;
        int actual = ticket5.compareTo(ticket6);

        Assertions.assertEquals(expected, actual);

    }

    // тест сортировки

    @Test
    public void searchByPrice() {

        sales.add(ticket1);
        sales.add(ticket2);
        sales.add(ticket3);
        sales.add(ticket4);
        sales.add(ticket5);
        sales.add(ticket6);

        Ticket[] expected = {ticket4, ticket5, ticket1};
        Ticket[] actual = sales.search("Moscow","St. Petersburg");

        Assertions.assertArrayEquals(expected, actual);
    }

    // тестирование компаратора сравнения цены по времени полёта

    @Test
    public void ticketTimeComparatorTest() {

        Comparator<Ticket> comparator = new TicketTimeComparator();

        sales.add(ticket1);
        sales.add(ticket2);
        sales.add(ticket3);
        sales.add(ticket4);
        sales.add(ticket5);
        sales.add(ticket6);

        Ticket[] expected = {ticket1, ticket5, ticket4};
        Ticket[] actual = sales.searchAndSortBy("Moscow","St. Petersburg", comparator);

        Assertions.assertArrayEquals(expected, actual);

    }

    // проверка с пустым массивом

    @Test
    public void shouldNotSearchTicket() {

        sales.add(ticket1);
        sales.add(ticket2);
        sales.add(ticket3);
        sales.add(ticket4);
        sales.add(ticket5);
        sales.add(ticket6);

        Ticket[] expected = {};
        Ticket[] actual = sales.search("Oryol", "Moscow");

        Assertions.assertArrayEquals(expected, actual);

    }

    // проверка на поиск конкретного билета

    @Test
    public void shouldFindNeededTicket() {

        sales.add(ticket1);
        sales.add(ticket2);
        sales.add(ticket3);
        sales.add(ticket4);
        sales.add(ticket5);
        sales.add(ticket6);

        Ticket[] expected = {ticket3};
        Ticket[] actual = sales.search("Moscow", "Krasnodar");

        Assertions.assertArrayEquals(expected, actual);
    }
}