package com.whatsup.bot.service.agenda;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.springframework.stereotype.Component;

@Component
public class BusinessDaysCalculator {

    public static List<String> getNextBusinessDays() {
        List<String> businessDays = new ArrayList<>();
        LocalDate date = LocalDate.now(); // Fecha actual
        int count = 0;

        while (count < 5) {
            date = date.plusDays(1); // Avanza al siguiente día
            DayOfWeek dayOfWeek = date.getDayOfWeek();

            // Excluye sábados y domingos
            if (dayOfWeek != DayOfWeek.SATURDAY && dayOfWeek != DayOfWeek.SUNDAY) {
                String dayName = dayOfWeek.getDisplayName(TextStyle.FULL, Locale.getDefault());
                String formattedDate = String.format("%s %d %s", 
                        capitalize(dayName), 
                        date.getDayOfMonth(), 
                        date.getMonth().getDisplayName(TextStyle.FULL, Locale.getDefault()));

                businessDays.add(formattedDate);
                count++;
            }
        }

        return businessDays;
    }

    // Capitaliza la primera letra del texto (opcional, para mejorar presentación)
    private static String capitalize(String text) {
        if (text == null || text.isEmpty()) return text;
        return text.substring(0, 1).toUpperCase() + text.substring(1).toLowerCase();
    }

    public static void main(String[] args) {
        List<String> nextBusinessDays = getNextBusinessDays();
        nextBusinessDays.forEach(System.out::println);
    }
}
