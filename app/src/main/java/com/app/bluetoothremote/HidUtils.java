package com.app.bluetoothremote;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothDevice;
import android.os.ParcelUuid;

public class HidUtils {
    @SuppressLint("MissingPermission")
    public static boolean isProfileSupported(BluetoothDevice device) {
        // If a device reports itself as a HID Device, then it isn't a HID Host.
        ParcelUuid[] uuidArray = device.getUuids();
        if (uuidArray != null) {
            for (ParcelUuid uuid : uuidArray) {
                if (Constants.HID_UUID.equals(uuid) || Constants.HOGP_UUID.equals(uuid)) {
                    return false;
                }
            }
        }
        return true;
    }
}
