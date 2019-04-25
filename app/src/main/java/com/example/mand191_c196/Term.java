package com.example.mand191_c196;

public class Term {
    private long termId;
    private String termTitle;
    private String termStartDate;
    private String termEndDate;

    public Term (long termId, String termTitle, String termStartDate, String termEndDate){
        this.termId = termId;
        this.termTitle = termTitle;
        this.termStartDate = termStartDate;
        this.termEndDate = termEndDate;
    }

    public Term(){}

    public long getTermId(){
        return termId;
    }

    public void setTermId(long termId){
        this.termId = termId;
    }

    public String getTermTitle(){
        return  termTitle;
    }

    public void setTermTitle(String termTitle){
        this.termTitle = termTitle;
    }

    public String getTermStartDate(){
        return termStartDate;
    }

    public void setTermStartDate(String termStartDate){
        this.termStartDate = termStartDate;
    }

    public String getTermEndDate(){
        return termEndDate;
    }

    public void setTermEndDate(String termEndDate){
        this.termEndDate = termEndDate;
    }

    public String toString(){
        return "Term ID: " + getTermId() +
                ", Term Title: " + getTermTitle() +
                ", Term Start: " + getTermStartDate() +
                ", Term End: " + getTermEndDate();
    }
}
