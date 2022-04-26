package two.one.sqlitedrawer.util;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MySQLiteHelper extends SQLiteOpenHelper {

        private static final int DATABASE_VERSION = 1;

        private static final String DATABASE_NAME = "machines";

        private static final String CREATE_TABLE_MACHINE= "create table Machine(" +
                "id INTEGER primary key autoincrement," +
                "reference TEXT," +
                "marque TEXT" +
                ")";
        private static final String CREATE_TABLE_MARQUE= "create table Marque(" +
                "id INTEGER primary key autoincrement," +
                "code TEXT," +
                "libelle TEXT)";

    public MySQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(CREATE_TABLE_MACHINE);
            db.execSQL(CREATE_TABLE_MARQUE);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS Machine");
            db.execSQL("DROP TABLE IF EXISTS Marque");
            onCreate(db);
        }
    }


