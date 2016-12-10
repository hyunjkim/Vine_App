package nyc.c4q.hyun.vine_app.network;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Hyun on 12/10/16.
 */

public class Loops {

    @SerializedName("count")
    @Expose
    private Integer count;
    @SerializedName("velocity")
    @Expose
    private Integer velocity;
    @SerializedName("onFire")
    @Expose
    private Integer onFire;

    /**
     *
     * @return
     * The count
     */
    public Integer getCount() {
        return count;
    }

    /**
     *
     * @param count
     * The count
     */
    public void setCount(Integer count) {
        this.count = count;
    }

    /**
     *
     * @return
     * The velocity
     */
    public Integer getVelocity() {
        return velocity;
    }

    /**
     *
     * @param velocity
     * The velocity
     */
    public void setVelocity(Integer velocity) {
        this.velocity = velocity;
    }

    /**
     *
     * @return
     * The onFire
     */
    public Integer getOnFire() {
        return onFire;
    }

    /**
     *
     * @param onFire
     * The onFire
     */
    public void setOnFire(Integer onFire) {
        this.onFire = onFire;
    }

}