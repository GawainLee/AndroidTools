package com.tapwater.revisebaseadapterbugtext;

import android.content.Context;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;

import java.util.LinkedList;

/**
 * Created by Tapwater on 16-11-16.
 */

public class ListItemBaseAdapter extends BaseAdapter {

    private LinkedList<ListItem> listItems;
    private Context mContext;


    public ListItemBaseAdapter(LinkedList<ListItem> listItems, Context mContext) {
        this.listItems = listItems;
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return listItems.size();
    }

    @Override
    public Object getItem(int position) {
        return listItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHost viewHost = null;
        if (convertView == null)
        {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.list_item,parent,false);
            viewHost = new ViewHost();
            viewHost.imageViewHead = (ImageView) convertView.findViewById(R.id.imageViewPlace);
            viewHost.editText = (EditText) convertView.findViewById(R.id.editTextPlace);
            viewHost.checkBox = (CheckBox) convertView.findViewById(R.id.checkboxPlace);
            convertView.setTag(viewHost);
        }
        else
        {
            viewHost = (ViewHost)convertView.getTag();
        }

        final ListItem listItem = listItems.get(position);
        if (viewHost.editText.getTag() instanceof TextWatcher)
        {
            viewHost.editText.removeTextChangedListener((TextWatcher)(viewHost.editText.getTag()));
        }

        viewHost.editText.setHint(position + ".");

        if (TextUtils.isEmpty(listItem.getEditText()))
        {
            viewHost.editText.setText("");
        }
        else
        {
            viewHost.editText.setText(listItem.getEditText());
        }
        if (listItem.isFocus())
        {
            if (!viewHost.editText.isFocused())
            {
                viewHost.editText.requestFocus();
            }
            CharSequence text = listItem.getEditText();
            viewHost.editText.setSelection(TextUtils.isEmpty(text) ? 0 : text.length());
        }
        else
        {
            if (viewHost.editText.isFocused())
            {
                viewHost.editText.clearFocus();
            }
        }
        final ViewHost finalViewHost = viewHost;
        viewHost.editText.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_UP)
                {
                    final boolean focus = listItem.isFocus();
                    check(position);
                    if (!focus && !finalViewHost.editText.isFocused())
                    {
                        finalViewHost.editText.requestFocus();
                        finalViewHost.editText.onWindowFocusChanged(true);
                    }
                }
                return false;
            }
        });
        final TextWatcher textWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (TextUtils.isEmpty(s))
                {
                    listItem.setEditText(null);
                }
                else
                {
                    listItem.setEditText(String.valueOf(s));
                }
            }
        };
        viewHost.editText.addTextChangedListener(textWatcher);
        viewHost.editText.setTag(textWatcher);


        viewHost.imageViewHead.setBackgroundResource(listItems.get(position).getHead());
//        viewHost.editText.setText(listItems.get(position).getEditText());
        viewHost.checkBox.setChecked(listItems.get(position).isCheckBox());

        return convertView;
    }

    private void check(int position)
    {
        for (ListItem listItem : listItems)
        {
            listItem.setFocus(false);
        }
        listItems.get(position).setFocus(true);
    }

    static class ViewHost
    {
        ImageView imageViewHead;
        EditText editText;
        CheckBox checkBox;
    }
}
