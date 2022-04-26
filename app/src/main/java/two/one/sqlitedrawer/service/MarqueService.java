package two.one.sqlitedrawer.service;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import two.one.sqlitedrawer.classes.Marque;
import two.one.sqlitedrawer.util.MySQLiteHelper;

public class MarqueService {


    private static final String TABLE_NAME = "Marque";

    private static final String KEY_ID = "id";
    private static final String KEY_CODE = "code";
    private static final String KEY_LIBELLE = "libelle";

    private static String[] COLUMNS = {KEY_ID, KEY_CODE, KEY_LIBELLE};

    private MySQLiteHelper helper;

    public MarqueService() {
    }
    public MarqueService(Context context) {
        this.helper = new MySQLiteHelper(context);
    }

    public void create(Marque e) {
        SQLiteDatabase db = this.helper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_CODE, e.getCode());
        values.put(KEY_LIBELLE, e.getLibelle());
        db.insert(TABLE_NAME,
                null,
                values);
        Log.d("insert", e.getCode() + " " + e.getLibelle());
        db.close();
    }

    public void update(Marque e) {
        SQLiteDatabase db = this.helper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_ID, e.getId());
        values.put(KEY_CODE, e.getCode());
        values.put(KEY_LIBELLE, e.getLibelle());

        db.update(TABLE_NAME,
                values,
                "id = ?",
                new String[]{e.getId() + ""});
        db.close();
    }

    public Marque findById(int id) {
        Marque e = null;
        SQLiteDatabase db = this.helper.getReadableDatabase();
        Cursor c;
        c = db.query(TABLE_NAME,
                COLUMNS,
                "id = ?",
                new String[]{String.valueOf(id)},
                null,
                null,
                null,
                null);
        if (c.moveToFirst()) {
            e = new Marque();
            e.setId(c.getInt(0));
            e.setCode(c.getString(1));
            e.setLibelle(c.getString(2));
        }
        db.close();
        return e;
    }

    public void delete(Marque e) {
        SQLiteDatabase db = this.helper.getWritableDatabase();
        db.delete(TABLE_NAME,
                "id = ?",
                new String[]{String.valueOf(e.getId())});
        db.close();
    }

    public List<Marque> findAll() {
        List<Marque> eds = new ArrayList<>();
        String req = "select * from " + TABLE_NAME;
        SQLiteDatabase db = this.helper.getReadableDatabase();
        Cursor c = db.rawQuery(req, null);
        Marque e = null;
        if (c.moveToFirst()) {
            do {
                e = new Marque();
                e.setId(c.getInt(0));
                e.setCode(c.getString(1));
                e.setLibelle(c.getString(2));
                eds.add(e);
                Log.d("id = ", e.getId() + "");
            } while (c.moveToNext());
        }
        return eds;
    }
}



