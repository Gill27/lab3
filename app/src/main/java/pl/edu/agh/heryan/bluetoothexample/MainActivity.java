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

    private final BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
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

    private void turnBluetoothOn() {
        if (bluetoothAdapter != null) {
            if (!bluetoothAdapter.isEnabled()) {
                bluetoothAdapter.enable();
                showToast("Bluetooth is now enabled");
            } else {
                showToast("Bluetooth is already enabled");
            }
        } else {
            showToast("Bluetooth is not supported on this device");
        }
    }

    private void turnBluetoothOff() {
        if (bluetoothAdapter != null) {
            if (bluetoothAdapter.isEnabled()) {
                bluetoothAdapter.disable();
                showToast("Bluetooth is now disabled");
            } else {
                showToast("Bluetooth is already disabled");
            }
        }
    }

    private void makeDiscoverable() {
        if (bluetoothAdapter != null) {
            Intent discoverableIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE);
            discoverableIntent.putExtra(BluetoothAdapter.EXTRA_DISCOVERABLE_DURATION, 300); // Set discoverable duration in seconds
            startActivity(discoverableIntent);
        }
    }

    private void listDevices() {
        if (bluetoothAdapter != null) {
            Set<BluetoothDevice> pairedDevices = bluetoothAdapter.getBondedDevices();
            List<String> deviceList = new ArrayList<>();

            for (BluetoothDevice device : pairedDevices) {
                String deviceInfo = device.getName() + "\n" + device.getAddress();
                deviceList.add(deviceInfo);
            }

            ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, deviceList);
            pairedDevicesList.setAdapter(adapter);
        }
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}