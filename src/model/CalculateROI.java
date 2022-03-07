package model;

import javafx.beans.Observable;
import javafx.collections.ObservableList;

public class CalculateROI {

    private int day;
    private double vpnd;
    private String diamondHands;
    private String compoundBonus;
    private double reward;
    private double fee;
    private double total;

    public CalculateROI(int day, double vpnd, String diamondHands, String compoundBonus, double reward, double fee, double total) {
        this.day = day;
        this.vpnd = vpnd;
        this.diamondHands = diamondHands;
        this.compoundBonus = compoundBonus;
        this.reward = reward;
        this.fee = fee;
        this.total = total;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public double getVpnd() {
        return vpnd;
    }

    public void setVpnd(double vpnd) {
        this.vpnd = vpnd;
    }

    public String getDiamondHands() {
        return diamondHands;
    }

    public void setDiamondHands(String diamondHands) {
        this.diamondHands = diamondHands;
    }

    public String getCompoundBonus() {
        return compoundBonus;
    }

    public void setCompoundBonus(String compoundBonus) {
        this.compoundBonus = compoundBonus;
    }

    public double getReward() {
        return reward;
    }

    public void setReward(double reward) {
        this.reward = reward;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
