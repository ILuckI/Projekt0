package com.project0.ProjektGrupowy.service;

import org.springframework.stereotype.Service;

@Service
public class DateService {

    public int countDays(String startDate, String endDate) {

//        Zamiana Stringa na wartości liczbowe z podziałem na dni, miesiące i lata
        int startYear = Integer.parseInt(startDate.substring(0,4));
        int startMonth = Integer.parseInt(startDate.substring(5, 7));
        int startDay = Integer.parseInt(startDate.substring(8,10));

        int endYear = Integer.parseInt(endDate.substring(0,4));
        int endMonth = Integer.parseInt(endDate.substring(5, 7));
        int endDay = Integer.parseInt(endDate.substring(8,10));

        int days = 1;

//        Sprawdzenie pełnych lat między dwoma datami
        for (int year = startYear + 1; year < endYear; year++) {
            days += isLeap(year) ? 366 : 365;
        }

//        Tablica z liczbą dni w danym miesiącu
        int monthsLengthness[] = {0, 31, 28, 31, 30, 31, 30, 31,
                31, 30, 31, 30, 31};

//        Wyznaczenie liczby dni między dwoma datami
        if (startYear == endYear) {
            if (startMonth == endMonth) {
                days += endDay - startDay;
            } else {
                for (int month = startMonth + 1; month < endMonth; month++) {
                    days += (month == 2 && isLeap(startYear)) ?
                            monthsLengthness[month] + 1 :
                            monthsLengthness[month];
                }
                days += endDay;
                days += monthsLengthness[startMonth] - startDay;
            }
        } else {
            for (int month = startMonth + 1; month <= 12; month++) {
                days += (month == 2 && isLeap(startYear)) ?
                        monthsLengthness[month] + 1 :
                        monthsLengthness[month];
            }

            days += monthsLengthness[startMonth] - startDay;

            for (int month = 1; month < endMonth; month++) {
                days += (month == 2 && isLeap(endYear)) ?
                        monthsLengthness[month] + 1 :
                        monthsLengthness[month];
            }

            days += endDay;
        }

//        Przekazanie ostatecznego wyniku
        return days;
    }

//    Metoda sprawdzająca czy wybrany rok jest rokiem przestępnym
    private boolean isLeap(int year) {
        return ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0));
    }
}

