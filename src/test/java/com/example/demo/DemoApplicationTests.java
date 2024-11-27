package com.example.demo;

import com.whatsup.bot.service.agenda.BusinessDaysCalculator;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
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
		
                List<String> days = BusinessDaysCalculator.getNextBusinessDays();
		Assertions.assertEquals(5, days.size());
	}

}
