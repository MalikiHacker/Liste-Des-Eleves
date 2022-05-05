package sn.ept.git.dic2.app1;

import android.content.Context;

import androidx.room.Room;

public class DbConnection {
    private Context ctx ;
    private static final String BD_NAME = "GRH-EPT";
    private EptDatabase db;
    private static DbConnection dbInstance;

    private DbConnection(Context ctx) {
        this.ctx = ctx;
        db = Room.databaseBuilder(ctx,
                EptDatabase.class, BD_NAME).build();
    }

    public EptDatabase getDb() {
        return db;
    }

    public static DbConnection getDbInstance(Context ctx) {
        if(dbInstance == null){
            dbInstance = new DbConnection(ctx);
        }
        return dbInstance;
    }
}
