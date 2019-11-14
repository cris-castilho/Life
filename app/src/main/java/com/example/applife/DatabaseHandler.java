package com.example.applife;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;
import java.util.List;


public class DatabaseHandler extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "AppLifeManager";
    private static final String TABLE_USUARIO = "usuario";
    private static final String KEY_ID = "id";
    private static final String KEY_NOME = "nome";
    private static final String KEY_SEXO = "sexo";
    private static final String KEY_EMAIL = "email";

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        //3rd argument to be passed is CursorFactory instance  
    }

    // Creating Tables  
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE = "CREATE TABLE " + TABLE_USUARIO + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NOME + " TEXT," + KEY_SEXO + " TEXT,"
                + KEY_EMAIL + " TEXT" + ")";
        db.execSQL(CREATE);
    }

    // Upgrading database  
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed  
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USUARIO);

        // Create tables again  
        onCreate(db);
    }

    // code to add the new contact  
    void addUsuario(Usuario usuario) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NOME, usuario.getNome());
        values.put(KEY_SEXO, usuario.getSexo());
        values.put(KEY_EMAIL, usuario.getEmail());

        // Inserting Row  
        db.insert(TABLE_USUARIO, null, values);
        //2nd argument is String containing nullColumnHack  
        db.close(); // Closing database connection  
    }

    // code to get the single contact  
    Usuario getUsuario(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_USUARIO, new String[] { KEY_ID,
                        KEY_NOME, KEY_SEXO, KEY_EMAIL }, KEY_ID + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        Usuario usuario = new Usuario(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1), cursor.getString(3), cursor.getString(2));
        // return contact  
        return usuario;
    }

    // code to get all contacts in a list view  
    public List<Usuario> getAllContacts() {
        List<Usuario> usuarioArrayList = new ArrayList<Usuario>();
        // Select All Query  
        String selectQuery = "SELECT  * FROM " + TABLE_USUARIO;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list  
        if (cursor.moveToFirst()) {
            do {
                Usuario contact = new Usuario();
                contact.setId(Integer.parseInt(cursor.getString(0)));
                contact.setNome(cursor.getString(1));
                contact.setSexo(cursor.getString(2));
                contact.setEmail(cursor.getString(3));
                // Adding contact to list  
                usuarioArrayList.add(contact);
            } while (cursor.moveToNext());
        }

        // return contact list  
        return usuarioArrayList;
    }

    public int updateUsuario(Usuario usuario) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NOME, usuario.getNome());
        values.put(KEY_SEXO, usuario.getSexo());
        values.put(KEY_EMAIL, usuario.getEmail());

        // updating row  
        return db.update(TABLE_USUARIO, values, KEY_ID + " = ?",
                new String[] { String.valueOf(usuario.getId()) });
    }

    public void deleteUsuario(Usuario usuario) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_USUARIO, KEY_ID + " = ?",
                new String[] { String.valueOf(usuario.getId()) });
        db.close();
    }

    public int getUsuariosCount() {
        String countQuery = "SELECT  * FROM " + TABLE_USUARIO;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();
        // return count  
        return cursor.getCount();
    }

}