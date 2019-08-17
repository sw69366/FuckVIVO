package com.example.fuckvivo;

import android.accessibilityservice.AccessibilityService;
import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Toast;
import androidx.annotation.RequiresApi;

import java.util.List;

public class FuckVivoService extends AccessibilityService {

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR2)
    @Override
    public void onAccessibilityEvent(AccessibilityEvent accessibilityEvent) {


        CharSequence packageName = accessibilityEvent.getPackageName();

        Log.d("xxx", packageName.toString());


        AccessibilityNodeInfo rootInActiveWindow = getRootInActiveWindow();


        {
            if (rootInActiveWindow != null) {
                List<AccessibilityNodeInfo> installBtns = rootInActiveWindow.findAccessibilityNodeInfosByViewId("com.android.packageinstaller:id/continue_button");
                if (installBtns != null && installBtns.size() > 0) {
                    if (installBtns.get(0).getText().toString().equalsIgnoreCase("继续安装")) {
                        installBtns.get(0).performAction(AccessibilityNodeInfo.ACTION_CLICK);
                        Toast.makeText(this, "干死傻逼VIVO", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        }

        {
            if (rootInActiveWindow != null) {
                List<AccessibilityNodeInfo> installBtns = rootInActiveWindow.findAccessibilityNodeInfosByViewId("com.android.packageinstaller:id/ok_button");
                if (installBtns != null && installBtns.size() > 0) {
                    if (installBtns.get(0).getText().toString().equalsIgnoreCase("安装")) {
                        installBtns.get(0).performAction(AccessibilityNodeInfo.ACTION_CLICK);
                        Toast.makeText(this, "干死傻逼VIVO", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        }

        {
            if (rootInActiveWindow != null) {
                List<AccessibilityNodeInfo> dialog_pwd = rootInActiveWindow.findAccessibilityNodeInfosByViewId("com.bbk.account:id/dialog_pwd");
                if (dialog_pwd != null && dialog_pwd.size() > 0) {
                    Log.d("xxx", "找到输入框 - 自动填入密码");
                    Bundle arguments = new Bundle();
                    arguments.putCharSequence(
                            AccessibilityNodeInfo.ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE, "你的VIVO密码");
                    dialog_pwd.get(0).performAction(AccessibilityNodeInfo.ACTION_SET_TEXT, arguments);
                    Toast.makeText(this, "干死傻逼VIVO-自动输入密码", Toast.LENGTH_SHORT).show();

                    List<AccessibilityNodeInfo> button1 = rootInActiveWindow.findAccessibilityNodeInfosByViewId("android:id/button1");

                    if (button1 != null && button1.size() > 0) {
                        button1.get(0).performAction(AccessibilityNodeInfo.ACTION_CLICK);
                    }


                } else {
                    Log.d("xxx", "没找到输入框");
                }
            }
        }


        {
            if (rootInActiveWindow != null) {
                List<AccessibilityNodeInfo> button2 = rootInActiveWindow.findAccessibilityNodeInfosByViewId("com.android.packageinstaller:id/launch_button");
                if (button2 != null && button2.size() > 0) {
                    button2.get(0).performAction(AccessibilityNodeInfo.ACTION_CLICK);
                }
            }
        }


    }

    @Override
    public void onInterrupt() {

    }
}
