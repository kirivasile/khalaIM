package com.github.kirivasile.khala_im.menu;

import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.github.kirivasile.khala_im.R;
import com.github.kirivasile.khala_im.authorization.LoginActivity;
import com.github.kirivasile.khala_im.chats.view.ChatsFragment;
import com.github.kirivasile.khala_im.contacts.view.ContactsFragment;

public class MenuActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener{
    private Toolbar mToolBar;
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;
    private NavigationView mNavigationView;

    private Fragment mChatFragment;
    private Fragment mContactsFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        try {
            manageToolBar();
            // TODO: Заменить заглушки
            initNavigation("Artanis", "artanis@protoss.com");
        } catch (Exception e) {
            Log.e("MENU", "Failed to set up menu: " + e.toString());
        }
    }

    private void manageToolBar() {
        mToolBar = (Toolbar)findViewById(R.id.toolBar);
        mToolBar.setTitleTextColor(Color.WHITE);
        mToolBar.setNavigationIcon(R.drawable.ic_arrow_back_white_24dp);
        setSupportActionBar(mToolBar);
    }

    private void initNavigation(String nickName, String email) {
        mDrawerLayout = (DrawerLayout)findViewById(R.id.navDrawerLayout);
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, mToolBar,
                R.string.OpenDrawer, R.string.CloseDrawer);
        mDrawerLayout.addDrawerListener(mDrawerToggle);
        mDrawerToggle.syncState();

        mNavigationView = (NavigationView)findViewById(R.id.navView);
        mNavigationView.setNavigationItemSelectedListener(this);

        View hView = mNavigationView.getHeaderView(0);
        TextView userNameTV = (TextView)hView.findViewById(R.id.navHeaderUserName);
        TextView userEmailTV = (TextView)hView.findViewById(R.id.navHeaderUserEmail);

        userNameTV.setText(nickName);
        userEmailTV.setText(email);

        mNavigationView.getMenu().getItem(0).setChecked(true);

        if (mChatFragment == null) {
            mChatFragment = new ChatsFragment();
        }
        replaceFragment(mChatFragment);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()) {
            case R.id.navChats:
                if (mChatFragment == null) {
                    mChatFragment = new ChatsFragment();
                }
                replaceFragment(mChatFragment);
                break;
            case R.id.navContacts:
                if (mContactsFragment == null) {
                    mContactsFragment = new ContactsFragment();
                }
                replaceFragment(mContactsFragment);
                break;
            case R.id.navLogout:
                Intent logoutIntent = new Intent(this, LoginActivity.class);
                startActivity(logoutIntent);
                finish();
                break;
            default:
        }
        mDrawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    private void replaceFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out)
                .replace(R.id.frameContainer, fragment)
                .commit();
    }
}
