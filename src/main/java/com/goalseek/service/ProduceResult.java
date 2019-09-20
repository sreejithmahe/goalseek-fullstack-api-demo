package com.goalseek.service;
import java.util.ArrayList;
import java.util.List;

/**
 * @author sreejith.kizhakkayil
 *
 */
import org.springframework.stereotype.Service;

import com.goalseek.dao.GoalSeekOutDao;

@Service
public class ProduceResult {
	
	 
	 public List<GoalSeekOutDao> M1(double OP1,double Guess,double ExpCB,double NP) {
		  List<GoalSeekOutDao>  getJsonResultP = new ArrayList<GoalSeekOutDao>(); 
          double   Lfee1 = Guess;
          double IRPer1    = 0.06;
          double MarPer1   = 0.01;
          double TLPPer1   = 0.01;
          double TotMarTLP1= MarPer1+TLPPer1;
         // double TotPer1   = IRPer1+MarPer1+TLPPer1;
         // double IndexPer1 = 0;
          double TLP1  =
          (OP1-Lfee1)*TLPPer1+TotMarTLP1/(1-TotMarTLP1)*TLPPer1*(OP1-Lfee1);
          double Margin1  =
          (OP1-Lfee1)*MarPer1+TotMarTLP1/(1-TotMarTLP1)*MarPer1*(OP1-Lfee1);
          double IR1  =
          (OP1-Lfee1)*IRPer1+TotMarTLP1/(1-TotMarTLP1)*IRPer1*(OP1-Lfee1);
          double Depre1 = Lfee1-TLP1-Margin1-IR1;
          double CB1 = OP1-Depre1;
		/*
		 * StringBuilder GoalResultJson = new StringBuilder(); String Jopn ="{"; String
		 * op = "\"OPN-1.0\": "+Math.round(OP1)+","; String dep =
		 * "\"DEP-1.0\": "+Math.round(Depre1)+","; String cb =
		 * "\"CLB-1.0\": "+Math.round(CB1)+","; String ir =
		 * "\"INR-1.0\": "+Math.round(IR1)+","; String mar =
		 * "\"MAR-1.0\": "+Math.round(Margin1)+","; String tlp =
		 * "\"TLP-1.0\": "+Math.round(TLP1)+","; String lfe =
		 * "\"LEF-1.0\": "+Math.round(Lfee1)+",";
		 * GoalResultJson.append(Jopn+"\n"+op+"\n"+dep+"\n"+cb+"\n"+ir+"\n"+mar+"\n"+tlp
		 * +"\n"+lfe+"\n");
		 */
          GoalSeekOutDao gs = new GoalSeekOutDao();
          gs.setOpeningBalance(Math.round(OP1));
          gs.setDepreciation(Math.round(Depre1));
          gs.setClosingBalance(Math.round(CB1));
          gs.setInterestRate(Math.round(IR1));
          gs.setMargin(Math.round(Margin1));
          gs.setTlp(Math.round(TLP1));
          gs.setLeaseFee(+Math.round(Lfee1));
          gs.setPeriod(1);
          getJsonResultP.add(gs);
          MN(CB1,Guess,ExpCB,NP,getJsonResultP);
          return getJsonResultP;
    }
	 public List<GoalSeekOutDao> MN(double OPn,double Guess,double ExpCB,double NP, List<GoalSeekOutDao>  getJsonResultP) {
		  int Period =2;
	      double OPN = OPn;
	      double  LfeeN = 0;
	      double CBN = 0;
	            do {
	           double IRPerN    = 0.06;
	           double MarPerN   = 0.01;
	           double TLPPerN   = 0.01;
	           double TotMarTLPN= MarPerN+TLPPerN;
	          // double TotPerN   = IRPerN+MarPerN+TLPPerN;
	           double IndexPerN = 0.01;
	            LfeeN = Guess*(1+IndexPerN)*Math.pow((1+IndexPerN),Period-2);
	            double TLPN  =
	           (OPN-LfeeN)*TLPPerN+TotMarTLPN/(1-TotMarTLPN)*TLPPerN*(OPN-LfeeN);
	           double MarginN  =
	           (OPN-LfeeN)*MarPerN+TotMarTLPN/(1-TotMarTLPN)*MarPerN*(OPN-LfeeN);
	           double IRN  =
	           (OPN-LfeeN)*IRPerN+TotMarTLPN/(1-TotMarTLPN)*IRPerN*(OPN-LfeeN);
	           double DepreN = LfeeN-TLPN-MarginN-IRN;
	           CBN = OPN-DepreN;
	           GoalSeekOutDao gs = new GoalSeekOutDao();
	           gs.setOpeningBalance(Math.round(OPN));
	           gs.setDepreciation(Math.round(DepreN));
	           gs.setClosingBalance(Math.round(CBN));
	           gs.setInterestRate(Math.round(IRN));
	           gs.setMargin(Math.round(MarginN));
	           gs.setTlp(Math.round(TLPN));
	           gs.setLeaseFee(+Math.round(LfeeN));
	           gs.setPeriod(Period);
		       getJsonResultP.add(gs);
	             Period = Period+1;
	             OPN = CBN;
	        }while(Period <= NP);
		       return getJsonResultP;
	}
}
