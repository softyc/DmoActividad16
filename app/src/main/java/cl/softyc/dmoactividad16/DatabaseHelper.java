package cl.softyc.dmoactividad16;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by felipecamposgonzalez on 17-11-15.
 */



public class DatabaseHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "pfrescos.db";

    //tabla Usuarios
    private static final String TABLE_NAME = "usuarios";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_USUARIO = "usuario";
    private static final String COLUMN_NOMBRE = "nombre";
    private static final String COLUMN_PASSWORD = "password";



    SQLiteDatabase db;
    private static final String TABLA_USUARIOS = "create table usuarios (id integer primary key not null , " +
            "usuario text not null , nombre text not null , password text not null);";



    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLA_USUARIOS);
        this.db = db;
    }

    public void insertUsuarios(Usuarios c) {
        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        String query = "select * from usuarios";
        Cursor cursor = db.rawQuery(query , null);
        int count = cursor.getCount();

        values.put(COLUMN_ID , count);
        values.put(COLUMN_NOMBRE, c.getNombre());
        values.put(COLUMN_USUARIO, c.getUsuario());
        values.put(COLUMN_PASSWORD, c.getPassword());


        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    public String searchPass(String usuario)
    {
        db = this.getReadableDatabase();
        String query = "select usuario, password from "+TABLE_NAME;
        Cursor cursor = db.rawQuery(query , null);
        String a, b;
        b = "No existe Usuario";
        if(cursor.moveToFirst())
        {
            do{
                a = cursor.getString(0);

                if(a.equals(usuario))
                {
                    b = cursor.getString(1);
                    break;
                }
            }
            while(cursor.moveToNext());
        }

        return b;
    }





    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String query = "Borra tabla si existe "+TABLE_NAME;
        db.execSQL(query);
        this.onCreate(db);
    }
}
