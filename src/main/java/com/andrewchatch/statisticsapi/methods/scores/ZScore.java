package com.andrewchatch.statisticsapi.methods.scores;

import java.util.HashMap;

import com.andrewchatch.statisticsapi.methods.distributions.Normal;

public class ZScore extends Normal {
    
    public ZScore(double x, double popMean, double popStDev) {
        super(x, popMean, popStDev);
    }

    public ZScore(ZScore z) {
        super(z);
    }

    public HashMap<String,Double> calculateZScore() {
        double zScore = (this.x - this.popMean) / this.popStDev;

        HashMap<String,Double> map = this.getProbability(this.x, this.popMean, this.popStDev);
        map.put("Z Score", zScore);
        return map;
    }
}
