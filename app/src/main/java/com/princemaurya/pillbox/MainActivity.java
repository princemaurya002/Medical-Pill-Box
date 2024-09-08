package com.princemaurya.pillbox;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Set;
import java.util.UUID;

public class MainActivity extends AppCompatActivity {

    private BluetoothAdapter btAdapter = null;
    private BluetoothSocket btSocket = null;
    private OutputStream outputStream = null;
    private BluetoothDevice btDevice;
    private static final UUID uuid = UUID.fromString("00001101-0000-1000-8000-00805F9B34FB"); // Standard UUID for HC-05 module
    private static String address = ""; // Replace with your HC-05 module MAC address
    private static final int REQUEST_BLUETOOTH_PERMISSION = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Set the status bar color
        Window window = getWindow();
        window.setStatusBarColor(ContextCompat.getColor(this, R.color.acid_green));


        btAdapter = BluetoothAdapter.getDefaultAdapter();
        if (btAdapter == null) {
            // Device doesn't support Bluetooth
            Toast.makeText(this, "Bluetooth not supported", Toast.LENGTH_SHORT).show();
            finish();
            return;
        }
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.BLUETOOTH) != PackageManager.PERMISSION_GRANTED) {
            // Bluetooth permission not granted, request it
            ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.BLUETOOTH}, REQUEST_BLUETOOTH_PERMISSION);
        } else {

            btAdapter=BluetoothAdapter.getDefaultAdapter();
            Set<BluetoothDevice> pairedDevices = btAdapter.getBondedDevices();
            for(BluetoothDevice device :pairedDevices){
                System.out.println("Name->"+device.getName()+"   "+ "MAC->"+device.getAddress());
                if(device.getName().equals("HC-05")){
                    address=device.getAddress();
                    System.out.println("MAC->"+address);
                }
            }

            btAdapter=BluetoothAdapter.getDefaultAdapter();
            btDevice=btAdapter.getRemoteDevice(address);

            // Bluetooth permission granted, proceed with Bluetooth connection
            new Thread(new Runnable() {
                @Override
                public void run() {
                    if(ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.BLUETOOTH_CONNECT)!= PackageManager.PERMISSION_DENIED){
                        if(Build.VERSION.SDK_INT>31){
                            ActivityCompat.requestPermissions(MainActivity.this,new String[]{Manifest.permission.BLUETOOTH_CONNECT},100);
                            return;
                        }
                    }

                    try {
                        btSocket=btDevice.createInsecureRfcommSocketToServiceRecord(uuid);
                        btAdapter.cancelDiscovery();
                        btSocket.connect();
                        outputStream=btSocket.getOutputStream();
                        Log.d("Message","Connect to HC-05");
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(MainActivity.this, "Bluetooth successfully connected", Toast.LENGTH_LONG).show();

                                Intent i=new Intent(getApplicationContext(), chooseMedicineForTime.class);
                                startActivity(i);
                            }
                        });
                    } catch (IOException e) {
                        Log.d("Message", "Turn on bluetooth and restart the app");
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(MainActivity.this, "Turn on bluetooth and restart the app", Toast.LENGTH_SHORT).show();
                            }
                        });
                        throw new RuntimeException(e);
                    }
                }


            }).start();

        }

    }

}