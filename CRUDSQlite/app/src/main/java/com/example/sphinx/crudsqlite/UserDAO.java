package com.example.sphinx.crudsqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    private OpenDB conexao;

    public UserDAO(Context ctx) {
        this.conexao = new OpenDB(ctx);
    }

    public int insertUser(Usuario usuario) {
        try {


            SQLiteDatabase db = conexao.getWritableDatabase();

            ContentValues valores = new ContentValues();
            valores.put("NOME", usuario.getNome());
            valores.put("CPF", usuario.getCpf());
            valores.put("TELEFONE", usuario.getTelefone());
            valores.put("EMAIL", usuario.getEmail());

            db.insert("USER", null, valores);
            db.close();

            return 1;
        } catch (Exception e) {
            return 0;
        }
    }


    public int updateUser(Usuario usuario) {
        try{
            SQLiteDatabase db = conexao.getWritableDatabase();

            ContentValues valores = new ContentValues();
            valores.put("NOME", usuario.getNome());
            valores.put("TELEFONE", usuario.getTelefone());
            valores.put("EMAIL", usuario.getEmail());
            valores.put("CPF", usuario.getCpf());

            db.update("USER", valores, "id=?", new String[]{String.valueOf(usuario.getId())});
            db.close();

            return 1;
        }catch (Exception e){
            return 0;
        }
    }

    public int deleteUser(Usuario idUser){

        try{
            SQLiteDatabase db = conexao.getWritableDatabase();

            db.delete("USER", "id=?", new String[]{String.valueOf(idUser)});
            db.close();
            return 1;
        }catch (Exception e){
            return 0;
        }

    }


    public List<Usuario> getAllUsers() {
        SQLiteDatabase db = conexao.getReadableDatabase();
        Cursor cursor = db.query("USER", new String[]{}, null, null, null, null, null);

        String nome, cpf, telefone, email;
        int id;

        List<Usuario> listaUsuario = new ArrayList<Usuario>();

        while (cursor.moveToNext()) {

            id = cursor.getInt(cursor.getColumnIndex("ID"));
            nome = cursor.getString(cursor.getColumnIndex("NOME"));
            cpf = cursor.getString(cursor.getColumnIndex("CPF"));
            telefone = cursor.getString(cursor.getColumnIndex("TELEFONE"));
            email = cursor.getString(cursor.getColumnIndex("EMAIL"));

            Usuario user = new Usuario(id, nome, cpf, telefone, email);

            listaUsuario.add(user);

        }

        db.close();

        return listaUsuario;

    }

    public Usuario userById(long id){
        try {
            SQLiteDatabase db = conexao.getReadableDatabase();
            Cursor cursor = db.query("USER", new String[]{"ID", "NOME", "CPF", "TELEFONE", "EMAIL"},
                    "ID = ?", new String[]{String.valueOf(id)}, null, null, null);

            Usuario usuario = null;

            while (cursor.moveToNext()) {
                usuario = new Usuario((int) cursor.getLong(cursor.getColumnIndex("ID")), cursor.getString(cursor.getColumnIndex("NOME")),
                        cursor.getString(cursor.getColumnIndex("TELEFONE")), cursor.getString(cursor.getColumnIndex("EMAIL")),
                        cursor.getString(cursor.getColumnIndex("CPF")));
            }

            db.close();

            return usuario;
        } catch (Exception e) {
            return null;
        }
    }

    public Usuario consulta(String dnome){
        SQLiteDatabase db = conexao.getReadableDatabase();
        String whereClause = "nome = ?";
        String[] whereArgs = new String[] {dnome};
        Cursor cursor = db.query("USER", new String[]{}, whereClause, whereArgs, null, null, null);
        String nome, cpf, telefone, email;
        int id;
        Usuario user = null;
        try {
            while (cursor.moveToNext()) {
                id = cursor.getInt(cursor.getColumnIndex("id"));
                nome = cursor.getString(cursor.getColumnIndex("nome"));
                cpf = cursor.getString(cursor.getColumnIndex("cpf"));
                telefone = cursor.getString(cursor.getColumnIndex("telefone"));
                email = cursor.getString(cursor.getColumnIndex("email"));

                user = new Usuario(id, nome, cpf, telefone, email);
                db.close();

                return user;
            }
        }catch (Exception e ){

        }
        return user;

    }

}
