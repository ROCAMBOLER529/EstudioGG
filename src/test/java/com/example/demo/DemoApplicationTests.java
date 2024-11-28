package com.example.demo;

import com.whatsup.bot.service.agenda.BusinessDaysCalculator;
import com.whatsup.bot.service.agenda.DateUtil1;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

//@SpringBootTest
class DemoApplicationTests {
	
	@Test
	void contextLoads() {
	}
	
	
	
	@Test
	void BotTest()
	{
		
		Assertions.assertEquals(1,1);
	}
        
        @Test
	void DiasDeLaSemanaTest()
	{
		
                List<String> days = BusinessDaysCalculator.getNextBusinessDays(5);
		Assertions.assertEquals(5, days.size());
	}
        
                @Test
	void TextoDiasTest()
	{
		
                List<String> days = BusinessDaysCalculator.getNextBusinessDays(1);
		Assertions.assertEquals("20241129", days.get(0));
	}
         @Test
	void TextoDayInLetterTest()
	{
		
                String day = DateUtil1.convertDateToText("20241128");
		Assertions.assertEquals("jueves, 28", day.trim() );
	}
        
        @Test
	void TextoCapitalizeTest()
	{
		

		Assertions.assertEquals("Jueves, 28", BusinessDaysCalculator.capitalize(DateUtil1.convertDateToText("20241128")).trim());
	}
}
