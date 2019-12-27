package com.example.imageslider;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SlideAdapter extends PagerAdapter {
   Context context;
   LayoutInflater inflator;
   public int[] lst_images={
           R.drawable.img1,
           R.drawable.img2,
           R.drawable.img3,
           R.drawable.earth
   };
   public String[] lst_title={
           "Spacecraft 1",
           "Spacecraft 2",
           "Spacecraft 3",
           "Galaxy"

   };

   public String[] lst_description={
           "Description 1",
           "Description 2",
           "Description 3",
           "Description 4"
   };

   public int[] lst_backgroundcolor={
           Color.rgb(55,55,55),
   Color.rgb(239,85,85),
   Color.rgb(110,49,89),
   Color.rgb(1,188,212)
   };

   public SlideAdapter(Context context)
   {
       this.context=context;
   }
    @Override
    public int getCount() {
        return lst_title.length;
    }



    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return (view==(LinearLayout)o);
    }
    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
       inflator=(LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
       View view=inflator.inflate(R.layout.slide,container,false);
       LinearLayout layoutslide=view.findViewById(R.id.slidelinearlayout);
        ImageView imgslide=(ImageView)view.findViewById(R.id.slideimg);
        TextView txttitle=(TextView)view.findViewById(R.id.txttitle);
        TextView description=(TextView)view.findViewById(R.id.txtdescription);
        layoutslide.setBackgroundColor(lst_backgroundcolor[position]);
        imgslide.setImageResource(lst_images[position]);
        txttitle.setText(lst_title[position]);
        description.setText(lst_description[position]);
        container.addView(view);
        return view;
    }
    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
       container.removeView((LinearLayout)object);
    }


}
