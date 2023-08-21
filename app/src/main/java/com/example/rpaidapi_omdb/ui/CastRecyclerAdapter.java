package com.example.rpaidapi_omdb.ui;
import com.example.rpaidapi_omdb.Model.Principal;
import com.example.rpaidapi_omdb.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CastRecyclerAdapter extends RecyclerView.Adapter<CastViewHolder>{
    Context context;
    List<Principal> principalList;

    public CastRecyclerAdapter(Context context, List<Principal> principalList) {
        this.context = context;
        this.principalList = principalList;
    }

    @NonNull
    @Override
    public CastViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CastViewHolder(LayoutInflater.from(context).inflate(R.layout.cast_list,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull CastViewHolder holder, int position) {
        holder.actor.setText(principalList.get(position).getName());
        List<String> characters = principalList.get(position).getCharacters();
        StringBuilder characterString = new StringBuilder();

        for (int i = 0; i < characters.size(); i++) {
            characterString.append(characters.get(i));

            if (i < characters.size() - 1) {
                characterString.append(", "); // Add comma and space except for the last character
            }
        }

        holder.character.setText(characterString.toString());


    }

    @Override
    public int getItemCount() {
        return principalList.size();
    }
}


class CastViewHolder extends RecyclerView.ViewHolder {
    TextView actor,character;

    public CastViewHolder(@NonNull View itemView) {
        super(itemView);
        actor=itemView.findViewById(R.id.textView_actor);
        character=itemView.findViewById(R.id.textView_character);
    }
}