package com.example.scott.ohemem;

import android.support.v4.app.Fragment;
import android.os.Bundle;

public class CategoryActivity extends SingleFragmentActivity {
    private static final String DEBUG_MESS = "CategoryActivity";

    @Override
    protected Fragment createFragment() {
        return new CategoryListFragment();
    }

}
