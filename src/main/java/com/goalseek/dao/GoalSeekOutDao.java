package com.goalseek.dao;
/**
 * @author sreejith.kizhakkayil
 *
 */
public class GoalSeekOutDao {
	
	private double openingBalance;
	private double depreciation;
	private double closingBalance;
	private double interestRate;
	private double margin;
	private double tlp;
	private double leaseFee;
	private int period;
	
	public GoalSeekOutDao() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GoalSeekOutDao(double openingBalance, double depreciation, double closingBalance, double interestRate,
			double margin, double tlp, double leaseFee, int period) {
		super();
		this.openingBalance = openingBalance;
		this.depreciation = depreciation;
		this.closingBalance = closingBalance;
		this.interestRate = interestRate;
		this.margin = margin;
		this.tlp = tlp;
		this.leaseFee = leaseFee;
		this.period = period;
	}

	public double getOpeningBalance() {
		return openingBalance;
	}

	public void setOpeningBalance(double openingBalance) {
		this.openingBalance = openingBalance;
	}

	public double getDepreciation() {
		return depreciation;
	}

	public void setDepreciation(double depreciation) {
		this.depreciation = depreciation;
	}

	public double getClosingBalance() {
		return closingBalance;
	}

	public void setClosingBalance(double closingBalance) {
		this.closingBalance = closingBalance;
	}

	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}

	public double getMargin() {
		return margin;
	}

	public void setMargin(double margin) {
		this.margin = margin;
	}

	public double getTlp() {
		return tlp;
	}

	public void setTlp(double tlp) {
		this.tlp = tlp;
	}

	public double getLeaseFee() {
		return leaseFee;
	}

	public void setLeaseFee(double leaseFee) {
		this.leaseFee = leaseFee;
	}

	public int getPeriod() {
		return period;
	}

	public void setPeriod(int period) {
		this.period = period;
	}

}
