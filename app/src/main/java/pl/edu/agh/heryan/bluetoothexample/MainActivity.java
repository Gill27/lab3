package pl.edu.agh.heryan.bluetoothexample;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    private final BluetoothAdapter bAdapter = BluetoothAdapter.getDefaultAdapter();
    private ListView pairedDevicesList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.buttonON).setOnClickListener(v -> turnBluetoothOn());
        findViewById(R.id.buttonOFF).setOnClickListener(v-> turnBluetoothOff());
        findViewById(R.id.buttonDiscoverable).setOnClickListener(n->makeDiscoverable());
        findViewById(R.id.buttonList).setOnClickListener(n->listDevices());
        pairedDevicesList = findViewById(R.id.listViewPairedDevices);
    }

    private void turnBluetoothOn(){

    }

    private void turnBluetoothOff(){
    }

    private void makeDiscoverable(){
    }

    private void listDevices(){
    }
}