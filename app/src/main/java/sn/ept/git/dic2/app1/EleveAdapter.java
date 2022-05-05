package sn.ept.git.dic2.app1;

import static sn.ept.git.dic2.app1.R.color.black;
import static sn.ept.git.dic2.app1.R.color.purple_700;
import static sn.ept.git.dic2.app1.R.color.white;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class EleveAdapter extends BaseAdapter {
    private List<Eleve> eleves;
    private Context ctx;


    public EleveAdapter(List<Eleve> eleves, Context ctx) {
        this.ctx = ctx;
        setEleves(eleves);
    }

    public final void setEleves(List<Eleve> eleves) {
        if(eleves == null){
            this.eleves = new ArrayList<>();
        }else{
            this.eleves = eleves;
        }
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return eleves.size();
    }

    @Override
    public Object getItem(int position) {
        return eleves.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(ctx).inflate(R.layout.eleve_item, parent, false);
        }
        TextView prenom = convertView.findViewById(R.id.prenomValue);
        TextView nom = convertView.findViewById(R.id.nomValue);
        TextView prenomlabel = convertView.findViewById(R.id.prenomLabel);
        TextView nomlabel = convertView.findViewById(R.id.nomLabel);
        Eleve e = (Eleve) getItem(position);
        prenom.setText(e.getPrenom());
        nom.setText(e.getNom());
        if (position % 2 == 0) {
            convertView.setBackgroundColor(ctx.getColor(purple_700));
            prenom.setTextColor(ctx.getColor(white));
            nom.setTextColor(ctx.getColor(white));
            prenomlabel.setTextColor(ctx.getColor(white));
            nomlabel.setTextColor(ctx.getColor(white));
        }else{
            convertView.setBackgroundColor(ctx.getColor(white));
            prenom.setTextColor(ctx.getColor(purple_700));
            nom.setTextColor(ctx.getColor(purple_700));
            prenomlabel.setTextColor(ctx.getColor(purple_700));
            nomlabel.setTextColor(ctx.getColor(purple_700));
        }

        return convertView;

    }
}
