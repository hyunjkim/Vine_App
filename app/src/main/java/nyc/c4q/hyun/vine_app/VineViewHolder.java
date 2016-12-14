package nyc.c4q.hyun.vine_app;

import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import nyc.c4q.hyun.vine_app.network.Record;

/**
 * Created by Hyun on 12/10/16.
 */
public class VineViewHolder extends RecyclerView.ViewHolder {

    private TextView usernameTV;
    private TextView likedTV;
    private LinearLayout textBox;

    public VineViewHolder(View itemView) {
        super(itemView);
        usernameTV = (TextView) itemView.findViewById(R.id.vineusername_TV);
        likedTV = (TextView) itemView.findViewById(R.id.vineliked_TV);
        textBox = (LinearLayout) itemView.findViewById(R.id.vinetextbox_background);
    }

    public void setData(Record record) {
        textBox.setBackground(Drawable.createFromPath(record.getProfileBackground()));
        usernameTV.setText(record.getUsername());
        likedTV.setText(record.getLiked());
    }
}
