package com.dvloop.hands.features.users.list;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.dvloop.hands.BaseFragment;
import com.dvloop.hands.R;
import com.dvloop.hands.custons.WaitDialog;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by rafaelzanin on 25/09/17.
 */

public class ListUserFragment extends BaseFragment implements ListUserView {


    @BindView(R.id.rvListUsers) RecyclerView rvListUsers;

    private ListUserPresenter presenter;
    private Context context;
    private WaitDialog waitDialog;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.fragment_list_users, container, false);
        initComponents(layout);
        this.context = getActivity();
        return layout;
    }

    private void initComponents(View view) {
        ButterKnife.bind(this, view);
        waitDialog = new WaitDialog(getActivity());

        ListUsersAdapter adapter = new ListUsersAdapter(context, new ArrayList<>());
        rvListUsers.setAdapter(adapter);
        LinearLayoutManager llm = new LinearLayoutManager(context);
        rvListUsers.setLayoutManager(llm);

        presenter = new ListUserPresenter();
        presenter.attachView(this);
        waitDialog.show();
        //Primeiro parametro é o limite de dados que desejo trazer na tela, podendo futuramente ser criado paginações, etc.
        presenter.getListUsers(50, getActivity());

    }

    @Override
    public void showListUsers(List<String> list) {
        waitDialog.dismiss();
        ListUsersAdapter adapter = new ListUsersAdapter(context, list);
        rvListUsers.setAdapter(adapter);
    }

    @Override
    public void showError(String message) {
        waitDialog.dismiss();
        Toast.makeText(context, message, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onDestroy() {
        presenter.dettachView();
        super.onDestroy();
    }
}
