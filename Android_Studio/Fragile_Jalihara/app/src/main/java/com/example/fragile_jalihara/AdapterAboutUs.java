package com.example.fragile_jalihara;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class AdapterAboutUs extends FragmentStateAdapter {
    public AdapterAboutUs(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        Fragment fragment = new aboutUsFragment();
        Bundle args = new Bundle();
        if ((position+1) == 1){
            args.putString(aboutUsFragment.TITLE, "About Us");
        } else {
            args.putString(aboutUsFragment.TITLE, "Contact Us");
        }
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
