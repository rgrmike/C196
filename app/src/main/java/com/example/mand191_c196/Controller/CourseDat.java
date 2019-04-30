package com.example.mand191_c196.Controller;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.mand191_c196.Model.Course;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class CourseDat {
    public static final String LOGTAG = "COURSE_SYS";

    SQLiteOpenHelper dbhandler;
    SQLiteDatabase database;

    private static final String[] allColumns = {
            DbHelper.COURSE_ID,
            DbHelper.COURSE_TITLE,
            DbHelper.COURSE_START_DATE,
            DbHelper.COURSE_END_DATE,
            DbHelper.COURSE_STATUS,
            DbHelper.COURSE_MENTOR_NAME,
            DbHelper.COURSE_MENTOR_PHONE,
            DbHelper.COURSE_MENTOR_EMAIL,
            DbHelper.COURSE_NOTES,
            DbHelper.COURSE_TERM_ID
    };

    public CourseDat(Context context){
        dbhandler = new DbHelper(context);
    }



    public void open(){
        Log.i(LOGTAG,"Database Opened");
        database = dbhandler.getWritableDatabase();
    }

    public void close(){
        Log.i(LOGTAG, "Database Closed");
        dbhandler.close();
    }

    public Course addCourse(Course course) {
        ContentValues values = new ContentValues();
        values.put(DbHelper.COURSE_ID, course.getCourseId());
        values.put(DbHelper.COURSE_TITLE, course.getCourseTitle());
        values.put(DbHelper.COURSE_START_DATE, course.getCourseStartDate());
        values.put(DbHelper.COURSE_END_DATE, course.getCourseEndDate());
        values.put(DbHelper.COURSE_STATUS, course.getCourseStatus());
        values.put(DbHelper.COURSE_MENTOR_NAME, course.getCourseMentorName());
        values.put(DbHelper.COURSE_MENTOR_PHONE, course.getCourseMentorPhone());
        values.put(DbHelper.COURSE_MENTOR_EMAIL, course.getCourseMentorEmail());
        values.put(DbHelper.COURSE_NOTES, course.getCourseNotes());
        values.put(DbHelper.COURSE_TERM_ID, course.getTermId());
        long insertid = database.insert(DbHelper.TABLE_COURSE, null, values);
        course.setCourseId(insertid);
        return course;
    }

    //Get Single Term
    public Course getTerm(long id) {
        Cursor cursor = database.query(DbHelper.TABLE_COURSE, allColumns,DbHelper.COURSE_ID + "=?", new String[]{String.valueOf(id)},null,null,null);
        if (cursor != null)
            cursor.moveToFirst();
        Course course = makeCourse(cursor);
        cursor.close();
        return course;
    }

    public List<Course> getAllCourses(){
        Cursor cursor = database.query(DbHelper.TABLE_TERM, allColumns,null,null,null,null,null);
        List<Course> courses = new ArrayList<>();
        if(cursor.getCount() > 0){
            while(cursor.moveToNext()){
                Course course = makeCourse(cursor);
                courses.add(course);
                cursor.moveToNext();
            }
        }
        cursor.close();
        return courses;
    }

    //update
    public int updateCourse(Course course){
        ContentValues values = new ContentValues();
        values.put(DbHelper.COURSE_TITLE, course.getCourseTitle());
        values.put(DbHelper.COURSE_START_DATE, course.getCourseStartDate());
        values.put(DbHelper.COURSE_END_DATE, course.getCourseEndDate());
        values.put(DbHelper.COURSE_STATUS, course.getCourseStatus());
        values.put(DbHelper.COURSE_MENTOR_NAME, course.getCourseMentorName());
        values.put(DbHelper.COURSE_MENTOR_PHONE, course.getCourseMentorPhone());
        values.put(DbHelper.COURSE_MENTOR_EMAIL, course.getCourseMentorEmail());
        values.put(DbHelper.COURSE_NOTES, course.getCourseNotes());
        values.put(DbHelper.COURSE_TERM_ID, course.getTermId());
        return database.update(DbHelper.TABLE_COURSE, values, DbHelper.COURSE_ID + "=?",new String[]{ String.valueOf(course.getCourseId())});
    }

    //delete
    public void removeCourse(Course course){
        database.delete(DbHelper.TABLE_COURSE, DbHelper.COURSE_ID + "=" + course.getCourseId(), null);
    }

    //get all present courses
    public List<Course> getNowCourse(){
        long now = Calendar.getInstance().getTimeInMillis();
        Cursor cursor = database.query(DbHelper.TABLE_COURSE, allColumns, DbHelper.COURSE_START_DATE + " <= " + now + " AND " + DbHelper.COURSE_END_DATE + " >= " + now, null, null, null, null);
        cursor.moveToFirst();
        List<Course> courses = new ArrayList<>();
        while(!cursor.isAfterLast()){
            Course course = makeCourse(cursor);
            courses.add(course);
            cursor.moveToNext();
        }
        cursor.close();
        return courses;
    }

    //find courses by term
    public List<Course> getTermCourse(long termId){
        List<Course> courses = new ArrayList<>();
        Cursor cursor = database.query(DbHelper.TABLE_COURSE, allColumns, DbHelper.COURSE_TERM_ID + " = " + termId, null, null, null, null);
        cursor.moveToFirst();
        while(!cursor.isAfterLast()){
            Course course = makeCourse(cursor);
            courses.add(course);
            cursor.moveToNext();
        }
        cursor.close();
        return courses;
    }

    private Course makeCourse(Cursor cursor){
        Course course = new Course();
        course.setCourseId(cursor.getLong(0));
        course.setCourseTitle(cursor.getString(1));
        course.setCourseStartDate(cursor.getString(2));
        course.setCourseEndDate(cursor.getString(3));
        course.setCourseStatus(cursor.getString(4));
        course.setCourseMentorName(cursor.getString(5));
        course.setCourseMentorPhone(cursor.getString(6));
        course.setCourseMentorEmail(cursor.getString(7));
        course.setCourseNotes(cursor.getString(8));
        course.setTermId(cursor.getLong(9));
        return course;


    }


}
