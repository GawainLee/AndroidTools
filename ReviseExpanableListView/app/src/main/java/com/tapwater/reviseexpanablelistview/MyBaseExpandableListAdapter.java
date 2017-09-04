package com.tapwater.reviseexpanablelistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Tapwater on 16-11-23.
 */

public class MyBaseExpandableListAdapter extends BaseExpandableListAdapter {

    private Context context;
    private ArrayList<Group> arrayListGroup;
    private ArrayList<ArrayList<Item>> arrayListItem;

    public MyBaseExpandableListAdapter(ArrayList<Group> arrayListGroup, ArrayList<ArrayList<Item>> arrayListItem, Context context) {
        this.arrayListGroup = arrayListGroup;
        this.arrayListItem = arrayListItem;
        this.context = context;
    }

    @Override
    public int getGroupCount() {
        return arrayListGroup.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return arrayListItem.get(groupPosition).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return arrayListGroup.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return arrayListItem.get(groupPosition).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        ViewHolderGroup viewHolderGroup = null;
        if (convertView == null)
        {
            viewHolderGroup = new ViewHolderGroup();
            convertView = LayoutInflater.from(context).inflate(R.layout.item_expanlist_group,parent,false);
            viewHolderGroup.textViewGroup = (TextView) convertView.findViewById(R.id.textViewExpandGroup);
            convertView.setTag(viewHolderGroup);
        }
        else
        {
            viewHolderGroup = (ViewHolderGroup) convertView.getTag();
        }
        viewHolderGroup.textViewGroup.setText(arrayListGroup.get(groupPosition).getGroupName());
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        ViewHolderItem viewHolderItem = null;
        if (convertView == null)
        {
            viewHolderItem = new ViewHolderItem();
            convertView = LayoutInflater.from(context).inflate(R.layout.item_expand_item,parent,false);
            viewHolderItem.imageViewItem = (ImageView) convertView.findViewById(R.id.imageViewPlace);
            viewHolderItem.textViewItem = (TextView) convertView.findViewById(R.id.textViewPlace);
            convertView.setTag(viewHolderItem);
        }
        else
        {
            viewHolderItem = (ViewHolderItem) convertView.getTag();
        }
        viewHolderItem.imageViewItem.setBackgroundResource(arrayListItem.get(groupPosition).get(childPosition).getHeroHead());
        viewHolderItem.textViewItem.setText(arrayListItem.get(groupPosition).get(childPosition).getHeroName());
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    private static class ViewHolderGroup
    {
        TextView textViewGroup;
    }
    private static class ViewHolderItem
    {
        ImageView imageViewItem;
        TextView textViewItem;
    }
}
