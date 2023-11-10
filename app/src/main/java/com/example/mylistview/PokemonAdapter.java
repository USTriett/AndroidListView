package com.example.mylistview;

import android.app.Activity;
import android.database.DataSetObserver;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;


public class PokemonAdapter implements ExpandableListAdapter {
    private ArrayList<PokeInfo> _pokemons;
    private Activity _activity;
    private LayoutInflater inflater;


//    private HashMap<PokeInfo, >

    @Override
    public void registerDataSetObserver(DataSetObserver observer) {

    }

    @Override
    public void unregisterDataSetObserver(DataSetObserver observer) {

    }

    @Override
    public int getGroupCount() {
        if(_pokemons != null)
            return _pokemons.size();
        return 0;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return 6;
    }

    @Override
    public Object getGroup(int groupPosition) {
        return _pokemons.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        switch (childPosition){
            case 0:
                return _pokemons.get(groupPosition).getBase().getHP();
            case 1:
                return _pokemons.get(groupPosition).getBase().getAttack();
            case 2:
                return _pokemons.get(groupPosition).getBase().getDefense();
            case 3:
                return _pokemons.get(groupPosition).getBase().getSpAttack();
            case 4:
                return _pokemons.get(groupPosition).getBase().getSpDefense();
            case 5:
                return _pokemons.get(groupPosition).getBase().getSpeed();
            default:
                return null;
        }
    }

    @Override
    public long getGroupId(int groupPosition) {

        return _pokemons.get(groupPosition).getId();
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.poke_list, null);
            viewHolder = new ViewHolder();
            viewHolder.imageView = convertView.findViewById(R.id.imageView);
            viewHolder.id = convertView.findViewById(R.id.pokeid);
            viewHolder.name = convertView.findViewById(R.id.pokename);
            viewHolder.firstType = convertView.findViewById(R.id.firstType);
            viewHolder.secondType = convertView.findViewById(R.id.secondType);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        PokeInfo pokeInfo = this._pokemons.get(groupPosition);

//        Bitmap bitmap = BitmapFactory.decodeResource(_activity.getResources(), R.drawable.p001);
//        viewHolder.imageView.setImageBitmap(bitmap);
        SetPokeImage(pokeInfo, _activity, viewHolder);

        viewHolder.name.setText(pokeInfo.getName().getEnglish());
        viewHolder.id.setText(String.valueOf(pokeInfo.getId()));
        viewHolder.firstType.setText(pokeInfo.getType().get(0));
        if(pokeInfo.getType().size() > 1)
            viewHolder.secondType.setText(pokeInfo.getType().get(1));
        else{
            viewHolder.secondType.setText("");
        }
        return convertView;
    }

    class ChildViewHolder{
        TextView label;
        ProgressBar progressBar;
    }
    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        ChildViewHolder childViewHolder;

        if(convertView == null){
            convertView = inflater.inflate(R.layout.base_list, null);
            childViewHolder = new ChildViewHolder();
            childViewHolder.label = (TextView) convertView.findViewById(R.id.labelBase);
            childViewHolder.progressBar = (ProgressBar) convertView.findViewById(R.id.progressBase);
            convertView.setTag(childViewHolder);
        }else {
            childViewHolder = (ChildViewHolder) convertView.getTag();
        }
        PokeInfo pokeInfo = _pokemons.get(groupPosition);
        switch (childPosition){
            case 0:
                childViewHolder.label.setText("HP");
                childViewHolder.progressBar.setProgress(pokeInfo.getBase().getHP());
                break;
            case 1:
                childViewHolder.label.setText("ATTACK");
                childViewHolder.progressBar.setProgress(pokeInfo.getBase().getAttack());
                break;
            case 2:
                childViewHolder.label.setText("DEFENSE");
                childViewHolder.progressBar.setProgress(pokeInfo.getBase().getDefense());
                break;
            case 3:
                childViewHolder.label.setText("SP ATTACK");
                childViewHolder.progressBar.setProgress(pokeInfo.getBase().getSpAttack());
                break;
            case 4:
                childViewHolder.label.setText("SP DEFENSE");
                childViewHolder.progressBar.setProgress(pokeInfo.getBase().getSpDefense());
                break;
            case 5:
                childViewHolder.label.setText("SPEED");
                childViewHolder.progressBar.setProgress(pokeInfo.getBase().getSpeed());
                break;
            default:
                break;
        }


        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    @Override
    public boolean areAllItemsEnabled() {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return _pokemons == null;
    }

    @Override
    public void onGroupExpanded(int groupPosition) {

    }

    @Override
    public void onGroupCollapsed(int groupPosition) {

    }

    @Override
    public long getCombinedChildId(long groupId, long childId) {
        return 0;
    }

    @Override
    public long getCombinedGroupId(long groupId) {
        return 0;
    }


    class ViewHolder{
        ImageView imageView;
        TextView name, id, firstType, secondType;
    }
    PokemonAdapter(Activity activity, ArrayList<PokeInfo> pokemons){
        _pokemons = pokemons;
        _activity = activity;
        inflater = _activity.getLayoutInflater();

    }


//    @Override
//    public int getCount() {
//        return this._pokemons.size();
//    }
//
//    @Override
//    public Object getItem(int position) {
//        return this._pokemons.get(position);
//    }
//
//    @Override
//    public long getItemId(int position) {
//        return _pokemons.get(position).getId();
//    }
//
//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//        ViewHolder viewHolder;
//        if (convertView == null) {
//            convertView = inflater.inflate(R.layout.poke_list, null);
//            viewHolder = new ViewHolder();
//            viewHolder.imageView = convertView.findViewById(R.id.imageView);
//            viewHolder.id = convertView.findViewById(R.id.pokeid);
//            viewHolder.name = convertView.findViewById(R.id.pokename);
//            viewHolder.firstType = convertView.findViewById(R.id.firstType);
//            viewHolder.secondType = convertView.findViewById(R.id.secondType);
//            convertView.setTag(viewHolder);
//        } else {
//            viewHolder = (ViewHolder) convertView.getTag();
//        }
//
//        PokeInfo pokeInfo = this._pokemons.get(position);
//
////        Bitmap bitmap = BitmapFactory.decodeResource(_activity.getResources(), R.drawable.p001);
////        viewHolder.imageView.setImageBitmap(bitmap);
//        SetPokeImage(pokeInfo, _activity, viewHolder);
//
//        viewHolder.name.setText(pokeInfo.getName().getEnglish());
//        viewHolder.id.setText(String.valueOf(pokeInfo.getId()));
//        viewHolder.firstType.setText(pokeInfo.getType().get(0));
//        if(pokeInfo.getType().size() > 1)
//            viewHolder.secondType.setText(pokeInfo.getType().get(1));
//        else{
//            viewHolder.secondType.setText("");
//        }
//        return convertView;
//    }

    private void SetPokeImage(PokeInfo pokeInfo, Activity activity, ViewHolder viewHolder) {
        int id = pokeInfo.getId();
        String imgId = parseID(id);
        Log.d("Img Id", "SetPokeImage: " + imgId);
        int resId = activity.getResources().getIdentifier(imgId, "drawable", activity.getPackageName());

        if (resId != 0) {
            Bitmap bitmap = BitmapFactory.decodeResource(activity.getResources(), resId);
            viewHolder.imageView.setImageBitmap(bitmap);
        } else {
            Log.d("log", "SetPokeImage: Can not found " + resId);
        }
    }

    private String parseID(int id) {
        StringBuilder rs = new StringBuilder();
        while(id > 0){
            rs.insert(0, String.valueOf(id % 10));
            id/=10;
        }
        while(rs.length() < 3){
            rs.insert(0, String.valueOf(0));
        }
        return "p" + rs.toString();
    }


}
