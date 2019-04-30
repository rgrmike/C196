package com.example.mand191_c196.Controller;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;


import com.example.mand191_c196.Model.Assessment;


public class AssessmentDat {
    public static final String LOGTAG = "Assessment_SYS";

    SQLiteOpenHelper dbhandler;
    SQLiteDatabase database;

    private static final String[] allColumns = {
            DbHelper.ASSESSMENT_ID,
            DbHelper.ASSESSMENT_TITLE,
            DbHelper.ASSESSMENT_DUE_DATE,
            DbHelper.ASSESSMENT_TYPE,
            DbHelper.ASSESSMENT_COURSE_ID
    };

    public AssessmentDat(Context context){
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

    public Assessment addAssessment(Assessment assessment) {
        ContentValues values = new ContentValues();
        values.put(DbHelper.ASSESSMENT_ID, assessment.getAssessmentId());
        values.put(DbHelper.ASSESSMENT_TITLE, assessment.getAssessmentTitle());
        values.put(DbHelper.ASSESSMENT_DUE_DATE, assessment.getAssessmentDueDate());
        values.put(DbHelper.ASSESSMENT_TYPE, assessment.getAssessmentType());
        values.put(DbHelper.ASSESSMENT_COURSE_ID, assessment.getAssessmentCourseId());
        long insertid = database.insert(DbHelper.TABLE_ASSESSMENT, null, values);
        assessment.setAssessmentId(insertid);
        return assessment;
    }

    public Assessment getAssessment(long id) {
        Cursor cursor = database.query(DbHelper.TABLE_ASSESSMENT, allColumns,DbHelper.ASSESSMENT_ID + "=?", new String[]{String.valueOf(id)},null,null,null);
        if (cursor != null)
            cursor.moveToFirst();
        Assessment assessment = makeAssessment(cursor);
        cursor.close();
        return assessment;
    }

    public List<Assessment> getAllAssessments(){
        Cursor cursor = database.query(DbHelper.TABLE_ASSESSMENT, allColumns,null,null,null,null,null);
        List<Assessment> assessments = new ArrayList<>();
        if(cursor.getCount() > 0){
            while(cursor.moveToNext()){
                Assessment assessment = makeAssessment(cursor);
                assessments.add(assessment);
                cursor.moveToNext();
            }
        }
        cursor.close();
        return assessments;
    }

    //update
    public int updateAssessment(Assessment assessment){
        ContentValues values = new ContentValues();
        values.put(DbHelper.ASSESSMENT_TITLE, assessment.getAssessmentTitle());
        values.put(DbHelper.ASSESSMENT_DUE_DATE, assessment.getAssessmentDueDate());
        values.put(DbHelper.ASSESSMENT_TYPE, assessment.getAssessmentType());
        values.put(DbHelper.ASSESSMENT_COURSE_ID, assessment.getAssessmentCourseId());
        return database.update(DbHelper.TABLE_ASSESSMENT, values, DbHelper.ASSESSMENT_ID + "=?",new String[]{ String.valueOf(assessment.getAssessmentId())});
    }

    //delete
    public void removeAssesment(Assessment assessment){
        database.delete(DbHelper.TABLE_ASSESSMENT, DbHelper.ASSESSMENT_ID + "=" + assessment.getAssessmentId(), null);
    }

    //find Assessments by course
    public List<Assessment> getTermCourse(long assesmentId){
        List<Assessment> assessments = new ArrayList<>();
        Cursor cursor = database.query(DbHelper.TABLE_ASSESSMENT, allColumns, DbHelper.ASSESSMENT_COURSE_ID + " = " + assesmentId, null, null, null, null);
        cursor.moveToFirst();
        while(!cursor.isAfterLast()){
            Assessment assessment = makeAssessment(cursor);
            assessments.add(assessment);
            cursor.moveToNext();
        }
        cursor.close();
        return assessments;
    }

    private Assessment makeAssessment(Cursor cursor){
        Assessment assessment = new Assessment();
        assessment.setAssessmentId(cursor.getLong(0));
        assessment.setAssessmentTitle(cursor.getString(1));
        assessment.setAssessmentDueDate(cursor.getString(2));
        assessment.setAssessmentType(cursor.getString(3));
        assessment.setAssessmentCourseId(cursor.getLong(4));
        return assessment;
    }

}
