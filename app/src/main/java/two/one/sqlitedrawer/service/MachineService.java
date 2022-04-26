package two.one.sqlitedrawer.service;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import two.one.sqlitedrawer.classes.Machine;
import two.one.sqlitedrawer.util.MySQLiteHelper;


public class MachineService {

    private static final String TABLE_NAME = "Machine";
    private static final String KEY_ID = "id";
    private static final String KEY_REFERENCE = "reference";
    private static final String KEY_MARQUE = "marque";
    private MarqueService marqueService;

    private static String[] COLUMNS = {KEY_ID, KEY_REFERENCE, KEY_MARQUE};

    private MySQLiteHelper helper;

    public MachineService(Context context) {
        this.helper = new MySQLiteHelper(context);
    }

    public MachineService() {

    }

    public void create(Machine e) {
        SQLiteDatabase db = this.helper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_REFERENCE, e.getReference());
        values.put(KEY_MARQUE, e.getMarque());

        db.insert(TABLE_NAME,
                null,
                values);
        db.close();
    }

    public void update(Machine e) {
        SQLiteDatabase db = this.helper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_ID, e.getId());
        values.put(KEY_REFERENCE, e.getReference());
        values.put(KEY_MARQUE, e.getMarque());

        db.update(TABLE_NAME,
                values,
                "id = ?",
                new String[]{e.getId() + ""});
        db.close();
    }

    public Machine findById(int id) {
        marqueService = new MarqueService();
        Machine e = null;
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
            e = new Machine();
            e.setId(c.getInt(0));
            e.setReference(c.getString(1));
            e.setMarque(c.getString(2));
        }
        db.close();
        return e;
    }

    public void delete(Machine e) {
        SQLiteDatabase db = this.helper.getWritableDatabase();
        db.delete(TABLE_NAME,
                "id = ?",
                new String[]{String.valueOf(e.getId())});
        db.close();
    }

    public List<Machine> findAll() {
        List<Machine> eds = new ArrayList<>();
        String req = "select * from " + TABLE_NAME;
        SQLiteDatabase db = this.helper.getReadableDatabase();
        Cursor c = db.rawQuery(req, null);
        Machine e = null;
        if (c.moveToFirst()) {
            do {
                e = new Machine();
                e.setId(c.getInt(0));
                e.setReference(c.getString(1));
                e.setMarque(c.getString(2));
                eds.add(e);
                Log.d("id = ", e.getId() + "");
            } while (c.moveToNext());
        }
        return eds;
    }

    public HashMap<String, Integer> machinesByMarque() {
        HashMap<String, Integer> stats = new HashMap<>();
        // 1. build the query
        String query = "SELECT libelle, count(*) FROM machine INNER JOIN marque" +
                " on marque.libelle = machine.marque group by machine.marque";
        // 2. get reference to writable DB
        SQLiteDatabase db = this.helper.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        // 3. go over each row
        if (cursor.moveToFirst()) {
            do {
                stats.put(cursor.getString(0), cursor.getInt(1));

            } while (cursor.moveToNext());
        }
        return stats;
    }
}



