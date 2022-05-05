package sn.ept.git.dic2.app1;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface EleveDao {
    @Query("SELECT * FROM eleve")
    List<Eleve> getAll();

    @Query("SELECT * FROM eleve WHERE id IN (:eleveIds)")
    List<Eleve> loadAllByIds(int[] eleveIds);

    @Query("SELECT * FROM eleve WHERE prenom LIKE :prenom AND nom LIKE :nom ")
    List<Eleve> findByName(String prenom, String nom);

    @Insert
    void insertAll(Eleve... eleves);

    @Delete
    void delete(Eleve eleve);
}