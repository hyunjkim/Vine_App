package nyc.c4q.hyun.vine_app;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import nyc.c4q.hyun.vine_app.network.Record;

/**
 * Created by Hyun on 12/10/16.
 */
public class VineViewHolder extends RecyclerView.ViewHolder {

    private TextView usernameTV;

    public VineViewHolder(View itemView) {
        super(itemView);
        usernameTV = (TextView) itemView.findViewById(R.id.vineusername_TV);
    }

    public void setData(Record record) {
        usernameTV.setText(record.getUsername());
    }
}
