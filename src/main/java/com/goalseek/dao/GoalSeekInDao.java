package com.goalseek.dao;
/**
 * @author sreejith.kizhakkayil
 *
 */
public class GoalSeekInDao {
	
	private double openingBalance;
	private double expectedClosingBalance;
	private double totalNoPeriod;
	private double interestInPeriod;
	private double marginInPeriod;
	private double tlpInPeriod;
	private double totalRateInPeriod;
	private double totMarginTlp;
	
	public GoalSeekInDao() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GoalSeekInDao(double openingBalance, double expectedClosingBalance, double totalNoPeriod,
			double interestInPeriod, double marginInPeriod, double tlpInPeriod, double totalRateInPeriod,
			double totMarginTlp) {
		super();
		this.openingBalance = openingBalance;
		this.expectedClosingBalance = expectedClosingBalance;
		this.totalNoPeriod = totalNoPeriod;
		this.interestInPeriod = interestInPeriod;
		this.marginInPeriod = marginInPeriod;
		this.tlpInPeriod = tlpInPeriod;
		this.totalRateInPeriod = totalRateInPeriod;
		this.totMarginTlp = totMarginTlp;
	}

	public double getOpeningBalance() {
		return openingBalance;
	}

	public void setOpeningBalance(double openingBalance) {
		this.openingBalance = openingBalance;
	}

	public double getExpectedClosingBalance() {
		return expectedClosingBalance;
	}

	public void setExpectedClosingBalance(double expectedClosingBalance) {
		this.expectedClosingBalance = expectedClosingBalance;
	}

	public double getTotalNoPeriod() {
		return totalNoPeriod;
	}

	public void setTotalNoPeriod(double totalNoPeriod) {
		this.totalNoPeriod = totalNoPeriod;
	}

	public double getInterestInPeriod() {
		return interestInPeriod;
	}

	public void setInterestInPeriod(double interestInPeriod) {
		this.interestInPeriod = interestInPeriod;
	}

	public double getMarginInPeriod() {
		return marginInPeriod;
	}

	public void setMarginInPeriod(double marginInPeriod) {
		this.marginInPeriod = marginInPeriod;
	}

	public double getTlpInPeriod() {
		return tlpInPeriod;
	}

	public void setTlpInPeriod(double tlpInPeriod) {
		this.tlpInPeriod = tlpInPeriod;
	}

	public double getTotalRateInPeriod() {
		return totalRateInPeriod;
	}

	public void setTotalRateInPeriod(double totalRateInPeriod) {
		this.totalRateInPeriod = totalRateInPeriod;
	}

	public double getTotMarginTlp() {
		return totMarginTlp;
	}

	public void setTotMarginTlp(double totMarginTlp) {
		this.totMarginTlp = totMarginTlp;
	}

}
