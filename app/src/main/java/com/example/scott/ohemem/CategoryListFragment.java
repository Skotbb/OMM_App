package com.example.scott.ohemem;

import android.app.ListFragment;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.example.scott.ohemem.R;
import com.example.scott.ohemem.TechniqueListFragment;

import java.util.List;


public class CategoryListFragment extends Fragment {
    private static final String DEBUG_MESS = "CatFragment";

    private RecyclerView mCatRecyclerView;
    private CategoryAdapter mCategoryAdapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.category_content, container, false);

        mCatRecyclerView = (RecyclerView) view.findViewById(R.id.category_recycler_view);
        mCatRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        updateUI();

        return view;
    }

    private void updateUI(){
        TechniqueManager tMgr = TechniqueManager.getInstance();
        List<String> categories = tMgr.getCategories();

        if(mCategoryAdapter == null){
            mCategoryAdapter = new CategoryAdapter(categories);
            mCatRecyclerView.setAdapter(mCategoryAdapter);
        }else{
            mCategoryAdapter.notifyDataSetChanged();
        }
    }

    private class CategoryHolder extends RecyclerView.ViewHolder
    implements View.OnClickListener{
        private TextView mCategoryTitle;

        public CategoryHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);

            mCategoryTitle = (TextView) itemView.findViewById(R.id.list_item_label);
        }

        public void setCategoryTitle(String title){
            mCategoryTitle.setText(title);
        }

        @Override
        public void onClick(View v) {

        }
    }


    private class CategoryAdapter extends RecyclerView.Adapter<CategoryHolder>{
        private List<String> mCategories;

        public CategoryAdapter(List<String> categories){
            mCategories = categories;
        }

        @Override
        public CategoryHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater li = LayoutInflater.from(getActivity());
            View view = li.inflate(R.layout.list_item_category, parent, false);

            return new CategoryHolder(view);
        }

        @Override
        public void onBindViewHolder(CategoryHolder holder, int position) {
            String category = mCategories.get(position);
            holder.setCategoryTitle(category);
        }

        @Override
        public int getItemCount() {
            return mCategories.size();
        }
    }
}