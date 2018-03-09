package com.jsz.hellocordova;

import android.app.AlertDialog;
import android.content.DialogInterface;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaArgs;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONException;

/**
 * Created by jia on 2018/3/9.
 */

public class CustomDialog extends CordovaPlugin {
    @Override
    public boolean execute(String action, CordovaArgs args, CallbackContext callbackContext) throws JSONException {

        if ("show".equals(action)) {
            AlertDialog.Builder builder = new AlertDialog.Builder(cordova.getActivity());
            builder.setTitle("温馨提示");
            builder.setMessage(args.getString(0));
            builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                    callbackContext.success("点击了确定!");
                }
            });
            builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                    callbackContext.error("点击了取消");
                }
            });
            builder.create().show();
            return true;
        }

        return super.execute(action, args, callbackContext);
    }
}
