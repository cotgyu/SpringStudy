package net.study.com.travel.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import net.study.com.travel.domain.Travel;
import net.study.com.travel.service.TravelService;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.springframework.beans.factory.annotation.Autowired;

@Controller
@RequestMapping(value="/travel")
public class TravelController {
	
	@Autowired
	private TravelService travelService;
	
	@RequestMapping("/planCreate")
	public ModelAndView planCreate() {
		

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("travel/planCreate");
		return modelAndView;
	}
//	String myKey = "uaggmM92YCI2loPv%2FE1ACToqLNKJA86fQ7W6a0S%2Bw4S6w5AU7eOnwdznpcSxEnGSsq5W%2B3uW9Z%2BJekpTokZbZA%3D%3D";
//	String ServiceKey	= URLEncoder.encode(myKey, "UTF-8");
//	@RequestMapping(value="/getDate", method=RequestMethod.POST)
//	@ResponseBody
//	public Object getDate(@ResponseBody Travel request)  { 
//		
//	}
}
