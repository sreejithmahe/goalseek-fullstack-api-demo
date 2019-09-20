package com.goalseek.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.goalseek.dao.GoalSeekInDao;
import com.goalseek.dao.GoalSeekOutDao;
import com.goalseek.service.GoalseekService;
/**
 * @author sreejith.kizhakkayil
 *
 */
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class GoalSeekController {
	
	@Autowired
	private GoalseekService goalseekService;

	@RequestMapping (value ="/goalseek")
     public List<GoalSeekOutDao> goalseek(@RequestBody GoalSeekInDao gs) {
		return goalseekService.getGoalseek(gs);
    }
	@RequestMapping (method=RequestMethod.PUT, value="/goalseek")
	public String updateGoalseek(@RequestBody GoalSeekOutDao gs) {
		return "RequestMethod.PUT";
	}
	@RequestMapping (method=RequestMethod.POST, value="/goalseek")
	public  List<GoalSeekOutDao> addGoalseek(@RequestBody GoalSeekInDao gs) {
		return goalseekService.getGoalseek(gs);
	}
	@RequestMapping (method=RequestMethod.DELETE, value="/goalseek")
	public String delGoalseek() {
		return "RequestMethod.DELETE";
	}
	@RequestMapping(value={"/error"}, method = RequestMethod.GET)
    public ModelAndView login(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("error");
        return modelAndView;
    }
}
