package com.merrily01.recyclerviewdemo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;


/**
 * Author: https://github.com/merrily01
 * Email:  merrily01@gmail.com
 * Date:   2017/1/10
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    Context context;
    int pokemonsList[] = {R.drawable.p1, R.drawable.p18, R.drawable.p3,
            R.drawable.p4, R.drawable.p6, R.drawable.p7,
            R.drawable.p8, R.drawable.p9, R.drawable.p10, R.drawable.p11,
            R.drawable.p12, R.drawable.p13,R.drawable.p14,R.drawable.p15,
            R.drawable.p16,R.drawable.p17,R.drawable.p18,R.drawable.p19,
            R.drawable.p20,R.drawable.p21};

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

//        /**
//         * 添加item
//         * @param position
//         */
//        public void addItem(int position) {
//            list.add(position,"AAAAA");
//            notifyItemInserted(position);
//        }
//
//        /**
//         * 删除item
//         * @param position
//         */
//        public void removeItem(int position) {
//            list.remove(position);
//            notifyItemRemoved(position);
//        }
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
        final ViewHolder viewHolder = new ViewHolder(view);
        viewHolder.pokemon_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = viewHolder.getAdapterPosition();
                Toast.makeText(v.getContext(), "ShortClick Picture NO." + position,Toast.LENGTH_SHORT).show();
            }
        });
        viewHolder.pokemon_name.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                int position = viewHolder.getAdapterPosition();
                Toast.makeText(v.getContext(), "LongClick Name NO." + position, Toast.LENGTH_LONG).show();
                return true;
            }
        });
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
        return 30;
    }
}
