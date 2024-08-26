package com.app.bluetoothremote;

import android.annotation.SuppressLint;

public class MouseHelper {

    @SuppressLint("MissingPermission")
    public static boolean sendData(boolean left, boolean right, boolean middle, int x, int y, int wheel) {
        if (BluetoothHidService.bluetoothHidDevice != null && BluetoothHidService.isHidDeviceConnected) {
            return BluetoothHidService.bluetoothHidDevice.sendReport(BluetoothHidService.bluetoothDevice, Constants.ID_MOUSE, MouseReport.getReport(left, right, middle, x, y, wheel));
        }
        return false;
    }
}
