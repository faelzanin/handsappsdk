package com.dvloop.hands.features.users.detail;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.dvloop.hands.BaseFragment;
import com.dvloop.hands.R;
import com.dvloop.hands.custons.WaitDialog;
import com.dvloop.hands.features.users.list.ListUserPresenter;
import com.dvloop.hands.features.users.list.ListUserView;
import com.dvloop.hands.features.users.list.ListUsersAdapter;
import com.dvloop.sdk.models.domain.User;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by rafaelzanin on 25/09/17.
 */

public class DetailUserFragment extends BaseFragment implements DetailUserView {

    private DetailUserPresenter presenter;
    private Context context;
    private User user;
    private WaitDialog waitDialog;

    @BindView(R.id.tvDeviceModel)
    TextView tvDeviceModel;

    @BindView(R.id.tvOSAndOSVersion)
    TextView tvOSAndOSVersion;

    @BindView(R.id.tvPercentBattery)
    TextView tvPercentBattery;

    @BindView(R.id.tvAddress)
    TextView tvAddress;

    @BindView(R.id.tvCityState)
    TextView tvCityState;

    @BindView(R.id.tvCountry)
    TextView tvCountry;

    @BindView(R.id.mvHouse)
    MapView mvHouse;

    private GoogleMap gMap;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.fragment_detail_user, container, false);
        initComponents(layout);
        mvHouse.onCreate(savedInstanceState);

        this.context = getActivity();
        return layout;
    }

    private void initComponents(View view) {
        ButterKnife.bind(this, view);
        waitDialog = new WaitDialog(getActivity());

        presenter = new DetailUserPresenter();
        presenter.attachView(this);

        waitDialog.show();
        String userId = getActivity().getIntent().getExtras().get("USER_ID").toString();
        presenter.getUser(userId, context);

    }

    public void loadMap() {

        if (mvHouse != null) {
            mvHouse.getMapAsync(new OnMapReadyCallback() {
                @Override
                public void onMapReady(GoogleMap googleMap) {
                    gMap = googleMap;

                    String[] latLonHomeSplited = user.getHome().split(" ");
                    LatLng latLngHome = new LatLng(0,0);

                    if(latLonHomeSplited.length >= 2) {
                        String latHome = latLonHomeSplited[0];
                        String lonHome = latLonHomeSplited[1];
                        latLngHome = new LatLng(Float.parseFloat(latHome), Float.parseFloat(lonHome));

                        gMap.addMarker(new MarkerOptions()
                                .icon(BitmapDescriptorFactory.fromResource(R.drawable.marker24))
                                .anchor(0.0f, 1.0f)
                                .title(context.getResources().getString(R.string.st_home))
                                .position(latLngHome));
                    }

                    String[] latLonWorkSplited = user.getHome().split(" ");
                    if(latLonWorkSplited.length >= 2) {
                        String latWork = latLonWorkSplited[0];
                        String lonWork = latLonWorkSplited[1];
                        LatLng latLngWork = new LatLng(Float.parseFloat(latWork), Float.parseFloat(lonWork));

                        gMap.addMarker(new MarkerOptions()
                                .icon(BitmapDescriptorFactory.fromResource(R.drawable.marker24))
                                .anchor(0.0f, 1.0f)
                                .title(context.getResources().getString(R.string.st_work))
                                .position(latLngWork));
                    }

                    gMap.getUiSettings().setMyLocationButtonEnabled(false);


                    if (ActivityCompat.checkSelfPermission(getActivity(), android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getActivity(), android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {


                        ActivityCompat.requestPermissions(getActivity(),
                                new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION},
                                100);


                    } else {

                        gMap.setMyLocationEnabled(true);
                        gMap.getUiSettings().setZoomControlsEnabled(true);
                        MapsInitializer.initialize(context);
                        LatLngBounds.Builder builder = new LatLngBounds.Builder();
                        builder.include(latLngHome);
                        LatLngBounds bounds = builder.build();
                        int padding = 0;
                        // Updates the location and zoom of the MapView
                        CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngBounds(bounds, padding);
                        gMap.moveCamera(cameraUpdate);

                    }

                }
            });
        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

    }

    @Override
    public void showUser(User user) {
        waitDialog.dismiss();

        this.user = user;
        tvDeviceModel.setText(user.getDeviceModel());
        tvAddress.setText(user.getAddress());
        tvOSAndOSVersion.setText(user.getOs() + " - " + user.getOsVersion());
        tvPercentBattery.setText(user.getBatteryPercentage() + "%");
        tvCityState.setText(user.getCity() + " / " +user.getState());
        tvCountry.setText(user.getCountry());


        loadMap();
    }

    @Override
    public void showError(String message) {
        waitDialog.dismiss();
        Toast.makeText(context, message, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onDestroy() {
        presenter.dettachView();
        mvHouse.onDestroy();
        super.onDestroy();
    }

    @Override
    public void onResume() {
        super.onResume();
        mvHouse.onResume();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mvHouse.onLowMemory();
    }

    @Override
    public void onPause() {
        super.onPause();
        mvHouse.onPause();
    }
}
