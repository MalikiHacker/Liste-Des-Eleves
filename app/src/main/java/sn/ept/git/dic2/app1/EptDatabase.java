package sn.ept.git.dic2.app1;

import androidx.room.Database;
import androidx.room.RoomDatabase;


@Database(entities = {Eleve.class}, version = 1)
public abstract class EptDatabase extends RoomDatabase {
    public abstract EleveDao EleveDao();
}
