package nyc.c4q.hyun.vine_app.backend;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Hyun on 12/13/16.
 */
public class VineRecord {
    private static int liked;
    private static String username;
    private static String profileBackground;

    public VineRecord(int liked, String background, String userName) {
        this.liked = liked;
        this.profileBackground = background;
        this.username = userName;
    }

    public static VineRecord parse(JSONObject currentRecord) {
        try {
            int liked = currentRecord.getInt("liked");
            String background= currentRecord.getString("profileBackground");
            String userName = currentRecord.getString("username");
            return new VineRecord(liked,background,userName);

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return new VineRecord(liked,username,profileBackground);
    }
}
