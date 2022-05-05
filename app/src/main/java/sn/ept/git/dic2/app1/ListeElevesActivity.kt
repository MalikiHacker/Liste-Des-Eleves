package sn.ept.git.dic2.app1

import androidx.appcompat.app.AppCompatActivity
import sn.ept.git.dic2.app1.Eleve
import sn.ept.git.dic2.app1.EptDatabase
import android.os.Bundle
import sn.ept.git.dic2.app1.R
import sn.ept.git.dic2.app1.DbConnection
import sn.ept.git.dic2.app1.EleveAdapter
import android.content.Intent
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ListView
import sn.ept.git.dic2.app1.EditEleve
import sn.ept.git.dic2.app1.ListeElevesActivity
import android.widget.Toast

class ListeElevesActivity : AppCompatActivity() {
    private var ajoutEleve: Button? = null
    private var listElevesView: ListView? = null
    private var eleves: List<Eleve>? = null
    private var db: EptDatabase? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_liste_eleves)
        db = DbConnection.getDbInstance(applicationContext).db

        //eleves = new ArrayList<>();
        //loadEleves.start();
        ajoutEleve = findViewById(R.id.addEleve)
        listElevesView = findViewById(R.id.elevesListView)
        listElevesView.setAdapter(EleveAdapter(eleves, applicationContext))
        Thread {
            eleves = db.EleveDao().all
            listElevesView.post(Runnable {
                val adapter = listElevesView.getAdapter() as EleveAdapter
                adapter.setEleves(eleves)
            })
        }.start()
        ajoutEleve.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@ListeElevesActivity, EditEleve::class.java)
            //startActivity(intent);
            startActivityForResult(intent, REQUEST_EDIT)
        })
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_EDIT) {
            if (resultCode == EditEleve.EDIT_OK) {
                val e = data!!.getSerializableExtra("eleve") as Eleve?
                Thread {
                    db!!.EleveDao().insertAll(e)
                    eleves = db!!.EleveDao().all
                    listElevesView!!.post {
                        val adapter = listElevesView!!.adapter as EleveAdapter
                        adapter.setEleves(eleves)
                    }
                }.start()

                //eleves.add(e);
                //EleveAdapter adapter= (EleveAdapter) listElevesView.getAdapter();
                //adapter.notifyDataSetChanged();
                val message = "Ajout dans la liste des élèves $e"
                Log.i("DIC2_GIT", message)
                Toast.makeText(applicationContext, message, Toast.LENGTH_LONG).show()
            } else if (resultCode == EditEleve.EDIT_CANCEL) {
                Log.i("DIC2_GIT", "Saisie annulée !")
            } else {
                Log.i("DIC2_GIT", "CODE INCOMPRIS !")
            }
        }
    }

    companion object {
        const val REQUEST_EDIT = 0
    }
}