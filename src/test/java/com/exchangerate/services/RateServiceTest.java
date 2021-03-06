package com.exchangerate.services;

import java.util.Calendar;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import com.exchangerate.dto.RateDTO;
import com.exchangerate.repositories.RateRepository;

public class RateServiceTest {

	RateService rateService;
	HistoricalInformationService historicalInformationService;
	
	@Mock
	RateRepository rateRepository;
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		rateService = new RateServiceImpl(rateRepository);
		historicalInformationService = new HistoricalInformationServiceImpl(rateRepository);
}
	
	@Test
	public void getRate() throws Exception {
		
		RateDTO rate1 = new RateDTO();
		Calendar calendar = Calendar.getInstance();
		
		rate1.setYear(calendar.get(Calendar.YEAR));
		rate1.setMonth(calendar.get(Calendar.MONTH) + 1);
		rate1.setDay(calendar.get(Calendar.DAY_OF_MONTH));
		
		// given
		when(rateService.getRate("2015-03-03", "EUR", "USD")).thenReturn(rate1);
		
		// when
		RateDTO rateDTO = rateService.getRate("2015-03-03", "EUR", "USD");
		
		// then
		assertEquals(rate1.getYear(), rateDTO.getYear());
		assertEquals(rate1.getMonth(), rateDTO.getMonth());
		assertEquals(rate1.getDay(), rateDTO.getDay());
}
}
