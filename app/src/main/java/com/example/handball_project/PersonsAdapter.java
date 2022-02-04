package com.example.handball_project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class PersonsAdapter extends RecyclerView.Adapter<PersonsAdapter.PersonViewHolder>{

    private Context mCtx;
    private List<Person> personList;

    public PersonsAdapter(Context mCtx, List<Person> personList) {
        this.mCtx = mCtx;
        this.personList = personList;
    }

    @NonNull
    @Override
    public PersonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PersonViewHolder(
                LayoutInflater.from(mCtx).inflate(R.layout.activity_persons_adapter, parent, false)
        );
    }

    @Override
    public void onBindViewHolder(@NonNull PersonViewHolder holder, int position) {
        Person person = personList.get(position);

        holder.textViewName.setText(person.getName());
        holder.textViewSurname.setText(person.getSurname());
        holder.textViewNumber.setText(person.getNumber());
        holder.textViewDate.setText( person.getDate());

    }

    @Override
    public int getItemCount() {
        return personList.size();
    }

    class PersonViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView textViewName, textViewSurname, textViewNumber, textViewDate;

        public PersonViewHolder(View itemView) {
            super(itemView);

            textViewName = itemView.findViewById(R.id.textview_name);
            textViewSurname = itemView.findViewById(R.id.textview_surname);
            textViewNumber = itemView.findViewById(R.id.textview_number);
            textViewDate = itemView.findViewById(R.id.textview_date);


            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            Person person = personList.get(getAdapterPosition());
            Intent intent = new Intent(mCtx, UpdatePersonActivity.class);
            intent.putExtra("eyll", person);
            mCtx.startActivity(intent);
        }
    }


}
