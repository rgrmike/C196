package com.example.mand191_c196;

public class Assessment {
    /*
    Include features that allow the user to do the following for each  assessment:
		a. add performance and objective assessments for each  course, including the titles and due dates of the assessments
		b. enter, edit, and delete assessment information
c. set alerts for goal dates, that will trigger when the application is not running
     */

    private long assessmentId;
    private String assessmentTitle;
    private String assessmentDueDate;
    private String assessmentType;
    private long assessmentCourseId;

    public Assessment(long assessmentId, String assessmentTitle, String assessmentDueDate, String assessmentType, long assessmentCourseId){
        this.assessmentId = assessmentId;
        this.assessmentTitle = assessmentTitle;
        this.assessmentDueDate = assessmentDueDate;
        this.assessmentType = assessmentType;
        this.assessmentCourseId = assessmentCourseId;
    }

    public Assessment(){}

    public long getAssessmentId() {
        return assessmentId;
    }

    public void setAssessmentId(long assessmentId) {
        this.assessmentId = assessmentId;
    }

    public String getAssessmentTitle() {
        return assessmentTitle;
    }

    public void setAssessmentTitle(String assessmentTitle) {
        this.assessmentTitle = assessmentTitle;
    }

    public String getAssessmentDueDate() {
        return assessmentDueDate;
    }

    public void setAssessmentDueDate(String assessmentDueDate){
        this.assessmentDueDate = assessmentDueDate;
    }

    public String getAssessmentType() {return assessmentType;}

    public void setAssessmentType(String assessmentType){
        this.assessmentType = assessmentType;
    }

    public long getAssessmentCourseId() {
        return assessmentCourseId;
    }

    public void setAssessmentCourseId(long assessmentCourseId) {
        this.assessmentCourseId = assessmentCourseId;
    }
}
