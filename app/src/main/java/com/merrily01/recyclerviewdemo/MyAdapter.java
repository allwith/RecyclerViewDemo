package com.merrily01.recyclerviewdemo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * Author: https://github.com/merrily01
 * Email:  merrily01@gmail.com
 * Date:   2017/1/10
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    Context context;
    int pokemonsList[] = {R.drawable.img_bulbasaur, R.drawable.img_caterpie, R.drawable.img_charmander,
            R.drawable.img_fearow, R.drawable.img_nidoking, R.drawable.img_nidoqueen, R.drawable.img_oddish,
            R.drawable.img_p, R.drawable.img_rattata, R.drawable.img_sandslash, R.drawable.img_squirtle,
            R.drawable.img_vulpix, R.drawable.img_weedle};

    /**
     * 内部类ViewHolder
     */
    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView pokemon_img;
        TextView pokemon_name;

        public ViewHolder(View itemView) {
            super(itemView);
            pokemon_img = (ImageView) itemView.findViewById(R.id.pokemon_img);
            pokemon_name = (TextView) itemView.findViewById(R.id.pokemon_name);
        }

        public void setData(int position) {
            pokemon_img.setImageResource(pokemonsList[position % pokemonsList.length]);
            pokemon_name.setText("NO." + position);
        }
    }

    /**
     * 构造函数
     *
     * @param context
     */
    public MyAdapter(Context context) {
        this.context = context;
    }

    /**
     * 重写onCreateViewHolder方法，创建ViewHolder实例，并返回
     *
     * @param parent
     * @param viewType
     * @return
     */
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.pokemon_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    /**
     * 给子布局填充数据
     *
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.setData(position);
    }

    /**
     * 子项个数
     *
     * @return
     */
    @Override
    public int getItemCount() {
        return 50;
    }
}
