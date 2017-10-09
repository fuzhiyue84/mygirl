package hr.fuzhiyue.com.meinvshare;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.List;

import hr.fuzhiyue.com.meinvshare.model.GirlResult;

/**
 * Created by dell on 2017-09-25.
 */

public class GirlAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<GirlResult.GirlEntity> datas;
    private Context context;

    public GirlAdapter(Context context, List<GirlResult.GirlEntity> datas){
        this.context = context;
        this.datas = datas;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_layout, parent, false);
        GirlViewHolder girlViewHolder = new GirlViewHolder(view);
        return girlViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Picasso.with(context).load(datas.get(position).getUrl()).into(((GirlViewHolder)holder).iv);
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    class GirlViewHolder extends RecyclerView.ViewHolder{

        private ImageView iv;
        public GirlViewHolder(View view){
            super(view);
            iv = (ImageView) view.findViewById(R.id.girl_img);
        }

    }
}
