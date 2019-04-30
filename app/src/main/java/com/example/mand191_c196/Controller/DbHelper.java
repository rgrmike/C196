package com.example.mand191_c196.Controller;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper extends SQLiteOpenHelper {
    private static final String DATABASE = "course.db";
    private static final int DATABASE_VERSION = 1;

    //tables
    public static final String TABLE_COURSE = "course";
    public static final String TABLE_TERM = "term";
    public static final String TABLE_ASSESSMENT = "assessment";

    //course columns
    public static final String COURSE_ID = "courseId";
    public static final String COURSE_TITLE = "courseTitle";
    public static final String COURSE_START_DATE = "courseStartDate";
    public static final String COURSE_END_DATE = "courseEndDate";
    public static final String COURSE_STATUS = "courseStatus";
    public static final String COURSE_MENTOR_NAME = "courseMentorName";
    public static final String COURSE_MENTOR_PHONE = "courseMentorPhone";
    public static final String COURSE_MENTOR_EMAIL = "courseMentorEmail";
    public static final String COURSE_NOTES = "courseNotes";
    public static final String COURSE_TERM_ID = "courseTermId";

    //term columns
    public static final String TERM_ID = "termId";
    public static final String TERM_TITLE = "termTitle";
    public static final String TERM_START_DATE = "termStartDate";
    public static final String TERM_END_DATE = "termEndDate";

    //assessment columns
    public static final String ASSESSMENT_ID = "assessmentId";
    public static final String ASSESSMENT_TITLE = "assessmentTitle";
    public static final String ASSESSMENT_TYPE = "assessmentType";
    public static final String ASSESSMENT_DUE_DATE = "assessmentDueDate";
    public static final String ASSESSMENT_COURSE_ID = "assessmentCourseId";

    //create course table
    private static final String CREATE_TABLE_COURSE =
            "CREATE TABLE " + TABLE_COURSE + " (" +
                    COURSE_ID + "INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COURSE_TITLE + "TEXT, " +
                    COURSE_START_DATE + "INTEGER, " +
                    COURSE_END_DATE + "INTEGER, " +
                    COURSE_STATUS + "TEXT, " +
                    COURSE_MENTOR_NAME + "TEXT, " +
                    COURSE_MENTOR_PHONE + "TEXT, " +
                    COURSE_MENTOR_EMAIL + "TEXT, " +
                    COURSE_NOTES + "TEXT, " +
                    COURSE_TERM_ID + "INTEGER " +
                    ") ";

    //create term table
    private static final String CREATE_TABLE_TERM =
            "CREATE TABLE " + TABLE_TERM + " (" +
                    TERM_ID + "INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    TERM_TITLE + "TEXT, " +
                    TERM_START_DATE + "INTEGER, " +
                    TERM_END_DATE + "INTEGER " +
                    ") ";

    //create assessment table
    private static final String CREATE_TABLE_ASSESSMENT =
            "CREATE TABLE " + TABLE_ASSESSMENT + " (" +
                    ASSESSMENT_ID + "INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    ASSESSMENT_TITLE + "TEXT, " +
                    ASSESSMENT_TYPE + "TEXT, " +
                    ASSESSMENT_DUE_DATE  + "INTEGER, " +
                    ASSESSMENT_COURSE_ID + "INTEGER " +
                                ") ";


    public DbHelper(Context context) { super(context, DATABASE, null, DATABASE_VERSION); }

    @Override
    public void onCreate(SQLiteDatabase database) {
        //execute create tables
        database.execSQL(CREATE_TABLE_COURSE);
        database.execSQL(CREATE_TABLE_TERM);
        database.execSQL(CREATE_TABLE_ASSESSMENT );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //on upgrade drop old tables
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_COURSE);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_TERM);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ASSESSMENT);
        //create new tables
        onCreate(db);
    }
}


