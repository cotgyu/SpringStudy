package net.study.baseMybatis.travel.web;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import net.study.baseMybatis.travel.service.TravelService;

@RequestMapping(value="/travel")
public class TravelController {

	private final Log log = LogFactory.getLog(this.getClass());
	
	@Autowired
	private TravelService travelService;
	
	
}
