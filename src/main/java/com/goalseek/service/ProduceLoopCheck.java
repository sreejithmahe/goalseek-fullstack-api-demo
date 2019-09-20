package com.goalseek.service;
/**
 * @author sreejith.kizhakkayil
 *
 */
import org.springframework.stereotype.Service;

@Service
public class ProduceLoopCheck {
	 public double M1(double OP1,double Guess,double ExpCB,double NP) {
          double   Lfee1 = Guess;
          double IRPer1    = 0.06;
          double MarPer1   = 0.01;
          double TLPPer1   = 0.01;
          double TotMarTLP1= MarPer1+TLPPer1;
          //double TotPer1   = IRPer1+MarPer1+TLPPer1;
          //double IndexPer1 = 0;
          double TLP1  =
          (OP1-Lfee1)*TLPPer1+TotMarTLP1/(1-TotMarTLP1)*TLPPer1*(OP1-Lfee1);
          double Margin1  =
          (OP1-Lfee1)*MarPer1+TotMarTLP1/(1-TotMarTLP1)*MarPer1*(OP1-Lfee1);
          double IR1  =
          (OP1-Lfee1)*IRPer1+TotMarTLP1/(1-TotMarTLP1)*IRPer1*(OP1-Lfee1);
          double Depre1 = Lfee1-TLP1-Margin1-IR1;
          /* if required check 'Depre1' Value not going to be -Ve */
          double CB1 = OP1-Depre1;
	      double FinalCB =  MN(CB1,Guess,ExpCB,NP);
          return FinalCB;
     }
	 public double MN(double OPn,double Guess,double ExpCB,double NP) {
	      double Period =2;
	      double OPN = OPn;
	      double  LfeeN = 0;
	      double CBN = 0;
		       do {
	           double IRPerN    = 0.06;
	           double MarPerN   = 0.01;
	           double TLPPerN   = 0.01;
	           double TotMarTLPN= MarPerN+TLPPerN;
	           //double TotPerN   = IRPerN+MarPerN+TLPPerN;
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
	           Period = Period+1;
	             OPN = CBN;
	        }while(Period <= NP);
		    return CBN;
	}
}