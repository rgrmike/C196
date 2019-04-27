package com.example.mand191_c196.Model;

public class Course {
    /*
   the course title
       •  the start date
       •  the anticipated end date
       •  the status (in progress, completed, dropped, plan to take)
       •  the course mentor names, phone numbers, and e-mail addresses

       Include features that allow the user to do the following for each  course:
		a. add as many assessments as needed
		b. add a minimum of one optional note per course
		c. enter, edit, and delete course information
		d. display optional notes
		e. display a detailed view of the course, including the due date
		f. set alerts for the start and end date, that will trigger when the application is not running
g. share notes via a sharing feature (either e-mail or SMS)

    */
    private long courseId;
    private String courseTitle;
    private String courseStartDate;
    private String courseEndDate;
    private String courseStatus;
    private String courseMentorName;
    private String courseMentorPhone;
    private String courseMentorEmail;
    private String courseNotes;
    private long termId;

    public Course (long courseId,
                   String courseTitle,
                   String courseStartDate,
                   String courseEndDate,
                   String courseStatus,
                   String courseMentorName,
                   String courseMentorPhone,
                   String courseMentorEmail,
                   String courseNotes,
                   long termId){
        this.courseId = courseId;
        this.courseTitle = courseTitle;
        this.courseStartDate = courseStartDate;
        this.courseEndDate = courseEndDate;
        this.courseStatus = courseStatus;
        this.courseMentorName = courseMentorName;
        this.courseMentorPhone = courseMentorPhone;
        this.courseMentorEmail = courseMentorEmail;
        this.courseNotes = courseNotes;
        this.termId = termId;
    }

    public Course(){}

    public long getCourseId() {
        return courseId;
    }

    public void setCourseId(long courseId) {
        this.courseId = courseId;
    }

    public String getCourseTitle(){
        return courseTitle;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }

    public String getCourseStartDate() {
        return courseStartDate;
    }

    public void setCourseStartDate(String courseStartDate) {
        this.courseStartDate = courseStartDate;
    }

    public String getCourseEndDate(){
        return courseEndDate;
    }

    public void setCourseEndDate(String courseEndDate) {
        this.courseEndDate = courseEndDate;
    }

    public String getCourseStatus() {
        return courseStatus;
    }

    public void setCourseStatus(String courseStatus) {
        this.courseStatus = courseStatus;
    }

    public String getCourseMentorName() {
        return courseMentorName;
    }

    public void setCourseMentorName(String courseMentorName) {
        this.courseMentorName = courseMentorName;
    }

    public String getCourseMentorPhone() {
        return courseMentorPhone;
    }

    public void setCourseMentorPhone(String courseMentorPhone) {
        this.courseMentorPhone = courseMentorPhone;
    }

    public String getCourseMentorEmail() {
        return courseMentorEmail;
    }

    public void setCourseMentorEmail(String courseMentorEmail) {
        this.courseMentorEmail = courseMentorEmail;
    }

    public String getCourseNotes() {
        return courseNotes;
    }

    public void setCourseNotes(String courseNotes) {
        this.courseNotes = courseNotes;
    }

    public long getTermId() {return termId;}

    public void setTermId(long termId){
        this.termId = termId;
    }
}
