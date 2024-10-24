package com.example.demo;

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

}
