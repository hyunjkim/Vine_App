package nyc.c4q.hyun.vine_app;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import nyc.c4q.hyun.vine_app.network.Record;

/**
 * Created by Hyun on 12/10/16.
 */
public class VineAdapter extends RecyclerView.Adapter<VineViewHolder> {

    private List<Record> recordList;

    public VineAdapter(List<Record> recordList) {
        this.recordList = recordList;
    }

    @Override
    public VineViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_vine,parent,false);
        return new VineViewHolder(view);
    }

    @Override
    public void onBindViewHolder(VineViewHolder holder, int position) {
        holder.setData(recordList.get(position));
    }

    @Override
    public int getItemCount() {
        return recordList.size();
    }
}
