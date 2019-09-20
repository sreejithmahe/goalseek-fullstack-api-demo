package com.goalseek.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.goalseek.dao.GoalSeekInDao;
import com.goalseek.dao.GoalSeekOutDao;

/**
 * @author sreejith.kizhakkayil
 *
 */
@Service
public class GoalseekService {
	@Autowired
	private ProduceLoopCheck produceLoopCheck;
	@Autowired
	private ProduceResult produceResult;
	private List<GoalSeekOutDao> goalseekList = new ArrayList<GoalSeekOutDao>();
	public List<GoalSeekOutDao> getGoalseek(GoalSeekInDao gs) {
        double OP1 = gs.getOpeningBalance();
        double NP  = gs.getTotalNoPeriod();
        double ExpCB = gs.getExpectedClosingBalance();
        double Guess = OP1/NP;
        double FinalCB = 0.0;
        boolean flag = false;
        FinalCB = produceLoopCheck.M1(OP1,Guess,ExpCB,NP);
    	if (ExpCB < FinalCB) {
    		flag = true; 
    	} else 	{
    		flag = false;
    	}
        for (int i = 1 ; i < 100000 ; i++) {
        	if(flag) {
		          Guess = Guess+0.1;
				  FinalCB = produceLoopCheck.M1(OP1,Guess,ExpCB,NP);
				  		if(ExpCB >= Math.round(FinalCB)) {
				  			break;
				  		}  
	            } else {
  		       Guess = Guess-0.1;
			       FinalCB = produceLoopCheck.M1(OP1,Guess,ExpCB,NP);
                       if(ExpCB <= Math.round(FinalCB)) {
	                         break;
                     }
              }
		 }
	 return produceResult.M1(OP1,Guess,ExpCB,NP);
	}
	public void updateGoalseek(GoalSeekOutDao gs) {
		}

	public List<GoalSeekOutDao> getResult(GoalSeekOutDao gs) {
		return goalseekList;
	}
}
