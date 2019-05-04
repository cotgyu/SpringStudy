package net.study.com.travel.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import net.study.com.travel.service.TravelService;

import org.springframework.beans.factory.annotation.Autowired;

@Controller
@RequestMapping(value="/travel")
public class TravelController {
	
	@Autowired
	private TravelService travelService;
	
}
