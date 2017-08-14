package com.project.rating.model;

public class Rating {

    private String resource;
    private String score;
    private String hype;
    private String risk;
    private String invest;

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getHype() {
        return hype;
    }

    public void setHype(String hype) {
        this.hype = hype;
    }

    public String getRisk() {
        return risk;
    }

    public void setRisk(String risk) {
        this.risk = risk;
    }

    public String getInvest() {
        return invest;
    }

    public void setInvest(String invest) {
        this.invest = invest;
    }
}
