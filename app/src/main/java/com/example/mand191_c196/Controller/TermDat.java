package com.example.mand191_c196.Controller;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.mand191_c196.Model.Term;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import static java.lang.Long.parseLong;

public class TermDat {
    public static final String LOGTAG = "TERM_SYS";

    SQLiteOpenHelper dbhandler;
    SQLiteDatabase database;

    private static final String[] allColumns = {
            DbHelper.TERM_ID,
            DbHelper.TERM_TITLE,
            DbHelper.TERM_START_DATE,
            DbHelper.TERM_END_DATE
    };

    public TermDat(Context context){
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

    public Term addTerm(Term term) {
        ContentValues values = new ContentValues();
        values.put(DbHelper.TERM_ID, term.getTermId());
        values.put(DbHelper.TERM_TITLE, term.getTermId());
        values.put(DbHelper.TERM_START_DATE, term.getTermStartDate());
        values.put(DbHelper.TERM_END_DATE, term.getTermEndDate());
        long insertid = database.insert(DbHelper.TABLE_TERM, null, values);
        term.setTermId(insertid);
        return term;



    }

    //Get Single Term
    public Term getTerm(long id) {
        Cursor cursor = database.query(DbHelper.TABLE_TERM, allColumns,DbHelper.TERM_ID + "=?", new String[]{String.valueOf(id)},null,null,null);
                if (cursor != null)
                    cursor.moveToFirst();
                Term term = makeTerm(cursor);
                cursor.close();
                return term;
    }

    public List<Term> getAllTerms(){
        Cursor cursor = database.query(DbHelper.TABLE_TERM, allColumns,null,null,null,null,null);
            List<Term> terms = new ArrayList<>();
            if(cursor.getCount() > 0){
                while(cursor.moveToNext()){
                    Term term = makeTerm(cursor);
                    terms.add(term);
                    cursor.moveToNext();
                }
            }
            cursor.close();
            return terms;
    }

    //update
    public int updateTerm(Term term){
        ContentValues values = new ContentValues();
        values.put(DbHelper.TERM_TITLE, term.getTermTitle());
        values.put(DbHelper.TERM_START_DATE, term.getTermStartDate());
        values.put(DbHelper.TERM_END_DATE, term.getTermEndDate());
        return database.update(DbHelper.TABLE_TERM, values, DbHelper.TERM_ID + "=?",new String[]{ String.valueOf(term.getTermId())});
    }

    //delete
    public void removeTerm(Term term){
        database.delete(DbHelper.TABLE_TERM, DbHelper.TERM_ID + "=" + term.getTermId(), null);
    }

    public Term getNow(){
        long now = Calendar.getInstance().getTimeInMillis();
        Cursor cursor = database.query(DbHelper.TABLE_TERM, allColumns, DbHelper.TERM_START_DATE + " <= " + now + " AND " + DbHelper.TERM_END_DATE + " >= " + now, null, null, null, null);
        cursor.moveToFirst();
        Term term = null;
        if(cursor!=null && cursor.getCount()>0) {
            term = makeTerm(cursor);
        }
        cursor.close();
        return term;
    }

    private Term makeTerm(Cursor cursor){
        Term term = new Term();
        term.setTermId(cursor.getLong(0));
        term.setTermTitle(cursor.getString(1));
        term.setTermStartDate(cursor.getString(2));
        term.setTermEndDate(cursor.getString(3));
        return term;


    }

}
