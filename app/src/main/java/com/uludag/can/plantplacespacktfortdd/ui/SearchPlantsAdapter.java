package com.uludag.can.plantplacespacktfortdd.ui;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.uludag.can.plantplacespacktfortdd.R;
import com.uludag.can.plantplacespacktfortdd.dto.PlantDTO;

import java.util.List;

public class SearchPlantsAdapter extends RecyclerView.Adapter<SearchPlantsAdapter.ViewHolder> {

    private List<PlantDTO> mPlants;

    public SearchPlantsAdapter(List<PlantDTO> plants) {
        mPlants = plants;
    }

    @Override
    public SearchPlantsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View rootView = LayoutInflater.from(parent.getContext()).inflate(R.layout.plants_list_item, parent, false);
        return new ViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(SearchPlantsAdapter.ViewHolder holder, int position) {
        holder.tvPlantName.setText(mPlants.get(position).getCommon());
    }

    @Override
    public int getItemCount() {
        return mPlants.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView tvPlantName;

        public ViewHolder(View itemView) {
            super(itemView);
            tvPlantName = itemView.findViewById(R.id.tv_plant_name);
        }
    }
}
