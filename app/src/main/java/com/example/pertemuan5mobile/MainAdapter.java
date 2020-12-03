package com.example.pertemuan5mobile;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class MainAdapter extends FragmentPagerAdapter {
    public MainAdapter(FragmentManager fm, int tabCount) {
        super(fm, MainAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position)
        {
            case 0:
                return new ListsFragment(); //ChildFragment1 at position 0
            case 1:
                return new ProfileFragment(); //ChildFragment2 at position 1

        }
        return null; //does not happen
    }

    @Override
    public int getCount() {
        return 2; //three fragments
    }
}