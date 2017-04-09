package ru.furman.vkmessanger.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import ru.furman.vkmessanger.R;

/**
 * Created by Furman on 08.04.2017.
 */

public class MessagesFragment extends Fragment {

    private RecyclerView recyclerView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.messages_fragment,container,false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        Toolbar toolbar = (Toolbar) getActivity().findViewById(R.id.toolbar);
        toolbar.setTitle(getResources().getString(R.string.messages));
        super.onActivityCreated(savedInstanceState);

        recyclerView = (RecyclerView) getActivity().findViewById(R.id.my_recycler_view);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        String[] messages = {"edsad","dsadasd","e214124","edsad","dsadasd","e214124","edsad","dsadasd","e214124","edsad","dsadasd","e214124"};
        recyclerView.setAdapter(new MyAdapter(messages));
        recyclerView.addItemDecoration(new DividerItemDecoration(recyclerView.getContext(),
                layoutManager.getOrientation()));
    }

    public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>{

        private String[] messages;

        public class ViewHolder extends RecyclerView.ViewHolder{

            public ImageView statusIV;
            public TextView timeTV;
            public ImageView photoIV;
            public TextView nameTV;
            public TextView messageTV;
            public View view;

            public ViewHolder(LinearLayout linearLayout) {
                super(linearLayout);
                photoIV = (ImageView) linearLayout.findViewById(R.id.photoIV);
                nameTV = (TextView) linearLayout.findViewById(R.id.nameTV);
                messageTV = (TextView) linearLayout.findViewById(R.id.messageTv);
                view = linearLayout;
                timeTV = (TextView) linearLayout.findViewById(R.id.timeTV);
                statusIV = (ImageView) linearLayout.findViewById(R.id.statusIV);
            }
        }

        public MyAdapter(String[] messages) {
            super();
            this.messages = messages;
        }

        @Override
        public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new ViewHolder((LinearLayout) getActivity().getLayoutInflater().inflate(R.layout.dialog_item,parent,false));
        }

        @Override
        public void onBindViewHolder(MyAdapter.ViewHolder holder, int position) {
            holder.nameTV.setText(messages[position]);
            holder.timeTV.setText("24:34");
            if(position%2==1) holder.statusIV.setVisibility(View.GONE);
            holder.view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getActivity(),"1",Toast.LENGTH_SHORT).show();
                }
            });
        }

        @Override
        public int getItemCount() {
            return messages.length;
        }
    }
}
