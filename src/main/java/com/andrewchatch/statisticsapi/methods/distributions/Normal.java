package com.andrewchatch.statisticsapi.methods.distributions;

import java.util.HashMap;

public class Normal {
    protected double x;
    protected double popMean;
    protected double popStDev;

    public Normal(double x, double popMean, double popStDev) {
        this.x = x;
        this.popMean = popMean;
        this.popStDev = popStDev;
    }

    public Normal(Normal normal) {
        this.x = normal.x;
        this.popMean = normal.popMean;
        this.popStDev = normal.popStDev;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setMean(double mean) {
        this.popMean = mean;
    }

    public void setStDev(double popStDev) {
        this.popStDev = popStDev;
    }

    public double getX() {
        return this.x;
    }

    public double getMean() {
        return this.popMean;
    }

    public double getStDev() {
        return this.popStDev;
    }

    private double computeZScore(double x, double mean, double stdev) {
        double zScore = (x - mean) / stdev;
        return zScore;
    }

    private double[] normalCDF(double x, double mean, double stdev) {
        double zScore = computeZScore(x, mean, stdev);
        double leftArea = (1 + erfFunction(0, zScore/Math.sqrt(2), 0.00001)) / 2;
        double rightArea = 1 - leftArea;

        if (zScore < 0) {
            double temp = leftArea;
            leftArea = rightArea;
            rightArea = temp;
        }

        double[] arr = {leftArea, rightArea};
        return arr;
    }

    private double erfFunction(double start, double end, double step) {
        double area = 0;

        if (end < 0) {
            for(double z = start; z > end; z -= step) {
                area += Math.exp(-Math.pow((z + step/2),2)) * step;
            }
        }
        else {
            for(double z = start; z < end; z += step) {
                area += Math.exp(-Math.pow((z + step/2),2)) * step;
            }
        }

        return area * (2 / Math.sqrt(Math.PI));
    }

    public HashMap<String,Double> getProbability(double x, double mean, double stdev) {
        double[] probs = normalCDF(x, mean, stdev);

        HashMap<String,Double> map = new HashMap<String,Double>();
        map.put("P(X < x)", probs[0]);
        map.put("P(X > x)", probs[1]);

        return map;
    }
}
