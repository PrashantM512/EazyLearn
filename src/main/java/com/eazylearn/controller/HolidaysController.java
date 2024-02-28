package com.eazylearn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.eazylearn.model.Holiday;
import com.eazylearn.repository.HolidaysRepository;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Controller
public class HolidaysController {
	
	@Autowired
    private HolidaysRepository holidaysRepository;

    @GetMapping("/holidays")
    public String displayHolidays(Model model) {
    	Iterable<Holiday> holidays = holidaysRepository.findAll();
        List<Holiday> holidayList = StreamSupport
                .stream(holidays.spliterator(), false)
                .collect(Collectors.toList());
        Holiday.Type[] types = Holiday.Type.values();
        for (Holiday.Type type : types) {
            model.addAttribute(type.toString(),
                    (holidayList.stream()
                            .filter(holiday -> type.name().equals(holiday.getType().name())) // Compare enum name instead of value
                            .collect(Collectors.toList())));
        }

         return "holidays.html";
    }
}
